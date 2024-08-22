package com.baidu.location.provider;

import android.content.Intent;
import android.telephony.CellInfo;
import java.util.List;

public class KeyEventListener {
    public boolean onCellInfo(List<CellInfo> list) {
        return true;
    }

    public boolean receiveActions(Intent intent) {
        return true;
    }

    public void setLog(String str) {
    }
}
