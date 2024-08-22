package com.baidu.webkit.sdk.system;

import com.baidu.webkit.sdk.WebBackForwardList;
import com.baidu.webkit.sdk.WebHistoryItem;
import java.lang.reflect.Method;

final class WebBackForwardListImpl extends WebBackForwardList implements Cloneable {
    private static Method cloneMethod;
    private final android.webkit.WebBackForwardList mList;

    static {
        try {
            cloneMethod = android.webkit.WebBackForwardList.class.getDeclaredMethod("clone", (Class[]) null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    static WebBackForwardList from(android.webkit.WebBackForwardList webBackForwardList) {
        if (webBackForwardList == null) {
            return null;
        }
        return new WebBackForwardListImpl(webBackForwardList);
    }

    private WebBackForwardListImpl(android.webkit.WebBackForwardList webBackForwardList) {
        this.mList = webBackForwardList;
    }

    public final WebHistoryItem getCurrentItem() {
        return WebHistoryItemImpl.from(this.mList.getCurrentItem());
    }

    public final int getCurrentIndex() {
        return this.mList.getCurrentIndex();
    }

    public final WebHistoryItem getItemAtIndex(int i2) {
        return WebHistoryItemImpl.from(this.mList.getItemAtIndex(i2));
    }

    public final int getSize() {
        return this.mList.getSize();
    }

    public final WebBackForwardList clone() {
        android.webkit.WebBackForwardList webBackForwardList;
        try {
            Method method = cloneMethod;
            if (!(method == null || (webBackForwardList = this.mList) == null)) {
                return from((android.webkit.WebBackForwardList) method.invoke(webBackForwardList, (Object[]) null));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }
}
