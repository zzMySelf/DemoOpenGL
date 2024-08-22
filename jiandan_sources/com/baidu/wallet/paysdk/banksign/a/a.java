package com.baidu.wallet.paysdk.banksign.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.wallet.paysdk.presenter.j;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.ui.OrderConfirmActivity;
import com.baidu.wallet.paysdk.ui.PayTypeActivity;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a {
    public static Pattern a = Pattern.compile("(.*)(selected_card_no=[^&]+)(.*)");
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public byte[] g;
    public boolean h;

    /* renamed from: i  reason: collision with root package name */
    public String f3597i;
    public boolean j;
    public j k;
    public PayTypeActivity l;
    public OrderConfirmActivity m;

    /* renamed from: com.baidu.wallet.paysdk.banksign.a.a$a  reason: collision with other inner class name */
    public static class C0162a {
        public static a a = new a();
    }

    public static a a() {
        return C0162a.a;
    }

    public String b() {
        return this.f3597i;
    }

    public OrderConfirmActivity c() {
        return this.m;
    }

    public boolean d() {
        return this.j;
    }

    public PayTypeActivity e() {
        return this.l;
    }

    public j f() {
        return this.k;
    }

    public boolean g() {
        return this.h;
    }

    public String h() {
        return this.d;
    }

    public String i() {
        return this.c;
    }

    public String j() {
        return this.e;
    }

    public String k() {
        return this.f;
    }

    public byte[] l() {
        return this.g;
    }

    public String m() {
        return this.b;
    }

    public void n() {
        this.g = null;
        this.k = null;
        this.m = null;
        this.l = null;
    }

    public a() {
        this.h = false;
        this.j = false;
    }

    public void a(String str) {
        this.f3597i = str;
    }

    public void b(boolean z) {
        this.h = z;
    }

    public void c(String str) {
        this.c = str;
    }

    public void d(String str) {
        this.e = str;
    }

    public void e(String str) {
        this.f = str;
    }

    public void f(String str) {
        this.b = str;
    }

    public String g(String str) {
        String group;
        String orderExtraInfo = PayDataCache.getInstance().getOrderExtraInfo();
        PayDataCache.getInstance().getPayResponse().pay.selected_card_no = str;
        if (TextUtils.isEmpty(orderExtraInfo)) {
            return null;
        }
        Matcher matcher = a.matcher(orderExtraInfo);
        if (!matcher.matches() || 3 != matcher.groupCount() || (group = matcher.group(2)) == null || str == null) {
            return orderExtraInfo;
        }
        String encode = Uri.encode(str);
        return orderExtraInfo.replace(group, "selected_card_no=" + encode);
    }

    public void a(OrderConfirmActivity orderConfirmActivity) {
        this.m = orderConfirmActivity;
    }

    public void b(String str) {
        this.d = str;
    }

    public void a(boolean z) {
        this.j = z;
    }

    public void a(PayTypeActivity payTypeActivity) {
        this.l = payTypeActivity;
    }

    public void a(j jVar) {
        this.k = jVar;
    }

    public void a(byte[] bArr) {
        this.g = bArr;
    }
}
