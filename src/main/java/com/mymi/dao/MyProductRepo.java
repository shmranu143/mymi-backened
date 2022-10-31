package com.mymi.dao;

import com.mymi.MyProducts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyProductRepo extends JpaRepository<MyProducts, Integer> {
    List<MyProducts> findByType(String type);
}
