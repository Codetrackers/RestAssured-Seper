package com.cydeo.day5;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersIntro {

    @DisplayName("Assertion witn Numbers")
    @Test
    public void test1() {


        assertThat(5 + 5, is(10));
        assertThat(5 + 5, equalTo(10));

        //matchers has 2 overloaded version
        //first that accept actual value
        //second that accept another matchers
        assertThat(5 + 5, is(equalTo(10)));

        assertThat(5 + 5, not(9));
        assertThat(5 + 5, is(not(9)));
        assertThat(5 + 5, is(not(equalTo(8))));

        //greaterThan()
        //greaterThanOrEqualTo()
        //lessThan()
        //lessThanOrEqualTo()
        assertThat(5 + 5, is(greaterThan(9)));
    }

    @DisplayName("Assertion with String")
    @Test
    public void test2() {
        String text = "B25 is learning hamcrest";
        assertThat(text, is("B25 is learning hamcrest"));
        assertThat(text, equalTo("B25 is learning hamcrest"));
        assertThat(text, is(equalTo("B25 is learning hamcrest")));


        assertThat(text, startsWith("B25"));
        assertThat(text, startsWithIgnoringCase("b25"));
        assertThat(text, endsWith("hamcrest"));


        assertThat(text, containsString("learning"));
        assertThat(text, containsStringIgnoringCase("LEARNING"));

        String str = "  ";

        assertThat(str, blankString());
        assertThat(str.trim(), emptyString());
    }


    @DisplayName("handcrest Collection")
    @Test
    public void Collection() {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 32, 54, 66, 43, 24);
        assertThat(list, hasSize(9));

        assertThat(list, hasItem(54));

        assertThat(list, hasItems(43, 24, 3));


        assertThat(list,everyItem(greaterThan(0)));



    }


}
