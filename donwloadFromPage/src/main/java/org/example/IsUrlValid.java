package org.example;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class IsUrlValid {
    static boolean isValid(String url){
        try{
            new URL(url).toURI();
            return true;
        } catch (MalformedURLException | URISyntaxException e) {
            return false;
        }
    }
    static int countLinks(boolean isValid){
        int count = 0;
        if(isValid){
            count++;
        }
        return count;
    }
}
