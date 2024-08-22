package com.baidu.talos.core.render.viewshot;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.MessageQueue;
import com.baidu.talos.TalosAppRuntimeInit;
import com.baidu.talos.core.bridge.GuardedAsyncTask;
import com.baidu.talos.util.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CleanTask extends GuardedAsyncTask<Void, Void> implements TalosAppRuntimeInit.IAppRuntimeCallback {
    private static final long EXPIRATION = 3600000;
    private static final JunkFileProviderManager PROVIDER_MANAGER = new JunkFileProviderManager();
    private volatile long initTs = 0;

    public CleanTask() {
        super((Context) null);
    }

    /* access modifiers changed from: protected */
    public void doInBackgroundGuarded(Void... voids) {
        List<IJunkFileProvider> providers;
        Application application = TalosAppRuntimeInit.getAppContext();
        if (application != null && (providers = PROVIDER_MANAGER.getProviders()) != null) {
            List<File> files = new ArrayList<>();
            for (IJunkFileProvider provider : providers) {
                List<File> tmpFiles = provider.getFiles(application, this.initTs);
                if (tmpFiles != null) {
                    files.addAll(tmpFiles);
                }
            }
            for (File file : files) {
                FileUtils.deleteFile(file);
            }
        }
    }

    public void onAttachApplication(Application app) {
        this.initTs = System.currentTimeMillis();
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            public boolean queueIdle() {
                CleanTask.this.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return false;
            }
        });
    }
}
