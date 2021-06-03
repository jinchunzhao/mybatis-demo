package com.jy.study.mybatis.mapper;


import com.jy.study.mybatis.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 管理员 -- dao
 *
 * @author jcz
 * @date 2018-08-17
 */
@Mapper
public interface AdminMapper {

    List<Admin> selectAll();
}
