package com.mymi.service;

import com.mymi.model.MyProducts;
import com.mymi.dao.MyProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyProductServiceImpl implements MyProductService{

    @Autowired
    MyProductRepo repo;


    @Override
    public MyProducts createProduct(MyProducts product) {
        try{
            return repo.save(product);
//            return savedProd;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public MyProducts getProductById(int id) {
        try{
            if (repo.existsById(id)){
                Optional<MyProducts> prod = repo.findById(id);
                return prod.get();
            }
            else {
                System.out.println(id+" : does not exist");
                return null;
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<MyProducts> getProductsByType(String type) {
        List<MyProducts> list = repo.findByType(type);
        return list;
    }

    @Override
    public List<MyProducts> getAllProducts() {
        return repo.findAll();
//        return null;
    }
}
