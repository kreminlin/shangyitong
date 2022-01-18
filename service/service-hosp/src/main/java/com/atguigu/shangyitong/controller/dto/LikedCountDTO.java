package com.atguigu.shangyitong.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LikedCountDTO {

    @ApiModelProperty(value = "点赞用户ID")
    private Long userId;

    @ApiModelProperty(value = "被点赞用户ID")
    private Long likedPostId;

    @ApiModelProperty(value = "评论事务ID")
    private Long affairId;

    @ApiModelProperty(value = "是否点赞，0未点赞，1点赞")
    private Integer status;

    @ApiModelProperty(value = "点赞类型")
    private Long likeType;

}
