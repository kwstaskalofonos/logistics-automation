package kk.base.core.service;

import kk.base.core.dto.CustomerDto;
import kk.base.core.entity.Customer;
import kk.base.core.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends GenericService<Customer, CustomerDto, Long>{
    protected CustomerService(CustomerRepository customerRepository) {
        super(customerRepository, CustomerDto.class, Customer.class);
    }
}
