package com.unigo.mall.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.unigo.mall.common.PageResult;
import com.unigo.mall.controller.product.vo.ProductParamReq;
import com.unigo.mall.mapper.ProductMapper;
import com.unigo.mall.model.Product;
import com.unigo.mall.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
    @Override
    public PageResult<Product> listByPage(ProductParamReq productParamReq) {
        log.info(JSON.toJSONString(productParamReq));
        Page<Product> page = new Page<>(productParamReq.getPageNo(), productParamReq.getPageSize());
        LambdaQueryWrapper<Product> productQw = new LambdaQueryWrapper<Product>()
                .eq(Product::getProductCategoryId, productParamReq.getCategoryId())
                .like(StrUtil.isNotBlank(productParamReq.getProductName()), Product::getProductName, productParamReq.getProductName());
        Page<Product> productPage = page(page, productQw);
        return PageResult.of(productPage.getTotal(), productPage.getRecords());
    }
}
