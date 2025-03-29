package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldNotAddNegativeAmount() {
        CreditAccount account = new CreditAccount(0, 5_000, 15);
        boolean result = account.add(-1_000);
        Assertions.assertFalse(result);
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldNotAddZeroAmount() {
        CreditAccount account = new CreditAccount(0, 5_000, 15);
        boolean result = account.add(0);
        Assertions.assertFalse(result);
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldPayWithinCreditLimit() {
        CreditAccount account = new CreditAccount(2_000, 5_000, 15);
        boolean result = account.pay(6_000);
        Assertions.assertTrue(result);
        Assertions.assertEquals(-4_000, account.getBalance());
    }

    @Test
    public void shouldNotPayExceedingCreditLimit() {
        CreditAccount account = new CreditAccount(1_000, 5_000, 15);
        boolean result = account.pay(7_000);
        Assertions.assertFalse(result);
        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void shouldNotPayNegativeAmount() {
        CreditAccount account = new CreditAccount(2_000, 5_000, 15);
        boolean result = account.pay(-500);
        Assertions.assertFalse(result);
        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldCalculateYearChangeForNegativeBalance() {
        CreditAccount account = new CreditAccount(-3_000, 5_000, 20);
        int interest = account.yearChange();
        Assertions.assertEquals(-600, interest);
    }

    @Test
    public void shouldCalculateYearChangeForPositiveBalance() {
        CreditAccount account = new CreditAccount(3_000, 5_000, 20);
        int interest = account.yearChange();
        Assertions.assertEquals(0, interest);
    }

    @Test
    public void shouldThrowExceptionForNegativeInitialBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CreditAccount(-1_000, 5_000, 15));
    }

    @Test
    public void shouldThrowExceptionForNegativeCreditLimit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CreditAccount(1_000, -5_000, 15));
    }

    @Test
    public void shouldThrowExceptionForZeroRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CreditAccount(1_000, 5_000, 0));
    }
}

