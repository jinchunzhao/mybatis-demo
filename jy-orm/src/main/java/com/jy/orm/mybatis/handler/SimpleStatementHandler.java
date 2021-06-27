package com.jy.orm.mybatis.handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jy.orm.mybatis.executor.parameter.ParameterHandler;
import com.jy.orm.mybatis.mapping.MappedStatement;

public class SimpleStatementHandler implements StatementHandler {

    private final MappedStatement mappedStatement;

    public SimpleStatementHandler(MappedStatement mappedStatement) {
        this.mappedStatement = mappedStatement;
    }

    @Override
    public PreparedStatement prepare(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = this.instantiateStatement(connection);

        return preparedStatement;
    }

    @Override
    public ResultSet query(PreparedStatement ps) throws SQLException {
        // ps.execute();
        ResultSet resultSet = ps.executeQuery();
        return resultSet;
    }

    @Override
    public ParameterHandler getStatementHandler() {
        return null;
    }

    /**
     * 初始化Statement
     *
     * @param connection
     *            连接
     * @return Statement
     * @throws SQLException
     *             任何异常
     */
    protected PreparedStatement instantiateStatement(Connection connection) throws SQLException {
        return connection.prepareStatement(mappedStatement.getSql());
    }

    /**
     * 关闭 statement
     * 
     * @param statement
     *            PreparedStatement
     */
    protected void closeStatement(PreparedStatement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }
}
