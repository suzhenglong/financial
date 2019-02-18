package com.suzl.manager.controller;

import com.suzl.entity.Product;
import com.suzl.manager.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:产品
 * @author: zhenglongsu@163.com
 * @date: 2018.08.21 17:01
 */
@RestController
@RequestMapping("products")
public class ProductController {

    private static Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductService productService;

    /**
     * 创建产品
     *
     * @param product
     * @return
     */
    @ApiOperation(value = "创建产品",notes = "根据对应业务规则添加相应的产品")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Product addProduct(@RequestBody Product product) {
        log.info("创建产品,参数:{}", product);
        Product result = productService.addProduct(product);
        log.info("创建产品,结果:{}", result);
        return result;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product findOne(@PathVariable String id) {
        Assert.notNull(id, "需要产品编号参数");
        log.info("查询单个产品,编号id={}", id);

        Product product = productService.findOne(id);
        log.info("查询单个产品,结果:{}", product);
        return product;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Page<Product> query(String ids, BigDecimal minRewardRate, BigDecimal maxRewardRate, String status,
                               @RequestParam(defaultValue = "0") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        log.info("查询产品,ids={},minRewardRate={},maxRewardRate={},status,pageNum={},pageSize={}");
        List<String> idList = null, statusList = null;
        if (!StringUtils.isEmpty(ids)) {
            idList = Arrays.asList(ids.split(","));
        }
        if (!StringUtils.isEmpty(status)) {
            statusList = Arrays.asList(status.split(","));
        }

        Pageable pageable = new PageRequest(pageNum, pageSize);
        Page<Product> page = productService.query(idList, minRewardRate, maxRewardRate, statusList, pageable);
        log.info("查询产品,结果={}", page);
        return page;
    }

}
