package com.jy.orm.mybatis.executor;

import com.jy.orm.mybatis.executor.resultset.DefaultResultSetHandler;
import com.jy.orm.mybatis.executor.resultset.ResultSetHandler;
import com.jy.orm.mybatis.handler.PreparedStatement;
import com.jy.orm.mybatis.handler.SimpleStatementHandler;
import com.jy.orm.mybatis.handler.StatementHandler;
import com.jy.orm.mybatis.handler.parameter.DefaultParameterHandler;
import com.jy.orm.mybatis.handler.parameter.ParameterHandler;
import com.jy.orm.mybatis.mapping.MappedStatement;
import com.jy.orm.mybatis.session.Configuration;


import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

/**
 * Mybatis执行器实现类
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-05-22 20:10
 */
public class SimpleExecutor implements Executor{

    private Configuration configuration;

    public SimpleExecutor(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <E> List<E> doQuery(MappedStatement ms, Object parameter) {
        try {

//            //获取连接数据库
//            Connection connection = getConnect();

            Connection connection = null;
            //获取MappedStatement信息，里面有SQL信息
            MappedStatement mappedStatement = configuration.getMappedStatement(ms.getSqlId());
//
//            //实例化statementHandler对象
            StatementHandler statementHandler = new SimpleStatementHandler(mappedStatement);
//
//            //通过StatementHandler和connection获取PreparedStatement
            PreparedStatement preparedStatement = statementHandler.prepare(connection);
//
//            //实例化ParameterHandler，将sql语句中 ? 参数化
            ParameterHandler parameterHandler = new DefaultParameterHandler(parameter);
            parameterHandler.setParameters(preparedStatement);
//

//            //执行sql，得到结果集ResultSet
            ResultSet resultSet = statementHandler.query(preparedStatement);

            //实例化ResultSetHandler，通过反射将ResultSet中结果设置到目标resultType对象中
            ResultSetHandler resultSetHandler = new DefaultResultSetHandler(mappedStatement);
            return resultSetHandler.handleResultSets(resultSet);

        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void doUpdate(MappedStatement ms, Object parameter) {

    }
}
