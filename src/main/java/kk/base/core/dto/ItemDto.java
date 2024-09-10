package kk.base.core.dto;

import kk.base.core.enumeration.Uom;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class ItemDto extends BaseDto<ItemDto> {
    private String title;
    private Uom uom;
    private String externalCode;
    private String lotNumber;
    private BigDecimal quantity;

    @Override
    public String toString() {
        return "ItemDto{" +
                ", title='" + title + '\'' +
                ", uom=" + uom +
                ", externalCode='" + externalCode + '\'' +
                ", lotNumber='" + lotNumber + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
