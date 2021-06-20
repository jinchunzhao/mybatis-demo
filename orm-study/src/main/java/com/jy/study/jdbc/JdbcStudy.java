package com.jy.study.jdbc;


import com.jy.study.entity.Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

/**
 * JDBC操作数据库
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-06-20 16:33
 */
public class JdbcStudy {

    public static void main(String[] args) {
        Connection connection = null;

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //加载mysql数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://8.129.109.34:3306/mybatis-study?characterEncoding=utf-8", "root", "root");
            //sql语句
            String sql = "select * from sys_admin where userName = ?";
            //预处理statement
            preparedStatement = connection.prepareStatement(sql);

            //设置参数，针对sql中占位符中
            preparedStatement.setString(1, "tom");
            //发起查询
            resultSet = preparedStatement.executeQuery();

            Admin admin = new Admin();
            //遍历查询结果集
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String userName = resultSet.getString("userName");

                //封装结果集
                admin.setId(id);
                admin.setUserName(userName);
            }

            System.out.printf("结果集：" + admin.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //释放资源
                if (Objects.nonNull(resultSet)) {
                    resultSet.close();
                }

                if (Objects.nonNull(preparedStatement)) {
                    preparedStatement.close();
                }

                if (Objects.nonNull(connection)) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
