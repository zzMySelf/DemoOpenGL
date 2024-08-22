package com.google.protobuf.util;

import com.google.protobuf.Duration;
import com.google.protobuf.Timestamp;
import java.math.BigInteger;
import java.text.ParseException;

@Deprecated
public final class TimeUtil {
    public static final long DURATION_SECONDS_MAX = 315576000000L;
    public static final long DURATION_SECONDS_MIN = -315576000000L;
    public static final long NANOS_PER_SECOND = 1000000000;
    public static final BigInteger NANOS_PER_SECOND_BIG_INTEGER = new BigInteger(String.valueOf(1000000000));
    public static final long TIMESTAMP_SECONDS_MAX = 253402300799L;
    public static final long TIMESTAMP_SECONDS_MIN = -62135596800L;

    @Deprecated
    public static Timestamp add(Timestamp timestamp, Duration duration) {
        return Timestamps.add(timestamp, duration);
    }

    public static Duration createDurationFromBigInteger(BigInteger bigInteger) {
        return normalizedDuration(bigInteger.divide(new BigInteger(String.valueOf(1000000000))).longValue(), bigInteger.remainder(new BigInteger(String.valueOf(1000000000))).intValue());
    }

    @Deprecated
    public static Duration createDurationFromMicros(long j) {
        return Durations.fromMicros(j);
    }

    @Deprecated
    public static Duration createDurationFromMillis(long j) {
        return Durations.fromMillis(j);
    }

    @Deprecated
    public static Duration createDurationFromNanos(long j) {
        return Durations.fromNanos(j);
    }

    @Deprecated
    public static Timestamp createTimestampFromMicros(long j) {
        return Timestamps.fromMicros(j);
    }

    @Deprecated
    public static Timestamp createTimestampFromMillis(long j) {
        return Timestamps.fromMillis(j);
    }

    @Deprecated
    public static Timestamp createTimestampFromNanos(long j) {
        return Timestamps.fromNanos(j);
    }

    @Deprecated
    public static Duration distance(Timestamp timestamp, Timestamp timestamp2) {
        return Timestamps.between(timestamp, timestamp2);
    }

    public static Duration divide(Duration duration, double d) {
        return multiply(duration, 1.0d / d);
    }

    @Deprecated
    public static Timestamp getCurrentTime() {
        return Timestamps.fromMillis(System.currentTimeMillis());
    }

    @Deprecated
    public static Timestamp getEpoch() {
        return Timestamp.getDefaultInstance();
    }

    public static Duration multiply(Duration duration, double d) {
        double seconds = (((double) duration.getSeconds()) * d) + ((((double) duration.getNanos()) * d) / 1.0E9d);
        if (seconds < -9.223372036854776E18d || seconds > 9.223372036854776E18d) {
            throw new IllegalArgumentException("Result is out of valid range.");
        }
        long j = (long) seconds;
        return normalizedDuration(j, (int) ((seconds - ((double) j)) * 1.0E9d));
    }

    public static Duration normalizedDuration(long j, int i2) {
        long j2 = (long) i2;
        if (j2 <= -1000000000 || j2 >= 1000000000) {
            j += j2 / 1000000000;
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
        if (j >= -315576000000L && j <= 315576000000L) {
            return Duration.newBuilder().setSeconds(j).setNanos(i2).build();
        }
        throw new IllegalArgumentException("Duration is out of valid range.");
    }

    @Deprecated
    public static Duration parseDuration(String str) throws ParseException {
        return Durations.parse(str);
    }

    @Deprecated
    public static Timestamp parseTimestamp(String str) throws ParseException {
        return Timestamps.parse(str);
    }

    public static Duration remainder(Duration duration, Duration duration2) {
        return createDurationFromBigInteger(toBigInteger(duration).remainder(toBigInteger(duration2)));
    }

    @Deprecated
    public static Timestamp subtract(Timestamp timestamp, Duration duration) {
        return Timestamps.subtract(timestamp, duration);
    }

    public static BigInteger toBigInteger(Duration duration) {
        return toBigInteger(duration.getSeconds()).multiply(NANOS_PER_SECOND_BIG_INTEGER).add(toBigInteger((long) duration.getNanos()));
    }

    @Deprecated
    public static long toMicros(Timestamp timestamp) {
        return Timestamps.toMicros(timestamp);
    }

    @Deprecated
    public static long toMillis(Timestamp timestamp) {
        return Timestamps.toMillis(timestamp);
    }

    @Deprecated
    public static long toNanos(Timestamp timestamp) {
        return Timestamps.toNanos(timestamp);
    }

    @Deprecated
    public static String toString(Timestamp timestamp) {
        return Timestamps.toString(timestamp);
    }

    @Deprecated
    public static Duration add(Duration duration, Duration duration2) {
        return Durations.add(duration, duration2);
    }

    public static Duration divide(Duration duration, long j) {
        return createDurationFromBigInteger(toBigInteger(duration).divide(toBigInteger(j)));
    }

    @Deprecated
    public static Duration subtract(Duration duration, Duration duration2) {
        return Durations.subtract(duration, duration2);
    }

    @Deprecated
    public static long toMicros(Duration duration) {
        return Durations.toMicros(duration);
    }

    @Deprecated
    public static long toMillis(Duration duration) {
        return Durations.toMillis(duration);
    }

    @Deprecated
    public static long toNanos(Duration duration) {
        return Durations.toNanos(duration);
    }

    @Deprecated
    public static String toString(Duration duration) {
        return Durations.toString(duration);
    }

    public static long divide(Duration duration, Duration duration2) {
        return toBigInteger(duration).divide(toBigInteger(duration2)).longValue();
    }

    public static Duration multiply(Duration duration, long j) {
        return createDurationFromBigInteger(toBigInteger(duration).multiply(toBigInteger(j)));
    }

    public static BigInteger toBigInteger(long j) {
        return new BigInteger(String.valueOf(j));
    }
}
