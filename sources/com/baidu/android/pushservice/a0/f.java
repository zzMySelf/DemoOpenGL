package com.baidu.android.pushservice.a0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.widget.RemoteViews;
import com.baidu.android.pushservice.R;
import com.baidu.android.pushservice.s.a;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.searchbox.feed.model.FeedPrefixTagDataKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f extends g {

    /* renamed from: j  reason: collision with root package name */
    public boolean f7937j = false;
    public boolean k = false;
    public String l;
    public String m;
    public String n;
    public String o = "";
    public String p = "";
    public Bitmap q;
    public String r = "";
    public String s = "";
    public String t = "";

    public f(Context context, int i2, String str) {
        super(context, i2, str);
    }

    public final void a(RemoteViews remoteViews) {
        if (!TextUtils.isEmpty(this.f7941d)) {
            remoteViews.setViewVisibility(R.id.bd_push_txv_content_title, 0);
            remoteViews.setTextViewText(R.id.bd_push_txv_content_title, this.f7941d);
            remoteViews.setTextColor(R.id.bd_push_txv_content_title, this.f7945h);
        }
        if (this.q != null) {
            float applyDimension = TypedValue.applyDimension(1, 59.0f, this.f7938a.getResources().getDisplayMetrics());
            Bitmap a2 = Utility.a(Utility.a(this.q, applyDimension, applyDimension), (int) (TypedValue.applyDimension(1, 10.0f, this.f7938a.getResources().getDisplayMetrics()) - 5.0f), 1);
            this.q = a2;
            remoteViews.setImageViewBitmap(R.id.bd_push_img_goods, a2);
        }
        remoteViews.setTextViewText(R.id.bd_push_txv_goods_desc, this.t);
        if (!TextUtils.isEmpty(this.r)) {
            remoteViews.setViewVisibility(R.id.bd_push_txv_goods_price1, 0);
            remoteViews.setTextViewText(R.id.bd_push_txv_goods_price1, this.r);
        }
        if (!TextUtils.isEmpty(this.s)) {
            remoteViews.setViewVisibility(R.id.bd_push_lyt_goods_price2, 0);
            remoteViews.setTextViewText(R.id.bd_push_txv_goods_price2, this.s);
        }
    }

    public final void a(RemoteViews remoteViews, int i2, int i3, float f2, float f3) {
        if (!TextUtils.isEmpty(this.n)) {
            remoteViews.setImageViewBitmap(i2, Utility.a((Drawable) Utility.a(-1, (int) TypedValue.applyDimension(1, 17.5f, this.f7938a.getResources().getDisplayMetrics()), -1, "", this.n), (int) TypedValue.applyDimension(1, f2, this.f7938a.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, f3, this.f7938a.getResources().getDisplayMetrics())));
        }
        if (!TextUtils.isEmpty(this.m)) {
            remoteViews.setTextColor(i3, Color.parseColor(this.m));
        }
    }

    public final void b(RemoteViews remoteViews) {
        Bitmap a2;
        if (!TextUtils.isEmpty(this.p) && (a2 = a.a().a(this.p)) != null) {
            remoteViews.setViewVisibility(R.id.bd_push_img_bg, 0);
            remoteViews.setImageViewBitmap(R.id.bd_push_img_bg, a2);
        } else if (!TextUtils.isEmpty(this.o)) {
            remoteViews.setInt(R.id.bd_push_container, "setBackgroundColor", Color.parseColor(this.o));
        }
    }

    public RemoteViews c() {
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(this.f7939b);
            JSONObject optJSONObject = jSONObject2.optJSONObject("goods");
            if (optJSONObject == null) {
                return null;
            }
            this.t = optJSONObject.optString("title");
            String optString = optJSONObject.optString("img");
            if (!TextUtils.isEmpty(this.t)) {
                if (!TextUtils.isEmpty(optString)) {
                    this.r = optJSONObject.optString("sales_price");
                    this.s = optJSONObject.optString("price");
                    JSONArray optJSONArray = jSONObject2.optJSONArray("button_list");
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("background");
                    if (optJSONObject2 != null) {
                        this.o = optJSONObject2.optString("color");
                        this.p = optJSONObject2.optString("url");
                    }
                    RemoteViews remoteViews = new RemoteViews(this.f7938a.getPackageName(), R.layout.bd_push_layout_customs_notification_goods_card);
                    c(remoteViews);
                    this.q = a.a().a(optString);
                    a(remoteViews);
                    if (optJSONArray != null) {
                        try {
                            if (optJSONArray.length() > 0 && (jSONObject = optJSONArray.getJSONObject(0)) != null) {
                                JSONObject optJSONObject3 = jSONObject.optJSONObject("title");
                                this.n = jSONObject.optString(FeedPrefixTagDataKt.KEY_BG_COLOR, "");
                                if (optJSONObject3 != null) {
                                    String optString2 = optJSONObject3.optString("txt");
                                    this.l = optString2;
                                    if (!TextUtils.isEmpty(optString2)) {
                                        this.k = true;
                                        remoteViews.setViewVisibility(R.id.bd_push_lyt_btn_bottom, 0);
                                        remoteViews.setTextViewText(R.id.bd_push_txv_btn_bottom_text, this.l);
                                        this.m = optJSONObject3.optString("color");
                                        a(remoteViews, R.id.bd_push_img_btn_bottom_bg, R.id.bd_push_txv_btn_bottom_text, 306.0f, 35.0f);
                                    }
                                }
                            }
                        } catch (JSONException e2) {
                        }
                    }
                    this.f7937j = true;
                    return remoteViews;
                }
            }
            return null;
        } catch (JSONException e3) {
            return null;
        }
    }

    public final void c(RemoteViews remoteViews) {
        if (a()) {
            remoteViews.setViewVisibility(R.id.bd_push_lyt_head, 0);
            String g2 = Utility.g(this.f7938a);
            if (!TextUtils.isEmpty(this.f7943f)) {
                g2 = g2 + "•" + this.f7943f;
            }
            remoteViews.setTextViewText(R.id.bd_push_txv_app_name, g2);
            remoteViews.setImageViewBitmap(R.id.bd_push_img_icon, Utility.e(this.f7938a));
            int i2 = this.f7945h;
            if (i2 != Integer.MIN_VALUE) {
                remoteViews.setTextColor(R.id.bd_push_txv_app_name, i2);
            }
            b(remoteViews);
        }
        if (!g()) {
            remoteViews.setViewPadding(R.id.bd_push_container_shape, 0, 0, 0, 0);
        }
    }

    public RemoteViews d() {
        if (!this.f7937j) {
            return null;
        }
        RemoteViews remoteViews = new RemoteViews(this.f7938a.getPackageName(), R.layout.bd_push_layout_customs_notification_goods_card);
        c(remoteViews);
        a(remoteViews);
        if (this.k) {
            remoteViews.setViewVisibility(R.id.bd_push_lyt_btn_right, 0);
            remoteViews.setTextViewText(R.id.bd_push_btn_right, this.l);
            a(remoteViews, R.id.bd_push_img_btn_right_bg, R.id.bd_push_btn_right, 60.0f, 25.0f);
        }
        return remoteViews;
    }

    public boolean e() {
        return true;
    }
}
