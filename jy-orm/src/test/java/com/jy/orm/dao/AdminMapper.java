package com.jy.orm.dao;


import com.jy.orm.entity.Admin;

import java.util.List;

/**
 * 管理员 -- dao
 *
 * @author jcz
 * @date 2018-08-17
 */
public interface AdminMapper {

    List<Admin> selectAll();
}
