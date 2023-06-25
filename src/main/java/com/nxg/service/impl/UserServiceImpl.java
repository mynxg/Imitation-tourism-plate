package com.nxg.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nxg.dao.UserDao;
import com.nxg.domain.User;
import com.nxg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nxg
 * @apiNote 用户 业务逻辑层
 * 用户业务 实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public PageInfo<User> findPage(User condition, int pageNum, int pageSize) {
        return PageHelper.startPage(pageNum,pageSize).doSelectPageInfo(() ->{
            userDao.selectList(Wrappers.<User>query());
        });
    }

    @Override
    public List<User> find(User condition) {
        return userDao.selectList(Wrappers.query());
    }

    @Override
    public int add(User user) {
        return userDao.insert(user);
    }

    @Override
    public User findById(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public int update(User user) {
        return userDao.updateById(user);
    }

    @Override
    public int delete(Integer id) {
        return userDao.deleteById(id);
    }
}
