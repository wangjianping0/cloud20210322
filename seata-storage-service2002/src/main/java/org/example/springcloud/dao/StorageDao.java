package org.example.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Classname StorageDao
 * @Description TODO
 * @Date 2021/6/8 10:20
 * @Created by wangjianping
 */
@Mapper
public interface StorageDao {
    public void decrease(@Param("productId") Long productId,@Param("count") Integer count) ;
}
