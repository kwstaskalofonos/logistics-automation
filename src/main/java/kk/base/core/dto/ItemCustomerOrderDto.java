package kk.base.core.dto;

import kk.base.core.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class ItemCustomerOrderDto extends BaseDto<ItemCustomerOrderDto>{
    private Item item;
    private BigDecimal quantity;
}
