package fe.fe.ddd.rrr;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.widget.CustomSlidingPanelLayout;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlidingPaneLayout;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public View f1582ad;
    public SlidingPaneLayout qw;

    public qw() {
        this(true);
    }

    public void ad(boolean z) {
        SlidingPaneLayout slidingPaneLayout = this.qw;
        if (slidingPaneLayout != null && (slidingPaneLayout instanceof CustomSlidingPanelLayout)) {
            slidingPaneLayout.forceActivityTransparent(z);
        }
    }

    public Drawable de(Context context, String str) {
        Bitmap decodeFile;
        if (context == null || TextUtils.isEmpty(str) || (decodeFile = BitmapFactory.decodeFile(str)) == null) {
            return null;
        }
        byte[] ninePatchChunk = decodeFile.getNinePatchChunk();
        if (NinePatch.isNinePatchChunk(ninePatchChunk)) {
            return new NinePatchDrawable(context.getResources(), decodeFile, ninePatchChunk, new Rect(), (String) null);
        }
        return new BitmapDrawable(context.getResources(), decodeFile);
    }

    public View fe() {
        return this.f1582ad;
    }

    public void qw(Activity activity) {
        if (activity != null) {
            View findViewById = activity.findViewById(16908290);
            boolean isFocused = findViewById.isFocused();
            ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
            viewGroup.removeView(findViewById);
            if (this.f1582ad == null) {
                View view = new View(activity);
                this.f1582ad = view;
                view.setBackgroundColor(Color.parseColor("#40000000"));
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            CustomSlidingPanelLayout customSlidingPanelLayout = new CustomSlidingPanelLayout(activity);
            this.qw = customSlidingPanelLayout;
            customSlidingPanelLayout.setShadowDrawable(de(activity, "sliding_layout_shadow.9.png"));
            this.qw.addView(this.f1582ad, layoutParams);
            this.qw.addView(findViewById, layoutParams);
            this.qw.setSliderFadeColor(0);
            viewGroup.addView(this.qw);
            if (isFocused) {
                this.qw.requestFocus();
            }
            this.qw.attachActivity(activity);
        }
    }

    public void rg(boolean z) {
        SlidingPaneLayout slidingPaneLayout = this.qw;
        if (slidingPaneLayout != null && (slidingPaneLayout instanceof CustomSlidingPanelLayout)) {
            ((CustomSlidingPanelLayout) slidingPaneLayout).setCanSlidable(z);
        }
    }

    public void th(Drawable drawable) {
        SlidingPaneLayout slidingPaneLayout = this.qw;
        if (slidingPaneLayout != null) {
            slidingPaneLayout.setShadowDrawable(drawable);
        }
    }

    public void uk(SlidingPaneLayout.PanelSlideListener panelSlideListener) {
        SlidingPaneLayout slidingPaneLayout = this.qw;
        if (slidingPaneLayout != null && panelSlideListener != null) {
            slidingPaneLayout.setPanelSlideListener(panelSlideListener);
        }
    }

    public void yj(SlideInterceptor slideInterceptor) {
        SlidingPaneLayout slidingPaneLayout;
        if (slideInterceptor != null && (slidingPaneLayout = this.qw) != null && (slidingPaneLayout instanceof CustomSlidingPanelLayout)) {
            ((CustomSlidingPanelLayout) slidingPaneLayout).setSlideInterceptor(slideInterceptor);
        }
    }

    public qw(boolean z) {
    }
}
