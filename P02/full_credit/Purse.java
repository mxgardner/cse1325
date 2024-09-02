enum Denomination {
    Penny(0.01), 
    Nickel(0.05), 
    Dime(0.10), 
    Quarter(0.25), 
    Dollar(1.00);

    private final double value;

    Denomination(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}

class Coin{
    private Denomination denomination;
    private int year;

    public Coin(int year, Denomination denomination){
        this.year = year;
        this.denomination = denomination;

        // TODO: Add data validation
    }

    public double getValue() {
        return denomination.getValue();
    }

    public int getYear() {
        return year;
    }
}
public class Purse {
    public static void main(String[] args) {
        Coin[] coins = new Coin[5];

        coins[0] = new Coin(1870, Denomination.Penny);
        coins[1] = new Coin(0, Denomination.Nickel);
        coins[2] = new Coin(1216, Denomination.Dime);
        coins[3] = new Coin(1991, Denomination.Quarter);
        coins[4] = new Coin(2024, Denomination.Dollar);

        for (Coin coin : coins) {
            System.out.println("Year: " + coin.getYear() + ", Value: " + coin.getValue());
        }
    }
}