package com.nxg.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author nxg
 * @apiNote 分类
 */
@Data
@TableName("tab_category")
public class Category implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer cid; //分类id
    private String cname; //分类名称
}
