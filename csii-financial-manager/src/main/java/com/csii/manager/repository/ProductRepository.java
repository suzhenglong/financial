package com.csii.manager.repository;

import com.csii.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * @Description:产品管理
 * @author: zhenglongsu@163.com
 * @date: 2018.08.21 17:02
 */
public interface ProductRepository extends CrudRepository<Product,String>, JpaRepository<Product, String>, JpaSpecificationExecutor<Product> {
}
