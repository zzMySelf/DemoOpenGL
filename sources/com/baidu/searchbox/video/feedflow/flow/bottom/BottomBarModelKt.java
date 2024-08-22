package com.baidu.searchbox.video.feedflow.flow.bottom;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a4\u0010\u0003\u001a\u00020\u0004*\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t\u001a\f\u0010\n\u001a\u00020\u0001*\u0004\u0018\u00010\u000b\u001a\f\u0010\f\u001a\u00020\r*\u0004\u0018\u00010\u000b\u001a\f\u0010\u000e\u001a\u00020\r*\u0004\u0018\u00010\u000b\u001a\f\u0010\u000f\u001a\u00020\r*\u0004\u0018\u00010\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"TYPE_BARRAGE_BTN_DARK", "", "TYPE_BARRAGE_BTN_LIGHT", "detectBarrageButtonShowTime", "", "Lcom/baidu/searchbox/video/feedflow/flow/bottom/BottomBarModel;", "progress", "max", "show", "Lkotlin/Function1;", "getBarrageBtnShowPosition", "Lcom/baidu/searchbox/video/feedflow/flow/bottom/BottomBarrageInputModel;", "isDarkStyle", "", "isPercentType", "isSecondType", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomBarModel.kt */
public final class BottomBarModelKt {
    public static final int TYPE_BARRAGE_BTN_DARK = 2;
    public static final int TYPE_BARRAGE_BTN_LIGHT = 1;

    public static final boolean isDarkStyle(BottomBarrageInputModel $this$isDarkStyle) {
        return $this$isDarkStyle != null && $this$isDarkStyle.getBarrageButtonStyle() == 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = r3.getBarrageBtnConfig();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isSecondType(com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarrageInputModel r3) {
        /*
            r0 = 1
            r1 = 0
            if (r3 == 0) goto L_0x0011
            com.baidu.searchbox.video.feedflow.flow.bottom.BarrageBtnPositionConfig r2 = r3.getBarrageBtnConfig()
            if (r2 == 0) goto L_0x0011
            int r2 = r2.getPositionType()
            if (r2 != r0) goto L_0x0011
            goto L_0x0012
        L_0x0011:
            r0 = r1
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarModelKt.isSecondType(com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarrageInputModel):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = r3.getBarrageBtnConfig();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isPercentType(com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarrageInputModel r3) {
        /*
            r0 = 0
            if (r3 == 0) goto L_0x0011
            com.baidu.searchbox.video.feedflow.flow.bottom.BarrageBtnPositionConfig r1 = r3.getBarrageBtnConfig()
            if (r1 == 0) goto L_0x0011
            int r1 = r1.getPositionType()
            r2 = 2
            if (r1 != r2) goto L_0x0011
            r0 = 1
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarModelKt.isPercentType(com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarrageInputModel):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r1.getBarrageBtnConfig();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int getBarrageBtnShowPosition(com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarrageInputModel r1) {
        /*
            if (r1 == 0) goto L_0x0011
            com.baidu.searchbox.video.feedflow.flow.bottom.BarrageBtnPositionConfig r0 = r1.getBarrageBtnConfig()
            if (r0 == 0) goto L_0x0011
            int r0 = r0.getShowPosition()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            int r0 = com.baidu.searchbox.player.utils.BdPlayerUtils.orZero((java.lang.Integer) r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarModelKt.getBarrageBtnShowPosition(com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarrageInputModel):int");
    }

    public static /* synthetic */ void detectBarrageButtonShowTime$default(BottomBarModel bottomBarModel, int i2, int i3, Function1 function1, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            function1 = null;
        }
        detectBarrageButtonShowTime(bottomBarModel, i2, i3, function1);
    }

    public static final void detectBarrageButtonShowTime(BottomBarModel $this$detectBarrageButtonShowTime, int progress, int max, Function1<? super BottomBarModel, Unit> show) {
        BottomBarrageInputModel barrageInputModel;
        if ($this$detectBarrageButtonShowTime != null && (barrageInputModel = $this$detectBarrageButtonShowTime.getBarrageInputModel()) != null) {
            if (isSecondType(barrageInputModel)) {
                if (progress > getBarrageBtnShowPosition(barrageInputModel) * 1000 && show != null) {
                    show.invoke($this$detectBarrageButtonShowTime);
                }
            } else if (isPercentType(barrageInputModel) && (((float) progress) / ((float) max)) * ((float) 100) > ((float) getBarrageBtnShowPosition(barrageInputModel)) && show != null) {
                show.invoke($this$detectBarrageButtonShowTime);
            }
        }
    }
}
