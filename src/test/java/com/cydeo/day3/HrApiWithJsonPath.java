package com.cydeo.day3;

import com.cydeo.utilities.HrTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
public class HrApiWithJsonPath extends HrTestBase {


    @DisplayName("GET request to countries with Path method")
    @Test
    public void test1() {
        Response response = get("/countries");
        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.getString("items[3].country_name"));
        List<String> list = jsonPath.getList("items.country_name");
        for (String s : list) {
            System.out.println(s);
        }


        List<Object> list2 = jsonPath.getList("items.findAll{it.region_id==2}.country_name");
        System.out.println(list2);

    }




        @DisplayName("GET request to IT with Path method")
        @Test
        public void test2() {





    }
}
