package product;

import java.net.MalformedURLException;
import java.net.URL;

public class Media {
    private String title;
    private String URL;

    public Media (String title, String URL){
        this.title = title;

        if (!isValidURL(URL)) {
            throw new RuntimeException("Invalid URL: " + URL);
        }

        this.URL = URL;
    }

    private boolean isValidURL(String url) {
        try {
            new URL(url);  
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Media [Title: " + title + ", URL: " + URL + "]";
    }
}