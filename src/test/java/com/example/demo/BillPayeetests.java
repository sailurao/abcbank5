package com.example.demo;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.is;

public class BillPayeetests {
    @Test
    void MyTest() {

        get("http://localhost:9090/billpayees")
                .then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(5));
    }

       /* get("http://localhost:9090/billpayees/1")
                .then()
                .assertThat()
                .statusCode(200)
                .body("payeeId", Matchers.equalTo(1));*/


    /*@Test
    public void MyTes() {
        String str = "{\"payeeId\":5,\"userId\":4,\"payeeAccountNumber\":\"222\",\"payeeAddress\":\"222,abc colony\",\"payeePhone\":\"22222\"}";
        String Resp = given().
                header("Content-Type", "application/json; charset=utf-8").
                body(str).
                when().
                post("http://localhost:9090/billpayees").
                then().assertThat().
                statusCode(200).
                extract().
                response().asString();
    }*/


   /* @Test
    public void MyTest1() {
        String Resp=given().
                when().
                delete("http://localhost:9090/billpayees/4").
                then().assertThat().
                statusCode(200).
                extract().
                response().asString();

    }*/



}
