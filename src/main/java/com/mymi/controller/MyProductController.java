package com.mymi.controller;

import com.mymi.model.MyProducts;
import com.mymi.ResponseEnum;
import com.mymi.responses.Response;
import com.mymi.responses.ResponseData;
import com.mymi.responses.ResponseList;
import com.mymi.service.MyProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class MyProductController {

    @Autowired
    MyProductServiceImpl service;

    @GetMapping("/")
    public Response welcome(){
        return new Response(ResponseEnum.SUCCESS.getCode(), "Welcome to my mi.com ");
    }

    @GetMapping("/ad/msg")
    public Response welcomeAdmin(){
        return new Response(ResponseEnum.SUCCESS.getCode(), "Welcome to my mi.com admin");
    }
    @GetMapping("/us/msg")
    public Response welcomeUser(){
        return new Response(ResponseEnum.SUCCESS.getCode(), "Welcome to my mi.com ");
    }
    @PostMapping("/ad/save")
    public Response AddProduct(@RequestBody MyProducts product){
        Response response = new Response();
        try{
            MyProducts products =  service.createProduct(product);
            if (Objects.nonNull(products)){
                response.setCode(ResponseEnum.SUCCESS.getCode());
                response.setDesc(ResponseEnum.SUCCESS.getDesc());
            }
            else {
                response.setCode(ResponseEnum.FAILED.getCode());
                response.setDesc(ResponseEnum.FAILED.getDesc());
            }
        } catch (Exception e){
            e.printStackTrace();
            response.setCode(ResponseEnum.EXCEPTION.getCode());
            response.setDesc(ResponseEnum.EXCEPTION.getDesc());
        }
        return response;
    }

    @GetMapping("/us/get")
    public ResponseList getListByType(@RequestParam String type){
        ResponseList response = new ResponseList();
        try{
            List<MyProducts> list = service.getProductsByType(type);
            if (!list.isEmpty()){
                response.setCode(ResponseEnum.SUCCESS.getCode());
                response.setDesc(ResponseEnum.SUCCESS.getDesc());
                response.setData(list);
            } else {
                response.setCode(ResponseEnum.FAILED.getCode());
                response.setDesc(ResponseEnum.FAILED.getDesc());
            }
        } catch (Exception e){
            e.printStackTrace();
            response.setCode(ResponseEnum.EXCEPTION.getCode());
            response.setDesc(ResponseEnum.EXCEPTION.getDesc());
        }
        return response;
    }
    @GetMapping("/us/get/{id}")
    public ResponseData getDeviceInfoBySkuId(@PathVariable int id){
        ResponseData response = new ResponseData();
        try{
            MyProducts product= service.getProductById(id);
            if (Objects.nonNull(product)){
                response.setCode(ResponseEnum.SUCCESS.getCode());
                response.setDesc(ResponseEnum.SUCCESS.getDesc());
                response.setData(product);
            }
            else {
                response.setCode(ResponseEnum.FAILED.getCode());
                response.setDesc(ResponseEnum.FAILED.getDesc());
            }
        } catch (Exception e){
            e.printStackTrace();
            response.setCode(ResponseEnum.EXCEPTION.getCode());
            response.setDesc(ResponseEnum.EXCEPTION.getDesc());
        }
        return response;
    }
    @GetMapping("/us/getall")
    public ResponseList getAllProducts(){
        ResponseList response = new ResponseList();
        try{
            List<MyProducts> list= service.getAllProducts();
            if (!list.isEmpty()){
                response.setCode(ResponseEnum.SUCCESS.getCode());
                response.setDesc(ResponseEnum.SUCCESS.getDesc());
                response.setData(list);
            } else {
                response.setCode(ResponseEnum.FAILED.getCode());
                response.setDesc(ResponseEnum.FAILED.getDesc());
            }
        } catch ( Exception e){
            e.printStackTrace();
            response.setCode(ResponseEnum.EXCEPTION.getCode());
            response.setDesc(ResponseEnum.EXCEPTION.getDesc());
        }
        return response;
    }

}
