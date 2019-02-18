package com.suzl.manager.error;

/**
 * @Description:错误种类
 * @author: zhenglongsu@163.com
 * @date: 2018.08.22 20:46
 */
public enum ErrorEnum {

    ID_NOT_NULL("F001", "编号不可为空", false),
    REWARDRATE_RANGE("F002", "收益率范围错误", false),
    STEPAMOUNT_INT("F003", "投资步长需为整数", false),
    //...
    UNKNOWN("999", "未知异常", false);
    private String code;
    private String message;
    private boolean canRetry;

    ErrorEnum(String code, String message, boolean canRetry) {
        this.code = code;
        this.message = message;
        this.canRetry = canRetry;
    }

    public static ErrorEnum getByCode(String code) {
        for (ErrorEnum errorEnum : ErrorEnum.values()) {
            if (errorEnum.code.equals(code)) {
                return errorEnum;
            }
        }
        return UNKNOWN;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean isCanRetry() {
        return canRetry;
    }

}
