package com.unigo.mall.controller.product.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductAddParamVo implements Serializable {
    private String productName;
    private String productIntro;
    private String productDesc;
    private String productCover;
    private String productPrice;
    private String memberPrice;
    private String productCategoryId;
}
