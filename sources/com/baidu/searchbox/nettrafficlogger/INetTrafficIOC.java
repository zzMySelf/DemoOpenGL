package com.baidu.searchbox.nettrafficlogger;

import android.content.Context;

public interface INetTrafficIOC {
    public static final INetTrafficIOC EMPTY = new INetTrafficIOC() {
        public void checkSendStatisData(Context context) {
        }
    };

    void checkSendStatisData(Context context);
}
