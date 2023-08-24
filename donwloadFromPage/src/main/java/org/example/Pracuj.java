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

    public static void main(String[] args) throws Exception {
        SeparetedLinks separetedLinks = new SeparetedLinks();
        Set<String> links = new TreeSet<>();

        long start = System.currentTimeMillis();

        try {
            separetedLinks.addLinksToList(links, PRACUJ_PL_URL);
        } finally {
            ArrayList<String> listOfLinks = new ArrayList<>(links);
            SaveFiles.saveFiles(listOfLinks);
            System.out.println("Saved " + listOfLinks.size() + " links.");
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
