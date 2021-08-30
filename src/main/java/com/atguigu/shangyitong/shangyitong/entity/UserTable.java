package com.atguigu.shangyitong.shangyitong.entity;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@TableName(value = "user_table")
@Data
public class UserTable {

  @TableId(value = "id",type = IdType.ASSIGN_ID)
  private long id;
  private String name;
  private long age;
  private String email;

  @TableField(fill = FieldFill.INSERT)
  private Date createTime;

  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;

  //实现乐观锁--需要version版本号对应
  @Version
  @TableField(fill = FieldFill.INSERT)
  private Integer version;

}
