package com.jy.orm.mybatis.executor.parameter;


import java.sql.PreparedStatement;

public class DefaultParameterHandler implements ParameterHandler {

    private final Object parameter;

    public DefaultParameterHandler(Object parameter) {
        this.parameter = parameter;
    }

    @Override
    public void setParameters(PreparedStatement preparedStatement) {
//        preparedStatement.

    }
}
