package com.baidu.searchbox.hissug.ioc;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.hissug.ubc.SugDuration;
import com.baidu.searchbox.search.pyramid.SearchBrowserInterface;
import java.util.ArrayList;
import java.util.HashMap;

public class BrowserImpl implements IBrowser {
    private SearchBrowserInterface browserInterface;

    private SearchBrowserInterface getBrowserInterface() {
        if (this.browserInterface == null) {
            this.browserInterface = (SearchBrowserInterface) ServiceManager.getService(SearchBrowserInterface.SERVICE_REFERENCE);
        }
        return this.browserInterface;
    }

    public void launchWebSearchForSearchActivity(Context context, String query, String vType, String sebarstate, String searchSource, boolean newWindow, ArrayList<String> timeInfoArray, HashMap<String, String> params, SugDuration sugDuration) {
        SearchBrowserInterface browserInterface2 = getBrowserInterface();
        if (browserInterface2 != null) {
            browserInterface2.launchWebSearchForSearchActivity(context, query, vType, sebarstate, searchSource, newWindow, timeInfoArray, params, sugDuration);
        }
    }

    public MessageQueue.IdleHandler prepareBrowserAndPreload(Context context) {
        MessageQueue.IdleHandler idleHandler = new BrowserImpl$$ExternalSyntheticLambda0(context);
        Looper.myQueue().addIdleHandler(idleHandler);
        return idleHandler;
    }

    static /* synthetic */ boolean lambda$prepareBrowserAndPreload$0(Context context) {
        SearchBrowserInterface browserInterface2 = (SearchBrowserInterface) ServiceManager.getService(SearchBrowserInterface.SERVICE_REFERENCE);
        if (browserInterface2 == null) {
            return false;
        }
        browserInterface2.prepareBrowserAndPreload(context);
        return false;
    }

    public void removePreloadRunnable() {
        SearchBrowserInterface browserInterface2 = (SearchBrowserInterface) ServiceManager.getService(SearchBrowserInterface.SERVICE_REFERENCE);
        if (browserInterface2 != null) {
            browserInterface2.removePreloadRunnable();
        }
    }

    public void loadUserInputUrl(Context context, String url, String userInputUrl, boolean newWindow) {
        SearchBrowserInterface browserInterface2 = (SearchBrowserInterface) ServiceManager.getService(SearchBrowserInterface.SERVICE_REFERENCE);
        if (browserInterface2 != null) {
            browserInterface2.loadUserInputUrl(context, url, userInputUrl, newWindow);
        }
    }
}
