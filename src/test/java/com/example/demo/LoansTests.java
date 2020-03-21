package com.example.demo;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.is;

public class LoansTests {
    @Test
    void MyTests() {

        get("http://localhost:9090/loans")
                .then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(3));

    }



}
