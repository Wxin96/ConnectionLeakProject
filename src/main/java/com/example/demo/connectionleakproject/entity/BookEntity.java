package com.example.demo.connectionleakproject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author wangxin
 */
@Data
@Entity
@Table(name = "Book")
public class BookEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private String bookName;

    @Column
    private BigDecimal bookPrice;


}
