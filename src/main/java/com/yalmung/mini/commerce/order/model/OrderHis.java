package com.yalmung.mini.commerce.order.model;


import com.yalmung.mini.commerce.common.codeconst.ORDER_STATUS;
import com.yalmung.mini.commerce.common.codeconst.model.BaseEntity;
import com.yalmung.mini.commerce.product.model.Product;
import com.yalmung.mini.commerce.user.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Entity(name = "OrderHis")
@Table(name = "order_his")
@Getter
public class OrderHis extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderNo;

    @NotNull
    @ManyToOne(targetEntity = Product.class, optional = false)
    @JoinColumn(name="product_no", nullable = false)
    private Product product;

    @NotNull
    @ManyToOne(targetEntity = User.class, optional = false)
    @JoinColumn(name="user_no", nullable = false)
    private User user;

    @NotNull
    @Column(name="product_cnt")
    private Integer productCnt;

    @Column(name="tot_price")
    private Long totalPrice;

    @Column(name="order_status")
    @Enumerated(EnumType.STRING)
    private ORDER_STATUS orderStatus;
}
