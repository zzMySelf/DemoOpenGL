package com.baidu.searchbox.live.ubc;

import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001:\u0001!B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0006\u0010\u001f\u001a\u00020\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/live/ubc/LoadPlayerRoomEvent;", "", "from", "", "value", "ext", "Lcom/baidu/searchbox/live/ubc/Ext;", "source", "type", "page", "(Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/live/ubc/Ext;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getExt", "()Lcom/baidu/searchbox/live/ubc/Ext;", "getFrom", "()Ljava/lang/String;", "getPage", "getSource", "getType", "getValue", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toJsonString", "toString", "Builder", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: LoadPlayerRoomEvent.kt */
public final class LoadPlayerRoomEvent {
    private final Ext ext;
    private final String from;
    private final String page;
    private final String source;
    private final String type;
    private final String value;

    public static /* synthetic */ LoadPlayerRoomEvent copy$default(LoadPlayerRoomEvent loadPlayerRoomEvent, String str, String str2, Ext ext2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = loadPlayerRoomEvent.from;
        }
        if ((i2 & 2) != 0) {
            str2 = loadPlayerRoomEvent.value;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            ext2 = loadPlayerRoomEvent.ext;
        }
        Ext ext3 = ext2;
        if ((i2 & 8) != 0) {
            str3 = loadPlayerRoomEvent.source;
        }
        String str7 = str3;
        if ((i2 & 16) != 0) {
            str4 = loadPlayerRoomEvent.type;
        }
        String str8 = str4;
        if ((i2 & 32) != 0) {
            str5 = loadPlayerRoomEvent.page;
        }
        return loadPlayerRoomEvent.copy(str, str6, ext3, str7, str8, str5);
    }

    public final String component1() {
        return this.from;
    }

    public final String component2() {
        return this.value;
    }

    public final Ext component3() {
        return this.ext;
    }

    public final String component4() {
        return this.source;
    }

    public final String component5() {
        return this.type;
    }

    public final String component6() {
        return this.page;
    }

    public final LoadPlayerRoomEvent copy(String str, String str2, Ext ext2, String str3, String str4, String str5) {
        Intrinsics.checkParameterIsNotNull(str, "from");
        Intrinsics.checkParameterIsNotNull(str2, "value");
        Intrinsics.checkParameterIsNotNull(ext2, "ext");
        Intrinsics.checkParameterIsNotNull(str3, "source");
        Intrinsics.checkParameterIsNotNull(str4, "type");
        Intrinsics.checkParameterIsNotNull(str5, "page");
        return new LoadPlayerRoomEvent(str, str2, ext2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoadPlayerRoomEvent)) {
            return false;
        }
        LoadPlayerRoomEvent loadPlayerRoomEvent = (LoadPlayerRoomEvent) obj;
        return Intrinsics.areEqual((Object) this.from, (Object) loadPlayerRoomEvent.from) && Intrinsics.areEqual((Object) this.value, (Object) loadPlayerRoomEvent.value) && Intrinsics.areEqual((Object) this.ext, (Object) loadPlayerRoomEvent.ext) && Intrinsics.areEqual((Object) this.source, (Object) loadPlayerRoomEvent.source) && Intrinsics.areEqual((Object) this.type, (Object) loadPlayerRoomEvent.type) && Intrinsics.areEqual((Object) this.page, (Object) loadPlayerRoomEvent.page);
    }

    public int hashCode() {
        String str = this.from;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Ext ext2 = this.ext;
        int hashCode3 = (hashCode2 + (ext2 != null ? ext2.hashCode() : 0)) * 31;
        String str3 = this.source;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.type;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.page;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode5 + i2;
    }

    public String toString() {
        return "LoadPlayerRoomEvent(from=" + this.from + ", value=" + this.value + ", ext=" + this.ext + ", source=" + this.source + ", type=" + this.type + ", page=" + this.page + ")";
    }

    public LoadPlayerRoomEvent(String from2, String value2, Ext ext2, String source2, String type2, String page2) {
        Intrinsics.checkParameterIsNotNull(from2, "from");
        Intrinsics.checkParameterIsNotNull(value2, "value");
        Intrinsics.checkParameterIsNotNull(ext2, "ext");
        Intrinsics.checkParameterIsNotNull(source2, "source");
        Intrinsics.checkParameterIsNotNull(type2, "type");
        Intrinsics.checkParameterIsNotNull(page2, "page");
        this.from = from2;
        this.value = value2;
        this.ext = ext2;
        this.source = source2;
        this.type = type2;
        this.page = page2;
    }

    public final String getFrom() {
        return this.from;
    }

    public final String getValue() {
        return this.value;
    }

    public final Ext getExt() {
        return this.ext;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getType() {
        return this.type;
    }

    public final String getPage() {
        return this.page;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\u0006\u0010\u001b\u001a\u00020\u001cJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003JE\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0003J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012¨\u0006*"}, d2 = {"Lcom/baidu/searchbox/live/ubc/LoadPlayerRoomEvent$Builder;", "", "from", "", "value", "ext", "Lcom/baidu/searchbox/live/ubc/Ext;", "source", "type", "page", "(Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/live/ubc/Ext;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getExt", "()Lcom/baidu/searchbox/live/ubc/Ext;", "setExt", "(Lcom/baidu/searchbox/live/ubc/Ext;)V", "getFrom", "()Ljava/lang/String;", "setFrom", "(Ljava/lang/String;)V", "getPage", "setPage", "getSource", "setSource", "getType", "setType", "getValue", "setValue", "build", "Lcom/baidu/searchbox/live/ubc/LoadPlayerRoomEvent;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: LoadPlayerRoomEvent.kt */
    public static final class Builder {
        private Ext ext;
        private String from;
        private String page;
        private String source;
        private String type;
        private String value;

        public Builder() {
            this((String) null, (String) null, (Ext) null, (String) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Builder copy$default(Builder builder, String str, String str2, Ext ext2, String str3, String str4, String str5, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = builder.from;
            }
            if ((i2 & 2) != 0) {
                str2 = builder.value;
            }
            String str6 = str2;
            if ((i2 & 4) != 0) {
                ext2 = builder.ext;
            }
            Ext ext3 = ext2;
            if ((i2 & 8) != 0) {
                str3 = builder.source;
            }
            String str7 = str3;
            if ((i2 & 16) != 0) {
                str4 = builder.type;
            }
            String str8 = str4;
            if ((i2 & 32) != 0) {
                str5 = builder.page;
            }
            return builder.copy(str, str6, ext3, str7, str8, str5);
        }

        public final String component1() {
            return this.from;
        }

        public final String component2() {
            return this.value;
        }

        public final Ext component3() {
            return this.ext;
        }

        public final String component4() {
            return this.source;
        }

        public final String component5() {
            return this.type;
        }

        public final String component6() {
            return this.page;
        }

        public final Builder copy(String str, String str2, Ext ext2, String str3, String str4, String str5) {
            Intrinsics.checkParameterIsNotNull(str, "from");
            Intrinsics.checkParameterIsNotNull(str2, "value");
            Intrinsics.checkParameterIsNotNull(ext2, "ext");
            Intrinsics.checkParameterIsNotNull(str3, "source");
            Intrinsics.checkParameterIsNotNull(str4, "type");
            Intrinsics.checkParameterIsNotNull(str5, "page");
            return new Builder(str, str2, ext2, str3, str4, str5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Builder)) {
                return false;
            }
            Builder builder = (Builder) obj;
            return Intrinsics.areEqual((Object) this.from, (Object) builder.from) && Intrinsics.areEqual((Object) this.value, (Object) builder.value) && Intrinsics.areEqual((Object) this.ext, (Object) builder.ext) && Intrinsics.areEqual((Object) this.source, (Object) builder.source) && Intrinsics.areEqual((Object) this.type, (Object) builder.type) && Intrinsics.areEqual((Object) this.page, (Object) builder.page);
        }

        public int hashCode() {
            String str = this.from;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.value;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Ext ext2 = this.ext;
            int hashCode3 = (hashCode2 + (ext2 != null ? ext2.hashCode() : 0)) * 31;
            String str3 = this.source;
            int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.type;
            int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.page;
            if (str5 != null) {
                i2 = str5.hashCode();
            }
            return hashCode5 + i2;
        }

        public String toString() {
            return "Builder(from=" + this.from + ", value=" + this.value + ", ext=" + this.ext + ", source=" + this.source + ", type=" + this.type + ", page=" + this.page + ")";
        }

        public Builder(String from2, String value2, Ext ext2, String source2, String type2, String page2) {
            Intrinsics.checkParameterIsNotNull(from2, "from");
            Intrinsics.checkParameterIsNotNull(value2, "value");
            Intrinsics.checkParameterIsNotNull(ext2, "ext");
            Intrinsics.checkParameterIsNotNull(source2, "source");
            Intrinsics.checkParameterIsNotNull(type2, "type");
            Intrinsics.checkParameterIsNotNull(page2, "page");
            this.from = from2;
            this.value = value2;
            this.ext = ext2;
            this.source = source2;
            this.type = type2;
            this.page = page2;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Builder(java.lang.String r13, java.lang.String r14, com.baidu.searchbox.live.ubc.Ext r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, int r19, kotlin.jvm.internal.DefaultConstructorMarker r20) {
            /*
                r12 = this;
                r0 = r19 & 1
                java.lang.String r1 = ""
                if (r0 == 0) goto L_0x0008
                r0 = r1
                goto L_0x0009
            L_0x0008:
                r0 = r13
            L_0x0009:
                r2 = r19 & 2
                if (r2 == 0) goto L_0x000f
                r2 = r1
                goto L_0x0010
            L_0x000f:
                r2 = r14
            L_0x0010:
                r3 = r19 & 4
                if (r3 == 0) goto L_0x0027
                com.baidu.searchbox.live.ubc.Ext$Builder r3 = new com.baidu.searchbox.live.ubc.Ext$Builder
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 31
                r11 = 0
                r4 = r3
                r4.<init>(r5, r6, r7, r8, r9, r10, r11)
                com.baidu.searchbox.live.ubc.Ext r3 = r3.build()
                goto L_0x0028
            L_0x0027:
                r3 = r15
            L_0x0028:
                r4 = r19 & 8
                if (r4 == 0) goto L_0x002e
                r4 = r1
                goto L_0x0030
            L_0x002e:
                r4 = r16
            L_0x0030:
                r5 = r19 & 16
                if (r5 == 0) goto L_0x0036
                r5 = r1
                goto L_0x0038
            L_0x0036:
                r5 = r17
            L_0x0038:
                r6 = r19 & 32
                if (r6 == 0) goto L_0x003d
                goto L_0x003f
            L_0x003d:
                r1 = r18
            L_0x003f:
                r13 = r0
                r14 = r2
                r15 = r3
                r16 = r4
                r17 = r5
                r18 = r1
                r12.<init>(r13, r14, r15, r16, r17, r18)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.live.ubc.LoadPlayerRoomEvent.Builder.<init>(java.lang.String, java.lang.String, com.baidu.searchbox.live.ubc.Ext, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final String getFrom() {
            return this.from;
        }

        public final void setFrom(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.from = str;
        }

        public final String getValue() {
            return this.value;
        }

        public final void setValue(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.value = str;
        }

        public final Ext getExt() {
            return this.ext;
        }

        public final void setExt(Ext ext2) {
            Intrinsics.checkParameterIsNotNull(ext2, "<set-?>");
            this.ext = ext2;
        }

        public final String getSource() {
            return this.source;
        }

        public final void setSource(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.source = str;
        }

        public final String getType() {
            return this.type;
        }

        public final void setType(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.type = str;
        }

        public final String getPage() {
            return this.page;
        }

        public final void setPage(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.page = str;
        }

        public final Builder from(String from2) {
            Intrinsics.checkParameterIsNotNull(from2, "from");
            this.from = from2;
            return this;
        }

        public final Builder value(String value2) {
            Intrinsics.checkParameterIsNotNull(value2, "value");
            this.value = value2;
            return this;
        }

        public final Builder ext(Ext ext2) {
            Intrinsics.checkParameterIsNotNull(ext2, "ext");
            this.ext = ext2;
            return this;
        }

        public final Builder source(String source2) {
            Intrinsics.checkParameterIsNotNull(source2, "source");
            this.source = source2;
            return this;
        }

        public final Builder type(String type2) {
            Intrinsics.checkParameterIsNotNull(type2, "type");
            this.type = type2;
            return this;
        }

        public final Builder page(String page2) {
            Intrinsics.checkParameterIsNotNull(page2, "page");
            this.page = page2;
            return this;
        }

        public final LoadPlayerRoomEvent build() {
            return new LoadPlayerRoomEvent(this.from, this.value, this.ext, this.source, this.type, this.page);
        }
    }

    public final String toJsonString() {
        String json = new Gson().toJson((Object) this);
        Intrinsics.checkExpressionValueIsNotNull(json, "gson.toJson(this)");
        return json;
    }
}
