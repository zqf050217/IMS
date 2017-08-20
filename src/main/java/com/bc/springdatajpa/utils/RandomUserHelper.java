/*
 * Copyright 2017 BangChen Information Technology Ltd., Co.
 * Licensed under the Apache License 2.0.
 */
package com.bc.springdatajpa.utils;

import com.bc.springdatajpa.po.ImsUser;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 随机用户（ImsUser）批量生成器
 *
 * @author L.X <gugia@qq.com>
 */
@Service
public class RandomUserHelper {

    RandomNameHelper helper = new RandomNameHelper();

    public List<ImsUser> generateUserList(int size) {
        List<ImsUser> list = new ArrayList<>();
        for (int i = 1; i < size + 1; i++) {
            String username = "user" + String.valueOf(i);
            String password = "123";
            int up = 5, low = 1;
            byte v = 1;
            ImsUser imsUser = new ImsUser(username, password, helper.getRandomName(true), v, helper.rand(low, up), v, "default", v);
            list.add(imsUser);
        }
        return list;
    }
}
