package com.jy.orm.mybatis.session;

/**
 * 构建SqlSession的工厂、工厂模式
 * 
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-05-22 17:31
 */
public interface SqlSessionFactory {

    /**
     * 打开会话，创建SqlSession实例
     *
     * @return SqlSession
     */
    DefaultSqlSession openSession();
}
