package com.unigo.mall.controller.product;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.unigo.mall.common.ApiResult;
import com.unigo.mall.common.PageResult;
import com.unigo.mall.controller.product.vo.ProductParamReq;
import com.unigo.mall.model.Product;
import com.unigo.mall.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/list")
    public ApiResult<List<Product>> list() {
        return ApiResult.ok(productService.list());
    }

    @PostMapping("/product/list-by-page")
    public ApiResult<PageResult<Product>> listByPage(@RequestBody ProductParamReq productParamReq) {
        log.info(JSON.toJSONString(productParamReq));
        Page<Product> page = new Page<>(productParamReq.getPageNo(), productParamReq.getPageSize());
        Page<Product> productPage = productService.page(page);
        return ApiResult.ok(PageResult.of(productPage.getTotal(), productPage.getRecords()));
    }

    @GetMapping("/product/add")
    public ApiResult add() {
        Product product = new Product();
        product.setProductName("hahahssss");
        product.setProductDesc("VVSS");
        productService.save(product);
        return ApiResult.ok();
    }
}
