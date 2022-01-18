package com.atguigu.shangyitong.controller.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
public class CommentsVO{

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

}
