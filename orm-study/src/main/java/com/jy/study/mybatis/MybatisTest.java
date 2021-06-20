package com.jy.study.mybatis;



import com.jy.study.entity.Admin;
import com.jy.study.mybatis.mapper.AdminMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    public static void main(String[] args) throws Exception{

        //读取mybatis.xml的配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //打开SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取mapper接口对象
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        //调用mapper接口对象的方法操作数据库
        List<Admin> adminList = adminMapper.selectAll();
        //业务处理

        System.out.println(adminList.toString());
    }

}
