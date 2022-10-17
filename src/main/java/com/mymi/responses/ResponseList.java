package com.mymi.responses;

import com.mymi.MyProducts;
import lombok.Data;

import java.util.List;

@Data
public class ResponseList {
    int code;
    String desc;
    List<MyProducts> data;
}
