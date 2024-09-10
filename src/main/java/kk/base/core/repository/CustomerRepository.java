package kk.base.core.repository;

import kk.base.core.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends GenericRepository<Customer, Long> {
}
