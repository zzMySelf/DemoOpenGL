package com.baidu.searchbox.player.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.player.control.model.PraiseInfo;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.player.utils.LayerUtil;
import com.baidu.searchbox.videoplayer.vulcan.R;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0001H\u0002J\b\u0010\u000f\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R0\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/player/widget/VideoVulcanPraiseViewWrapper;", "Lcom/baidu/searchbox/player/widget/IVideoUnityPraiseView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "listener", "Lkotlin/Function2;", "", "", "", "getListener", "()Lkotlin/jvm/functions/Function2;", "setListener", "(Lkotlin/jvm/functions/Function2;)V", "view", "getView", "()Lcom/baidu/searchbox/player/widget/IVideoUnityPraiseView;", "view$delegate", "Lkotlin/Lazy;", "createView", "Landroid/view/View;", "setPraiseInfo", "data", "Lcom/baidu/searchbox/player/control/model/PraiseInfo;", "business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoVulcanPraiseViewWrapper.kt */
public final class VideoVulcanPraiseViewWrapper implements IVideoUnityPraiseView {
    private final Context context;
    private Function2<? super Boolean, ? super Integer, Unit> listener;
    private final Lazy view$delegate = BdPlayerUtils.lazyNone(new VideoVulcanPraiseViewWrapper$view$2(this));

    public VideoVulcanPraiseViewWrapper(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    private final IVideoUnityPraiseView getView() {
        return (IVideoUnityPraiseView) this.view$delegate.getValue();
    }

    public final Function2<Boolean, Integer, Unit> getListener() {
        return this.listener;
    }

    public final void setListener(Function2<? super Boolean, ? super Integer, Unit> function2) {
        this.listener = function2;
    }

    /* access modifiers changed from: private */
    public final IVideoUnityPraiseView createView() {
        if (this.context instanceof Activity) {
            VideoVulcanCoolPraiseView $this$createView_u24lambda_u2d1 = new VideoVulcanCoolPraiseView(this.context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
            $this$createView_u24lambda_u2d1.setLayoutParams(new ViewGroup.LayoutParams(-2, LayerUtil.slotSize()));
            $this$createView_u24lambda_u2d1.setPraiseIconSize(LayerUtil.slotSize(), LayerUtil.slotSize());
            $this$createView_u24lambda_u2d1.setPraiseCntsVisibility(true);
            $this$createView_u24lambda_u2d1.setPraiseStateIconRes(R.drawable.videoplayer_vulcan_control_unpraise, R.drawable.videoplayer_vulcan_control_praise);
            $this$createView_u24lambda_u2d1.setPraiseCntsLeftMargin(BdPlayerUtils.dp2px($this$createView_u24lambda_u2d1, 4.0f));
            $this$createView_u24lambda_u2d1.setOnClickPraiseListener(new VideoVulcanPraiseViewWrapper$$ExternalSyntheticLambda0(this));
            return $this$createView_u24lambda_u2d1;
        }
        VideoVulcanDefaultPraiseView $this$createView_u24lambda_u2d2 = new VideoVulcanDefaultPraiseView(this.context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        $this$createView_u24lambda_u2d2.setLayoutParams(new ViewGroup.LayoutParams(-2, LayerUtil.slotSize()));
        $this$createView_u24lambda_u2d2.setOnPraiseClickListener(new VideoVulcanPraiseViewWrapper$createView$2$1(this));
        return $this$createView_u24lambda_u2d2;
    }

    /* access modifiers changed from: private */
    /* renamed from: createView$lambda-1$lambda-0  reason: not valid java name */
    public static final void m2444createView$lambda1$lambda0(VideoVulcanPraiseViewWrapper this$0, boolean isPraised, int praiseCount) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function2<? super Boolean, ? super Integer, Unit> function2 = this$0.listener;
        if (function2 != null) {
            Unit invoke = function2.invoke(Boolean.valueOf(isPraised), Integer.valueOf(praiseCount));
        }
    }

    public void setPraiseInfo(PraiseInfo data) {
        Intrinsics.checkNotNullParameter(data, "data");
        getView().setPraiseInfo(data);
    }

    /* renamed from: getView  reason: collision with other method in class */
    public View m2445getView() {
        return getView().getView();
    }
}
