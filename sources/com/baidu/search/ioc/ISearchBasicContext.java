package com.baidu.search.ioc;

import android.content.Context;
import com.baidu.searchbox.database.SearchableType;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\bf\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cJ\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J.\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH&Jz\u0010\u000f\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&¨\u0006\u001d"}, d2 = {"Lcom/baidu/search/ioc/ISearchBasicContext;", "", "getDefaultSearchType", "Lcom/baidu/searchbox/database/SearchableType;", "context", "Landroid/content/Context;", "getVerticalSearchType", "setCookieManualNoBdussOperate", "", "url", "", "cookieValue", "sync", "", "funcName", "showDownloadDialog", "method", "requestHeader", "responseHeader", "contentDisposition", "mimeType", "preReferer", "referer", "userAgent", "contentLength", "", "postData", "", "Companion", "lib_search_basic_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ISearchBasicContext.kt */
public interface ISearchBasicContext {
    public static final Companion Companion = Companion.$$INSTANCE;

    SearchableType getDefaultSearchType(Context context);

    SearchableType getVerticalSearchType(Context context);

    void setCookieManualNoBdussOperate(String str, String str2, boolean z, String str3);

    void showDownloadDialog(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, long j2, byte[] bArr);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/search/ioc/ISearchBasicContext$Companion;", "", "()V", "EMPTY", "Lcom/baidu/search/ioc/ISearchBasicContext;", "getEMPTY", "()Lcom/baidu/search/ioc/ISearchBasicContext;", "lib_search_basic_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ISearchBasicContext.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final ISearchBasicContext EMPTY = new ISearchBasicContext$Companion$EMPTY$1();

        private Companion() {
        }

        public final ISearchBasicContext getEMPTY() {
            return EMPTY;
        }
    }
}
