package com.epam.rosalind.ba8e;

/**
 * Created by Aleksandr_Kolesov on 5/18/2016.
 */
public class PairC {
    private final String c1;
    private final String c2;
    private final float min;

    public PairC(String c1, String c2, float min) {

        this.c1 = c1;
        this.c2 = c2;
        this.min = min;
    }

    public String getC1() {
        return c1;
    }

    public String getC2() {
        return c2;
    }

    public float getMin() {
        return min;
    }
}
