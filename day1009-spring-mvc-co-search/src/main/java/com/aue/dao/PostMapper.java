package com.aue.dao;


import com.aue.pojo.Post;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PostMapper {
    List<Post> selectPostsByPage(@Param("offset")int offset, @Param("rowCount")int rowCount);

    Post selectById(int id);

    List<Post> selectByCondition(@Param("title") String title, @Param("content") String content, @Param("status") int status);

    List<Post> selectByCondition(Post post);

    List<Post> selectByCondition(Map<String, Object> map);

    List<Post> selectByConditionWithDynamicSql(Post post);

    List<Post> selectByConditionWithOneCondition(Post post);

    int add(Post post);

    void update(Post post);

    void deleteById(int i);

    void deleteByIds(int[] ids);

    void deleteByIds(List<Integer> ids);

    List<Post> selectPostsAndUser();
}