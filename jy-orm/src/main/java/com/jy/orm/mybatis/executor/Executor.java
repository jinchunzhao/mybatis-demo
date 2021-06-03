package com.jy.orm.mybatis.executor;

import com.jy.orm.mybatis.mapping.MappedStatement;

import java.util.List;

/**
 * mybatis执行器
 * 
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-05-22 20:07
 */
public interface Executor {

    /**
     * 查询数据列表
     *
     * @param ms
     *        MappedStatement
     * @param parameter
     *        参数列表
     * @param <E>
     *        泛型
     * @return
     *        结果数据
     */
    <E> List<E> doQuery(MappedStatement ms,Object parameter);

    /**
     * 更新操作
     *
     * @param ms
     *        MappedStatement
     * @param parameter
     *        参数列表
     */
    void doUpdate(MappedStatement ms,Object parameter);
}
