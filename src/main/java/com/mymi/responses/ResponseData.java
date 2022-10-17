package com.mymi.responses;

import com.mymi.MyProducts;
import lombok.Data;

@Data
public class ResponseData {
    int code;
    String desc;
    MyProducts data;
}
