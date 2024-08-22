package kotlin.text;

import com.google.common.net.MediaType;
import com.tera.scan.doc.preview.document.ui.view.DocumentViewerActivity;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.internal.InlineOnly;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\f\n\u0002\b\u0011\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\b\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\b\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\b\u001a\u0019\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\b\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\b\u001a)\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\b\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\b\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\b\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\b\u001a\f\u0010\u0017\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0014\u0010\u0017\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0007\u001a\u0015\u0010\u001a\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0011H\b\u001a\u0015\u0010\u001c\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0011H\b\u001a\u001d\u0010\u001d\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\b\u001a\u001c\u0010 \u001a\u00020\u0011*\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a\f\u0010$\u001a\u00020\u0002*\u00020\u0014H\u0007\u001a \u0010$\u001a\u00020\u0002*\u00020\u00142\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\u0007\u001a\u0019\u0010&\u001a\u00020#*\u0004\u0018\u00010'2\b\u0010!\u001a\u0004\u0018\u00010'H\u0004\u001a \u0010&\u001a\u00020#*\u0004\u0018\u00010'2\b\u0010!\u001a\u0004\u0018\u00010'2\u0006\u0010\"\u001a\u00020#H\u0007\u001a\u0015\u0010&\u001a\u00020#*\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\b\u001a\u0015\u0010&\u001a\u00020#*\u00020\u00022\u0006\u0010(\u001a\u00020'H\b\u001a\f\u0010)\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0014\u0010)\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0007\u001a\f\u0010*\u001a\u00020\u0002*\u00020\rH\u0007\u001a*\u0010*\u001a\u00020\u0002*\u00020\r2\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u00112\b\b\u0002\u0010+\u001a\u00020#H\u0007\u001a\f\u0010,\u001a\u00020\r*\u00020\u0002H\u0007\u001a*\u0010,\u001a\u00020\r*\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u00112\b\b\u0002\u0010+\u001a\u00020#H\u0007\u001a\u001c\u0010-\u001a\u00020#*\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a \u0010/\u001a\u00020#*\u0004\u0018\u00010\u00022\b\u0010!\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a2\u00100\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\b¢\u0006\u0002\u00104\u001a6\u00100\u001a\u00020\u0002*\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\b¢\u0006\u0004\b5\u00104\u001a*\u00100\u001a\u00020\u0002*\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\b¢\u0006\u0002\u00106\u001a:\u00100\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\b¢\u0006\u0002\u00107\u001a>\u00100\u001a\u00020\u0002*\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u00100\u001a\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\b¢\u0006\u0004\b5\u00107\u001a2\u00100\u001a\u00020\u0002*\u00020\u00042\u0006\u00100\u001a\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\b¢\u0006\u0002\u00108\u001a\r\u00109\u001a\u00020\u0002*\u00020\u0002H\b\u001a\n\u0010:\u001a\u00020#*\u00020'\u001a\r\u0010;\u001a\u00020\u0002*\u00020\u0002H\b\u001a\u0015\u0010;\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\b\u001a\u001d\u0010<\u001a\u00020\u0011*\u00020\u00022\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0011H\b\u001a\u001d\u0010<\u001a\u00020\u0011*\u00020\u00022\u0006\u0010@\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u0011H\b\u001a\u001d\u0010A\u001a\u00020\u0011*\u00020\u00022\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0011H\b\u001a\u001d\u0010A\u001a\u00020\u0011*\u00020\u00022\u0006\u0010@\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u0011H\b\u001a\u001d\u0010B\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010C\u001a\u00020\u0011H\b\u001a4\u0010D\u001a\u00020#*\u00020'2\u0006\u0010E\u001a\u00020\u00112\u0006\u0010!\u001a\u00020'2\u0006\u0010F\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020#\u001a4\u0010D\u001a\u00020#*\u00020\u00022\u0006\u0010E\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00022\u0006\u0010F\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020#\u001a\u0012\u0010G\u001a\u00020\u0002*\u00020'2\u0006\u0010H\u001a\u00020\u0011\u001a$\u0010I\u001a\u00020\u0002*\u00020\u00022\u0006\u0010J\u001a\u00020>2\u0006\u0010K\u001a\u00020>2\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010I\u001a\u00020\u0002*\u00020\u00022\u0006\u0010L\u001a\u00020\u00022\u0006\u0010M\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010N\u001a\u00020\u0002*\u00020\u00022\u0006\u0010J\u001a\u00020>2\u0006\u0010K\u001a\u00020>2\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010N\u001a\u00020\u0002*\u00020\u00022\u0006\u0010L\u001a\u00020\u00022\u0006\u0010M\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a\"\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00020P*\u00020'2\u0006\u0010Q\u001a\u00020R2\b\b\u0002\u0010S\u001a\u00020\u0011\u001a\u001c\u0010T\u001a\u00020#*\u00020\u00022\u0006\u0010U\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010T\u001a\u00020#*\u00020\u00022\u0006\u0010U\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020#\u001a\u0015\u0010V\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0011H\b\u001a\u001d\u0010V\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\b\u001a\u0017\u0010W\u001a\u00020\r*\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\b\u001a\r\u0010X\u001a\u00020\u0014*\u00020\u0002H\b\u001a3\u0010X\u001a\u00020\u0014*\u00020\u00022\u0006\u0010Y\u001a\u00020\u00142\b\b\u0002\u0010Z\u001a\u00020\u00112\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\b\u001a \u0010X\u001a\u00020\u0014*\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\u0007\u001a\r\u0010[\u001a\u00020\u0002*\u00020\u0002H\b\u001a\u0015\u0010[\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\b\u001a\u0017\u0010\\\u001a\u00020R*\u00020\u00022\b\b\u0002\u0010]\u001a\u00020\u0011H\b\u001a\r\u0010^\u001a\u00020\u0002*\u00020\u0002H\b\u001a\u0015\u0010^\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\b\u001a\r\u0010_\u001a\u00020\u0002*\u00020\u0002H\b\u001a\u0015\u0010_\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\b\"%\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006`"}, d2 = {"CASE_INSENSITIVE_ORDER", "Ljava/util/Comparator;", "", "Lkotlin/Comparator;", "Lkotlin/String$Companion;", "getCASE_INSENSITIVE_ORDER", "(Lkotlin/jvm/internal/StringCompanionObject;)Ljava/util/Comparator;", "String", "stringBuffer", "Ljava/lang/StringBuffer;", "stringBuilder", "Ljava/lang/StringBuilder;", "bytes", "", "charset", "Ljava/nio/charset/Charset;", "offset", "", "length", "chars", "", "codePoints", "", "capitalize", "locale", "Ljava/util/Locale;", "codePointAt", "index", "codePointBefore", "codePointCount", "beginIndex", "endIndex", "compareTo", "other", "ignoreCase", "", "concatToString", "startIndex", "contentEquals", "", "charSequence", "decapitalize", "decodeToString", "throwOnInvalidSequence", "encodeToByteArray", "endsWith", "suffix", "equals", "format", "args", "", "", "(Ljava/lang/String;Ljava/util/Locale;[Ljava/lang/Object;)Ljava/lang/String;", "formatNullable", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "intern", "isBlank", "lowercase", "nativeIndexOf", "ch", "", "fromIndex", "str", "nativeLastIndexOf", "offsetByCodePoints", "codePointOffset", "regionMatches", "thisOffset", "otherOffset", "repeat", "n", "replace", "oldChar", "newChar", "oldValue", "newValue", "replaceFirst", "split", "", "regex", "Ljava/util/regex/Pattern;", "limit", "startsWith", "prefix", "substring", "toByteArray", "toCharArray", "destination", "destinationOffset", "toLowerCase", "toPattern", "flags", "toUpperCase", "uppercase", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/text/StringsKt")
public class StringsKt__StringsJVMKt extends StringsKt__StringNumberConversionsKt {
    @InlineOnly
    public static final String String(byte[] bArr, int i2, int i3, Charset charset) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        Intrinsics.checkNotNullParameter(charset, MediaType.CHARSET_ATTRIBUTE);
        return new String(bArr, i2, i3, charset);
    }

    @NotNull
    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String capitalize(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        return capitalize(str, locale);
    }

    @InlineOnly
    public static final int codePointAt(String str, int i2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return str.codePointAt(i2);
    }

    @InlineOnly
    public static final int codePointBefore(String str, int i2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return str.codePointBefore(i2);
    }

    @InlineOnly
    public static final int codePointCount(String str, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return str.codePointCount(i2, i3);
    }

    public static final int compareTo(@NotNull String str, @NotNull String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "other");
        if (z) {
            return str.compareToIgnoreCase(str2);
        }
        return str.compareTo(str2);
    }

    public static /* synthetic */ int compareTo$default(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return compareTo(str, str2, z);
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String concatToString(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return new String(cArr);
    }

    public static /* synthetic */ String concatToString$default(char[] cArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = cArr.length;
        }
        return concatToString(cArr, i2, i3);
    }

    @InlineOnly
    public static final boolean contentEquals(String str, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        return str.contentEquals(charSequence);
    }

    @NotNull
    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { it.lowercase(Locale.getDefault()) }", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String decapitalize(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (!(str.length() > 0) || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(0, 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        String lowerCase = substring.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        sb.append(lowerCase);
        String substring2 = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
        sb.append(substring2);
        return sb.toString();
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String decodeToString(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return new String(bArr, Charsets.UTF_8);
    }

    public static /* synthetic */ String decodeToString$default(byte[] bArr, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = bArr.length;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return decodeToString(bArr, i2, i3, z);
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final byte[] encodeToByteArray(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static /* synthetic */ byte[] encodeToByteArray$default(String str, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return encodeToByteArray(str, i2, i3, z);
    }

    public static final boolean endsWith(@NotNull String str, @NotNull String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, DocumentViewerActivity.KEY_SUFFIX);
        if (!z) {
            return str.endsWith(str2);
        }
        return regionMatches(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static /* synthetic */ boolean endsWith$default(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return endsWith(str, str2, z);
    }

    public static final boolean equals(@Nullable String str, @Nullable String str2, boolean z) {
        if (str == null) {
            return str2 == null;
        }
        if (!z) {
            return str.equals(str2);
        }
        return str.equalsIgnoreCase(str2);
    }

    public static /* synthetic */ boolean equals$default(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return equals(str, str2, z);
    }

    @InlineOnly
    public static final String format(String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(objArr, "args");
        String format = String.format(str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        return format;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "formatNullable")
    public static final String formatNullable(String str, Locale locale, Object... objArr) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(objArr, "args");
        String format = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, this, *args)");
        return format;
    }

    @NotNull
    public static final Comparator<String> getCASE_INSENSITIVE_ORDER(@NotNull StringCompanionObject stringCompanionObject) {
        Intrinsics.checkNotNullParameter(stringCompanionObject, "<this>");
        Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;
        Intrinsics.checkNotNullExpressionValue(comparator, "CASE_INSENSITIVE_ORDER");
        return comparator;
    }

    @InlineOnly
    public static final String intern(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String intern = str.intern();
        Intrinsics.checkNotNullExpressionValue(intern, "this as java.lang.String).intern()");
        return intern;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isBlank(@org.jetbrains.annotations.NotNull java.lang.CharSequence r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            int r0 = r4.length()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x003e
            kotlin.ranges.IntRange r0 = kotlin.text.StringsKt__StringsKt.getIndices(r4)
            boolean r3 = r0 instanceof java.util.Collection
            if (r3 == 0) goto L_0x0020
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0020
        L_0x001e:
            r4 = 1
            goto L_0x003c
        L_0x0020:
            java.util.Iterator r0 = r0.iterator()
        L_0x0024:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x001e
            r3 = r0
            kotlin.collections.IntIterator r3 = (kotlin.collections.IntIterator) r3
            int r3 = r3.nextInt()
            char r3 = r4.charAt(r3)
            boolean r3 = kotlin.text.CharsKt__CharJVMKt.isWhitespace(r3)
            if (r3 != 0) goto L_0x0024
            r4 = 0
        L_0x003c:
            if (r4 == 0) goto L_0x003f
        L_0x003e:
            r1 = 1
        L_0x003f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__StringsJVMKt.isBlank(java.lang.CharSequence):boolean");
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String lowercase(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    @InlineOnly
    public static final int nativeIndexOf(String str, char c, int i2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return str.indexOf(c, i2);
    }

    @InlineOnly
    public static final int nativeLastIndexOf(String str, char c, int i2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return str.lastIndexOf(c, i2);
    }

    @InlineOnly
    public static final int offsetByCodePoints(String str, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return str.offsetByCodePoints(i2, i3);
    }

    public static final boolean regionMatches(@NotNull CharSequence charSequence, int i2, @NotNull CharSequence charSequence2, int i3, int i4, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(charSequence2, "other");
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            return StringsKt__StringsKt.regionMatchesImpl(charSequence, i2, charSequence2, i3, i4, z);
        }
        return regionMatches((String) charSequence, i2, (String) charSequence2, i3, i4, z);
    }

    public static /* synthetic */ boolean regionMatches$default(CharSequence charSequence, int i2, CharSequence charSequence2, int i3, int i4, boolean z, int i5, Object obj) {
        return regionMatches(charSequence, i2, charSequence2, i3, i4, (i5 & 16) != 0 ? false : z);
    }

    @NotNull
    public static final String repeat(@NotNull CharSequence charSequence, int i2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int i3 = 1;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i2 + '.').toString());
        } else if (i2 == 0) {
            return "";
        } else {
            if (i2 == 1) {
                return charSequence.toString();
            }
            int length = charSequence.length();
            if (length == 0) {
                return "";
            }
            if (length != 1) {
                StringBuilder sb = new StringBuilder(charSequence.length() * i2);
                if (1 <= i2) {
                    while (true) {
                        sb.append(charSequence);
                        if (i3 == i2) {
                            break;
                        }
                        i3++;
                    }
                }
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "{\n                    va…tring()\n                }");
                return sb2;
            }
            char charAt = charSequence.charAt(0);
            char[] cArr = new char[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                cArr[i4] = charAt;
            }
            return new String(cArr);
        }
    }

    @NotNull
    public static final String replace(@NotNull String str, char c, char c2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (!z) {
            String replace = str.replace(c, c2);
            Intrinsics.checkNotNullExpressionValue(replace, "this as java.lang.String…replace(oldChar, newChar)");
            return replace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (CharsKt__CharKt.equals(charAt, c, z)) {
                charAt = c2;
            }
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public static /* synthetic */ String replace$default(String str, char c, char c2, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return replace(str, c, c2, z);
    }

    @NotNull
    public static final String replaceFirst(@NotNull String str, char c, char c2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, c, 0, z, 2, (Object) null);
        return indexOf$default < 0 ? str : StringsKt__StringsKt.replaceRange((CharSequence) str, indexOf$default, indexOf$default + 1, (CharSequence) String.valueOf(c2)).toString();
    }

    public static /* synthetic */ String replaceFirst$default(String str, char c, char c2, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return replaceFirst(str, c, c2, z);
    }

    @NotNull
    public static final List<String> split(@NotNull CharSequence charSequence, @NotNull Pattern pattern, int i2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(pattern, "regex");
        StringsKt__StringsKt.requireNonNegativeLimit(i2);
        if (i2 == 0) {
            i2 = -1;
        }
        String[] split = pattern.split(charSequence, i2);
        Intrinsics.checkNotNullExpressionValue(split, "regex.split(this, if (limit == 0) -1 else limit)");
        return ArraysKt___ArraysJvmKt.asList((T[]) split);
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, Pattern pattern, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return split(charSequence, pattern, i2);
    }

    public static final boolean startsWith(@NotNull String str, @NotNull String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "prefix");
        if (!z) {
            return str.startsWith(str2);
        }
        return regionMatches(str, 0, str2, 0, str2.length(), z);
    }

    public static /* synthetic */ boolean startsWith$default(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return startsWith(str, str2, z);
    }

    @InlineOnly
    public static final String substring(String str, int i2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String substring = str.substring(i2);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    @InlineOnly
    public static final byte[] toByteArray(String str, Charset charset) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, MediaType.CHARSET_ATTRIBUTE);
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static /* synthetic */ byte[] toByteArray$default(String str, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, MediaType.CHARSET_ATTRIBUTE);
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final char[] toCharArray(@NotNull String str, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(i2, i3, str.length());
        char[] cArr = new char[(i3 - i2)];
        str.getChars(i2, i3, cArr, 0);
        return cArr;
    }

    public static /* synthetic */ char[] toCharArray$default(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return toCharArray(str, i2, i3);
    }

    @Deprecated(message = "Use lowercase() instead.", replaceWith = @ReplaceWith(expression = "lowercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    @InlineOnly
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String toLowerCase(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String lowerCase = str.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        return lowerCase;
    }

    @InlineOnly
    public static final Pattern toPattern(String str, int i2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Pattern compile = Pattern.compile(str, i2);
        Intrinsics.checkNotNullExpressionValue(compile, "compile(this, flags)");
        return compile;
    }

    public static /* synthetic */ Pattern toPattern$default(String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Pattern compile = Pattern.compile(str, i2);
        Intrinsics.checkNotNullExpressionValue(compile, "compile(this, flags)");
        return compile;
    }

    @Deprecated(message = "Use uppercase() instead.", replaceWith = @ReplaceWith(expression = "uppercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    @InlineOnly
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String toUpperCase(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String upperCase = str.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase()");
        return upperCase;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String uppercase(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String upperCase = str.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase;
    }

    @InlineOnly
    public static final String String(byte[] bArr, Charset charset) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        Intrinsics.checkNotNullParameter(charset, MediaType.CHARSET_ATTRIBUTE);
        return new String(bArr, charset);
    }

    @SinceKotlin(version = "1.4")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @NotNull
    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(locale) else it.toString() }", imports = {}))
    @LowPriorityInOverloadResolution
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String capitalize(@NotNull String str, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        if (!(str.length() > 0)) {
            return str;
        }
        char charAt = str.charAt(0);
        if (!Character.isLowerCase(charAt)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char titleCase = Character.toTitleCase(charAt);
        if (titleCase != Character.toUpperCase(charAt)) {
            sb.append(titleCase);
        } else {
            String substring = str.substring(0, 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            String upperCase = substring.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
            sb.append(upperCase);
        }
        String substring2 = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
        sb.append(substring2);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String concatToString(@NotNull char[] cArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(i2, i3, cArr.length);
        return new String(cArr, i2, i3 - i2);
    }

    @InlineOnly
    public static final boolean contentEquals(String str, StringBuffer stringBuffer) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(stringBuffer, "stringBuilder");
        return str.contentEquals(stringBuffer);
    }

    @SinceKotlin(version = "1.4")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @NotNull
    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { it.lowercase(locale) }", imports = {}))
    @LowPriorityInOverloadResolution
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String decapitalize(@NotNull String str, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        if (!(str.length() > 0) || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(0, 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        String lowerCase = substring.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        sb.append(lowerCase);
        String substring2 = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
        sb.append(substring2);
        return sb.toString();
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String decodeToString(@NotNull byte[] bArr, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(i2, i3, bArr.length);
        if (!z) {
            return new String(bArr, i2, i3 - i2, Charsets.UTF_8);
        }
        String charBuffer = Charsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(bArr, i2, i3 - i2)).toString();
        Intrinsics.checkNotNullExpressionValue(charBuffer, "decoder.decode(ByteBuffe…- startIndex)).toString()");
        return charBuffer;
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final byte[] encodeToByteArray(@NotNull String str, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(i2, i3, str.length());
        if (!z) {
            String substring = str.substring(i2, i3);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            byte[] bytes = substring.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return bytes;
        }
        ByteBuffer encode = Charsets.UTF_8.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).encode(CharBuffer.wrap(str, i2, i3));
        if (encode.hasArray() && encode.arrayOffset() == 0) {
            int remaining = encode.remaining();
            byte[] array = encode.array();
            Intrinsics.checkNotNull(array);
            if (remaining == array.length) {
                byte[] array2 = encode.array();
                Intrinsics.checkNotNullExpressionValue(array2, "{\n        byteBuffer.array()\n    }");
                return array2;
            }
        }
        byte[] bArr = new byte[encode.remaining()];
        encode.get(bArr);
        return bArr;
    }

    @InlineOnly
    public static final String format(StringCompanionObject stringCompanionObject, String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(stringCompanionObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "format");
        Intrinsics.checkNotNullParameter(objArr, "args");
        String format = String.format(str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "formatNullable")
    public static final String formatNullable(StringCompanionObject stringCompanionObject, Locale locale, String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(stringCompanionObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "format");
        Intrinsics.checkNotNullParameter(objArr, "args");
        String format = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        return format;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String lowercase(String str, Locale locale) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    @InlineOnly
    public static final int nativeIndexOf(String str, String str2, int i2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "str");
        return str.indexOf(str2, i2);
    }

    @InlineOnly
    public static final int nativeLastIndexOf(String str, String str2, int i2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "str");
        return str.lastIndexOf(str2, i2);
    }

    public static /* synthetic */ boolean regionMatches$default(String str, int i2, String str2, int i3, int i4, boolean z, int i5, Object obj) {
        return regionMatches(str, i2, str2, i3, i4, (i5 & 16) != 0 ? false : z);
    }

    public static /* synthetic */ String replace$default(String str, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return replace(str, str2, str3, z);
    }

    public static /* synthetic */ String replaceFirst$default(String str, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return replaceFirst(str, str2, str3, z);
    }

    public static /* synthetic */ boolean startsWith$default(String str, String str2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = false;
        }
        return startsWith(str, str2, i2, z);
    }

    @InlineOnly
    public static final String substring(String str, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String substring = str.substring(i2, i3);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ char[] toCharArray$default(String str, char[] cArr, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = str.length();
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "destination");
        str.getChars(i3, i4, cArr, i2);
        return cArr;
    }

    @Deprecated(message = "Use lowercase() instead.", replaceWith = @ReplaceWith(expression = "lowercase(locale)", imports = {}))
    @InlineOnly
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String toLowerCase(String str, Locale locale) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    @Deprecated(message = "Use uppercase() instead.", replaceWith = @ReplaceWith(expression = "uppercase(locale)", imports = {}))
    @InlineOnly
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String toUpperCase(String str, Locale locale) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        String upperCase = str.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String uppercase(String str, Locale locale) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        String upperCase = str.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }

    @InlineOnly
    public static final String String(byte[] bArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        return new String(bArr, i2, i3, Charsets.UTF_8);
    }

    @SinceKotlin(version = "1.5")
    public static final boolean contentEquals(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        if (!(charSequence instanceof String) || charSequence2 == null) {
            return StringsKt__StringsKt.contentEqualsImpl(charSequence, charSequence2);
        }
        return ((String) charSequence).contentEquals(charSequence2);
    }

    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @InlineOnly
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    public static final /* synthetic */ String format(String str, Locale locale, Object... objArr) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(objArr, "args");
        String format = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, this, *args)");
        return format;
    }

    @NotNull
    public static final String replaceFirst(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "oldValue");
        Intrinsics.checkNotNullParameter(str3, "newValue");
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, str2, 0, z, 2, (Object) null);
        return indexOf$default < 0 ? str : StringsKt__StringsKt.replaceRange((CharSequence) str, indexOf$default, str2.length() + indexOf$default, (CharSequence) str3).toString();
    }

    public static final boolean startsWith(@NotNull String str, @NotNull String str2, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "prefix");
        if (!z) {
            return str.startsWith(str2, i2);
        }
        return regionMatches(str, i2, str2, 0, str2.length(), z);
    }

    @InlineOnly
    public static final char[] toCharArray(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        char[] charArray = str.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        return charArray;
    }

    @InlineOnly
    public static final String String(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        return new String(bArr, Charsets.UTF_8);
    }

    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @InlineOnly
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    public static final /* synthetic */ String format(StringCompanionObject stringCompanionObject, Locale locale, String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(stringCompanionObject, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(str, "format");
        Intrinsics.checkNotNullParameter(objArr, "args");
        String format = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        return format;
    }

    public static final boolean regionMatches(@NotNull String str, int i2, @NotNull String str2, int i3, int i4, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "other");
        if (!z) {
            return str.regionMatches(i2, str2, i3, i4);
        }
        return str.regionMatches(z, i2, str2, i3, i4);
    }

    @InlineOnly
    public static final char[] toCharArray(String str, char[] cArr, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "destination");
        str.getChars(i3, i4, cArr, i2);
        return cArr;
    }

    @InlineOnly
    public static final String String(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "chars");
        return new String(cArr);
    }

    @InlineOnly
    public static final String String(char[] cArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(cArr, "chars");
        return new String(cArr, i2, i3);
    }

    @SinceKotlin(version = "1.5")
    public static final boolean contentEquals(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, boolean z) {
        if (z) {
            return StringsKt__StringsKt.contentEqualsIgnoreCaseImpl(charSequence, charSequence2);
        }
        return contentEquals(charSequence, charSequence2);
    }

    @NotNull
    public static final String replace(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "oldValue");
        Intrinsics.checkNotNullParameter(str3, "newValue");
        int i2 = 0;
        int indexOf = StringsKt__StringsKt.indexOf((CharSequence) str, str2, 0, z);
        if (indexOf < 0) {
            return str;
        }
        int length = str2.length();
        int coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            do {
                sb.append(str, i2, indexOf);
                sb.append(str3);
                i2 = indexOf + length;
                if (indexOf >= str.length() || (indexOf = StringsKt__StringsKt.indexOf((CharSequence) str, str2, indexOf + coerceAtLeast, z)) <= 0) {
                    sb.append(str, i2, str.length());
                    String sb2 = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.append(this, i, length).toString()");
                }
                sb.append(str, i2, indexOf);
                sb.append(str3);
                i2 = indexOf + length;
                break;
            } while ((indexOf = StringsKt__StringsKt.indexOf((CharSequence) str, str2, indexOf + coerceAtLeast, z)) <= 0);
            sb.append(str, i2, str.length());
            String sb22 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb22, "stringBuilder.append(this, i, length).toString()");
            return sb22;
        }
        throw new OutOfMemoryError();
    }

    @InlineOnly
    public static final String String(int[] iArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "codePoints");
        return new String(iArr, i2, i3);
    }

    @InlineOnly
    public static final String String(StringBuffer stringBuffer) {
        Intrinsics.checkNotNullParameter(stringBuffer, "stringBuffer");
        return new String(stringBuffer);
    }

    @InlineOnly
    public static final String String(StringBuilder sb) {
        Intrinsics.checkNotNullParameter(sb, "stringBuilder");
        return new String(sb);
    }
}
