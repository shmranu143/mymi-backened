package com.mymi.responses;

import lombok.Data;

@Data
public class ResponseLong {
    int code;
    String desc;
    int data;
}