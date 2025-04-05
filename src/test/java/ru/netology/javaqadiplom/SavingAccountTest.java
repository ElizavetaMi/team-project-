package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    
    @Test
    public void shouldNotAddMoreThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                9_000, // начальный баланс
                1_000, // минимальный баланс
                10_000, // максимальный баланс
                5 // процентная ставка
        );

        boolean result = account.add(2_000); // попытка пополнить на 2_000, что превысит максимальный баланс

        Assertions.assertFalse(result);
        Assertions.assertEquals(9_000, account.getBalance()); // баланс остается на 9_000
    }

    @Test
    public void shouldNotAddNegativeAmount() {
        SavingAccount account = new SavingAccount(
                5_000, // начальный баланс
                1_000, // минимальный баланс
                10_000, // максимальный баланс
                5 // процентная ставка
        );

        boolean result = account.add(-1_000); // попытка пополнить на отрицательную сумму

        Assertions.assertFalse(result);
        Assertions.assertEquals(5_000, account.getBalance()); // баланс остается на 5_000
    }

    @Test
    public void shouldNotAddZeroAmount() {
        SavingAccount account = new SavingAccount(
                3_000, // начальный баланс
                1_000, // минимальный баланс
                10_000, // максимальный баланс
                5 // процентная ставка
        );

        boolean result = account.add(0); // попытка пополнить на 0

        Assertions.assertFalse(result);
        Assertions.assertEquals(3_000, account.getBalance()); // баланс остается на 3_000
    }

    @Test
    public void shouldCalculateYearChangeCorrectly() {
        SavingAccount account = new SavingAccount(
                4_000, // начальный баланс
                1_000, // минимальный баланс
                10_000, // максимальный баланс
                5 // процентная ставка
        );

        int interest = account.yearChange(); // расчет процентов за год (5% от 4_000)

        Assertions.assertEquals(200, interest); // ожидаемые проценты: 4_000 * 5 / 100 = 200
    }
}