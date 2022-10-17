package com.mymi.dao;

import com.mymi.MyProducts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyProductRepo extends JpaRepository<MyProducts, Integer> {

}
