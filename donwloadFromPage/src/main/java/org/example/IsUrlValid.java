package org.example;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Optional;

public class IsUrlValid {
    Optional<URL> getValid(String url){
        try{
            return Optional.of(URI.create(url).toURL());
        } catch (MalformedURLException e) {
            return Optional.empty();
        }
    }
}
