package com.aue.dao;


import com.aue.pojo.Post;
import com.aue.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PostMapper {
    List<Post> selectPostsByPage(@Param("offset") int offset, @Param("rowCount") int rowCount);

    Post selectById(int id);

    List<Post> selectByCondition(@Param("title") String title, @Param("content") String content, @Param("status") int status);

    List<Post> selectByCondition(Post post);

    List<Post> selectByCondition(Map<String, Object> map);

    List<Post> selectByConditionWithDynamicSql(Post post);

    List<Post> selectByConditionWithOneCondition(Post post);

    int add(Post post);

    int update(Post post);

    int deleteById(int i);

    int deleteByIds(int[] ids);

    int deleteByIds(List<Integer> ids);

    List<Post> selectPostsAndUser();

    List<User> selectUserAndPosts();

    List<User> selectUsers();

    List<Post> selectPostsByUserId();
}