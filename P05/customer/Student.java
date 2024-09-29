package customer;

import product.Media;
import customer.Alacarte;
import customer.Unlimited;

public class Student {
    private String name;
    private long id;
    private String email;
    private Account account;

    public Student(String name, long id, String email, boolean unlimited) {
        if (!email.endsWith("@uta.edu" || !email.endsWith("@mavs.uta.edu"))) {
            throw new IllegalArgumentException("Non-UTA email address: " + email);
        }

        this.name = name;
        this.id = id;
        this.email = email;

        if (unlimited) {
            this.account = new Unlimited();  // Unlimited account
        } else {
            this.account = new Alacarte(0);  // Alacarte account with 0 starting points
        }
    }

    public Account getAccount() {
        return account;
    }

    public String requestMedia(Media media) {
        return account.play(media);  // Calls play on the correct account type
    }

    @Override
    public String toString() {
        return name + " (" + id + ", " + email + ", Account #" + account.getAccountNumber() + ")";
    }
}
