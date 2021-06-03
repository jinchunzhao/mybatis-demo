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
    public <T> T selectOne(String statementId,Object parameter);

    /**
     * 查询多天记录
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
    public <E> List<E> selectList(String statementId, Object parameter);

    /**
     * 更新
     *
     * @param statementId
     *        mapper类全名+方法名
     * @param parameter
     *        参数列表
     */
    public void update(String statementId, Object parameter);

    /**
     * 插入
     *
     * @param statementId
     *        mapper类全名+方法名
     * @param parameter
     *        参数列表
     */
    public void insert(String statementId, Object parameter);
}
