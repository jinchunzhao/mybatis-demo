package com.jy.orm.mybatis.session;

import java.util.List;

/**
 * SQL会话
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-05-22 18:06
 */
public interface SqlSession {
    /**
     * 查询一条记录
     * @param statementId
     *        mapper类全名+方法名
     * @param parameter
     *        参数信息
     * @param <T>
     *        泛型
     * @return
     *        结果信息
     */
    <T> T selectOne(String statementId,Object parameter);

    /**
     * 查询多条记录
     *
     * @param statementId
     *        mapper类全名+方法名
     * @param parameter
     *        参数列表
     * @param <E>
     *        泛型
     * @return
     *        结果信息
     */
    <E> List<E> selectList(String statementId, Object parameter);

    /**
     * 更新
     *
     * @param statementId
     *        mapper类全名+方法名
     * @param parameter
     *        参数列表
     */
    void update(String statementId, Object parameter);

    /**
     * 插入
     *
     * @param statementId
     *        mapper类全名+方法名
     * @param parameter
     *        参数列表
     */
    void insert(String statementId, Object parameter);
}
