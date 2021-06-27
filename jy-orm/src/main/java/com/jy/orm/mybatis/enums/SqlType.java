package com.jy.orm.mybatis.enums;

/**
 * SQL枚举类型 select、insert、update
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-05-22 16:43
 */
public enum SqlType {

    SELECT("select", "查询"), INSERT("insert", "插入"), UPDATE("update", "更新"), DELETE("delete", "删除"),
    FLUSH("flush", "冲洗"), UNKNOWN("unknown", "未知的");

    private String code;

    private String value;

    SqlType(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
