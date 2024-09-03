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

    @Override
    public String toString() {
        return name().toLowerCase();
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

    @Override
    public String toString() {
        return year + " " + denomination;
    }
}
public class Purse {
    public static void main(String[] args) {
        Coin[] coins = new Coin[5];

        coins[0] = new Coin(1776, Denomination.Penny);
        coins[1] = new Coin(1432, Denomination.Nickel);
        coins[2] = new Coin(1215, Denomination.Dime);
        coins[3] = new Coin(1989, Denomination.Quarter);
        coins[4] = new Coin(1442, Denomination.Dollar);

        System.out.printf("\nCoins in your bag\n-----------\n");
        for (Coin coin : coins) {
            System.out.println(coin);
        }

        double totalValue = 0;

        for (Coin coin : coins) {
            totalValue += coin.getValue();
        }

        int minYear = coins[0].getYear();
        int maxYear = coins[0].getYear();

        for (Coin coin : coins) {
            if(coin.getYear() < minYear){
                minYear = coin.getYear();
            }
            if(coin.getYear() > maxYear){
                maxYear = coin.getYear();
            }
        }

        System.out.printf("\n\nTotal Value: $ %.2f \nYear Range: %d - %d\n", totalValue, minYear, maxYear);
    }
}