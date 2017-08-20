/*
 * Copyright 2017 BangChen Information Technology Ltd., Co.
 * Licensed under the Apache License 2.0.
 */
package com.bc.springdatajpa.dao.test;

import com.bc.springdatajpa.dao.ImsUserDao;
import com.bc.springdatajpa.po.ImsUser;
import com.bc.springdatajpa.test.BaseTest;
import javax.annotation.Resource;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ImsUserDao单元测试
 *
 * @author L.X <gugia@qq.com>
 */
public class ImsUserDaoTest extends BaseTest {

    Logger logger = LoggerFactory.getLogger(ImsUserDaoTest.class);

    @Resource
    ImsUserDao imsUserDao;

    @Test
    public void test() {
        String username = "itsuki";
        String password = "123";
        String realname = "luoxu";
        byte v = 1;
        ImsUser imsUser = new ImsUser(username, password, realname, v, v, v, "default", v);
        imsUserDao.save(imsUser);
        ImsUser user = imsUserDao.findByUsername(username);
        logger.info("取得的用户是{}", imsUser);
        assertTrue("取得的用户的密码与预想不一致", password.equals(user.getPassword()));
    }
}