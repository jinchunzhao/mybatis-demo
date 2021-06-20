package com.jy.study.dbutils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * commons-dbutils工具类使用
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-06-20 16:54
 */
public class JdbcUtils {

    private static HikariDataSource hikariDataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://8.129.109.34:3306/mybatis-study?characterEncoding=utf-8");
        config.setUsername("root");
        config.setPassword("root");
        //等待连接池分配连接的最大时长（毫秒），超过这个时长还没可用的连接则发生SQLException
        config.setConnectionTimeout(30000);
        //一个连接idle状态的最大时长（毫秒），超时则被释放（retired）,缺省10分钟
        config.setIdleTimeout(600000);
        //连接池中允许的最大连接数。缺省：10，推荐公式（（core_count * 2）+ eff）
        config.setMaximumPoolSize(15);

        //一个连接的生命时长（毫秒），超时而且没被使用则被释放（retired）,缺省30分钟
        config.setMaxLifetime(1800000);
        //创建数据源
        hikariDataSource = new HikariDataSource(config);
    }

    /**
     * 提供数据源
     *
     * @return 数据源
     */
    public static DataSource getDataSource() {
        return hikariDataSource;
    }

    /**
     * 获取连接
     *
     * @return 连接
     * @throws SQLException sql异常
     */
    public static Connection getConnection() throws SQLException {
        return hikariDataSource.getConnection();
    }
}
