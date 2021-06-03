package com.jy.orm.mybatis.session;


import com.jy.orm.mybatis.executor.Executor;
import com.jy.orm.mybatis.executor.SimpleExecutor;
import com.jy.orm.mybatis.mapping.MappedStatement;

import java.util.List;

/**
 * 默认SQL会话实现类
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-05-22 18:08
 */
public class DefaultSqlSession implements SqlSession{

    private final Configuration configuration;

    private final Executor executor;

    /**
     * 默认构造汉朝
     *
     * @param configuration
     *        JDBC参数信息
     */
    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
        this.executor = new SimpleExecutor(configuration);
    }

    @Override
    public <T> T selectOne(String statementId, Object parameter) {
        List<T> results = this.<T>selectList(statementId, parameter);
        if(results == null || results.size() == 0){
            return null;
        }
        if (results.size() == 1) {
            return results.get(0);
        }
        if (results.size() > 1) {
//         throw new Exception("查询多过");
//            return null;
        }
        return null;
    }

    @Override
    public <E> List<E> selectList(String statementId, Object parameter) {

        MappedStatement mappedStatement = this.configuration.getMappedStatement(statementId);

        return this.executor.<E>doQuery(mappedStatement,parameter);
    }

    @Override
    public void update(String statementId, Object parameter) {
        MappedStatement mappedStatement = this.configuration.getMappedStatement(statementId);

        this.executor.doUpdate(mappedStatement, parameter);

    }

    @Override
    public void insert(String statementId, Object parameter) {
//        MappedStatement mappedStatement = this.configuration.getMappedStatement(statementId);
//
//        this.executor.insert(mappedStatement, parameter);
    }

    /**
     * 获取mapper
     *
     * @param type
     *        class对象 JDBC接口代理，最好传接口
     * @param <T>
     *        泛型
     * @return
     *        mapper
     */
    public <T> T gerMapper(Class<T> type){
        return configuration.<T> getMapper(type,this);
    }

    /**
     * 获取jdbc信息
     *
     * @return
     *        jdbc信息
     */
    public Configuration getConfiguration() {
        return this.configuration;
    }
}
