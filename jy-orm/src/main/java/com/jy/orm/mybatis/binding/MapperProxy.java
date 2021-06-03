package com.jy.orm.mybatis.binding;

import com.jy.orm.mybatis.mapping.MappedStatement;
import com.jy.orm.mybatis.session.DefaultSqlSession;
import com.jy.orm.mybatis.session.SqlSession;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;

/**
 * Mapper代理
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-05-22 21:06
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {

    private DefaultSqlSession defaultSqlSession;

    private final Class<T> mapperInterface;

    public MapperProxy(DefaultSqlSession defaultSqlSession, Class<T> mapperInterface) {
        this.defaultSqlSession = defaultSqlSession;
        this.mapperInterface = mapperInterface;
    }

    /**
     * 真正执行方法
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        try {
            if (Object.class.equals(method.getDeclaringClass())){
                return method.invoke(this,args);
            }
            return this.execute(method, args);

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 根据SQL指令执行对应操作
     *
     * @param method
     * @param args
     * @return
     */
    private Object execute(Method method, Object[] args) {

        String statementId = this.mapperInterface.getName() + "." + method.getName();

        MappedStatement ms = this.defaultSqlSession.getConfiguration().getMappedStatement(statementId);

        Object result = null;
        switch (ms.getSqlCommandType()){
            case SELECT:{
                Class<?> returnType = method.getReturnType();

                //如果返回的是list,应该调用查询多个结果的方法，否则只要查询单条记录
                if(Collection.class.isAssignableFrom(returnType)){
                    //ID为mapper类全名+方法名
                    result = defaultSqlSession.selectList(statementId,args);
                }else {
                    result = defaultSqlSession.selectOne(statementId,args);
                }
                break;
            }
            case UPDATE:{
                defaultSqlSession.update(statementId, args);
                break;
            }
            case INSERT:{
                defaultSqlSession.insert(statementId,args);
                break;
            }default :{
                break;
            }
        }

        return result;
    }
}
