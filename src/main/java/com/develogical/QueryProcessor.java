package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("what is your team name")) {
            return "Dynamic_Duo";
        }
        if (query.toLowerCase().contains("what is") && query.toLowerCase().contains("plus")) {
            return Integer.toString(Integer.parseInt(query.toLowerCase().split(" ")[3]) + Integer.parseInt(query.toLowerCase().split(" ")[5]));
        }
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        return "";
    }
}
