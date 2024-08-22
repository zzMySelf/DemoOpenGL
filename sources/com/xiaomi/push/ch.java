package com.xiaomi.push;

import com.baidu.android.imsdk.db.DBTableDefine;
import com.xiaomi.push.ag;

class ch extends ag.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ce f6794a;

    ch(ce ceVar) {
        this.f6794a = ceVar;
    }

    public String a() {
        return "10053";
    }

    public void run() {
        if (ce.a(this.f6794a) != null) {
            ce.a(this.f6794a).b(ce.a(this.f6794a));
            this.f6794a.b(DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM);
        }
    }
}
