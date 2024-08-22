package com.baidu.browser.explore.mutable.personalrecommend;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0018\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013J$\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u0017\u001a\u00020\u000fJ\u001a\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003R\u000e\u0010\u0006\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/baidu/browser/explore/mutable/personalrecommend/CardConsumer;", "", "lid", "", "order", "(Ljava/lang/String;Ljava/lang/String;)V", "CONSUME_URI", "TAG", "getLid", "()Ljava/lang/String;", "setLid", "(Ljava/lang/String;)V", "getOrder", "setOrder", "consumeCardInfo", "", "context", "Landroid/content/Context;", "handler", "Lcom/baidu/searchbox/unitedscheme/CallbackHandler;", "requestRecommendInfo", "source", "type", "resetContainer", "updateConsumeinfo", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardConsumer.kt */
public final class CardConsumer {
    private final String CONSUME_URI;
    private final String TAG;
    private String lid;
    private String order;

    public CardConsumer() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public CardConsumer(String lid2, String order2) {
        this.lid = lid2;
        this.order = order2;
        this.TAG = "CardConsumer";
        this.CONSUME_URI = "baiduboxapp://browser/resultPageDeepConsume";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CardConsumer(String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getLid() {
        return this.lid;
    }

    public final String getOrder() {
        return this.order;
    }

    public final void setLid(String str) {
        this.lid = str;
    }

    public final void setOrder(String str) {
        this.order = str;
    }

    public final void updateConsumeinfo(String lid2, String order2) {
        CharSequence charSequence = this.lid;
        boolean z = false;
        if (charSequence == null || charSequence.length() == 0) {
            CharSequence charSequence2 = this.order;
            if (charSequence2 == null || charSequence2.length() == 0) {
                z = true;
            }
            if (z) {
                this.lid = lid2;
                this.order = order2;
            }
        }
    }

    public final void consumeCardInfo(Context context, CallbackHandler handler) {
        String it;
        String it2;
        Intrinsics.checkNotNullParameter(handler, "handler");
        CharSequence charSequence = this.lid;
        boolean z = false;
        if (!(charSequence == null || charSequence.length() == 0)) {
            CharSequence charSequence2 = this.order;
            if (charSequence2 == null || charSequence2.length() == 0) {
                z = true;
            }
            if (!z) {
                try {
                    Router.invokeScheme(context, Uri.parse(this.CONSUME_URI).buildUpon().appendQueryParameter("action", "getConsumeParams").build(), "inside", handler);
                } catch (IllegalArgumentException e2) {
                    if (AppConfig.isDebug() && (it = e2.getLocalizedMessage()) != null) {
                        Log.d(this.TAG, it);
                    }
                } catch (UnsupportedOperationException e3) {
                    if (AppConfig.isDebug() && (it2 = e3.getLocalizedMessage()) != null) {
                        Log.d(this.TAG, it2);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034 A[Catch:{ IllegalArgumentException -> 0x0091, UnsupportedOperationException -> 0x007c, JSONException -> 0x0068 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0048 A[Catch:{ IllegalArgumentException -> 0x0091, UnsupportedOperationException -> 0x007c, JSONException -> 0x0068 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void requestRecommendInfo(android.content.Context r6, java.lang.String r7, java.lang.String r8) {
        /*
            r5 = this;
            if (r6 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.String r0 = r5.CONSUME_URI
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.net.Uri$Builder r0 = r0.buildUpon()
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ IllegalArgumentException -> 0x0091, UnsupportedOperationException -> 0x007c, JSONException -> 0x0068 }
            r1.<init>()     // Catch:{ IllegalArgumentException -> 0x0091, UnsupportedOperationException -> 0x007c, JSONException -> 0x0068 }
            java.lang.String r2 = "lid"
            java.lang.String r3 = r5.lid     // Catch:{ IllegalArgumentException -> 0x0091, UnsupportedOperationException -> 0x007c, JSONException -> 0x0068 }
            r1.put(r2, r3)     // Catch:{ IllegalArgumentException -> 0x0091, UnsupportedOperationException -> 0x007c, JSONException -> 0x0068 }
            java.lang.String r2 = "order"
            java.lang.String r3 = r5.order     // Catch:{ IllegalArgumentException -> 0x0091, UnsupportedOperationException -> 0x007c, JSONException -> 0x0068 }
            r1.put(r2, r3)     // Catch:{ IllegalArgumentException -> 0x0091, UnsupportedOperationException -> 0x007c, JSONException -> 0x0068 }
            r2 = r7
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ IllegalArgumentException -> 0x0091, UnsupportedOperationException -> 0x007c, JSONException -> 0x0068 }
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0031
            int r2 = r2.length()     // Catch:{ IllegalArgumentException -> 0x0091, UnsupportedOperationException -> 0x007c, JSONException -> 0x0068 }
            if (r2 != 0) goto L_0x002f
            goto L_0x0031
        L_0x002f:
            r2 = r3
            goto L_0x0032
        L_0x0031:
            r2 = r4
        L_0x0032:
            if (r2 != 0) goto L_0x003a
            java.lang.String r2 = "source"
            r1.put(r2, r7)     // Catch:{ IllegalArgumentException -> 0x0091, UnsupportedOperationException -> 0x007c, JSONException -> 0x0068 }
        L_0x003a:
            r2 = r8
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ IllegalArgumentException -> 0x0091, UnsupportedOperationException -> 0x007c, JSONException -> 0x0068 }
            if (r2 == 0) goto L_0x0045
            int r2 = r2.length()     // Catch:{ IllegalArgumentException -> 0x0091, UnsupportedOperationException -> 0x007c, JSONException -> 0x0068 }
            if (r2 != 0) goto L_0x0046
        L_0x0045:
            r3 = r4
        L_0x0046:
            if (r3 != 0) goto L_0x004e
            java.lang.String r2 = "type"
            r1.put(r2, r8)     // Catch:{ IllegalArgumentException -> 0x0091, UnsupportedOperationException -> 0x007c, JSONException -> 0x0068 }
        L_0x004e:
            java.lang.String r2 = "action"
            java.lang.String r3 = "startConsumeRequest"
            android.net.Uri$Builder r2 = r0.appendQueryParameter(r2, r3)     // Catch:{ IllegalArgumentException -> 0x0091, UnsupportedOperationException -> 0x007c, JSONException -> 0x0068 }
            java.lang.String r3 = "data"
            java.lang.String r4 = r1.toString()     // Catch:{ IllegalArgumentException -> 0x0091, UnsupportedOperationException -> 0x007c, JSONException -> 0x0068 }
            r2.appendQueryParameter(r3, r4)     // Catch:{ IllegalArgumentException -> 0x0091, UnsupportedOperationException -> 0x007c, JSONException -> 0x0068 }
            android.net.Uri r2 = r0.build()     // Catch:{ IllegalArgumentException -> 0x0091, UnsupportedOperationException -> 0x007c, JSONException -> 0x0068 }
            com.baidu.searchbox.Router.invokeScheme(r6, r2)     // Catch:{ IllegalArgumentException -> 0x0091, UnsupportedOperationException -> 0x007c, JSONException -> 0x0068 }
            goto L_0x00a5
        L_0x0068:
            r1 = move-exception
            boolean r2 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r2 == 0) goto L_0x00a5
            java.lang.String r2 = r1.getLocalizedMessage()
            if (r2 == 0) goto L_0x00a5
            r3 = 0
            java.lang.String r4 = r5.TAG
            android.util.Log.d(r4, r2)
            goto L_0x00a5
        L_0x007c:
            r1 = move-exception
            boolean r2 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r2 == 0) goto L_0x00a5
            java.lang.String r2 = r1.getLocalizedMessage()
            if (r2 == 0) goto L_0x0090
            r3 = 0
            java.lang.String r4 = r5.TAG
            android.util.Log.d(r4, r2)
            goto L_0x00a5
        L_0x0090:
            goto L_0x00a5
        L_0x0091:
            r1 = move-exception
            boolean r2 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r2 == 0) goto L_0x00a5
            java.lang.String r2 = r1.getLocalizedMessage()
            if (r2 == 0) goto L_0x00a5
            r3 = 0
            java.lang.String r4 = r5.TAG
            android.util.Log.d(r4, r2)
        L_0x00a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.browser.explore.mutable.personalrecommend.CardConsumer.requestRecommendInfo(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public final void resetContainer() {
        this.lid = null;
        this.order = null;
    }
}
