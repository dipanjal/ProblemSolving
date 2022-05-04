package com.dipanjal.ocp.practiece.chapter10;

/**
 * @author dipanjal
 * @since 4/21/2021
 */

public class NestedMemberExample {
    private static final String FAST_DELIVER;
    private static final String REGULAR_DELIVER;
    static {
        FAST_DELIVER = "FAST";
        REGULAR_DELIVER = "REGULAR";
    }

    private ShippingMode shippingMode;

    public NestedMemberExample() {
        this.shippingMode = createShippingMode();
    }

    public NestedMemberExample(ShippingMode shippingMode) {
        this.shippingMode = shippingMode;
    }

    public ShippingMode getShippingMode() {
        return shippingMode;
    }

    public void setShippingMode(ShippingMode shippingMode) {
        this.shippingMode = shippingMode;
    }

    public ShippingMode createShippingMode(){
        return new ShippingMode();
    }

    public ShippingMode createShippingMode(String deliveryMode){
        return new ShippingMode(deliveryMode);
    }

    /** Belongs to instances */
    private class ShippingMode {
        private String deliveryMode;

        public ShippingMode() {
            this.deliveryMode = REGULAR_DELIVER;
        }

        public ShippingMode(String deliveryMode) {
            this.deliveryMode = deliveryMode;
        }
    }

    public static void main(String[] args) {
        NestedMemberExample example = new NestedMemberExample();
        /**
         * Fails here;
         * ShippingMode is a member inner class, which doesn't exists without NestedMemberExample class
         * We can not create ShippingMode without instantiating NestedMemberExample class
         */
//        ShippingMode s = new ShippingMode(FAST_DELIVER);

        /** WORKS FINE */
        NestedMemberExample example2 = new NestedMemberExample();
        example2.setShippingMode(example.createShippingMode(FAST_DELIVER));
        System.out.println("ahdskahskdhas");
    }
}
