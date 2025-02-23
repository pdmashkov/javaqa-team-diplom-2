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
    public void shouldBeSuccessCreateCreditAccount() {
        CreditAccount creditAccount = new CreditAccount(27_987, 12_500, 52);

        int expectedBalance = 27_987;
        int actualBalance = creditAccount.getBalance();

        Assertions.assertEquals(expectedBalance, actualBalance);

        int expectedCreditLimit = 12_500;
        int actualCreditLimit = creditAccount.getCreditLimit();

        Assertions.assertEquals(expectedCreditLimit, actualCreditLimit);

        int expectedRate = 52;
        int actualRate = creditAccount.getRate();

        Assertions.assertEquals(expectedRate, actualRate);
    }

    @Test
    public void shouldBeSuccessWithNegativeInitBalance() {
        CreditAccount creditAccount = new CreditAccount(-15_000, 15_000, 15);

        int expected = -15_000;
        int actual = creditAccount.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeFailedWithNegativeBalanceMoreCreditLimit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount creditAccount = new CreditAccount(-10_000, 5000, 150);
        });
    }

    @Test
    public void shouldBeFailedWithNegativeCreditLimit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount creditAccount = new CreditAccount(0, -10_000, 20);
        });
    }

    @Test
    public void shouldBeFailedWithNegativeRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount creditAccount = new CreditAccount(10_000, 12_000, -11);
        });
    }

    @Test
    public void shouldBeSuccessWithZeroRate() {
        CreditAccount creditAccount = new CreditAccount(12_781, 15_100, 0);

        int expected = 0;
        int actual = creditAccount.getRate();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeSuccessPay() {
        CreditAccount creditAccount = new CreditAccount(1_000, 5000, 15);

        boolean expected = true;
        boolean actual = creditAccount.pay(4_791);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeFailedPay() {
        CreditAccount creditAccount = new CreditAccount(0, 10_000, 71);

        int expectedInitBalance = creditAccount.getBalance();

        boolean expected = false;
        boolean actual = creditAccount.pay(12_700);

        Assertions.assertEquals(expected, actual);

        int actualBalance = creditAccount.getBalance();

        Assertions.assertEquals(expectedInitBalance, actualBalance);
    }

    @Test
    public void shouldBeSuccessAddBalance() {
        CreditAccount creditAccount = new CreditAccount(5_000, 15_000, 34);

        creditAccount.add(27_000);

        int expected = 32_000;
        int actual = creditAccount.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeSuccessAddBalanceWithZeroInitBalance() {
        CreditAccount creditAccount = new CreditAccount(0, 15_000, 34);

        creditAccount.add(27_000);

        int expected = 27_000;
        int actual = creditAccount.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeFailedAddBalance() {
        CreditAccount creditAccount = new CreditAccount(0, 0, 10);

        int expectedInitBalance = creditAccount.getBalance();

        boolean expected = false;
        boolean actual = creditAccount.add(-10_000);

        Assertions.assertEquals(expected, actual);

        int actualBalance = creditAccount.getBalance();

        Assertions.assertEquals(expectedInitBalance, actualBalance);
    }

    @Test
    public void shouldBeSuccessYearChangeWithNegativeBalance() {
        CreditAccount creditAccount = new CreditAccount(-2_000, 10000, 27);

        int expected = -540;
        int actual = creditAccount.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeSuccessYearChangeWithPositiveBalance() {
        CreditAccount creditAccount = new CreditAccount(1_000_000, 95_000, 93);

        int expected = 0;
        int actual = creditAccount.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeSuccessYearChangeWithZeroBalance() {
        CreditAccount creditAccount = new CreditAccount(0, 95_000, 93);

        int expected = 0;
        int actual = creditAccount.yearChange();

        Assertions.assertEquals(expected, actual);
    }
}
