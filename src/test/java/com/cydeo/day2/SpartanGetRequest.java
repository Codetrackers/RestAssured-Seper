package com.cydeo.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpartanGetRequest {
   String url="http://3.84.108.13:8000";


 /*
        Given Accept type is application/json
        When user send GET request to  /api/spartans end point
        Then status code must be 200
        And response content type must be application/json
     */

   @Test
    public void test1(){


       Response response = RestAssured.
               given().
               accept(ContentType.JSON)
               .when()
               .get(url + "/api/spartans");
       //print the status code
       System.out.println("response.statusCode() = " + response.statusCode());
       //print the content type
       System.out.println("response.contentType() = " + response.contentType());

       //how to test API ?
       //verify status code is 200
       Assertions.assertEquals(200,response.statusCode());

       //verify content type is application json
       Assertions.assertEquals("application/json",response.contentType());





   }
}
