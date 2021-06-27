package com.jy.orm.mybatis.executor.resultset;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jy.orm.mybatis.mapping.MappedStatement;

/**
 * 结果集处理实现类
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-05-22 20:24
 */
public class DefaultResultSetHandler implements ResultSetHandler {

    private MappedStatement mappedStatement;

    public DefaultResultSetHandler(MappedStatement mappedStatement) {
        this.mappedStatement = mappedStatement;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <E> List<E> handleResultSets(ResultSet resultSet) {
        try {

            List<E> result = new ArrayList<>();

            if (resultSet == null) {
                return null;
            }
            while (resultSet.next()) {
                // 通过反射实例化返回类
                Class<?> entityClass = Class.forName(mappedStatement.getResultType());

                E entity = (E) entityClass.newInstance();
                Field[] declaredFields = entityClass.getDeclaredFields();

                for (Field field : declaredFields) {

                    // 对成员变量赋值
                    field.setAccessible(true);
                    Class<?> fieldType = field.getType();
                    // 暂时实现String 与 int 的转换
                    if (String.class.equals(fieldType)) {
                        field.set(entity, resultSet.getString(field.getName()));
                    } else if (int.class.equals(fieldType) || Integer.class.equals(fieldType)) {
                        field.set(entity, resultSet.getInt(field.getName()));
                    } else {
                        // 其他类型后期在添加，暂时直接设置
                        field.set(entity, resultSet.getObject(field.getName()));
                    }
                }
                result.add(entity);
            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
