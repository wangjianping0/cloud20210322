package org.example.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Classname AccountDao
 * @Description TODO
 * @Date 2021/6/7 18:58
 * @Created by wangjianping
 */
@Mapper
public interface AccountDao {

    void decrease(@Param("userId") Long userId,@Param("count") BigDecimal count);
}
