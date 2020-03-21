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

public class UsertableTests {

   @Test
            void MyTests() {

       get("http://localhost:9090/users")
               .then()
               .assertThat()
               .statusCode(200)
               .body("size()", is(2));

   }
        /*get("http://localhost:9090/users/2")
                .then()
                .assertThat()
                .statusCode(200)
                .body("user_id", Matchers.equalTo(2));

        get("http://localhost:9090/users/2")
                .then()
                .assertThat()
                .statusCode(200)
                .body("first_name", Matchers.equalTo("Naga_Saradha"));


    }

    @Test
    public void MyTest2()
    {

        String Resp=given().
                header("Content-Type","application/json; charset=utf-8").
                body("{\"user_id\":2,\"first_name\":\"saradha bandla\",\"last_name\":\"vuppala\",\"password\":\"27sru442\",\"email\":\"srujana42@gmail.com\",\"mobile_number\":\"31\",\"middle_name\":\"\"}").
                when().
                put("http://localhost:9090/users/2").
                then().assertThat().
                statusCode(200).
                extract().
                response().asString();



    @Test
    public void MyTest() {
        String str="{\"user_id\":5,\"first_name\":\"Naga\",\"last_name\":\"Am\",\"password\":\"27sru442\",\"email\":\"srujana42@gmail.com\",\"mobile_number\":\"31\",\"middle_name\":\"\"}";
        String Resp = given().
                header("Content-Type", "application/json; charset=utf-8").
                body(str).
                when().
                post("http://localhost:9090/users").
                then().assertThat().
                statusCode(200).
                extract().
                response().asString();

    }
    @Test
            public void MyTest1() {
        String Resp=given().
                when().
               delete("http://localhost:9090/users/5").
                then().assertThat().
                statusCode(200).
                extract().
                response().asString();*/

    }

