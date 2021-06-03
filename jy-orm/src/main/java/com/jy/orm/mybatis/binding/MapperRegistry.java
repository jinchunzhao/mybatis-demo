package com.jy.orm.mybatis.binding;

import com.jy.orm.mybatis.session.DefaultSqlSession;
import com.jy.orm.mybatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

/**
 * MapperRegistry
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-05-22 20:43
 */
public class MapperRegistry {

    /**
     * the knownMappers
     */
    private final Map<Class<?>,MapperProxyFactory<?>> knownMappers = new HashMap<>();

    /**
     * 注册代理工厂
     *
     * @param type
     *        class对象
     * @param <T>
     *        泛型
     */
    public <T> void addMapper(Class<?> type){
        this.knownMappers.put(type, new MapperProxyFactory<>(type));
    }

    /**
     * 获取代理工厂实例
     *
     * @param type
     *        class对象
     * @param defaultSqlSession
     *        会话
     * @param <T>
     *        泛型
     * @return
     *        代理工厂实例
     */
    @SuppressWarnings("unchecked")
    public <T> T getMapper(Class<T> type, DefaultSqlSession defaultSqlSession){
        MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) this.knownMappers.get(type);

        return mapperProxyFactory.newInstance(defaultSqlSession);
    }

}
