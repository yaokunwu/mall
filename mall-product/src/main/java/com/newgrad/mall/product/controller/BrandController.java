package com.newgrad.mall.product.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.newgrad.common.valid.AddGroup;
import com.newgrad.common.valid.UpdateGroup;
import com.newgrad.common.valid.UpdateStatusGroup;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newgrad.mall.product.entity.BrandEntity;
import com.newgrad.mall.product.service.BrandService;
import com.newgrad.common.utils.PageUtils;
import com.newgrad.common.utils.R;

import javax.validation.Valid;


//import javax.validation.Valid;


/**
 * 品牌
 *
 * @author yaokunwu
 * @email yaokun.wu.2017@gmail.com
 * @date 2022-06-16 22:26:01
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = brandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    public R info(@PathVariable("brandId") Long brandId){
		BrandEntity brand = brandService.getById(brandId);

        return R.ok().put("brand", brand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody @Validated({AddGroup.class}) BrandEntity brand){
//        if (result.hasErrors()) {
//            Map<String, String> map = new HashMap<>();
//            System.out.println("The result has error");
//            result.getFieldErrors().forEach((item) ->{
//                String defaultMessage = item.getDefaultMessage();
//                String field = item.getField();
//                map.put(field, defaultMessage);
//            });
//            return R.error(400, "Data format illegal").put("data", map);
//
//        } else {
            brandService.save(brand);
            return R.ok();
//        }
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody @Validated({UpdateGroup.class}) BrandEntity brand){
		brandService.updateById(brand);

        return R.ok();
    }

    /**
     * 修改状态
     */
    @RequestMapping("/update/status")
    public R updateStatus(@RequestBody @Validated({UpdateStatusGroup.class}) BrandEntity brand){
        brandService.updateById(brand);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] brandIds){
		brandService.removeByIds(Arrays.asList(brandIds));

        return R.ok();
    }

}
