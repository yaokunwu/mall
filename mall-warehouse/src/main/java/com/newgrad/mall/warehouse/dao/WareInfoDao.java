package com.newgrad.mall.warehouse.dao;

import com.newgrad.mall.warehouse.entity.WareInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 仓库信息
 * 
 * @author yaokunwu
 * @email yaokun.wu.2017@gmail.com
 * @date 2022-06-17 14:23:27
 */
@Mapper
public interface WareInfoDao extends BaseMapper<WareInfoEntity> {
	
}
