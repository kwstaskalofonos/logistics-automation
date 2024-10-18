package kk.base.core.service;

import kk.base.core.dto.BaseDto;
import kk.base.core.entity.Company;
import kk.base.core.paging.FiltersDto;
import kk.base.core.paging.GenericSpecs;
import kk.base.core.repository.GenericRepository;
import kk.base.core.utils.Utils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;

public abstract class GenericService<E, D, ID> {

    protected final GenericRepository<E, ID> genericRepository;
    private final GenericSpecs<E> genericSpecs;
    private final Class<D> dtoClass;
    private final Class<E> entityClass;

    protected GenericService(GenericRepository<E, ID> genericRepository, Class<D> dtoClass, Class<E> entityClass) {
        this.genericRepository = genericRepository;
        this.genericSpecs = new GenericSpecs<E>();
        this.dtoClass = dtoClass;
        this.entityClass = entityClass;
    }

    public Page<D> dynamic(FiltersDto filters, boolean filterByOwner) {
        Company company = Boolean.TRUE.equals(filterByOwner) ? CurrentUserUtils.getCompany() : null;
        Specification<E> specs = genericSpecs.areFieldsLike(filters, company);
        PageRequest pageable = PageRequest.of(filters.getPageNo(), filters.getPageSize());
        Page<E> entityPage = genericRepository.findAll(specs, pageable);

        List<D> dtoContent = entityPage.getContent().stream()
                .map(e -> Utils.mapToDto(e, dtoClass))
                .toList();
        return new PageImpl<>(dtoContent, pageable, entityPage.getTotalElements());
    }

    public BaseDto<D> create(D dto, boolean filterByOwner) throws NoSuchFieldException, IllegalAccessException {
        E entity = Utils.mapToEntity(dto, entityClass);
        if (Boolean.TRUE.equals(filterByOwner)) {
            Company company = CurrentUserUtils.getCompany();
            Field entityField = entityClass.getDeclaredField("company");
            entityField.setAccessible(true);
            entityField.set(entity, company);
        }
        Field entityField = entityClass.getSuperclass().getDeclaredField("creationDate");
        entityField.setAccessible(true);
        entityField.set(entity, LocalDateTime.now());
        entity = genericRepository.save(entity);
        return (BaseDto<D>) Utils.mapToDto(entity, dtoClass);
    }

    public BaseDto<D> getOne(Long id, boolean filterByOwner) {
        Company company = Boolean.TRUE.equals(filterByOwner) ? CurrentUserUtils.getCompany() : null;
        Specification<E> specs = genericSpecs.byId(id, company);
        List<E> results = genericRepository.findAll(specs);
        if (Utils.isEmpty(results)) return new BaseDto<D>();
        return (BaseDto<D>) Utils.mapToDto(results.get(0), dtoClass);
    }

    public List<D> getAll(boolean filterByOwner) {
        Company company = Boolean.TRUE.equals(filterByOwner) ? CurrentUserUtils.getCompany() : null;
        Specification<E> specs = genericSpecs.areFieldsLike(new FiltersDto(), company);
        List<E> results = genericRepository.findAll(specs);
        return results.stream()
                .map(e -> Utils.mapToDto(e, dtoClass))
                .toList();
    }
}
