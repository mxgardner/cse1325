package test;

import product.Media;

public class TestMedia {
    public static void main(String[] args) {

        // Test Media Constructor
        Media media = new Media("Sample Title", "https://example.com", 0);

        String expected = "Media [Title: Sample Title, URL: https://example.com, Customer Points: 0]";
        String actual = media.toString();

        if (!actual.equals(expected)) {
            System.err.println("FAIL: Expected '" + expected + "', but got '" + actual + "'");
            System.exit(1); 
        }

        // Test for valid URLs
        String[] validURLs = {"https://youtube.com", "file://media/lib/garp.mp4"};
        String[] invalidURLs = {"hello.world", "htt://badurl.com", "flub://badurl.com"};

        for (String url : validURLs) {
            try {
                new Media("Valid URL Test", url, 0); 
            } catch (Exception e) {
                System.err.println("FAIL: Expected valid URL, but got exception for '" + url + "'");
                System.exit(2); 
            }
        }

        for (String url : invalidURLs) {
            try {
                new Media("Invalid URL Test", url, 0);
                System.err.println("FAIL: Expected exception for invalid URL '" + url + "', but none was thrown");
                System.exit(3); 
            } catch (RuntimeException e) {

            } catch (Exception e) {
                System.err.println("FAIL: Expected RuntimeException, but got a different exception for '" + url + "': " + e);
                System.exit(4); 
            }
        }
        
    }
}