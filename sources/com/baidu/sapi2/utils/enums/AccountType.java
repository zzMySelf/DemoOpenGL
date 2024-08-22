package com.baidu.sapi2.utils.enums;

public enum AccountType {
    NORMAL(0),
    INCOMPLETE_USER(1),
    UNKNOWN(2);
    
    private int type;

    private AccountType(int type2) {
        this.type = type2;
    }

    public int getType() {
        return this.type;
    }

    public static AccountType getAccountType(int type2) {
        switch (type2) {
            case 0:
                return NORMAL;
            case 1:
                return INCOMPLETE_USER;
            default:
                return UNKNOWN;
        }
    }
}
