package com.yalmung.mini.commerce.order.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class OrderHisService {
    private OrderHisService orderHisService;

    public OrderHisService(OrderHisService orderHisService) {
        this.orderHisService = orderHisService;
    }
}
