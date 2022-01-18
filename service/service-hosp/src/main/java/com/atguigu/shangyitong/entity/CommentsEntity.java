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

@TableName(value = "comments_table")
@Data
@ApiModel(description = "评论实体表")
public class CommentsEntity {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    private Long id;
    private String commentId;
    @ApiModelProperty(value = "评论内容")
    private String content;
    @ApiModelProperty(value = "评论用户")
    private String userId;
    @ApiModelProperty(value = "评论业务Id")
    private Long businessId;
    @ApiModelProperty(value = "评论类型")
    private Integer type;
    @ApiModelProperty(value = "是否是消息转发")
    private Integer messageType;
    @ApiModelProperty(value = "评论点赞数量")
    private Integer commentLikeCount;
    @ApiModelProperty(value = "转发次数")
    private Integer commentTranspond;
    @ApiModelProperty(value = "收藏次数")
    private Integer commentCollected;
    @ApiModelProperty(value = "顶级评论id，用于区分顶级评论和回复评论，如果为null则为顶级评论，如果不为空则为顶级评论的id")
    private String rootCommentId;
    @ApiModelProperty(value = "为null则为顶级评论,否则为目标评论id")
    private String toCommentId;
    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @ApiModelProperty(value = "逻辑删除")
    private Integer deleted;
    @ApiModelProperty(value = "是否审核")
    private Integer checked;

}
