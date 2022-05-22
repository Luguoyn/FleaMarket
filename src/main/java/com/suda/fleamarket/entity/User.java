package com.suda.fleamarket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.suda.fleamarket.enums.Authority;
import com.suda.fleamarket.enums.Gander;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    @TableId(type = IdType.AUTO)
    private int id;
    private String name;
    private Authority authority;
    private Date birthday;
    private Gander gander;
    private String address;
    private String telephone;
}
