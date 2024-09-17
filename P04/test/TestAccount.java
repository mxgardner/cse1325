package test;

import customer.Account;
import customer.Alacarte;
import customer.Unlimited;

public class TestAccount {
    public static void main(String[] args) {

        int testCases = 2;

        for (int i = 1; i <= testCases; i++) {
            int expected = i;
            
            // Use a concrete subclass of Account (e.g., Alacarte or Unlimited)
            Account account;
            if (i == 1) {
                account = new Alacarte(0);  // Instantiate Alacarte with 0 points
            } else {
                account = new Unlimited();  // Instantiate Unlimited
            }

            int actual = account.getAccountNumber();

            if (actual != expected) {
                System.err.println("FAIL: Expected account number '" + expected + "', but got '" + actual + "'");
                System.exit(1);
            }
        }

    }
}
