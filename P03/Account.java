public class Account {
    private int accountNumber;
    private static int nextAccountNumber;

    public Account (int accountNumber, int nextAccountNumber){
        this.accountNumber = accountNumber;
        this.nextAccountNumber = nextAccountNumber;

        // TODO: Add data validation
    }

}