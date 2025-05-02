package com.yalmung.mini.commerce.model;

import com.yalmung.mini.commerce.common.codeconst.YN;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Entity(name = "Product")
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_no")
    private Long productNo;

    @Column(name="code")
    private String code;

    @Column(name="name")
    private String name;

    @NotNull
    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name="expose_yn")
    @Enumerated(EnumType.STRING)
    private YN exposeYn;

    @Column(name="del_yn")
    @Enumerated(EnumType.STRING)
    private YN delYn;




    public Product() {
        this.delYn = YN.N;
    }
}
