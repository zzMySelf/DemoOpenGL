package com.tencent.open.log;

import android.text.format.Time;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.video.feedflow.detail.personalizedcontentinsert.PersonalizedContentConfigKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: ProGuard */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f5985a = new g();

    public final String a(int i2) {
        switch (i2) {
            case 1:
                return "V";
            case 2:
                return PersonalizedContentConfigKt.ACTION_REQUEST_NEXT;
            case 4:
                return "I";
            case 8:
                return ExifInterface.LONGITUDE_WEST;
            case 16:
                return ExifInterface.LONGITUDE_EAST;
            case 32:
                return "A";
            default:
                return "-";
        }
    }

    public String a(int i2, Thread thread, long j2, String str, String str2, Throwable th2) {
        long j3 = j2 % 1000;
        Time time = new Time();
        time.set(j2);
        StringBuilder sb = new StringBuilder();
        sb.append(a(i2)).append('/').append(time.format("%Y-%m-%d %H:%M:%S")).append('.');
        if (j3 < 10) {
            sb.append("00");
        } else if (j3 < 100) {
            sb.append('0');
        }
        sb.append(j3).append(' ').append(AbstractJsonLexerKt.BEGIN_LIST);
        if (thread == null) {
            sb.append("N/A");
        } else {
            sb.append(thread.getName());
        }
        sb.append(AbstractJsonLexerKt.END_LIST).append(AbstractJsonLexerKt.BEGIN_LIST).append(str).append(AbstractJsonLexerKt.END_LIST).append(' ').append(str2).append(10);
        if (th2 != null) {
            sb.append("* Exception : \n").append(Log.getStackTraceString(th2)).append(10);
        }
        return sb.toString();
    }
}
