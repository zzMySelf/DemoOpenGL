package com.tera.scan.component.base.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import com.baidu.android.util.soloader.SoUtils;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.Logger;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.fp.Either;
import fe.mmm.qw.i.qw;
import fe.mmm.qw.yj.th;
import java.io.File;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\t\u0010\u0011\u001a\u00020\u0006H J\u0006\u0010\u0012\u001a\u00020\u0006J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0003R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/tera/scan/component/base/base/NativeChannelManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "channelSystemPath", "", "getChannelSystemPath", "()Ljava/lang/String;", "innerSoFilePath", "systemLibFile", "buildDeviceFilePath", "Ljava/io/File;", "copySdcardFile", "", "fromFile", "toFile", "getChannelFormJni", "readChannel", "readChannelFromNative", "systemLoad", "", "soPath", "component-base_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NativeChannelManager {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public String f6830ad = "";
    @NotNull
    public final String qw = (Environment.getRootDirectory().getAbsolutePath() + File.separator + SoUtils.PRE + File.separator + "libbdwpchannel.so");

    public NativeChannelManager(@Nullable Context context) {
        if (context != null) {
            File dir = context.getDir("jniLibs", 0);
            if (!dir.exists()) {
                boolean mkdir = dir.mkdir();
                qw.ad("native_channel", "内部so父目录创建：" + mkdir);
            }
            String absolutePath = new File(dir.getAbsolutePath(), "libbdwpchannel.so").getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "File(jniDir.absolutePath…EL_FILENAME).absolutePath");
            this.f6830ad = absolutePath;
        }
    }

    private final native String getChannelFormJni();

    public final boolean ad(String str, String str2) {
        Either either;
        try {
            FilesKt__UtilsKt.copyTo$default(new File(str), new File(str2), false, 0, 6, (Object) null);
            either = ExpectKt.success(Boolean.TRUE);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            if (!Logger.INSTANCE.getEnable()) {
                either = ExpectKt.failure(th2);
            } else {
                throw th2;
            }
        }
        return ((Boolean) ExpectKt.successOrDefault(either, Boolean.FALSE)).booleanValue();
    }

    public final String de() {
        String yj2 = th.ppp().yj("system_properties");
        if (!(yj2 == null || yj2.length() == 0)) {
            return yj2;
        }
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke((Object) null, new Object[]{"ro.com.baidu.wangpan"});
            String str = invoke instanceof String ? (String) invoke : null;
            th.ppp().m1013switch("system_properties", str);
            return str;
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            if (!Logger.INSTANCE.getEnable()) {
                ExpectKt.failure(th2);
                return null;
            }
            throw th2;
        }
    }

    @NotNull
    public final String fe() {
        String str = this.f6830ad;
        if (str == null || str.length() == 0) {
            return "";
        }
        File file = new File(this.f6830ad);
        if (file.exists()) {
            qw.ad("native_channel", "内部so文件已存在：" + this.f6830ad);
            return rg();
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            boolean mkdir = parentFile.mkdir();
            qw.ad("native_channel", "内部so父目录创建：" + mkdir);
        }
        File qw2 = qw();
        if (!qw2.exists()) {
            qw.ad("native_channel", "设备so文件不存在（非预装）：" + qw2.getAbsoluteFile());
            return "";
        }
        String absolutePath = qw2.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "deviceFile.absolutePath");
        if (ad(absolutePath, this.f6830ad)) {
            return rg();
        }
        return "";
    }

    public final File qw() {
        String de2 = de();
        if (de2 == null || de2.length() == 0) {
            return new File(this.qw);
        }
        return new File(de() + "libbdwpchannel.so");
    }

    public final String rg() {
        try {
            th(this.f6830ad);
            return getChannelFormJni();
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            Either.Left failure = ExpectKt.failure(th2);
            if (failure instanceof Either.Left) {
                qw.ad("native_channel", "读取so中渠道号失败：" + ((Throwable) failure.getValue()).getMessage());
                new Either.Left(Unit.INSTANCE);
                return "";
            } else if (failure instanceof Either.Right) {
                return "";
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public final void th(String str) throws SecurityException, UnsatisfiedLinkError, NullPointerException {
        if (str != null) {
            System.load(str);
        }
    }
}
