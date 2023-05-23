package com.unigo.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.unigo.mall.controller.category.vo.req.CategoryAddParamVo;
import com.unigo.mall.controller.category.vo.req.CategoryParamVo;
import com.unigo.mall.controller.category.vo.req.CategoryUpdateParamVo;
import com.unigo.mall.model.Category;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CategoryService extends IService<Category> {


    List<Category> list(CategoryParamVo categoryParamVo);

    boolean add(CategoryAddParamVo categoryAddParamVo);

    boolean update(CategoryUpdateParamVo categoryUpdateParamVo);
}
