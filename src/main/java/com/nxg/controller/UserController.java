package com.nxg.controller;

import com.github.pagehelper.PageInfo;
import com.nxg.domain.User;
import com.nxg.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author nxg
 * @apiNote 用户 控制器
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 分页查询
     * @param user 请求参数
     * @param pageNum 当前页
     * @param pageSize 每页行数
     * @param model
     * @return
     */
    @RequestMapping("/page")
    public String page(
            User user,
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize,
            Model model){
        PageInfo<User> page = userService.findPage(user,pageNum,pageSize);
        model.addAttribute("page",page);

        model.addAttribute("user",user);
        return "user/list";
    }

    /**
     * 跳转到添加页面
     * @return
     */
    @RequestMapping("/toadd")
    public String toAdd(){
        return "user/add";
    }

    /**
     * 添加
     * @param user
     * @return
     */
    @RequestMapping("/doadd")
    public String doAdd(User user){
        userService.add(user);
        return "redirect:/admin/user/page";
    }

    /**
     * 跳转到修改页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toupdate/{uid}")
    public String toUpdate(@PathVariable("uid")Integer id,Model model){
        User user = userService.findById(id);
        model.addAttribute("user",user);
        return "user/update";
    }

    /**
     * 修改
     * @param user
     * @return
     */
    @RequestMapping("/doupdate")
    public String doUpdate(User user){
        userService.update(user);
        return "redirect:/admin/user/page";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        userService.delete(id);
        return "redirect:/admin/user/page";
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public String batchDelete(@RequestParam("ids") Integer[] ids){
        for (Integer id : ids) {
            userService.delete(id);
        }
        return "redirect:/admin/user/page";
    }
}
