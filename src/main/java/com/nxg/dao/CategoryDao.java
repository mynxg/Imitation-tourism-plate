package com.nxg.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nxg.domain.Category;
import org.apache.ibatis.annotations.Select;

/**
 * @author nxg
 * @apiNote
 */
public interface CategoryDao extends BaseMapper<Category> {

    @Select("select cname,cid from tab_category where cid=#{cid}")
    public Category findById(Integer id);
}
