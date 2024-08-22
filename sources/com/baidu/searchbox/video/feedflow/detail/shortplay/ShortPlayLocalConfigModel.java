package com.baidu.searchbox.video.feedflow.detail.shortplay;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.feedflow.utils.DateUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0018\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÂ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÂ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003JG\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\u000e\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\u000e\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u0003J\u0006\u0010(\u001a\u00020\nJ\u0006\u0010)\u001a\u00020\nJ\u001e\u0010*\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003J\u0006\u0010+\u001a\u00020\nJ\u0006\u0010,\u001a\u00020-J\u0006\u0010.\u001a\u00020-J\u0006\u0010/\u001a\u00020-J\t\u00100\u001a\u000201HÖ\u0001J\u001e\u00102\u001a\u00020-2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003R\u000e\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/shortplay/ShortPlayLocalConfigModel;", "Lcom/baidu/searchbox/NoProGuard;", "showTimes", "", "noClickTime", "exitDay", "lastDay", "Lcom/baidu/searchbox/video/feedflow/detail/shortplay/ShortPlayLocalOneDayModel;", "hasShownCount", "hasShownAfterExit", "", "(IIILcom/baidu/searchbox/video/feedflow/detail/shortplay/ShortPlayLocalOneDayModel;IZ)V", "getHasShownAfterExit", "()Z", "setHasShownAfterExit", "(Z)V", "getHasShownCount", "()I", "setHasShownCount", "(I)V", "getLastDay", "()Lcom/baidu/searchbox/video/feedflow/detail/shortplay/ShortPlayLocalOneDayModel;", "setLastDay", "(Lcom/baidu/searchbox/video/feedflow/detail/shortplay/ShortPlayLocalOneDayModel;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "getDateDiff", "curTime", "", "hashCode", "isConformExitDaysLimit", "diff", "isConformOneDayShownCount", "isConformShownDaysLimit", "isSampleConfig", "isValid", "recordToFirstDay", "", "reset", "resetExit", "toString", "", "updateConfig", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShortPlayPushManager.kt */
public final class ShortPlayLocalConfigModel implements NoProGuard {
    private int exitDay;
    private boolean hasShownAfterExit;
    private int hasShownCount;
    private ShortPlayLocalOneDayModel lastDay;
    private int noClickTime;
    private int showTimes;

    private final int component1() {
        return this.showTimes;
    }

    private final int component2() {
        return this.noClickTime;
    }

    private final int component3() {
        return this.exitDay;
    }

    public static /* synthetic */ ShortPlayLocalConfigModel copy$default(ShortPlayLocalConfigModel shortPlayLocalConfigModel, int i2, int i3, int i4, ShortPlayLocalOneDayModel shortPlayLocalOneDayModel, int i5, boolean z, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = shortPlayLocalConfigModel.showTimes;
        }
        if ((i6 & 2) != 0) {
            i3 = shortPlayLocalConfigModel.noClickTime;
        }
        int i7 = i3;
        if ((i6 & 4) != 0) {
            i4 = shortPlayLocalConfigModel.exitDay;
        }
        int i8 = i4;
        if ((i6 & 8) != 0) {
            shortPlayLocalOneDayModel = shortPlayLocalConfigModel.lastDay;
        }
        ShortPlayLocalOneDayModel shortPlayLocalOneDayModel2 = shortPlayLocalOneDayModel;
        if ((i6 & 16) != 0) {
            i5 = shortPlayLocalConfigModel.hasShownCount;
        }
        int i9 = i5;
        if ((i6 & 32) != 0) {
            z = shortPlayLocalConfigModel.hasShownAfterExit;
        }
        return shortPlayLocalConfigModel.copy(i2, i7, i8, shortPlayLocalOneDayModel2, i9, z);
    }

    public final ShortPlayLocalOneDayModel component4() {
        return this.lastDay;
    }

    public final int component5() {
        return this.hasShownCount;
    }

    public final boolean component6() {
        return this.hasShownAfterExit;
    }

    public final ShortPlayLocalConfigModel copy(int i2, int i3, int i4, ShortPlayLocalOneDayModel shortPlayLocalOneDayModel, int i5, boolean z) {
        return new ShortPlayLocalConfigModel(i2, i3, i4, shortPlayLocalOneDayModel, i5, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShortPlayLocalConfigModel)) {
            return false;
        }
        ShortPlayLocalConfigModel shortPlayLocalConfigModel = (ShortPlayLocalConfigModel) obj;
        return this.showTimes == shortPlayLocalConfigModel.showTimes && this.noClickTime == shortPlayLocalConfigModel.noClickTime && this.exitDay == shortPlayLocalConfigModel.exitDay && Intrinsics.areEqual((Object) this.lastDay, (Object) shortPlayLocalConfigModel.lastDay) && this.hasShownCount == shortPlayLocalConfigModel.hasShownCount && this.hasShownAfterExit == shortPlayLocalConfigModel.hasShownAfterExit;
    }

    public int hashCode() {
        int hashCode = ((((Integer.hashCode(this.showTimes) * 31) + Integer.hashCode(this.noClickTime)) * 31) + Integer.hashCode(this.exitDay)) * 31;
        ShortPlayLocalOneDayModel shortPlayLocalOneDayModel = this.lastDay;
        int hashCode2 = (((hashCode + (shortPlayLocalOneDayModel == null ? 0 : shortPlayLocalOneDayModel.hashCode())) * 31) + Integer.hashCode(this.hasShownCount)) * 31;
        boolean z = this.hasShownAfterExit;
        if (z) {
            z = true;
        }
        return hashCode2 + (z ? 1 : 0);
    }

    public String toString() {
        return "ShortPlayLocalConfigModel(showTimes=" + this.showTimes + ", noClickTime=" + this.noClickTime + ", exitDay=" + this.exitDay + ", lastDay=" + this.lastDay + ", hasShownCount=" + this.hasShownCount + ", hasShownAfterExit=" + this.hasShownAfterExit + ')';
    }

    public ShortPlayLocalConfigModel(int showTimes2, int noClickTime2, int exitDay2, ShortPlayLocalOneDayModel lastDay2, int hasShownCount2, boolean hasShownAfterExit2) {
        this.showTimes = showTimes2;
        this.noClickTime = noClickTime2;
        this.exitDay = exitDay2;
        this.lastDay = lastDay2;
        this.hasShownCount = hasShownCount2;
        this.hasShownAfterExit = hasShownAfterExit2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ShortPlayLocalConfigModel(int r8, int r9, int r10, com.baidu.searchbox.video.feedflow.detail.shortplay.ShortPlayLocalOneDayModel r11, int r12, boolean r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r7 = this;
            r15 = r14 & 8
            if (r15 == 0) goto L_0x0007
            r11 = 0
            r4 = r11
            goto L_0x0008
        L_0x0007:
            r4 = r11
        L_0x0008:
            r11 = r14 & 16
            r15 = 0
            if (r11 == 0) goto L_0x000f
            r5 = r15
            goto L_0x0010
        L_0x000f:
            r5 = r12
        L_0x0010:
            r11 = r14 & 32
            if (r11 == 0) goto L_0x0016
            r6 = r15
            goto L_0x0017
        L_0x0016:
            r6 = r13
        L_0x0017:
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.shortplay.ShortPlayLocalConfigModel.<init>(int, int, int, com.baidu.searchbox.video.feedflow.detail.shortplay.ShortPlayLocalOneDayModel, int, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final ShortPlayLocalOneDayModel getLastDay() {
        return this.lastDay;
    }

    public final void setLastDay(ShortPlayLocalOneDayModel shortPlayLocalOneDayModel) {
        this.lastDay = shortPlayLocalOneDayModel;
    }

    public final int getHasShownCount() {
        return this.hasShownCount;
    }

    public final void setHasShownCount(int i2) {
        this.hasShownCount = i2;
    }

    public final boolean getHasShownAfterExit() {
        return this.hasShownAfterExit;
    }

    public final void setHasShownAfterExit(boolean z) {
        this.hasShownAfterExit = z;
    }

    public final void updateConfig(int showTimes2, int noClickTime2, int exitDay2) {
        this.showTimes = showTimes2;
        this.noClickTime = noClickTime2;
        this.exitDay = exitDay2;
    }

    public final boolean isSampleConfig(int showTimes2, int noClickTime2, int exitDay2) {
        return this.showTimes == showTimes2 && this.noClickTime == noClickTime2 && this.exitDay == exitDay2;
    }

    public final boolean isValid() {
        return this.showTimes > 0 && this.noClickTime > 0 && this.exitDay >= 0;
    }

    public final boolean isConformExitDaysLimit(int diff) {
        return diff > this.exitDay;
    }

    public final int getDateDiff(long curTime) {
        ShortPlayLocalOneDayModel shortPlayLocalOneDayModel = this.lastDay;
        return DateUtilsKt.getDayDiffWithTimeStamp(curTime, shortPlayLocalOneDayModel != null ? shortPlayLocalOneDayModel.getLastShownTime() : 0);
    }

    public final boolean isConformShownDaysLimit() {
        return this.hasShownCount < this.noClickTime;
    }

    public final boolean isConformOneDayShownCount() {
        ShortPlayLocalOneDayModel shortPlayLocalOneDayModel = this.lastDay;
        return BdPlayerUtils.orZero(shortPlayLocalOneDayModel != null ? Integer.valueOf(shortPlayLocalOneDayModel.getHasShownCount()) : null) < this.showTimes;
    }

    public final void recordToFirstDay() {
        reset();
        ShortPlayLocalOneDayModel shortPlayLocalOneDayModel = new ShortPlayLocalOneDayModel(0, 0, 3, (DefaultConstructorMarker) null);
        this.lastDay = shortPlayLocalOneDayModel;
        shortPlayLocalOneDayModel.setLastShownTime(System.currentTimeMillis());
        ShortPlayLocalOneDayModel shortPlayLocalOneDayModel2 = this.lastDay;
        if (shortPlayLocalOneDayModel2 != null) {
            shortPlayLocalOneDayModel2.setHasShownCount(1);
        }
        this.hasShownCount = 1;
    }

    public final void reset() {
        ShortPlayLocalOneDayModel shortPlayLocalOneDayModel = this.lastDay;
        if (shortPlayLocalOneDayModel != null) {
            shortPlayLocalOneDayModel.reset();
        }
        this.lastDay = null;
        this.hasShownCount = 0;
    }

    public final void resetExit() {
        this.hasShownCount = 0;
        this.hasShownAfterExit = false;
    }
}
