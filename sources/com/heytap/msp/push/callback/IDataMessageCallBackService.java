package com.heytap.msp.push.callback;

import android.content.Context;
import com.heytap.msp.push.mode.DataMessage;

public interface IDataMessageCallBackService {
    void processMessage(Context context, DataMessage dataMessage);
}
