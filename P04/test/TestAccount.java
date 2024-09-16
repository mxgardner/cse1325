package test;

import customer.Account;

public class TestAccount {
    public static void main(String[] args) {

        int testCases = 2;

        for(int i = 1; i <= testCases; i++){
            int expected = i;
            Account account = new Account();

            int actual = account.getAccountNumber();

            if (actual != expected){
                System.err.println("FAIL: Expected account number '" + expected + "', but got '" + actual + "'");
                System.exit(1); 
            }
        }

    }
}
