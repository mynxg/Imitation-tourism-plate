package com.nxg.service;

import com.github.pagehelper.PageInfo;
import com.nxg.domain.Route;

/**
 * @author nxg
 * @apiNote
 */
public interface RouteService {

    /**
     * 分页查询
     * @param condition 查询条件
     * @param pageNum 当前页
     * @param pageSize //当前页行数
     * @return
     */
    public PageInfo<Route> findPage(Route condition,int pageNum,int pageSize);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    public Route findById(Integer id);

    /**
     * 添加
     * @param route
     * @return
     */
    public int add(Route route);

    /**
     * 修改
     * @param route
     * @return
     */
    public int update(Route route);

    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(Integer id);

}
