package com.jy;

import java.util.List;

import com.jy.orm.dao.AdminMapper;
import com.jy.orm.entity.Admin;
import com.jy.orm.mybatis.session.DefaultSqlSession;
import com.jy.orm.mybatis.session.SqlSessionFactory;
import com.jy.orm.mybatis.session.SqlSessionFactoryBuilder;

public class TestJyOrm {

    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build("conf.properties");

        DefaultSqlSession sqlSession = sqlSessionFactory.openSession();

        AdminMapper adminMapper = sqlSession.gerMapper(AdminMapper.class);

        List<Admin> admins = adminMapper.selectAll();

        System.out.println(admins.toString());
    }

}
