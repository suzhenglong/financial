package com.suzl.manager.service;

import com.suzl.api.events.ProductStatusEvent;
import com.suzl.entity.enums.ProductStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Description:管理产品状态
 * @author: zhenglongsu@163.com
 * @date: 2018.08.28 09:26
 */
@Component
public class ProductStatusManager {

    static final String MQ_DESTINATION = "VirtualTopic.PRODUCT_STATUS";
    static Logger log = LoggerFactory.getLogger(ProductStatusManager.class);


    @Autowired
    private JmsTemplate jmsTemplate;

    public void changeStatus(String id, ProductStatus status) {
        ProductStatusEvent event = new ProductStatusEvent(id, status);
        log.info("send message:{}", event);
        jmsTemplate.convertAndSend(MQ_DESTINATION, event);
    }

    //@PostConstruct
    public void init() {
        changeStatus("001", ProductStatus.IN_SELL);
    }
}
