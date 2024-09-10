public class TestMedia {
    public static void main(String[] args) {
        Media media = new Media("Sample Title", "https://example.com");

        String expected = "Media [Title: Sample Title, URL: https://example.com]";
        String actual = media.toString();

        if (!actual.equals(expected)) {
            System.err.println("FAIL: Expected '" + expected + "', but got '" + actual + "'");
            System.exit(1); 
        }
        
    }
}