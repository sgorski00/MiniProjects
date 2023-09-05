package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

import java.util.Set;
import java.util.TreeSet;

public class SeparetedLinks {
    private StringBuilder readWebsite(String url) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(IsUrlValid.getValid(url).get().openStream()));

        String inputLine;
        StringBuilder stringBuilder = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            stringBuilder.append(inputLine);
            stringBuilder.append(System.lineSeparator());
        }
        in.close();

        return stringBuilder;
    }

     Set<String> getAllLinksFromPage(String website) throws IOException, URISyntaxException {
        String splittedToLink;
        Set<String> links = new TreeSet<>();
        for (int i = 0; i < getOffersDiv(website).length(); i++) {
            if (i < 0) {
                break;
            }
            i = getOffersDiv(website).indexOf("https://www.pracuj.pl/praca/", i);
            splittedToLink = getOffersDiv(website).substring(i);
            String finalLink = splittedToLink.split("\"")[0];
            links.add(finalLink);
        }
        return links;
    }
    private String getOffersDiv(String website) throws IOException, URISyntaxException {
        String result = getElement(readWebsite(website).toString(), "<body>");
        return result.split("<div data-test=\"job-offers-bottom-pagination\"")[0];
    }

    String getMaxPageNumber(String websiteLink) throws IOException, URISyntaxException {
        String result = getElement(readWebsite(websiteLink).toString(), "\"top-pagination-max-page-number\">");
        result = result.split("</span>")[0];
        result = result.substring(result.indexOf(">") + 1);
        return result;
    }

    private String getElement(String fullPage, String textToGetIndex) {
        int index = fullPage.indexOf(textToGetIndex);
        return fullPage.substring(index);
    }
}
