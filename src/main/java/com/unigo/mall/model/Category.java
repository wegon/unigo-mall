package com.unigo.mall.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.unigo.mall.model.base.BaseModel;
import lombok.Data;
import lombok.ToString;

@TableName("category")
@Data
@ToString
public class Category extends BaseModel {
    private String name;
    private String parentId;
    private String path;
    private String cover;
}
