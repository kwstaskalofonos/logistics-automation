package kk.base.core.service;

import kk.base.core.paging.FiltersDto;
import kk.base.core.paging.GenericSpecs;
import kk.base.core.repository.GenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

public abstract class GenericService<E> {

    private final GenericRepository<E> genericRepository;
    private final GenericSpecs<E> genericSpecs;

    protected GenericService(GenericRepository<E> genericRepository) {
        this.genericRepository = genericRepository;
        this.genericSpecs = new GenericSpecs<E>();
    }

    public Page<E> dynamic(FiltersDto filters) {
        Specification<E> specs = genericSpecs.areFieldsLike(filters);
        PageRequest pageable = PageRequest.of(filters.getPageNo(), filters.getPageSize());
        return genericRepository.findAll(specs,pageable);
    }
}
