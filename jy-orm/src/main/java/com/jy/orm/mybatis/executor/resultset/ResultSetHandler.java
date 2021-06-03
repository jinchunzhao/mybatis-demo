package com.jy.orm.mybatis.executor.resultset;

import java.sql.ResultSet;
import java.util.List;

/**
 * 结果集处理
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-05-22 20:22
 */
public interface ResultSetHandler {

    /**
     * 处理查询结果
     *
     * <p>
     *     通过反射设置到返回的实体类
     * </p>
     *
     * @param resultSet
     *        查询结果
     * @param <E>
     *        泛型
     * @return
     *        结果数据
     */
    <E> List<E> handleResultSets(ResultSet resultSet);
}
