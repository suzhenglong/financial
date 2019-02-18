package com.suzl.seller.service;

import com.suzl.api.ProductRpc;
import com.suzl.api.domain.ProductRpcReq;
import com.suzl.entity.Product;
import com.suzl.entity.enums.ProductStatus;
import com.hazelcast.core.HazelcastInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description:产品缓存
 * @author: zhenglongsu@163.com
 * @date: 2018.08.27 20:27
 */
@Component
public class ProductCache {

    private static Logger log = LoggerFactory.getLogger(ProductCache.class);

    public static final String CACHE_NAME = "suzl_product";

    @Autowired
    private ProductRpc productRpc;

    @Autowired
    private HazelcastInstance hazelcastInstance;

    /**
     * 读取缓存
     *
     * @param id
     * @return
     */
    @Cacheable(cacheNames = CACHE_NAME)
    public Product readCache(String id) {
        log.info("rpc查询单个产品,请求:{}", id);
        Product result = productRpc.findOne(id);
        log.info("rpc查询单个产品,结果:{}", result);
        return result;
    }

    public List<Product> readAllCache() {
        Map map = hazelcastInstance.getMap(CACHE_NAME);
        List<Product> products = null;
        if (map.size() > 0) {
            products = new ArrayList<>();
            products.addAll(map.values());
        } else {
            products = findAll();
        }
        return products;
    }

    /**
     * 查询全部产品
     *
     * @return
     */
    public List<Product> findAll() {
        ProductRpcReq productRpcReq = new ProductRpcReq();
        List<String> status = new ArrayList<>();
        status.add(ProductStatus.IN_SELL.name());
        productRpcReq.setStatusList(status);
        log.info("rpc查询全部产品,请求:{}", productRpcReq);
        List<Product> result = productRpc.query(productRpcReq);
        log.info("rpc查询全部产品,结果:{}", result);
        return result;
    }

    @CachePut(cacheNames = CACHE_NAME, key = "#product.id")
    public Product putCache(Product product) {
        return product;
    }


    @CacheEvict(cacheNames = CACHE_NAME)
    public void removeCache(String id) {

    }
}
