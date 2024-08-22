package com.baidu.searchbox.video.feedflow.detail.clip;

import android.graphics.Rect;
import android.view.ViewGroup;
import com.baidu.searchbox.feed.detail.arch.api.IService;
import com.baidu.searchbox.player.plugin.model.VideoProperty;
import com.baidu.searchbox.video.feedflow.utils.PlayerClipResult;
import com.baidu.searchbox.video.feedflow.utils.ShortVideoClipRuleType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001JN\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH&J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\u0010\u001a\u00020\u0007H&J\b\u0010\u0011\u001a\u00020\u0007H&J\b\u0010\u0012\u001a\u00020\u0007H&J\u001c\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fH&J\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0017H&J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H&J\b\u0010\u001b\u001a\u00020\u0007H'J\b\u0010\u001c\u001a\u00020\u0014H&J\b\u0010\u001d\u001a\u00020\u0014H&J\b\u0010\u001e\u001a\u00020\u0007H&J\u001c\u0010\u001f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0017\u0018\u00010 H&J\u001c\u0010!\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0017\u0018\u00010 H&J\u0016\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0017H&J\b\u0010#\u001a\u00020\fH&J\b\u0010$\u001a\u00020\fH&J\b\u0010%\u001a\u00020\fH&J\b\u0010&\u001a\u00020\fH&¨\u0006'"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/clip/IPlayerClipService;", "Lcom/baidu/searchbox/feed/detail/arch/api/IService;", "clipPlayerHolder", "Lcom/baidu/searchbox/video/feedflow/utils/PlayerClipResult;", "holder", "Landroid/view/ViewGroup;", "videoWidth", "", "videoHeight", "videoProperty", "Lcom/baidu/searchbox/player/plugin/model/VideoProperty;", "isWaterMark", "", "isInterveneClip", "isMiniVideoFullScreenEnabled", "getAvailableScreenContentHeight", "getAvailableScreenContentWidth", "getAvailableStatusBarHeight", "getBottomBarHeight", "getClipMaxPercent", "", "isUseDefault", "getDefaultMinWHRatio", "Lkotlin/Pair;", "getMiniVideoMinTextMargin", "Landroid/graphics/Rect;", "getShortVideoMinTextMargin", "getShortVideoRuleType", "getShortVideoScale", "getShortVideoYLocationRatio", "getTopBarHeight", "getWHAutoLimitless", "", "getWHDemoteLevel", "getWaterMarkMinWHRadio", "isMiniVideoClipScaleEnable", "isMiniVideoGravityTopEnable", "isShortVideoClipScaleEnable", "isShortVideoTranslationYEnable", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IPlayerClipService.kt */
public interface IPlayerClipService extends IService {
    PlayerClipResult clipPlayerHolder(ViewGroup viewGroup, int i2, int i3, VideoProperty videoProperty, boolean z, boolean z2, boolean z3);

    int getAvailableScreenContentHeight(int i2, int i3);

    int getAvailableScreenContentWidth();

    int getAvailableStatusBarHeight();

    int getBottomBarHeight();

    float getClipMaxPercent(boolean z, boolean z2);

    Pair<Integer, Integer> getDefaultMinWHRatio();

    Rect getMiniVideoMinTextMargin();

    Rect getShortVideoMinTextMargin();

    @ShortVideoClipRuleType
    int getShortVideoRuleType();

    float getShortVideoScale();

    float getShortVideoYLocationRatio();

    int getTopBarHeight();

    List<Pair<Integer, Integer>> getWHAutoLimitless();

    List<Pair<Integer, Integer>> getWHDemoteLevel();

    Pair<Integer, Integer> getWaterMarkMinWHRadio();

    boolean isMiniVideoClipScaleEnable();

    boolean isMiniVideoGravityTopEnable();

    boolean isShortVideoClipScaleEnable();

    boolean isShortVideoTranslationYEnable();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IPlayerClipService.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ float getClipMaxPercent$default(IPlayerClipService iPlayerClipService, boolean z, boolean z2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    z = true;
                }
                if ((i2 & 2) != 0) {
                    z2 = false;
                }
                return iPlayerClipService.getClipMaxPercent(z, z2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getClipMaxPercent");
        }

        public static /* synthetic */ PlayerClipResult clipPlayerHolder$default(IPlayerClipService iPlayerClipService, ViewGroup viewGroup, int i2, int i3, VideoProperty videoProperty, boolean z, boolean z2, boolean z3, int i4, Object obj) {
            int i5;
            int i6;
            VideoProperty videoProperty2;
            boolean z4;
            boolean z5;
            if (obj == null) {
                boolean z6 = false;
                if ((i4 & 2) != 0) {
                    i5 = 0;
                } else {
                    i5 = i2;
                }
                if ((i4 & 4) != 0) {
                    i6 = 0;
                } else {
                    i6 = i3;
                }
                if ((i4 & 8) != 0) {
                    videoProperty2 = null;
                } else {
                    videoProperty2 = videoProperty;
                }
                if ((i4 & 16) != 0) {
                    z4 = false;
                } else {
                    z4 = z;
                }
                if ((i4 & 32) != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if ((i4 & 64) == 0) {
                    z6 = z3;
                }
                return iPlayerClipService.clipPlayerHolder(viewGroup, i5, i6, videoProperty2, z4, z5, z6);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipPlayerHolder");
        }
    }
}
