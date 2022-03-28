package org.concept.lambda.ex20;

import java.util.Arrays;

public class UserDefined {
    public static String apply(String inData){
        return Arrays.toString(inData.toCharArray());
    }

    public static Integer apply(Integer n1, Integer n2){
        return (n1*n1+ n2*n2+ 2*n1*n2);
    }
}
