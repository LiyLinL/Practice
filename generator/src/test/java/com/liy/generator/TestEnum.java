package com.liy.generator;

public enum TestEnum {

    OK(999999) {
        public String toString() {
            return String.valueOf(this.getCode());
        }
    },
    NG(100);

    private final int code;

    TestEnum( int i ) {
        this.code = i;
    }

    public int getCode() {
        return code;
    }
}
