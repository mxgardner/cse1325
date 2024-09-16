package product;

import java.net.MalformedURLException;
import java.net.URL;

public class Media {
    private String title;
    private String URL;
    private int points = 0;

    public Media (String title, String URL, int points){
        this.title = title;

        if (!isValidURL(URL)) {
            throw new RuntimeException("Invalid URL: " + URL);
        }

        this.URL = URL;
        this.points = points;
    }

    private boolean isValidURL(String url) {
        try {
            new URL(url);  
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }

    public int getPoints (){
        return points;
    }

    @Override
    public String toString() {
        return "Media [Title: " + title + ", URL: " + URL + " + Customer Points + '' + points]";
    }
}