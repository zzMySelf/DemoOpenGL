package com.google.ar.core;

import com.google.ar.core.Session;

/* 'enum' modifier removed */
/* compiled from: Session */
final class ag extends Session.c {
    ag(String str, int i2, int i3, Class cls) {
        super(str, 3, 1095893250, cls, (byte) 0);
    }

    public final Trackable a(long j2, Session session) {
        return new Point(j2, session);
    }
}
