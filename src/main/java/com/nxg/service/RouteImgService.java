package com.nxg.service;

import com.nxg.domain.RouteImg;

import java.util.List;

/**
 * @author nxg
 * date 2022/1/17
 * @apiNote
 */
public interface RouteImgService {

    /**
     * 处理线路图片
     * @param rid 线路id，根据线路id删除原图
     * @param routeImgs 要添加的线路图片列表
     */
    public void saveImg(Integer rid, List<RouteImg> routeImgs);
}
