package com.jy.study.mybatis;



import com.jy.study.entity.Admin;
import com.jy.study.mybatis.mapper.AdminMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * mybatis学习
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-06-20 17:59
 */
public class MybatisStudy {

    public static void main(String[] args) throws Exception{

        //第一阶段
        //读取mybatis.xml的配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //构建SqlSessionFactory， build构造者模式  SqlSessionFactory 工厂模式，通过构造者构造出一个工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //第二阶段
        //打开SqlSession，通过工厂生产
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取mapper接口对象,  生成了接口的代理对象
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);

        //第三阶段
        //调用mapper接口对象的方法操作数据库， 执行代理对象的方法结果进行封装
        List<Admin> adminList = adminMapper.selectAll();

        //ibatis的使用方式
//        List<Admin> admins = sqlSession.selectList("com.jy.study.mybatis.mapper.AdminMapper.selectAll");
        //业务处理

        System.out.println(adminList.toString());
    }

}
