package com.baidu.searchbox.titantest;

import android.util.Log;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AnonymousTester {
    public static final String TAG = "TitanTest";
    private static volatile AnonymousTester sInstance;
    private ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();

    private AnonymousTester() {
    }

    public static synchronized AnonymousTester getInstance() {
        AnonymousTester anonymousTester;
        synchronized (AnonymousTester.class) {
            if (sInstance == null) {
                sInstance = new AnonymousTester();
            }
            anonymousTester = sInstance;
        }
        return anonymousTester;
    }

    public void testAnonymousClass() {
        this.singleThreadPool.execute(new Runnable() {
            public void run() {
                Log.d("TitanTest", "runnable 1");
            }
        });
        this.singleThreadPool.execute(new Runnable() {
            public void run() {
                Log.d("TitanTest", "runnable 2");
            }
        });
        this.singleThreadPool.execute(new Runnable() {
            public void run() {
                Log.d("TitanTest", "runnable 3");
            }
        });
    }
}
