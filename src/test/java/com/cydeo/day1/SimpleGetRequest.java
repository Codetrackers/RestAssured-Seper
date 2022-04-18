package com.cydeo.day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class SimpleGetRequest {

@Test
    public void test1(){

    String url="http://3.84.108.13:8000/v3/api-docs";
    //send a get request and save response inside the Response object
    Response response = RestAssured.get(url);
    //print response status code
    System.out.println("response.statusCode() = " + response.statusCode());

    //print response body
    response.prettyPrint();

}
}
