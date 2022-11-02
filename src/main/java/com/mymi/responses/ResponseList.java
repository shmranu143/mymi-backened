package com.mymi.responses;

import com.mymi.model.MyProducts;
import lombok.Data;

import java.util.List;

@Data
public class ResponseList {
    int code;
    String desc;
    List<MyProducts> data;
}
