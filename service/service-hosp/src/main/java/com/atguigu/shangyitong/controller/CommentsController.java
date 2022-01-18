package com.atguigu.shangyitong.controller;

import com.atguigu.shangyitong.controller.vo.CommentsVO;
import com.atguigu.shangyitong.service.CommentsTableService;
import com.atguigu.shangyitong.service.LikeTableService;
import com.atguigu.shangyitong.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * 评论专区
 */
@RestController
@RequestMapping(value = "/comments")
@Api(tags = "comments")
public class CommentsController {

    @Autowired
    CommentsTableService commentsTableService;

    @Autowired
    RedisService redisService;

    @Autowired
    LikeTableService likeTableService;

    private static final Integer PROJECT = 1;
    private static final Integer FUND = 2;
    private static final Integer POLICY = 3;

    @RequestMapping(value = "/findAllTopicOfBusiness",method = RequestMethod.POST)
    @ApiOperation(value = "查询某业务下所有顶级评论")
    public HashMap findAllTopicOfBusiness(@RequestParam Integer type, @RequestParam Long businessId){
        HashMap hashMap = new HashMap();
        if(type.equals(PROJECT)){
            List topicComments = commentsTableService.topicComments(type,businessId);
            hashMap.put("project",topicComments);
            hashMap.put("count",topicComments.size());
        } else if(type.equals(FUND)){
            List topicComments = commentsTableService.topicComments(type,businessId);
            hashMap.put("fund",topicComments);
            hashMap.put("count",topicComments.size());
        } else if(type.equals(POLICY)){
            List topicComments = commentsTableService.topicComments(type,businessId);
            hashMap.put("policy",topicComments);
            hashMap.put("count",topicComments.size());
        }
        return hashMap;
    }

    @RequestMapping(value = "/findAllCommentsOfTopic",method = RequestMethod.POST)
    @ApiOperation(value = "查询某顶级评论下的所有评论")
    public HashMap findAllCommentsOfTopic(@RequestParam Integer type,@RequestParam String rootCommentId){
        HashMap hashMap = new HashMap();
        if(type.equals(PROJECT)){
            List commentsOfTopic = commentsTableService.commentsOfTopic(type,rootCommentId);
            hashMap.put("project",commentsOfTopic);
            hashMap.put("count",commentsOfTopic.size());
        }else if(type.equals(FUND)){
            List commentsOfTopic = commentsTableService.commentsOfTopic(type,rootCommentId);
            hashMap.put("project",commentsOfTopic);
            hashMap.put("count",commentsOfTopic.size());
        }else if(type.equals(POLICY)){
            List commentsOfTopic = commentsTableService.commentsOfTopic(type,rootCommentId);
            hashMap.put("project",commentsOfTopic);
            hashMap.put("count",commentsOfTopic.size());
        }
        return hashMap;
    }

    @RequestMapping(value = "/publishOneComment",method = RequestMethod.POST)
    @ApiOperation(value = "发布一条评论")
    public Integer publishOneComment(@RequestBody CommentsVO commentsVO){
        Integer result = commentsTableService.publishComments(commentsVO);
        return result;
    }

    @RequestMapping(value = "/deleteOneComment",method = RequestMethod.POST)
    @ApiOperation(value = "删除一条评论123")
    public Integer deleteOneComments(@RequestParam String commentId){
        Integer result = commentsTableService.deleteOneComment(commentId);
        return result;
    }

    @RequestMapping(value = "/like",method = RequestMethod.POST)
    @ApiOperation(value = "点赞")
    public Integer like(@RequestParam Long userId,@RequestParam Long likePostId,@RequestParam Long affaird){
        Integer result = redisService.saveLiked2Redis(userId,likePostId,affaird);
        return result;
    }

    @RequestMapping(value = "/unlike",method = RequestMethod.POST)
    @ApiOperation(value = "取消点赞")
    public Integer unlike(@RequestParam Long userId,@RequestParam Long likePostId,@RequestParam Long affaird){
        Integer result = redisService.unlikeFromRedis(userId,likePostId,affaird);
        return result;
    }

    @RequestMapping(value = "/findLikeMe",method = RequestMethod.POST)
    @ApiOperation(value = "查询点赞我的")
    public Integer findLikeMe(@RequestParam Integer likeType,@RequestParam String liketype,@RequestParam Integer status){
        Integer result = commentsTableService.deleteOneComment(liketype);
        return result;
    }

}
