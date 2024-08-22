package com.google.protobuf.util;

import com.baidu.android.common.others.IStringUtil;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.common.math.LongMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.protobuf.Duration;
import java.text.ParseException;
import java.util.Comparator;
import org.apache.commons.codec.digest4util.Sha2Crypt;

public final class Durations {
    public static final Comparator<Duration> COMPARATOR = new Comparator<Duration>() {
        public int compare(Duration duration, Duration duration2) {
            Durations.checkValid(duration);
            Durations.checkValid(duration2);
            int compare = Long.compare(duration.getSeconds(), duration2.getSeconds());
            return compare != 0 ? compare : Integer.compare(duration.getNanos(), duration2.getNanos());
        }
    };
    public static final long DURATION_SECONDS_MAX = 315576000000L;
    public static final long DURATION_SECONDS_MIN = -315576000000L;
    public static final Duration MAX_VALUE = Duration.newBuilder().setSeconds(315576000000L).setNanos(Sha2Crypt.ROUNDS_MAX).build();
    public static final Duration MIN_VALUE = Duration.newBuilder().setSeconds(-315576000000L).setNanos(-999999999).build();
    public static final long SECONDS_PER_DAY = 86400;
    public static final long SECONDS_PER_HOUR = 3600;
    public static final long SECONDS_PER_MINUTE = 60;
    public static final Duration ZERO = Duration.newBuilder().setSeconds(0).setNanos(0).build();

    public static Duration add(Duration duration, Duration duration2) {
        checkValid(duration);
        checkValid(duration2);
        return normalizedDuration(LongMath.checkedAdd(duration.getSeconds(), duration2.getSeconds()), IntMath.checkedAdd(duration.getNanos(), duration2.getNanos()));
    }

    @CanIgnoreReturnValue
    public static Duration checkNotNegative(Duration duration) {
        checkValid(duration);
        Preconditions.checkArgument(!isNegative(duration), "duration (%s) must not be negative", (Object) toString(duration));
        return duration;
    }

    @CanIgnoreReturnValue
    public static Duration checkPositive(Duration duration) {
        checkValid(duration);
        Preconditions.checkArgument(!isNegative(duration) && !duration.equals(ZERO), "duration (%s) must be positive", (Object) toString(duration));
        return duration;
    }

    @CanIgnoreReturnValue
    public static Duration checkValid(Duration duration) {
        long seconds = duration.getSeconds();
        int nanos = duration.getNanos();
        if (isValid(seconds, nanos)) {
            return duration;
        }
        throw new IllegalArgumentException(String.format("Duration is not valid. See proto definition for valid values. Seconds (%s) must be in range [-315,576,000,000, +315,576,000,000]. Nanos (%s) must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds", new Object[]{Long.valueOf(seconds), Integer.valueOf(nanos)}));
    }

    public static Comparator<Duration> comparator() {
        return COMPARATOR;
    }

    public static int compare(Duration duration, Duration duration2) {
        return COMPARATOR.compare(duration, duration2);
    }

    public static Duration fromDays(long j) {
        return Duration.newBuilder().setSeconds(LongMath.checkedMultiply(j, 86400)).setNanos(0).build();
    }

    public static Duration fromHours(long j) {
        return Duration.newBuilder().setSeconds(LongMath.checkedMultiply(j, SECONDS_PER_HOUR)).setNanos(0).build();
    }

    public static Duration fromMicros(long j) {
        return normalizedDuration(j / 1000000, (int) ((j % 1000000) * 1000));
    }

    public static Duration fromMillis(long j) {
        return normalizedDuration(j / 1000, (int) ((j % 1000) * 1000000));
    }

    public static Duration fromMinutes(long j) {
        return Duration.newBuilder().setSeconds(LongMath.checkedMultiply(j, 60)).setNanos(0).build();
    }

    public static Duration fromNanos(long j) {
        return normalizedDuration(j / 1000000000, (int) (j % 1000000000));
    }

    public static Duration fromSeconds(long j) {
        return normalizedDuration(j, 0);
    }

    public static boolean isNegative(Duration duration) {
        checkValid(duration);
        if (duration.getSeconds() == 0) {
            if (duration.getNanos() < 0) {
                return true;
            }
        } else if (duration.getSeconds() < 0) {
            return true;
        }
        return false;
    }

    public static boolean isValid(long j, int i2) {
        if (j >= -315576000000L && j <= 315576000000L) {
            long j2 = (long) i2;
            if (j2 >= -999999999 && j2 < 1000000000) {
                int i3 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i3 < 0 || i2 < 0) {
                    return i3 <= 0 && i2 <= 0;
                }
                return true;
            }
        }
    }

    public static boolean isValid(Duration duration) {
        return isValid(duration.getSeconds(), duration.getNanos());
    }

    public static Duration normalizedDuration(long j, int i2) {
        long j2 = (long) i2;
        if (j2 <= -1000000000 || j2 >= 1000000000) {
            j = LongMath.checkedAdd(j, j2 / 1000000000);
            i2 = (int) (j2 % 1000000000);
        }
        if (j > 0 && i2 < 0) {
            i2 = (int) (((long) i2) + 1000000000);
            j--;
        }
        if (j < 0 && i2 > 0) {
            i2 = (int) (((long) i2) - 1000000000);
            j++;
        }
        return checkValid(Duration.newBuilder().setSeconds(j).setNanos(i2).build());
    }

    public static Duration parse(String str) throws ParseException {
        boolean z;
        String str2;
        if (str.isEmpty() || str.charAt(str.length() - 1) != 's') {
            throw new ParseException("Invalid duration string: " + str, 0);
        }
        if (str.charAt(0) == '-') {
            str = str.substring(1);
            z = true;
        } else {
            z = false;
        }
        String substring = str.substring(0, str.length() - 1);
        int indexOf = substring.indexOf(46);
        if (indexOf != -1) {
            str2 = substring.substring(indexOf + 1);
            substring = substring.substring(0, indexOf);
        } else {
            str2 = "";
        }
        long parseLong = Long.parseLong(substring);
        int parseNanos = str2.isEmpty() ? 0 : Timestamps.parseNanos(str2);
        if (parseLong >= 0) {
            if (z) {
                parseLong = -parseLong;
                parseNanos = -parseNanos;
            }
            try {
                return normalizedDuration(parseLong, parseNanos);
            } catch (IllegalArgumentException unused) {
                throw new ParseException("Duration value is out of range.", 0);
            }
        } else {
            throw new ParseException("Invalid duration string: " + str, 0);
        }
    }

    public static Duration subtract(Duration duration, Duration duration2) {
        checkValid(duration);
        checkValid(duration2);
        return normalizedDuration(LongMath.checkedSubtract(duration.getSeconds(), duration2.getSeconds()), IntMath.checkedSubtract(duration.getNanos(), duration2.getNanos()));
    }

    public static long toDays(Duration duration) {
        return checkValid(duration).getSeconds() / 86400;
    }

    public static long toHours(Duration duration) {
        return checkValid(duration).getSeconds() / SECONDS_PER_HOUR;
    }

    public static long toMicros(Duration duration) {
        checkValid(duration);
        return LongMath.checkedAdd(LongMath.checkedMultiply(duration.getSeconds(), 1000000), ((long) duration.getNanos()) / 1000);
    }

    public static long toMillis(Duration duration) {
        checkValid(duration);
        return LongMath.checkedAdd(LongMath.checkedMultiply(duration.getSeconds(), 1000), ((long) duration.getNanos()) / 1000000);
    }

    public static long toMinutes(Duration duration) {
        return checkValid(duration).getSeconds() / 60;
    }

    public static long toNanos(Duration duration) {
        checkValid(duration);
        return LongMath.checkedAdd(LongMath.checkedMultiply(duration.getSeconds(), 1000000000), (long) duration.getNanos());
    }

    public static long toSeconds(Duration duration) {
        return checkValid(duration).getSeconds();
    }

    public static double toSecondsAsDouble(Duration duration) {
        checkValid(duration);
        return ((double) duration.getSeconds()) + (((double) duration.getNanos()) / 1.0E9d);
    }

    public static String toString(Duration duration) {
        checkValid(duration);
        long seconds = duration.getSeconds();
        int nanos = duration.getNanos();
        StringBuilder sb = new StringBuilder();
        if (seconds < 0 || nanos < 0) {
            sb.append("-");
            seconds = -seconds;
            nanos = -nanos;
        }
        sb.append(seconds);
        if (nanos != 0) {
            sb.append(IStringUtil.CURRENT_PATH);
            sb.append(Timestamps.formatNanos(nanos));
        }
        sb.append("s");
        return sb.toString();
    }

    public static Duration checkValid(Duration.Builder builder) {
        return checkValid(builder.build());
    }
}
