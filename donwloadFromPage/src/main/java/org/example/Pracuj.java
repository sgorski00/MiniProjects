package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Pracuj {
    private static final String PRACUJ_PL_URL = "https://www.pracuj.pl/praca/warszawa;wp?rd=0&pn=";

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        SeparetedLinks separetedLinks = new SeparetedLinks();
        Set<String> links = new TreeSet<>();

        long start = System.currentTimeMillis();

        try {
            OperationsOnFiles.deleteFiles();
            getLinks(separetedLinks, links);
        } finally {
            ArrayList<String> listOfLinks = new ArrayList<>(links);
            OperationsOnFiles.saveFiles(listOfLinks);
            System.out.println("Saved " + listOfLinks.size() + " links.");
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
        executorService.shutdown();
    }

    private static void getLinks(SeparetedLinks separetedLinks, Set<String> links) throws IOException {
        int i = 1;
        int startValue;
        int endValue;

        while (IsUrlValid.isValid(PRACUJ_PL_URL + i)) {
            startValue = links.size();
            separetedLinks.addLinksToList(links, PRACUJ_PL_URL + i);
            endValue = links.size();
            if (startValue == endValue) {
                break;
            }
            i++;
        }
    }
}
