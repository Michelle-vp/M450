package ch.schule.bank.junit5;

import ch.schule.Bank;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests f�r die Klasse 'Bank'.
 *
 * @author xxxx
 * @version 1.0
 */
public class BankTests {

    private int dateOf(int year, int month, int dayInMonth0to29) {
        return (year - 1970) * 360 + (month - 1) * 30 + dayInMonth0to29;
    }

    /**
     * Tests to create new Accounts
     */
    @Test
    public void testCreate() {
        Bank bank = new Bank();

        String sId = bank.createSavingsAccount();
        assertNotNull(sId);
        assertTrue(sId.startsWith("S-"));

        String yId = bank.createPromoYouthSavingsAccount();
        assertNotNull(yId);
        assertTrue(yId.startsWith("Y-"));

        String pId = bank.createSalaryAccount(-500);
        assertNotNull(pId);
        assertTrue(pId.startsWith("P-"));

        assertNull(bank.createSalaryAccount(500));
    }

    /**
     * Testet das Einzahlen auf ein Konto.
     */
    @Test
    public void testDeposit() {
        Bank bank = new Bank();
        String id = bank.createSavingsAccount();

        int d1 = dateOf(2025, 1, 0);

        assertTrue(bank.deposit(id, d1, 1000L));
        assertEquals(1000L, bank.getBalance(id));

        assertFalse(bank.deposit(id, d1, -10L));
        assertEquals(1000L, bank.getBalance(id));

        assertFalse(bank.deposit("DOES-NOT-EXIST", d1, 100L));
    }

    /**
     * Testet das Abheben von einem Konto.
     */
    @Test
    public void testWithdraw() {
        Bank bank = new Bank();
        String id = bank.createSavingsAccount();
        int d1 = dateOf(2025, 1, 0);

        bank.deposit(id, d1, 500L);

        assertTrue(bank.withdraw(id, d1, 200L));
        assertEquals(300L, bank.getBalance(id));

        assertFalse(bank.withdraw(id, d1, 9999L));
        assertEquals(300L, bank.getBalance(id));

        assertFalse(bank.withdraw(id, d1, -1L));
        assertEquals(300L, bank.getBalance(id));

        assertFalse(bank.withdraw("NOPE", d1, 10L));
    }

    /**
     * Experimente mit print().
     */
    @Test
    public void testPrint() {
        Bank bank = new Bank();
        String id = bank.createSavingsAccount();
        int d1 = dateOf(2025, 1, 0);

        bank.deposit(id, d1, 100L);
        bank.withdraw(id, d1, 40L);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream old = System.out;
        System.setOut(new PrintStream(out));

        try {
            bank.print(id);
        } finally {
            System.setOut(old);
        }

        String printed = out.toString();
        assertTrue(printed.contains("Kontoauszug"));
        assertTrue(printed.contains(id));
        assertTrue(printed.contains("Datum"));
        assertTrue(printed.contains("Betrag"));
        assertTrue(printed.contains("Saldo"));

        bank.print("UNKNOWN-ID");
    }

    /**
     * Experimente mit print(year, month).
     */
    @Test
    public void testMonthlyPrint() {
        Bank bank = new Bank();
        String id = bank.createSavingsAccount();

        int jan05 = dateOf(2025, 1, 5);
        int feb01 = dateOf(2025, 2, 1);

        bank.deposit(id, jan05, 100L);
        bank.deposit(id, feb01, 200L);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream old = System.out;
        System.setOut(new PrintStream(out));

        try {
            bank.print(id, 2025, 1);
        } finally {
            System.setOut(old);
        }

        String printed = out.toString();
        assertTrue(printed.contains("Monat: 1.2025"));
        assertTrue(printed.contains(id));
        assertTrue(printed.contains("Datum"));
        assertTrue(printed.contains("Betrag"));
        assertTrue(printed.contains("Saldo"));

        bank.print("UNKNOWN-ID", 2025, 1);
    }

    /**
     * Testet den Gesamtkontostand der Bank.
     */
    @Test
    public void testBalance() {
        Bank bank = new Bank();
        int d1 = dateOf(2025, 1, 0);

        String a = bank.createSavingsAccount();
        String b = bank.createSavingsAccount();

        bank.deposit(a, d1, 1000L);
        bank.deposit(b, d1, 500L);

        assertEquals(-(1000L + 500L), bank.getBalance());

        bank.withdraw(a, d1, 200L);
        assertEquals(-(800L + 500L), bank.getBalance());

        assertEquals(0L, bank.getBalance("UNKNOWN"));
    }

    /**
     * Tested die Ausgabe der "top 5" konten.
     */
    @Test
    public void testTop5() {
        Bank bank = new Bank();
        int d1 = dateOf(2025, 1, 0);

        String id1 = bank.createSavingsAccount(); bank.deposit(id1, d1, 100L);
        String id2 = bank.createSavingsAccount(); bank.deposit(id2, d1, 500L);
        String id3 = bank.createSavingsAccount(); bank.deposit(id3, d1, 300L);
        String id4 = bank.createSavingsAccount(); bank.deposit(id4, d1, 200L);
        String id5 = bank.createSavingsAccount(); bank.deposit(id5, d1, 400L);
        String id6 = bank.createSavingsAccount(); bank.deposit(id6, d1, 50L);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream old = System.out;
        System.setOut(new PrintStream(out));

        try {
            bank.printTop5();
        } finally {
            System.setOut(old);
        }

        String printed = out.toString();
        assertFalse(printed.isBlank());
        assertTrue(printed.contains("S-"));
    }

    /**
     * Tested die Ausgabe der "bottom 5" konten.
     */
    @Test
    public void testBottom5() {
        Bank bank = new Bank();
        int d1 = dateOf(2025, 1, 0);

        String id1 = bank.createSavingsAccount(); bank.deposit(id1, d1, 100L);
        String id2 = bank.createSavingsAccount(); bank.deposit(id2, d1, 500L);
        String id3 = bank.createSavingsAccount(); bank.deposit(id3, d1, 300L);
        String id4 = bank.createSavingsAccount(); bank.deposit(id4, d1, 200L);
        String id5 = bank.createSavingsAccount(); bank.deposit(id5, d1, 400L);
        String id6 = bank.createSavingsAccount(); bank.deposit(id6, d1, 50L);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream old = System.out;
        System.setOut(new PrintStream(out));

        try {
            bank.printBottom5();
        } finally {
            System.setOut(old);
        }

        String printed = out.toString();
        assertFalse(printed.isBlank());
        assertTrue(printed.contains("S-"));
    }
}
