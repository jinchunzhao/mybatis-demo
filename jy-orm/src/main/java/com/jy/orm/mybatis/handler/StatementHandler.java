package com.jy.orm.mybatis.handler;

import com.jy.orm.mybatis.executor.parameter.ParameterHandler;
import com.jy.orm.mybatis.executor.statement.PreparedStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface StatementHandler {

    PreparedStatement prepare(Connection connection) throws SQLException;

    ResultSet query(PreparedStatement preparedStatement) throws SQLException;

    ParameterHandler getStatementHandler();
}
