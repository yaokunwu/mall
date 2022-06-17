package com.newgrad.mall.warehouse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.newgrad.common.utils.PageUtils;
import com.newgrad.mall.warehouse.entity.WareOrderTaskEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author yaokunwu
 * @email yaokun.wu.2017@gmail.com
 * @date 2022-06-17 14:23:27
 */
public interface WareOrderTaskService extends IService<WareOrderTaskEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

