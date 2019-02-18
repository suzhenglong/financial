package com.suzl.seller.service;

import com.suzl.api.ProductRpc;
import com.suzl.api.events.ProductStatusEvent;
import com.suzl.entity.Product;
import com.suzl.entity.enums.ProductStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:产品服务
 * @author: zhenglongsu@163.com
 * @date: 2018.08.24 16:47
 */
@Service
public class ProductRpcService implements ApplicationListener<ContextRefreshedEvent> {

    private static Logger log = LoggerFactory.getLogger(ProductRpcService.class);
    private static final String MQ_DESTINATION = "Consumer.cache.VirtualTopic.PRODUCT_STATUS";
    @Autowired
    private ProductRpc productRpc;

    @Autowired
    private ProductCache productCache;

    /**
     * 查询全部产品
     *
     * @return
     */
    public List<Product> findAll() {
        return productCache.readAllCache();
    }

    /**
     * 查询单个产品
     *
     * @param id
     * @return
     */
    public Product findOne(String id) {

        Product product = productCache.readCache(id);
        if (product == null) {
            productCache.removeCache(id);
        }
        return product;

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        List<Product> products = findAll();
        products.forEach(product -> {
            productCache.putCache(product);
        });
    }

    //    @JmsListener(destination = MQ_DESTINATION)
    void updateCache(ProductStatusEvent event) {
        log.info("receive event:{}", event);
        productCache.removeCache(event.getId());
        if (ProductStatus.IN_SELL.equals(event.getStatus())) {
            productCache.readCache(event.getId());
        }
    }

    // @PostConstruct
    // public void testFindAll() {
    //     findAll();
    //     System.out.println("===========================************====================================");
    //     findOne("T004");
    // }

}
