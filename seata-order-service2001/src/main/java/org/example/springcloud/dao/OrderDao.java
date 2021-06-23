package org.example.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.springcloud.domain.Order;

/**
 * @Classname OrderDao
 * @Description TODO
 * @Date 2021/6/7 16:15
 * @Created by wangjianping
 */
@Mapper
public interface OrderDao {
    //新建订单
    void create(Order order);
    //修改订单状态
    void update(@Param("userId")Long userId,@Param("status")Integer status);

}
