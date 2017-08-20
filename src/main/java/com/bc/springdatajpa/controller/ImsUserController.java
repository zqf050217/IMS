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
 *
 * @author L.X <gugia@qq.com>
 */
@Controller
public class ImsUserController {

    @Resource
    ImsUserService imsUserService;
    @Resource
    RandomUserHelper randomUserHelper;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Page<ImsUser> findAllPaged(@RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "15") Integer size) {
        return imsUserService.findAll(page, size);
    }

    @ResponseBody
    @RequestMapping(value = "/departments/{department_id}/users", method = RequestMethod.GET)
    public Page<ImsUser> findAllByDepartmentPaged(@PathVariable("department_id") int department_id, @RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "15") Integer size) {
        return imsUserService.findAllByDepartment(department_id, page, size);
    }

    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String findAllPaged(@RequestParam(value = "size", defaultValue = "20") Integer size) {
        imsUserService.save(randomUserHelper.generateUserList(size));
        return "success";
    }
}
