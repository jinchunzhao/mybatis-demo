package com.jy.orm.mybatis.executor;

import com.jy.orm.mybatis.constants.Constant;
import com.jy.orm.mybatis.executor.resultset.DefaultResultSetHandler;
import com.jy.orm.mybatis.executor.resultset.ResultSetHandler;
import com.jy.orm.mybatis.handler.SimpleStatementHandler;
import com.jy.orm.mybatis.handler.StatementHandler;
import com.jy.orm.mybatis.executor.parameter.DefaultParameterHandler;
import com.jy.orm.mybatis.executor.parameter.ParameterHandler;
import com.jy.orm.mybatis.mapping.MappedStatement;
import com.jy.orm.mybatis.session.Configuration;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Mybatis执行器实现类
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-05-22 20:10
 */
public class SimpleExecutor implements Executor {

    private Configuration configuration;

    public SimpleExecutor(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <E> List<E> doQuery(MappedStatement ms, Object parameter) {
        try {

//            //获取连接数据库
            Connection connection = getConnection();

//            Connection connection = null;
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

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void doUpdate(MappedStatement ms, Object parameter) {

    }


    /**
     * 获取数据库连接
     *
     * @return 数据库连接信息
     * @throws SQLException sql错误
     */
    public Connection getConnection() throws SQLException {
        String url = Configuration.getProperty(Constant.DB_URL_CONF);

        String username = Configuration.getProperty(Constant.DB_USERNAME_CONF);

        String password = Configuration.getProperty(Constant.DB_PASSWORD);

        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    //每次别人获取连接的时候，都需要加载该类。但是一个类只需要加载一次就够了。静态代码块只需要执行一次。
    static {
        try {
            String driver = Configuration.getProperty(Constant.DB_DRIVER_CONF);

            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
