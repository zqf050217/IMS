/*
 * Copyright 2017 BangChen Information Technology Ltd., Co.
 * Licensed under the Apache License 2.0.
 */
package com.bc.springdatajpa.controller;

import com.bc.springdatajpa.po.ImsUser;
import com.bc.springdatajpa.service.ImsUserService;
import com.bc.springdatajpa.utils.RandomUserHelper;
import javax.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ImsUser用户控制器
 *
 * @author L.X <gugia@qq.com>
 */
@Controller
public class ImsUserController {

    @Resource
    ImsUserService imsUserService;
    @Resource
    RandomUserHelper randomUserHelper;

    /**
     * 首页地址映射
     *
     * @return 返回首页视图名称
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    /**
     * 通过url传参，分页查询所有用户，并以JSON格式返回
     *
     * @param page 当前页码，默认0
     * @param size 每页条目数量，默认15
     * @return 分页查询结果
     */
    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Page<ImsUser> findAllPaged(@RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "15") Integer size) {
        return imsUserService.findAll(page, size);
    }

    /**
     * 通过url传参，分页查询特定部门的所有用户，并以JSON格式返回
     *
     * @param department_id 部门id
     * @param page 当前页码，默认0
     * @param size 每页条目数量，默认15
     * @return 分页查询结果
     */
    @ResponseBody
    @RequestMapping(value = "/departments/{department_id}/users", method = RequestMethod.GET)
    public Page<ImsUser> findAllByDepartmentPaged(@PathVariable("department_id") int department_id, @RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "15") Integer size) {
        return imsUserService.findAllByDepartment(department_id, page, size);
    }

    /**
     * 批量创建用户
     *
     * @param size 要创建的用户数量
     * @return 成功返回success，失败返回..
     */
    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String saveImsUsers(@RequestParam(value = "size", defaultValue = "20") Integer size) {
        imsUserService.save(randomUserHelper.generateUserList(size));
        return "success";
    }
}
