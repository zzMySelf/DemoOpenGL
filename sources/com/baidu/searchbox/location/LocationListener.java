package com.baidu.searchbox.location;

import com.baidu.searchbox.NoProGuard;

public interface LocationListener extends NoProGuard {
    public static final int NO_PERMISSION = 5;
    public static final int NO_SCENE_PERMISSION = 6;
    public static final int OTHER_ERROR = 4;
    public static final int REQUEST_FREQUENT = 2;
    public static final int SDK_NOT_INIT = 3;
    public static final int SERVER_ERROR = 1;

    void onError(int i2);

    void onReceiveLocation(LocationInfo locationInfo);
}
