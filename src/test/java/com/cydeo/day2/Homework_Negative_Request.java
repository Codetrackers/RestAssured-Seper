package com.cydeo.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Homework_Negative_Request {
    @BeforeAll
    public static void inti() {
        RestAssured.baseURI = "http://3.84.108.13:8000";
    }

    /*TASK
   Given Accept type application/xml
   When user send GET request to /api/spartans/10 end point
   Then status code must be 406
   And response Content Type must be application/xml;charset=UTF-8;
   */
    @DisplayName("Spartan code 406")
    @Test
    public void test4() {
        //Given Accept type application/xml
        Response response = RestAssured
        .given().accept(ContentType.XML).when()

        // When user send GET request to /api/spartans/10 end point
        .get("/api/spartans/10 end point");

        // Then status code must be 406
        Assertions.assertEquals(406, response.statusCode());


        // And response Content Type must be application/xml;charset=UTF-8;
        Assertions.assertEquals("application/xml;charset=UTF-8", response.contentType());


    }


}
