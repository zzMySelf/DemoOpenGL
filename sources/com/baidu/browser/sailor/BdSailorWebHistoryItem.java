package com.baidu.browser.sailor;

import android.graphics.Bitmap;
import android.graphics.Picture;
import com.baidu.webkit.sdk.WebHistoryItem;

public class BdSailorWebHistoryItem {
    private WebHistoryItem mItem;

    public void setUserData(int i2, Object obj) {
    }

    public Object getUserData(int i2) {
        return null;
    }

    public int getKey() {
        return -1;
    }

    protected BdSailorWebHistoryItem(WebHistoryItem webHistoryItem) {
        this.mItem = webHistoryItem;
    }

    public Bitmap getFavicon() {
        return this.mItem.getFavicon();
    }

    public String getOriginalUrl() {
        return this.mItem.getOriginalUrl();
    }

    public String getTitle() {
        return this.mItem.getTitle();
    }

    public String getUrl() {
        return this.mItem.getUrl();
    }

    public String getTouchIconUrl() {
        return this.mItem.getTouchIconUrl();
    }

    public Picture getSnapshot() {
        return this.mItem.getScreenshot();
    }

    @Deprecated
    public int getVisibleTitleHeight() {
        return this.mItem.getVisibleTitleHeight();
    }

    public String toString() {
        return getUrl();
    }
}
