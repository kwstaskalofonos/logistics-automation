package kk.base.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "customer")
@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Customer {
    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_customer")
    @SequenceGenerator(name = "sequence_customer", sequenceName = "sequence_customer", allocationSize = 1)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private LocalDateTime creationDate;
}
