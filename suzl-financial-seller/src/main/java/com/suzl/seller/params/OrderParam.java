package com.suzl.seller.params;

import com.suzl.seller.sign.SignText;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:下单请求参数
 * @author: zhenglongsu@163.com
 * @date: 2018.08.28 10:48
 */
public class OrderParam implements SignText {
    //渠道id
    private String chanId;

    private String chanUserId;

    private String productId;

    private BigDecimal amount;

    private String outerOrderId;

    private String memo;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createAt;

    public String getChanId() {
        return chanId;
    }

    public void setChanId(String chanId) {
        this.chanId = chanId;
    }

    public String getChanUserId() {
        return chanUserId;
    }

    public void setChanUserId(String chanUserId) {
        this.chanUserId = chanUserId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getOuterOrderId() {
        return outerOrderId;
    }

    public void setOuterOrderId(String outerOrderId) {
        this.outerOrderId = outerOrderId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "OrderParam{" +
                "chanId='" + chanId + '\'' +
                ", chanUserId='" + chanUserId + '\'' +
                ", productId='" + productId + '\'' +
                ", amount=" + amount +
                ", outerOrderId='" + outerOrderId + '\'' +
                ", memo='" + memo + '\'' +
                ", createAt=" + createAt +
                '}';
    }
}