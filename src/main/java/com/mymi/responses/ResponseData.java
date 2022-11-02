package com.mymi.responses;

import com.mymi.model.MyProducts;
import lombok.Data;

@Data
public class ResponseData {
    int code;
    String desc;
    MyProducts data;
}
