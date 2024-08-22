package com.baidu.poly.controller.event;

import android.text.TextUtils;
import java.util.Objects;

/* compiled from: SearchBox */
public class LifeEvent {
    public static final String CHECK_PAY_ORDER_RESULT = "CHECK_PAY_ORDER_RESULT";

    /* renamed from: a  reason: collision with root package name */
    private String f16900a;

    public LifeEvent(String str) {
        this.f16900a = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return TextUtils.equals(this.f16900a, ((LifeEvent) obj).f16900a);
    }

    public String getAction() {
        return this.f16900a;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f16900a});
    }
}
