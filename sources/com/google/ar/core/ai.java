package com.google.ar.core;

import com.google.ar.core.Session;

/* 'enum' modifier removed */
/* compiled from: Session */
final class ai extends Session.c {
    ai(String str, int i2, int i3, Class cls) {
        super(str, 5, 1095893253, cls, (byte) 0);
    }

    public final Trackable a(long j2, Session session) {
        return session.faceCache.a(j2, session);
    }
}
