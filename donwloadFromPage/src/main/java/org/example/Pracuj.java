package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Pracuj {
    public static void main(String[] args) throws Exception {
        URL pracuj = new URL("https://www.pracuj.pl/praca/legnica;wp?rd=10/");
        BufferedReader in = new BufferedReader(new InputStreamReader(pracuj.openStream()));

        String inputLine;
        StringBuilder stringBuilder = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            stringBuilder.append(inputLine);
            stringBuilder.append(System.lineSeparator());
        }
        in.close();

        String content = stringBuilder.toString();
        Set<String> links = new TreeSet<>();

        int index = content.indexOf("<body>");
        String substring = content.substring(index);
        String splittedToBody = substring.split("<div data-test=\"job-offers-bottom-pagination\"")[0];
        String splittedToLink;
        try {
            for (int i = 0; i < splittedToBody.length(); i++) {
                if (i < 0) {
                    break;
                }
                i = splittedToBody.indexOf("https://www.pracuj.pl/praca/", i);
                splittedToLink = splittedToBody.substring(i);
                String finalLink = splittedToLink.split("\"")[0];
                links.add(finalLink);
            }
        } catch(IndexOutOfBoundsException e){

        }finally {
            links.forEach(System.out::println);
            System.out.println(links.size());
        }
    }
}
