package com.atguigu.shangyitong.service;

import com.atguigu.shangyitong.controller.vo.CommentsVO;
import com.atguigu.shangyitong.entity.CommentsEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* 评论区接口
*/
@Service
public interface CommentsTableService extends IService<CommentsEntity> {

    /**
     * 发布一条评论
     * @param commentsVO
     * @return
     */
    public Integer publishComments(CommentsVO commentsVO);

    /**
     * 查询某业务下的所有顶级评论
     * @param type
     * @param businessId
     * @return
     */
    public List topicComments(Integer type, Long businessId);

    /**
     * 查询某顶级评论下的所有子评论
     * @param type
     * @param rootCommentId
     * @return
     */
    public List commentsOfTopic(Integer type,String rootCommentId);

    /**
     * 删除一条评论
     * @param commentId
     * @return
     */
    public Integer deleteOneComment(String commentId);
}
