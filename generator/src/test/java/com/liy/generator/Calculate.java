package com.liy.generator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Calculate {


    /**
     * 加總
     *
     * @param decimals
     * @return
     */
    public static BigDecimal sum( List<BigDecimal> decimals ) {
        return decimals.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * 平均數
     *
     * @param decimals
     * @return
     */
    public static BigDecimal mean( List<BigDecimal> decimals ) {
        BigDecimal sum = sum(decimals);

        if (sum.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }

        return sum.divide(new BigDecimal(decimals.size()), 8, RoundingMode.HALF_UP);
    }

    /**
     * 標準差
     *
     * @param decimals
     * @return
     */
    public static BigDecimal standard( List<BigDecimal> decimals ) {
        // 平均
        BigDecimal mean = mean(decimals);

        if (mean.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }

        // 方差
        BigDecimal variance = decimals.stream()
                .reduce(BigDecimal.ZERO, ( pre, decimal ) ->
                        decimal.subtract(mean).pow(2)
                                .setScale(8, RoundingMode.HALF_UP)
                                .add(pre));

        variance = variance.divide(new BigDecimal(decimals.size()), 8, RoundingMode.HALF_UP);
        // 標準差
        return new BigDecimal(String.valueOf(Math.sqrt(variance.doubleValue())))
                .setScale(8, RoundingMode.HALF_UP);
    }

    public static BigDecimal ck( BigDecimal mean, BigDecimal usl, BigDecimal lsl, BigDecimal center ) {
        boolean flag = side(usl, lsl);

        if (flag) {
            // 雙邊
            BigDecimal decimal1 = center.subtract(mean).abs();

            if (decimal1.compareTo(BigDecimal.ZERO) == 0) {
                return BigDecimal.ZERO;
            }

            BigDecimal decimal2 = usl.subtract(lsl).divide(new BigDecimal(2), 8, RoundingMode.HALF_UP);

            return decimal1.divide(decimal2, 8, RoundingMode.HALF_UP);
        }

        // 單邊
        return null;
    }

    public static BigDecimal cp( BigDecimal sigma, BigDecimal mean, BigDecimal usl, BigDecimal lsl ) {
        boolean flag = side(usl, lsl);

        BigDecimal decimal1 = BigDecimal.ZERO;
        BigDecimal decimal2;

        if (sigma.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }

        if (flag) {
            decimal1 = usl.subtract(lsl);
            decimal2 = sigma.multiply(new BigDecimal(6));

            return decimal1.divide(decimal2, 8, RoundingMode.HALF_UP);
        }

        decimal2 = sigma.multiply(new BigDecimal(3));
        if (usl != null) {
            decimal1 = usl.subtract(mean).abs();
        } else if (lsl != null) {
            decimal1 = lsl.subtract(mean).abs();
        }

        if (decimal1.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }

        return decimal1.divide(decimal2, 8, RoundingMode.HALF_UP);
    }

    public static BigDecimal cpk( BigDecimal ck, BigDecimal cp ) {
        if (ck != null) {
            BigDecimal one = BigDecimal.ONE;

            return one.subtract(ck).multiply(cp);
        }

        return cp;
    }

    private static boolean side( BigDecimal usl, BigDecimal lsl ) {
        // 單邊 or 雙邊
        return usl != null && lsl != null;
    }
}
