package com.csii.api.events;

import com.csii.entity.enums.ProductStatus;

import java.io.Serializable;

/**
 * @Description:产品状态事件
 * @author: zhenglongsu@163.com
 * @date: 2018.08.28 09:24
 */
public class ProductStatusEvent implements Serializable {

    private String id;
    private ProductStatus status;

    public ProductStatusEvent(String id, ProductStatus status) {
        this.id = id;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProductStatusEvent{" +
                "id='" + id + '\'' +
                ", status=" + status +
                '}';
    }
}
