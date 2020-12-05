package com.baeldung.ecommerce.comment.Model;

import com.baeldung.ecommerce.Product.Model.Product;
import com.baeldung.ecommerce.User.Model.User;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Data
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product", foreignKey = @ForeignKey(name = "FK_Comment_Product"))
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", foreignKey = @ForeignKey(name = "FK_Comment_User"))
    private User user;

    @Column
    private String yorum;
}



