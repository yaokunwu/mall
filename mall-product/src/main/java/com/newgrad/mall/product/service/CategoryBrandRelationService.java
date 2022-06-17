package com.newgrad.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.newgrad.common.utils.PageUtils;
import com.newgrad.mall.product.entity.CategoryBrandRelationEntity;

import java.util.Map;

/**
 * 品牌分类关联
 *
 * @author yaokunwu
 * @email yaokun.wu.2017@gmail.com
 * @date 2022-06-16 22:26:01
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

