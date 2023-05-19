package com.unigo.mall.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.unigo.mall.model.base.BaseModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@TableName("product")
@Data
public class Product extends BaseModel {
    private String productName;
    private String productCover;
    private BigDecimal productPrice;
    private String productCategoryId;
    private String productDesc;
}
