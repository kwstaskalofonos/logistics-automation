package kk.base.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "item_customer_order")
@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class ItemCustomerOrder extends BaseEntity{
    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_item_order")
    @SequenceGenerator(name = "sequence_item_order", sequenceName = "sequence_item_order", allocationSize = 1)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "order_id")
    private CustomerOrder order;
    @ManyToOne()
    @JoinColumn(name = "item_id")
    private Item item;
    @Column(nullable = false)
    private BigDecimal quantity;

}
