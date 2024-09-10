public class Media {
    private String title;
    private String URL;

    public Media (String title, String URL){
        this.title = title;
        this.URL = URL;

        // TODO: Add data validation
    }

    @Override
    public String toString() {
        return "Media [Title: " + title + ", URL: " + URL + "]";
    }
}