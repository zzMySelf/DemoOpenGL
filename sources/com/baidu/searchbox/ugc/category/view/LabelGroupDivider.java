package com.baidu.searchbox.ugc.category.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.common.ui.style.R;
import com.baidu.searchbox.favor.data.FavorModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/ugc/category/view/LabelGroupDivider;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onDraw", "", "c", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "lib-ugc-core_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LabelGroupView.kt */
public final class LabelGroupDivider extends RecyclerView.ItemDecoration {
    private final Context context;

    public LabelGroupDivider(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public void onDraw(Canvas c2, RecyclerView parent, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(c2, "c");
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        Intrinsics.checkNotNullParameter(state, "state");
        super.onDraw(c2, parent, state);
        float left = (float) parent.getPaddingLeft();
        float right = (float) parent.getWidth();
        int childCount = parent.getChildCount();
        for (int index = 0; index < childCount; index++) {
            float top = (float) parent.getChildAt(index).getBottom();
            Paint $this$onDraw_u24lambda_u2d0 = new Paint();
            $this$onDraw_u24lambda_u2d0.setColor(ContextCompat.getColor(this.context, R.color.GC34));
            Unit unit = Unit.INSTANCE;
            c2.drawRect(left, top, right, top + 1.0f, $this$onDraw_u24lambda_u2d0);
        }
    }
}
