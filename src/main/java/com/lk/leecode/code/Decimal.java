package com.lk.leecode.code;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Decimal {


    public static void main(String[] args) {
        BigDecimal deductionHappened = BigDecimal.valueOf(193);
        BigDecimal deductionSuccess = BigDecimal.valueOf(69);
        BigDecimal real = deductionSuccess.multiply(BigDecimal.valueOf(100)).divide(deductionHappened, 2, RoundingMode.DOWN);
        System.out.println(real);
    }
}
