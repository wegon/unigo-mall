package com.unigo.mall.controller.category.vo.req;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryUpdateParamVo implements Serializable {
    private String id;
    private String name;
    private String cover;
    private String parentId;
}
