package com.nxg.service;

import com.github.pagehelper.PageInfo;
import com.nxg.domain.User;

import java.util.List;

/**
 * @author nxg
 * @apiNote 用户接口 -业务逻辑层
 */
public interface UserService {

    /**
     * 分页查询
     * @param condition 查询条件
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<User> findPage(User condition,int pageNum,int pageSize);

    /**
     * 查询
     * @param condition 查询条件
     * @return
     */
    public List<User> find(User condition);

    /**
     * 添加
     * @param user
     * @return
     */
    public int add(User user);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    public User findById(Integer id);

    /**
     * 修改
     * @param user
     * @return
     */
    public int update(User user);

    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(Integer id);

}
