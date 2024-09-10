public class Student{
    private String name;
    private int id;
    private String email;
    private Account account;

    public Student(){
        if (!email.endsWith("@uta.edu") && !email.endsWith("@mavs.uta.edu")) {
            throw new IllegalArgumentException("Non-UTA email address: " + email);
        }

        this.name = name;
        this.id = id;
        this.email = email;
        this.account = new Account();
    }

    public String requestMedia(Media media) {
        return account.play(media); 
    }

    @Override
    public String toString() {
        return String.format("%s (%d, %s, Account #%d)", name, id, email, account.getAccountNumber());
    }
}