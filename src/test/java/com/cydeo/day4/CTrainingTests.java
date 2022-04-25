package com.cydeo.day4;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class CTrainingTests {

    @BeforeAll
    public static void init() {
        RestAssured.baseURI = "http://api.cybertektraining.com";
    }
    //send a get request to student id 24103 as a path parameter and accept header application/json
    //verify status code=200
    // /content type=application/json;charset=UTF-8
    // /Content-Encoding = gzip
    //verify Date header exists
    //assert that
            /*
                firstName Karole
                batch 7
                major Master of Creative Arts
                emailAddress hassan.lebsack@hotmail.com
                companyName Legacy Integration Analyst
                street 6253 Willard Place
                zipCode 28524

                using JsonPath
             */

    @Test
    public void test1() {
        Response response = given()
                .accept(ContentType.JSON)
                .and().pathParam("id", 24103)
                .when().get("/student/{id}");


        JsonPath jsonPath = response.jsonPath();

        //verify status code=200
        assertEquals(200, response.statusCode());

        //header application/json
        assertEquals("application/json;charset=UTF-8", response.contentType());


        // /Content-Encoding = gzip
        assertEquals("gzip", response.getHeader("Content-Encoding"));


        //verify Date header exists
        assertTrue(response.headers().hasHeaderWithName("Date"));

        //firstName Karole
        assertEquals("Karole", jsonPath.get("students[0].firstName"));

        // batch 7
        assertEquals(7, (Integer) jsonPath.get("students[0].batch"));

        // major Master of Creative Arts
        assertEquals("Master of Creative Arts", jsonPath.get("students[0].major"));

        //emailAddress hassan.lebsack@hotmail.com
        assertEquals("hassan.lebsack@hotmail.com", jsonPath.get("students[0].contact.emailAddress"));

        //companyName Legacy Integration Analyst
        assertEquals("Legacy Integration Analyst", jsonPath.get("students[0].company.companyName"));

        // street 6253 Willard Place
        assertEquals("6253 Willard Place",jsonPath.get("students[0].company.address.street"));

         // zipCode 28524
        assertEquals(28524, (Integer) jsonPath.get("students[0].company.address.zipCode"));

    }
}