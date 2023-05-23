package com.unigo.mall.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.unigo.mall.constant.CommonConst;
import com.unigo.mall.controller.category.vo.req.CategoryAddParamVo;
import com.unigo.mall.controller.category.vo.req.CategoryParamVo;
import com.unigo.mall.controller.category.vo.req.CategoryUpdateParamVo;
import com.unigo.mall.exception.CommonException;
import com.unigo.mall.mapper.CategoryMapper;
import com.unigo.mall.model.Category;
import com.unigo.mall.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Override
    public List<Category> list(CategoryParamVo categoryParamVo) {
        if (StrUtil.isNotBlank(categoryParamVo.getCategoryId())) {
            Category category = getById(categoryParamVo.getCategoryId());
            if (Objects.nonNull(category)) {
                categoryParamVo.setCategoryPath(category.getPath());
            }
        }
        LambdaQueryWrapper<Category> categoryQw = new LambdaQueryWrapper<Category>()
                .likeRight(StrUtil.isNotBlank(categoryParamVo.getCategoryPath()), Category::getPath, categoryParamVo.getCategoryPath() + CommonConst.VERTICAL_BAR)
                .like(StrUtil.isNotBlank(categoryParamVo.getCategoryName()), Category::getName, categoryParamVo.getCategoryName());
        return list(categoryQw);
    }

    @Override
    public boolean add(CategoryAddParamVo categoryAddParamVo) {
        if (StrUtil.isBlank(categoryAddParamVo.getName())) {
            throw new CommonException("分类名称不能为空。");
        }

        String categoryPath = "";
        if (StrUtil.isNotBlank(categoryAddParamVo.getParentId())) {
            Category parentCategory = getById(categoryAddParamVo.getParentId());
            if (Objects.isNull(parentCategory)) {
                throw new CommonException("上级分类错误。");
            }
            categoryPath = parentCategory.getPath();
        } else {
            categoryAddParamVo.setParentId("");
        }

        // 校验同层级名称是否重复
        if (StrUtil.isNotBlank(categoryAddParamVo.getName())) {
            LambdaQueryWrapper<Category> caWq = new LambdaQueryWrapper<Category>()
                    .eq(Category::getName, categoryAddParamVo.getName())
                    .eq(Category::getParentId, categoryAddParamVo.getParentId());
            if (count(caWq) >= 1) {
                throw new CommonException("分类名称不能重复。");
            }
        }

        Category category = new Category();
        category.setName(categoryAddParamVo.getName());
        category.setCover(categoryAddParamVo.getCover());
        category.setParentId(categoryAddParamVo.getParentId());
        save(category);

        if (StrUtil.isBlank(categoryPath)) {
            category.setPath(category.getId());
        } else {
            category.setPath(categoryPath + CommonConst.VERTICAL_BAR + category.getId());
        }
        updateById(category);

        return true;
    }

    @Override
    public boolean update(CategoryUpdateParamVo categoryUpdateParamVo) {
        if (StrUtil.isBlank(categoryUpdateParamVo.getId())) {
            throw new CommonException("id不能为空");
        }
        if (StrUtil.isBlank(categoryUpdateParamVo.getName())) {
            throw new CommonException("分类名称不能为空。");
        }
        Category category = getById(categoryUpdateParamVo.getId());
        if (Objects.isNull(category)) {
            throw new CommonException("分类不存在。");
        }
        String categoryPath = category.getPath();

        String parentId = categoryUpdateParamVo.getParentId();
        if (StrUtil.isBlank(parentId)) {
            parentId = category.getParentId();
        } else {
            Category newParentCategory = getById(parentId);
            if (Objects.isNull(newParentCategory)) {
                throw new CommonException("上级层级不存在。");
            }

            categoryPath = newParentCategory.getPath() + CommonConst.VERTICAL_BAR + categoryUpdateParamVo.getId();
        }

        LambdaQueryWrapper<Category> existCategoryQw = new LambdaQueryWrapper<Category>()
                .eq(Category::getName, categoryUpdateParamVo.getName())
                .eq(Category::getParentId, parentId)
                .ne(Category::getId, categoryUpdateParamVo.getId());
        if (count(existCategoryQw) >= 1) {
            throw new CommonException("分类名称不能重复。");
        }

        category = new Category();
        category.setId(categoryUpdateParamVo.getId());
        category.setName(categoryUpdateParamVo.getName());
        category.setParentId(parentId);
        category.setPath(categoryPath);
        updateById(category);

        return true;
    }
}
