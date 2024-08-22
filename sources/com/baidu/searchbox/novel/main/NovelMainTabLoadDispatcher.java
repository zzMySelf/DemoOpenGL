package com.baidu.searchbox.novel.main;

import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.searchbox.discovery.novel.NovelLog;
import com.baidu.searchbox.environment.runtime.NovelRuntime;
import java.util.LinkedList;
import java.util.List;

public class NovelMainTabLoadDispatcher {
    private static final int MAX_PENDING_TIME = 5000;
    private static final String TAG = NovelMainTabLoadDispatcher.class.getSimpleName();
    private static NovelMainTabLoadDispatcher sInstance;
    private NovelMainTab mCurrPendingTab;
    private List<NovelMainTab> mPendingTabList = new LinkedList();

    private NovelMainTabLoadDispatcher() {
    }

    public static NovelMainTabLoadDispatcher getInstance() {
        if (sInstance == null) {
            synchronized (NovelMainTabLoadDispatcher.class) {
                if (sInstance == null) {
                    sInstance = new NovelMainTabLoadDispatcher();
                }
            }
        }
        return sInstance;
    }

    public void addPendingNovelTab(NovelMainTab tab) {
        List<NovelMainTab> list = this.mPendingTabList;
        if (list != null && !list.contains(tab)) {
            if (NovelRuntime.DEBUG) {
                NovelLog.d(TAG, "添加一个加载任务 = " + tab);
            }
            this.mPendingTabList.add(tab);
            if (this.mCurrPendingTab == null) {
                executeNext();
            }
        }
    }

    public void executeNow(NovelMainTab tab) {
        if (NovelRuntime.DEBUG) {
            NovelLog.d(TAG, "立即执行 = " + tab);
        }
        List<NovelMainTab> list = this.mPendingTabList;
        if (list != null && list.contains(tab)) {
            this.mPendingTabList.remove(tab);
        }
        tab.onLoadData();
    }

    public void informLastTaskFinished(NovelMainTab tabFinished) {
        if (tabFinished != null && tabFinished == this.mCurrPendingTab) {
            if (NovelRuntime.DEBUG) {
                NovelLog.d(TAG, "加载任务完成 = " + tabFinished);
            }
            this.mCurrPendingTab = null;
            executeNext();
        }
    }

    public boolean isTabExecuting(NovelMainTab novelTab) {
        if (this.mCurrPendingTab == novelTab) {
            return true;
        }
        return false;
    }

    public boolean isTabInQueue(NovelMainTab novelTab) {
        List<NovelMainTab> list = this.mPendingTabList;
        if (list == null || !list.contains(novelTab)) {
            return false;
        }
        return true;
    }

    public void release() {
        this.mPendingTabList.clear();
        this.mCurrPendingTab = null;
        sInstance = null;
    }

    private void executeNext() {
        List<NovelMainTab> list = this.mPendingTabList;
        if (list != null && list.size() != 0) {
            final NovelMainTab novelTab = this.mPendingTabList.remove(0);
            if (NovelRuntime.DEBUG) {
                NovelLog.d(TAG, "正在执行任务 = " + novelTab);
            }
            novelTab.onLoadData();
            this.mCurrPendingTab = novelTab;
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    NovelMainTabLoadDispatcher.this.informLastTaskFinished(novelTab);
                }
            }, 5000);
        }
    }
}
