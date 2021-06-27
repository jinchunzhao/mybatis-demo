package com.jy.orm.mybatis.session;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.jy.orm.mybatis.exceptions.JyException;
import com.jy.orm.mybatis.executor.Executor;
import com.jy.orm.mybatis.executor.SimpleExecutor;
import com.jy.orm.mybatis.mapping.MappedStatement;

/**
 * 默认SQL会话实现类
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-05-22 18:08
 */
public class DefaultSqlSession implements SqlSession {

    /**
     * JDBC信息
     */
    private final Configuration configuration;

    /**
     * 执行器，JDBC的执行进行了封装
     */
    private final Executor executor;

    /**
     * 默认构造函数
     *
     * @param configuration
     *            JDBC参数信息
     */
    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
        this.executor = new SimpleExecutor(configuration);
    }

    @Override
    public <T> T selectOne(String statementId, Object parameter) {
        List<T> results = this.<T>selectList(statementId, parameter);
        if (CollectionUtils.isEmpty(results)) {
            return null;
        }
        if (results.size() == 1) {
            return results.get(0);
        }
        if (results.size() > 1) {
            throw new JyException(
                "Expected one result (or null) to be returned by selectOne(), but found: " + results.size());
        }
        return null;
    }

    @Override
    public <E> List<E> selectList(String statementId, Object parameter) {

        MappedStatement mappedStatement = this.configuration.getMappedStatement(statementId);

        return this.executor.<E>doQuery(mappedStatement, parameter);
    }

    @Override
    public void update(String statementId, Object parameter) {
        MappedStatement mappedStatement = this.configuration.getMappedStatement(statementId);

        this.executor.doUpdate(mappedStatement, parameter);

    }

    @Override
    public void insert(String statementId, Object parameter) {
        // MappedStatement mappedStatement = this.configuration.getMappedStatement(statementId);
        //
        // this.executor.insert(mappedStatement, parameter);
    }

    /**
     * 获取mapper
     *
     * @param type
     *            class对象 JDBC接口代理，最好传接口
     * @param <T>
     *            泛型
     * @return mapper
     */
    public <T> T gerMapper(Class<T> type) {
        return configuration.<T>getMapper(type, this);
    }

    /**
     * 获取jdbc信息
     *
     * @return jdbc信息
     */
    public Configuration getConfiguration() {
        return this.configuration;
    }
}
