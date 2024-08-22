package com.baidu.growthsystem.wealth.scrollguide.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.growthsystem.business.wealthtask.R;
import com.baidu.growthsystem.wealth.scrollguide.model.WealthVideoScrollUpGuideModel;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGView;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B-\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0013R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/baidu/growthsystem/wealth/scrollguide/ui/WealthVideoScrollUpGuideView;", "Landroid/widget/FrameLayout;", "model", "Lcom/baidu/growthsystem/wealth/scrollguide/model/WealthVideoScrollUpGuideModel;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Lcom/baidu/growthsystem/wealth/scrollguide/model/WealthVideoScrollUpGuideModel;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "firstLineTextView", "Landroid/widget/TextView;", "pagView", "Lorg/libpag/PAGView;", "secondLineIconView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "secondLineTextView", "initUI", "", "playAnimation", "stopAnimation", "wealth-task-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WealthVideoScrollUpGuideView.kt */
public final class WealthVideoScrollUpGuideView extends FrameLayout {
    public Map<Integer, View> _$_findViewCache;
    private final TextView firstLineTextView;
    private final WealthVideoScrollUpGuideModel model;
    private final PAGView pagView;
    private final SimpleDraweeView secondLineIconView;
    private final TextView secondLineTextView;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WealthVideoScrollUpGuideView(WealthVideoScrollUpGuideModel wealthVideoScrollUpGuideModel, Context context) {
        this(wealthVideoScrollUpGuideModel, context, (AttributeSet) null, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(wealthVideoScrollUpGuideModel, "model");
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WealthVideoScrollUpGuideView(WealthVideoScrollUpGuideModel wealthVideoScrollUpGuideModel, Context context, AttributeSet attributeSet) {
        this(wealthVideoScrollUpGuideModel, context, attributeSet, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(wealthVideoScrollUpGuideModel, "model");
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WealthVideoScrollUpGuideView(WealthVideoScrollUpGuideModel model2, Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(model2, "model");
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.model = model2;
        LayoutInflater.from(context).inflate(R.layout.wealth_video_scroll_up_guide, this);
        View findViewById = findViewById(R.id.wealth_video_scroll_up_guide_pag);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.wealth…ideo_scroll_up_guide_pag)");
        this.pagView = (PAGView) findViewById;
        View findViewById2 = findViewById(R.id.wealth_video_scroll_up_guide_first_line_text);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.wealth…up_guide_first_line_text)");
        this.firstLineTextView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.wealth_video_scroll_up_guide_second_line_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.wealth…p_guide_second_line_icon)");
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById3;
        this.secondLineIconView = simpleDraweeView;
        View findViewById4 = findViewById(R.id.wealth_video_scroll_up_guide_second_line_text);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.wealth…p_guide_second_line_text)");
        this.secondLineTextView = (TextView) findViewById4;
        ((GenericDraweeHierarchy) simpleDraweeView.getHierarchy()).setUseGlobalColorFilter(false);
        initUI();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WealthVideoScrollUpGuideView(WealthVideoScrollUpGuideModel wealthVideoScrollUpGuideModel, Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(wealthVideoScrollUpGuideModel, context, (i3 & 4) != 0 ? null : attributeSet, (i3 & 8) != 0 ? 0 : i2);
    }

    public final void playAnimation() {
        if (!this.pagView.isPlaying()) {
            this.pagView.play();
        }
    }

    public final void stopAnimation() {
        if (this.pagView.isPlaying()) {
            this.pagView.stop();
        }
    }

    private final void initUI() {
        this.pagView.setPath("assets://wealth_video_scroll_guide.pag");
        this.pagView.setRepeatCount(-1);
        this.firstLineTextView.setText(this.model.getFirstLineText());
        this.secondLineIconView.setImageURI(this.model.getSecondLineIconUrl());
        this.secondLineTextView.setText(this.model.getSecondLineText());
    }
}
