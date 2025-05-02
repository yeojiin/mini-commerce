package com.yalmung.mini.commerce.product.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Entity(name = "ProductStock")
@Table(name = "product_stock")
@Getter
public class ProductStock {

    @Id
    private Long productNo;

    @MapsId("productNo")     // 식별자 클래스의 ID와 매핑
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_no", nullable = false)
    private Product product;

    @Column(name="stock_cnt")
    private Integer stockCnt;
}
