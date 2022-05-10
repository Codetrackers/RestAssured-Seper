package com.cydeo.day10;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.cydeo.utilities.HrTestBase;
import com.cydeo.utilities.SpartanTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class FormulaOneXmlTest {

    @BeforeAll
    public static void init(){
//http://ergast.com/api/f1/drivers/alonso
        RestAssured.baseURI="http://ergast.com";
        RestAssured.basePath="/api/f1";


    }
@Test
    public void test1(){
Response response= given()
        .pathParams("driver","alonso")
        .when()
        .get("drivers/{driver}")
        .then().statusCode(200)
        .extract().response();
    XmlPath xmlPath = response.xmlPath();
    System.out.println(xmlPath.getString("MRData.DriverTable.Driver.GivenName"));

    System.out.println(xmlPath.getString("MRData.DriverTable.Driver.@driverId"));


}




}
