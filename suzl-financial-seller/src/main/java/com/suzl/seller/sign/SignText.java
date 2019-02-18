package com.suzl.seller.sign;

import com.suzl.util.JsonUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @Description:签名明文
 * @author: zhenglongsu@163.com
 * @date: 2018.08.28 10:49
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public interface SignText {
    default String toText() {
        return JsonUtil.toJson(this);
    }
}