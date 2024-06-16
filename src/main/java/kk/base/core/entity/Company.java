package kk.base.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "company")
@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Company {
    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_company")
    @SequenceGenerator(name = "sequence_company", sequenceName = "sequence_company", allocationSize = 1)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column
    @Enumerated(EnumType.STRING)
    private CompanyType companyType;
    @Column(nullable = false)
    private LocalDateTime creationDate;

    public enum CompanyType {
        CUSTOMER,
        LOGISTICS,
        STORAGE,
        COORDINATOR
    }
}
