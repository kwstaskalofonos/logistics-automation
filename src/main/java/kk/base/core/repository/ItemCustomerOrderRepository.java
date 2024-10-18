package kk.base.core.repository;

import kk.base.core.entity.CustomerOrder;
import kk.base.core.entity.ItemCustomerOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemCustomerOrderRepository extends GenericRepository<ItemCustomerOrder, Long>{

    List<ItemCustomerOrder> findAllByOrder(CustomerOrder order);
}
