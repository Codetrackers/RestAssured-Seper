package com.cydeo.day3;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

import com.cydeo.utilities.SpartanTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpartanTestWithParameters extends SpartanTestBase {
 /*   Given accept type is Json
          And Id parameter value is 5
          When user sends GET request to /api/spartans/{id}
          Then response status code should be 200

          And "Blythe" should be in response payload(body)
       */


    @DisplayName("Get request with id ")
    @Test
    public void test1() {

        //Given accept type is Json
        //And Id parameter value is 5
        Response response = given().accept(ContentType.JSON).and().pathParam("id", 5).when().get("/api/spartans/{id}");

        //verify response status code should be 200
        assertEquals(200, response.statusCode());

        //verify response content-type: application/json
        assertEquals("application/json", response.contentType());

        // verify "Blythe" should be in response payload(body)
        assertTrue(response.body().asString().contains("Blythe"));

    }

    /*
    TASK
    Given accept type is Json
    And Id parameter value is 500
    When user sends GET request to /api/spartans/{id}
    Then response status code should be 404
    And response content-type: application/json
    And "Not Found" message should be in response payload
 */
    @DisplayName("get id 500")
    @Test
    public void test2() {
      //Given accept type is Json
      // And Id parameter value is 500
      // When user sends GET request to /api/spartans/{id}
        Response response = given()
                .accept(ContentType.JSON)
                .and().pathParam("id", 500)
                .when().get("/api/spartans/{id}");

        //Verify response status code should be 404
        assertEquals(404, response.contentType());

        //Verify response content-type: application/json
        assertEquals("application/json", response.contentType());

        //Verify "Not Found" message should be in response payload
        assertTrue(response.body().asString().contains("Not Found"));


    }

}
