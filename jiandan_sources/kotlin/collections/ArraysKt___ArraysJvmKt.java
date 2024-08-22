package kotlin.collections;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000¬\u0001\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0018\n\u0002\u0010\u0005\n\u0002\u0010\u0012\n\u0002\u0010\f\n\u0002\u0010\u0019\n\u0002\u0010\u0006\n\u0002\u0010\u0013\n\u0002\u0010\u0007\n\u0002\u0010\u0014\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\u0010\n\n\u0002\u0010\u0017\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u000f\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003¢\u0006\u0002\u0010\u0004\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001*\u00020\u0006\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001*\u00020\b\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\t0\u0001*\u00020\n\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001*\u00020\f\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u000e\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001*\u00020\u0010\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00110\u0001*\u00020\u0012\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00130\u0001*\u00020\u0014\u001aU\u0010\u0015\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u0006\u0010\u0016\u001a\u0002H\u00022\u001a\u0010\u0017\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0018j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f¢\u0006\u0002\u0010\u001c\u001a9\u0010\u0015\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u0006\u0010\u0016\u001a\u0002H\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f¢\u0006\u0002\u0010\u001d\u001a&\u0010\u0015\u001a\u00020\u000f*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010\u0015\u001a\u00020\u000f*\u00020\n2\u0006\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010\u0015\u001a\u00020\u000f*\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010\u0015\u001a\u00020\u000f*\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010\u0015\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010\u0015\u001a\u00020\u000f*\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010\u0015\u001a\u00020\u000f*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a2\u0010\u001e\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u000e\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\f¢\u0006\u0004\b \u0010!\u001a6\u0010\u001e\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u00032\u0010\u0010\u001f\u001a\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\f¢\u0006\u0004\b\"\u0010!\u001a\"\u0010#\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\b¢\u0006\u0004\b$\u0010%\u001a$\u0010#\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\b¢\u0006\u0004\b&\u0010%\u001a\"\u0010'\u001a\u00020(\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\b¢\u0006\u0004\b)\u0010*\u001a$\u0010'\u001a\u00020(\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\b¢\u0006\u0004\b+\u0010*\u001a0\u0010,\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u000e\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\f¢\u0006\u0002\u0010!\u001a6\u0010,\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u00032\u0010\u0010\u001f\u001a\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\f¢\u0006\u0004\b-\u0010!\u001a\u0015\u0010,\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\f\u001a\u001e\u0010,\u001a\u00020\u0005*\u0004\u0018\u00010\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u0006H\f¢\u0006\u0002\b-\u001a\u0015\u0010,\u001a\u00020\u0005*\u00020\b2\u0006\u0010\u001f\u001a\u00020\bH\f\u001a\u001e\u0010,\u001a\u00020\u0005*\u0004\u0018\u00010\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\bH\f¢\u0006\u0002\b-\u001a\u0015\u0010,\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH\f\u001a\u001e\u0010,\u001a\u00020\u0005*\u0004\u0018\u00010\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\nH\f¢\u0006\u0002\b-\u001a\u0015\u0010,\u001a\u00020\u0005*\u00020\f2\u0006\u0010\u001f\u001a\u00020\fH\f\u001a\u001e\u0010,\u001a\u00020\u0005*\u0004\u0018\u00010\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\fH\f¢\u0006\u0002\b-\u001a\u0015\u0010,\u001a\u00020\u0005*\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000eH\f\u001a\u001e\u0010,\u001a\u00020\u0005*\u0004\u0018\u00010\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000eH\f¢\u0006\u0002\b-\u001a\u0015\u0010,\u001a\u00020\u0005*\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0010H\f\u001a\u001e\u0010,\u001a\u00020\u0005*\u0004\u0018\u00010\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u0010H\f¢\u0006\u0002\b-\u001a\u0015\u0010,\u001a\u00020\u0005*\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0012H\f\u001a\u001e\u0010,\u001a\u00020\u0005*\u0004\u0018\u00010\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010\u0012H\f¢\u0006\u0002\b-\u001a\u0015\u0010,\u001a\u00020\u0005*\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u0014H\f\u001a\u001e\u0010,\u001a\u00020\u0005*\u0004\u0018\u00010\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u0014H\f¢\u0006\u0002\b-\u001a \u0010.\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\b¢\u0006\u0002\u0010%\u001a$\u0010.\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\b¢\u0006\u0004\b/\u0010%\u001a\r\u0010.\u001a\u00020\u000f*\u00020\u0006H\b\u001a\u0014\u0010.\u001a\u00020\u000f*\u0004\u0018\u00010\u0006H\b¢\u0006\u0002\b/\u001a\r\u0010.\u001a\u00020\u000f*\u00020\bH\b\u001a\u0014\u0010.\u001a\u00020\u000f*\u0004\u0018\u00010\bH\b¢\u0006\u0002\b/\u001a\r\u0010.\u001a\u00020\u000f*\u00020\nH\b\u001a\u0014\u0010.\u001a\u00020\u000f*\u0004\u0018\u00010\nH\b¢\u0006\u0002\b/\u001a\r\u0010.\u001a\u00020\u000f*\u00020\fH\b\u001a\u0014\u0010.\u001a\u00020\u000f*\u0004\u0018\u00010\fH\b¢\u0006\u0002\b/\u001a\r\u0010.\u001a\u00020\u000f*\u00020\u000eH\b\u001a\u0014\u0010.\u001a\u00020\u000f*\u0004\u0018\u00010\u000eH\b¢\u0006\u0002\b/\u001a\r\u0010.\u001a\u00020\u000f*\u00020\u0010H\b\u001a\u0014\u0010.\u001a\u00020\u000f*\u0004\u0018\u00010\u0010H\b¢\u0006\u0002\b/\u001a\r\u0010.\u001a\u00020\u000f*\u00020\u0012H\b\u001a\u0014\u0010.\u001a\u00020\u000f*\u0004\u0018\u00010\u0012H\b¢\u0006\u0002\b/\u001a\r\u0010.\u001a\u00020\u000f*\u00020\u0014H\b\u001a\u0014\u0010.\u001a\u00020\u000f*\u0004\u0018\u00010\u0014H\b¢\u0006\u0002\b/\u001a \u00100\u001a\u00020(\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\b¢\u0006\u0002\u0010*\u001a$\u00100\u001a\u00020(\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\b¢\u0006\u0004\b1\u0010*\u001a\r\u00100\u001a\u00020(*\u00020\u0006H\b\u001a\u0014\u00100\u001a\u00020(*\u0004\u0018\u00010\u0006H\b¢\u0006\u0002\b1\u001a\r\u00100\u001a\u00020(*\u00020\bH\b\u001a\u0014\u00100\u001a\u00020(*\u0004\u0018\u00010\bH\b¢\u0006\u0002\b1\u001a\r\u00100\u001a\u00020(*\u00020\nH\b\u001a\u0014\u00100\u001a\u00020(*\u0004\u0018\u00010\nH\b¢\u0006\u0002\b1\u001a\r\u00100\u001a\u00020(*\u00020\fH\b\u001a\u0014\u00100\u001a\u00020(*\u0004\u0018\u00010\fH\b¢\u0006\u0002\b1\u001a\r\u00100\u001a\u00020(*\u00020\u000eH\b\u001a\u0014\u00100\u001a\u00020(*\u0004\u0018\u00010\u000eH\b¢\u0006\u0002\b1\u001a\r\u00100\u001a\u00020(*\u00020\u0010H\b\u001a\u0014\u00100\u001a\u00020(*\u0004\u0018\u00010\u0010H\b¢\u0006\u0002\b1\u001a\r\u00100\u001a\u00020(*\u00020\u0012H\b\u001a\u0014\u00100\u001a\u00020(*\u0004\u0018\u00010\u0012H\b¢\u0006\u0002\b1\u001a\r\u00100\u001a\u00020(*\u00020\u0014H\b\u001a\u0014\u00100\u001a\u00020(*\u0004\u0018\u00010\u0014H\b¢\u0006\u0002\b1\u001aQ\u00102\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\f\u00103\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u00104\u001a\u00020\u000f2\b\b\u0002\u00105\u001a\u00020\u000f2\b\b\u0002\u00106\u001a\u00020\u000fH\u0007¢\u0006\u0002\u00107\u001a2\u00102\u001a\u00020\u0006*\u00020\u00062\u0006\u00103\u001a\u00020\u00062\b\b\u0002\u00104\u001a\u00020\u000f2\b\b\u0002\u00105\u001a\u00020\u000f2\b\b\u0002\u00106\u001a\u00020\u000fH\u0007\u001a2\u00102\u001a\u00020\b*\u00020\b2\u0006\u00103\u001a\u00020\b2\b\b\u0002\u00104\u001a\u00020\u000f2\b\b\u0002\u00105\u001a\u00020\u000f2\b\b\u0002\u00106\u001a\u00020\u000fH\u0007\u001a2\u00102\u001a\u00020\n*\u00020\n2\u0006\u00103\u001a\u00020\n2\b\b\u0002\u00104\u001a\u00020\u000f2\b\b\u0002\u00105\u001a\u00020\u000f2\b\b\u0002\u00106\u001a\u00020\u000fH\u0007\u001a2\u00102\u001a\u00020\f*\u00020\f2\u0006\u00103\u001a\u00020\f2\b\b\u0002\u00104\u001a\u00020\u000f2\b\b\u0002\u00105\u001a\u00020\u000f2\b\b\u0002\u00106\u001a\u00020\u000fH\u0007\u001a2\u00102\u001a\u00020\u000e*\u00020\u000e2\u0006\u00103\u001a\u00020\u000e2\b\b\u0002\u00104\u001a\u00020\u000f2\b\b\u0002\u00105\u001a\u00020\u000f2\b\b\u0002\u00106\u001a\u00020\u000fH\u0007\u001a2\u00102\u001a\u00020\u0010*\u00020\u00102\u0006\u00103\u001a\u00020\u00102\b\b\u0002\u00104\u001a\u00020\u000f2\b\b\u0002\u00105\u001a\u00020\u000f2\b\b\u0002\u00106\u001a\u00020\u000fH\u0007\u001a2\u00102\u001a\u00020\u0012*\u00020\u00122\u0006\u00103\u001a\u00020\u00122\b\b\u0002\u00104\u001a\u00020\u000f2\b\b\u0002\u00105\u001a\u00020\u000f2\b\b\u0002\u00106\u001a\u00020\u000fH\u0007\u001a2\u00102\u001a\u00020\u0014*\u00020\u00142\u0006\u00103\u001a\u00020\u00142\b\b\u0002\u00104\u001a\u00020\u000f2\b\b\u0002\u00105\u001a\u00020\u000f2\b\b\u0002\u00106\u001a\u00020\u000fH\u0007\u001a$\u00108\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\b¢\u0006\u0002\u00109\u001a.\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010:\u001a\u00020\u000fH\b¢\u0006\u0002\u0010;\u001a\r\u00108\u001a\u00020\u0006*\u00020\u0006H\b\u001a\u0015\u00108\u001a\u00020\u0006*\u00020\u00062\u0006\u0010:\u001a\u00020\u000fH\b\u001a\r\u00108\u001a\u00020\b*\u00020\bH\b\u001a\u0015\u00108\u001a\u00020\b*\u00020\b2\u0006\u0010:\u001a\u00020\u000fH\b\u001a\r\u00108\u001a\u00020\n*\u00020\nH\b\u001a\u0015\u00108\u001a\u00020\n*\u00020\n2\u0006\u0010:\u001a\u00020\u000fH\b\u001a\r\u00108\u001a\u00020\f*\u00020\fH\b\u001a\u0015\u00108\u001a\u00020\f*\u00020\f2\u0006\u0010:\u001a\u00020\u000fH\b\u001a\r\u00108\u001a\u00020\u000e*\u00020\u000eH\b\u001a\u0015\u00108\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010:\u001a\u00020\u000fH\b\u001a\r\u00108\u001a\u00020\u0010*\u00020\u0010H\b\u001a\u0015\u00108\u001a\u00020\u0010*\u00020\u00102\u0006\u0010:\u001a\u00020\u000fH\b\u001a\r\u00108\u001a\u00020\u0012*\u00020\u0012H\b\u001a\u0015\u00108\u001a\u00020\u0012*\u00020\u00122\u0006\u0010:\u001a\u00020\u000fH\b\u001a\r\u00108\u001a\u00020\u0014*\u00020\u0014H\b\u001a\u0015\u00108\u001a\u00020\u0014*\u00020\u00142\u0006\u0010:\u001a\u00020\u000fH\b\u001a6\u0010<\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\b¢\u0006\u0004\b=\u0010>\u001a\"\u0010<\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\b¢\u0006\u0002\b=\u001a\"\u0010<\u001a\u00020\b*\u00020\b2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\b¢\u0006\u0002\b=\u001a\"\u0010<\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\b¢\u0006\u0002\b=\u001a\"\u0010<\u001a\u00020\f*\u00020\f2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\b¢\u0006\u0002\b=\u001a\"\u0010<\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\b¢\u0006\u0002\b=\u001a\"\u0010<\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\b¢\u0006\u0002\b=\u001a\"\u0010<\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\b¢\u0006\u0002\b=\u001a\"\u0010<\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\b¢\u0006\u0002\b=\u001a5\u0010?\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0004\b<\u0010>\u001a!\u0010?\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b<\u001a!\u0010?\u001a\u00020\b*\u00020\b2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b<\u001a!\u0010?\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b<\u001a!\u0010?\u001a\u00020\f*\u00020\f2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b<\u001a!\u0010?\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b<\u001a!\u0010?\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b<\u001a!\u0010?\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b<\u001a!\u0010?\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b<\u001a(\u0010@\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u0006\u0010A\u001a\u00020\u000fH\b¢\u0006\u0002\u0010B\u001a\u0015\u0010@\u001a\u00020\u0005*\u00020\u00062\u0006\u0010A\u001a\u00020\u000fH\b\u001a\u0015\u0010@\u001a\u00020\u0007*\u00020\b2\u0006\u0010A\u001a\u00020\u000fH\b\u001a\u0015\u0010@\u001a\u00020\t*\u00020\n2\u0006\u0010A\u001a\u00020\u000fH\b\u001a\u0015\u0010@\u001a\u00020\u000b*\u00020\f2\u0006\u0010A\u001a\u00020\u000fH\b\u001a\u0015\u0010@\u001a\u00020\r*\u00020\u000e2\u0006\u0010A\u001a\u00020\u000fH\b\u001a\u0015\u0010@\u001a\u00020\u000f*\u00020\u00102\u0006\u0010A\u001a\u00020\u000fH\b\u001a\u0015\u0010@\u001a\u00020\u0011*\u00020\u00122\u0006\u0010A\u001a\u00020\u000fH\b\u001a\u0015\u0010@\u001a\u00020\u0013*\u00020\u00142\u0006\u0010A\u001a\u00020\u000fH\b\u001a7\u0010C\u001a\u00020D\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0016\u001a\u0002H\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f¢\u0006\u0002\u0010E\u001a&\u0010C\u001a\u00020D*\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010C\u001a\u00020D*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010C\u001a\u00020D*\u00020\n2\u0006\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010C\u001a\u00020D*\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010C\u001a\u00020D*\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010C\u001a\u00020D*\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010C\u001a\u00020D*\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010C\u001a\u00020D*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a-\u0010F\u001a\b\u0012\u0004\u0012\u0002HG0\u0001\"\u0004\b\u0000\u0010G*\u0006\u0012\u0002\b\u00030\u00032\f\u0010H\u001a\b\u0012\u0004\u0012\u0002HG0I¢\u0006\u0002\u0010J\u001aA\u0010K\u001a\u0002HL\"\u0010\b\u0000\u0010L*\n\u0012\u0006\b\u0000\u0012\u0002HG0M\"\u0004\b\u0001\u0010G*\u0006\u0012\u0002\b\u00030\u00032\u0006\u00103\u001a\u0002HL2\f\u0010H\u001a\b\u0012\u0004\u0012\u0002HG0I¢\u0006\u0002\u0010N\u001a,\u0010O\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0016\u001a\u0002H\u0002H\u0002¢\u0006\u0002\u0010P\u001a4\u0010O\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0010Q\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\u0002¢\u0006\u0002\u0010R\u001a2\u0010O\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010Q\u001a\b\u0012\u0004\u0012\u0002H\u00020SH\u0002¢\u0006\u0002\u0010T\u001a\u0015\u0010O\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0005H\u0002\u001a\u0015\u0010O\u001a\u00020\u0006*\u00020\u00062\u0006\u0010Q\u001a\u00020\u0006H\u0002\u001a\u001b\u0010O\u001a\u00020\u0006*\u00020\u00062\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00050SH\u0002\u001a\u0015\u0010O\u001a\u00020\b*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0007H\u0002\u001a\u0015\u0010O\u001a\u00020\b*\u00020\b2\u0006\u0010Q\u001a\u00020\bH\u0002\u001a\u001b\u0010O\u001a\u00020\b*\u00020\b2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00070SH\u0002\u001a\u0015\u0010O\u001a\u00020\n*\u00020\n2\u0006\u0010\u0016\u001a\u00020\tH\u0002\u001a\u0015\u0010O\u001a\u00020\n*\u00020\n2\u0006\u0010Q\u001a\u00020\nH\u0002\u001a\u001b\u0010O\u001a\u00020\n*\u00020\n2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\t0SH\u0002\u001a\u0015\u0010O\u001a\u00020\f*\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000bH\u0002\u001a\u0015\u0010O\u001a\u00020\f*\u00020\f2\u0006\u0010Q\u001a\u00020\fH\u0002\u001a\u001b\u0010O\u001a\u00020\f*\u00020\f2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u000b0SH\u0002\u001a\u0015\u0010O\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\rH\u0002\u001a\u0015\u0010O\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010Q\u001a\u00020\u000eH\u0002\u001a\u001b\u0010O\u001a\u00020\u000e*\u00020\u000e2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\r0SH\u0002\u001a\u0015\u0010O\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000fH\u0002\u001a\u0015\u0010O\u001a\u00020\u0010*\u00020\u00102\u0006\u0010Q\u001a\u00020\u0010H\u0002\u001a\u001b\u0010O\u001a\u00020\u0010*\u00020\u00102\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u000f0SH\u0002\u001a\u0015\u0010O\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0011H\u0002\u001a\u0015\u0010O\u001a\u00020\u0012*\u00020\u00122\u0006\u0010Q\u001a\u00020\u0012H\u0002\u001a\u001b\u0010O\u001a\u00020\u0012*\u00020\u00122\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00110SH\u0002\u001a\u0015\u0010O\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0013H\u0002\u001a\u0015\u0010O\u001a\u00020\u0014*\u00020\u00142\u0006\u0010Q\u001a\u00020\u0014H\u0002\u001a\u001b\u0010O\u001a\u00020\u0014*\u00020\u00142\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00130SH\u0002\u001a,\u0010U\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0016\u001a\u0002H\u0002H\b¢\u0006\u0002\u0010P\u001a\u001d\u0010V\u001a\u00020D\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003¢\u0006\u0002\u0010W\u001a*\u0010V\u001a\u00020D\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020X*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\b¢\u0006\u0002\u0010Y\u001a1\u0010V\u001a\u00020D\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f¢\u0006\u0002\u0010Z\u001a=\u0010V\u001a\u00020D\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020X*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010[\u001a\n\u0010V\u001a\u00020D*\u00020\b\u001a\u001e\u0010V\u001a\u00020D*\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a\n\u0010V\u001a\u00020D*\u00020\n\u001a\u001e\u0010V\u001a\u00020D*\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a\n\u0010V\u001a\u00020D*\u00020\f\u001a\u001e\u0010V\u001a\u00020D*\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a\n\u0010V\u001a\u00020D*\u00020\u000e\u001a\u001e\u0010V\u001a\u00020D*\u00020\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a\n\u0010V\u001a\u00020D*\u00020\u0010\u001a\u001e\u0010V\u001a\u00020D*\u00020\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a\n\u0010V\u001a\u00020D*\u00020\u0012\u001a\u001e\u0010V\u001a\u00020D*\u00020\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a\n\u0010V\u001a\u00020D*\u00020\u0014\u001a\u001e\u0010V\u001a\u00020D*\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a9\u0010\\\u001a\u00020D\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u001a\u0010\u0017\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0018j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0019¢\u0006\u0002\u0010]\u001aM\u0010\\\u001a\u00020D\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u001a\u0010\u0017\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0018j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f¢\u0006\u0002\u0010^\u001a9\u0010_\u001a\u00020`\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020`0bH\bø\u0001\u0000¢\u0006\u0004\bc\u0010d\u001a9\u0010_\u001a\u00020e\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020e0bH\bø\u0001\u0000¢\u0006\u0004\bf\u0010g\u001a)\u0010_\u001a\u00020`*\u00020\u00062\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020`0bH\bø\u0001\u0000¢\u0006\u0002\bc\u001a)\u0010_\u001a\u00020e*\u00020\u00062\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020e0bH\bø\u0001\u0000¢\u0006\u0002\bf\u001a)\u0010_\u001a\u00020`*\u00020\b2\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020`0bH\bø\u0001\u0000¢\u0006\u0002\bc\u001a)\u0010_\u001a\u00020e*\u00020\b2\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020e0bH\bø\u0001\u0000¢\u0006\u0002\bf\u001a)\u0010_\u001a\u00020`*\u00020\n2\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020`0bH\bø\u0001\u0000¢\u0006\u0002\bc\u001a)\u0010_\u001a\u00020e*\u00020\n2\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020e0bH\bø\u0001\u0000¢\u0006\u0002\bf\u001a)\u0010_\u001a\u00020`*\u00020\f2\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020`0bH\bø\u0001\u0000¢\u0006\u0002\bc\u001a)\u0010_\u001a\u00020e*\u00020\f2\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020e0bH\bø\u0001\u0000¢\u0006\u0002\bf\u001a)\u0010_\u001a\u00020`*\u00020\u000e2\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020`0bH\bø\u0001\u0000¢\u0006\u0002\bc\u001a)\u0010_\u001a\u00020e*\u00020\u000e2\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020e0bH\bø\u0001\u0000¢\u0006\u0002\bf\u001a)\u0010_\u001a\u00020`*\u00020\u00102\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020`0bH\bø\u0001\u0000¢\u0006\u0002\bc\u001a)\u0010_\u001a\u00020e*\u00020\u00102\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020e0bH\bø\u0001\u0000¢\u0006\u0002\bf\u001a)\u0010_\u001a\u00020`*\u00020\u00122\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020`0bH\bø\u0001\u0000¢\u0006\u0002\bc\u001a)\u0010_\u001a\u00020e*\u00020\u00122\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020e0bH\bø\u0001\u0000¢\u0006\u0002\bf\u001a)\u0010_\u001a\u00020`*\u00020\u00142\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020`0bH\bø\u0001\u0000¢\u0006\u0002\bc\u001a)\u0010_\u001a\u00020e*\u00020\u00142\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020e0bH\bø\u0001\u0000¢\u0006\u0002\bf\u001a-\u0010h\u001a\b\u0012\u0004\u0012\u0002H\u00020i\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020X*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003¢\u0006\u0002\u0010j\u001a?\u0010h\u001a\b\u0012\u0004\u0012\u0002H\u00020i\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u001a\u0010\u0017\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0018j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0019¢\u0006\u0002\u0010k\u001a\u0010\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00050i*\u00020\u0006\u001a\u0010\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00070i*\u00020\b\u001a\u0010\u0010h\u001a\b\u0012\u0004\u0012\u00020\t0i*\u00020\n\u001a\u0010\u0010h\u001a\b\u0012\u0004\u0012\u00020\u000b0i*\u00020\f\u001a\u0010\u0010h\u001a\b\u0012\u0004\u0012\u00020\r0i*\u00020\u000e\u001a\u0010\u0010h\u001a\b\u0012\u0004\u0012\u00020\u000f0i*\u00020\u0010\u001a\u0010\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00110i*\u00020\u0012\u001a\u0010\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00130i*\u00020\u0014\u001a\u0015\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00050\u0003*\u00020\u0006¢\u0006\u0002\u0010m\u001a\u0015\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003*\u00020\b¢\u0006\u0002\u0010n\u001a\u0015\u0010l\u001a\b\u0012\u0004\u0012\u00020\t0\u0003*\u00020\n¢\u0006\u0002\u0010o\u001a\u0015\u0010l\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003*\u00020\f¢\u0006\u0002\u0010p\u001a\u0015\u0010l\u001a\b\u0012\u0004\u0012\u00020\r0\u0003*\u00020\u000e¢\u0006\u0002\u0010q\u001a\u0015\u0010l\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003*\u00020\u0010¢\u0006\u0002\u0010r\u001a\u0015\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003*\u00020\u0012¢\u0006\u0002\u0010s\u001a\u0015\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003*\u00020\u0014¢\u0006\u0002\u0010t\u0002\u0007\n\u0005\b20\u0001¨\u0006u"}, d2 = {"asList", "", "T", "", "([Ljava/lang/Object;)Ljava/util/List;", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "binarySearch", "element", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "fromIndex", "toIndex", "([Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;II)I", "([Ljava/lang/Object;Ljava/lang/Object;II)I", "contentDeepEquals", "other", "contentDeepEqualsInline", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "contentDeepEqualsNullable", "contentDeepHashCode", "contentDeepHashCodeInline", "([Ljava/lang/Object;)I", "contentDeepHashCodeNullable", "contentDeepToString", "", "contentDeepToStringInline", "([Ljava/lang/Object;)Ljava/lang/String;", "contentDeepToStringNullable", "contentEquals", "contentEqualsNullable", "contentHashCode", "contentHashCodeNullable", "contentToString", "contentToStringNullable", "copyInto", "destination", "destinationOffset", "startIndex", "endIndex", "([Ljava/lang/Object;[Ljava/lang/Object;III)[Ljava/lang/Object;", "copyOf", "([Ljava/lang/Object;)[Ljava/lang/Object;", "newSize", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "copyOfRange", "copyOfRangeInline", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "copyOfRangeImpl", "elementAt", "index", "([Ljava/lang/Object;I)Ljava/lang/Object;", "fill", "", "([Ljava/lang/Object;Ljava/lang/Object;II)V", "filterIsInstance", "R", "klass", "Ljava/lang/Class;", "([Ljava/lang/Object;Ljava/lang/Class;)Ljava/util/List;", "filterIsInstanceTo", "C", "", "([Ljava/lang/Object;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "plus", "([Ljava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;", "elements", "([Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Object;", "", "([Ljava/lang/Object;Ljava/util/Collection;)[Ljava/lang/Object;", "plusElement", "sort", "([Ljava/lang/Object;)V", "", "([Ljava/lang/Comparable;)V", "([Ljava/lang/Object;II)V", "([Ljava/lang/Comparable;II)V", "sortWith", "([Ljava/lang/Object;Ljava/util/Comparator;)V", "([Ljava/lang/Object;Ljava/util/Comparator;II)V", "sumOf", "Ljava/math/BigDecimal;", "selector", "Lkotlin/Function1;", "sumOfBigDecimal", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "sumOfBigInteger", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "toSortedSet", "Ljava/util/SortedSet;", "([Ljava/lang/Comparable;)Ljava/util/SortedSet;", "([Ljava/lang/Object;Ljava/util/Comparator;)Ljava/util/SortedSet;", "toTypedArray", "([Z)[Ljava/lang/Boolean;", "([B)[Ljava/lang/Byte;", "([C)[Ljava/lang/Character;", "([D)[Ljava/lang/Double;", "([F)[Ljava/lang/Float;", "([I)[Ljava/lang/Integer;", "([J)[Ljava/lang/Long;", "([S)[Ljava/lang/Short;", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/collections/ArraysKt")
public class ArraysKt___ArraysJvmKt extends ArraysKt__ArraysKt {
    @NotNull
    public static final <T> List<T> asList(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        List<T> asList = ArraysUtilJVM.asList(tArr);
        Intrinsics.checkNotNullExpressionValue(asList, "asList(this)");
        return asList;
    }

    public static final <T> int binarySearch(@NotNull T[] tArr, T t, @NotNull Comparator<? super T> comparator, int i2, int i3) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return Arrays.binarySearch(tArr, i2, i3, t, comparator);
    }

    public static /* synthetic */ int binarySearch$default(Object[] objArr, Object obj, Comparator comparator, int i2, int i3, int i4, Object obj2) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        return binarySearch(objArr, obj, comparator, i2, i3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    @LowPriorityInOverloadResolution
    @JvmName(name = "contentDeepEqualsInline")
    public static final <T> boolean contentDeepEqualsInline(T[] tArr, T[] tArr2) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(tArr2, "other");
        return ArraysKt__ArraysKt.contentDeepEquals(tArr, tArr2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentDeepEqualsNullable")
    public static final <T> boolean contentDeepEqualsNullable(T[] tArr, T[] tArr2) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return ArraysKt__ArraysKt.contentDeepEquals(tArr, tArr2);
        }
        return Arrays.deepEquals(tArr, tArr2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    @LowPriorityInOverloadResolution
    @JvmName(name = "contentDeepHashCodeInline")
    public static final <T> int contentDeepHashCodeInline(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return ArraysKt__ArraysJVMKt.contentDeepHashCode(tArr);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentDeepHashCodeNullable")
    public static final <T> int contentDeepHashCodeNullable(T[] tArr) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return ArraysKt__ArraysJVMKt.contentDeepHashCode(tArr);
        }
        return Arrays.deepHashCode(tArr);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    @LowPriorityInOverloadResolution
    @JvmName(name = "contentDeepToStringInline")
    public static final <T> String contentDeepToStringInline(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return ArraysKt__ArraysKt.contentDeepToString(tArr);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentDeepToStringNullable")
    public static final <T> String contentDeepToStringNullable(T[] tArr) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return ArraysKt__ArraysKt.contentDeepToString(tArr);
        }
        String deepToString = Arrays.deepToString(tArr);
        Intrinsics.checkNotNullExpressionValue(deepToString, "deepToString(this)");
        return deepToString;
    }

    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @InlineOnly
    public static final /* synthetic */ <T> boolean contentEquals(T[] tArr, T[] tArr2) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(tArr2, "other");
        return Arrays.equals(tArr, tArr2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentEqualsNullable")
    public static final <T> boolean contentEqualsNullable(T[] tArr, T[] tArr2) {
        return Arrays.equals(tArr, tArr2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentHashCodeNullable")
    public static final <T> int contentHashCodeNullable(T[] tArr) {
        return Arrays.hashCode(tArr);
    }

    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @InlineOnly
    public static final /* synthetic */ <T> String contentToString(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        String arrays = Arrays.toString(tArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        return arrays;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentToStringNullable")
    public static final <T> String contentToStringNullable(T[] tArr) {
        String arrays = Arrays.toString(tArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        return arrays;
    }

    @NotNull
    @SinceKotlin(version = "1.3")
    public static final <T> T[] copyInto(@NotNull T[] tArr, @NotNull T[] tArr2, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(tArr2, "destination");
        System.arraycopy(tArr, i3, tArr2, i2, i4 - i3);
        return tArr2;
    }

    public static /* synthetic */ Object[] copyInto$default(Object[] objArr, Object[] objArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = objArr.length;
        }
        return copyInto((T[]) objArr, (T[]) objArr2, i2, i3, i4);
    }

    @InlineOnly
    public static final <T> T[] copyOf(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        T[] copyOf = Arrays.copyOf(tArr, tArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    @JvmName(name = "copyOfRange")
    public static final <T> T[] copyOfRange(@NotNull T[] tArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i3, tArr.length);
        T[] copyOfRange = Arrays.copyOfRange(tArr, i2, i3);
        Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    public static final <T> T[] copyOfRangeInline(T[] tArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(tArr, i2, i3);
        }
        if (i3 <= tArr.length) {
            T[] copyOfRange = Arrays.copyOfRange(tArr, i2, i3);
            Intrinsics.checkNotNullExpressionValue(copyOfRange, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + tArr.length);
    }

    @InlineOnly
    public static final <T> T elementAt(T[] tArr, int i2) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr[i2];
    }

    public static final <T> void fill(@NotNull T[] tArr, T t, int i2, int i3) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Arrays.fill(tArr, i2, i3, t);
    }

    public static /* synthetic */ void fill$default(Object[] objArr, Object obj, int i2, int i3, int i4, Object obj2) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = objArr.length;
        }
        fill((T[]) objArr, obj, i2, i3);
    }

    @NotNull
    public static final <R> List<R> filterIsInstance(@NotNull Object[] objArr, @NotNull Class<R> cls) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Intrinsics.checkNotNullParameter(cls, "klass");
        return (List) filterIsInstanceTo(objArr, new ArrayList(), cls);
    }

    @NotNull
    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(@NotNull Object[] objArr, @NotNull C c, @NotNull Class<R> cls) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(cls, "klass");
        for (Object obj : objArr) {
            if (cls.isInstance(obj)) {
                c.add(obj);
            }
        }
        return c;
    }

    @NotNull
    public static final <T> T[] plus(@NotNull T[] tArr, T t) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int length = tArr.length;
        T[] copyOf = Arrays.copyOf(tArr, length + 1);
        copyOf[length] = t;
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @InlineOnly
    public static final <T> T[] plusElement(T[] tArr, T t) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return plus(tArr, t);
    }

    public static final void sort(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length > 1) {
            Arrays.sort(iArr);
        }
    }

    public static /* synthetic */ void sort$default(Comparable[] comparableArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = comparableArr.length;
        }
        sort((T[]) comparableArr, i2, i3);
    }

    public static final <T> void sortWith(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }

    public static /* synthetic */ void sortWith$default(Object[] objArr, Comparator comparator, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = objArr.length;
        }
        sortWith(objArr, comparator, i2, i3);
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    public static final <T> BigDecimal sumOfBigDecimal(T[] tArr, Function1<? super T, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        for (T invoke : tArr) {
            valueOf = valueOf.add((BigDecimal) function1.invoke(invoke));
            Intrinsics.checkNotNullExpressionValue(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    public static final <T> BigInteger sumOfBigInteger(T[] tArr, Function1<? super T, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigInteger valueOf = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        for (T invoke : tArr) {
            valueOf = valueOf.add((BigInteger) function1.invoke(invoke));
            Intrinsics.checkNotNullExpressionValue(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(tArr, new TreeSet());
    }

    @NotNull
    public static final Byte[] toTypedArray(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Byte[] bArr2 = new Byte[bArr.length];
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            bArr2[i2] = Byte.valueOf(bArr[i2]);
        }
        return bArr2;
    }

    @NotNull
    public static final List<Byte> asList(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return new ArraysKt___ArraysJvmKt$asList$1(bArr);
    }

    public static final <T> int binarySearch(@NotNull T[] tArr, T t, int i2, int i3) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return Arrays.binarySearch(tArr, i2, i3, t);
    }

    public static /* synthetic */ int binarySearch$default(Object[] objArr, Object obj, int i2, int i3, int i4, Object obj2) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = objArr.length;
        }
        return binarySearch((T[]) objArr, obj, i2, i3);
    }

    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @InlineOnly
    public static final /* synthetic */ boolean contentEquals(byte[] bArr, byte[] bArr2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(bArr2, "other");
        return Arrays.equals(bArr, bArr2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentEqualsNullable")
    public static final boolean contentEqualsNullable(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentHashCodeNullable")
    public static final int contentHashCodeNullable(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @InlineOnly
    public static final /* synthetic */ String contentToString(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        String arrays = Arrays.toString(bArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        return arrays;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentToStringNullable")
    public static final String contentToStringNullable(byte[] bArr) {
        String arrays = Arrays.toString(bArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        return arrays;
    }

    @NotNull
    @SinceKotlin(version = "1.3")
    public static final byte[] copyInto(@NotNull byte[] bArr, @NotNull byte[] bArr2, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(bArr2, "destination");
        System.arraycopy(bArr, i3, bArr2, i2, i4 - i3);
        return bArr2;
    }

    public static /* synthetic */ byte[] copyInto$default(byte[] bArr, byte[] bArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = bArr.length;
        }
        return copyInto(bArr, bArr2, i2, i3, i4);
    }

    @InlineOnly
    public static final byte[] copyOf(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    @InlineOnly
    public static final byte elementAt(byte[] bArr, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return bArr[i2];
    }

    public static final void fill(@NotNull byte[] bArr, byte b, int i2, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Arrays.fill(bArr, i2, i3, b);
    }

    public static /* synthetic */ void fill$default(byte[] bArr, byte b, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = bArr.length;
        }
        fill(bArr, b, i2, i3);
    }

    public static final void sort(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length > 1) {
            Arrays.sort(jArr);
        }
    }

    public static /* synthetic */ void sort$default(byte[] bArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = bArr.length;
        }
        sort(bArr, i2, i3);
    }

    public static final <T> void sortWith(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator, int i2, int i3) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Arrays.sort(tArr, i2, i3, comparator);
    }

    @NotNull
    public static final SortedSet<Byte> toSortedSet(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(bArr, new TreeSet());
    }

    @NotNull
    public static final List<Short> asList(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return new ArraysKt___ArraysJvmKt$asList$2(sArr);
    }

    public static final int binarySearch(@NotNull byte[] bArr, byte b, int i2, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return Arrays.binarySearch(bArr, i2, i3, b);
    }

    public static /* synthetic */ int binarySearch$default(byte[] bArr, byte b, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = bArr.length;
        }
        return binarySearch(bArr, b, i2, i3);
    }

    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @InlineOnly
    public static final /* synthetic */ boolean contentEquals(short[] sArr, short[] sArr2) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(sArr2, "other");
        return Arrays.equals(sArr, sArr2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentEqualsNullable")
    public static final boolean contentEqualsNullable(short[] sArr, short[] sArr2) {
        return Arrays.equals(sArr, sArr2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentHashCodeNullable")
    public static final int contentHashCodeNullable(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @InlineOnly
    public static final /* synthetic */ String contentToString(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        String arrays = Arrays.toString(sArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        return arrays;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentToStringNullable")
    public static final String contentToStringNullable(short[] sArr) {
        String arrays = Arrays.toString(sArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        return arrays;
    }

    @NotNull
    @SinceKotlin(version = "1.3")
    public static final short[] copyInto(@NotNull short[] sArr, @NotNull short[] sArr2, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(sArr2, "destination");
        System.arraycopy(sArr, i3, sArr2, i2, i4 - i3);
        return sArr2;
    }

    public static /* synthetic */ short[] copyInto$default(short[] sArr, short[] sArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = sArr.length;
        }
        return copyInto(sArr, sArr2, i2, i3, i4);
    }

    @InlineOnly
    public static final short[] copyOf(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    @JvmName(name = "copyOfRange")
    public static final byte[] copyOfRange(@NotNull byte[] bArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i3, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i2, i3);
        Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @InlineOnly
    public static final short elementAt(short[] sArr, int i2) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return sArr[i2];
    }

    public static final void fill(@NotNull short[] sArr, short s, int i2, int i3) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Arrays.fill(sArr, i2, i3, s);
    }

    public static /* synthetic */ void fill$default(short[] sArr, short s, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = sArr.length;
        }
        fill(sArr, s, i2, i3);
    }

    public static final void sort(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length > 1) {
            Arrays.sort(bArr);
        }
    }

    public static /* synthetic */ void sort$default(short[] sArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = sArr.length;
        }
        sort(sArr, i2, i3);
    }

    @NotNull
    public static final SortedSet<Short> toSortedSet(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(sArr, new TreeSet());
    }

    @NotNull
    public static final List<Integer> asList(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return new ArraysKt___ArraysJvmKt$asList$3(iArr);
    }

    public static final int binarySearch(@NotNull short[] sArr, short s, int i2, int i3) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return Arrays.binarySearch(sArr, i2, i3, s);
    }

    public static /* synthetic */ int binarySearch$default(short[] sArr, short s, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = sArr.length;
        }
        return binarySearch(sArr, s, i2, i3);
    }

    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @InlineOnly
    public static final /* synthetic */ boolean contentEquals(int[] iArr, int[] iArr2) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(iArr2, "other");
        return Arrays.equals(iArr, iArr2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentEqualsNullable")
    public static final boolean contentEqualsNullable(int[] iArr, int[] iArr2) {
        return Arrays.equals(iArr, iArr2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentHashCodeNullable")
    public static final int contentHashCodeNullable(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @InlineOnly
    public static final /* synthetic */ String contentToString(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        String arrays = Arrays.toString(iArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        return arrays;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentToStringNullable")
    public static final String contentToStringNullable(int[] iArr) {
        String arrays = Arrays.toString(iArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        return arrays;
    }

    @NotNull
    @SinceKotlin(version = "1.3")
    public static final int[] copyInto(@NotNull int[] iArr, @NotNull int[] iArr2, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(iArr2, "destination");
        System.arraycopy(iArr, i3, iArr2, i2, i4 - i3);
        return iArr2;
    }

    public static /* synthetic */ int[] copyInto$default(int[] iArr, int[] iArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = iArr.length;
        }
        return copyInto(iArr, iArr2, i2, i3, i4);
    }

    @InlineOnly
    public static final int[] copyOf(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    @InlineOnly
    public static final int elementAt(int[] iArr, int i2) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return iArr[i2];
    }

    public static final void fill(@NotNull int[] iArr, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Arrays.fill(iArr, i3, i4, i2);
    }

    public static /* synthetic */ void fill$default(int[] iArr, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = iArr.length;
        }
        fill(iArr, i2, i3, i4);
    }

    public static final void sort(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length > 1) {
            Arrays.sort(sArr);
        }
    }

    public static /* synthetic */ void sort$default(int[] iArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = iArr.length;
        }
        sort(iArr, i2, i3);
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    public static final BigDecimal sumOfBigDecimal(byte[] bArr, Function1<? super Byte, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        for (byte valueOf2 : bArr) {
            valueOf = valueOf.add((BigDecimal) function1.invoke(Byte.valueOf(valueOf2)));
            Intrinsics.checkNotNullExpressionValue(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    public static final BigInteger sumOfBigInteger(byte[] bArr, Function1<? super Byte, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigInteger valueOf = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        for (byte valueOf2 : bArr) {
            valueOf = valueOf.add((BigInteger) function1.invoke(Byte.valueOf(valueOf2)));
            Intrinsics.checkNotNullExpressionValue(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @NotNull
    public static final SortedSet<Integer> toSortedSet(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(iArr, new TreeSet());
    }

    @NotNull
    public static final Short[] toTypedArray(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Short[] shArr = new Short[sArr.length];
        int length = sArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            shArr[i2] = Short.valueOf(sArr[i2]);
        }
        return shArr;
    }

    @NotNull
    public static final List<Long> asList(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return new ArraysKt___ArraysJvmKt$asList$4(jArr);
    }

    public static final int binarySearch(@NotNull int[] iArr, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return Arrays.binarySearch(iArr, i3, i4, i2);
    }

    public static /* synthetic */ int binarySearch$default(int[] iArr, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = iArr.length;
        }
        return binarySearch(iArr, i2, i3, i4);
    }

    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @InlineOnly
    public static final /* synthetic */ boolean contentEquals(long[] jArr, long[] jArr2) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(jArr2, "other");
        return Arrays.equals(jArr, jArr2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentEqualsNullable")
    public static final boolean contentEqualsNullable(long[] jArr, long[] jArr2) {
        return Arrays.equals(jArr, jArr2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentHashCodeNullable")
    public static final int contentHashCodeNullable(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @InlineOnly
    public static final /* synthetic */ String contentToString(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        String arrays = Arrays.toString(jArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        return arrays;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentToStringNullable")
    public static final String contentToStringNullable(long[] jArr) {
        String arrays = Arrays.toString(jArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        return arrays;
    }

    @NotNull
    @SinceKotlin(version = "1.3")
    public static final long[] copyInto(@NotNull long[] jArr, @NotNull long[] jArr2, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(jArr2, "destination");
        System.arraycopy(jArr, i3, jArr2, i2, i4 - i3);
        return jArr2;
    }

    public static /* synthetic */ long[] copyInto$default(long[] jArr, long[] jArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = jArr.length;
        }
        return copyInto(jArr, jArr2, i2, i3, i4);
    }

    @InlineOnly
    public static final long[] copyOf(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    @JvmName(name = "copyOfRange")
    public static final short[] copyOfRange(@NotNull short[] sArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i3, sArr.length);
        short[] copyOfRange = Arrays.copyOfRange(sArr, i2, i3);
        Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @InlineOnly
    public static final long elementAt(long[] jArr, int i2) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return jArr[i2];
    }

    public static final void fill(@NotNull long[] jArr, long j, int i2, int i3) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Arrays.fill(jArr, i2, i3, j);
    }

    public static /* synthetic */ void fill$default(long[] jArr, long j, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = jArr.length;
        }
        fill(jArr, j, i2, i3);
    }

    @NotNull
    public static final byte[] plus(@NotNull byte[] bArr, byte b) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length;
        byte[] copyOf = Arrays.copyOf(bArr, length + 1);
        copyOf[length] = b;
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    public static final void sort(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length > 1) {
            Arrays.sort(dArr);
        }
    }

    public static /* synthetic */ void sort$default(long[] jArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = jArr.length;
        }
        sort(jArr, i2, i3);
    }

    @NotNull
    public static final SortedSet<Long> toSortedSet(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(jArr, new TreeSet());
    }

    @NotNull
    public static final List<Float> asList(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return new ArraysKt___ArraysJvmKt$asList$5(fArr);
    }

    public static final int binarySearch(@NotNull long[] jArr, long j, int i2, int i3) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return Arrays.binarySearch(jArr, i2, i3, j);
    }

    public static /* synthetic */ int binarySearch$default(long[] jArr, long j, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = jArr.length;
        }
        return binarySearch(jArr, j, i2, i3);
    }

    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @InlineOnly
    public static final /* synthetic */ boolean contentEquals(float[] fArr, float[] fArr2) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(fArr2, "other");
        return Arrays.equals(fArr, fArr2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentEqualsNullable")
    public static final boolean contentEqualsNullable(float[] fArr, float[] fArr2) {
        return Arrays.equals(fArr, fArr2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentHashCodeNullable")
    public static final int contentHashCodeNullable(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @InlineOnly
    public static final /* synthetic */ String contentToString(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        String arrays = Arrays.toString(fArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        return arrays;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentToStringNullable")
    public static final String contentToStringNullable(float[] fArr) {
        String arrays = Arrays.toString(fArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        return arrays;
    }

    @NotNull
    @SinceKotlin(version = "1.3")
    public static final float[] copyInto(@NotNull float[] fArr, @NotNull float[] fArr2, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(fArr2, "destination");
        System.arraycopy(fArr, i3, fArr2, i2, i4 - i3);
        return fArr2;
    }

    public static /* synthetic */ float[] copyInto$default(float[] fArr, float[] fArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = fArr.length;
        }
        return copyInto(fArr, fArr2, i2, i3, i4);
    }

    @InlineOnly
    public static final float[] copyOf(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    @InlineOnly
    public static final float elementAt(float[] fArr, int i2) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return fArr[i2];
    }

    public static final void fill(@NotNull float[] fArr, float f, int i2, int i3) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Arrays.fill(fArr, i2, i3, f);
    }

    public static /* synthetic */ void fill$default(float[] fArr, float f, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = fArr.length;
        }
        fill(fArr, f, i2, i3);
    }

    public static final void sort(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length > 1) {
            Arrays.sort(fArr);
        }
    }

    public static /* synthetic */ void sort$default(float[] fArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = fArr.length;
        }
        sort(fArr, i2, i3);
    }

    @NotNull
    public static final SortedSet<Float> toSortedSet(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(fArr, new TreeSet());
    }

    @NotNull
    public static final List<Double> asList(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return new ArraysKt___ArraysJvmKt$asList$6(dArr);
    }

    public static final int binarySearch(@NotNull float[] fArr, float f, int i2, int i3) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return Arrays.binarySearch(fArr, i2, i3, f);
    }

    public static /* synthetic */ int binarySearch$default(float[] fArr, float f, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = fArr.length;
        }
        return binarySearch(fArr, f, i2, i3);
    }

    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @InlineOnly
    public static final /* synthetic */ boolean contentEquals(double[] dArr, double[] dArr2) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(dArr2, "other");
        return Arrays.equals(dArr, dArr2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentEqualsNullable")
    public static final boolean contentEqualsNullable(double[] dArr, double[] dArr2) {
        return Arrays.equals(dArr, dArr2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentHashCodeNullable")
    public static final int contentHashCodeNullable(double[] dArr) {
        return Arrays.hashCode(dArr);
    }

    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @InlineOnly
    public static final /* synthetic */ String contentToString(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        String arrays = Arrays.toString(dArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        return arrays;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentToStringNullable")
    public static final String contentToStringNullable(double[] dArr) {
        String arrays = Arrays.toString(dArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        return arrays;
    }

    @NotNull
    @SinceKotlin(version = "1.3")
    public static final double[] copyInto(@NotNull double[] dArr, @NotNull double[] dArr2, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(dArr2, "destination");
        System.arraycopy(dArr, i3, dArr2, i2, i4 - i3);
        return dArr2;
    }

    public static /* synthetic */ double[] copyInto$default(double[] dArr, double[] dArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = dArr.length;
        }
        return copyInto(dArr, dArr2, i2, i3, i4);
    }

    @InlineOnly
    public static final double[] copyOf(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        double[] copyOf = Arrays.copyOf(dArr, dArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    @JvmName(name = "copyOfRange")
    public static final int[] copyOfRange(@NotNull int[] iArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i3, iArr.length);
        int[] copyOfRange = Arrays.copyOfRange(iArr, i2, i3);
        Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    public static final byte[] copyOfRangeInline(byte[] bArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(bArr, i2, i3);
        }
        if (i3 <= bArr.length) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, i2, i3);
            Intrinsics.checkNotNullExpressionValue(copyOfRange, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + bArr.length);
    }

    @InlineOnly
    public static final double elementAt(double[] dArr, int i2) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return dArr[i2];
    }

    public static final void fill(@NotNull double[] dArr, double d, int i2, int i3) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Arrays.fill(dArr, i2, i3, d);
    }

    public static /* synthetic */ void fill$default(double[] dArr, double d, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = dArr.length;
        }
        fill(dArr, d, i2, i3);
    }

    public static final void sort(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length > 1) {
            Arrays.sort(cArr);
        }
    }

    public static /* synthetic */ void sort$default(double[] dArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = dArr.length;
        }
        sort(dArr, i2, i3);
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    public static final BigDecimal sumOfBigDecimal(short[] sArr, Function1<? super Short, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        for (short valueOf2 : sArr) {
            valueOf = valueOf.add((BigDecimal) function1.invoke(Short.valueOf(valueOf2)));
            Intrinsics.checkNotNullExpressionValue(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    public static final BigInteger sumOfBigInteger(short[] sArr, Function1<? super Short, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigInteger valueOf = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        for (short valueOf2 : sArr) {
            valueOf = valueOf.add((BigInteger) function1.invoke(Short.valueOf(valueOf2)));
            Intrinsics.checkNotNullExpressionValue(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @NotNull
    public static final SortedSet<Double> toSortedSet(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(dArr, new TreeSet());
    }

    @NotNull
    public static final Integer[] toTypedArray(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Integer[] numArr = new Integer[iArr.length];
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            numArr[i2] = Integer.valueOf(iArr[i2]);
        }
        return numArr;
    }

    @NotNull
    public static final List<Boolean> asList(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return new ArraysKt___ArraysJvmKt$asList$7(zArr);
    }

    public static final int binarySearch(@NotNull double[] dArr, double d, int i2, int i3) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return Arrays.binarySearch(dArr, i2, i3, d);
    }

    public static /* synthetic */ int binarySearch$default(double[] dArr, double d, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = dArr.length;
        }
        return binarySearch(dArr, d, i2, i3);
    }

    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @InlineOnly
    public static final /* synthetic */ boolean contentEquals(boolean[] zArr, boolean[] zArr2) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(zArr2, "other");
        return Arrays.equals(zArr, zArr2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentEqualsNullable")
    public static final boolean contentEqualsNullable(boolean[] zArr, boolean[] zArr2) {
        return Arrays.equals(zArr, zArr2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentHashCodeNullable")
    public static final int contentHashCodeNullable(boolean[] zArr) {
        return Arrays.hashCode(zArr);
    }

    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @InlineOnly
    public static final /* synthetic */ String contentToString(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        String arrays = Arrays.toString(zArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        return arrays;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentToStringNullable")
    public static final String contentToStringNullable(boolean[] zArr) {
        String arrays = Arrays.toString(zArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        return arrays;
    }

    @NotNull
    @SinceKotlin(version = "1.3")
    public static final boolean[] copyInto(@NotNull boolean[] zArr, @NotNull boolean[] zArr2, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(zArr2, "destination");
        System.arraycopy(zArr, i3, zArr2, i2, i4 - i3);
        return zArr2;
    }

    public static /* synthetic */ boolean[] copyInto$default(boolean[] zArr, boolean[] zArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = zArr.length;
        }
        return copyInto(zArr, zArr2, i2, i3, i4);
    }

    @InlineOnly
    public static final boolean[] copyOf(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        boolean[] copyOf = Arrays.copyOf(zArr, zArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    @InlineOnly
    public static final boolean elementAt(boolean[] zArr, int i2) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr[i2];
    }

    public static final void fill(@NotNull boolean[] zArr, boolean z, int i2, int i3) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Arrays.fill(zArr, i2, i3, z);
    }

    public static /* synthetic */ void fill$default(boolean[] zArr, boolean z, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = zArr.length;
        }
        fill(zArr, z, i2, i3);
    }

    @InlineOnly
    public static final <T extends Comparable<? super T>> void sort(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        sort(tArr);
    }

    public static /* synthetic */ void sort$default(char[] cArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = cArr.length;
        }
        sort(cArr, i2, i3);
    }

    @NotNull
    public static final SortedSet<Boolean> toSortedSet(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(zArr, new TreeSet());
    }

    @NotNull
    public static final List<Character> asList(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return new ArraysKt___ArraysJvmKt$asList$8(cArr);
    }

    public static final int binarySearch(@NotNull char[] cArr, char c, int i2, int i3) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return Arrays.binarySearch(cArr, i2, i3, c);
    }

    public static /* synthetic */ int binarySearch$default(char[] cArr, char c, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = cArr.length;
        }
        return binarySearch(cArr, c, i2, i3);
    }

    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @InlineOnly
    public static final /* synthetic */ boolean contentEquals(char[] cArr, char[] cArr2) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(cArr2, "other");
        return Arrays.equals(cArr, cArr2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentEqualsNullable")
    public static final boolean contentEqualsNullable(char[] cArr, char[] cArr2) {
        return Arrays.equals(cArr, cArr2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentHashCodeNullable")
    public static final int contentHashCodeNullable(char[] cArr) {
        return Arrays.hashCode(cArr);
    }

    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @InlineOnly
    public static final /* synthetic */ String contentToString(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        String arrays = Arrays.toString(cArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        return arrays;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentToStringNullable")
    public static final String contentToStringNullable(char[] cArr) {
        String arrays = Arrays.toString(cArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        return arrays;
    }

    @NotNull
    @SinceKotlin(version = "1.3")
    public static final char[] copyInto(@NotNull char[] cArr, @NotNull char[] cArr2, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(cArr2, "destination");
        System.arraycopy(cArr, i3, cArr2, i2, i4 - i3);
        return cArr2;
    }

    public static /* synthetic */ char[] copyInto$default(char[] cArr, char[] cArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = cArr.length;
        }
        return copyInto(cArr, cArr2, i2, i3, i4);
    }

    @InlineOnly
    public static final char[] copyOf(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        char[] copyOf = Arrays.copyOf(cArr, cArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    @JvmName(name = "copyOfRange")
    public static final long[] copyOfRange(@NotNull long[] jArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i3, jArr.length);
        long[] copyOfRange = Arrays.copyOfRange(jArr, i2, i3);
        Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @InlineOnly
    public static final char elementAt(char[] cArr, int i2) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return cArr[i2];
    }

    public static final void fill(@NotNull char[] cArr, char c, int i2, int i3) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Arrays.fill(cArr, i2, i3, c);
    }

    public static /* synthetic */ void fill$default(char[] cArr, char c, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = cArr.length;
        }
        fill(cArr, c, i2, i3);
    }

    @NotNull
    public static final short[] plus(@NotNull short[] sArr, short s) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        int length = sArr.length;
        short[] copyOf = Arrays.copyOf(sArr, length + 1);
        copyOf[length] = s;
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    public static final <T> void sort(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }

    public static /* synthetic */ void sort$default(Object[] objArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = objArr.length;
        }
        sort((T[]) objArr, i2, i3);
    }

    @NotNull
    public static final SortedSet<Character> toSortedSet(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(cArr, new TreeSet());
    }

    @InlineOnly
    public static final byte[] copyOf(byte[] bArr, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        byte[] copyOf = Arrays.copyOf(bArr, i2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }

    @SinceKotlin(version = "1.4")
    public static final <T extends Comparable<? super T>> void sort(@NotNull T[] tArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Arrays.sort(tArr, i2, i3);
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    public static final BigDecimal sumOfBigDecimal(int[] iArr, Function1<? super Integer, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        for (int valueOf2 : iArr) {
            valueOf = valueOf.add((BigDecimal) function1.invoke(Integer.valueOf(valueOf2)));
            Intrinsics.checkNotNullExpressionValue(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    public static final BigInteger sumOfBigInteger(int[] iArr, Function1<? super Integer, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigInteger valueOf = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        for (int valueOf2 : iArr) {
            valueOf = valueOf.add((BigInteger) function1.invoke(Integer.valueOf(valueOf2)));
            Intrinsics.checkNotNullExpressionValue(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @NotNull
    public static final <T> SortedSet<T> toSortedSet(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(tArr, new TreeSet(comparator));
    }

    @NotNull
    public static final Long[] toTypedArray(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Long[] lArr = new Long[jArr.length];
        int length = jArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            lArr[i2] = Long.valueOf(jArr[i2]);
        }
        return lArr;
    }

    @InlineOnly
    public static final short[] copyOf(short[] sArr, int i2) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        short[] copyOf = Arrays.copyOf(sArr, i2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    @JvmName(name = "copyOfRange")
    public static final float[] copyOfRange(@NotNull float[] fArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i3, fArr.length);
        float[] copyOfRange = Arrays.copyOfRange(fArr, i2, i3);
        Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return copyOfRange;
    }

    public static final void sort(@NotNull byte[] bArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Arrays.sort(bArr, i2, i3);
    }

    @InlineOnly
    public static final int[] copyOf(int[] iArr, int i2) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int[] copyOf = Arrays.copyOf(iArr, i2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }

    public static final void sort(@NotNull short[] sArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Arrays.sort(sArr, i2, i3);
    }

    @InlineOnly
    public static final long[] copyOf(long[] jArr, int i2) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        long[] copyOf = Arrays.copyOf(jArr, i2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    @JvmName(name = "copyOfRange")
    public static final double[] copyOfRange(@NotNull double[] dArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i3, dArr.length);
        double[] copyOfRange = Arrays.copyOfRange(dArr, i2, i3);
        Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    public static final short[] copyOfRangeInline(short[] sArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(sArr, i2, i3);
        }
        if (i3 <= sArr.length) {
            short[] copyOfRange = Arrays.copyOfRange(sArr, i2, i3);
            Intrinsics.checkNotNullExpressionValue(copyOfRange, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + sArr.length);
    }

    @NotNull
    public static final int[] plus(@NotNull int[] iArr, int i2) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, length + 1);
        copyOf[length] = i2;
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    public static final void sort(@NotNull int[] iArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Arrays.sort(iArr, i2, i3);
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    public static final BigDecimal sumOfBigDecimal(long[] jArr, Function1<? super Long, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        for (long valueOf2 : jArr) {
            valueOf = valueOf.add((BigDecimal) function1.invoke(Long.valueOf(valueOf2)));
            Intrinsics.checkNotNullExpressionValue(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    public static final BigInteger sumOfBigInteger(long[] jArr, Function1<? super Long, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigInteger valueOf = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        for (long valueOf2 : jArr) {
            valueOf = valueOf.add((BigInteger) function1.invoke(Long.valueOf(valueOf2)));
            Intrinsics.checkNotNullExpressionValue(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @NotNull
    public static final Float[] toTypedArray(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Float[] fArr2 = new Float[fArr.length];
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            fArr2[i2] = Float.valueOf(fArr[i2]);
        }
        return fArr2;
    }

    @InlineOnly
    public static final float[] copyOf(float[] fArr, int i2) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        float[] copyOf = Arrays.copyOf(fArr, i2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }

    public static final void sort(@NotNull long[] jArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Arrays.sort(jArr, i2, i3);
    }

    @InlineOnly
    public static final double[] copyOf(double[] dArr, int i2) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        double[] copyOf = Arrays.copyOf(dArr, i2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    @JvmName(name = "copyOfRange")
    public static final boolean[] copyOfRange(@NotNull boolean[] zArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i3, zArr.length);
        boolean[] copyOfRange = Arrays.copyOfRange(zArr, i2, i3);
        Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return copyOfRange;
    }

    public static final void sort(@NotNull float[] fArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Arrays.sort(fArr, i2, i3);
    }

    @InlineOnly
    public static final boolean[] copyOf(boolean[] zArr, int i2) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        boolean[] copyOf = Arrays.copyOf(zArr, i2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }

    public static final void sort(@NotNull double[] dArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Arrays.sort(dArr, i2, i3);
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    public static final BigDecimal sumOfBigDecimal(float[] fArr, Function1<? super Float, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        for (float valueOf2 : fArr) {
            valueOf = valueOf.add((BigDecimal) function1.invoke(Float.valueOf(valueOf2)));
            Intrinsics.checkNotNullExpressionValue(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    public static final BigInteger sumOfBigInteger(float[] fArr, Function1<? super Float, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigInteger valueOf = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        for (float valueOf2 : fArr) {
            valueOf = valueOf.add((BigInteger) function1.invoke(Float.valueOf(valueOf2)));
            Intrinsics.checkNotNullExpressionValue(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @NotNull
    public static final Double[] toTypedArray(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Double[] dArr2 = new Double[dArr.length];
        int length = dArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            dArr2[i2] = Double.valueOf(dArr[i2]);
        }
        return dArr2;
    }

    @InlineOnly
    public static final char[] copyOf(char[] cArr, int i2) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        char[] copyOf = Arrays.copyOf(cArr, i2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    @JvmName(name = "copyOfRange")
    public static final char[] copyOfRange(@NotNull char[] cArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i3, cArr.length);
        char[] copyOfRange = Arrays.copyOfRange(cArr, i2, i3);
        Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @NotNull
    public static final long[] plus(@NotNull long[] jArr, long j) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, length + 1);
        copyOf[length] = j;
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    public static final void sort(@NotNull char[] cArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Arrays.sort(cArr, i2, i3);
    }

    @InlineOnly
    public static final <T> T[] copyOf(T[] tArr, int i2) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        T[] copyOf = Arrays.copyOf(tArr, i2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }

    public static final <T> void sort(@NotNull T[] tArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Arrays.sort(tArr, i2, i3);
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    public static final int[] copyOfRangeInline(int[] iArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(iArr, i2, i3);
        }
        if (i3 <= iArr.length) {
            int[] copyOfRange = Arrays.copyOfRange(iArr, i2, i3);
            Intrinsics.checkNotNullExpressionValue(copyOfRange, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + iArr.length);
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    public static final BigDecimal sumOfBigDecimal(double[] dArr, Function1<? super Double, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        for (double valueOf2 : dArr) {
            valueOf = valueOf.add((BigDecimal) function1.invoke(Double.valueOf(valueOf2)));
            Intrinsics.checkNotNullExpressionValue(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    public static final BigInteger sumOfBigInteger(double[] dArr, Function1<? super Double, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigInteger valueOf = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        for (double valueOf2 : dArr) {
            valueOf = valueOf.add((BigInteger) function1.invoke(Double.valueOf(valueOf2)));
            Intrinsics.checkNotNullExpressionValue(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @NotNull
    public static final Boolean[] toTypedArray(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Boolean[] boolArr = new Boolean[zArr.length];
        int length = zArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            boolArr[i2] = Boolean.valueOf(zArr[i2]);
        }
        return boolArr;
    }

    @NotNull
    public static final float[] plus(@NotNull float[] fArr, float f) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int length = fArr.length;
        float[] copyOf = Arrays.copyOf(fArr, length + 1);
        copyOf[length] = f;
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    public static final BigDecimal sumOfBigDecimal(boolean[] zArr, Function1<? super Boolean, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        for (boolean valueOf2 : zArr) {
            valueOf = valueOf.add((BigDecimal) function1.invoke(Boolean.valueOf(valueOf2)));
            Intrinsics.checkNotNullExpressionValue(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    public static final BigInteger sumOfBigInteger(boolean[] zArr, Function1<? super Boolean, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigInteger valueOf = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        for (boolean valueOf2 : zArr) {
            valueOf = valueOf.add((BigInteger) function1.invoke(Boolean.valueOf(valueOf2)));
            Intrinsics.checkNotNullExpressionValue(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @NotNull
    public static final Character[] toTypedArray(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Character[] chArr = new Character[cArr.length];
        int length = cArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            chArr[i2] = Character.valueOf(cArr[i2]);
        }
        return chArr;
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    public static final long[] copyOfRangeInline(long[] jArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(jArr, i2, i3);
        }
        if (i3 <= jArr.length) {
            long[] copyOfRange = Arrays.copyOfRange(jArr, i2, i3);
            Intrinsics.checkNotNullExpressionValue(copyOfRange, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + jArr.length);
    }

    @NotNull
    public static final double[] plus(@NotNull double[] dArr, double d) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int length = dArr.length;
        double[] copyOf = Arrays.copyOf(dArr, length + 1);
        copyOf[length] = d;
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    public static final BigDecimal sumOfBigDecimal(char[] cArr, Function1<? super Character, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        for (char valueOf2 : cArr) {
            valueOf = valueOf.add((BigDecimal) function1.invoke(Character.valueOf(valueOf2)));
            Intrinsics.checkNotNullExpressionValue(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    public static final BigInteger sumOfBigInteger(char[] cArr, Function1<? super Character, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigInteger valueOf = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        for (char valueOf2 : cArr) {
            valueOf = valueOf.add((BigInteger) function1.invoke(Character.valueOf(valueOf2)));
            Intrinsics.checkNotNullExpressionValue(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @NotNull
    public static final boolean[] plus(@NotNull boolean[] zArr, boolean z) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        int length = zArr.length;
        boolean[] copyOf = Arrays.copyOf(zArr, length + 1);
        copyOf[length] = z;
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    public static final float[] copyOfRangeInline(float[] fArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(fArr, i2, i3);
        }
        if (i3 <= fArr.length) {
            float[] copyOfRange = Arrays.copyOfRange(fArr, i2, i3);
            Intrinsics.checkNotNullExpressionValue(copyOfRange, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + fArr.length);
    }

    @NotNull
    public static final char[] plus(@NotNull char[] cArr, char c) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int length = cArr.length;
        char[] copyOf = Arrays.copyOf(cArr, length + 1);
        copyOf[length] = c;
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    public static final double[] copyOfRangeInline(double[] dArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(dArr, i2, i3);
        }
        if (i3 <= dArr.length) {
            double[] copyOfRange = Arrays.copyOfRange(dArr, i2, i3);
            Intrinsics.checkNotNullExpressionValue(copyOfRange, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + dArr.length);
    }

    @NotNull
    public static final <T> T[] plus(@NotNull T[] tArr, @NotNull Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(collection, "elements");
        int length = tArr.length;
        T[] copyOf = Arrays.copyOf(tArr, collection.size() + length);
        for (T t : collection) {
            copyOf[length] = t;
            length++;
        }
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final byte[] plus(@NotNull byte[] bArr, @NotNull Collection<Byte> collection) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(collection, "elements");
        int length = bArr.length;
        byte[] copyOf = Arrays.copyOf(bArr, collection.size() + length);
        for (Byte byteValue : collection) {
            copyOf[length] = byteValue.byteValue();
            length++;
        }
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    public static final boolean[] copyOfRangeInline(boolean[] zArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(zArr, i2, i3);
        }
        if (i3 <= zArr.length) {
            boolean[] copyOfRange = Arrays.copyOfRange(zArr, i2, i3);
            Intrinsics.checkNotNullExpressionValue(copyOfRange, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + zArr.length);
    }

    @NotNull
    public static final short[] plus(@NotNull short[] sArr, @NotNull Collection<Short> collection) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(collection, "elements");
        int length = sArr.length;
        short[] copyOf = Arrays.copyOf(sArr, collection.size() + length);
        for (Short shortValue : collection) {
            copyOf[length] = shortValue.shortValue();
            length++;
        }
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    public static final char[] copyOfRangeInline(char[] cArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(cArr, i2, i3);
        }
        if (i3 <= cArr.length) {
            char[] copyOfRange = Arrays.copyOfRange(cArr, i2, i3);
            Intrinsics.checkNotNullExpressionValue(copyOfRange, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + cArr.length);
    }

    @NotNull
    public static final int[] plus(@NotNull int[] iArr, @NotNull Collection<Integer> collection) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(collection, "elements");
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, collection.size() + length);
        for (Integer intValue : collection) {
            copyOf[length] = intValue.intValue();
            length++;
        }
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final long[] plus(@NotNull long[] jArr, @NotNull Collection<Long> collection) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(collection, "elements");
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, collection.size() + length);
        for (Long longValue : collection) {
            copyOf[length] = longValue.longValue();
            length++;
        }
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final float[] plus(@NotNull float[] fArr, @NotNull Collection<Float> collection) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(collection, "elements");
        int length = fArr.length;
        float[] copyOf = Arrays.copyOf(fArr, collection.size() + length);
        for (Float floatValue : collection) {
            copyOf[length] = floatValue.floatValue();
            length++;
        }
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final double[] plus(@NotNull double[] dArr, @NotNull Collection<Double> collection) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(collection, "elements");
        int length = dArr.length;
        double[] copyOf = Arrays.copyOf(dArr, collection.size() + length);
        for (Double doubleValue : collection) {
            copyOf[length] = doubleValue.doubleValue();
            length++;
        }
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final boolean[] plus(@NotNull boolean[] zArr, @NotNull Collection<Boolean> collection) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(collection, "elements");
        int length = zArr.length;
        boolean[] copyOf = Arrays.copyOf(zArr, collection.size() + length);
        for (Boolean booleanValue : collection) {
            copyOf[length] = booleanValue.booleanValue();
            length++;
        }
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final char[] plus(@NotNull char[] cArr, @NotNull Collection<Character> collection) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(collection, "elements");
        int length = cArr.length;
        char[] copyOf = Arrays.copyOf(cArr, collection.size() + length);
        for (Character charValue : collection) {
            copyOf[length] = charValue.charValue();
            length++;
        }
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final <T> T[] plus(@NotNull T[] tArr, @NotNull T[] tArr2) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(tArr2, "elements");
        int length = tArr.length;
        int length2 = tArr2.length;
        T[] copyOf = Arrays.copyOf(tArr, length + length2);
        System.arraycopy(tArr2, 0, copyOf, length, length2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final byte[] plus(@NotNull byte[] bArr, @NotNull byte[] bArr2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(bArr2, "elements");
        int length = bArr.length;
        int length2 = bArr2.length;
        byte[] copyOf = Arrays.copyOf(bArr, length + length2);
        System.arraycopy(bArr2, 0, copyOf, length, length2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final short[] plus(@NotNull short[] sArr, @NotNull short[] sArr2) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(sArr2, "elements");
        int length = sArr.length;
        int length2 = sArr2.length;
        short[] copyOf = Arrays.copyOf(sArr, length + length2);
        System.arraycopy(sArr2, 0, copyOf, length, length2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final int[] plus(@NotNull int[] iArr, @NotNull int[] iArr2) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(iArr2, "elements");
        int length = iArr.length;
        int length2 = iArr2.length;
        int[] copyOf = Arrays.copyOf(iArr, length + length2);
        System.arraycopy(iArr2, 0, copyOf, length, length2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final long[] plus(@NotNull long[] jArr, @NotNull long[] jArr2) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(jArr2, "elements");
        int length = jArr.length;
        int length2 = jArr2.length;
        long[] copyOf = Arrays.copyOf(jArr, length + length2);
        System.arraycopy(jArr2, 0, copyOf, length, length2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final float[] plus(@NotNull float[] fArr, @NotNull float[] fArr2) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(fArr2, "elements");
        int length = fArr.length;
        int length2 = fArr2.length;
        float[] copyOf = Arrays.copyOf(fArr, length + length2);
        System.arraycopy(fArr2, 0, copyOf, length, length2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final double[] plus(@NotNull double[] dArr, @NotNull double[] dArr2) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(dArr2, "elements");
        int length = dArr.length;
        int length2 = dArr2.length;
        double[] copyOf = Arrays.copyOf(dArr, length + length2);
        System.arraycopy(dArr2, 0, copyOf, length, length2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final boolean[] plus(@NotNull boolean[] zArr, @NotNull boolean[] zArr2) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(zArr2, "elements");
        int length = zArr.length;
        int length2 = zArr2.length;
        boolean[] copyOf = Arrays.copyOf(zArr, length + length2);
        System.arraycopy(zArr2, 0, copyOf, length, length2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final char[] plus(@NotNull char[] cArr, @NotNull char[] cArr2) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(cArr2, "elements");
        int length = cArr.length;
        int length2 = cArr2.length;
        char[] copyOf = Arrays.copyOf(cArr, length + length2);
        System.arraycopy(cArr2, 0, copyOf, length, length2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "result");
        return copyOf;
    }
}
