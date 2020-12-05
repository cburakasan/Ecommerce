package com.baeldung.ecommerce.Order.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_table")
@Data
@ToString(exclude = {"id"})
@EqualsAndHashCode(exclude = {"id"})
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String status;

    @Column
    private Date dateCreated;
}
