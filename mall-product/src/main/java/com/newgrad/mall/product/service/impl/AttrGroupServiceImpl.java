package com.newgrad.mall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.newgrad.common.utils.PageUtils;
import com.newgrad.common.utils.Query;

import com.newgrad.mall.product.dao.AttrGroupDao;
import com.newgrad.mall.product.entity.AttrGroupEntity;
import com.newgrad.mall.product.service.AttrGroupService;
import org.springframework.util.StringUtils;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long catelogId) {
        String key = (String) params.get("key");
        QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<>();
        // key不为空
        if (!StringUtils.isEmpty(key)) {
            wrapper.and((obj) ->
                    obj.eq("attr_group_id", key).or().like("attr_group_name", key)
            );
        }
        if (catelogId != 0){
            // 增加id信息
            wrapper.eq("catelog_id", catelogId);
        }
        IPage<AttrGroupEntity> page =
                this.page(new Query<AttrGroupEntity>().getPage(params),
                        wrapper);
        return new PageUtils(page);
    }

}