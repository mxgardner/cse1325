package test;

import customer.Account;

public class TestAccount {
    public static void main(String[] args) {
        Account account1 = new Account();
        int expected1 = 1;
        int actual1 = account1.getAccountNumber();

        if (actual1 != expected1) {
            System.err.println("FAIL: Expected account number '" + expected1 + "', but got '" + actual1 + "'");
            System.exit(1);
        }

        Account account2 = new Account();
        int expected2 = 2;
        int actual2 = account2.getAccountNumber();

        if (actual2 != expected2) {
            System.err.println("FAIL: Expected account number '" + expected2 + "', but got '" + actual2 + "'");
            System.exit(1); 
        }

    }
}
