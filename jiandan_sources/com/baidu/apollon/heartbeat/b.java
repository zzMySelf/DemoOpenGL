package com.baidu.apollon.heartbeat;

import com.baidu.apollon.a.a;
import com.baidu.apollon.utils.LogUtil;
import java.util.Calendar;
import java.util.Objects;

public final class b {
    public static final String a = "b";
    public com.baidu.apollon.a.a b = null;

    public final class a {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;

        public a() {
        }
    }

    /* renamed from: com.baidu.apollon.heartbeat.b$b  reason: collision with other inner class name */
    public final class C0026b {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;

        public C0026b() {
        }
    }

    public b() {
        b();
    }

    private void b() {
        com.baidu.apollon.a.a aVar = new com.baidu.apollon.a.a(1);
        this.b = aVar;
        aVar.a(new a.b(1, 3, 1, new a.C0024a() {
            public void a() {
                String a2 = b.a;
                LogUtil.i(a2, b.a + " Idle ---> Active.");
                HeartBeatManager.getInstance().a(0);
                HeartBeatManager.getInstance().startHeartBeat();
            }
        }));
        com.baidu.apollon.a.a aVar2 = this.b;
        Objects.requireNonNull(aVar2);
        aVar2.a(new a.b(3, 1, 2, new a.C0024a() {
            public void a() {
                String a2 = b.a;
                LogUtil.i(a2, b.a + " Active ---> Idle.");
                HeartBeatManager.getInstance().stopHeartBeat();
            }
        }));
        com.baidu.apollon.a.a aVar3 = this.b;
        Objects.requireNonNull(aVar3);
        aVar3.a(new a.b(3, 2, 3, new a.C0024a() {
            public void a() {
                String a2 = b.a;
                LogUtil.i(a2, b.a + " Active ---> HalfActive.");
                HeartBeatManager.getInstance().a(Calendar.getInstance().getTimeInMillis() / 1000);
            }
        }));
        com.baidu.apollon.a.a aVar4 = this.b;
        Objects.requireNonNull(aVar4);
        aVar4.a(new a.b(2, 3, 4, new a.C0024a() {
            public void a() {
                String a2 = b.a;
                LogUtil.i(a2, b.a + " HalfActive ---> Active.");
                HeartBeatManager.getInstance().a(0);
                HeartBeatManager.getInstance().startHeartBeat();
            }
        }));
        com.baidu.apollon.a.a aVar5 = this.b;
        Objects.requireNonNull(aVar5);
        aVar5.a(new a.b(2, 1, 2, new a.C0024a() {
            public void a() {
                String a2 = b.a;
                LogUtil.i(a2, b.a + " HalfActive ---> Idle.");
                HeartBeatManager.getInstance().stopHeartBeat();
            }
        }));
    }

    public void a(int i2) {
        if (i2 < 1 || i2 > 4) {
            throw new IllegalArgumentException(a + " invalid params eventId:" + i2);
        }
        com.baidu.apollon.a.a aVar = this.b;
        if (aVar != null) {
            aVar.b(i2);
            return;
        }
        throw new RuntimeException(a + " sendEvent but the mStateMachine is null.");
    }
}
