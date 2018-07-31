package pl.sda.homework.account;

import pl.sda.homework.bookStorage.BookStorage;

public class Account extends BookStorage {
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
