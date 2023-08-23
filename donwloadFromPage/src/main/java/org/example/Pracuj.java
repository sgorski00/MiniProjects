package org.example;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Pracuj {

    //https://www.pracuj.pl/praca/legnica;wp?rd=10&pn=2
    private static final String PRACUJ_PL_URL = "https://www.pracuj.pl/praca/legnica;wp?rd=10/";
    private static final String PATH_TO_LINKS = new JFileChooser().getFileSystemView().getDefaultDirectory().toString() + "\\links\\";

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        StringBuilder pracujWebsite = readWebsite();
        String content = pracujWebsite.toString();
        Set<String> links = new TreeSet<>();

        try {
            String offersDiv = getOffersDiv(content);
            getAllLinksFromPage(links, offersDiv);
        } catch(IndexOutOfBoundsException e){
            //go to next page
        } finally{
            ArrayList<String> listOfLinks = new ArrayList<>(links);
            saveFiles(listOfLinks);
            System.out.println("URL files saved in: " + PATH_TO_LINKS);
            System.out.println(listOfLinks.get(0));
            System.out.println(listOfLinks.get(1));
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void getAllLinksFromPage(Set<String> links, String offersSection) {
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

    private static void saveFiles(List<String> linksList) throws IOException {
        int i = 1;
        for(String link: linksList){
            writeToFile(PATH_TO_LINKS + i + ".url", "[InternetShortcut]\nURL=" + link);
            i++;
        }
    }

    private static String getOffersDiv(String content) {
        int index = content.indexOf("<body>");
        String substring = content.substring(index);
        return substring.split("<div data-test=\"job-offers-bottom-pagination\"")[0];
    }

    private static StringBuilder readWebsite() throws IOException {
        URL pracuj = new URL(PRACUJ_PL_URL);
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

    private static void writeToFile(String fileName, String link) throws IOException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
            writer.write(link);
            writer.close();
        } catch (FileNotFoundException e) {
            Files.createDirectories(Paths.get(PATH_TO_LINKS));
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
            writer.write(link);
            writer.close();
        }
    }
}
