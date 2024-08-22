package com.baidu.android.pushservice.a0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.baidu.android.pushservice.R;
import com.baidu.android.pushservice.util.Utility;
import org.json.JSONException;
import org.json.JSONObject;

public class j extends g {
    public j(Context context, int i2, String str) {
        super(context, i2, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = android.os.Build.VERSION.SDK_INT;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String b() {
        /*
            r2 = this;
            android.content.Context r0 = r2.f7938a
            boolean r0 = com.baidu.android.pushservice.util.Utility.H(r0)
            if (r0 == 0) goto L_0x0015
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r0 < r1) goto L_0x0015
            r1 = 29
            if (r0 > r1) goto L_0x0015
            java.lang.String r0 = "101"
            goto L_0x0019
        L_0x0015:
            java.lang.String r0 = super.b()
        L_0x0019:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.a0.j.b():java.lang.String");
    }

    public RemoteViews c() {
        String str;
        String str2 = "";
        int i2 = R.string.bd_push_red_envelope;
        int i3 = R.layout.bd_push_notification_red_env_style;
        if (Utility.P(this.f7938a) || (Utility.G(this.f7938a) && Build.VERSION.SDK_INT <= 30)) {
            i3 = R.layout.bd_push_notification_red_env_style_vivo;
        }
        int i4 = R.id.bd_push_title;
        int i5 = R.id.bd_push_tv_app_name;
        int i6 = R.id.bd_push_iv_bg;
        try {
            JSONObject jSONObject = new JSONObject(this.f7939b);
            str = jSONObject.optString("title");
            try {
                str2 = jSONObject.optString("appname");
            } catch (JSONException e2) {
            }
        } catch (JSONException e3) {
            str = str2;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.f7938a.getResources().getString(i2);
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = Utility.g(this.f7938a);
        }
        if (!Utility.O(this.f7938a)) {
            return null;
        }
        RemoteViews remoteViews = new RemoteViews(this.f7938a.getPackageName(), i3);
        remoteViews.setTextViewText(i4, str);
        remoteViews.setTextViewText(i5, str2);
        if (Utility.P(this.f7938a)) {
            remoteViews.setImageViewBitmap(i6, Utility.a(100, 100, "#FF9C34"));
        }
        return remoteViews;
    }

    public boolean e() {
        return Utility.y(this.f7938a);
    }
}
