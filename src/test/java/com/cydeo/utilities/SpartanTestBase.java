package com.cydeo.utilities;


import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class SpartanTestBase {
    @BeforeAll
    public static void inti() {
        RestAssured.baseURI = "http://3.84.108.13:8000";


        String dbUrl = "jdbc:oracle:thin:@3.84.108.13:1521:XE";
        String dbUsername = "SP";
        String dbPassword = "SP";
     //   DBUtils.createConnection(dbUrl,dbUsername,dbPassword);
    }
    @AfterAll
    public static void close(){
        DBUtils.destroy();
    }




    }
