package com.baidu.searchbox.video.search.player.plugin;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u000bJ\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000eJ\u0016\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000eJ\u0016\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/video/search/player/plugin/SearchFirstJumpSlotRecord;", "", "()V", "TAG", "", "firstJumpTimeStamp", "Lcom/baidu/searchbox/video/search/player/plugin/SearchFirstJumpSlotRecord$FirstJumpTimeStamp;", "appendFirstJumpSlotDuration", "", "nid", "dataMap", "Ljava/util/HashMap;", "beginTrack", "clickTimeStamp", "", "recordEndSchemeDispatchTimeStamp", "timeStamp", "recordInitPlayerTimeStamp", "recordStartSchemeDispatchTimeStamp", "FirstJumpTimeStamp", "search-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchFlowCoreStatPlugin.kt */
public final class SearchFirstJumpSlotRecord {
    public static final SearchFirstJumpSlotRecord INSTANCE = new SearchFirstJumpSlotRecord();
    private static final String TAG = "SearchFirstJumpSlotRecord";
    private static final FirstJumpTimeStamp firstJumpTimeStamp = new FirstJumpTimeStamp((String) null, 0, 0, 0, 0, 31, (DefaultConstructorMarker) null);

    private SearchFirstJumpSlotRecord() {
    }

    public final void beginTrack(String nid, long clickTimeStamp) {
        Intrinsics.checkNotNullParameter(nid, "nid");
        if (!StringsKt.isBlank(nid) && clickTimeStamp > 0) {
            FirstJumpTimeStamp firstJumpTimeStamp2 = firstJumpTimeStamp;
            firstJumpTimeStamp2.reset();
            firstJumpTimeStamp2.setNid(nid);
            firstJumpTimeStamp2.setClickTimeStamp(clickTimeStamp);
        }
    }

    public final void recordStartSchemeDispatchTimeStamp(String nid, long timeStamp) {
        Intrinsics.checkNotNullParameter(nid, "nid");
        if (!StringsKt.isBlank(nid) && timeStamp > 0) {
            FirstJumpTimeStamp firstJumpTimeStamp2 = firstJumpTimeStamp;
            if (Intrinsics.areEqual((Object) nid, (Object) firstJumpTimeStamp2.getNid()) && firstJumpTimeStamp2.getStartSchemeDispatchTimeStamp() <= 0) {
                firstJumpTimeStamp2.setStartSchemeDispatchTimeStamp(timeStamp);
            }
        }
    }

    public final void recordEndSchemeDispatchTimeStamp(String nid, long timeStamp) {
        Intrinsics.checkNotNullParameter(nid, "nid");
        if (!StringsKt.isBlank(nid) && timeStamp > 0) {
            FirstJumpTimeStamp firstJumpTimeStamp2 = firstJumpTimeStamp;
            if (Intrinsics.areEqual((Object) nid, (Object) firstJumpTimeStamp2.getNid()) && firstJumpTimeStamp2.getEndSchemeDispatchTimeStamp() <= 0) {
                firstJumpTimeStamp2.setEndSchemeDispatchTimeStamp(timeStamp);
            }
        }
    }

    public final void recordInitPlayerTimeStamp(String nid, long timeStamp) {
        Intrinsics.checkNotNullParameter(nid, "nid");
        if (!StringsKt.isBlank(nid) && timeStamp > 0) {
            FirstJumpTimeStamp firstJumpTimeStamp2 = firstJumpTimeStamp;
            if (Intrinsics.areEqual((Object) nid, (Object) firstJumpTimeStamp2.getNid()) && firstJumpTimeStamp2.getInitPlayerTimeStamp() <= 0) {
                firstJumpTimeStamp2.setInitPlayerTimeStamp(timeStamp);
            }
        }
    }

    public final void appendFirstJumpSlotDuration(String nid, HashMap<String, Object> dataMap) {
        Intrinsics.checkNotNullParameter(dataMap, "dataMap");
        if (firstJumpTimeStamp.checkValid(nid)) {
            FirstJumpTimeStamp $this$appendFirstJumpSlotDuration_u24lambda_u2d0 = firstJumpTimeStamp;
            dataMap.put("p11_1_unitedSchemeDispatch_duration", String.valueOf($this$appendFirstJumpSlotDuration_u24lambda_u2d0.getStartSchemeDispatchTimeStamp() - $this$appendFirstJumpSlotDuration_u24lambda_u2d0.getClickTimeStamp()));
            dataMap.put("p11_2_videoSchemeDispatch_duration", String.valueOf($this$appendFirstJumpSlotDuration_u24lambda_u2d0.getEndSchemeDispatchTimeStamp() - $this$appendFirstJumpSlotDuration_u24lambda_u2d0.getStartSchemeDispatchTimeStamp()));
            dataMap.put("p11_schemeDispatch_duration", String.valueOf($this$appendFirstJumpSlotDuration_u24lambda_u2d0.getEndSchemeDispatchTimeStamp() - $this$appendFirstJumpSlotDuration_u24lambda_u2d0.getClickTimeStamp()));
            dataMap.put("p1_callPlayer_duration", String.valueOf($this$appendFirstJumpSlotDuration_u24lambda_u2d0.getInitPlayerTimeStamp() - $this$appendFirstJumpSlotDuration_u24lambda_u2d0.getClickTimeStamp()));
            $this$appendFirstJumpSlotDuration_u24lambda_u2d0.reset();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\u0018\u001a\u00020\u00192\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u001a\u001a\u00020\u001bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/video/search/player/plugin/SearchFirstJumpSlotRecord$FirstJumpTimeStamp;", "", "nid", "", "clickTimeStamp", "", "startSchemeDispatchTimeStamp", "endSchemeDispatchTimeStamp", "initPlayerTimeStamp", "(Ljava/lang/String;JJJJ)V", "getClickTimeStamp", "()J", "setClickTimeStamp", "(J)V", "getEndSchemeDispatchTimeStamp", "setEndSchemeDispatchTimeStamp", "getInitPlayerTimeStamp", "setInitPlayerTimeStamp", "getNid", "()Ljava/lang/String;", "setNid", "(Ljava/lang/String;)V", "getStartSchemeDispatchTimeStamp", "setStartSchemeDispatchTimeStamp", "checkValid", "", "reset", "", "search-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SearchFlowCoreStatPlugin.kt */
    public static final class FirstJumpTimeStamp {
        private long clickTimeStamp;
        private long endSchemeDispatchTimeStamp;
        private long initPlayerTimeStamp;
        private String nid;
        private long startSchemeDispatchTimeStamp;

        public FirstJumpTimeStamp() {
            this((String) null, 0, 0, 0, 0, 31, (DefaultConstructorMarker) null);
        }

        public FirstJumpTimeStamp(String nid2, long clickTimeStamp2, long startSchemeDispatchTimeStamp2, long endSchemeDispatchTimeStamp2, long initPlayerTimeStamp2) {
            Intrinsics.checkNotNullParameter(nid2, "nid");
            this.nid = nid2;
            this.clickTimeStamp = clickTimeStamp2;
            this.startSchemeDispatchTimeStamp = startSchemeDispatchTimeStamp2;
            this.endSchemeDispatchTimeStamp = endSchemeDispatchTimeStamp2;
            this.initPlayerTimeStamp = initPlayerTimeStamp2;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ FirstJumpTimeStamp(java.lang.String r11, long r12, long r14, long r16, long r18, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
            /*
                r10 = this;
                r0 = r20 & 1
                if (r0 == 0) goto L_0x0007
                java.lang.String r0 = ""
                goto L_0x0008
            L_0x0007:
                r0 = r11
            L_0x0008:
                r1 = r20 & 2
                r2 = 0
                if (r1 == 0) goto L_0x0010
                r4 = r2
                goto L_0x0011
            L_0x0010:
                r4 = r12
            L_0x0011:
                r1 = r20 & 4
                if (r1 == 0) goto L_0x0017
                r6 = r2
                goto L_0x0018
            L_0x0017:
                r6 = r14
            L_0x0018:
                r1 = r20 & 8
                if (r1 == 0) goto L_0x001e
                r8 = r2
                goto L_0x0020
            L_0x001e:
                r8 = r16
            L_0x0020:
                r1 = r20 & 16
                if (r1 == 0) goto L_0x0025
                goto L_0x0027
            L_0x0025:
                r2 = r18
            L_0x0027:
                r11 = r0
                r12 = r4
                r14 = r6
                r16 = r8
                r18 = r2
                r10.<init>(r11, r12, r14, r16, r18)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.search.player.plugin.SearchFirstJumpSlotRecord.FirstJumpTimeStamp.<init>(java.lang.String, long, long, long, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final String getNid() {
            return this.nid;
        }

        public final void setNid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.nid = str;
        }

        public final long getClickTimeStamp() {
            return this.clickTimeStamp;
        }

        public final void setClickTimeStamp(long j2) {
            this.clickTimeStamp = j2;
        }

        public final long getStartSchemeDispatchTimeStamp() {
            return this.startSchemeDispatchTimeStamp;
        }

        public final void setStartSchemeDispatchTimeStamp(long j2) {
            this.startSchemeDispatchTimeStamp = j2;
        }

        public final long getEndSchemeDispatchTimeStamp() {
            return this.endSchemeDispatchTimeStamp;
        }

        public final void setEndSchemeDispatchTimeStamp(long j2) {
            this.endSchemeDispatchTimeStamp = j2;
        }

        public final long getInitPlayerTimeStamp() {
            return this.initPlayerTimeStamp;
        }

        public final void setInitPlayerTimeStamp(long j2) {
            this.initPlayerTimeStamp = j2;
        }

        public final boolean checkValid(String nid2) {
            long j2 = this.clickTimeStamp;
            if (j2 <= 0) {
                return false;
            }
            long j3 = this.startSchemeDispatchTimeStamp;
            if (j3 <= j2) {
                return false;
            }
            long j4 = this.endSchemeDispatchTimeStamp;
            if (j4 <= j3) {
                return false;
            }
            if (this.initPlayerTimeStamp <= j4) {
                return false;
            }
            CharSequence charSequence = nid2;
            if ((charSequence == null || StringsKt.isBlank(charSequence)) || !Intrinsics.areEqual((Object) nid2, (Object) this.nid)) {
                return false;
            }
            return true;
        }

        public final void reset() {
            this.nid = "";
            this.clickTimeStamp = 0;
            this.startSchemeDispatchTimeStamp = 0;
            this.endSchemeDispatchTimeStamp = 0;
            this.initPlayerTimeStamp = 0;
        }
    }
}
