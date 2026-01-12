public class TestDriver {

    private static final double EPS = 0.0001;

    public static void main(String[] args) {
        boolean result = test_calculate_price();
        System.out.println();
        System.out.println("Final result: " + (result ? "ALL TESTS PASSED" : "TESTS FAILED"));
    }

    static boolean test_calculate_price() {
        boolean test_ok = true;

        double base = 20000.0;
        double special = 1000.0;
        double extra = 2000.0;

        test_ok &= check("Test 1: no extras, no discount",
                PriceCalculator.calculatePrice(base, special, extra, 0, 0),
                23000.0);

        test_ok &= check("Test 2: 3 extras (10% extra discount)",
                PriceCalculator.calculatePrice(base, special, extra, 3, 0),
                22800.0);

        test_ok &= check("Test 3: 5 extras (15% extra discount)",
                PriceCalculator.calculatePrice(base, special, extra, 5, 0),
                22700.0);

        test_ok &= check("Test 4: dealer discount 12%",
                PriceCalculator.calculatePrice(base, special, extra, 0, 12),
                20600.0);

        test_ok &= check("Test 5: dealer discount + extras discount",
                PriceCalculator.calculatePrice(base, special, extra, 3, 20),
                18800.0);

        return test_ok;
    }

    private static boolean check(String name, double actual, double expected) {
        boolean ok = Math.abs(actual - expected) < EPS;
        System.out.printf("%s -> expected: %.2f | actual: %.2f | %s%n",
                name, expected, actual, ok ? "OK" : "FAIL");
        return ok;
    }
}
