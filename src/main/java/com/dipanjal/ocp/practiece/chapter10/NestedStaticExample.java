package com.dipanjal.ocp.practiece.chapter10;

/**
 * @author dipanjal
 * @since 4/21/2021
 */

public class NestedStaticExample {
    private static final String FAST_DELIVER;
    private static final String REGULAR_DELIVER;
    static {
        FAST_DELIVER = "FAST";
        REGULAR_DELIVER = "REGULAR";
    }

    private ShippingMode shippingMode;

    public NestedStaticExample() {
        this.shippingMode = createShippingMode();
    }

    public NestedStaticExample(ShippingMode shippingMode) {
        this.shippingMode = shippingMode;
    }

    public ShippingMode getShippingMode() {
        return shippingMode;
    }

    public static ShippingMode createShippingMode(){
        return new ShippingMode();
    }

    public static ShippingMode createShippingMode(String deliveryMode){
        return new ShippingMode(deliveryMode);
    }

    private static class ShippingMode {
        private String deliveryMode;

        public ShippingMode() {
            this.deliveryMode = REGULAR_DELIVER;
        }

        public ShippingMode(String deliveryMode) {
            this.deliveryMode = deliveryMode;
        }
    }

    public static void main(String[] args) {
        NestedStaticExample example = new NestedStaticExample();
        NestedStaticExample example2 = new NestedStaticExample(createShippingMode(FAST_DELIVER));
        System.out.println("ahdskahskdhas");
    }
}
