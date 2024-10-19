package kk.base.core.service;

import kk.base.core.dto.BaseDto;
import kk.base.core.dto.CustomerOrderDto;
import kk.base.core.dto.FullCustomerOrderDto;
import kk.base.core.dto.ItemCustomerOrderDto;
import kk.base.core.entity.CustomerOrder;
import kk.base.core.entity.WebUser;
import kk.base.core.repository.CustomerOrderRepository;
import kk.base.core.repository.ItemCustomerOrderRepository;
import kk.base.core.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderService extends GenericService<CustomerOrder, CustomerOrderDto, Long>{

    private final CustomerOrderRepository customerOrderRepository;
    private final ItemCustomerOrderRepository itemCustomerOrderRepository;

    protected CustomerOrderService(CustomerOrderRepository customerOrderRepository, ItemCustomerOrderRepository itemCustomerOrderRepository) {
        super(customerOrderRepository, CustomerOrderDto.class, CustomerOrder.class);
        this.customerOrderRepository = customerOrderRepository;
        this.itemCustomerOrderRepository = itemCustomerOrderRepository;
    }

    @Override
    public BaseDto<CustomerOrderDto> create(CustomerOrderDto dto, boolean filterByOwner) throws NoSuchFieldException, IllegalAccessException {
        dto = new CustomerOrderDto();

        return super.create(dto, filterByOwner);
    }

    public FullCustomerOrderDto getCurrentOrder(WebUser user) {
        CustomerOrder order = customerOrderRepository.findCurrentOrder(user.getCompany())
                .orElse(null);
        if(Utils.isEmpty(order)) return FullCustomerOrderDto.builder().build();
        List<ItemCustomerOrderDto> items = itemCustomerOrderRepository.findAllByOrder(order)
                .stream().map(item -> Utils.mapToDto(item, ItemCustomerOrderDto.class))
                .toList();
        return FullCustomerOrderDto.builder()
                .order(Utils.mapToDto(order, CustomerOrderDto.class))
                .items(items)
                .build();
    }
}
