package org.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Pracuj {
    private static final String PRACUJ_PL_URL = "https://www.pracuj.pl/praca/wroclaw;wp?rd=0&pn=";
    private static final SeparetedLinks separetedLinks = new SeparetedLinks();
    private static final Map<Integer, Set<String>> linksMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws Exception {
        Set<String> uniqueLinks = new HashSet<>();

        try {
            OperationsOnFiles.deleteFiles();
            getLinks();
            uniqueLinks = linksMap.values().stream()
                    .flatMap(Set::stream)
                    .collect(Collectors.toSet());
        } finally {
            ArrayList<String> listOfLinks = new ArrayList<>(uniqueLinks);
            OperationsOnFiles.saveFiles(listOfLinks);
            System.out.println("Saved " + listOfLinks.size() + " links.");
        }
    }

    private static void getLinks() throws IOException, URISyntaxException {
        int maxPage = Integer.parseInt(separetedLinks.getMaxPageNumber(PRACUJ_PL_URL));
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 1; i <= maxPage; i++) {
            var currentUrl = PRACUJ_PL_URL + i;
            service.submit(() -> {
                Set<String> linksSet;
                linksSet = IsUrlValid.getValid(currentUrl)
                        .map(separetedLinks::getAllLinksFromPage)
                        .isPresent()
                        .get();
                linksMap.put(1, linksSet);
            });
        }
        service.shutdown();

        try {
            service.awaitTermination(120, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
