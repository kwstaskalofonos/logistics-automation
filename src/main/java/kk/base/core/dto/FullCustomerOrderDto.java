package kk.base.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class FullCustomerOrderDto{
    private CustomerOrderDto order;
    private List<ItemCustomerOrderDto> items;
}
