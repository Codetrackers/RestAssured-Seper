package com.cydeo.Practice;

import com.cydeo.utilities.SpartanTestBase;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
public class p2 extends SpartanTestBase {


@DisplayName("test1")
    @Test
    public void test1(){
        Response response= given().accept(ContentType.JSON)
                .when()
                .get("/api/spartans")
                .then()
                .assertThat().statusCode(200)
                .contentType("application/json")
                .extract().response();
    //    System.out.println(response.getHeaders());
     //   System.out.println(response.getHeader("Date"));
      //  response.prettyPrint();

    }

    @DisplayName("test2")
    @Test
    public void test2() {
        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 7)
                .when()
                .get("/api/spartans/{id}")
                .then()
                .assertThat().statusCode(200)
                .contentType("application/json")
                .extract().response();
        response.prettyPrint();


    }




    @DisplayName("Allan")
    @Test
    public void test3() {
        Response response = given().accept(ContentType.JSON)
                .queryParam("nameContains","Allen")
                .when()
                .get("/api/spartans/search")
                .then()
                .assertThat().statusCode(200)
               // .contentType("application/json")
                .extract().response();
        response.prettyPrint();


    }


    @DisplayName("male")
    @Test
    public void test4() {
        Response response = given().accept(ContentType.JSON)
                .queryParam("gender","Male")
                .when()
                .get("/api/spartans/search")
                .then()
                .assertThat().statusCode(200)
                // .contentType("application/json")
                .extract().response();
        response.prettyPrint();


    }

    @DisplayName("Female Z")
    @Test
    public void test5() {
        Response response = given().accept(ContentType.JSON)
                .queryParam("gender","Female")
                .queryParam("nameContains","z")
                .when()
                .get("/api/spartans/search")
                .then()
                .assertThat().statusCode(200)
                // .contentType("application/json")
                .extract().response();
        response.prettyPrint();


    }


    @DisplayName("15")
    @Test
    public void test6() {
        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 15)
                .when()
                .get("/api/spartans/{id}")
                .then()
                .assertThat().statusCode(200)
                .contentType("application/json")
                .extract().response();
      //  System.out.println(response.getBody());
       //  System.out.println(response.path("name").toString());
        JsonPath jsonPath= response.jsonPath();
        System.out.println(jsonPath.getString("name"));


    }


    @DisplayName("last")
    @Test
    public void test7() {
        Response response = given().accept(ContentType.JSON)
                .when()
                .get("/api/spartans");
       // response.prettyPrint();
JsonPath jsonPath= response.jsonPath();
        System.out.println(jsonPath.getString("name[9]"));
        System.out.println(jsonPath.getString("gender[19]"));
        System.out.println(jsonPath.getInt("id[29]"));

    }

}
