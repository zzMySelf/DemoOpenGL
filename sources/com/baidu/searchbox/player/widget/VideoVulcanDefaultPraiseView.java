package com.baidu.searchbox.player.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.searchbox.player.control.model.PraiseInfo;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.videoplayer.widget.BdPressedImageView;
import com.baidu.searchbox.videoplayer.vulcan.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016H\u0016J@\u0010\u0019\u001a\u00020\u000f28\u0010\r\u001a4\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eJ\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010\u000b\u001a\u00020\fR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/player/widget/VideoVulcanDefaultPraiseView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/baidu/searchbox/player/widget/IVideoUnityPraiseView;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isPraised", "", "listener", "Lkotlin/Function2;", "", "praiseCount", "praiseTextView", "Landroid/widget/TextView;", "praiseView", "Lcom/baidu/searchbox/video/videoplayer/widget/BdPressedImageView;", "getView", "Landroid/view/View;", "onClick", "v", "setOnPraiseClickListener", "Lkotlin/ParameterName;", "name", "setPraiseInfo", "data", "Lcom/baidu/searchbox/player/control/model/PraiseInfo;", "setPraisedResource", "business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoVulcanDefaultPraiseView.kt */
public final class VideoVulcanDefaultPraiseView extends ConstraintLayout implements IVideoUnityPraiseView, View.OnClickListener {
    public Map<Integer, View> _$_findViewCache;
    private boolean isPraised;
    private Function2<? super Boolean, ? super Integer, Unit> listener;
    private int praiseCount;
    private final TextView praiseTextView;
    private final BdPressedImageView praiseView;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VideoVulcanDefaultPraiseView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VideoVulcanDefaultPraiseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
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
    public VideoVulcanDefaultPraiseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        View.inflate(context, R.layout.videoplayer_vulcan_praise_layout, this);
        View findViewById = findViewById(R.id.bd_video_praise);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.bd_video_praise)");
        BdPressedImageView bdPressedImageView = (BdPressedImageView) findViewById;
        this.praiseView = bdPressedImageView;
        View findViewById2 = findViewById(R.id.bd_video_praise_count);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.bd_video_praise_count)");
        this.praiseTextView = (TextView) findViewById2;
        bdPressedImageView.setOnClickListener(this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VideoVulcanDefaultPraiseView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public void setPraiseInfo(PraiseInfo data) {
        Intrinsics.checkNotNullParameter(data, "data");
        setPraisedResource(data.isPraised());
        this.praiseTextView.setText(BdPlayerUtils.toTextString(data.getPraiseCount()));
    }

    public View getView() {
        return this;
    }

    public void onClick(View v) {
        boolean z = this.isPraised;
        if (z) {
            int i2 = this.praiseCount;
            if (i2 > 0) {
                this.praiseCount = i2 - 1;
            }
        } else {
            this.praiseCount++;
        }
        boolean z2 = !z;
        this.isPraised = z2;
        setPraisedResource(z2);
        Function2<? super Boolean, ? super Integer, Unit> function2 = this.listener;
        if (function2 != null) {
            Unit invoke = function2.invoke(Boolean.valueOf(this.isPraised), Integer.valueOf(this.praiseCount));
        }
    }

    public static /* synthetic */ void setPraisedResource$default(VideoVulcanDefaultPraiseView videoVulcanDefaultPraiseView, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        videoVulcanDefaultPraiseView.setPraisedResource(z);
    }

    public final void setPraisedResource(boolean isPraised2) {
        if (isPraised2) {
            this.praiseView.setImageResource(R.drawable.videoplayer_vulcan_control_praise);
        } else {
            this.praiseView.setImageResource(R.drawable.videoplayer_vulcan_control_unpraise);
        }
    }

    public final void setOnPraiseClickListener(Function2<? super Boolean, ? super Integer, Unit> listener2) {
        Intrinsics.checkNotNullParameter(listener2, "listener");
        this.listener = listener2;
    }
}
