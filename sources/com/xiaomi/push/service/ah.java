package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.ji;
import java.util.Map;

public class ah {

    /* renamed from: a  reason: collision with root package name */
    private static a f7547a;

    /* renamed from: a  reason: collision with other field name */
    private static b f962a;

    public interface a {
        Map<String, String> a(Context context, ji jiVar);

        /* renamed from: a  reason: collision with other method in class */
        void m8870a(Context context, ji jiVar);

        boolean a(Context context, ji jiVar, boolean z);
    }

    public interface b {
        void a(ji jiVar);

        void a(String str);

        /* renamed from: a  reason: collision with other method in class */
        boolean m8871a(ji jiVar);
    }

    public static boolean a(Context context, ji jiVar, boolean z) {
        a aVar = f7547a;
        if (aVar != null && jiVar != null) {
            return aVar.a(context, jiVar, z);
        }
        com.xiaomi.channel.commonutils.logger.b.a("pepa judement listener or container is null");
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m8868a(Context context, ji jiVar) {
        a aVar = f7547a;
        if (aVar == null || jiVar == null) {
            com.xiaomi.channel.commonutils.logger.b.a("handle msg wrong");
        } else {
            aVar.a(context, jiVar);
        }
    }

    public static Map<String, String> a(Context context, ji jiVar) {
        a aVar = f7547a;
        if (aVar != null && jiVar != null) {
            return aVar.a(context, jiVar);
        }
        com.xiaomi.channel.commonutils.logger.b.a("pepa listener or container is null");
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m8869a(ji jiVar) {
        b bVar = f962a;
        if (bVar != null && jiVar != null) {
            return bVar.a(jiVar);
        }
        com.xiaomi.channel.commonutils.logger.b.a("pepa handleReceiveMessage is null");
        return false;
    }

    public static void a(ji jiVar) {
        b bVar = f962a;
        if (bVar == null || jiVar == null) {
            com.xiaomi.channel.commonutils.logger.b.a("pepa clearMessage is null");
        } else {
            bVar.a(jiVar);
        }
    }

    public static void a(String str) {
        b bVar = f962a;
        if (bVar == null || str == null) {
            com.xiaomi.channel.commonutils.logger.b.a("pepa clearMessage is null");
        } else {
            bVar.a(str);
        }
    }
}
