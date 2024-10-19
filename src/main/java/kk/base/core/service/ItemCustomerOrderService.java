package kk.base.core.service;

import kk.base.core.dto.ItemCustomerOrderDto;
import kk.base.core.entity.ItemCustomerOrder;
import kk.base.core.repository.ItemCustomerOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemCustomerOrderService extends GenericService<ItemCustomerOrder, ItemCustomerOrderDto,Long>{
    protected ItemCustomerOrderService(ItemCustomerOrderRepository itemCustomerOrderRepository) {
        super(itemCustomerOrderRepository, ItemCustomerOrderDto.class, ItemCustomerOrder.class);
    }


}
