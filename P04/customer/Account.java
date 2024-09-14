package customer;

public class Account {
    private int accountNumber;
    private static int nextAccountNumber = 1;

    public Account(){
        this.accountNumber = nextAccountNumber++;
        // TODO: Add data validation
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String play(Media media) {
        return "Playing " + media.toString();
    }

}