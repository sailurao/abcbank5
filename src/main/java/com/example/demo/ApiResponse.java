package com.example.demo;
//By NAGA - https://github.com/only2dhir/spring-boot-rest/blob/master/src/main/java/com/devglan/model/ApiResponse.java
public class ApiResponse<T> {



    private Object result;



    public ApiResponse( Object result) {

        this.result = result;
    }



    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
