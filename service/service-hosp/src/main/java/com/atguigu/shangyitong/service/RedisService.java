package com.atguigu.shangyitong.service;

import com.atguigu.shangyitong.controller.dto.LikedCountDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * RedisService：评论点赞用
 */
@Service
public interface RedisService {

    /**
     * 点赞。状态为1
     * @param likedUserId
     * @param likedPostId
     * @param affaird
     */
    Integer saveLiked2Redis(Long likedUserId, Long likedPostId,Long affaird);

    /**
     * 取消点赞。将状态改变为0
     * @param likedUserId
     * @param likedPostId
     */
    Integer unlikeFromRedis(Long likedUserId, Long likedPostId,Long affaird);

    /**
     * 从Redis中删除一条点赞数据
     * @param likedUserId
     * @param likedPostId
     */
    void deleteLikedFromRedis(Long likedUserId, Long likedPostId,Long affaird);

    /**
     * 该用户的点赞数加1
     * @param likedUserId
     */
    void incrementLikedCount(Long likedUserId);

    /**
     * 该用户的点赞数减1
     * @param likedUserId
     */
    void decrementLikedCount(Long likedUserId);

    /**
     * 获取Redis中存储的所有点赞数据
     * @return
     */
//    List<UserLike> getLikedDataFromRedis();

    /**
     * 获取Redis中存储的所有点赞数量
     * @return
     */
    List<LikedCountDTO> getLikedCountFromRedis();

}
