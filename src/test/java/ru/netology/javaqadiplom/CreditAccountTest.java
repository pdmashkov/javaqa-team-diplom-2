package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldBeSuccessCreateCreditAccount() {
        CreditAccount creditAccount = new CreditAccount(4_000, 10_000, 15);

        int expectedInitBalance = 4_000;
        int actualInitBalance = creditAccount.getBalance();

        Assertions.assertEquals(expectedInitBalance, actualInitBalance);

        int expectedCreditLimit = 10_000;
        int actualCreditLimit = creditAccount.getCreditLimit();

        Assertions.assertEquals(expectedCreditLimit, actualCreditLimit);

        int expectedRate = 15;
        int actualRate = creditAccount.getRate();

        Assertions.assertEquals(expectedRate, actualRate);
    }

    @Test
    public void shouldBeFailedWithNegativeInitBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount creditAccount = new CreditAccount(-12_988, 100_000, 15);
        });
    }

    @Test
    public void shouldBeSuccessWithZeroInitBalance() {
        CreditAccount creditAccount = new CreditAccount(0, 100_000, 15);
    }

    @Test
    public void shouldBeFailedWithNegativeCreditLimit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount creditAccount = new CreditAccount(16_000, -111_233, 15);
        });
    }

    @Test
    public void shouldBeSuccessWithZeroCreditLimit() {
        CreditAccount creditAccount = new CreditAccount(16_000, 0, 15);
    }

    @Test
    public void shouldBeFailedWithNegativeRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount creditAccount = new CreditAccount(900, 5000, -15);
        });
    }

    @Test
    public void shouldBeSuccessCreateCreditAccountWithZeroRate() {
        CreditAccount creditAccount = new CreditAccount(900, 5000, 0);
    }

    @Test
    public void shouldBeSuccessPay() {
        CreditAccount creditAccount = new CreditAccount(5_000, 10_000, 20);

        boolean expectedResult = true;
        boolean actualResult = creditAccount.pay(2_000);

        Assertions.assertEquals(expectedResult, actualResult);

        int expectedBalance = 3_000;
        int actualBalance = creditAccount.getBalance();

        Assertions.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void shouldBeFailedPay() {
        CreditAccount creditAccount = new CreditAccount(0, 5_000, 18);

        boolean expectedResult = false;
        boolean actualResult = creditAccount.pay(12_000);

        Assertions.assertEquals(expectedResult, actualResult);

        int expectedBalance = 0;
        int actualBalance = creditAccount.getBalance();

        Assertions.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void shouldBeFailedPayWithNegativeAmount() {
        CreditAccount creditAccount = new CreditAccount(0, 5_000, 18);

        boolean expectedResult = false;
        boolean actualResult = creditAccount.pay(-12_000);

        Assertions.assertEquals(expectedResult, actualResult);

        int expectedBalance = 0;
        int actualBalance = creditAccount.getBalance();

        Assertions.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void shouldBeFailedPayWithZeroAmount() {
        CreditAccount creditAccount = new CreditAccount(0, 5_000, 18);

        boolean expectedResult = false;
        boolean actualResult = creditAccount.pay(0);

        Assertions.assertEquals(expectedResult, actualResult);

        int expectedBalance = 0;
        int actualBalance = creditAccount.getBalance();

        Assertions.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void shouldBeSuccessAdd() {
        CreditAccount creditAccount = new CreditAccount(2_000, 5_000, 29);

        boolean expectedResult = true;
        boolean actualResult = creditAccount.add(12_000);

        Assertions.assertEquals(expectedResult, actualResult);

        int expectedBalance = 14_000;
        int actualBalance = creditAccount.getBalance();

        Assertions.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void shouldBeFailedAdd() {
        CreditAccount creditAccount = new CreditAccount(32_981, 12_999, 55);

        boolean expected = false;
        boolean actual = creditAccount.add(-10_000);

        Assertions.assertEquals(expected, actual);

        int expectedBalance = 32_981;
        int actualBalance = creditAccount.getBalance();

        Assertions.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void shouldBeFailedAddWithZeroAmount() {
        CreditAccount creditAccount = new CreditAccount(32_981, 12_999, 55);

        boolean expected = false;
        boolean actual = creditAccount.add(0);

        Assertions.assertEquals(expected, actual);

        int expectedBalance = 32_981;
        int actualBalance = creditAccount.getBalance();

        Assertions.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void shouldBeSuccessRateWithNegativeBalance() {
        CreditAccount creditAccount = new CreditAccount(1_000, 5_000, 15);

        creditAccount.pay(1_200);

        int expected = -30;
        int actual = creditAccount.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeSuccessRateWithPositiveBalance() {
        CreditAccount creditAccount = new CreditAccount(100_000, 5_000, 15);

        creditAccount.pay(97_000);

        int expected = 0;
        int actual = creditAccount.yearChange();

        Assertions.assertEquals(expected, actual);
    }
}
