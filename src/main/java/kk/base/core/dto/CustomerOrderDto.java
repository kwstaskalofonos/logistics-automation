package kk.base.core.dto;

import kk.base.core.entity.Company;
import kk.base.core.entity.Customer;
import kk.base.core.entity.CustomerOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class CustomerOrderDto extends BaseDto<CustomerOrderDto>{
    private String description;
    private CustomerOrder.OrderStatus status;
}
