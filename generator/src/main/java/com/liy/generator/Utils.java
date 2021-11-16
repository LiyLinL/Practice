package com.liy.generator;

import com.liy.generator.exception.ExtExpection;

public class Utils {

    public static void ThrowException( String msg, Object[] objects) {
        throw new ExtExpection(msg, objects);
    }
}
