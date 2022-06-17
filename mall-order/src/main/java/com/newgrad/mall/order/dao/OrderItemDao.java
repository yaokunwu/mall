package com.newgrad.mall.order.dao;

import com.newgrad.mall.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author yaokunwu
 * @email yaokun.wu.2017@gmail.com
 * @date 2022-06-17 14:06:39
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
