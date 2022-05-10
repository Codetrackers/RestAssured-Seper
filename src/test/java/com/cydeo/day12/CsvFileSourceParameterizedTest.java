package com.cydeo.day12;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CsvFileSourceParameterizedTest {


    @ParameterizedTest
    @CsvFileSource(resources = "/postalCode.csv",numLinesToSkip = 1)
    public void  zipCodeWithFile(String state, String city, int zipCount){

        System.out.println("state = " + state);
        System.out.println("city = " + city);
        System.out.println("zipCount = " + zipCount);


    }


}
