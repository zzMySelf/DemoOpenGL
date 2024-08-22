package kotlin.time;

import com.google.android.material.badge.BadgeDrawable;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.collections.IntIterator;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b*\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0002\u0010&\u001a\u0018\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0018\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0018\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0018\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0010\u0010/\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u0001H\u0002\u001a\u0010\u00100\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u0001H\u0002\u001a \u00101\u001a\u00020\u00072\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002ø\u0001\u0000¢\u0006\u0002\u00106\u001a\u0010\u00107\u001a\u00020\u00012\u0006\u00102\u001a\u000203H\u0002\u001a)\u00108\u001a\u00020\u0005*\u0002032\u0006\u00109\u001a\u00020\u00052\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002050;H\b\u001a)\u0010=\u001a\u000203*\u0002032\u0006\u00109\u001a\u00020\u00052\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002050;H\b\u001a\u001f\u0010>\u001a\u00020\u0007*\u00020\b2\u0006\u0010?\u001a\u00020\u0007H\nø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a\u001f\u0010>\u001a\u00020\u0007*\u00020\u00052\u0006\u0010?\u001a\u00020\u0007H\nø\u0001\u0000¢\u0006\u0004\bB\u0010C\u001a\u001c\u0010D\u001a\u00020\u0007*\u00020\b2\u0006\u0010E\u001a\u00020FH\u0007ø\u0001\u0000¢\u0006\u0002\u0010G\u001a\u001c\u0010D\u001a\u00020\u0007*\u00020\u00052\u0006\u0010E\u001a\u00020FH\u0007ø\u0001\u0000¢\u0006\u0002\u0010H\u001a\u001c\u0010D\u001a\u00020\u0007*\u00020\u00012\u0006\u0010E\u001a\u00020FH\u0007ø\u0001\u0000¢\u0006\u0002\u0010I\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"!\u0010\u0006\u001a\u00020\u0007*\u00020\b8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"!\u0010\u0006\u001a\u00020\u0007*\u00020\u00058FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\t\u0010\r\u001a\u0004\b\u000b\u0010\u000e\"!\u0010\u0006\u001a\u00020\u0007*\u00020\u00018FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\t\u0010\u000f\u001a\u0004\b\u000b\u0010\u0010\"!\u0010\u0011\u001a\u00020\u0007*\u00020\b8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\f\"!\u0010\u0011\u001a\u00020\u0007*\u00020\u00058FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000e\"!\u0010\u0011\u001a\u00020\u0007*\u00020\u00018FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0010\"!\u0010\u0014\u001a\u00020\u0007*\u00020\b8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\f\"!\u0010\u0014\u001a\u00020\u0007*\u00020\u00058FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000e\"!\u0010\u0014\u001a\u00020\u0007*\u00020\u00018FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0010\"!\u0010\u0017\u001a\u00020\u0007*\u00020\b8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\f\"!\u0010\u0017\u001a\u00020\u0007*\u00020\u00058FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000e\"!\u0010\u0017\u001a\u00020\u0007*\u00020\u00018FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0010\"!\u0010\u001a\u001a\u00020\u0007*\u00020\b8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001b\u0010\n\u001a\u0004\b\u001c\u0010\f\"!\u0010\u001a\u001a\u00020\u0007*\u00020\u00058FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000e\"!\u0010\u001a\u001a\u00020\u0007*\u00020\u00018FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0010\"!\u0010\u001d\u001a\u00020\u0007*\u00020\b8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001e\u0010\n\u001a\u0004\b\u001f\u0010\f\"!\u0010\u001d\u001a\u00020\u0007*\u00020\u00058FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000e\"!\u0010\u001d\u001a\u00020\u0007*\u00020\u00018FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0010\"!\u0010 \u001a\u00020\u0007*\u00020\b8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b!\u0010\n\u001a\u0004\b\"\u0010\f\"!\u0010 \u001a\u00020\u0007*\u00020\u00058FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b!\u0010\r\u001a\u0004\b\"\u0010\u000e\"!\u0010 \u001a\u00020\u0007*\u00020\u00018FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b!\u0010\u000f\u001a\u0004\b\"\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006J"}, d2 = {"MAX_MILLIS", "", "MAX_NANOS", "MAX_NANOS_IN_MILLIS", "NANOS_IN_MILLIS", "", "days", "Lkotlin/time/Duration;", "", "getDays$annotations", "(D)V", "getDays", "(D)J", "(I)V", "(I)J", "(J)V", "(J)J", "hours", "getHours$annotations", "getHours", "microseconds", "getMicroseconds$annotations", "getMicroseconds", "milliseconds", "getMilliseconds$annotations", "getMilliseconds", "minutes", "getMinutes$annotations", "getMinutes", "nanoseconds", "getNanoseconds$annotations", "getNanoseconds", "seconds", "getSeconds$annotations", "getSeconds", "durationOf", "normalValue", "unitDiscriminator", "(JI)J", "durationOfMillis", "normalMillis", "durationOfMillisNormalized", "millis", "durationOfNanos", "normalNanos", "durationOfNanosNormalized", "nanos", "millisToNanos", "nanosToMillis", "parseDuration", "value", "", "strictIso", "", "(Ljava/lang/String;Z)J", "parseOverLongIsoComponent", "skipWhile", "startIndex", "predicate", "Lkotlin/Function1;", "", "substringWhile", "times", "duration", "times-kIfJnKk", "(DJ)J", "times-mvk6XK0", "(IJ)J", "toDuration", "unit", "Lkotlin/time/DurationUnit;", "(DLkotlin/time/DurationUnit;)J", "(ILkotlin/time/DurationUnit;)J", "(JLkotlin/time/DurationUnit;)J", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class DurationKt {
    public static final long MAX_MILLIS = 4611686018427387903L;
    public static final long MAX_NANOS = 4611686018426999999L;
    public static final long MAX_NANOS_IN_MILLIS = 4611686018426L;
    public static final int NANOS_IN_MILLIS = 1000000;

    public static final long durationOf(long j, int i2) {
        return Duration.m519constructorimpl((j << 1) + ((long) i2));
    }

    public static final long durationOfMillis(long j) {
        return Duration.m519constructorimpl((j << 1) + 1);
    }

    public static final long durationOfMillisNormalized(long j) {
        boolean z = false;
        if (-4611686018426L <= j && j < 4611686018427L) {
            z = true;
        }
        if (z) {
            return durationOfNanos(millisToNanos(j));
        }
        return durationOfMillis(RangesKt___RangesKt.coerceIn(j, -4611686018427387903L, (long) MAX_MILLIS));
    }

    public static final long durationOfNanos(long j) {
        return Duration.m519constructorimpl(j << 1);
    }

    public static final long durationOfNanosNormalized(long j) {
        boolean z = false;
        if (-4611686018426999999L <= j && j < 4611686018427000000L) {
            z = true;
        }
        if (z) {
            return durationOfNanos(j);
        }
        return durationOfMillis(nanosToMillis(j));
    }

    public static final long getDays(int i2) {
        return toDuration(i2, DurationUnit.DAYS);
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @ExperimentalTime
    public static /* synthetic */ void getDays$annotations(double d) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @ExperimentalTime
    public static /* synthetic */ void getDays$annotations(int i2) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @ExperimentalTime
    public static /* synthetic */ void getDays$annotations(long j) {
    }

    public static final long getHours(int i2) {
        return toDuration(i2, DurationUnit.HOURS);
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @ExperimentalTime
    public static /* synthetic */ void getHours$annotations(double d) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @ExperimentalTime
    public static /* synthetic */ void getHours$annotations(int i2) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @ExperimentalTime
    public static /* synthetic */ void getHours$annotations(long j) {
    }

    public static final long getMicroseconds(int i2) {
        return toDuration(i2, DurationUnit.MICROSECONDS);
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @ExperimentalTime
    public static /* synthetic */ void getMicroseconds$annotations(double d) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @ExperimentalTime
    public static /* synthetic */ void getMicroseconds$annotations(int i2) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @ExperimentalTime
    public static /* synthetic */ void getMicroseconds$annotations(long j) {
    }

    public static final long getMilliseconds(int i2) {
        return toDuration(i2, DurationUnit.MILLISECONDS);
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @ExperimentalTime
    public static /* synthetic */ void getMilliseconds$annotations(double d) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @ExperimentalTime
    public static /* synthetic */ void getMilliseconds$annotations(int i2) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @ExperimentalTime
    public static /* synthetic */ void getMilliseconds$annotations(long j) {
    }

    public static final long getMinutes(int i2) {
        return toDuration(i2, DurationUnit.MINUTES);
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @ExperimentalTime
    public static /* synthetic */ void getMinutes$annotations(double d) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @ExperimentalTime
    public static /* synthetic */ void getMinutes$annotations(int i2) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @ExperimentalTime
    public static /* synthetic */ void getMinutes$annotations(long j) {
    }

    public static final long getNanoseconds(int i2) {
        return toDuration(i2, DurationUnit.NANOSECONDS);
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @ExperimentalTime
    public static /* synthetic */ void getNanoseconds$annotations(double d) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @ExperimentalTime
    public static /* synthetic */ void getNanoseconds$annotations(int i2) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @ExperimentalTime
    public static /* synthetic */ void getNanoseconds$annotations(long j) {
    }

    public static final long getSeconds(int i2) {
        return toDuration(i2, DurationUnit.SECONDS);
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @ExperimentalTime
    public static /* synthetic */ void getSeconds$annotations(double d) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @ExperimentalTime
    public static /* synthetic */ void getSeconds$annotations(int i2) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @ExperimentalTime
    public static /* synthetic */ void getSeconds$annotations(long j) {
    }

    public static final long millisToNanos(long j) {
        return j * ((long) 1000000);
    }

    public static final long nanosToMillis(long j) {
        return j / ((long) 1000000);
    }

    /* JADX WARNING: Removed duplicated region for block: B:175:0x00a4 A[EDGE_INSN: B:175:0x00a4->B:52:0x00a4 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0098 A[LOOP:1: B:36:0x006e->B:50:0x0098, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long parseDuration(java.lang.String r27, boolean r28) {
        /*
            r6 = r27
            int r7 = r27.length()
            if (r7 == 0) goto L_0x02b3
            kotlin.time.Duration$Companion r0 = kotlin.time.Duration.Companion
            long r8 = r0.m621getZEROUwyO8pc()
            r10 = 0
            char r0 = r6.charAt(r10)
            r1 = 43
            r2 = 45
            r11 = 1
            if (r0 != r1) goto L_0x001c
        L_0x001a:
            r0 = 1
            goto L_0x0020
        L_0x001c:
            if (r0 != r2) goto L_0x001f
            goto L_0x001a
        L_0x001f:
            r0 = 0
        L_0x0020:
            if (r0 == 0) goto L_0x0024
            r12 = 1
            goto L_0x0025
        L_0x0024:
            r12 = 0
        L_0x0025:
            if (r12 <= 0) goto L_0x0029
            r13 = 1
            goto L_0x002a
        L_0x0029:
            r13 = 0
        L_0x002a:
            r0 = 2
            r14 = 0
            if (r13 == 0) goto L_0x0036
            boolean r1 = kotlin.text.StringsKt__StringsKt.startsWith$default((java.lang.CharSequence) r6, (char) r2, (boolean) r10, (int) r0, (java.lang.Object) r14)
            if (r1 == 0) goto L_0x0036
            r15 = 1
            goto L_0x0037
        L_0x0036:
            r15 = 0
        L_0x0037:
            java.lang.String r5 = "No components"
            if (r7 <= r12) goto L_0x02ac
            char r1 = r6.charAt(r12)
            r2 = 80
            java.lang.String r4 = "this as java.lang.String).substring(startIndex)"
            java.lang.String r3 = "Unexpected order of duration components"
            r16 = r5
            r5 = 58
            r0 = 48
            java.lang.String r10 = "this as java.lang.String…ing(startIndex, endIndex)"
            if (r1 != r2) goto L_0x0158
            int r12 = r12 + r11
            if (r12 == r7) goto L_0x0152
            r2 = r14
            r1 = 0
        L_0x0054:
            if (r12 >= r7) goto L_0x014e
            char r13 = r6.charAt(r12)
            r11 = 84
            if (r13 != r11) goto L_0x006d
            if (r1 != 0) goto L_0x0067
            int r12 = r12 + 1
            if (r12 == r7) goto L_0x0067
            r1 = 1
            r11 = 1
            goto L_0x0054
        L_0x0067:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x006d:
            r11 = r12
        L_0x006e:
            int r13 = r27.length()
            if (r11 >= r13) goto L_0x00a1
            char r13 = r6.charAt(r11)
            if (r0 > r13) goto L_0x007f
            if (r13 >= r5) goto L_0x007f
            r16 = 1
            goto L_0x0081
        L_0x007f:
            r16 = 0
        L_0x0081:
            if (r16 != 0) goto L_0x0092
            java.lang.String r0 = "+-."
            r17 = r15
            r5 = 2
            r15 = 0
            boolean r0 = kotlin.text.StringsKt__StringsKt.contains$default((java.lang.CharSequence) r0, (char) r13, (boolean) r15, (int) r5, (java.lang.Object) r14)
            if (r0 == 0) goto L_0x0090
            goto L_0x0095
        L_0x0090:
            r0 = 0
            goto L_0x0096
        L_0x0092:
            r17 = r15
            r5 = 2
        L_0x0095:
            r0 = 1
        L_0x0096:
            if (r0 == 0) goto L_0x00a4
            int r11 = r11 + 1
            r15 = r17
            r0 = 48
            r5 = 58
            goto L_0x006e
        L_0x00a1:
            r17 = r15
            r5 = 2
        L_0x00a4:
            java.lang.String r0 = r6.substring(r12, r11)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r10)
            int r11 = r0.length()
            if (r11 != 0) goto L_0x00b3
            r11 = 1
            goto L_0x00b4
        L_0x00b3:
            r11 = 0
        L_0x00b4:
            if (r11 != 0) goto L_0x0148
            int r11 = r0.length()
            int r12 = r12 + r11
            if (r12 < 0) goto L_0x0131
            int r11 = kotlin.text.StringsKt__StringsKt.getLastIndex(r27)
            if (r12 > r11) goto L_0x0131
            char r11 = r6.charAt(r12)
            int r12 = r12 + 1
            kotlin.time.DurationUnit r11 = kotlin.time.DurationUnitKt__DurationUnitKt.durationUnitByIsoChar(r11, r1)
            if (r2 == 0) goto L_0x00dc
            int r2 = r2.compareTo(r11)
            if (r2 <= 0) goto L_0x00d6
            goto L_0x00dc
        L_0x00d6:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r3)
            throw r0
        L_0x00dc:
            r21 = 46
            r22 = 0
            r23 = 0
            r24 = 6
            r25 = 0
            r20 = r0
            int r2 = kotlin.text.StringsKt__StringsKt.indexOf$default((java.lang.CharSequence) r20, (char) r21, (int) r22, (boolean) r23, (int) r24, (java.lang.Object) r25)
            kotlin.time.DurationUnit r13 = kotlin.time.DurationUnit.SECONDS
            if (r11 != r13) goto L_0x011a
            if (r2 <= 0) goto L_0x011a
            r13 = 0
            java.lang.String r15 = r0.substring(r13, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r10)
            long r14 = parseOverLongIsoComponent(r15)
            long r13 = toDuration((long) r14, (kotlin.time.DurationUnit) r11)
            long r8 = kotlin.time.Duration.m555plusLRDsOJo(r8, r13)
            java.lang.String r0 = r0.substring(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            double r13 = java.lang.Double.parseDouble(r0)
            long r13 = toDuration((double) r13, (kotlin.time.DurationUnit) r11)
            long r8 = kotlin.time.Duration.m555plusLRDsOJo(r8, r13)
            goto L_0x0126
        L_0x011a:
            long r13 = parseOverLongIsoComponent(r0)
            long r13 = toDuration((long) r13, (kotlin.time.DurationUnit) r11)
            long r8 = kotlin.time.Duration.m555plusLRDsOJo(r8, r13)
        L_0x0126:
            r2 = r11
            r15 = r17
            r0 = 48
            r5 = 58
            r11 = 1
            r14 = 0
            goto L_0x0054
        L_0x0131:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Missing unit for value "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0148:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x014e:
            r17 = r15
            goto L_0x029f
        L_0x0152:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x0158:
            r17 = r15
            if (r28 != 0) goto L_0x02a6
            r5 = 0
            int r0 = r7 - r12
            r1 = 8
            int r11 = java.lang.Math.max(r0, r1)
            r14 = 1
            java.lang.String r2 = "Infinity"
            r15 = 48
            r0 = r27
            r1 = r12
            r26 = r3
            r3 = r5
            r5 = r4
            r4 = r11
            r11 = r5
            r15 = r16
            r5 = r14
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.regionMatches((java.lang.String) r0, (int) r1, (java.lang.String) r2, (int) r3, (int) r4, (boolean) r5)
            if (r0 == 0) goto L_0x0184
            kotlin.time.Duration$Companion r0 = kotlin.time.Duration.Companion
            long r8 = r0.m619getINFINITEUwyO8pc()
            goto L_0x029f
        L_0x0184:
            r0 = r13 ^ 1
            if (r13 == 0) goto L_0x01a6
            char r1 = r6.charAt(r12)
            r2 = 40
            if (r1 != r2) goto L_0x01a6
            char r1 = kotlin.text.StringsKt___StringsKt.last(r27)
            r2 = 41
            if (r1 != r2) goto L_0x01a6
            int r12 = r12 + 1
            int r7 = r7 + -1
            if (r12 == r7) goto L_0x01a0
            r0 = 1
            goto L_0x01a6
        L_0x01a0:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r15)
            throw r0
        L_0x01a6:
            r14 = 0
            r15 = 0
        L_0x01a8:
            if (r12 >= r7) goto L_0x029f
            if (r15 == 0) goto L_0x01c4
            if (r0 == 0) goto L_0x01c4
        L_0x01ae:
            int r1 = r27.length()
            if (r12 >= r1) goto L_0x01c4
            char r1 = r6.charAt(r12)
            r2 = 32
            if (r1 != r2) goto L_0x01be
            r15 = 1
            goto L_0x01bf
        L_0x01be:
            r15 = 0
        L_0x01bf:
            if (r15 == 0) goto L_0x01c4
            int r12 = r12 + 1
            goto L_0x01ae
        L_0x01c4:
            r1 = r12
        L_0x01c5:
            int r2 = r27.length()
            if (r1 >= r2) goto L_0x01e9
            char r2 = r6.charAt(r1)
            r3 = 48
            r4 = 58
            if (r3 > r2) goto L_0x01d9
            if (r2 >= r4) goto L_0x01d9
            r15 = 1
            goto L_0x01da
        L_0x01d9:
            r15 = 0
        L_0x01da:
            if (r15 != 0) goto L_0x01e3
            r5 = 46
            if (r2 != r5) goto L_0x01e1
            goto L_0x01e3
        L_0x01e1:
            r15 = 0
            goto L_0x01e4
        L_0x01e3:
            r15 = 1
        L_0x01e4:
            if (r15 == 0) goto L_0x01ed
            int r1 = r1 + 1
            goto L_0x01c5
        L_0x01e9:
            r3 = 48
            r4 = 58
        L_0x01ed:
            java.lang.String r1 = r6.substring(r12, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r10)
            int r2 = r1.length()
            if (r2 != 0) goto L_0x01fc
            r15 = 1
            goto L_0x01fd
        L_0x01fc:
            r15 = 0
        L_0x01fd:
            if (r15 != 0) goto L_0x0299
            int r2 = r1.length()
            int r12 = r12 + r2
            r2 = r12
        L_0x0205:
            int r5 = r27.length()
            if (r2 >= r5) goto L_0x021f
            char r5 = r6.charAt(r2)
            r13 = 97
            if (r13 > r5) goto L_0x0219
            r13 = 123(0x7b, float:1.72E-43)
            if (r5 >= r13) goto L_0x0219
            r15 = 1
            goto L_0x021a
        L_0x0219:
            r15 = 0
        L_0x021a:
            if (r15 == 0) goto L_0x021f
            int r2 = r2 + 1
            goto L_0x0205
        L_0x021f:
            java.lang.String r2 = r6.substring(r12, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r10)
            int r5 = r2.length()
            int r12 = r12 + r5
            kotlin.time.DurationUnit r2 = kotlin.time.DurationUnitKt__DurationUnitKt.durationUnitByShortName(r2)
            if (r14 == 0) goto L_0x0240
            int r5 = r14.compareTo(r2)
            if (r5 <= 0) goto L_0x0238
            goto L_0x0240
        L_0x0238:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r5 = r26
            r0.<init>(r5)
            throw r0
        L_0x0240:
            r5 = r26
            r19 = 46
            r20 = 0
            r21 = 0
            r22 = 6
            r23 = 0
            r18 = r1
            int r13 = kotlin.text.StringsKt__StringsKt.indexOf$default((java.lang.CharSequence) r18, (char) r19, (int) r20, (boolean) r21, (int) r22, (java.lang.Object) r23)
            if (r13 <= 0) goto L_0x0286
            r14 = 0
            java.lang.String r15 = r1.substring(r14, r13)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r10)
            long r3 = java.lang.Long.parseLong(r15)
            long r3 = toDuration((long) r3, (kotlin.time.DurationUnit) r2)
            long r3 = kotlin.time.Duration.m555plusLRDsOJo(r8, r3)
            java.lang.String r1 = r1.substring(r13)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r11)
            double r8 = java.lang.Double.parseDouble(r1)
            long r8 = toDuration((double) r8, (kotlin.time.DurationUnit) r2)
            long r8 = kotlin.time.Duration.m555plusLRDsOJo(r3, r8)
            if (r12 < r7) goto L_0x027e
            goto L_0x0293
        L_0x027e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Fractional component must be last"
            r0.<init>(r1)
            throw r0
        L_0x0286:
            r14 = 0
            long r3 = java.lang.Long.parseLong(r1)
            long r3 = toDuration((long) r3, (kotlin.time.DurationUnit) r2)
            long r8 = kotlin.time.Duration.m555plusLRDsOJo(r8, r3)
        L_0x0293:
            r14 = r2
            r26 = r5
            r15 = 1
            goto L_0x01a8
        L_0x0299:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x029f:
            if (r17 == 0) goto L_0x02a5
            long r8 = kotlin.time.Duration.m571unaryMinusUwyO8pc(r8)
        L_0x02a5:
            return r8
        L_0x02a6:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x02ac:
            r15 = r5
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r15)
            throw r0
        L_0x02b3:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The string is empty"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.time.DurationKt.parseDuration(java.lang.String, boolean):long");
    }

    public static final long parseOverLongIsoComponent(String str) {
        boolean z;
        boolean z2;
        int length = str.length();
        int i2 = (length <= 0 || !StringsKt__StringsKt.contains$default((CharSequence) "+-", str.charAt(0), false, 2, (Object) null)) ? 0 : 1;
        if (length - i2 > 16) {
            IntRange intRange = new IntRange(i2, StringsKt__StringsKt.getLastIndex(str));
            if (!(intRange instanceof Collection) || !((Collection) intRange).isEmpty()) {
                Iterator it = intRange.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    char charAt = str.charAt(((IntIterator) it).nextInt());
                    if ('0' > charAt || charAt >= ':') {
                        z2 = false;
                        continue;
                    } else {
                        z2 = true;
                        continue;
                    }
                    if (!z2) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                return str.charAt(0) == '-' ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
        }
        if (StringsKt__StringsJVMKt.startsWith$default(str, BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, false, 2, (Object) null)) {
            str = StringsKt___StringsKt.drop(str, 1);
        }
        return Long.parseLong(str);
    }

    public static final int skipWhile(String str, int i2, Function1<? super Character, Boolean> function1) {
        while (i2 < str.length() && function1.invoke(Character.valueOf(str.charAt(i2))).booleanValue()) {
            i2++;
        }
        return i2;
    }

    public static final String substringWhile(String str, int i2, Function1<? super Character, Boolean> function1) {
        int i3 = i2;
        while (i3 < str.length() && function1.invoke(Character.valueOf(str.charAt(i3))).booleanValue()) {
            i3++;
        }
        String substring = str.substring(i2, i3);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalTime.class})
    /* renamed from: times-kIfJnKk  reason: not valid java name */
    public static final long m644timeskIfJnKk(double d, long j) {
        return Duration.m556timesUwyO8pc(j, d);
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalTime.class})
    /* renamed from: times-mvk6XK0  reason: not valid java name */
    public static final long m645timesmvk6XK0(int i2, long j) {
        return Duration.m557timesUwyO8pc(j, i2);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long toDuration(int i2, @NotNull DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, "unit");
        if (durationUnit.compareTo(DurationUnit.SECONDS) <= 0) {
            return durationOfNanos(DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow((long) i2, durationUnit, DurationUnit.NANOSECONDS));
        }
        return toDuration((long) i2, durationUnit);
    }

    public static final long getDays(long j) {
        return toDuration(j, DurationUnit.DAYS);
    }

    public static final long getHours(long j) {
        return toDuration(j, DurationUnit.HOURS);
    }

    public static final long getMicroseconds(long j) {
        return toDuration(j, DurationUnit.MICROSECONDS);
    }

    public static final long getMilliseconds(long j) {
        return toDuration(j, DurationUnit.MILLISECONDS);
    }

    public static final long getMinutes(long j) {
        return toDuration(j, DurationUnit.MINUTES);
    }

    public static final long getNanoseconds(long j) {
        return toDuration(j, DurationUnit.NANOSECONDS);
    }

    public static final long getSeconds(long j) {
        return toDuration(j, DurationUnit.SECONDS);
    }

    public static final long getDays(double d) {
        return toDuration(d, DurationUnit.DAYS);
    }

    public static final long getHours(double d) {
        return toDuration(d, DurationUnit.HOURS);
    }

    public static final long getMicroseconds(double d) {
        return toDuration(d, DurationUnit.MICROSECONDS);
    }

    public static final long getMilliseconds(double d) {
        return toDuration(d, DurationUnit.MILLISECONDS);
    }

    public static final long getMinutes(double d) {
        return toDuration(d, DurationUnit.MINUTES);
    }

    public static final long getNanoseconds(double d) {
        return toDuration(d, DurationUnit.NANOSECONDS);
    }

    public static final long getSeconds(double d) {
        return toDuration(d, DurationUnit.SECONDS);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long toDuration(long j, @NotNull DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, "unit");
        long convertDurationUnitOverflow = DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(MAX_NANOS, DurationUnit.NANOSECONDS, durationUnit);
        boolean z = false;
        if ((-convertDurationUnitOverflow) <= j && j <= convertDurationUnitOverflow) {
            z = true;
        }
        if (z) {
            return durationOfNanos(DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(j, durationUnit, DurationUnit.NANOSECONDS));
        }
        return durationOfMillis(RangesKt___RangesKt.coerceIn(DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(j, durationUnit, DurationUnit.MILLISECONDS), -4611686018427387903L, (long) MAX_MILLIS));
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long toDuration(double d, @NotNull DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, "unit");
        double convertDurationUnit = DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(d, durationUnit, DurationUnit.NANOSECONDS);
        boolean z = true;
        if (!Double.isNaN(convertDurationUnit)) {
            long roundToLong = MathKt__MathJVMKt.roundToLong(convertDurationUnit);
            if (-4611686018426999999L > roundToLong || roundToLong >= 4611686018427000000L) {
                z = false;
            }
            if (z) {
                return durationOfNanos(roundToLong);
            }
            return durationOfMillisNormalized(MathKt__MathJVMKt.roundToLong(DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(d, durationUnit, DurationUnit.MILLISECONDS)));
        }
        throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
    }
}
