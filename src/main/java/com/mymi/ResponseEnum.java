package com.mymi;

public enum ResponseEnum {

    SUCCESS(1,"success"),
    PENDING(2,"pending"),
    FAILED(3,"failed"),

    EXCEPTION(4,"EXCEPTION OCCURED WHILE ADDING DATA INTO TABLE");

    int code;
    String desc;

    ResponseEnum(int code,String desc){
        this.code=code;
        this.desc=desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
