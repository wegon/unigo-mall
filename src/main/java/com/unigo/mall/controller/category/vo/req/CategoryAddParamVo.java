package com.unigo.mall.controller.category.vo.req;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryAddParamVo implements Serializable {
    private String name;
    private String parentId;
    private String cover;
}
