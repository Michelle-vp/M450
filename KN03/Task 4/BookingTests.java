package ch.schule.bank.junit5;

import ch.schule.Booking;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests für die Klasse Booking.
 *
 * @author Luigi Cavuoti
 * @version 1.1
 */
public class BookingTests {

    /**
     * Tests für die Erzeugung von Buchungen.
     */
    @Test
    public void testInitialization() {
        Booking b = new Booking(12345, 999L);

        assertEquals(12345, b.getDate());
        assertEquals(999L, b.getAmount());
    }

    /**
     * Experimente mit print().
     */
    @Test
    public void testPrint() {
        Booking b = new Booking(0, 1000L);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream old = System.out;
        System.setOut(new PrintStream(out));

        try {
            b.print(0L);
        } finally {
            System.setOut(old);
        }

        String printed = out.toString().trim();
        assertFalse(printed.isBlank());

        String formattedAmount = ch.schule.BankUtils.formatAmount(1000L);
        String formattedFinalBalance = ch.schule.BankUtils.formatAmount(0L + 1000L);

        assertTrue(printed.contains(formattedAmount),
                "Output should contain formatted amount: " + formattedAmount + " but was: " + printed);

        assertTrue(printed.contains(formattedFinalBalance),
                "Output should contain formatted final balance: " + formattedFinalBalance + " but was: " + printed);
    }

}
