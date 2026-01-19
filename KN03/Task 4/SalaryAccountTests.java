package ch.schule.bank.junit5;

import ch.schule.SalaryAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests der Klasse SalaryAccount.
 *
 * @author XXX
 * @version 1.1
 */
public class SalaryAccountTests {

    private int dateOf(int year, int month, int dayInMonth0to29) {
        return (year - 1970) * 360 + (month - 1) * 30 + dayInMonth0to29;
    }

    /**
     * Der Test.
     */
    @Test
    public void test() {
        int d1 = dateOf(2025, 1, 0);

        SalaryAccount acc = new SalaryAccount("P-1", -500L);

        assertTrue(acc.deposit(d1, 1000L));
        assertEquals(1000L, acc.getBalance());

        assertTrue(acc.withdraw(d1, 1200L));
        assertEquals(-200L, acc.getBalance());

        assertFalse(acc.withdraw(d1, 400L));
        assertEquals(-200L, acc.getBalance());

        assertFalse(acc.withdraw(d1, -1L));
        assertEquals(-200L, acc.getBalance());
    }
}
