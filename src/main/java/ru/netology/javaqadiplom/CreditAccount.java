package ru.netology.javaqadiplom;

public class CreditAccount {
    private int balance;
    private final int creditLimit;
    private final int rate;

    public CreditAccount(int initialBalance, int creditLimit, int rate) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Начальный баланс не может быть отрицательным: " + initialBalance);
        }
        if (creditLimit < 0) {
            throw new IllegalArgumentException("Кредитный лимит не может быть отрицательным: " + creditLimit);
        }
        if (rate <= 0) {
            throw new IllegalArgumentException("Ставка должна быть больше 0: " + rate);
        }
        this.balance = initialBalance;
        this.creditLimit = creditLimit;
        this.rate = rate;
    }


    public int getBalance() {
        return balance;
    }

    public boolean add(int amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    public boolean pay(int amount) {
        if (amount <= 0) {
            return false;
        }
        if (balance - amount < -creditLimit) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public int yearChange() {
        if (balance < 0) {
            return (balance * rate) / 100;
        }
        return 0; // Если баланс положительный — проценты не начисляются
    }

}