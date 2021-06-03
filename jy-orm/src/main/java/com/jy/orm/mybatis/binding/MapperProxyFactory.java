package com.jy.orm.mybatis.binding;

import com.jy.orm.mybatis.session.DefaultSqlSession;
import com.jy.orm.mybatis.session.SqlSession;

import java.lang.reflect.Proxy;


/**
 * Mapper代理工厂
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-05-22 20:57
 */
public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    /**
     * 根据sqlSession创建一个代理
     *
     * @param defaultSqlSession
     *        会话
     * @return
     *        代理
     */
    public T newInstance(DefaultSqlSession defaultSqlSession){
        MapperProxy<T> mapperProxy = new MapperProxy<T>(defaultSqlSession,this.mapperInterface);
        return newInstance(mapperProxy);
    }

    /**
     * 根据mapper代理返回实例
     *
     * @param mapperProxy
     *        mapper代理
     * @return
     *        代理实例
     */
    @SuppressWarnings("unchecked")
    public T newInstance(MapperProxy<T> mapperProxy){
        //JDK动态代理
        return (T)Proxy.newProxyInstance(this.mapperInterface.getClassLoader(),new Class[]{this.mapperInterface},mapperProxy);
    }

}
