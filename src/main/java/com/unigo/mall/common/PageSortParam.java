package com.unigo.mall.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageSortParam implements Serializable {
    private static final Integer PAGE_NO = 1;
    private static final Integer PAGE_SIZE = 20;

    private Integer pageNo = PAGE_NO;

    private Integer pageSize = PAGE_SIZE;

    private String sort;
}
