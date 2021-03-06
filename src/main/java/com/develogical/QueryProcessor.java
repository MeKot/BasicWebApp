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

    boolean isPrime(int num) {
        for(int i = 2; i <= num/2; ++i)
        {
            // condition for nonprime number
            if(num % i == 0)
            {
                return true;
            }
        }
        return false;
    }

    static boolean isCube(double input) {
        double cubeRoot = Math.cbrt(input); // get the cube root
        return Math.round(cubeRoot) == cubeRoot; // determine if number is integral
    }

    static int fib(int n) {
        if (n <= 1)
            return n;
        return fib(n-1) + fib(n-2);
    }

    public String process(String query) {
        if (query.toLowerCase().contains("what is your team name")) {
            return "Dynamic_Duo";
        }
        if (query.contains("what is your name")) {
            return "Dynamic_Duo";
        }
        if (query.contains("what is happening")) {
            return "Competition";
        }
        if (query.toLowerCase().contains("which of the following numbers") && query.contains("largest")) {
            List<String> ints = Arrays.asList(extractInt(query).split(" "));
            List<Integer> intss = ints.stream().map(Integer::parseInt).collect(Collectors.toList());
            return Integer.toString(Collections.max(intss));
        }
        if (query.toLowerCase().contains("what is") && query.toLowerCase().contains("plus")) {
            return Arrays.stream(extractInt(query).split(" ")).map(x -> Integer.parseInt(x)).reduce((x, y) -> x + y).get().toString();
        }
        if (query.toLowerCase().contains("what is") && query.toLowerCase().contains("minus")) {
            return Arrays.stream(extractInt(query).split(" ")).map(x -> Integer.parseInt(x)).reduce((x, y) -> x - y).get().toString();
        }
        if (query.toLowerCase().contains("numbers") && query.toLowerCase().contains("square and a cube")) {
            List<String> ints = Arrays.asList(extractInt(query).split(" "));
            List<Integer> intss = ints.stream().map(Integer::parseInt).collect(Collectors.toList());

            for (int i : intss)
                if (isCube(i) && (Math.sqrt(i) - Math.round(Math.sqrt(i)))  < 0.01) {
                    return Integer.toString(i);
                }
        }
        if (query.toLowerCase().contains("number in the Fibonacci")) {
            return Integer.toString(fib(Integer.parseInt(extractInt(query).split(" ")[0])));
        }
        if (query.toLowerCase().contains("what is") && query.toLowerCase().contains("multiplied")) {
            Arrays.stream(extractInt(query).split(" ")).reduce((x, y) -> Integer.toString(Integer.parseInt(x) * Integer.parseInt(y))).get();
        }
        if (query.toLowerCase().contains("what colour is a banana")) {
            return "yellow";
        }
        if (query.toLowerCase().contains("which year was Theresa May")) {
            return "2016";
        }
        if (query.toLowerCase().contains("which city is the Eiffel tower")) {
            return "Paris";
        }
        if (query.toLowerCase().contains("which of the following numbers are primes")) {
            Arrays.stream(extractInt(query).split(" ")).map(x -> Integer.parseInt(x)).filter(x -> isPrime(x)).map(x -> x.toString()).reduce((x, y) -> x + " " + y);
        }
        if (query.toLowerCase().contains("hello")) {
            return "hello";
        }
        if (query.toLowerCase().contains("when did you join imperial")) {
            return "2016";
        }
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        return "";
    }
}
