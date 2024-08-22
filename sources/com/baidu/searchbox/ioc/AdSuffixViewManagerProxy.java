package com.baidu.searchbox.ioc;

import android.content.Context;
import com.baidu.searchbox.feed.model.AdTailFrameData;
import com.baidu.searchbox.ioc.IAdVideoSuffixAppendHelper;
import com.baidu.searchbox.model.AdSuffixType;
import com.baidu.searchbox.newsuffix.AdSuffixImageView;
import com.baidu.searchbox.newsuffix.AdSuffixViewVerticalVideoPlayer;
import com.baidu.searchbox.newsuffix.AdSuffixViewVideoPlayer;
import com.baidu.searchbox.newsuffix.AdTailFrameView;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.BaseVideoPlayer;
import com.baidu.searchbox.view.AdSuffixBaseView;

public class AdSuffixViewManagerProxy implements IAdSuffixViewManagerProxy {

    /* renamed from: com.baidu.searchbox.ioc.AdSuffixViewManagerProxy$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$model$AdSuffixType;

        static {
            int[] iArr = new int[AdSuffixType.values().length];
            $SwitchMap$com$baidu$searchbox$model$AdSuffixType = iArr;
            try {
                iArr[AdSuffixType.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$model$AdSuffixType[AdSuffixType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$model$AdSuffixType[AdSuffixType.AD_VERTICAL_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$model$AdSuffixType[AdSuffixType.AD_APPEND.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public AdSuffixBaseView getAdSuffixView(Context context, AdSuffixType type) {
        switch (AnonymousClass1.$SwitchMap$com$baidu$searchbox$model$AdSuffixType[type.ordinal()]) {
            case 1:
                return new AdSuffixImageView(context);
            case 2:
                return new AdSuffixViewVideoPlayer(context);
            case 3:
                return new AdSuffixViewVerticalVideoPlayer(context);
            case 4:
                return new AdTailFrameView(context, (AdTailFrameData) IAdVideoSuffixAppendHelper.Impl.getAdVideoSuffixAppendHelper().createATFData());
            default:
                return null;
        }
    }

    public boolean isFullLandscapeStyle(BDVideoPlayer player) {
        if (!(player instanceof BaseVideoPlayer) || ((BaseVideoPlayer) player).getFullScreenStyle() != 1) {
            return false;
        }
        return true;
    }
}
