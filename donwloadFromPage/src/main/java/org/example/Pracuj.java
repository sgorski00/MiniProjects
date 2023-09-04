package org.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Pracuj {
    private static final String PRACUJ_PL_URL = "https://www.pracuj.pl/praca/wroclaw;wp?rd=0&pn=";
    private static SeparetedLinks separetedLinks = new SeparetedLinks();

    public static void main(String[] args) throws Exception {
        Set<String> links = new TreeSet<>();
        long start = System.currentTimeMillis();

        try {
            OperationsOnFiles.deleteFiles();
            getLinks(links);
        } finally {
            ArrayList<String> listOfLinks = new ArrayList<>(links);
            OperationsOnFiles.saveFiles(listOfLinks);
            System.out.println("Saved " + listOfLinks.size() + " links.");
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void getLinks(Set<String> links) throws IOException, URISyntaxException {
        int maxPage = Integer.parseInt(separetedLinks.getMaxPageNumber(PRACUJ_PL_URL));
        for(int i = 1; i<=maxPage; i++) {
            separetedLinks.addLinksToList(links, PRACUJ_PL_URL + i);
        }
    }
}
