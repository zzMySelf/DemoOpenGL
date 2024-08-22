package com.baidu.swan.card.pkg.model;

public interface PkgState {
    public static final int DEFAULT = -1;
    public static final int LOCAL = 4;
    public static final int LOCAL_BY_MAXAGE = 3;
    public static final int PENDING_MAXAGE_CHECK = 99;
    public static final int PRESET = 5;
    public static final int REMOT = 0;
    public static final int REMOT_BY_LOCALERR = 2;
    public static final int REMOT_BY_MAXAGE = 1;
}
