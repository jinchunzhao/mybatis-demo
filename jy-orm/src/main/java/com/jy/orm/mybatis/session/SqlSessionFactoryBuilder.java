package com.jy.orm.mybatis.session;

import java.io.IOException;
import java.io.InputStream;

/**
 * SqlSessionFactoryBuilder - 构建者模式
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-05-22 17:16
 */
public class SqlSessionFactoryBuilder {

    /**
     * 根据文件名称构建SqlSessionFactory
     *
     * @author jinchunzhao
     * @version 1.0
     * @date 2021-05-22 17:18
     */
    public SqlSessionFactory build(String fileName) {
        InputStream inputStream = SqlSessionFactoryBuilder.class.getClassLoader().getResourceAsStream(fileName);
        return build(inputStream);
    }

    /**
     * 根据流构建SqlSessionFactory
     * 
     * @param inputStream
     *            输入流
     * @return SqlSessionFactory对象
     */
    public SqlSessionFactory build(InputStream inputStream) {

        try {
            // 给Properties设置，设置JDBC的参数
            Configuration.PROPS.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 所有的jdbc配置信息
        return new DefaultSqlSessionFactory(new Configuration());
    }

}
