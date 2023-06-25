package com.nxg.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nxg.domain.Route;

import java.util.List;

/**
 * @author nxg
 * @apiNote 旅游路线 --数据访问层
 */
public interface RouteDao extends BaseMapper<Route> {

    /**
     * 分页查询
     * @param condition
     * @return
     */
    public List<Route> find(Route condition);

    /**
     * 根据Id查询用户
     * @param id
     * @return
     */
    public Route findById(Integer id);
}
