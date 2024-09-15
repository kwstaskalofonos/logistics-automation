package kk.base.core.repository;

import kk.base.core.entity.CustomerOrder;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderRepository extends GenericRepository<CustomerOrder, Long>{
}
