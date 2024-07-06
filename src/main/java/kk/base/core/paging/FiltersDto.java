package kk.base.core.paging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class FiltersDto {
    private int pageNo;
    private int pageSize;
    private List<FieldValueDto> fields;
}
