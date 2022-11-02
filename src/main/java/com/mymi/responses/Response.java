package com.mymi.responses;

import lombok.Data;

@Data
public class Response {
    int code;
    String desc;

    public Response(){

    }
    public Response(int code , String desc){
        this.code = code;
        this.desc = desc;
    }
}

