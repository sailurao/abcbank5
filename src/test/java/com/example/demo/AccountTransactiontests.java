package com.example.demo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestPropertySource;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.put;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

//import org.junit.Test;
//import org.junit.runner.RunWith;

public class AccountTransactiontests {

    @Test
            void MyTest() {

        get("http://localhost:9090/transactions")
                .then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(2));

      /* get("http://localhost:9090/transactions/1")
                .then()
                .assertThat()
               .statusCode(200)
                .body("accountId", Matchers.equalTo(1));*/
          }
   /*@Test
    public void MyTes() {
        String str="{\"accountId\":5,\"transactionNumber\":1,\"transactionDate\": \"2010-11-11 00:00:00\",\"transactionAccount\": \"1000\",\"transactionType\": \"deposit\",\"loanId\": \"1\",\"payeeId\": \"1\",\"accountBalence\": \"\"}";
        String Resp = given().
                header("Content-Type", "application/json; charset=utf-8").
                body(str).
                when().
                post("http://localhost:9090/transactions").
                then().assertThat().
                statusCode(200).
                extract().
                response().asString();

    }
   /* @Test
    public void MyTest1() {
        String Resp=given().
                when().
                delete("http://localhost:9090/transactions/2").
                then().assertThat().
                statusCode(200).
                extract().
                response().asString();

    }*/
    }





