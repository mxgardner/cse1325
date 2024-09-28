package product;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * The {@code Media} class represents a piece of media content, such as a video or article, 
 * with a title, URL, and associated customer points required to access it.
 * 
 * @author YourName
 * @version 0.2
 * @since 2024
 */
public class Media {
    private String title;
    private String URL;
    private int points;

    /**
     * Constructs a new {@code Media} object with the given title, URL, and points.
     *
     * @param title The title of the media.
     * @param URL The URL of the media. Must be a valid URL.
     * @param points The number of points required to access the media.
     * @throws RuntimeException If the URL is invalid.
     * @since 0.2
     */
    public Media(String title, String URL, int points) {
        this.title = title;

        if (!isValidURL(URL)) {
            throw new RuntimeException("Invalid URL: " + URL);
        }

        this.URL = URL;
        this.points = points;
    }

    /**
     * Checks if a URL is valid.
     *
     * @param url The URL to be validated.
     * @return {@code true} if the URL is valid, {@code false} otherwise.
     */
    private boolean isValidURL(String url) {
        try {
            new URL(url);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }

    /**
     * Gets the number of points required to access the media.
     * 
     * @return The number of points.
     * @since 0.2
     */
    public int getPoints() {
        return points;
    }

    /**
     * Returns a string representation of the {@code Media} object, 
     * including the title, URL, and points.
     * 
     * @return A string describing the media.
     * @since 0.2
     */
    @Override
    public String toString() {
        return "Media [Title: " + title + ", URL: " + URL + ", Customer Points: " + points + "]";
    }
}
