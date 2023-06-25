package com.nxg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nxg.dao.SellerDao;
import com.nxg.domain.Seller;
import com.nxg.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nxg
 * @apiNote 公司名称  -- 实现
 */
@Service
public class SellerServiceImpl implements SellerService  {

    @Autowired
    private SellerDao sellerDao;

    /**
     * 分页查询
     *
     * @param condition 查询条件
     * @param pageNum   当前页
     * @param pageSize  当前页行数
     * @return
     */
    @Override
    public PageInfo<Seller> findPage(Seller condition, int pageNum, int pageSize) {

        return PageHelper.startPage(pageNum,pageSize).doSelectPageInfo(() ->{
            sellerDao.selectList(new QueryWrapper<Seller>());
        });
    }

    /**
     * 查询
     *
     * @param condition 查询条件
     * @return
     */
    @Override
    public List<Seller> find(Seller condition) {
        return sellerDao.selectList(Wrappers.query());
    }

    /**
     * 根据Id查询商家信息
     *
     * @param id
     * @return
     */
    @Override
    public Seller findById(Integer id) {
        return sellerDao.selectById(id);
    }

    /**
     * 添加
     *
     * @param seller
     * @return
     */
    @Override
    public int add(Seller seller) {
        return sellerDao.insert(seller);
    }

    /**
     * 修改
     *
     * @param seller
     * @return
     */
    @Override
    public int update(Seller seller) {
        return sellerDao.updateById(seller);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public int delete(Integer id) {
        return sellerDao.deleteById(id);
    }
}
