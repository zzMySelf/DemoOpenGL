package com.baidu.searchbox.video.channel.flow.pageview.drawer;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/video/channel/flow/pageview/drawer/Drawer;", "", "value", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "equals", "", "other", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "Companion", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
/* compiled from: IChannelDrawer.kt */
public final class Drawer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String LeftDrawer = m4897constructorimpl("left");
    /* access modifiers changed from: private */
    public static final String rightDrawer = m4897constructorimpl("right");
    private final String value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Drawer m4896boximpl(String str) {
        return new Drawer(str);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static String m4897constructorimpl(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        return str;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4898equalsimpl(String str, Object obj) {
        return (obj instanceof Drawer) && Intrinsics.areEqual((Object) str, (Object) ((Drawer) obj).m4902unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m4899equalsimpl0(String str, String str2) {
        return Intrinsics.areEqual((Object) str, (Object) str2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m4900hashCodeimpl(String str) {
        return str.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m4901toStringimpl(String str) {
        return "Drawer(value=" + str + ')';
    }

    public boolean equals(Object obj) {
        return m4898equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m4900hashCodeimpl(this.value);
    }

    public String toString() {
        return m4901toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ String m4902unboximpl() {
        return this.value;
    }

    private /* synthetic */ Drawer(String value2) {
        this.value = value2;
    }

    public final String getValue() {
        return this.value;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/video/channel/flow/pageview/drawer/Drawer$Companion;", "", "()V", "LeftDrawer", "Lcom/baidu/searchbox/video/channel/flow/pageview/drawer/Drawer;", "getLeftDrawer-eq2za7k", "()Ljava/lang/String;", "Ljava/lang/String;", "rightDrawer", "getRightDrawer-eq2za7k", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IChannelDrawer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getLeftDrawer-eq2za7k  reason: not valid java name */
        public final String m4903getLeftDrawereq2za7k() {
            return Drawer.LeftDrawer;
        }

        /* renamed from: getRightDrawer-eq2za7k  reason: not valid java name */
        public final String m4904getRightDrawereq2za7k() {
            return Drawer.rightDrawer;
        }
    }
}
