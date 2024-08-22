package com.baidu.searchbox.home.tips.newhome;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.searchbox.home.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/home/tips/newhome/NewHomeTipsContainer;", "Landroid/widget/FrameLayout;", "Lcom/baidu/searchbox/home/tips/newhome/NewHomeClickPosition;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mCloseView", "Landroid/view/View;", "onClick", "", "event", "Landroid/view/MotionEvent;", "lib-home-header_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NewHomeTipsContainer.kt */
public final class NewHomeTipsContainer extends FrameLayout implements NewHomeClickPosition {
    public Map<Integer, View> _$_findViewCache;
    private View mCloseView;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NewHomeTipsContainer(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NewHomeTipsContainer(Context context, AttributeSet attributeSet) {
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
    public NewHomeTipsContainer(Context context, AttributeSet attr, int defStyleAttr) {
        super(context, attr, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NewHomeTipsContainer(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public void onClick(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.mCloseView == null) {
            this.mCloseView = findViewById(R.id.home_tips_close);
        }
        View $this$onClick_u24lambda_u2d0 = this.mCloseView;
        if ($this$onClick_u24lambda_u2d0 != null) {
            if (($this$onClick_u24lambda_u2d0.getVisibility() == 0 ? 1 : null) != null) {
                int[] closePosition = new int[2];
                $this$onClick_u24lambda_u2d0.getLocationOnScreen(closePosition);
                if (event.getRawX() >= ((float) closePosition[0]) && event.getRawX() <= ((float) (closePosition[0] + $this$onClick_u24lambda_u2d0.getWidth())) && event.getRawY() >= ((float) closePosition[1]) && event.getRawY() <= ((float) (closePosition[1] + $this$onClick_u24lambda_u2d0.getHeight()))) {
                    $this$onClick_u24lambda_u2d0.performClick();
                    return;
                }
            }
        }
        performClick();
    }
}
