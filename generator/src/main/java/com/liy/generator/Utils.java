package com.liy.generator;

import com.liy.generator.exception.ExtExpection;

public class Utils {

    public static void ThrowException( String msg, Object[] objects) {
        throw new ExtExpection(msg, objects);
    }

    public static boolean isNumber( String str ) {
        return str.matches("[+-]?\\d*(\\.\\d+)?");
    }
}
