package com.baidu.searchbox.schemedispatch.united.module;

import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J¸\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062&\u0010\b\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b2&\u0010\f\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b2&\u0010\r\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b2&\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011H\u0016¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/schemedispatch/united/module/UnitedSchemeResultPageNaAdapter;", "", "()V", "handleAPageTalosTcLog", "", "type", "", "iteration", "clkInfoObjParams", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "extraObjParams", "urlParams", "extra", "handleFetchRecAfterClick", "data", "Lorg/json/JSONArray;", "handleFresh", "url", "handlePageLogSend", "handleSendPzLogUrl", "logUrl", "handleTalosScheme", "", "talosScheme", "Lcom/baidu/searchbox/unitedscheme/UnitedSchemeEntity;", "refreshNaView", "refreshData", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UnitedSchemeResultPageNaAdapter.kt */
public abstract class UnitedSchemeResultPageNaAdapter {
    public void handleFetchRecAfterClick(JSONArray data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public void handleFresh(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
    }

    public void handlePageLogSend(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public void handleSendPzLogUrl(String logUrl) {
        Intrinsics.checkNotNullParameter(logUrl, "logUrl");
    }

    public void handleAPageTalosTcLog(int type, int iteration, HashMap<String, String> clkInfoObjParams, HashMap<String, String> extraObjParams, HashMap<String, String> urlParams, HashMap<String, String> extra) {
    }

    public boolean handleTalosScheme(UnitedSchemeEntity talosScheme) {
        Intrinsics.checkNotNullParameter(talosScheme, "talosScheme");
        return false;
    }

    public void refreshNaView(JSONArray refreshData) {
    }
}
