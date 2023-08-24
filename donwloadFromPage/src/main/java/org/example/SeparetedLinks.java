package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Set;

public class SeparetedLinks {
    protected StringBuilder readWebsite(String url) throws IOException {
        URL pracuj = new URL(url);
        BufferedReader in = new BufferedReader(new InputStreamReader(pracuj.openStream()));

        String inputLine;
        StringBuilder stringBuilder = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            stringBuilder.append(inputLine);
            stringBuilder.append(System.lineSeparator());
        }
        in.close();

        return stringBuilder;
    }

    private void getAllLinksFromPage(Set<String> links, String offersSection) {
        String splittedToLink = "";
        for (int i = 0; i < offersSection.length(); i++) {
            if (i < 0) {
                break;
            }
            i = offersSection.indexOf("https://www.pracuj.pl/praca/", i);
            splittedToLink = offersSection.substring(i);
            String finalLink = splittedToLink.split("\"")[0];
            links.add(finalLink);
        }
    }
    private String getOffersDiv(String fullPage) {
        int index = fullPage.indexOf("<body>");
        String substring = fullPage.substring(index);
        return substring.split("<div data-test=\"job-offers-bottom-pagination\"")[0];
    }

    void addLinksToList(Set<String> links, String website) throws IOException {
        String offersDiv;
        StringBuilder pracujWebsite;
        try {
            pracujWebsite = readWebsite(website);
            offersDiv = getOffersDiv(pracujWebsite.toString());
            getAllLinksFromPage(links, offersDiv);
        } catch (StringIndexOutOfBoundsException e) {

        }
    }
}
