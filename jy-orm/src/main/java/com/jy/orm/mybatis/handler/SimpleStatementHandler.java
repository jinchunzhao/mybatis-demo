package com.jy.orm.mybatis.handler;

import com.jy.orm.mybatis.executor.parameter.ParameterHandler;
import com.jy.orm.mybatis.executor.statement.PreparedStatement;
import com.jy.orm.mybatis.mapping.MappedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SimpleStatementHandler implements StatementHandler{

    private final MappedStatement mappedStatement;

    public SimpleStatementHandler(MappedStatement mappedStatement) {
        this.mappedStatement = mappedStatement;
    }

    @Override
    public PreparedStatement prepare(Connection connection) throws SQLException {
        return null;
    }

    @Override
    public ResultSet query(PreparedStatement preparedStatement) throws SQLException{
        return null;
    }

    @Override
    public ParameterHandler getStatementHandler() {
        return null;
    }
}
