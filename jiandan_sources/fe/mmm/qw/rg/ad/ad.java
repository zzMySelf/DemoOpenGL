package fe.mmm.qw.rg.ad;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

public final class ad {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public static String f8265ad = "aiscan.baidu.com";
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public static String f8266de = "aiscan.baidu.com";
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public static final CopyOnWriteArraySet<String> f8267fe;
    @NotNull
    public static final ad qw = new ad();

    static {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(String.format("data.%s", Arrays.copyOf(new Object[]{f8265ad}, 1)), "format(format, *args)");
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(String.format("d.%s", Arrays.copyOf(new Object[]{f8265ad}, 1)), "format(format, *args)");
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(String.format("https://sofire.%s", Arrays.copyOf(new Object[]{f8265ad}, 1)), "format(format, *args)");
        StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(String.format("c-all.%s", Arrays.copyOf(new Object[]{f8265ad}, 1)), "format(format, *args)");
        StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(String.format("https://passport.%s", Arrays.copyOf(new Object[]{f8265ad}, 1)), "format(format, *args)");
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        copyOnWriteArraySet.add("aiscan.baidu.com");
        copyOnWriteArraySet.addAll(de.qw);
        f8267fe = copyOnWriteArraySet;
    }

    @JvmStatic
    @NotNull
    public static final String ad() {
        return qw.rg() + "/api/";
    }

    @JvmStatic
    @NotNull
    public static final String de() {
        return f8266de;
    }

    @JvmStatic
    @NotNull
    @Deprecated(message = "请使用getDomain()来获取域名", replaceWith = @ReplaceWith(expression = "getDomain()", imports = {"com.tera.scan.business.kernel.HostURLManager.getDomain"}))
    public static final String fe() {
        return de();
    }

    @JvmStatic
    @NotNull
    public static final CopyOnWriteArraySet<String> qw() {
        if (f8267fe.isEmpty()) {
            f8267fe.add("aiscan.baidu.com");
            f8267fe.addAll(de.qw);
        }
        return f8267fe;
    }

    @JvmStatic
    @NotNull
    public static final String yj() {
        return qw.th();
    }

    @NotNull
    public final String rg() {
        return "https://" + de();
    }

    public final String th() {
        return "https://" + de();
    }
}
