package com.nxg.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.nxg.dao.CategoryDao;
import com.nxg.domain.Category;
import com.nxg.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nxg
 * @apiNote
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> find() {
        return categoryDao.selectList(Wrappers.query());
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public Category findById(Integer id) {
        return categoryDao.selectById(id);
    }

    /**
     * 添加
     * @param category
     * @return
     */
    @Override
    public int add(Category category) {
        return categoryDao.insert(category);
    }

    /**
     * 修改
     * @param category
     * @return
     */
    @Override
    public int update(Category category) {
        return categoryDao.updateById(category);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public int delete(Integer id) {
        return categoryDao.deleteById(id);
    }
}
