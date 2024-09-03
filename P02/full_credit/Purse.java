enum Denomination {
    Penny, 
    Nickel, 
    Dime, 
    Quarter, 
    Dollar
}

class Coin{
    private Denomination denomination;
    private int year;
    private double value;

    public Coin(int year, Denomination denomination){
        this.year = year;
        this.denomination = denomination;
        this.value = assignValue(denomination);

        // TODO: Add data validation
    }

    private double assignValue(Denomination denomination) {
        switch (denomination) {
            case Penny:
                return 0.01;
            case Nickel:
                return 0.05;
            case Dime:
                return 0.10;
            case Quarter:
                return 0.25;
            case Dollar:
                return 1.00;
            default:
                return 0.0; 
        }
    }

    public double getValue() {
        return value;
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

        // System.out.printf("\nCoins in your bag\n-----------\n");
        // for (Coin coin : coins) {
        //     System.out.println("Year: " + coin.getYear() + ", Value: " + coin.getValue());
        // }

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

        System.out.printf("\n\nTotal Value: $ %.2f \nYear Range: %d - %d\n\n", totalValue, minYear, maxYear);
    }
}