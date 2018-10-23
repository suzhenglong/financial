package com.csii.entity.enums;

/**
 * @Description:订单类型
 * @author: zhenglongsu@163.com
 * @date: 2018.08.21 15:33
 */
public enum OrderType {
    APPLY("申购"),
    REDEEM("赎回");

    private String desc;

    OrderType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
