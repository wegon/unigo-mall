package com.unigo.mall.controller.category.vo.req;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryParamVo implements Serializable {
    private String categoryId;

    private String categoryName;

    private String categoryPath;
}
