package com.baidu.swan.games.view.recommend.listmode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.swan.game.R;

public class ListRecommendDivider extends RecyclerView.ItemDecoration {
    private int mDividerHeight;
    private int mDividerMargin;
    private Paint mDividerPaint;

    public ListRecommendDivider(Context context) {
        Resources res = context.getResources();
        this.mDividerHeight = res.getDimensionPixelSize(R.dimen.swangame_recommend_dialog_list_divider_height);
        this.mDividerMargin = res.getDimensionPixelSize(R.dimen.swangame_recommend_dialog_list_divider_margin);
        Paint paint = new Paint();
        this.mDividerPaint = paint;
        paint.setColor(res.getColor(R.color.swangame_recommend_dialog_list_divider));
    }

    public void getItemOffsets(Rect outRect, View view2, RecyclerView parent, RecyclerView.State state) {
        outRect.set(0, 0, 0, this.mDividerHeight);
    }

    public void onDraw(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        int itemCount = parent.getAdapter().getItemCount();
        for (int i2 = 0; i2 < itemCount; i2++) {
            View view2 = parent.getChildAt(i2);
            if (!(view2 == null || parent.getChildAdapterPosition(view2) == itemCount - 1)) {
                canvas.drawRect((float) this.mDividerMargin, (float) view2.getBottom(), (float) (view2.getWidth() - this.mDividerMargin), (float) (view2.getBottom() + this.mDividerHeight), this.mDividerPaint);
            }
        }
    }
}
