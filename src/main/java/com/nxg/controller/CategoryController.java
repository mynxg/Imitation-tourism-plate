package com.nxg.controller;

import com.nxg.domain.Category;
import com.nxg.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author nxg
 * date 2022/1/17
 * @apiNote 分类管理 控制器
 */
@Controller
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 查询列表
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String find(Model model){
        List<Category> list = categoryService.find();
        model.addAttribute("list",list);
        return "category/list";
    }

    /**
     * 跳转到添加页面
     * @return
     */
    @RequestMapping("/toadd")
    public String toAdd(){
        return "category/add";
    }

    /**
     * 添加
     * @param category
     * @return
     */
    @RequestMapping("/doadd")
    public String doAdd(Category category){
        categoryService.add(category);
        return "redirect:/admin/category/list";
    }

    /**
     * 跳转到修改页面
     * @param id
     * @return
     */
    @RequestMapping("/toupdate/{id}")
    public String toUpdate(@PathVariable("id") Integer id,Model model){
        Category category = categoryService.findById(id);
        model.addAttribute("category",category);
        return "category/update";
    }

    /**
     * 修改
     * @param category
     * @return
     */
    @RequestMapping("/doupdate")
    public String doUpdate(Category category){
        categoryService.update(category);
        return "redirect:/admin/category/list";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        categoryService.delete(id);
        return "redirect:/admin/category/list";
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public String batchDelete(@RequestParam("ids") Integer[] ids){
        for (Integer id : ids) {
            categoryService.delete(id);
        }
        return "redirect:/admin/category/page";
    }
}
