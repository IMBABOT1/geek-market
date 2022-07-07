package com.geekbrains.geek.market.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_quantity")
    private int quantity;

    @Column(name = "product_price")
    private int price;

    @Column(name = "client_name")
    private String clientName;


    @Column(name = "client_phone")
    private String client_phone;

    @Column(name = "client_address")
    private String client_address;

}
