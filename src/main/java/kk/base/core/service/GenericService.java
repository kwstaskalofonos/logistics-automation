package kk.base.core.service;

import kk.base.core.entity.Company;
import kk.base.core.paging.FiltersDto;
import kk.base.core.paging.GenericSpecs;
import kk.base.core.repository.GenericRepository;
import kk.base.core.utils.Utils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.stream.Collectors;

public abstract class GenericService<E,D> {

    private final GenericRepository<E> genericRepository;
    private final GenericSpecs<E> genericSpecs;
    private final Class<D> dtoClass;

    protected GenericService(GenericRepository<E> genericRepository, Class<D> dtoClass) {
        this.genericRepository = genericRepository;
        this.genericSpecs = new GenericSpecs<E>();
        this.dtoClass = dtoClass;
    }

    public Page<D> dynamic(FiltersDto filters) {
        Company company = CurrentUserUtils.getCompany();
        Specification<E> specs = genericSpecs.areFieldsLike(filters,company);
        PageRequest pageable = PageRequest.of(filters.getPageNo(), filters.getPageSize());
        Page<E> entityPage = genericRepository.findAll(specs,pageable);

        List<D> dtoContent = entityPage.getContent().stream()
                .map(e -> Utils.mapToDto(e,dtoClass))
                .toList();
        return new PageImpl<>(dtoContent,pageable, entityPage.getTotalElements());
    }

}
