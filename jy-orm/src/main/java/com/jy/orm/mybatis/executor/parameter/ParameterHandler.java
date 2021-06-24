package com.jy.orm.mybatis.executor.parameter;

import com.jy.orm.mybatis.executor.statement.PreparedStatement;

public interface ParameterHandler {

    void setParameters(PreparedStatement preparedStatement);
}
