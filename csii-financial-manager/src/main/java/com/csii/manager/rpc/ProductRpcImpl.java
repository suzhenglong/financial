package com.csii.manager.rpc;

import com.csii.api.ProductRpc;
import com.csii.api.domain.ParamInf;
import com.csii.api.domain.ProductRpcReq;
import com.csii.entity.Product;
import com.csii.manager.service.ProductService;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Description:
 * @author: zhenglongsu@163.com
 * @date: 2018.08.24 16:27
 */
@Service
@AutoJsonRpcServiceImpl
public class ProductRpcImpl implements ProductRpc {

    private static Logger log = LoggerFactory.getLogger(ProductRpcImpl.class);

    @Autowired
    private ProductService productService;

    @Override
    public List<Product> query(ParamInf paramInf) {
        log.info("查询多个产品,请求:{}", paramInf);
        Pageable pageable = new PageRequest(0, 1000, Sort.Direction.DESC, "rewardRate");
        Page<Product> result = productService.query(paramInf.getIdList(), paramInf.getMinRewardRate(), paramInf.getMaxRewardRate(), paramInf.getStatusList(), pageable);
        log.info("查询多个产品,结果:{}", result);
        return result.getContent();
    }

    @Override
    public Product findOne(String id) {
        log.info("查询产品详情,请求:{}", id);
        Product result = productService.findOne(id);
        log.info("查询产品详情,结果:{}", result);
        return result;
    }
}
