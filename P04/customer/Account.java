package customer;

import product.Media;

public abstract class Account {
    private int accountNumber;
    private static int nextAccountNumber = 1;

    public Account(){
        this.accountNumber = nextAccountNumber++;
        // TODO: Add data validation
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public abstract String play(Media media);

}