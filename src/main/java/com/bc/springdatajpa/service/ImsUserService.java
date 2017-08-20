/*
 * Copyright 2017 BangChen Information Technology Ltd., Co.
 * Licensed under the Apache License 2.0.
 */
package com.bc.springdatajpa.service;

import com.bc.springdatajpa.dao.ImsUserDao;
import com.bc.springdatajpa.po.ImsUser;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * 用户服务层（为了演示未定义接口）
 *
 * @author L.X <gugia@qq.com>
 */
@Service
public class ImsUserService {

    @Resource
    ImsUserDao imsUserDao;

    /**
     * 批量新建用户
     *
     * @param list 要保存的ImsUser集合（泛型）
     */
    public void save(List<ImsUser> list) {
        imsUserDao.save(list);
    }

    /**
     * 无条件分页查询用户
     *
     * @param page 当前页码，初始为0
     * @param size 每页条目数量
     * @return 返回ImsUser集合
     */
    public Page<ImsUser> findAll(int page, int size) {
        return imsUserDao.findAll(new PageRequest(page, size));
    }

    /**
     * 按所在部门分页查询用户，包括一个匿名方法（lambda表达式）
     *
     * @param department 用户所在部门（整型）
     * @param page 当前页码，初始为0
     * @param size 每页条目数量
     * @return 返回ImsUser集合
     */
    public Page<ImsUser> findAllByDepartment(final int department, int page, int size) {
        return imsUserDao.findAll((Root<ImsUser> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            Predicate predicate = cb.equal(root.get("department"), department);
            query.where(predicate);
            return predicate;
        }, new PageRequest(page, size));
    }
}
