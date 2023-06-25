package com.nxg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nxg.dao.RouteDao;

import com.nxg.domain.Route;
import com.nxg.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nxg
 * @apiNote
 */
@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteDao routeDao;

    /**
     * 分页查询
     *
     * @param condition 查询条件
     * @param pageNum   当前页
     * @param pageSize  //当前页行数
     * @return
     */
    @Override
    public PageInfo<Route> findPage(Route condition, int pageNum, int pageSize) {
        return PageHelper.startPage(pageNum,pageSize).doSelectPageInfo(() -> {
            routeDao.find(condition);
        });
    }

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    @Override
    public Route findById(Integer id) {
        return routeDao.findById(id);
    }

    /**
     * 添加
     *
     * @param route
     * @return
     */
    @Override
    public int add(Route route) {
        return routeDao.insert(route);
    }

    /**
     * 修改
     *
     * @param route
     * @return
     */
    @Override
    public int update(Route route) {
        return routeDao.updateById(route);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public int delete(Integer id) {
        return routeDao.deleteById(id);
    }
}
