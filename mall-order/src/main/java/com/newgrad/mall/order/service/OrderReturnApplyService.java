package com.newgrad.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.newgrad.common.utils.PageUtils;
import com.newgrad.mall.order.entity.OrderReturnApplyEntity;

import java.util.Map;

/**
 * 订单退货申请
 *
 * @author yaokunwu
 * @email yaokun.wu.2017@gmail.com
 * @date 2022-06-17 14:06:39
 */
public interface OrderReturnApplyService extends IService<OrderReturnApplyEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

