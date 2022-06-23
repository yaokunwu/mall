package com.newgrad.mall.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.newgrad.mall.product.entity.BrandEntity;
import com.newgrad.mall.product.service.BrandService;
import com.newgrad.mall.product.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

@SpringBootTest
class MallProductApplicationTests {
    @Autowired
    BrandService brandService;

    @Autowired
    CategoryService categoryService;

    @Test
    public void testFindPath() {
        Long[] catelogPath = categoryService.findCatelogPath(225L);
        for (Long id : catelogPath) System.out.println(id);
    }

    @Test
    void contextLoads() {
//        BrandEntity brandEntity = new BrandEntity();
//        brandEntity.setBrandId(1L);
//        brandEntity.setDescript("google description test");
//        brandEntity.setName("Google");
//        brandService.save(brandEntity);
//        System.out.println("save successfully");
//        brandService.updateById(brandEntity);
        List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 1L));
        for (BrandEntity entity : list) {
            System.out.println(entity);
        }
    }





}
