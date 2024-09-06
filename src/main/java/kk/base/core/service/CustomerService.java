package kk.base.core.service;

import kk.base.core.dto.CustomerDto;
import kk.base.core.entity.Customer;
import kk.base.core.repository.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends GenericService<Customer, CustomerDto>{
    protected CustomerService(GenericRepository<Customer> genericRepository) {
        super(genericRepository, CustomerDto.class);
    }
}
