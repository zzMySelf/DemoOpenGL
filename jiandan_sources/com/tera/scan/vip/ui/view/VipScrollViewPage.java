package com.tera.scan.vip.ui.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.baidu.aiscan.R;
import com.tera.scan.vip.model.PrivilegeType;
import fe.mmm.qw.k.pf.i.rg;
import fe.mmm.qw.th.qw.th.th;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003:;<B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010.\u001a\u00020/H\u0002J\u0018\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u0013H\u0002J\u0010\u00103\u001a\u00020/2\u0006\u00104\u001a\u00020\u0013H\u0002J\u0010\u00105\u001a\u00020/2\b\u00106\u001a\u0004\u0018\u000107J\u0006\u00108\u001a\u00020/J\u0010\u00109\u001a\u00020/2\u0006\u00104\u001a\u00020\u0013H\u0002R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0002¢\u0006\f\n\u0004\b!\u0010\u000e\u001a\u0004\b\u001f\u0010 R\u000e\u0010\"\u001a\u00020#XD¢\u0006\u0002\n\u0000R\u001b\u0010$\u001a\u00020%8BX\u0002¢\u0006\f\n\u0004\b(\u0010\u000e\u001a\u0004\b&\u0010'R\u001b\u0010)\u001a\u00020*8BX\u0002¢\u0006\f\n\u0004\b-\u0010\u000e\u001a\u0004\b+\u0010,¨\u0006="}, d2 = {"Lcom/tera/scan/vip/ui/view/VipScrollViewPage;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "animDuration", "", "borderView", "Landroid/view/View;", "getBorderView", "()Landroid/view/View;", "borderView$delegate", "Lkotlin/Lazy;", "closeAnim", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "currentIndex", "", "dataList", "", "Lcom/tera/scan/vip/ui/view/VipScrollViewPage$ViewPageData;", "expandAnim", "expandGap", "firstSelect", "", "itemMargin", "itemWidth", "llTabContainer", "Landroid/widget/LinearLayout;", "getLlTabContainer", "()Landroid/widget/LinearLayout;", "llTabContainer$delegate", "maskAlpha", "", "tabScrollView", "Landroid/widget/HorizontalScrollView;", "getTabScrollView", "()Landroid/widget/HorizontalScrollView;", "tabScrollView$delegate", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "getViewPager", "()Landroidx/viewpager2/widget/ViewPager2;", "viewPager$delegate", "initView", "", "onItemSelectChange", "selectPos", "unSelectPos", "onPageItemSelected", "position", "setCurrentPage", "from", "", "showBorder", "smoothScrollToPosition", "PageViewHolder", "ViewPageData", "VipGuidePageAdapter", "lib_vip_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VipScrollViewPage extends FrameLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    public final long animDuration;
    @NotNull
    public final Lazy borderView$delegate;
    public final ValueAnimator closeAnim;
    public int currentIndex;
    @NotNull
    public final List<qw> dataList;
    public final ValueAnimator expandAnim;
    public int expandGap;
    public boolean firstSelect;
    public int itemMargin;
    public int itemWidth;
    @NotNull
    public final Lazy llTabContainer$delegate;
    public final float maskAlpha;
    @NotNull
    public final Lazy tabScrollView$delegate;
    @NotNull
    public final Lazy viewPager$delegate;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/tera/scan/vip/ui/view/VipScrollViewPage$PageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "lib_vip_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class PageViewHolder extends RecyclerView.ViewHolder {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PageViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/tera/scan/vip/ui/view/VipScrollViewPage$VipGuidePageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "dataList", "", "Lcom/tera/scan/vip/ui/view/VipScrollViewPage$ViewPageData;", "(Landroid/content/Context;Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "getDataList", "()Ljava/util/List;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "lib_vip_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class VipGuidePageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        @NotNull

        /* renamed from: ad  reason: collision with root package name */
        public final List<qw> f7466ad;
        @NotNull
        public final Context qw;

        public VipGuidePageAdapter(@NotNull Context context, @NotNull List<qw> list) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(list, "dataList");
            this.qw = context;
            this.f7466ad = list;
        }

        @NotNull
        public final Context getContext() {
            return this.qw;
        }

        @NotNull
        public final List<qw> getDataList() {
            return this.f7466ad;
        }

        public int getItemCount() {
            return this.f7466ad.size();
        }

        /* JADX WARNING: type inference failed for: r3v3, types: [android.view.View] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView.ViewHolder r3, int r4) {
            /*
                r2 = this;
                java.lang.String r0 = "holder"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                android.view.View r3 = r3.itemView
                boolean r0 = r3 instanceof android.view.ViewGroup
                r1 = 0
                if (r0 == 0) goto L_0x000f
                android.view.ViewGroup r3 = (android.view.ViewGroup) r3
                goto L_0x0010
            L_0x000f:
                r3 = r1
            L_0x0010:
                if (r3 == 0) goto L_0x002f
                r0 = 0
                android.view.View r3 = androidx.core.view.ViewGroupKt.get(r3, r0)
                boolean r0 = r3 instanceof android.widget.ImageView
                if (r0 == 0) goto L_0x001e
                r1 = r3
                android.widget.ImageView r1 = (android.widget.ImageView) r1
            L_0x001e:
                if (r1 == 0) goto L_0x002f
                java.util.List<com.tera.scan.vip.ui.view.VipScrollViewPage$qw> r3 = r2.f7466ad
                java.lang.Object r3 = r3.get(r4)
                com.tera.scan.vip.ui.view.VipScrollViewPage$qw r3 = (com.tera.scan.vip.ui.view.VipScrollViewPage.qw) r3
                int r3 = r3.ad()
                r1.setImageResource(r3)
            L_0x002f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.vip.ui.view.VipScrollViewPage.VipGuidePageAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
        }

        @NotNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i2) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            FrameLayout frameLayout = new FrameLayout(this.qw);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            ImageView imageView = new ImageView(this.qw);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.bottomMargin = th.qw(48.0f, this.qw);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            frameLayout.addView(imageView, layoutParams);
            return new PageViewHolder(frameLayout);
        }
    }

    public static final class ad implements Animator.AnimatorListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ VipScrollViewPage f7467ad;
        public final /* synthetic */ ValueAnimator qw;

        public ad(ValueAnimator valueAnimator, VipScrollViewPage vipScrollViewPage) {
            this.qw = valueAnimator;
            this.f7467ad = vipScrollViewPage;
        }

        public void onAnimationCancel(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.qw.setDuration(this.f7467ad.animDuration);
        }

        public void onAnimationRepeat(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }
    }

    public static final class qw {

        /* renamed from: ad  reason: collision with root package name */
        public final int f7468ad;

        /* renamed from: de  reason: collision with root package name */
        public final int f7469de;
        @NotNull
        public final PrivilegeType qw;

        public qw(@NotNull PrivilegeType privilegeType, int i2, int i3) {
            Intrinsics.checkNotNullParameter(privilegeType, "privilegeType");
            this.qw = privilegeType;
            this.f7468ad = i2;
            this.f7469de = i3;
        }

        public final int ad() {
            return this.f7468ad;
        }

        public final int de() {
            return this.f7469de;
        }

        @NotNull
        public final PrivilegeType qw() {
            return this.qw;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VipScrollViewPage(@NotNull Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VipScrollViewPage(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.currentIndex = -1;
        this.viewPager$delegate = LazyKt__LazyJVMKt.lazy(new VipScrollViewPage$viewPager$2(this));
        this.llTabContainer$delegate = LazyKt__LazyJVMKt.lazy(new VipScrollViewPage$llTabContainer$2(this));
        this.tabScrollView$delegate = LazyKt__LazyJVMKt.lazy(new VipScrollViewPage$tabScrollView$2(this));
        this.borderView$delegate = LazyKt__LazyJVMKt.lazy(new VipScrollViewPage$borderView$2(this));
        this.maskAlpha = 0.6f;
        this.animDuration = 250;
        this.firstSelect = true;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.setDuration(this.animDuration);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "");
        ofFloat.addListener(new ad(ofFloat, this));
        this.expandAnim = ofFloat;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat2.setInterpolator(new DecelerateInterpolator());
        ofFloat2.setDuration(this.animDuration);
        this.closeAnim = ofFloat2;
        this.dataList = CollectionsKt__CollectionsKt.listOf(new qw(PrivilegeType.imageAddWatermark, R.drawable.image_rights_pdf_water, R.string.vip_pdf_water_name), new qw(PrivilegeType.imageAiTranslate, R.drawable.image_rights_ai_translate2, R.string.vip_ai_translate_name), new qw(PrivilegeType.imageToWord, R.drawable.image_rights_to_word, R.string.vip_to_word_name), new qw(PrivilegeType.cardScan, R.drawable.image_rights_scan_cards, R.string.vip_id_card_name), new qw(PrivilegeType.pdfExtract, R.drawable.image_rights_export_doc, R.string.vip_export_doc_name), new qw(PrivilegeType.imageToPdfRemoveLogo, R.drawable.image_rights_remove_water, R.string.vip_watermarking_free_name));
        LayoutInflater.from(context).inflate(R.layout.view_vip_scroll_view_page, this);
        initView();
    }

    private final View getBorderView() {
        Object value = this.borderView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-borderView>(...)");
        return (View) value;
    }

    private final LinearLayout getLlTabContainer() {
        Object value = this.llTabContainer$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-llTabContainer>(...)");
        return (LinearLayout) value;
    }

    private final HorizontalScrollView getTabScrollView() {
        Object value = this.tabScrollView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-tabScrollView>(...)");
        return (HorizontalScrollView) value;
    }

    private final ViewPager2 getViewPager() {
        Object value = this.viewPager$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewPager>(...)");
        return (ViewPager2) value;
    }

    private final void initView() {
        this.expandGap = th.qw(54.0f, getContext());
        this.itemWidth = th.qw(72.0f, getContext());
        this.itemMargin = th.qw(4.0f, getContext());
        ViewPager2 viewPager = getViewPager();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        viewPager.setAdapter(new VipGuidePageAdapter(context, this.dataList));
        int i2 = 0;
        for (T next : this.dataList) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            qw qwVar = (qw) next;
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.item_vip_scroll_tab, (ViewGroup) null);
            int i4 = this.itemWidth;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i4);
            int i5 = this.itemMargin;
            if (i2 == 0) {
                i5 *= 3;
            }
            layoutParams.setMargins(i5, 0, this.itemMargin, 0);
            ((TextView) inflate.findViewById(R.id.tv_vip_item_des)).setText(getContext().getResources().getString(qwVar.de()));
            ((TextView) inflate.findViewById(R.id.tv_vip_item_des_black)).setText(getContext().getResources().getString(qwVar.de()));
            ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_vip_rights_icon);
            if (imageView != null) {
                imageView.setImageResource(qwVar.ad());
            }
            inflate.setOnClickListener(new fe.mmm.qw.k.pf.i.th(this, i2));
            getLlTabContainer().addView(inflate, layoutParams);
            i2 = i3;
        }
        getViewPager().registerOnPageChangeCallback(new VipScrollViewPage$initView$2(this));
    }

    /* renamed from: initView$lambda-4$lambda-3  reason: not valid java name */
    public static final void m948initView$lambda4$lambda3(VipScrollViewPage vipScrollViewPage, int i2, View view) {
        Intrinsics.checkNotNullParameter(vipScrollViewPage, "this$0");
        int i3 = vipScrollViewPage.currentIndex;
        if (i3 != i2) {
            vipScrollViewPage.onItemSelectChange(i2, i3);
            vipScrollViewPage.smoothScrollToPosition(i2);
            vipScrollViewPage.getViewPager().setCurrentItem(i2);
            vipScrollViewPage.currentIndex = i2;
        }
    }

    private final void onItemSelectChange(int i2, int i3) {
        this.closeAnim.cancel();
        this.closeAnim.removeAllUpdateListeners();
        this.expandAnim.cancel();
        this.expandAnim.removeAllUpdateListeners();
        if (i2 >= 0 && i2 < getLlTabContainer().getChildCount()) {
            View view = ViewGroupKt.get(getLlTabContainer(), i2);
            View findViewById = view.findViewById(R.id.v_vip_item_black_mask);
            TextView textView = (TextView) view.findViewById(R.id.tv_vip_item_des);
            TextView textView2 = (TextView) view.findViewById(R.id.tv_vip_item_des_black);
            if (this.firstSelect) {
                this.expandAnim.setDuration(0);
            }
            this.expandAnim.addUpdateListener(new fe.mmm.qw.k.pf.i.qw(view, findViewById, this, textView2, textView));
            this.expandAnim.start();
        }
        if (i3 >= 0 && i3 < getLlTabContainer().getChildCount()) {
            View view2 = ViewGroupKt.get(getLlTabContainer(), i3);
            View findViewById2 = view2.findViewById(R.id.v_vip_item_black_mask);
            this.closeAnim.addUpdateListener(new rg(view2, (TextView) view2.findViewById(R.id.tv_vip_item_des), (TextView) view2.findViewById(R.id.tv_vip_item_des_black), findViewById2, this));
            this.closeAnim.start();
        }
    }

    /* JADX WARNING: type inference failed for: r8v3, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: onItemSelectChange$lambda-10  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m949onItemSelectChange$lambda10(android.view.View r4, android.view.View r5, com.tera.scan.vip.ui.view.VipScrollViewPage r6, android.widget.TextView r7, android.widget.TextView r8, android.animation.ValueAnimator r9) {
        /*
            java.lang.String r0 = "$view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.Object r9 = r9.getAnimatedValue()
            if (r9 == 0) goto L_0x0081
            java.lang.Float r9 = (java.lang.Float) r9
            float r9 = r9.floatValue()
            android.view.ViewGroup$LayoutParams r0 = r4.getLayoutParams()
            if (r0 == 0) goto L_0x0079
            int r1 = r6.itemWidth
            float r1 = (float) r1
            int r2 = r6.expandGap
            float r2 = (float) r2
            float r2 = r2 * r9
            float r1 = r1 + r2
            int r1 = kotlin.math.MathKt__MathJVMKt.roundToInt((float) r1)
            r0.width = r1
            android.view.ViewGroup$LayoutParams r8 = r8.getLayoutParams()
            boolean r1 = r8 instanceof android.widget.FrameLayout.LayoutParams
            r2 = 0
            if (r1 == 0) goto L_0x003c
            android.widget.FrameLayout$LayoutParams r8 = (android.widget.FrameLayout.LayoutParams) r8
            goto L_0x003d
        L_0x003c:
            r8 = r2
        L_0x003d:
            if (r8 == 0) goto L_0x004d
            int r1 = r6.itemMargin
            float r3 = (float) r1
            float r1 = (float) r1
            float r1 = r1 * r9
            float r3 = r3 + r1
            int r1 = kotlin.math.MathKt__MathJVMKt.roundToInt((float) r3)
            r8.setMarginStart(r1)
        L_0x004d:
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            boolean r1 = r8 instanceof android.widget.FrameLayout.LayoutParams
            if (r1 == 0) goto L_0x0058
            r2 = r8
            android.widget.FrameLayout$LayoutParams r2 = (android.widget.FrameLayout.LayoutParams) r2
        L_0x0058:
            if (r2 == 0) goto L_0x0068
            int r8 = r6.itemMargin
            float r1 = (float) r8
            float r8 = (float) r8
            float r8 = r8 * r9
            float r1 = r1 + r8
            int r8 = kotlin.math.MathKt__MathJVMKt.roundToInt((float) r1)
            r2.setMarginStart(r8)
        L_0x0068:
            r4.setLayoutParams(r0)
            float r4 = r6.maskAlpha
            r6 = 1
            float r6 = (float) r6
            float r6 = r6 - r9
            float r4 = r4 * r6
            r5.setAlpha(r4)
            r7.setAlpha(r9)
            return
        L_0x0079:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException
            java.lang.String r5 = "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams"
            r4.<init>(r5)
            throw r4
        L_0x0081:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.Float"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.vip.ui.view.VipScrollViewPage.m949onItemSelectChange$lambda10(android.view.View, android.view.View, com.tera.scan.vip.ui.view.VipScrollViewPage, android.widget.TextView, android.widget.TextView, android.animation.ValueAnimator):void");
    }

    /* JADX WARNING: type inference failed for: r3v5, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: onItemSelectChange$lambda-14  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m950onItemSelectChange$lambda14(android.view.View r3, android.widget.TextView r4, android.widget.TextView r5, android.view.View r6, com.tera.scan.vip.ui.view.VipScrollViewPage r7, android.animation.ValueAnimator r8) {
        /*
            java.lang.String r0 = "$view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.Object r8 = r8.getAnimatedValue()
            if (r8 == 0) goto L_0x0081
            java.lang.Float r8 = (java.lang.Float) r8
            float r8 = r8.floatValue()
            android.view.ViewGroup$LayoutParams r0 = r3.getLayoutParams()
            if (r0 == 0) goto L_0x0079
            int r1 = r7.itemWidth
            float r1 = (float) r1
            int r2 = r7.expandGap
            float r2 = (float) r2
            float r2 = r2 * r8
            float r1 = r1 + r2
            int r1 = kotlin.math.MathKt__MathJVMKt.roundToInt((float) r1)
            r0.width = r1
            r3.setLayoutParams(r0)
            android.view.ViewGroup$LayoutParams r3 = r4.getLayoutParams()
            boolean r4 = r3 instanceof android.widget.FrameLayout.LayoutParams
            r0 = 0
            if (r4 == 0) goto L_0x003f
            android.widget.FrameLayout$LayoutParams r3 = (android.widget.FrameLayout.LayoutParams) r3
            goto L_0x0040
        L_0x003f:
            r3 = r0
        L_0x0040:
            if (r3 == 0) goto L_0x0050
            int r4 = r7.itemMargin
            float r1 = (float) r4
            float r4 = (float) r4
            float r4 = r4 * r8
            float r1 = r1 + r4
            int r4 = kotlin.math.MathKt__MathJVMKt.roundToInt((float) r1)
            r3.setMarginStart(r4)
        L_0x0050:
            android.view.ViewGroup$LayoutParams r3 = r5.getLayoutParams()
            boolean r4 = r3 instanceof android.widget.FrameLayout.LayoutParams
            if (r4 == 0) goto L_0x005b
            r0 = r3
            android.widget.FrameLayout$LayoutParams r0 = (android.widget.FrameLayout.LayoutParams) r0
        L_0x005b:
            if (r0 == 0) goto L_0x006b
            int r3 = r7.itemMargin
            float r4 = (float) r3
            float r3 = (float) r3
            float r3 = r3 * r8
            float r4 = r4 + r3
            int r3 = kotlin.math.MathKt__MathJVMKt.roundToInt((float) r4)
            r0.setMarginStart(r3)
        L_0x006b:
            float r3 = r7.maskAlpha
            r4 = 1
            float r4 = (float) r4
            float r4 = r4 - r8
            float r3 = r3 * r4
            r6.setAlpha(r3)
            r5.setAlpha(r8)
            return
        L_0x0079:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r4 = "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams"
            r3.<init>(r4)
            throw r3
        L_0x0081:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r4 = "null cannot be cast to non-null type kotlin.Float"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.vip.ui.view.VipScrollViewPage.m950onItemSelectChange$lambda14(android.view.View, android.widget.TextView, android.widget.TextView, android.view.View, com.tera.scan.vip.ui.view.VipScrollViewPage, android.animation.ValueAnimator):void");
    }

    /* access modifiers changed from: private */
    public final void onPageItemSelected(int i2) {
        onItemSelectChange(i2, this.currentIndex);
        smoothScrollToPosition(i2);
        this.currentIndex = i2;
        this.firstSelect = false;
    }

    /* renamed from: setCurrentPage$lambda-6  reason: not valid java name */
    public static final void m951setCurrentPage$lambda6(VipScrollViewPage vipScrollViewPage, int i2) {
        Intrinsics.checkNotNullParameter(vipScrollViewPage, "this$0");
        vipScrollViewPage.getViewPager().setCurrentItem(i2, false);
        vipScrollViewPage.onPageItemSelected(i2);
    }

    private final void smoothScrollToPosition(int i2) {
        if (i2 < getLlTabContainer().getChildCount() && i2 >= 0) {
            int[] iArr = new int[2];
            ViewGroupKt.get(getLlTabContainer(), i2).getLocationOnScreen(iArr);
            int i3 = iArr[0] - ((getContext().getResources().getDisplayMetrics().widthPixels / 2) - (this.itemWidth / 2));
            if (this.firstSelect) {
                getTabScrollView().scrollBy(i3, 0);
            } else {
                getTabScrollView().smoothScrollBy(i3, 0);
            }
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void setCurrentPage(@Nullable String str) {
        if (str != null) {
            List<qw> list = this.dataList;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            for (qw qw2 : list) {
                arrayList.add(qw2.qw().getValue());
            }
            getViewPager().post(new fe.mmm.qw.k.pf.i.ad(this, arrayList.indexOf(str)));
        }
    }

    public final void showBorder() {
        getBorderView().setVisibility(0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VipScrollViewPage(Context context, AttributeSet attributeSet, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }
}
