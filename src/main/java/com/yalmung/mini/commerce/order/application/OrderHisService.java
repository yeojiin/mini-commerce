package com.yalmung.mini.commerce.order.application;

import com.yalmung.mini.commerce.order.model.OrderHisRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class OrderHisService {
    private OrderHisRepository orderHisRepository;

    public OrderHisService(OrderHisRepository orderHisRepository) {
        this.orderHisRepository = orderHisRepository;
    }
}
