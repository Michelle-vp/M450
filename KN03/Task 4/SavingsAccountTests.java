package ch.schule.bank.junit5;

import ch.schule.SavingsAccount;



/**
 * Tests f�r die Klasse SavingsAccount.
 *
 * @author Roger H. J&ouml;rg
 * @version 1.0
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests für die Klasse SavingsAccount.
 *
 * @author XXX
 * @version 1.0
 */
public class SavingsAccountTests {

    private int dateOf(int year, int month, int dayInMonth0to29) {
        return (year - 1970) * 360 + (month - 1) * 30 + dayInMonth0to29;
    }

    @Test
    public void test() {
        SavingsAccount acc = new SavingsAccount("S-1");
        int d1 = dateOf(2025, 1, 0);

        assertEquals(0L, acc.getBalance());

        assertTrue(acc.deposit(d1, 500L));
        assertEquals(500L, acc.getBalance());

        assertTrue(acc.withdraw(d1, 200L));
        assertEquals(300L, acc.getBalance());

        assertFalse(acc.withdraw(d1, 9999L));
        assertEquals(300L, acc.getBalance());

        assertFalse(acc.withdraw(d1, -1L));
        assertEquals(300L, acc.getBalance());
    }
}

