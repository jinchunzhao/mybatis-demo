package com.jy.orm.mybatis.handler.parameter;

import com.jy.orm.mybatis.handler.PreparedStatement;

public class DefaultParameterHandler implements ParameterHandler{

    private final Object parameter;

    public DefaultParameterHandler(Object parameter) {
        this.parameter = parameter;
    }

    @Override
    public void setParameters(PreparedStatement preparedStatement) {

    }
}
