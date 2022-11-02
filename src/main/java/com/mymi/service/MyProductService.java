package com.mymi.service;

import com.mymi.model.MyProducts;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MyProductService {

    public MyProducts createProduct(MyProducts product);

    public MyProducts getProductById(int id);

    public List<MyProducts> getProductsByType(String type);

    public List<MyProducts>  getAllProducts();
}
