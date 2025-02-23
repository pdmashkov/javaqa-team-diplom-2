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
    public void shouldAddMoreMaxBalance() {
        SavingAccount account = new SavingAccount(
                3_000,
                1_000,
                5_000,
                5
        );

        boolean expected = false;
        boolean actual = account.add(3_000);

        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(3000, account.getBalance());
    }

    @Test
    public void shouldAddLessMinBalance() {
        SavingAccount account = new SavingAccount(
                0,
                1_000,
                5_000,
                5
        );

        boolean expected = false;
        boolean actual = account.add(500);

        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldMoreMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    5_000,
                    10_000,
                    5_000,
                    5);
        });
    }

    @Test
    public void shouldLessInitialBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    -5_000,
                    10_000,
                    15_000,
                    5);
        });
    }

    @Test
    public void shouldLessMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    5_000,
                    -10_000,
                    15_000,
                    5);
        });
    }

    @Test
    public void shouldLessMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    5_000,
                    5_000,
                    -7_000,
                    5);
        });
    }

    @Test
    public void testPayNormal() {
        SavingAccount account = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5
        );

        account.pay(2_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void testPayLessBalance() {
        SavingAccount account = new SavingAccount(
                1_500,
                1_000,
                10_000,
                5
        );

        boolean expected = false;
        boolean actual = account.pay(2_000);

        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(1_500, account.getBalance());
    }

    @Test
    public void testPayMoreBalance() {
        SavingAccount account = new SavingAccount(
                1_500,
                1_000,
                10_000,
                5
        );

        boolean expected = false;
        boolean actual = account.pay(20_000);

        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(1_500, account.getBalance());
    }

    @Test
    public void testYearChanceNormal() {
        SavingAccount account = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5
        );
        int expected = 250;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testYearChanceLessRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    5_000,
                    1_000,
                    10_000,
                    -5);
        });
    }

    @Test
    public void testYearChanceMoreRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    5_000,
                    1_000,
                    10_000,
                    500);
        });
    }

    @Test
    public void testGetMinBalance() {
        SavingAccount account = new SavingAccount(
                1_500,
                1_000,
                10_000,
                5
        );

        account.getMinBalance();

        Assertions.assertEquals(1_000, account.getMinBalance());
    }

    @Test
    public void testGetMaxBalance() {
        SavingAccount account = new SavingAccount(
                1_500,
                1_000,
                10_000,
                5
        );

        account.getMaxBalance();

        Assertions.assertEquals(10_000, account.getMaxBalance());
    }

    @Test
    public void testPayLessSum() {
        SavingAccount account = new SavingAccount(
                1_500,
                1_000,
                10_000,
                5
        );

        boolean expected = false;
        boolean actual = account.pay(-2_500);

        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(1_500, account.getBalance());
    }
}
