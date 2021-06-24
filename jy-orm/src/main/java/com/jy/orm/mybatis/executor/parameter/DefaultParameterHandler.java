package com.jy.orm.mybatis.executor.parameter;

import com.jy.orm.mybatis.executor.statement.PreparedStatement;

public class DefaultParameterHandler implements ParameterHandler {

    private final Object parameter;

    public DefaultParameterHandler(Object parameter) {
        this.parameter = parameter;
    }

    @Override
    public void setParameters(PreparedStatement preparedStatement) {

    }
}
