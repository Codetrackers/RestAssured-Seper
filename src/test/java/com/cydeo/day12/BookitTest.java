package com.cydeo.day12;
import com.cydeo.utilities.ExcelUtil;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class BookitTest {

//create a method to read bookitqa3 excel file information
//use those information as an email and password to send a get request to /sign endpoint
//verify you got 200 for each request
//print accesstoken for each request
//https://cybertek-reservation-api-qa3.herokuapp.com



    public static  List<Map<String,String>>  getExcelData(){
        ExcelUtil bookItFile= new ExcelUtil("src/test/resources/BookItQa3.xlsx","QA3");
        return bookItFile.getDataList();


    }


    @ParameterizedTest
    @MethodSource("getExcelData")
    public void BookitTest(Map<String,String> userinfo){
        System.out.println("userinfo.get(\"email\") = " + userinfo.get("email"));
        System.out.println("userinfo.get(\"password\") = " + userinfo.get("password"));
        given().
                baseUri("https://cybertek-reservation-api-qa3.herokuapp.com")
                .accept(ContentType.JSON)
                .and()
                .queryParams(userinfo)
                .when()
                .get("/sign")
                .then().statusCode(200).log().all();

    }


}