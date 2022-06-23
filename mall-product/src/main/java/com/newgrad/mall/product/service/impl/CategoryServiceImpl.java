package com.newgrad.mall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.newgrad.common.utils.PageUtils;
import com.newgrad.common.utils.Query;

import com.newgrad.mall.product.dao.CategoryDao;
import com.newgrad.mall.product.entity.CategoryEntity;
import com.newgrad.mall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listithTree() {
        //1. get all catogories
        List<CategoryEntity> entities = baseMapper.selectList(null);
        //2. construct to parent and child structure

        //2.1. find all level 1
        List<CategoryEntity> level1Menus = new ArrayList<>();
        for (CategoryEntity entity : entities) {
            if (entity.getParentCid() == 0) level1Menus.add(entity);
        }
        Collections.sort(level1Menus, (a, b) -> {
            return (a.getSort() == null? 0 : a.getSort()) - (b.getSort() == null? 0 :b.getSort());
        });
        //2.2. recursively find the children categories.
        for (CategoryEntity entity: level1Menus) {
            List<CategoryEntity> ls = getChildrens(entity, entities);
            Collections.sort(ls, (a, b) -> {
                return (a.getSort() == null? 0 : a.getSort()) - (b.getSort() == null? 0 :b.getSort());
            });
            entity.setChildren(ls);
        }


        return level1Menus;
    }

    @Override
    public void logicalRemoveIfNoReferencing(List<Long> asList) {
        baseMapper.deleteBatchIds(asList);
    }

    @Override
    public Long[] findCatelogPath(Long catelogId) {
        List<Long> paths = new ArrayList<>();
        CategoryEntity curr = this.getById(catelogId);
        while (true) {
            paths.add(curr.getCatId());
            if (curr.getParentCid() == 0) break;
            curr = this.getById(curr.getParentCid());
        }

        Collections.reverse(paths);
        return (Long[]) paths.toArray(new Long[paths.size()]);
    }

    private List<CategoryEntity> getChildrens(CategoryEntity root, List<CategoryEntity> all) {
        List<CategoryEntity> list = new ArrayList<>();
        for (CategoryEntity entity : all) {
            if (entity.getParentCid().equals(root.getCatId())) {
                list.add(entity);
                List<CategoryEntity> tmp = getChildrens(entity, all);
                Collections.sort(tmp , (a, b) -> {
                    return (a.getSort() == null? 0 : a.getSort()) - (b.getSort() == null? 0 :b.getSort());
                });
                entity.setChildren(tmp);
            }
        }
        return list;
    }

}