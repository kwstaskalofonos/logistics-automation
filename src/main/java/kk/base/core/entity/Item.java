package kk.base.core.entity;


import jakarta.persistence.*;
import kk.base.core.enumeration.Uom;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "item")
@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Item implements Serializable {
    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_item")
    @SequenceGenerator(name = "sequence_item", sequenceName = "sequence_item", allocationSize = 1)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(name = "external_code",nullable = false)
    private String externalCode;
    @Column(name = "lot_number",nullable = false)
    private String lotNumber;
    @Column(nullable = false)
    private BigDecimal quantity;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Uom uom;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;
}
