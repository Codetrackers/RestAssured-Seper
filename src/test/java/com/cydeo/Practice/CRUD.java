package com.cydeo.Practice;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

import com.cydeo.pojo.Spartan7000;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.LinkedHashMap;
import java.util.Map;

public class CRUD {
     /*As a homework,write a detailed test for Role Base Access Control(RBAC)
            in Spartan Auth app (7000)
            Admin should be able take all CRUD
            Editor should be able to take all CRUD
                other than DELETE
            User should be able to only READ data-->user user
                not update,delete,create (POST,PUT,PATCH,DELETE)
       --------------------------------------------------------
        Can guest even read data ? 401 for all*/

    @BeforeAll
    public static void url() {
        RestAssured.baseURI = "http://44.201.121.105:7000/";
    }

    @DisplayName("get")
    @Test
    public void test1() {
        Response response = given().accept(ContentType.JSON)
                .auth().basic("admin", "admin")
                .when().get("/api/spartans")
                .then().assertThat().statusCode(200)
                .extract().response();
        response.prettyPrint();
    }

    @DisplayName("post")
    @Test
    public void test2() {

        Spartan7000 spartan = new Spartan7000();
        spartan.setGender("Male");
        spartan.setName("Rudy");
        spartan.setPhone(9876543210L);

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .auth().basic("admin", "admin")
                .body(spartan)
                .when().post("/api/spartans")
                .then().assertThat().statusCode(201)
                .extract().response();
        response.prettyPrint();
    }
    @DisplayName("put")
    @Test
    public void test3() {

        Spartan7000 spartan = new Spartan7000();
        spartan.setGender("Female");
        spartan.setName("Kimia");
        spartan.setPhone(9876543210L);

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .auth().basic("admin", "admin")
                .body(spartan)
                .and().pathParam("id",561)
                .when().put("/api/spartans/{id}")
                .then().assertThat().statusCode(204)
                .extract().response();
                response.prettyPrint();
    }
}
