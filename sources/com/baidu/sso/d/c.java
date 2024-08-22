package com.baidu.sso.d;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: CallBackMsg */
public class c {

    /* renamed from: a  reason: collision with root package name */
    int f3490a = -1;

    /* renamed from: b  reason: collision with root package name */
    int f3491b;

    /* renamed from: c  reason: collision with root package name */
    int f3492c;

    /* renamed from: d  reason: collision with root package name */
    String f3493d;

    public c(int i2, int i3, int i4, String str) {
        this.f3490a = i2;
        this.f3491b = i3;
        this.f3492c = i4;
        this.f3493d = str;
    }

    public static c a() {
        return new c(3, 2020, -1, "No Authorized User Privacy Agreement");
    }

    public String toString() {
        return "CallBackMsg{status=" + this.f3490a + ", subStatus=" + this.f3491b + ", op='" + this.f3492c + '\'' + ", data='" + this.f3493d + '\'' + AbstractJsonLexerKt.END_OBJ;
    }
}
