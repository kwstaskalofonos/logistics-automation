package kk.base.core.service;

import kk.base.core.dto.CustomerOrderDto;
import kk.base.core.entity.CustomerOrder;
import kk.base.core.repository.CustomerOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderService extends GenericService<CustomerOrder, CustomerOrderDto, Long>{
    protected CustomerOrderService(CustomerOrderRepository customerOrderRepository) {
        super(customerOrderRepository, CustomerOrderDto.class, CustomerOrder.class);
    }
}
