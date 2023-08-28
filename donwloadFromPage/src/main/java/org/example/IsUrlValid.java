package org.example;

import java.net.URI;
import java.net.URISyntaxException;

public class IsUrlValid {
    static boolean isValid(String url){
        try{
            new URI(url);
            return true;
        } catch (URISyntaxException e) {
            return false;
        }
    }
}
