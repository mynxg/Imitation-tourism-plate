package com.nxg.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nxg.domain.Seller;

import java.util.List;

/**
 * @author nxg
 * @apiNote  业务逻辑层
 */
public interface SellerService {

    /**
     * 分页查询
     * @param condition 查询条件
     * @param pageNum 当前页
     * @param pageSize 当前页行数
     * @return
     */
    public PageInfo<Seller> findPage(Seller condition,int pageNum,int pageSize);

    /**
     * 查询
     * @param condition 查询条件
     * @return
     */
    public List<Seller> find(Seller condition);

    /**
     * 根据Id查询商家信息
     * @param id
     * @return
     */
    public Seller findById(Integer id);

    /**
     * 添加
     * @param seller
     * @return
     */
    public int add(Seller seller);

    /**
     * 修改
     * @param seller
     * @return
     */
    public int update(Seller seller);

    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(Integer id);
}
