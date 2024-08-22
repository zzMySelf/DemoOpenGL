package com.baidu.searchbox.comment.input.aiimage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.comment.CommentRuntime;
import com.baidu.searchbox.comment.R;
import com.baidu.searchbox.comment.util.DrawableCreator;
import com.baidu.searchbox.kotlinx.ViewExtensionsKt;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.ShimmerFrameLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGImageView;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001#B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\nH\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0012J\u0016\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u001fJ\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u001fH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/baidu/searchbox/comment/input/aiimage/AiPicButton;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "guideAnimView", "Lorg/libpag/PAGImageView;", "imageview", "Landroid/widget/ImageView;", "getImageview", "()Landroid/widget/ImageView;", "setImageview", "(Landroid/widget/ImageView;)V", "lastStats", "Lcom/baidu/searchbox/comment/input/aiimage/AiPicButton$ButtonType;", "normalDrawable", "Landroid/graphics/drawable/Drawable;", "selectDrawable", "initBg", "", "initGuideAnimView", "initTextView", "initialize", "resetLastButtonStatus", "type", "setButtonConf", "isModuleShow", "", "setImageDrawable", "selected", "showLottie", "ButtonType", "lib-comment-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiPicButton.kt */
public final class AiPicButton extends FrameLayout {
    public Map<Integer, View> _$_findViewCache;
    private PAGImageView guideAnimView;
    private ImageView imageview;
    private ButtonType lastStats;
    private Drawable normalDrawable;
    private Drawable selectDrawable;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/comment/input/aiimage/AiPicButton$ButtonType;", "", "(Ljava/lang/String;I)V", "NONE", "DEFAULT", "ENABLED", "SELECTED", "ENABLED_GUIDE", "lib-comment-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AiPicButton.kt */
    public enum ButtonType {
        NONE,
        DEFAULT,
        ENABLED,
        SELECTED,
        ENABLED_GUIDE
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AiPicButton.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ButtonType.values().length];
            iArr[ButtonType.ENABLED.ordinal()] = 1;
            iArr[ButtonType.SELECTED.ordinal()] = 2;
            iArr[ButtonType.ENABLED_GUIDE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AiPicButton(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AiPicButton(Context context, AttributeSet attributeSet) {
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
    public AiPicButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.lastStats = ButtonType.NONE;
        initialize();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AiPicButton(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final ImageView getImageview() {
        return this.imageview;
    }

    public final void setImageview(ImageView imageView) {
        this.imageview = imageView;
    }

    private final void initialize() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewExtensionsKt.getDimensionPixelSize(this, R.dimen.comment_dimen_61dp), ViewExtensionsKt.getDimensionPixelSize(this, R.dimen.comment_dimen_27dp));
        LinearLayout.LayoutParams $this$initialize_u24lambda_u2d0 = layoutParams;
        $this$initialize_u24lambda_u2d0.rightMargin = ViewExtensionsKt.getDimensionPixelSize(this, R.dimen.comment_dimen_9dp);
        $this$initialize_u24lambda_u2d0.gravity = 17;
        setLayoutParams(layoutParams);
        setClickable(true);
        this.imageview = initTextView();
        this.guideAnimView = initGuideAnimView();
        ShimmerFrameLayout shimmerView = new ShimmerFrameLayout(getContext());
        ShimmerFrameLayout $this$initialize_u24lambda_u2d3 = shimmerView;
        FrameLayout.LayoutParams $this$initialize_u24lambda_u2d3_u24lambda_u2d1 = new FrameLayout.LayoutParams($this$initialize_u24lambda_u2d3.getContext().getResources().getDimensionPixelSize(R.dimen.comment_dimen_45dp), $this$initialize_u24lambda_u2d3.getContext().getResources().getDimensionPixelSize(R.dimen.comment_dimen_15dp));
        $this$initialize_u24lambda_u2d3_u24lambda_u2d1.gravity = 17;
        $this$initialize_u24lambda_u2d3.setLayoutParams($this$initialize_u24lambda_u2d3_u24lambda_u2d1);
        $this$initialize_u24lambda_u2d3.addView(this.imageview);
        $this$initialize_u24lambda_u2d3.setRepeatCount(-1);
        $this$initialize_u24lambda_u2d3.post(new AiPicButton$$ExternalSyntheticLambda0($this$initialize_u24lambda_u2d3));
        $this$initialize_u24lambda_u2d3.setIntensity(1.0f);
        $this$initialize_u24lambda_u2d3.setMaskShape(ShimmerFrameLayout.MaskShape.WHITE_LINEAR);
        $this$initialize_u24lambda_u2d3.setAutoStart(true);
        addView(shimmerView);
        addView(this.guideAnimView);
        setButtonConf(ButtonType.DEFAULT, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: initialize$lambda-3$lambda-2  reason: not valid java name */
    public static final void m16805initialize$lambda3$lambda2(ShimmerFrameLayout $this_apply) {
        Intrinsics.checkNotNullParameter($this_apply, "$this_apply");
        $this_apply.startShimmerAnimation();
    }

    public final void setButtonConf(ButtonType type, boolean isModuleShow) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (this.lastStats == type) {
            return;
        }
        if (!isModuleShow || type != ButtonType.ENABLED) {
            if (this.normalDrawable == null || this.selectDrawable == null) {
                initBg();
            }
            switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 1:
                    setBackground(this.normalDrawable);
                    showLottie(true);
                    break;
                case 2:
                    setBackground(this.selectDrawable);
                    showLottie(false);
                    setImageDrawable(true);
                    break;
                case 3:
                    setBackground(this.normalDrawable);
                    showLottie(true);
                    break;
                default:
                    setBackground(this.normalDrawable);
                    showLottie(false);
                    setImageDrawable(false);
                    break;
            }
            this.lastStats = type;
        }
    }

    public final void resetLastButtonStatus(ButtonType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        setButtonConf(type, false);
    }

    private final void showLottie(boolean showLottie) {
        float f2;
        if (showLottie) {
            PAGImageView $this$showLottie_u24lambda_u2d4 = this.guideAnimView;
            if ($this$showLottie_u24lambda_u2d4 != null) {
                $this$showLottie_u24lambda_u2d4.setVisibility(0);
                $this$showLottie_u24lambda_u2d4.setPath("assets://bdcomment_aipic_day_icon.pag");
                if (NightModeHelper.getNightModeSwitcherState()) {
                    f2 = 0.8f;
                } else {
                    f2 = 1.0f;
                }
                $this$showLottie_u24lambda_u2d4.setAlpha(f2);
                $this$showLottie_u24lambda_u2d4.setRepeatCount(-1);
                $this$showLottie_u24lambda_u2d4.play();
            }
            ImageView $this$makeGone$iv = this.imageview;
            if ($this$makeGone$iv != null) {
                $this$makeGone$iv.setVisibility(8);
                return;
            }
            return;
        }
        PAGImageView $this$makeGone$iv2 = this.guideAnimView;
        if ($this$makeGone$iv2 != null) {
            $this$makeGone$iv2.setVisibility(8);
        }
        ImageView $this$makeVisible$iv = this.imageview;
        if ($this$makeVisible$iv != null) {
            $this$makeVisible$iv.setVisibility(0);
        }
    }

    public final void setImageDrawable(boolean selected) {
        int drawableRes = selected ? R.drawable.bdcomment_ai_pair_char_enabled : R.drawable.bdcomment_ai_pair_char_normal;
        ImageView imageView = this.imageview;
        if (imageView != null) {
            imageView.setImageDrawable(ContextCompat.getDrawable(CommentRuntime.getAppContext(), drawableRes));
        }
    }

    private final ImageView initTextView() {
        FrameLayout.LayoutParams imageParams = new FrameLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.comment_dimen_45dp), getContext().getResources().getDimensionPixelSize(R.dimen.comment_dimen_15dp));
        imageParams.gravity = 17;
        ImageView imageView = new ImageView(getContext());
        this.imageview = imageView;
        com.baidu.searchbox.comment.util.ViewExtensionsKt.setLayoutGravity(imageView, 17);
        ImageView imageView2 = this.imageview;
        if (imageView2 != null) {
            imageView2.setLayoutParams(imageParams);
        }
        ImageView imageView3 = this.imageview;
        if (imageView3 != null) {
            imageView3.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        return this.imageview;
    }

    private final PAGImageView initGuideAnimView() {
        PAGImageView pAGImageView = new PAGImageView(getContext());
        PAGImageView $this$initGuideAnimView_u24lambda_u2d7 = pAGImageView;
        FrameLayout.LayoutParams $this$initGuideAnimView_u24lambda_u2d7_u24lambda_u2d6 = new FrameLayout.LayoutParams(ViewExtensionsKt.getDimensionPixelSize($this$initGuideAnimView_u24lambda_u2d7, R.dimen.comment_dimen_45dp), ViewExtensionsKt.getDimensionPixelSize($this$initGuideAnimView_u24lambda_u2d7, R.dimen.comment_dimen_15dp));
        $this$initGuideAnimView_u24lambda_u2d7_u24lambda_u2d6.gravity = 17;
        $this$initGuideAnimView_u24lambda_u2d7.setLayoutParams($this$initGuideAnimView_u24lambda_u2d7_u24lambda_u2d6);
        com.baidu.searchbox.comment.util.ViewExtensionsKt.setLayoutGravity($this$initGuideAnimView_u24lambda_u2d7, 17);
        return pAGImageView;
    }

    private final void initBg() {
        float radius = ViewExtensionsKt.getDimension(this, R.dimen.comment_dimen_13dp);
        int strokeColor = ContextCompat.getColor(CommentRuntime.getAppContext(), com.baidu.searchbox.interaction.styles.R.color.IC19);
        int strokeWidth = ViewExtensionsKt.getDimensionPixelSize(this, R.dimen.dimens_1px);
        int selectBgColor = ContextCompat.getColor(CommentRuntime.getAppContext(), R.color.comment_input_ai_button_select_bg);
        this.normalDrawable = new DrawableCreator.Builder().setRadius(radius).setStrokeColor(strokeColor).setStrokeWidth(strokeWidth).createDrawable();
        this.selectDrawable = new DrawableCreator.Builder().setRadius(radius).setStrokeColor(strokeColor).setStrokeWidth(strokeWidth).setSolidColor(selectBgColor).createDrawable();
    }
}
