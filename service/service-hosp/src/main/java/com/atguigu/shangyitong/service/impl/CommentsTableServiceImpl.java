package com.atguigu.shangyitong.service.impl;

import com.atguigu.shangyitong.controller.vo.CommentsVO;
import com.atguigu.shangyitong.entity.CommentsEntity;
import com.atguigu.shangyitong.mapper.CommentsTableMapper;
import com.atguigu.shangyitong.service.CommentsTableService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 *
 */
@Service
public class CommentsTableServiceImpl extends ServiceImpl<CommentsTableMapper, CommentsEntity> implements CommentsTableService {

    @Autowired
    CommentsTableMapper commentsTableMapper;

    @Override
    public Integer publishComments(CommentsVO commentsVO) {
        CommentsEntity commentsEntity = new CommentsEntity();
        commentsEntity.setCommentId(UUID.randomUUID().toString());
        commentsEntity.setBusinessId(commentsVO.getBusinessId());
        commentsEntity.setType(commentsVO.getType());
        commentsEntity.setContent(commentsVO.getContent());
        commentsEntity.setCommentTranspond(commentsVO.getCommentTranspond());
        commentsEntity.setDeleted(0);
        commentsEntity.setUserId(commentsVO.getUserId());
        commentsEntity.setChecked(0);
        commentsEntity.setRootCommentId(commentsVO.getRootCommentId());
        commentsEntity.setToCommentId(commentsVO.getToCommentId());
        commentsEntity.setMessageType(commentsVO.getMessageType());
        commentsEntity.setCommentCollected(commentsVO.getCommentCollected());
        commentsEntity.setCommentLikeCount(commentsVO.getCommentLikeCount());
        return commentsTableMapper.insert(commentsEntity);
    }

    @Override
    public List topicComments(Integer type, Long businessId) {
        return commentsTableMapper.selectList(Wrappers.<CommentsEntity>query().lambda().eq(CommentsEntity::getType,type).eq(CommentsEntity::getRootCommentId,"0").eq(CommentsEntity::getBusinessId,businessId));
    }

    @Override
    public List commentsOfTopic(Integer type, String rootCommentId) {
        return commentsTableMapper.selectList(Wrappers.<CommentsEntity>query().lambda().eq(CommentsEntity::getType,type).eq(CommentsEntity::getRootCommentId,rootCommentId));
    }

    @Override
    public Integer deleteOneComment(String commentId) {
        return commentsTableMapper.delete(Wrappers.<CommentsEntity>query().lambda().eq(CommentsEntity::getCommentId,commentId));
    }
}
