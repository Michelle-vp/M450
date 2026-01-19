package ch.schule.bank.junit5;

import ch.schule.PromoYouthSavingsAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests für das Promo-Jugend-Sparkonto.
 *
 * @author XXXX
 * @version 1.0
 */
public class PromoYouthSavingsAccountTests {

    private int dateOf(int year, int month, int dayInMonth0to29) {
        return (year - 1970) * 360 + (month - 1) * 30 + dayInMonth0to29;
    }

    /**
     * Der Test.
     */
    @Test
    public void test() {
        PromoYouthSavingsAccount acc = new PromoYouthSavingsAccount("Y-1");
        int d1 = dateOf(2025, 1, 0);

        assertTrue(acc.deposit(d1, 1000L));
        assertEquals(1010L, acc.getBalance());

        assertTrue(acc.deposit(d1, 99L));
        assertEquals(1109L, acc.getBalance());

        assertFalse(acc.deposit(d1, -100L));
        assertEquals(1109L, acc.getBalance());
    }
}
