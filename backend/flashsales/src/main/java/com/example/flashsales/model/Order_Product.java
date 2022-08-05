package com.example.flashsales.model;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="ORDER_PRODUCTS")
public class Order_Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "op_id", nullable = false)
    private Long id;

    @Column(name = "qty", nullable = false)
    private int qty;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="prod_id")
    private Product op_product;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="order_id")
    private Order order;
}
