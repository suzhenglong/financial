package com.suzl.entity.enums;

/**
 * @Description:订单状态
 * @author: zhenglongsu@163.com
 * @date: 2018.08.21 15:32
 */
public enum OrderStatus {
    INIT("初始化"),
    PROCESS("处理中"),
    SUCCESS("成功"),
    FAIL("失败");

    private String desc;

    OrderStatus(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
    
}
