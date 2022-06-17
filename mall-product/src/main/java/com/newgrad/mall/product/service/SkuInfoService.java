package com.newgrad.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.newgrad.common.utils.PageUtils;
import com.newgrad.mall.product.entity.SkuInfoEntity;

import java.util.Map;

/**
 * sku信息
 *
 * @author yaokunwu
 * @email yaokun.wu.2017@gmail.com
 * @date 2022-06-16 23:22:28
 */
public interface SkuInfoService extends IService<SkuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

