package com.nxg.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nxg.domain.RouteImg;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author nxg
 * @apiNote 图片 -数据访问层
 */
public interface RouteImgDao extends BaseMapper<RouteImg> {

    @Select("select * from tab_route_img where rid = #{rid}")
    public List<RouteImg> findByRid(Integer rid);
}
