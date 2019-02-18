package com.suzl.api;

import com.suzl.api.domain.ParamInf;
import com.suzl.entity.Product;
import com.googlecode.jsonrpc4j.JsonRpcService;

import java.util.List;

/**
 * @Description:产品相关的RPC服务
 * @author: zhenglongsu@163.com
 * @date: 2018.08.24 16:17
 */
@JsonRpcService("rpc/products")
public interface ProductRpc {

    /**
     * 查询多个产品
     *
     * @return
     */
    List<Product> query(ParamInf paramInf);

    /**
     * 查询单个产品
     *
     * @param id
     * @return
     */
    Product findOne(String id);

}
