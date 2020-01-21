package com.develogical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class QueryProcessor {

    // Function to return the modified string
    static String extractInt(String str)
    {
        // Replacing every non-digit number
        // with a space(" ")
        str = str.replaceAll("[^\\d]", " ");

        // Remove extra spaces from the beginning
        // and the ending of the string
        str = str.trim();

        // Replace all the consecutive white
        // spaces with a single space
        str = str.replaceAll(" +", " ");

        if (str.equals(""))
            return "-1";

        return str;
    }

    static boolean isCube(double input) {
        double cubeRoot = Math.cbrt(input); // get the cube root
        return Math.round(cubeRoot) == cubeRoot; // determine if number is integral
    }



    public String process(String query) {
        if (query.toLowerCase().contains("what is your team name")) {
            return "Dynamic_Duo";
        }
        if (query.toLowerCase().contains("which of the following numbers") && query.contains("largest")) {
            List<String> ints = Arrays.asList(extractInt(query).split(" "));
            List<Integer> intss = ints.stream().map(Integer::parseInt).collect(Collectors.toList());
            return Integer.toString(Collections.max(intss));
        }
        if (query.toLowerCase().contains("what is") && query.toLowerCase().contains("plus")) {
            return Integer.toString(Integer.parseInt(query.toLowerCase().split(" ")[3]) + Integer.parseInt(query.toLowerCase().split(" ")[5]));
        }
        if (query.toLowerCase().contains("numbers") && query.toLowerCase().contains("square and a cube")) {
            List<String> ints = Arrays.asList(extractInt(query).split(" "));
            List<Integer> intss = ints.stream().map(Integer::parseInt).collect(Collectors.toList());

            for (int i : intss)
                if (isCube(i) && Math.sqrt(i) == Math.round(Math.sqrt(i))) {
                    return Integer.toString(i);
                }

        }
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        return "";
    }
}
