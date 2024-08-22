package com.baidu.searchbox.ng.browser.yalog;

import com.baidu.browser.sailor.ISailorYalogInterface;
import com.baidu.searchbox.retrieve.upload.UploadHelper;
import com.baidu.yalog.Logger;
import com.baidu.yalog.LoggerManager;
import java.util.List;
import org.json.JSONObject;

public class ZeusYalogImpl implements ISailorYalogInterface {
    private static final String LOG_TAG = "ZeusYalogImpl";
    private static ZeusYalogImpl sYalogImpl = null;

    private ZeusYalogImpl() {
    }

    public static ZeusYalogImpl getInstance() {
        if (sYalogImpl == null) {
            synchronized (ZeusYalogImpl.class) {
                if (sYalogImpl == null) {
                    sYalogImpl = new ZeusYalogImpl();
                }
            }
        }
        return sYalogImpl;
    }

    public void log(String space, String msg, boolean flush) {
        Logger logger = LoggerManager.getLogger(space);
        logger.n(msg);
        if (flush) {
            logger.flush(true);
        }
    }

    public void activeUpload(String type, String dataId, String source, List<String> spaces, long maxSizeLimit, long startTime, long endTime) {
        UploadHelper.getInstance().activeUpload(type, dataId, spaces, source, maxSizeLimit, startTime, endTime, (JSONObject) null);
    }
}
