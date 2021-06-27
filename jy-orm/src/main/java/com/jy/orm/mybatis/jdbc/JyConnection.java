package com.jy.orm.mybatis.jdbc;

import com.jy.orm.mybatis.constants.Constant;
import com.jy.orm.mybatis.session.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

/**
 * jdbc连接
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-06-27 15:13
 */
public class JyConnection {

    /**
     * 数据库连接
     */
    static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>();

    private JyConnection() {

    }

    /**
     * 每次别人获取连接的时候，都需要加载该类。但是一个类只需要加载一次就够了。静态代码块只需要执行一次。
     */
    static {
        try {
            String driver = Configuration.getProperty(Constant.DB_DRIVER_CONF);

            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     *
     * @return 数据库连接信息
     * @throws SQLException
     *             sql错误
     */
    public static Connection getConnection() throws SQLException {

        if (Objects.isNull(connectionThreadLocal)){
            String url = Configuration.getProperty(Constant.DB_URL_CONF);

            String username = Configuration.getProperty(Constant.DB_USERNAME_CONF);

            String password = Configuration.getProperty(Constant.DB_PASSWORD);

            Connection connection = DriverManager.getConnection(url, username, password);

            connectionThreadLocal.set(connection);
        }
        return connectionThreadLocal.get();
    }
}
