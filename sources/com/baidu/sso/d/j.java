package com.baidu.sso.d;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.imsdk.IMConstants;

/* compiled from: TimeOutHandler */
public class j {

    /* renamed from: c  reason: collision with root package name */
    private static volatile j f3544c;

    /* renamed from: a  reason: collision with root package name */
    private HandlerThread f3545a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f3546b = null;

    /* compiled from: TimeOutHandler */
    class a extends Handler {
        a(j jVar, Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i2;
            g gVar = new g();
            gVar.f3514a = message.arg2;
            int i3 = message.arg1;
            if (i3 == -1) {
                i2 = h.b().a();
            } else {
                i2 = i3;
            }
            h.b().a(message.what, 3, IMConstants.IM_MSG_TYPE_ADVISORY_DISCLAIMER, i2, "out time.", gVar, true);
        }
    }

    private j() {
        HandlerThread handlerThread = new HandlerThread("callback-handler");
        this.f3545a = handlerThread;
        handlerThread.start();
        this.f3546b = new a(this, this.f3545a.getLooper());
    }

    public static j a() {
        if (f3544c == null) {
            synchronized (j.class) {
                if (f3544c == null) {
                    f3544c = new j();
                }
            }
        }
        return f3544c;
    }

    public void a(Message message, long j2) {
        this.f3546b.sendMessageDelayed(message, j2);
    }

    public void a(int i2) {
        this.f3546b.removeMessages(i2);
    }
}
