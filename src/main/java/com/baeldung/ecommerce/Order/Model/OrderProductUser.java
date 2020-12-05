package com.baeldung.ecommerce.Order.Model;

import com.baeldung.ecommerce.Product.Model.Product;
import com.baeldung.ecommerce.User.Model.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class OrderProductUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;
//
    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_order",foreignKey = @ForeignKey(name = "FK_Order_Opu"))
    private Order order;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",foreignKey = @ForeignKey(name = "FK_Product_Opu"))
    private Product product;

    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user",foreignKey = @ForeignKey(name = "FK_User_Opu"))
    private User user;

    @Column
    private Long quantity;





}
