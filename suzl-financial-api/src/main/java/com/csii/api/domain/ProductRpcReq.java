package com.suzl.api.domain;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description:产品相关rpc请求对象
 * @author: zhenglongsu@163.com
 * @date: 2018.08.24 16:20
 */
public class ProductRpcReq implements ParamInf {

    private List<String> idList;
    private BigDecimal minRewardRate;

    private BigDecimal maxRewardRate;
    private List<String> statusList;

    @Override
    public List<String> getIdList() {
        return idList;
    }

    public void setIdList(List<String> idList) {
        this.idList = idList;
    }

    @Override
    public BigDecimal getMinRewardRate() {
        return minRewardRate;
    }

    public void setMinRewardRate(BigDecimal minRewardRate) {
        this.minRewardRate = minRewardRate;
    }

    @Override
    public BigDecimal getMaxRewardRate() {
        return maxRewardRate;
    }

    public void setMaxRewardRate(BigDecimal maxRewardRate) {
        this.maxRewardRate = maxRewardRate;
    }

    @Override
    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }

    @Override
    public String toString() {
        return "ProductRpcReq{" +
                "idList=" + idList +
                ", minRewardRate=" + minRewardRate +
                ", maxRewardRate=" + maxRewardRate +
                ", statusList=" + statusList +
                '}';
    }
}

