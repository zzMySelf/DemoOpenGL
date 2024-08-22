package com.baidu.mapsdkplatform.comapi.map;

import android.os.Message;

class J {

    /* renamed from: a  reason: collision with root package name */
    private I f14942a;

    J() {
    }

    /* access modifiers changed from: package-private */
    public void a(Message message) {
        if (message.what == 65289) {
            int i2 = message.arg1;
            if (!(i2 == 12 || i2 == 101 || i2 == 102)) {
                switch (i2) {
                    case -1:
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                        break;
                    default:
                        return;
                }
            }
            I i3 = this.f14942a;
            if (i3 != null) {
                i3.a(message.arg1, message.arg2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(I i2) {
        this.f14942a = i2;
    }

    /* access modifiers changed from: package-private */
    public void b(I i2) {
        this.f14942a = null;
    }
}
