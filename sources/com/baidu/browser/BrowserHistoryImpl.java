package com.baidu.browser;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.browser.ioc.IBrowserHistory;
import com.baidu.browser.speech.VoiceDirectDBControl;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\"\u0010\u000f\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u0011"}, d2 = {"Lcom/baidu/browser/BrowserHistoryImpl;", "Lcom/baidu/browser/ioc/IBrowserHistory;", "()V", "getConstantBundleKeyHisSource", "", "getConstantHisSourceFromBrowser", "getConstantHistoryFragmentId", "getConstantTplFeedAd", "getConstantTplSearchTextUrl", "voiceDirectDBOnCreate", "", "db", "Landroid/database/sqlite/SQLiteDatabase;", "newVersion", "", "voiceDirectDBOnUpdate", "oldVersion", "lib-browser-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BrowserHistoryImpl.kt */
public final class BrowserHistoryImpl implements IBrowserHistory {
    public void voiceDirectDBOnCreate(SQLiteDatabase db, int newVersion) {
        VoiceDirectDBControl.getInstance().onCreate(db, newVersion);
    }

    public void voiceDirectDBOnUpdate(SQLiteDatabase db, int oldVersion, int newVersion) {
        VoiceDirectDBControl.getInstance().onUpgrade(db, oldVersion, newVersion);
    }

    public String getConstantBundleKeyHisSource() {
        return "source";
    }

    public String getConstantHisSourceFromBrowser() {
        return "from_browser";
    }

    public String getConstantHistoryFragmentId() {
        return "history";
    }

    public String getConstantTplSearchTextUrl() {
        return "search_text_url";
    }

    public String getConstantTplFeedAd() {
        return "feed_ad";
    }
}
