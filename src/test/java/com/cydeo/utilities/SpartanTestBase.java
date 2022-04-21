package com.cydeo.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public abstract class SpartanTestBase {
 @BeforeAll
    public static void inti() {
        RestAssured.baseURI = "http://3.84.108.13:8000";}









    }
