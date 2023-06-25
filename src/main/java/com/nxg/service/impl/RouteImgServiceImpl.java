package com.nxg.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.nxg.dao.RouteImgDao;
import com.nxg.domain.RouteImg;
import com.nxg.service.RouteImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author nxg
 * @apiNote
 */
@Service
public class RouteImgServiceImpl implements RouteImgService {

    @Autowired
    private RouteImgDao routeImgDao;

    /**
     * 处理线路图片
     *
     * @param rid       线路id删除原图
     * @param routeImgs 要添加的线路图片列表
     */
    @Override
    @Transactional
    public void saveImg(Integer rid, List<RouteImg> routeImgs) {
        List<RouteImg> byRid = routeImgDao.findByRid(rid);
        // TODO: 数据库中数据有问题
//        if(byRid.isEmpty() && byRid.size()<=0){
//            return ;
//        }
        routeImgDao.delete(Wrappers.<RouteImg>query().eq("rid",rid));
        for (RouteImg routeImg : routeImgs) {
            routeImgDao.insert(routeImg);
        }
    }
}
