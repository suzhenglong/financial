package com.csii.seller.repository;

import com.csii.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Description:产品管理
 * @author: zhenglongsu@163.com
 * @date: 2018.08.21 17:02
 */
public interface OrderRepository extends JpaRepository<Order, String>, JpaSpecificationExecutor<Order> {
}
