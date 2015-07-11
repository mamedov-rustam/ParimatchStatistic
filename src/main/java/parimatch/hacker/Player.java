package parimatch.hacker;

/**
 * Created by rustam on 10.07.15.
 */
public class Player {
    private double money;
    private double minProfit;

    private double currentBetAmount;
    private double currentKof;
    private double lossMoney;

    public Player(double money, double minProfit) {
        this.money = money;
        this.minProfit = minProfit;
    }

    public void makeBet(double kof) {
        currentKof = kof;

        currentBetAmount = minProfit;

        while (lossMoney != 0 && currentBetAmount * (currentKof - 1) - lossMoney < minProfit) {
            currentBetAmount++;
        }

        money -= currentBetAmount;
        if (money < 0) {
            System.out.println("Loss: " + lossMoney);
            System.out.println("Kof: " + kof);
            System.out.println("Need: " + currentBetAmount);
            throw new RuntimeException("You fucking loser!");
        }

        System.out.println((int)money + " | " + currentBetAmount + " | " + currentKof);
    }

    public void win() {
        money += currentBetAmount * currentKof;
        lossMoney = 0;
    }

    public void upBet() {
        lossMoney += currentBetAmount;
    }

    public double getMoney() {
        return money;
    }
}
