package com.baidu.crius;

public enum CriusDimension {
    WIDTH(0),
    HEIGHT(1);
    
    private int mIntValue;

    private CriusDimension(int intValue) {
        this.mIntValue = intValue;
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static CriusDimension fromInt(int value) {
        switch (value) {
            case 0:
                return WIDTH;
            case 1:
                return HEIGHT;
            default:
                if (!CriusConstants.DEBUG) {
                    return WIDTH;
                }
                throw new IllegalArgumentException("Unknown enum value: " + value);
        }
    }
}
