package pl.sda.homework.account;

public class Account {
    private double account;

    public Account() {
        this.account = 0;
    }

    public double getAccount() {
        return account;
    }

    public void addMoneyToAccount(double value) {
        this.account += value;
    }
}
