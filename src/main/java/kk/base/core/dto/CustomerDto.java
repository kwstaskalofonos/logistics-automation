package kk.base.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class CustomerDto extends BaseDto<CustomerDto> {
    private String title;
    private String address;
    private int phone;
}
