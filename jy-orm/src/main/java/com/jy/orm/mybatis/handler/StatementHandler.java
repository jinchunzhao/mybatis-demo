package com.jy.orm.mybatis.handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jy.orm.mybatis.executor.parameter.ParameterHandler;

public interface StatementHandler {

    /**
     * 前置处理获取 PreparedStatement
     * 
     * @param connection
     *            sql连接
     * @return PreparedStatement
     * @throws SQLException
     *             SQL异常
     */
    PreparedStatement prepare(Connection connection) throws SQLException;

    /**
     * 查询操作
     * 
     * @param preparedStatement
     *            preparedStatement
     * @return JDBC结果信息
     * @throws SQLException
     *             SQL异常
     */
    ResultSet query(PreparedStatement preparedStatement) throws SQLException;

    ParameterHandler getStatementHandler();
}
