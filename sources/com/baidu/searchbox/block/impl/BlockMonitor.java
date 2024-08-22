package com.baidu.searchbox.block.impl;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.aperf.param.ThreadCollector;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.debug.smooth.LogLine;
import com.baidu.searchbox.ruka.ioc.IBlockMonitor;
import com.github.anrwatchdog.ANRError;
import com.github.anrwatchdog.ANRWatchDog;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Locale;

public class BlockMonitor implements IBlockMonitor {
    private static final int DEFAULT_BLOCK_TIMEOUT = 2000;
    private static final String SEPARATOR = "\r\n";
    private static final String TAG = "Ruka";
    public static final SimpleDateFormat TIME_FORMATTER = new SimpleDateFormat(LogLine.LOGCAT_DATE_FORMAT, Locale.US);
    public static String sBlockTimeStamp = null;
    private ANRWatchDog mBlockWatchDog = null;
    private boolean mMonitorStarted = false;

    public void startBlockMonitor(int blockTimeOut) {
        if (!this.mMonitorStarted) {
            this.mMonitorStarted = true;
            ANRWatchDog aNRWatchDog = new ANRWatchDog(blockTimeOut);
            this.mBlockWatchDog = aNRWatchDog;
            aNRWatchDog.setReportMainThreadOnly();
            this.mBlockWatchDog.setCollectAllTimeMainStackTrace(true);
            this.mBlockWatchDog.setANRListener(new BlockListenerImpl());
            if (AppConfig.isDebug()) {
                Log.d(TAG, "start mBlockWatchDog = " + this.mBlockWatchDog.getName() + " Monitor");
            }
            this.mBlockWatchDog.start();
        }
    }

    public void stopBlockMonitor() {
        ANRWatchDog aNRWatchDog;
        if (this.mMonitorStarted && (aNRWatchDog = this.mBlockWatchDog) != null) {
            aNRWatchDog.interrupt();
            this.mMonitorStarted = false;
        }
    }

    public boolean enableMonitor() {
        return BlockRuntime.getInstance().enableBlock();
    }

    private static class BlockListenerImpl implements ANRWatchDog.ANRListener {
        private BlockListenerImpl() {
        }

        public void onAppNotResponding(ANRError anrError) {
            Log.d(BlockMonitor.TAG, "BlockWatchDog catch block", anrError);
            BlockMonitor.collectData(anrError.getSTStackMap());
        }
    }

    /* access modifiers changed from: private */
    public static void collectData(LinkedHashMap<Long, StackTraceElement[]> stackMap) {
        if (AppRuntime.getAppContext() != null) {
            sBlockTimeStamp = String.valueOf(System.currentTimeMillis());
            String stackTrace = null;
            if (stackMap != null && stackMap.size() > 0) {
                stackTrace = getThreadStackEntries(stackMap);
            }
            if (TextUtils.isEmpty(stackTrace)) {
                stackTrace = ThreadCollector.getMainThreadStackTrace();
            }
            BlockContext.getBlockContext().onAppBlock(AppRuntime.getAppContext(), new BlockInfo(sBlockTimeStamp, stackTrace));
        }
    }

    public static String stack2String(StackTraceElement[] stes) {
        StringBuilder sb = new StringBuilder();
        if (stes != null) {
            try {
                if (stes.length >= 1) {
                    StackTraceElement[] var3 = stes;
                    int var4 = stes.length;
                    for (int var5 = 0; var5 < var4; var5++) {
                        sb.append(var3[var5].toString() + "\r\n");
                    }
                }
            } catch (Exception var7) {
                Log.e("ThreadCollector", "ThreadInfo Collector Interrupted!!", var7);
            }
        }
        return sb.toString();
    }

    public static String getThreadStackEntries(LinkedHashMap<Long, StackTraceElement[]> sStackMap) {
        StringBuilder formatSB = new StringBuilder();
        for (Long entryTime : sStackMap.keySet()) {
            formatSB.append(TIME_FORMATTER.format(entryTime)).append("\r\n").append(stack2String(sStackMap.get(entryTime))).append("\r\n").append("\r\n");
        }
        return formatSB.toString();
    }
}
