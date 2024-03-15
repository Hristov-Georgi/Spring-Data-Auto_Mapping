package XMLProcessing.carDealerEx.entity;

import java.util.Random;

public enum Discount {

    ZERO(0),
    FIVE(5),
    TEN(10),
    FIFTEEN(15),
    TWENTY(20),
    THIRTY(30),
    FORTY(40),
    FIFTY(50);

    private final int discount;

    private Discount(int discount) {
        this.discount = discount;
    }

    private static final Random RND = new Random();

    public static Discount getRandomDiscount() {
        Discount[] discounts = values();
        return discounts[RND.nextInt(discounts.length)];
    }

    public int getDiscount() {
        return discount;
    }
}
