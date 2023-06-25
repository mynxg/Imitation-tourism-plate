package com.nxg.controller;

import com.github.pagehelper.PageInfo;
import com.nxg.domain.Seller;
import com.nxg.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author nxg
 * @apiNote 旅游公司 控制器
 */
@Controller
@RequestMapping("/admin/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    /**
     * 分页查询
     * @param seller
     * @param pageNum
     * @param pageSize
     * @param model
     * @return
     */
    @RequestMapping("/page")
    public String page(Seller seller,
                       @RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       Model model){
        PageInfo<Seller> page = sellerService.findPage(seller,pageNum,pageSize);

        model.addAttribute("page",page);

        return "seller/list";
    }

    /**
     * 跳转到添加页面
     * @return
     */
    @RequestMapping("/toadd")
    public String toAdd(){
        return "seller/add";
    }

    /**
     * 添加
     * @param seller
     * @return
     */
    @RequestMapping("/doadd")
    public String doAdd(Seller seller){
        sellerService.add(seller);
        return "redirect:/admin/seller/page";
    }

    /**
     * 跳转到更新(修改)页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toupdate/{id}")
    public String toUpdate(@PathVariable("id") Integer id,Model model){
        Seller seller = sellerService.findById(id);
        model.addAttribute("seller",seller);

        return "seller/update";
    }

    /**
     * 修改
     * @param seller
     * @return
     */
    @RequestMapping("/doupdate")
    public String doUpdate(Seller seller){
        sellerService.update(seller);
        return "redirect:/admin/seller/page";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        sellerService.delete(id);
        return "redirect:/admin/seller/page";
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public String batchDelete(@RequestParam("ids") Integer[] ids){
        for (Integer id : ids) {
            sellerService.delete(id);
        }
        return "redirect:/admin/seller/page";
    }

}
