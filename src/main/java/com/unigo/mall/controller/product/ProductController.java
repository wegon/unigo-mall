package com.unigo.mall.controller.product;

import com.unigo.mall.common.ApiResult;
import com.unigo.mall.common.PageResult;
import com.unigo.mall.controller.common.vo.IdParamVo;
import com.unigo.mall.controller.product.vo.ProductAddParamVo;
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
        return ApiResult.ok(productService.listByPage(productParamReq));
    }

    @GetMapping("/product/get")
    public ApiResult getDetail(@RequestBody IdParamVo idParamVo) {
        return ApiResult.ok(productService.getById(idParamVo.getId()));
    }

    @GetMapping("/product/add")
    public ApiResult add(@RequestBody ProductAddParamVo productAddParamVo) {
        Product product = new Product();
        product.setProductName("hahahssss");
        product.setProductDesc("VVSS");
        productService.save(product);
        return ApiResult.ok();
    }
}
