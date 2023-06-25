package com.nxg.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nxg.domain.Seller;
import org.apache.ibatis.annotations.Select;

/**
 * @author nxg
 * @apiNote 公司dao 数据访问层
 */
public interface SellerDao extends BaseMapper<Seller> {

    @Select("SELECT * FROM tab_seller WHERE sid=#{id}")
    public Seller findById(Integer id);
}
