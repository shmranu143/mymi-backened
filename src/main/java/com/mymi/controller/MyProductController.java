package com.mymi.controller;

import com.mymi.MyProducts;
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
@RequestMapping("/home")
public class MyProductController {

    @Autowired
    MyProductServiceImpl service;

    @PostMapping("/save")
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

    @GetMapping("/get")
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
    @GetMapping("/get/{id}")
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
    @GetMapping("/getall")
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
