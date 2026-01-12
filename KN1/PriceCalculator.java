public class PriceCalculator {

    public static double calculatePrice(
            double baseprice,
            double specialprice,
            double extraprice,
            int extras,
            double discount
    ) {
        double addonDiscount;

        if (extras >= 5) {
            addonDiscount = 15.0;
        } else if (extras >= 3) {
            addonDiscount = 10.0;
        } else {
            addonDiscount = 0.0;
        }

        double result =
                baseprice / 100.0 * (100.0 - discount)
                        + specialprice
                        + extraprice / 100.0 * (100.0 - addonDiscount);

        return result;
    }
}
