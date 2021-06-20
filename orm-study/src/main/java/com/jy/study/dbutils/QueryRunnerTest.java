package com.jy.study.dbutils;

import com.jy.study.entity.Admin;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 使用QueryRunner实现增删改查
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-06-20 16:55
 */
public class QueryRunnerTest {


    public void insert() throws SQLException{

        QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "insert into admin(id,userName) values (?,?)";
        Object params[] = {88L,"tom"};
        runner.update(sql,params);
    }

    public void update() throws SQLException {
        QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "update  admin set userName = ? where id = ?";
        Object params[] = {"tom1",88L};
        runner.update(sql,params);
    }

    public void delete() throws SQLException {
        QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "delete from admin where identity = ?";
        Object params[] = {88L};
        runner.update(sql,params);
    }

    public void getById() throws SQLException {
        QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from admin where id = ?";
        Admin admin = runner.query(sql, new BeanHandler<>(Admin.class));
        System.out.println(admin.toString());

    }

    public void getAll() throws SQLException {
        QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from admin ";

        List<Admin> admins = runner.query(sql, new BeanListHandler<>(Admin.class));
        for (Admin admin : admins) {
            System.out.println(admin.toString());
        }
    }
    public void batchInsert() throws SQLException{

        QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "insert into admin(id,userName) values (?,?)";
        //三条sql
        Object params[][] = new Object[3][4];
        for (int i = 0; i < params.length; i++){
            params[i] = new Object[]{i+1,"study"+i};
        }
        runner.update(sql,params);
    }
}
