package com.baidu.searchbox.personal.feed;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.personalcenter.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0014J\u0006\u0010\u001b\u001a\u00020\u0017J\u0006\u0010\u001c\u001a\u00020\u0017R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/personal/feed/FooterLoadingViewHolder;", "Lcom/baidu/searchbox/personal/feed/VideoCollectionViewHolder;", "mContext", "Landroid/content/Context;", "itemView", "Landroid/view/View;", "(Landroid/content/Context;Landroid/view/View;)V", "arrowSize", "", "getArrowSize", "()I", "arrowSize$delegate", "Lkotlin/Lazy;", "mArrowImageView", "Landroid/widget/ImageView;", "mGotoMore", "Landroid/widget/TextView;", "mMatrix", "Landroid/graphics/Matrix;", "mRotationPivotX", "", "mRotationPivotY", "onFontSizeChanged", "", "onNightModeChanged", "onPull", "scrollOffset", "populate", "reset", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FooterLoadingViewHolder.kt */
public final class FooterLoadingViewHolder extends VideoCollectionViewHolder {
    private final Lazy arrowSize$delegate = LazyKt.lazy(new FooterLoadingViewHolder$arrowSize$2(this));
    private final ImageView mArrowImageView;
    /* access modifiers changed from: private */
    public final Context mContext;
    private final TextView mGotoMore;
    private Matrix mMatrix;
    private float mRotationPivotX;
    private float mRotationPivotY;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FooterLoadingViewHolder(Context mContext2, View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(mContext2, "mContext");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.mContext = mContext2;
        View findViewById = itemView.findViewById(R.id.goto_more);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.goto_more)");
        this.mGotoMore = (TextView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.indicator_arrow);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.indicator_arrow)");
        this.mArrowImageView = (ImageView) findViewById2;
        populate();
    }

    private final int getArrowSize() {
        return ((Number) this.arrowSize$delegate.getValue()).intValue();
    }

    private final void onFontSizeChanged() {
        FontSizeViewExtKt.setScaledSize$default(this.mArrowImageView, 0, (float) getArrowSize(), (float) getArrowSize(), 0, 8, (Object) null);
        FontSizeTextViewExtKt.setScaledSize$default(this.mGotoMore, 0, 1, 12.0f, 0, 8, (Object) null);
        ViewGroup.LayoutParams params = this.itemView.getLayoutParams();
        params.width = (int) FontSizeHelper.getScaledSize(0, this.mContext.getResources().getDimension(R.dimen.personal_user_pull_max_size));
        params.height = -1;
        this.itemView.setLayoutParams(params);
    }

    private final void onNightModeChanged() {
        this.itemView.setBackground(ResourcesCompat.getDrawable(this.mContext.getResources(), R.drawable.personal_page_video_collection_bg, (Resources.Theme) null));
        this.mGotoMore.setTextColor(this.mContext.getResources().getColor(com.baidu.android.common.ui.style.R.color.GC4));
        Bitmap bmp = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.indicator_arrow);
        Intrinsics.checkNotNullExpressionValue(bmp, "decodeResource(mContext.…drawable.indicator_arrow)");
        Matrix matrix = new Matrix();
        float scaledRatio = FontSizeHelper.getScaledRatio(0);
        matrix.postScale(scaledRatio, scaledRatio);
        Bitmap alteredBitmap = Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), bmp.getHeight(), matrix, true);
        Intrinsics.checkNotNullExpressionValue(alteredBitmap, "createBitmap(bmp, 0, 0, …bmp.height, matrix, true)");
        this.mArrowImageView.setImageBitmap(alteredBitmap);
        this.mArrowImageView.setScaleType(ImageView.ScaleType.MATRIX);
        this.mMatrix = new Matrix();
        this.mRotationPivotX = ((float) alteredBitmap.getWidth()) / 2.0f;
        float height = ((float) alteredBitmap.getHeight()) / 2.0f;
        this.mRotationPivotY = height;
        Matrix matrix2 = this.mMatrix;
        if (matrix2 != null) {
            matrix2.setRotate(0.0f, this.mRotationPivotX, height);
        }
        this.mArrowImageView.setImageMatrix(this.mMatrix);
    }

    public final void populate() {
        onFontSizeChanged();
        onNightModeChanged();
    }

    public final void onPull(float scrollOffset) {
        int contentSize = (int) FontSizeHelper.getScaledSize(0, this.mContext.getResources().getDimension(R.dimen.personal_user_pull_can_router_size));
        int width = this.mArrowImageView.getWidth() + this.mContext.getResources().getDimensionPixelSize(R.dimen.personal_user_pull_arrow_margin_left) + this.mContext.getResources().getDimensionPixelSize(R.dimen.personal_user_pull_arrow_margin_right);
        if (scrollOffset > ((float) width)) {
            float angle = ((scrollOffset - ((float) width)) / ((float) (contentSize - width))) * 180.0f;
            if (angle >= 180.0f) {
                angle = 180.0f;
                this.mGotoMore.setText(this.mContext.getResources().getString(R.string.personal_user_goto_more_text));
                ViewGroup.LayoutParams layoutParams = this.mArrowImageView.getLayoutParams();
                LinearLayout.LayoutParams it = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
                if (it != null) {
                    it.leftMargin = (int) (((double) this.mContext.getResources().getDimension(R.dimen.personal_user_pull_arrow_margin_left)) + (((double) (scrollOffset - ((float) contentSize))) * 0.66d));
                }
            } else {
                this.mGotoMore.setText(this.mContext.getResources().getString(R.string.personal_user_left_scroll_text));
            }
            Matrix matrix = this.mMatrix;
            if (matrix != null) {
                matrix.setRotate(angle, this.mRotationPivotX, this.mRotationPivotY);
            }
            this.mArrowImageView.setImageMatrix(this.mMatrix);
        }
    }

    public final void reset() {
        Matrix matrix = this.mMatrix;
        if (matrix != null) {
            matrix.setRotate(0.0f, this.mRotationPivotX, this.mRotationPivotY);
        }
        this.mArrowImageView.setImageMatrix(this.mMatrix);
        this.mGotoMore.setText(this.mContext.getResources().getString(R.string.personal_user_left_scroll_text));
        ViewGroup.LayoutParams layoutParams = this.mArrowImageView.getLayoutParams();
        LinearLayout.LayoutParams it = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
        if (it != null) {
            it.leftMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.personal_user_pull_arrow_margin_left);
        }
    }
}
