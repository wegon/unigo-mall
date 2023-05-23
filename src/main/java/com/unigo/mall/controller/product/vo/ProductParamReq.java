package com.unigo.mall.controller.product.vo;

import com.unigo.mall.common.PageSortParam;
import lombok.Data;

@Data
public class ProductParamReq extends PageSortParam {
    private String productName;
    private String categoryId;
}
