package com.nxg.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author nxg
 * @apiNote 旅游图片 -->实体类
 */
@Data
@TableName("tab_route_img")
public class RouteImg implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer rgid;//商品图片 id
    private Integer rid; //旅游商品 id
    private String bigpic;//详情商品图片
    private String smallpic;//详情商品小图
}
