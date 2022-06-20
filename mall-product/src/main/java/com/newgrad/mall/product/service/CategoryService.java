package com.newgrad.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.newgrad.common.utils.PageUtils;
import com.newgrad.mall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author yaokunwu
 * @email yaokun.wu.2017@gmail.com
 * @date 2022-06-16 22:26:01
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listithTree();

    void logicalRemoveIfNoReferencing(List<Long> asList);
}

