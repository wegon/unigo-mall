package com.unigo.mall.controller.category;

import com.unigo.mall.common.ApiResult;
import com.unigo.mall.controller.category.vo.req.CategoryAddParamVo;
import com.unigo.mall.controller.category.vo.req.CategoryParamVo;
import com.unigo.mall.controller.category.vo.req.CategoryUpdateParamVo;
import com.unigo.mall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @GetMapping("category/list")
    public ApiResult list(@RequestBody CategoryParamVo categoryParamVo) {
        return ApiResult.ok(categoryService.list(categoryParamVo));
    }

    @PostMapping("category/add")
    public ApiResult add(@RequestBody CategoryAddParamVo categoryAddParamVo) {
        return ApiResult.ok(categoryService.add(categoryAddParamVo));
    }

    @PostMapping("category/update")
    public ApiResult update(@RequestBody CategoryUpdateParamVo categoryUpdateParamVo) {
        return ApiResult.ok(categoryService.update(categoryUpdateParamVo));
    }
}
