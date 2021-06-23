package com.jy.orm.mybatis.session;

import com.jy.orm.mybatis.binding.MapperRegistry;
import com.jy.orm.mybatis.mapping.MappedStatement;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


/**
 * mybatis核心配置类
 *
 * <p>
 *     类名对应着mybatis-config.xml 的最外层根节点 <configuration></configuration>
 * </p>
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-05-22 15:28
 */
public class Configuration {

    /**
     * 配置信息
     * 对应着mybatis-config.xml文件的环境变量配置  <environments></environments>
     */
    public static Properties PROPS = new Properties();

    /**
     * MappedStatement信息
     * mapper.xml 中的方法信息
     * key：namespace+sqlId
     */
    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();

    /**
     * 代理
     */
    protected final  MapperRegistry mapperRegistry = new MapperRegistry();

    /**
     * 根据key获取节点信息
     * @param key
     *        节点名称
     * @return 节点value
     */
    public static String getProperty(String key){
        return PROPS.getProperty(key);
    }

    /**
     * 添加mapper接口与mapper.xml信息
     *
     * @param key
     *        namespace+sqlId
     * @param mappedStatement
     *        mapper.xml信息
     */
    public void addMappedStatement(String key, MappedStatement mappedStatement){
        this.mappedStatements.put(key, mappedStatement);
    }

    /**
     * 根据
     * namespace+sqlId 查询对应的mappedStatement信息
     * @param key
     *        namespace+sqlId
     * @return mappedStatement信息
     */
    public MappedStatement getMappedStatement(String key) {
        return this.mappedStatements.get(key);
    }

    /**
     * 添加代理工厂对象
     *
     * @param type
     * @param <T>
     */
    public <T> void addMapper(Class<T> type){
        this.mapperRegistry.addMapper(type);
    }

    public <T> T getMapper(Class<T> type,DefaultSqlSession defaultSqlSession){
        return this.mapperRegistry.getMapper(type, defaultSqlSession);
    }

}
