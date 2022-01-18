package com.atguigu.shangyitong.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@TableName(value = "like_table")
@Data
@ApiModel(description = "点赞表")
public class LikeEntity {

    @TableId(value = "id",type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    private Long id;

    private Long userId;

    private Long likedPostId;

    private Long affairId;

    private Integer status;

    private Integer likeType;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}
