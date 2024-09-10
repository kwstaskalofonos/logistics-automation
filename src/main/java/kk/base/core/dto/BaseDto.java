package kk.base.core.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Getter
@AllArgsConstructor
@MappedSuperclass
public class BaseDto<D> {
    protected Long id;
}
