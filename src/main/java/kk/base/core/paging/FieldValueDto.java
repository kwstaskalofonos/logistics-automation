package kk.base.core.paging;

import kk.base.core.enumeration.FieldType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class FieldValueDto {
    private String fieldName;
    private FieldType type;
    private String value;
}
