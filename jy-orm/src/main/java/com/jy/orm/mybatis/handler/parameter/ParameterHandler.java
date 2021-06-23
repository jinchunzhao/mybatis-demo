package com.jy.orm.mybatis.handler.parameter;

import com.jy.orm.mybatis.handler.PreparedStatement;

public interface ParameterHandler {

    void setParameters(PreparedStatement preparedStatement);
}
