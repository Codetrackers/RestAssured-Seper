package com.cydeo.day10;

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

public class SpartanXMLTest extends SpartanTestBase {


    @Test
    public void test1() {
      given().accept(ContentType.XML)
                .auth().basic("admin","admin")
                .when()
                .get("/api/spartans")
                .then()
                .statusCode(200)
                .contentType("application/xml").body("list.item[0].gender",is("Male")).
              body("list.item[0].name",is("Meade"))
        ;



    }

    @Test
    public void test2() {
       Response response= given().accept(ContentType.XML)
                .get("/api/spartans");
        XmlPath xmlPath = response.xmlPath();
        System.out.println(xmlPath.getString("list.item[0].name"));

        System.out.println(xmlPath.getInt("list.item[2].id"));
List<String> list= xmlPath.getList("list.item.name");
        System.out.println(list);

    }
}

