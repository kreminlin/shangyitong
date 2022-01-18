package com.atguigu.shangyitong.utils;

public class RedisKeyUtils {

    //保存用户点赞数据的key
    public static final String MAP_KEY_USER_LIKED = "MAP_USER_LIKED";
    //保存用户被点赞数量的key
    public static final String MAP_KEY_USER_LIKED_COUNT = "MAP_USER_LIKED_COUNT";

    /**
     * 拼接被点赞的用户id和点赞的人的id作为key。格式 222222::333333
     * @param likedUserId 被点赞的人id
     * @param likedPostId 点赞的人的id
     * @param affaird 被点赞文章或业务的id
     * @return
     */
    public static String getLikedKey(Long likedUserId, Long likedPostId,Long affaird){
        StringBuilder builder = new StringBuilder();
        builder.append(likedUserId);
        builder.append("::");
        builder.append(likedPostId);
        builder.append("::");
        builder.append(affaird);
        return builder.toString();
    }
}
