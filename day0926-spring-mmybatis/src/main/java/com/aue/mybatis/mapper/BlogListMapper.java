package com.aue.mybatis.mapper;


import com.aue.mybatis.po.BlogList;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BlogListMapper {
    List<BlogList> selectAll();

    BlogList selectById(int id);

    List<BlogList> selectByCondition(@Param("title") String title, @Param("content") String content, @Param("status") int status);

    List<BlogList> selectByCondition(BlogList blogList);

    List<BlogList> selectByCondition(Map<String, Object> map);

    List<BlogList> selectByConditionWithDynamicSql(BlogList blogList);

    List<BlogList> selectByConditionWithOneCondition(BlogList blogList);

    void add(BlogList blogList);

    void update(int i, @Param("blogList") BlogList blogList1);

    void deleteById(int i);

    void deleteByIds(int[] ids);

    void deleteByIds(List<Integer> ids);
}
