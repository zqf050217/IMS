/*
 * Copyright 2017 BangChen Information Technology Ltd., Co.
 * Licensed under the Apache License 2.0.
 */
package com.bc.springdatajpa.dao;

import com.bc.springdatajpa.po.ImsUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * ImsUser实体类对应数据访问层接口
 *
 * @author L.X <gugia@qq.com>
 */
public interface ImsUserDao extends JpaRepository<ImsUser, Integer>, JpaSpecificationExecutor<ImsUser> {

    /**
     * 通过用户名（唯一字段）查找特定用户
     *
     * @param username 用户名
     * @return 符合查找条件的ImsUser对象
     */
    ImsUser findByUsername(String username);
}
