package ch.schule.bank.junit5;

import ch.schule.Account;
import ch.schule.SalaryAccount;
import ch.schule.SavingsAccount;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests für die Klasse Account.
 *
 * @author xxxx
 * @version 1.0
 */
public class AccountTests {

    private int dateOf(int year, int month, int dayInMonth0to29) {
        return (year - 1970) * 360 + (month - 1) * 30 + dayInMonth0to29;
    }

    /**
     * Testet die Initialisierung eines Kontos.
     */
    @Test
    public void testInit() {
        SavingsAccount acc = new SavingsAccount("CH-001");

        assertEquals("CH-001", acc.getId());
        assertEquals(0L, acc.getBalance());
    }

    /**
     * Testet das Einzahlen auf ein Konto.
     */
    @Test
    public void testDeposit() {
        SavingsAccount acc = new SavingsAccount("CH-002");
        int d1 = dateOf(2025, 1, 0);

        assertTrue(acc.deposit(d1, 1000L));
        assertEquals(1000L, acc.getBalance());

        assertFalse(acc.deposit(d1, -50L));
        assertEquals(1000L, acc.getBalance());
    }

    /**
     * Testet das Abheben von einem Konto.
     */
    @Test
    public void testWithdraw() {
        int d1 = dateOf(2025, 1, 0);

        SavingsAccount s = new SavingsAccount("S-001");
        assertTrue(s.deposit(d1, 1000L));
        assertTrue(s.withdraw(d1, 400L));
        assertEquals(600L, s.getBalance());

        assertFalse(s.withdraw(d1, 9999L));
        assertEquals(600L, s.getBalance());

        SalaryAccount sal = new SalaryAccount("L-001", -500L);
        assertTrue(sal.deposit(d1, 1000L));

        assertTrue(sal.withdraw(d1, 1200L));
        assertEquals(-200L, sal.getBalance());

        assertFalse(sal.withdraw(d1, 400L));
        assertEquals(-200L, sal.getBalance());

        assertFalse(s.withdraw(d1, -1L));
        assertFalse(sal.withdraw(d1, -1L));
    }

    /**
     * Tests the reference from SavingsAccount
     */
    @Test
    public void testReferences() {
        Account a = new SavingsAccount("REF-1");
        assertNotNull(a);
        assertEquals("REF-1", a.getId());
        assertTrue(a instanceof SavingsAccount);

        Account b = new SalaryAccount("REF-2", -1000L);
        assertTrue(b instanceof SalaryAccount);
    }

    /**
     * teste the canTransact Flag
     */
    @Test
    public void testCanTransact() {
        SavingsAccount acc = new SavingsAccount("CT-1");
        int d10 = dateOf(2025, 1, 10);
        int d11 = dateOf(2025, 1, 11);
        int d09 = dateOf(2025, 1, 9);

        assertTrue(acc.canTransact(d10));

        assertTrue(acc.deposit(d10, 100L));
        assertEquals(100L, acc.getBalance());

        assertTrue(acc.deposit(d10, 50L));
        assertTrue(acc.withdraw(d11, 10L));

        long before = acc.getBalance();
        assertFalse(acc.deposit(d09, 999L));
        assertFalse(acc.withdraw(d09, 1L));
        assertEquals(before, acc.getBalance());
    }

    /**
     * Experimente mit print().
     */
    @Test
    public void testPrint() {
        SavingsAccount acc = new SavingsAccount("P-1");
        int d1 = dateOf(2025, 1, 0);

        acc.deposit(d1, 100L);
        acc.withdraw(d1, 40L);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream old = System.out;
        System.setOut(new PrintStream(out));

        try {
            acc.print();
        } finally {
            System.setOut(old);
        }

        String printed = out.toString();
        assertTrue(printed.contains("Kontoauszug 'P-1'"));
        assertTrue(printed.contains("Datum"));
        assertTrue(printed.contains("Betrag"));
        assertTrue(printed.contains("Saldo"));
    }

    /**
     * Experimente mit print(year,month).
     */
    @Test
    public void testMonthlyPrint() {
        SavingsAccount acc = new SavingsAccount("MP-1");

        int jan05 = dateOf(2025, 1, 5);
        int feb01 = dateOf(2025, 2, 1);

        acc.deposit(jan05, 100L);
        acc.deposit(feb01, 200L);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream old = System.out;
        System.setOut(new PrintStream(out));

        try {
            acc.print(2025, 1); // January
        } finally {
            System.setOut(old);
        }

        String printed = out.toString();

        assertTrue(printed.contains("Kontoauszug 'MP-1' Monat: 1.2025"));
        assertTrue(printed.contains("Datum"));
        assertFalse(printed.isBlank());
    }
}
