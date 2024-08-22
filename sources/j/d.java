package j;

import c.b;
import com.sina.weibo.sdk.web.WebActivity;
import j.b;

public final class d implements b<String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b.a f7780a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f7781b;

    public d(e eVar, WebActivity.a aVar) {
        this.f7781b = eVar;
        this.f7780a = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0071 A[Catch:{ JSONException -> 0x008a }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.String r4 = (java.lang.String) r4
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "handle image result :"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "WbShareTag"
            g.c.a(r1, r0)
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L_0x009f
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x008a }
            r0.<init>(r4)     // Catch:{ JSONException -> 0x008a }
            java.lang.String r4 = "code"
            int r4 = r0.optInt(r4)     // Catch:{ JSONException -> 0x008a }
            java.lang.String r1 = "data"
            java.lang.String r0 = r0.optString(r1)     // Catch:{ JSONException -> 0x008a }
            r1 = 1
            if (r4 != r1) goto L_0x0079
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x008a }
            if (r4 != 0) goto L_0x0079
            j.e r4 = r3.f7781b     // Catch:{ JSONException -> 0x008a }
            r4.f7787h = r0     // Catch:{ JSONException -> 0x008a }
            j.b$a r4 = r3.f7780a     // Catch:{ JSONException -> 0x008a }
            if (r4 == 0) goto L_0x00af
            com.sina.weibo.sdk.web.WebActivity$a r4 = (com.sina.weibo.sdk.web.WebActivity.a) r4     // Catch:{ JSONException -> 0x008a }
            com.sina.weibo.sdk.web.WebActivity r0 = com.sina.weibo.sdk.web.WebActivity.this     // Catch:{ JSONException -> 0x008a }
            j.b r0 = r0.f5621f     // Catch:{ JSONException -> 0x008a }
            java.lang.String r0 = r0.a()     // Catch:{ JSONException -> 0x008a }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x008a }
            if (r2 != 0) goto L_0x00af
            com.sina.weibo.sdk.web.WebActivity r2 = com.sina.weibo.sdk.web.WebActivity.this     // Catch:{ JSONException -> 0x008a }
            r2.getClass()     // Catch:{ JSONException -> 0x008a }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x008a }
            if (r2 != 0) goto L_0x006e
            java.lang.String r2 = "https://service.weibo.com/share/mobilesdk.php"
            boolean r2 = r0.startsWith(r2)     // Catch:{ JSONException -> 0x008a }
            if (r2 != 0) goto L_0x006f
            java.lang.String r2 = "https://open.weibo.cn/oauth2/authorize?"
            boolean r2 = r0.startsWith(r2)     // Catch:{ JSONException -> 0x008a }
            if (r2 == 0) goto L_0x006e
            goto L_0x006f
        L_0x006e:
            r1 = 0
        L_0x006f:
            if (r1 == 0) goto L_0x00af
            com.sina.weibo.sdk.web.WebActivity r4 = com.sina.weibo.sdk.web.WebActivity.this     // Catch:{ JSONException -> 0x008a }
            android.webkit.WebView r4 = r4.f5619d     // Catch:{ JSONException -> 0x008a }
            r4.loadUrl(r0)     // Catch:{ JSONException -> 0x008a }
            goto L_0x00af
        L_0x0079:
            j.b$a r4 = r3.f7780a     // Catch:{ JSONException -> 0x008a }
            if (r4 == 0) goto L_0x00af
            java.lang.String r0 = "图片内容不合适，禁止上传！"
            com.sina.weibo.sdk.web.WebActivity$a r4 = (com.sina.weibo.sdk.web.WebActivity.a) r4     // Catch:{ JSONException -> 0x008a }
            com.sina.weibo.sdk.web.WebActivity r4 = com.sina.weibo.sdk.web.WebActivity.this     // Catch:{ JSONException -> 0x008a }
            i.b r4 = r4.f5622g     // Catch:{ JSONException -> 0x008a }
            r4.a(r0)     // Catch:{ JSONException -> 0x008a }
            goto L_0x00af
        L_0x008a:
            r4 = move-exception
            r4.printStackTrace()
            j.b$a r4 = r3.f7780a
            if (r4 == 0) goto L_0x00af
            com.sina.weibo.sdk.web.WebActivity$a r4 = (com.sina.weibo.sdk.web.WebActivity.a) r4
            com.sina.weibo.sdk.web.WebActivity r4 = com.sina.weibo.sdk.web.WebActivity.this
            i.b r4 = r4.f5622g
            java.lang.String r0 = "解析服务端返回的字符串时发生异常！"
            r4.a(r0)
            goto L_0x00af
        L_0x009f:
            j.b$a r4 = r3.f7780a
            if (r4 == 0) goto L_0x00af
            com.sina.weibo.sdk.web.WebActivity$a r4 = (com.sina.weibo.sdk.web.WebActivity.a) r4
            com.sina.weibo.sdk.web.WebActivity r4 = com.sina.weibo.sdk.web.WebActivity.this
            i.b r4 = r4.f5622g
            java.lang.String r0 = "处理图片，服务端返回null!"
            r4.a(r0)
        L_0x00af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j.d.a(java.lang.Object):void");
    }

    public final void a(Throwable th2) {
        b.a aVar = this.f7780a;
        if (aVar != null) {
            WebActivity.this.f5622g.a(th2.getMessage());
        }
    }
}
