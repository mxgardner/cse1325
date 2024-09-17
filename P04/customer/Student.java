package customer;

import product.Media;

public class Student extends Account {
    private String name;
    private long id;
    private String email;
    private Alacarte alacarteAccount;

    public Student(String name, long id, String email) {
        if (!email.endsWith("@uta.edu")) {
            throw new IllegalArgumentException("Non-UTA email address: " + email);
        }

        this.name = name;
        this.id = id;
        this.email = email;
        this.alacarteAccount = new Alacarte(0);  // Initialize with 0 points
    }

    public void buyPoints(int points) {
        alacarteAccount.buyPoints(points);
    }

    public int getPointsRemaining() {
        return alacarteAccount.getPointsRemaining();
    }

    public String play(Media media) {
        return alacarteAccount.play(media);  // Use Alacarte's play method
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return name + " (" + id + ", " + email + ", Account #" + getAccountNumber() + ")";
    }
}
