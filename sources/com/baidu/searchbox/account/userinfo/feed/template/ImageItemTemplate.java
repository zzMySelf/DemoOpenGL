package com.baidu.searchbox.account.userinfo.feed.template;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.android.ext.widget.BdListPopupWindow;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.account.userinfo.R;
import com.baidu.searchbox.account.userinfo.data.PPImageEntity;
import com.baidu.searchbox.account.userinfo.utils.PersonalPageExtensionsKt;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.eventmessage.FontSizeChangeMessage;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.BdBaseImageView;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 B2\u00020\u0001:\u0001BB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010:\u001a\u00020(H\u0014J\b\u0010;\u001a\u00020(H\u0014J\b\u0010<\u001a\u00020(H\u0002J\b\u0010=\u001a\u00020(H\u0002J\b\u0010>\u001a\u00020(H\u0002J\u0016\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u00020\u00132\u0006\u0010A\u001a\u00020/R\u001a\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R'\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\"\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R7\u0010-\u001a\u001f\u0012\u0013\u0012\u00110/¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020(\u0018\u00010.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u000e\u00107\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/baidu/searchbox/account/userinfo/feed/template/ImageItemTemplate;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cardWidth", "getCardWidth", "()I", "setCardWidth", "(I)V", "cover", "Lcom/facebook/drawee/view/SimpleDraweeView;", "data", "Lcom/baidu/searchbox/account/userinfo/data/PPImageEntity;", "getData", "()Lcom/baidu/searchbox/account/userinfo/data/PPImageEntity;", "setData", "(Lcom/baidu/searchbox/account/userinfo/data/PPImageEntity;)V", "imageCardHeightMap", "", "getImageCardHeightMap", "()Ljava/util/Map;", "imageCardHeightMap$delegate", "Lkotlin/Lazy;", "indexIcon", "Lcom/baidu/searchbox/ui/BdBaseImageView;", "indexLayout", "Landroid/widget/LinearLayout;", "indexText", "Landroid/widget/TextView;", "moreIcon", "Landroid/widget/ImageView;", "onItemClick", "Lkotlin/Function0;", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function0;", "setOnItemClick", "(Lkotlin/jvm/functions/Function0;)V", "onTopMenuClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isCancel", "getOnTopMenuClick", "()Lkotlin/jvm/functions/Function1;", "setOnTopMenuClick", "(Lkotlin/jvm/functions/Function1;)V", "topIcon", "topLayout", "Landroid/widget/RelativeLayout;", "onAttachedToWindow", "onDetachedFromWindow", "onFontSizeChanged", "onNightModeChanged", "showMenu", "updateTemplate", "entity", "isSelf", "Companion", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageItemTemplate.kt */
public final class ImageItemTemplate extends FrameLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float HORIZONTAL_IMAGE_V_RATIO = 0.6666667f;
    private static final float VERTICAL_IMAGE_V_RATIO = 1.7777778f;
    public Map<Integer, View> _$_findViewCache;
    private int cardWidth;
    private final SimpleDraweeView cover;
    private PPImageEntity data;
    private final Lazy imageCardHeightMap$delegate;
    private final BdBaseImageView indexIcon;
    private final LinearLayout indexLayout;
    private final TextView indexText;
    private final ImageView moreIcon;
    private Function0<Unit> onItemClick;
    private Function1<? super Boolean, Unit> onTopMenuClick;
    private TextView topIcon;
    private RelativeLayout topLayout;

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

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/account/userinfo/feed/template/ImageItemTemplate$Companion;", "", "()V", "HORIZONTAL_IMAGE_V_RATIO", "", "VERTICAL_IMAGE_V_RATIO", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImageItemTemplate.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final PPImageEntity getData() {
        return this.data;
    }

    public final void setData(PPImageEntity pPImageEntity) {
        this.data = pPImageEntity;
    }

    public final Function1<Boolean, Unit> getOnTopMenuClick() {
        return this.onTopMenuClick;
    }

    public final void setOnTopMenuClick(Function1<? super Boolean, Unit> function1) {
        this.onTopMenuClick = function1;
    }

    public final Function0<Unit> getOnItemClick() {
        return this.onItemClick;
    }

    public final void setOnItemClick(Function0<Unit> function0) {
        this.onItemClick = function0;
    }

    public final int getCardWidth() {
        return this.cardWidth;
    }

    public final void setCardWidth(int i2) {
        this.cardWidth = i2;
    }

    private final Map<Integer, Integer> getImageCardHeightMap() {
        return (Map) this.imageCardHeightMap$delegate.getValue();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ImageItemTemplate(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ImageItemTemplate(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageItemTemplate(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context2, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.imageCardHeightMap$delegate = LazyKt.lazy(new ImageItemTemplate$imageCardHeightMap$2(this));
        SimpleDraweeView simpleDraweeView = new SimpleDraweeView(getContext());
        this.cover = simpleDraweeView;
        float corner = getResources().getDimension(R.dimen.personal_page_image_item_radius);
        GenericDraweeHierarchyBuilder newInstance = GenericDraweeHierarchyBuilder.newInstance(getResources());
        RoundingParams roundingParams = new RoundingParams();
        RoundingParams $this$_init__u24lambda_u2d0 = roundingParams;
        $this$_init__u24lambda_u2d0.setBorder(Color.parseColor("#0F000000"), 1.0f);
        $this$_init__u24lambda_u2d0.setCornersRadii(corner, corner, corner, corner);
        Unit unit = Unit.INSTANCE;
        simpleDraweeView.setHierarchy(newInstance.setRoundingParams(roundingParams).build());
        GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) simpleDraweeView.getHierarchy();
        if (genericDraweeHierarchy != null) {
            genericDraweeHierarchy.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        }
        GenericDraweeHierarchy genericDraweeHierarchy2 = (GenericDraweeHierarchy) simpleDraweeView.getHierarchy();
        if (genericDraweeHierarchy2 != null) {
            genericDraweeHierarchy2.setPlaceholderImage(ContextCompat.getDrawable(context2, R.drawable.feed_card_place_holder));
        }
        addView(simpleDraweeView, -2, -2);
        int hPadding = getResources().getDimensionPixelOffset(R.dimen.personal_page_image_item_h_padding);
        int vPadding = getResources().getDimensionPixelOffset(R.dimen.personal_page_image_item_v_margin);
        RelativeLayout relativeLayout = new RelativeLayout(context2);
        RelativeLayout $this$_init__u24lambda_u2d1 = relativeLayout;
        $this$_init__u24lambda_u2d1.setGravity(16);
        $this$_init__u24lambda_u2d1.setPadding(hPadding, vPadding, hPadding, vPadding);
        this.topLayout = relativeLayout;
        TextView textView = new TextView(context2);
        TextView $this$_init__u24lambda_u2d3 = textView;
        $this$_init__u24lambda_u2d3.setVisibility(8);
        $this$_init__u24lambda_u2d3.setIncludeFontPadding(false);
        $this$_init__u24lambda_u2d3.setText($this$_init__u24lambda_u2d3.getResources().getString(R.string.video_menu_top));
        $this$_init__u24lambda_u2d3.setBackground(ContextCompat.getDrawable(context2, R.drawable.item_top_icon_bg));
        int hTopPadding = DeviceUtils.ScreenInfo.dp2px(context2, 3.0f);
        int vTopPadding = DeviceUtils.ScreenInfo.dp2px(context2, 2.0f);
        $this$_init__u24lambda_u2d3.setPadding(hTopPadding, vTopPadding, hTopPadding, vTopPadding);
        $this$_init__u24lambda_u2d3.setTextColor(ContextCompat.getColor(context2, com.baidu.android.common.ui.style.R.color.BC60));
        TextPaint $this$_init__u24lambda_u2d3_u24lambda_u2d2 = $this$_init__u24lambda_u2d3.getPaint();
        $this$_init__u24lambda_u2d3_u24lambda_u2d2.setStyle(Paint.Style.FILL_AND_STROKE);
        $this$_init__u24lambda_u2d3_u24lambda_u2d2.setStrokeWidth(0.6f);
        this.topIcon = textView;
        ImageView imageView = new ImageView(context2);
        ImageView $this$_init__u24lambda_u2d4 = imageView;
        $this$_init__u24lambda_u2d4.setVisibility(8);
        $this$_init__u24lambda_u2d4.setScaleType(ImageView.ScaleType.CENTER_CROP);
        $this$_init__u24lambda_u2d4.setImageResource(R.drawable.video_item_more_icon);
        this.moreIcon = imageView;
        imageView.setOnClickListener(new ImageItemTemplate$$ExternalSyntheticLambda2(this));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        RelativeLayout.LayoutParams $this$_init__u24lambda_u2d6 = layoutParams;
        $this$_init__u24lambda_u2d6.addRule(15);
        $this$_init__u24lambda_u2d6.addRule(9);
        Unit unit2 = Unit.INSTANCE;
        this.topLayout.addView(this.topIcon, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.personal_page_image_item_more_icon_width), getResources().getDimensionPixelSize(R.dimen.personal_page_image_item_more_icon_height));
        RelativeLayout.LayoutParams $this$_init__u24lambda_u2d7 = layoutParams2;
        $this$_init__u24lambda_u2d7.addRule(15);
        $this$_init__u24lambda_u2d7.addRule(11);
        Unit unit3 = Unit.INSTANCE;
        this.topLayout.addView(imageView, layoutParams2);
        addView(this.topLayout, new FrameLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout = new LinearLayout(context2);
        LinearLayout $this$_init__u24lambda_u2d8 = linearLayout;
        $this$_init__u24lambda_u2d8.setGravity(16);
        $this$_init__u24lambda_u2d8.setOrientation(0);
        int hIndexPadding = $this$_init__u24lambda_u2d8.getResources().getDimensionPixelOffset(R.dimen.personal_page_image_item_index_h_padding);
        int vIndexPadding = $this$_init__u24lambda_u2d8.getResources().getDimensionPixelOffset(R.dimen.personal_page_image_item_index_v_padding);
        $this$_init__u24lambda_u2d8.setPadding(hIndexPadding, vIndexPadding, hIndexPadding, vIndexPadding);
        $this$_init__u24lambda_u2d8.setBackground(ResourcesCompat.getDrawable($this$_init__u24lambda_u2d8.getResources(), R.drawable.personal_page_image_index_bg, (Resources.Theme) null));
        this.indexLayout = linearLayout;
        BdBaseImageView $this$_init__u24lambda_u2d9 = new BdBaseImageView(context2);
        $this$_init__u24lambda_u2d9.setImageResource(R.drawable.image_item_index_img);
        this.indexIcon = $this$_init__u24lambda_u2d9;
        int iconSize = getResources().getDimensionPixelSize(R.dimen.personal_page_image_item_index_icon_size);
        LinearLayout.LayoutParams $this$_init__u24lambda_u2d10 = new LinearLayout.LayoutParams(iconSize, iconSize);
        $this$_init__u24lambda_u2d10.rightMargin = getResources().getDimensionPixelOffset(R.dimen.personal_page_image_item_index_icon_margin);
        Unit unit4 = Unit.INSTANCE;
        linearLayout.addView($this$_init__u24lambda_u2d9, $this$_init__u24lambda_u2d10);
        TextView textView2 = new TextView(context2);
        TextView $this$_init__u24lambda_u2d11 = textView2;
        $this$_init__u24lambda_u2d11.setIncludeFontPadding(false);
        $this$_init__u24lambda_u2d11.setTextColor(ResourcesCompat.getColor($this$_init__u24lambda_u2d11.getResources(), com.baidu.android.common.ui.style.R.color.GC10, (Resources.Theme) null));
        $this$_init__u24lambda_u2d11.setTextSize(1, 9.0f);
        this.indexText = textView2;
        linearLayout.addView(textView2, -2, -2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        FrameLayout.LayoutParams $this$_init__u24lambda_u2d12 = layoutParams3;
        $this$_init__u24lambda_u2d12.gravity = 8388693;
        int indexMargin = getResources().getDimensionPixelOffset(R.dimen.personal_page_image_item_index_margin);
        $this$_init__u24lambda_u2d12.bottomMargin = indexMargin;
        $this$_init__u24lambda_u2d12.rightMargin = indexMargin;
        Unit unit5 = Unit.INSTANCE;
        addView(linearLayout, layoutParams3);
        setOnClickListener(new ImageItemTemplate$$ExternalSyntheticLambda3(this, context2));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-5  reason: not valid java name */
    public static final void m14559_init_$lambda5(ImageItemTemplate this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showMenu();
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-14  reason: not valid java name */
    public static final void m14558_init_$lambda14(ImageItemTemplate this$0, Context $context, View it) {
        String it2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($context, "$context");
        PPImageEntity pPImageEntity = this$0.data;
        if (Intrinsics.areEqual((Object) pPImageEntity != null ? pPImageEntity.getShowStatus() : null, (Object) "own")) {
            UniversalToast.makeText($context, (CharSequence) this$0.getResources().getString(R.string.item_is_verifying_toast)).show();
            return;
        }
        Function0<Unit> function0 = this$0.onItemClick;
        if (function0 != null) {
            function0.invoke();
        }
        PPImageEntity pPImageEntity2 = this$0.data;
        if (pPImageEntity2 != null && (it2 = pPImageEntity2.getScheme()) != null) {
            Router.invoke($context, it2);
        }
    }

    public final void updateTemplate(PPImageEntity entity, boolean isSelf) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        this.data = entity;
        Integer num = getImageCardHeightMap().get(Integer.valueOf(entity.getImageShape()));
        int height = num != null ? num.intValue() : this.cardWidth;
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        ViewGroup.LayoutParams layoutParams = this.topLayout.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = this.cardWidth;
        }
        SimpleDraweeView simpleDraweeView = this.cover;
        String cover2 = entity.getCover();
        if (cover2 == null) {
            cover2 = "";
        }
        simpleDraweeView.setImageURI(cover2);
        this.cover.getLayoutParams().width = this.cardWidth;
        this.cover.getLayoutParams().height = height;
        this.topIcon.setVisibility(entity.isTop() ? 0 : 8);
        this.moreIcon.setVisibility(isSelf ? 0 : 8);
        if (entity.isGif()) {
            this.indexLayout.setVisibility(0);
            this.indexIcon.setVisibility(8);
            this.indexText.setText(getResources().getString(R.string.image_index_gif));
        } else if (entity.getCount() > 1) {
            this.indexLayout.setVisibility(0);
            this.indexIcon.setVisibility(0);
            this.indexText.setText(getResources().getString(R.string.image_index_num, new Object[]{Integer.valueOf(entity.getCount())}));
        } else {
            this.indexLayout.setVisibility(8);
        }
        onNightModeChanged();
        onFontSizeChanged();
    }

    private final void onNightModeChanged() {
        this.topIcon.setTextColor(ContextCompat.getColor(getContext(), com.baidu.android.common.ui.style.R.color.BC60));
        TextView textView = this.topIcon;
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.item_top_icon_bg);
        Drawable $this$onNightModeChanged_u24lambda_u2d15 = drawable;
        GradientDrawable gradientDrawable = $this$onNightModeChanged_u24lambda_u2d15 instanceof GradientDrawable ? (GradientDrawable) $this$onNightModeChanged_u24lambda_u2d15 : null;
        if (gradientDrawable != null) {
            gradientDrawable.setCornerRadius(FontSizeHelper.getScaledSize(0, PersonalPageExtensionsKt.dp2px(4)));
        }
        textView.setBackground(drawable);
        this.moreIcon.setImageResource(R.drawable.video_item_more_icon);
        this.indexLayout.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.personal_page_image_index_bg, (Resources.Theme) null));
        this.indexText.setTextColor(ResourcesCompat.getColor(getResources(), com.baidu.android.common.ui.style.R.color.GC84, (Resources.Theme) null));
        this.indexIcon.setImageResource(R.drawable.image_item_index_img);
        GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) this.cover.getHierarchy();
        if (genericDraweeHierarchy != null) {
            genericDraweeHierarchy.setPlaceholderImage(ContextCompat.getDrawable(getContext(), R.drawable.feed_card_place_holder));
        }
    }

    /* JADX WARNING: type inference failed for: r0v8, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void onFontSizeChanged() {
        /*
            r15 = this;
            android.widget.ImageView r0 = r15.moreIcon
            r1 = r0
            android.view.View r1 = (android.view.View) r1
            r0 = 16
            float r3 = com.baidu.searchbox.account.userinfo.utils.PersonalPageExtensionsKt.dp2px(r0)
            r0 = 15
            float r4 = com.baidu.searchbox.account.userinfo.utils.PersonalPageExtensionsKt.dp2px(r0)
            r2 = 0
            r5 = 0
            r6 = 8
            r7 = 0
            com.baidu.searchbox.config.ext.FontSizeViewExtKt.setScaledSize$default(r1, r2, r3, r4, r5, r6, r7)
            com.baidu.searchbox.ui.BdBaseImageView r0 = r15.indexIcon
            r1 = r0
            android.view.View r1 = (android.view.View) r1
            int r3 = com.baidu.searchbox.account.userinfo.R.dimen.personal_page_image_item_index_icon_size
            int r4 = com.baidu.searchbox.account.userinfo.R.dimen.personal_page_image_item_index_icon_size
            com.baidu.searchbox.config.ext.FontSizeViewExtKt.setScaledSizeRes$default(r1, r2, r3, r4, r5, r6, r7)
            android.widget.TextView r8 = r15.topIcon
            r9 = 0
            r10 = 1
            r11 = 1092616192(0x41200000, float:10.0)
            r12 = 0
            r13 = 8
            r14 = 0
            com.baidu.searchbox.config.ext.FontSizeTextViewExtKt.setScaledSize$default(r8, r9, r10, r11, r12, r13, r14)
            android.widget.TextView r0 = r15.topIcon
            android.graphics.drawable.Drawable r0 = r0.getBackground()
            boolean r1 = r0 instanceof android.graphics.drawable.GradientDrawable
            r2 = 0
            if (r1 == 0) goto L_0x0041
            android.graphics.drawable.GradientDrawable r0 = (android.graphics.drawable.GradientDrawable) r0
            goto L_0x0042
        L_0x0041:
            r0 = r2
        L_0x0042:
            r1 = 0
            if (r0 != 0) goto L_0x0046
            goto L_0x0052
        L_0x0046:
            r3 = 4
            float r3 = com.baidu.searchbox.account.userinfo.utils.PersonalPageExtensionsKt.dp2px(r3)
            float r3 = com.baidu.searchbox.config.FontSizeHelper.getScaledSize(r1, r3)
            r0.setCornerRadius(r3)
        L_0x0052:
            android.widget.TextView r4 = r15.indexText
            r5 = 0
            r6 = 1
            r7 = 1091567616(0x41100000, float:9.0)
            r8 = 0
            r9 = 8
            r10 = 0
            com.baidu.searchbox.config.ext.FontSizeTextViewExtKt.setScaledSize$default(r4, r5, r6, r7, r8, r9, r10)
            android.widget.LinearLayout r0 = r15.indexLayout
            android.graphics.drawable.Drawable r0 = r0.getBackground()
            boolean r3 = r0 instanceof android.graphics.drawable.GradientDrawable
            if (r3 == 0) goto L_0x006c
            r2 = r0
            android.graphics.drawable.GradientDrawable r2 = (android.graphics.drawable.GradientDrawable) r2
        L_0x006c:
            if (r2 != 0) goto L_0x006f
            goto L_0x007c
        L_0x006f:
            r0 = 9
            float r0 = com.baidu.searchbox.account.userinfo.utils.PersonalPageExtensionsKt.dp2px(r0)
            float r0 = com.baidu.searchbox.config.FontSizeHelper.getScaledSize(r1, r0)
            r2.setCornerRadius(r0)
        L_0x007c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.account.userinfo.feed.template.ImageItemTemplate.onFontSizeChanged():void");
    }

    private final void showMenu() {
        BdListPopupWindow.ListItemData topItem;
        PPImageEntity entity = this.data;
        if (entity != null) {
            if (entity.isTop()) {
                topItem = new BdListPopupWindow.ListItemData(R.string.video_menu_cancel_top, R.drawable.video_item_menu_cancel_top);
            } else {
                topItem = new BdListPopupWindow.ListItemData(R.string.video_menu_top, R.drawable.video_item_menu_put_top);
            }
            topItem.setItemClickListener(new ImageItemTemplate$showMenu$1(this, entity));
            if (Intrinsics.areEqual((Object) entity.getShowStatus(), (Object) "own")) {
                topItem.setEnable(false);
            }
            List datas = CollectionsKt.mutableListOf(topItem);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            new BdListPopupWindow(context, datas, false).showAtAnchorView(this.moreIcon);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        NightModeHelper.subscribeNightModeChangeEvent(this, new ImageItemTemplate$$ExternalSyntheticLambda0(this));
        BdEventBus.Companion.getDefault().register(this, FontSizeChangeMessage.class, 1, new ImageItemTemplate$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachedToWindow$lambda-16  reason: not valid java name */
    public static final void m14560onAttachedToWindow$lambda16(ImageItemTemplate this$0, boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onNightModeChanged();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachedToWindow$lambda-17  reason: not valid java name */
    public static final void m14561onAttachedToWindow$lambda17(ImageItemTemplate this$0, FontSizeChangeMessage it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.onFontSizeChanged();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        NightModeHelper.unsubscribeNightModeChangedEvent(this);
        BdEventBus.Companion.getDefault().unregister(this);
    }
}
