package com.baidu.mms.voicesearch.voice.view.guide;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.mms.voicesearch.voice.view.guide.ShimmerFrameLayout;
import com.baidu.speechbundle.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\"J\u0006\u0010&\u001a\u00020\"J\u000e\u0010'\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u0003J\u0018\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\tH\u0014J\u000e\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020\tJ\u0006\u0010-\u001a\u00020\"R\u001a\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006."}, d2 = {"Lcom/baidu/mms/voicesearch/voice/view/guide/ShimmerLoading;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mHight", "getMHight", "()I", "setMHight", "(I)V", "mShimmerImage", "Landroid/widget/ImageView;", "getMShimmerImage", "()Landroid/widget/ImageView;", "setMShimmerImage", "(Landroid/widget/ImageView;)V", "mShimmerLayout", "Lcom/baidu/mms/voicesearch/voice/view/guide/ShimmerFrameLayout;", "getMShimmerLayout", "()Lcom/baidu/mms/voicesearch/voice/view/guide/ShimmerFrameLayout;", "setMShimmerLayout", "(Lcom/baidu/mms/voicesearch/voice/view/guide/ShimmerFrameLayout;)V", "mShimmerRoot", "getMShimmerRoot", "()Landroid/widget/LinearLayout;", "setMShimmerRoot", "(Landroid/widget/LinearLayout;)V", "changeSkin", "", "isNight", "", "destroyShimmerLoading", "hideShimmerLoading", "init", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setRootHeight", "height", "showShimmerLoading", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShimmerLoading.kt */
public final class ShimmerLoading extends LinearLayout {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private int mHight;
    private ImageView mShimmerImage;
    private ShimmerFrameLayout mShimmerLayout;
    private LinearLayout mShimmerRoot;

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

    public final LinearLayout getMShimmerRoot() {
        return this.mShimmerRoot;
    }

    public final void setMShimmerRoot(LinearLayout linearLayout) {
        this.mShimmerRoot = linearLayout;
    }

    public final ShimmerFrameLayout getMShimmerLayout() {
        return this.mShimmerLayout;
    }

    public final void setMShimmerLayout(ShimmerFrameLayout shimmerFrameLayout) {
        this.mShimmerLayout = shimmerFrameLayout;
    }

    public final ImageView getMShimmerImage() {
        return this.mShimmerImage;
    }

    public final void setMShimmerImage(ImageView imageView) {
        this.mShimmerImage = imageView;
    }

    public final int getMHight() {
        return this.mHight;
    }

    public final void setMHight(int i2) {
        this.mHight = i2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShimmerLoading(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShimmerLoading(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShimmerLoading(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context);
    }

    public final void init(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.shimmer_loading, this, true);
        this.mShimmerRoot = (LinearLayout) findViewById(R.id.shimmer_root);
        this.mShimmerLayout = (ShimmerFrameLayout) findViewById(R.id.shimmer_layout);
        this.mShimmerImage = (ImageView) findViewById(R.id.shimmer_image);
    }

    public final void showShimmerLoading() {
        LinearLayout linearLayout = this.mShimmerRoot;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        LinearLayout linearLayout2 = this.mShimmerRoot;
        if (linearLayout2 != null) {
            linearLayout2.bringToFront();
        }
        ShimmerFrameLayout shimmerFrameLayout = this.mShimmerLayout;
        if (shimmerFrameLayout != null) {
            shimmerFrameLayout.setMaskShape(ShimmerFrameLayout.MaskShape.WHITE_LINEAR);
        }
        ShimmerFrameLayout shimmerFrameLayout2 = this.mShimmerLayout;
        if (shimmerFrameLayout2 != null) {
            shimmerFrameLayout2.startShimmerAnimation();
        }
    }

    public final void hideShimmerLoading() {
        LinearLayout linearLayout = this.mShimmerRoot;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        ShimmerFrameLayout shimmerFrameLayout = this.mShimmerLayout;
        if (shimmerFrameLayout != null) {
            shimmerFrameLayout.stopShimmerAnimation();
        }
    }

    public final void destroyShimmerLoading() {
        ShimmerFrameLayout shimmerFrameLayout = this.mShimmerLayout;
        if (shimmerFrameLayout != null) {
            shimmerFrameLayout.stopShimmerAnimation();
        }
        this.mShimmerLayout = null;
        this.mShimmerRoot = null;
    }

    public final void setRootHeight(int height) {
        this.mHight = height;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.mHight > 0) {
            setMeasuredDimension(getMeasuredWidth(), this.mHight);
            this.mHight = 0;
        }
    }

    public final void changeSkin(boolean isNight) {
        if (isNight) {
            LinearLayout linearLayout = this.mShimmerRoot;
            if (linearLayout != null) {
                linearLayout.setBackgroundColor(getContext().getResources().getColor(R.color.voice_night_slide_bg_color));
            }
            ImageView imageView = this.mShimmerImage;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.shimmer_night_loading);
                return;
            }
            return;
        }
        LinearLayout linearLayout2 = this.mShimmerRoot;
        if (linearLayout2 != null) {
            linearLayout2.setBackgroundColor(getContext().getResources().getColor(R.color.voice_slide_bg_color));
        }
        ImageView imageView2 = this.mShimmerImage;
        if (imageView2 != null) {
            imageView2.setImageResource(R.drawable.shimmer_white_loading);
        }
    }
}
