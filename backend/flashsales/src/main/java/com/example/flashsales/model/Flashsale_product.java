package com.example.flashsales.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Data
@Table(name="FLASHSALE_PRODUCTS")
public class Flashsale_product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fp_id", nullable = false)
    private Long id;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="prod_id")
    private Product fp_product;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="flashsale_id")
    private Flashsale flashsale;

    @Column(name = "prev_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal prevPrice;

    // current discounted price
    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
    @Column(name = "total_stock", nullable = false)
    private long totalStock;

    @Column(name = "available_stock", nullable = false)
    private long availableStock = totalStock;

    @Column(name = "lock_stock", nullable = false)
    private long lock_stock = 0;
}