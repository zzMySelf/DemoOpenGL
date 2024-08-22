package com.baidu.crius;

public enum CriusEdge {
    LEFT(0),
    TOP(1),
    RIGHT(2),
    BOTTOM(3),
    HORIZONTAL(4),
    VERTICAL(5),
    ALL(6);
    
    private int mIntValue;

    private CriusEdge(int intValue) {
        this.mIntValue = intValue;
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static CriusEdge fromInt(int value) {
        switch (value) {
            case 0:
                return LEFT;
            case 1:
                return TOP;
            case 2:
                return RIGHT;
            case 3:
                return BOTTOM;
            case 4:
                return HORIZONTAL;
            case 5:
                return VERTICAL;
            case 6:
                return ALL;
            default:
                if (!CriusConstants.DEBUG) {
                    return LEFT;
                }
                throw new IllegalArgumentException("Unknown enum value: " + value);
        }
    }
}
