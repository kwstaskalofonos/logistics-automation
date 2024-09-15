package kk.base.core.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "item")
@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class CustomerOrder extends BaseEntity{
    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_customer_order")
    @SequenceGenerator(name = "sequence_customer_order", sequenceName = "sequence_customer_order", allocationSize = 1)
    private Long id;
    @Column
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @ManyToOne()
    @JoinColumn(name = "company_id")
    private Company company;
    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public enum OrderStatus {
        TEMPORARY,
        IN_PROGRESS,
        COMPLETED
    }
}
