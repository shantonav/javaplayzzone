package com.test.how.it.works;

import java.math.BigDecimal;

public class PercentageValidation {

    public static final BigDecimal HUNDRED = BigDecimal.valueOf(100);

    public static void main (String[] a){
        BigDecimal percentage = BigDecimal.valueOf(0.05);
        BigDecimal amount = BigDecimal.valueOf(60);

        System.out.println(isAValidPercentage(percentage,"Percentage fee"));

        System.out.println(amount.multiply(percentage).divide(HUNDRED));

    }

    private static boolean isAValidPercentage(final BigDecimal value, final String fieldName){
        if ( value != null && value.compareTo(BigDecimal.ZERO) >= 0  && value.compareTo(HUNDRED) <= 0){
            return true;
        }
        return false;
    }
}
