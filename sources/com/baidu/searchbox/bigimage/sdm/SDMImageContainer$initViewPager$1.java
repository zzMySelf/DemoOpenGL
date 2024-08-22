package com.baidu.searchbox.bigimage.sdm;

import android.text.TextUtils;
import com.baidu.android.util.connect.NetWorkUtils;
import com.baidu.searchbox.browserenhanceengine.utils.BeeRenderMonitor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SDMImageContainer.kt */
final class SDMImageContainer$initViewPager$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ SDMImageContainer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SDMImageContainer$initViewPager$1(SDMImageContainer sDMImageContainer) {
        super(1);
        this.this$0 = sDMImageContainer;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Boolean) p1).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean it) {
        if (!this.this$0.isFirstImageLoadEnd) {
            SDMImageContainer sDMImageContainer = this.this$0;
            sDMImageContainer.currentStage = sDMImageContainer.currentStage + 1;
            this.this$0.isFirstImageLoadEnd = true;
        }
        if (this.this$0.currentStage <= this.this$0.MAX_STAGE) {
            if (it) {
                if (TextUtils.isEmpty(BeeRenderMonitor.getInstance().getStatistic(this.this$0.page, "imageLoadEnd"))) {
                    this.this$0.updateRenderStatistic("imageLoadEnd");
                }
                if (TextUtils.isEmpty(BeeRenderMonitor.getInstance().getStatistic(this.this$0.page, "onPageShow"))) {
                    BeeRenderMonitor.getInstance().updateStatistic(this.this$0.page, "onPageShow", BeeRenderMonitor.getInstance().getStatistic(this.this$0.page, "imageLoadEnd"));
                }
            } else if (TextUtils.isEmpty(BeeRenderMonitor.getInstance().getStatistic(this.this$0.page, "onPageShow"))) {
                if (!NetWorkUtils.isConnected(this.this$0.getContext())) {
                    BeeRenderMonitor.getInstance().changeStatus(this.this$0.page, "2");
                } else {
                    BeeRenderMonitor.getInstance().changeStatus(this.this$0.page, "3");
                }
            }
        }
        if (this.this$0.currentStage == this.this$0.MAX_STAGE) {
            BeeRenderMonitor.getInstance().uploadStatistic(this.this$0.page);
        }
    }
}
