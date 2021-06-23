package com.jy.orm.mybatis.session;

import com.jy.orm.mybatis.constants.Constant;
import com.jy.orm.mybatis.utils.XmlUtil;

import java.io.File;
import java.net.URL;

/**
 * 默认SQL会话工厂实现类
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-05-22 17:34
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory{

    /**
     * JDBC配置信息
     */
    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
        //com.jy.orm.mybatis.dao --> com/jy/orm/mybatis/dao
        loadMappersInfo(Configuration.getProperty(Constant.MAPPER_LOCATION).replaceAll("\\.","/"));
    }

    @Override
    public SqlSession openSession() {
        //SqlSession对象就是jdbc信息
        SqlSession sqlSession = new DefaultSqlSession(this.configuration);
        return sqlSession;
    }

    /**
     * 加载mapper信息
     *
     * @param dirName
     *        mapper.xml路径信息
     */
    private void loadMappersInfo(String dirName){

        URL  resources = DefaultSqlSessionFactory.class.getClassLoader().getResource(dirName);

        File mappersDir = new File(resources.getFile());

        if (!mappersDir.isDirectory()){
            return;
        }

        //显示包下所有的文件
        File[] mappers = mappersDir.listFiles();

        if (mappers == null || mappers.length == 0){
            return;
        }

        for (File file : mappers){
            //对文件继续递归
            if (file.isDirectory()) {
                loadMappersInfo(dirName + "/" + file.getName());
            }else if(file.getName().endsWith(Constant.MAPPER_FILE_SUFFIX)){
                //只对XML文件解析
                XmlUtil.readMapperXml(file,this.configuration);
            }

        }
    }
}
