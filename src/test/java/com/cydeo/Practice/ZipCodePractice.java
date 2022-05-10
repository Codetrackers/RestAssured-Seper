package com.cydeo.Practice;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ZipCodePractice {

    @BeforeAll
    public static void bf() {
        RestAssured.baseURI = "http://api.zippopotam.us";
    }


    @Test
    public void q1() {
//Given Accept application/json
//And path zipcode is 22031
//When I send a GET request to /us endpoint
//Then status code must be 200
//And content type must be application/json
//And Server header is cloudflare
//And Report-To header exists
//And body should contains following information
//    post code is 22031
//    country  is United States
//    country abbreviation is US
//    place name is Fairfax
//    state is Virginia
//    latitude is 38.8604


        Response response = given().accept(ContentType.JSON).and()

                .pathParam("zipcode", 22031)
                .get("/us/{zipcode}")


                //Then status code must be 200
                //And content type must be application/json
                .then()
                .statusCode(200).contentType("application/json")

                //And Server header is cloudflare
                .header("Server", "cloudflare")

                //And Report-To header exists
                .header("Report-To", notNullValue())
                .body("'post code'", is("22031"))
                .body("country", is("United States"))
                .body("'country abbreviation'", equalTo("US"))
                .body("places[0].'place name'", is("Fairfax"))
                .body("places[0].state", is("Virginia"))
                .body("places[0].latitude", is("38.8604"))
                .extract().response();
    }

    @Test
    public void q2() {
//Given Accept application/json
//And path zipcode is 50000
//When I send a GET request to /us endpoint
//Then status code must be 404
//And content type must be application/json

        Response response = given().accept(ContentType.JSON)
                .pathParams("zipcode", 50000)
                .get("/us/{zipcode}").then()
                .statusCode(404).contentType("application/json").extract().response();

    }

    @Test
    public void q3() {
        //Given Accept application/json
        //And path state is va
        //And path city is farifax
        //When I send a GET request to /us endpoint
        //Then status code must be 200
        //And content type must be application/json
        //And payload should contains following information
        //    country abbreviation is US
        //    country  United States
        //    place name  Fairfax
        //    each places must contains fairfax as a value
        //    each post code must start with 22

        Response response = given().accept(ContentType.JSON)
                .pathParam("state", "va")
                .pathParams("city", "fairfax")
                .get("/us/{state}/{city}").then()
                .statusCode(200)
                .contentType("application/json").and()
                .assertThat().body("'country abbreviation'", equalTo("US"))
                .body("'country'", equalTo("United States"))
                .body("'place name'", equalTo("Fairfax"))
                .body("places.'place name'", everyItem(containsString("Fairfax"))
                        , "places.'post code'", everyItem(startsWith("22")))


                .extract().response();


    }


}
