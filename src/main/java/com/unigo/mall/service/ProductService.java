package com.unigo.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.unigo.mall.common.PageResult;
import com.unigo.mall.controller.product.vo.ProductParamReq;
import com.unigo.mall.model.Product;

public interface ProductService extends IService<Product> {

    PageResult<Product> listByPage(ProductParamReq productParamReq);
}
