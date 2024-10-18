package kk.base.core.repository;

import kk.base.core.entity.Company;
import kk.base.core.entity.CustomerOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerOrderRepository extends GenericRepository<CustomerOrder, Long>{

    @Query("select o from CustomerOrder o where o.company=:company and o.status='TEMPORARY'")
    Optional<CustomerOrder> findCurrentOrder(Company company);
}
