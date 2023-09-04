package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.Set;

public class SeparetedLinks {
    private StringBuilder readWebsite(String url) throws IOException, URISyntaxException {
        URI pracuj = new URI(url);
        BufferedReader in = new BufferedReader(new InputStreamReader(pracuj.toURL().openStream()));

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
        String splittedToLink;
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

    void addLinksToList(Set<String> links, String website) throws IOException {
        try {
            getAllLinksFromPage(links, getOffersDiv(website));
        } catch (StringIndexOutOfBoundsException | URISyntaxException ignored) {}
    }
}
