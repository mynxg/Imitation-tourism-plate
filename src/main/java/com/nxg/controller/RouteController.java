package com.nxg.controller;

import com.github.pagehelper.PageInfo;
import com.nxg.domain.Category;
import com.nxg.domain.Route;
import com.nxg.domain.RouteImg;
import com.nxg.domain.Seller;
import com.nxg.service.CategoryService;
import com.nxg.service.RouteImgService;
import com.nxg.service.RouteService;
import com.nxg.service.SellerService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author nxg
 * @apiNote 路线控制器
 */
@Controller
@RequestMapping("/admin/route")
public class RouteController {

    @Autowired
    private RouteService routeService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SellerService sellerService;
    @Autowired
    private RouteImgService routeImgService;

    /**
     * 分页查询
     * @param route
     * @param pageNum 当前页
     * @param pageSize 当前页行数
     * @param model
     * @return
     */
    @RequestMapping("/page")
    public String page(Route route,
                           @RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "10") Integer pageSize,
                           Model model){
        PageInfo<Route> page = routeService.findPage(route,pageNum,pageSize);
        model.addAttribute("page",page);

        //查询所有分类生成下拉框
        List<Category> categories = categoryService.find();
        model.addAttribute("categories",categories);
        List<Seller> sellers = sellerService.find(new Seller());
        model.addAttribute("sellers",sellers);

        //用于页面回显
        model.addAttribute("route",route);
        return "route/list";
    }

    /**
     * 跳转到添加页面
     * @param model
     * @return
     */
    @RequestMapping("/toadd")
    public String toAdd(Model model){
        //查询所有分类生成下拉框
        List<Category> categories = categoryService.find();
        model.addAttribute("categories",categories);
        List<Seller> sellers = sellerService.find(new Seller());
        model.addAttribute("sellers",sellers);
        return "route/add";
    }

    /**
     * 执行添加
     * @param route
     * @param rimageFile
     * @param request
     * @return
     */
    @RequestMapping("/doadd")
    public String doAdd(Route route, @RequestParam("rimageFile")MultipartFile rimageFile,
                        HttpServletRequest request) throws IOException {
        //项目的部署目录 + img/product/small/
        performRImage(route,rimageFile,request);

        routeService.add(route);
        return "redirect:/admin/route/page";
    }

    /**
     * 图片处理工具
     * @param route
     * @param rimageFile
     * @param request
     * @throws IOException
     */
    public void performRImage(Route route,@RequestParam("rimageFile") MultipartFile rimageFile,HttpServletRequest request) throws IOException{
        //项目的部署目录 + img/product/small/
        String savePath = request.getServletContext().getRealPath("img/product/small/");

        //处理随机文件名
        String fileName = UUID.randomUUID().toString().replaceAll("-","")+"."+ FilenameUtils.getExtension(rimageFile.getOriginalFilename());

        //上传目录 如果不存在,先创建
        File savePathDir = new File(savePath);
        if (!savePathDir.exists()){
            savePathDir.mkdirs();
        }

        //保存文件
        rimageFile.transferTo(new File(savePathDir,fileName));
        //设置路线的rimage属性 = 文件的相对路径
        route.setRimage("img/product/small/"+fileName);
    }


    /**
     * 根据id查询，跳转到修改页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toupdate/{id}")
    public String toUpdate(@PathVariable("id") Integer id,Model model){
        //查询所有分类生成下拉框
        List<Category> categories = categoryService.find();
        model.addAttribute("categories",categories);

        List<Seller> sellers = sellerService.find(new Seller());
        model.addAttribute("sellers",sellers);

        Route route = routeService.findById(id);
        model.addAttribute("route",route);
        return "route/update";
    }

    /**
     * 执行更新(修改)
     * @param route
     * @return
     */
    @RequestMapping("/doupdate")
    public String doUpdate(Route route,@RequestParam("rimageFile") MultipartFile rimageFile,HttpServletRequest request) throws IOException{
        //项目的部署目录 + img/product/rimage/
        performRImage(route,rimageFile,request);
        routeService.update(route);
        return "redirect:/admin/route/page";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        routeService.delete(id);
        return "redirect:/admin/route/page";
    }

    /**
     * 根据id加载路线图片,跳转到image.html
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toimage/{id}")
    public String toImage(@PathVariable("id") Integer id,Model model) {
        Route route = routeService.findById(id);
        model.addAttribute("route",route);

        return "route/image";
    }

    /**
     * 图片上传
     * @param rid
     * @param bigPicFile
     * @param smallPicFile
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/doimage")
    public String doImage(Integer rid,
                          @RequestParam("bigPicFile") MultipartFile[] bigPicFile,
                          @RequestParam("smallPicFile") MultipartFile[] smallPicFile,
                          HttpServletRequest request) throws IOException {
        List<String> bigPic = new ArrayList<>();
        List<String> smallPic = new ArrayList<>();

        String path = request.getServletContext().getRealPath("/");
        for (MultipartFile f : bigPicFile) {
            // img\product\big-pic\
            File bigPath = new File(path+"img\\product\\size4\\");
            if (!bigPath.exists()){
                bigPath.mkdirs();
            }
            String fileName = UUID.randomUUID().toString().replaceAll("-","")+"."+FilenameUtils.getExtension(f.getOriginalFilename());
            f.transferTo(new File(bigPath,fileName));
            //大图
            bigPic.add("img/product/size4/"+fileName);
        }
        for (MultipartFile f : smallPicFile) {
            File smallPath = new File(path+"img\\product\\size2\\");
            if (!smallPath.exists()){
                smallPath.mkdirs();
            }
            String fileName = UUID.randomUUID().toString().replaceAll("-","")+"."+FilenameUtils.getExtension(f.getOriginalFilename());
            f.transferTo(new File(smallPath,fileName));
            //img/product/small-pic/
            smallPic.add("img/product/size2/"+fileName);
        }
        //要添加的图片列表
        List<RouteImg> ris = new ArrayList<>();
        for (int i=0; i < bigPic.size();i++) {
            RouteImg img = new RouteImg();
            img.setRid(rid);
            img.setBigpic(bigPic.get(i));
            img.setSmallpic(smallPic.get(i));
            ris.add(img);
        }

        routeImgService.saveImg(rid,ris);

        return "redirect:/admin/route/page";
    }
}
