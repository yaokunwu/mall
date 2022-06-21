package com.newgrad.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

//import javax.validation.constraints.*;
import com.newgrad.common.valid.AddGroup;
import com.newgrad.common.valid.ListValue;
import com.newgrad.common.valid.UpdateGroup;
import com.newgrad.common.valid.UpdateStatusGroup;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;

/**
 * 品牌
 * 
 * @author yaokunwu
 * @email yaokun.wu.2017@gmail.com
 * @date 2022-06-16 22:26:01
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@NotNull(message = "updating must specify id", groups={UpdateGroup.class})
	@Null(message = "Adding can not specify id", groups={AddGroup.class})
	@TableId
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotBlank(message = "Brand name must not be blank", groups={AddGroup.class, UpdateGroup.class})
	private String name;
	/**
	 * 品牌logo地址
	 */
	@URL(message = "logo must a valid url address", groups={AddGroup.class})
	@NotBlank(groups={AddGroup.class})
	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	@NotNull(groups={AddGroup.class, UpdateStatusGroup.class})
	@ListValue(vals={0, 1}, groups={AddGroup.class, UpdateStatusGroup.class})
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	@NotEmpty(groups={AddGroup.class})
	@Pattern(regexp = "^[a-zA-Z]$", message = "Only one character is allowed", groups={AddGroup.class,UpdateGroup.class})
	private String firstLetter;
	/**
	 * 排序
	 */
	@NotNull(groups={AddGroup.class})
	@Min(value=0,message = "sort is at least 0", groups={AddGroup.class,UpdateGroup.class})
	private Integer sort;

}
