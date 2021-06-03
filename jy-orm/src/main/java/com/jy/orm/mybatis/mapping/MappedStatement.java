package com.jy.orm.mybatis.mapping;

import com.jy.orm.mybatis.enums.SqlType;

/**
 * MappedStatement对象对应一个mapper.xml中的一个SQL节点
 * 
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-05-22 16:29
 */
public class MappedStatement {


    /**
     * 命名空间，对应着mapper接口的全路径名
     */
    private String namespace;

    /**
     * mapper.xml中sql语句 id
     */
    private String sqlId;

    /**
     * 返回值结果类型
     */
    private String resultType;

    /**
     * sql语句
     */
    private String sql;

    /**
     * SQL语句类型
     */
    private SqlType sqlCommandType;

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getSqlId() {
        return sqlId;
    }

    public void setSqlId(String sqlId) {
        this.sqlId = sqlId;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public SqlType getSqlCommandType() {
        return sqlCommandType;
    }

    public void setSqlCommandType(SqlType sqlCommandType) {
        this.sqlCommandType = sqlCommandType;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    @Override
    public String toString() {
        return "MappedStatement{" +
                "namespace='" + namespace + '\'' +
                ", sqlId='" + sqlId + '\'' +
                ", resultType='" + resultType + '\'' +
                ", sql='" + sql + '\'' +
                ", sqlCommandType=" + sqlCommandType +
                '}';
    }
}
