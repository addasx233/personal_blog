package com.yamlapkei.dao.type_info;

import com.mysql.jdbc.StringUtils;
import com.yamlapkei.view.TypeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypeInfoDao {
    //id:主键 sort:排序用 name:分类名
    int update(@Param("id") String id, @Param("sort") String sort, @Param("name") String name);

    int insert(@Param("sort")String sort, @Param("name") String name);

    //    查询所有分类
    List<TypeInfo> findAllType();
}
