package com.cydeo.day5;
import com.cydeo.utilities.HrTestBase;
import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class JSONtoJAVATest extends SpartanTestBase {



  @DisplayName("Get one spartan and deserialize to Map")
    @Test
    public void test1(){

 Response response= given().accept(ContentType.JSON)
              .and().pathParams("id",15)
              .when()
              .get("/api/spartans/{id}")
              .then()
              .statusCode(200)
              .extract().response();

      Map<String,Object> jsonMap= response.as(Map.class);



    }
}
