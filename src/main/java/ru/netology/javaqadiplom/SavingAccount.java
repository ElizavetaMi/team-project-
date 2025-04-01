package ru.netology.javaqadiplom;

public class SavingAccount extends Account {
    protected int minBalance;
    protected int maxBalance;

    public SavingAccount(int initialBalance, int minBalance, int maxBalance, int rate) {
        if (minBalance < 0) {
            throw new IllegalArgumentException("Минимальный баланс не может быть отрицательным.");
        }
        if (maxBalance <= minBalance) {
            throw new IllegalArgumentException("Максимальный баланс должен быть больше минимального.");
        }
        if (initialBalance < minBalance || initialBalance > maxBalance) {
            throw new IllegalArgumentException("Начальный баланс должен быть в пределах minBalance и maxBalance.");
        }
        if (rate < 0) {
 
            throw new IllegalArgumentException("Накопительная ставка не может быть отрицательной, а у вас: " + rate);

            
        }

        this.balance = initialBalance;
        this.minBalance = minBalance;
        this.maxBalance = maxBalance;
        this.rate = rate;
    }

    @Override
    public boolean pay(int amount) {
        if (amount <= 0 || balance - amount < minBalance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    @Override
    public boolean add(int amount) {
        if (amount <= 0 || balance + amount > maxBalance) {
            return false;
        }
        balance += amount;
        return true;
    }

    @Override
    public int yearChange() {
        return balance * rate / 100;
    }

    public int getMinBalance() {
        return minBalance;
    }

    public int getMaxBalance() {
        return maxBalance;
    }
}