

public class ExpresionIfElse {

    public static void main(String[] args) {
         
      /**
      * if (booleanExpression) {statements}
      * [else if (booleanExpression) {statements}]
      * [else {statements}]
      */

        double discountPercent = 0.2;
        int subtotal = 0;
        String shippingMethod;
        String customerType = "";

        /**
      * Ejemplo I
      */
        if (subtotal >= 100 && subtotal < 200) {
            discountPercent = 0.1;
        } else if (subtotal >= 200 && subtotal < 300) {
            discountPercent = 0.2;
        } else if (subtotal >= 300) {
            discountPercent = 0.3;

        } else {
            discountPercent = 0.05;
        }

        /**
         * Ejemplo II
         */

        if (customerType.equals("R")) {
            discountPercent = 0.1;
            shippingMethod = "UPS";

        } else if (customerType.equals("C")) {
            discountPercent = 0.2;
            shippingMethod = "Bulk";

        } else {
            shippingMethod = "USPS";
        }

        /**
      * Ejemplo III
      */

        if (customerType.equals("C")) {

            if (subtotal >= 100) {
                discountPercent = 0.2;
            } else {
                discountPercent = 0.1;
            }
        } else {
                discountPercent = 0.4;
        }

    }
}
