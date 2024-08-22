package com.tera.scan.main.ui.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.baidu.aiscan.R;
import com.tera.scan.main.home.BaseViewHolder;
import fe.mmm.qw.th.qw.th.th;
import fe.mmm.qw.xxx.p032if.th.qw;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0018B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bH\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0014\u0010\u0014\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0006\u0010\u0016\u001a\u00020\u000fJ\u0006\u0010\u0017\u001a\u00020\u000fR\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/tera/scan/main/ui/view/ScanHomeBannerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "currentItem", "", "dataList", "", "", "viewHandler", "Landroid/os/Handler;", "delayPostData", "", "generateBannerDotView", "Landroid/view/View;", "index", "initView", "setData", "list", "startCirculate", "stopCirculate", "HomeBannerAdapter", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScanHomeBannerView extends FrameLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    public int currentItem;
    @Nullable
    public List<String> dataList;
    @NotNull
    public final Handler viewHandler;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/tera/scan/main/ui/view/ScanHomeBannerView$HomeBannerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tera/scan/main/home/BaseViewHolder;", "context", "Landroid/content/Context;", "list", "", "", "(Landroid/content/Context;Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class HomeBannerAdapter extends RecyclerView.Adapter<BaseViewHolder> {
        @NotNull

        /* renamed from: ad  reason: collision with root package name */
        public final List<String> f6995ad;
        @NotNull
        public final Context qw;

        public HomeBannerAdapter(@NotNull Context context, @NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(list, "list");
            this.qw = context;
            this.f6995ad = list;
        }

        public int getItemCount() {
            return Integer.MAX_VALUE;
        }

        public void onBindViewHolder(@NotNull BaseViewHolder baseViewHolder, int i2) {
            Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
            int size = i2 % this.f6995ad.size();
            TextView textView = (TextView) baseViewHolder.findViewWithId(R.id.tv_home_banner_item);
            if (textView != null) {
                textView.setText(this.f6995ad.get(size));
            }
        }

        @NotNull
        public BaseViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i2) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(this.qw).inflate(R.layout.view_home_banner_item, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.…nner_item, parent, false)");
            return new BaseViewHolder(inflate);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ScanHomeBannerView(@NotNull Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ScanHomeBannerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.currentItem = 1073741823;
        this.viewHandler = new Handler(Looper.getMainLooper(), new qw(this));
        LayoutInflater.from(context).inflate(R.layout.view_scan_home_banner, this);
        initView(context);
    }

    private final void delayPostData() {
        this.viewHandler.sendEmptyMessageDelayed(0, CoroutineLiveDataKt.DEFAULT_TIMEOUT);
    }

    private final View generateBannerDotView(int i2) {
        int qw = th.qw(5.0f, getContext());
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(qw, qw);
        view.setBackgroundResource(R.drawable.ic_add_disk);
        if (i2 != 0) {
            layoutParams.leftMargin = th.qw(3.0f, getContext());
            view.setBackgroundTintList(getResources().getColorStateList(R.color.color_d9d9d9));
        } else {
            view.setBackgroundTintList(getResources().getColorStateList(R.color.color_5564ff));
        }
        view.setLayoutParams(layoutParams);
        return view;
    }

    private final void initView(Context context) {
        ((ViewPager2) _$_findCachedViewById(R.id.vp_banner_content)).registerOnPageChangeCallback(new ScanHomeBannerView$initView$1(this));
    }

    /* renamed from: viewHandler$lambda-0  reason: not valid java name */
    public static final boolean m832viewHandler$lambda0(ScanHomeBannerView scanHomeBannerView, Message message) {
        Intrinsics.checkNotNullParameter(scanHomeBannerView, "this$0");
        Intrinsics.checkNotNullParameter(message, "it");
        int i2 = scanHomeBannerView.currentItem + 1;
        scanHomeBannerView.currentItem = i2;
        ((ViewPager2) scanHomeBannerView._$_findCachedViewById(R.id.vp_banner_content)).setCurrentItem(i2);
        scanHomeBannerView.delayPostData();
        return true;
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

    public final void setData(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.dataList = list;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ((ViewPager2) _$_findCachedViewById(R.id.vp_banner_content)).setAdapter(new HomeBannerAdapter(context, list));
        int i2 = 0;
        ((ViewPager2) _$_findCachedViewById(R.id.vp_banner_content)).setCurrentItem(this.currentItem, false);
        ((LinearLayout) _$_findCachedViewById(R.id.ll_banner_dot_container)).removeAllViews();
        for (T next : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String str = (String) next;
            ((LinearLayout) _$_findCachedViewById(R.id.ll_banner_dot_container)).addView(generateBannerDotView(i2));
            i2 = i3;
        }
        startCirculate();
    }

    public final void startCirculate() {
        List<String> list = this.dataList;
        if (!(list == null || list.isEmpty())) {
            stopCirculate();
            delayPostData();
        }
    }

    public final void stopCirculate() {
        this.viewHandler.removeCallbacksAndMessages((Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScanHomeBannerView(Context context, AttributeSet attributeSet, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }
}
