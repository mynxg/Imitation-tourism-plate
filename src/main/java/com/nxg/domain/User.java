package com.nxg.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author nxg
 * @apiNote 用户 管理
 */
@Data
@TableName("tab_user")
public class User implements Serializable {
    @TableId(type = IdType.AUTO) //自增
    private Integer uid;
    private String username;
    private String password;
    private String name;
    private Date birthday;
    private String sex;
    private String telephone;
    private String email;
    private String status;
    private String code;

    private Boolean isadmin;
}
