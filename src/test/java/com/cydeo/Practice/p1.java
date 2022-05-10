package com.cydeo.Practice;

import com.cydeo.utilities.HrTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class p1 extends HrTestBase {
//- Given accept type is Json
//- Path param value- US
//- When users sends request to /countries
//- Then status code is 200
//- And Content - Type is Json
//- And country_id is US
//- And Country_name is United States of America
//- And Region_id is 2

    @DisplayName("get United State")
    @Test
    public void Q1() {

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id", "US").when()
                .get("/countries/{id}");
        JsonPath jsonPath = response.jsonPath();


//- Then status code is 200
        assertEquals(200, response.statusCode());


//- And Content - Type is Json
        assertEquals("application/json", response.contentType());

//- And country_id is US
        assertEquals("US", jsonPath.getString("country_id"));

//- And Country_name is United States of America
        assertEquals("United States of America", jsonPath.getString("country_name"));

//- And Region_id is 2
        assertEquals(2, jsonPath.getInt("region_id"));
    }

    //Q2:
    //- Given accept type is Json
    //- Query param value - q={"department_id":80}
    //- When users sends request to /employees
    //- Then status code is 200
    //- And Content - Type is Json
    //- And all job_ids start with 'SA'
    //- And all department_ids are 80
    //- Count is 25
    @DisplayName("Q2")
    @Test
    public void Q2() {

        Response response = given().accept(ContentType.JSON)
                .and().queryParam("q", "{\"department_id\":80}")
                .when()
                .get("/employees");
        JsonPath jsonPath = response.jsonPath();

        //- Then status code is 200
        assertEquals(200, response.statusCode());

        //- And Content - Type is Json
        assertEquals("application/json", response.contentType());

        //- And all job_ids start with 'SA'
        List<String> list = jsonPath.getList("items.job_id");
        for (String each : list) {
            assertTrue(each.startsWith("SA"));
        }

        //- And all department_ids are 80
        List<Integer> department_ids = jsonPath.getList("items.department_id");
        for (Integer each : department_ids) {
            assertTrue(each == 80);
        }
        //- Count is 25
        assertEquals(25, jsonPath.getInt("count"));


    }

    //Q3:
    //- Given accept type is Json
    //-Query param value q= region_id 3
    //- When users sends request to /countries
    //- Then status code is 200
    //- And all regions_id is 3
    //- And count is 6
    //- And hasMore is false
    //- And Country_name are;
    //Australia,China,India,Japan,Malaysia,Singapore
    @DisplayName("Q3")
    @Test
    public void Q3() {

        Response response = given().queryParam("q", "{\"region_id\":3}")
                .get("/countries");
        JsonPath jsonPath = response.jsonPath();


        //- Then status code is 200
        assertEquals(200, response.statusCode());

//- And all regions_id is 3
        List<Integer> list = jsonPath.getList("items.region_id");
        for (Integer each : list) {
            assertTrue(each == 3);
        }


        //- And count is 6
        assertEquals(6, jsonPath.getInt("count"));


        //- And hasMore is false
        assertEquals("false", jsonPath.getString("hasMore"));


        //- And Country_name are;
        //Australia,China,India,Japan,Malaysia,Singapore
        List<String> countryName = jsonPath.getList("items.country_name");
        String expected= "Australia,China,India,Japan,Malaysia,Singapore";
        for (String each : countryName) {
            assertTrue(each.contains(expected));

            
        }
    }
}