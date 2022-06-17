package com.newgrad.mall.product.dao;

import com.newgrad.mall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author yaokunwu
 * @email yaokun.wu.2017@gmail.com
 * @date 2022-06-16 22:26:01
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
