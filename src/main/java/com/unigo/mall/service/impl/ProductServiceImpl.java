package com.unigo.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.unigo.mall.mapper.ProductMapper;
import com.unigo.mall.model.Product;
import com.unigo.mall.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
