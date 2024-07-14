package kk.base.core.dto;

import kk.base.core.enumeration.Uom;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class ItemDto {
    private Long id;
    private String title;
    private Uom uom;
    private String externalCode;
}
