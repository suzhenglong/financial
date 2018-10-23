package com.csii.seller.controller;


import com.csii.entity.Order;
import com.csii.seller.params.OrderParam;
import com.csii.seller.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 订单相关
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    static Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    /**
     * 下单
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    public Order apply(@RequestHeader String authId, @RequestHeader String sign, @RequestBody OrderParam param) {
        log.info("申购请求:{}", param);
        Order order = new Order();
        BeanUtils.copyProperties(param, order);
        order = orderService.apply(order);
        log.info("申购结果:{}", order);
        return order;
    }
}
