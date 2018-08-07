package pl.sda.homework.account;


public class Account {
    private double balance;
    private int soldedBooks;

    public Account() {
        this.balance = 0;
        this.soldedBooks = 0;
    }

    public double getBalance() {
        return balance;
    }

    public int getSoldedBooks() {
        return soldedBooks;
    }

    public void addMoneyToAccount(double value) {
        this.balance += value;
        this.soldedBooks++;
    }

}
