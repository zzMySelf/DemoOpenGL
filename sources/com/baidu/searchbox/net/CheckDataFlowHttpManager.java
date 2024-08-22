package com.baidu.searchbox.net;

import android.content.Context;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.RequestHandler;
import com.baidu.searchbox.net.common.ioc.LegacyHttpRuntime;
import java.io.IOException;

public class CheckDataFlowHttpManager extends HttpManager {
    private static volatile CheckDataFlowHttpManager checkDataFlowHttpManager;

    private CheckDataFlowHttpManager(final Context context) {
        super(context);
        setRequestHandler(new RequestHandler() {
            public void preExecuteRequest() throws IOException {
                if (LegacyHttpRuntime.getContext().isDataFlowPopDialog(context)) {
                    throw new IOException("user has not confirmed flow pop dialog!");
                }
            }
        });
    }

    public static CheckDataFlowHttpManager getDefault(Context context) {
        if (checkDataFlowHttpManager == null) {
            synchronized (CheckDataFlowHttpManager.class) {
                if (checkDataFlowHttpManager == null) {
                    checkDataFlowHttpManager = new CheckDataFlowHttpManager(context);
                }
            }
        }
        return checkDataFlowHttpManager;
    }

    public static CheckDataFlowHttpManager newHttpManager(Context context) {
        return new CheckDataFlowHttpManager(context);
    }
}
