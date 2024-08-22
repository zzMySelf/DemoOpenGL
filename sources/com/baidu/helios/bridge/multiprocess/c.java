package com.baidu.helios.bridge.multiprocess;

import android.database.AbstractCursor;
import android.os.Bundle;

public class c extends AbstractCursor {

    /* renamed from: a  reason: collision with root package name */
    private Bundle f12722a;

    public c(Bundle bundle) {
        this.f12722a = bundle;
    }

    public String[] getColumnNames() {
        return new String[0];
    }

    public int getCount() {
        return 0;
    }

    public double getDouble(int i2) {
        return 0.0d;
    }

    public Bundle getExtras() {
        return this.f12722a;
    }

    public float getFloat(int i2) {
        return 0.0f;
    }

    public int getInt(int i2) {
        return 0;
    }

    public long getLong(int i2) {
        return 0;
    }

    public short getShort(int i2) {
        return 0;
    }

    public String getString(int i2) {
        return null;
    }

    public boolean isNull(int i2) {
        return false;
    }
}
