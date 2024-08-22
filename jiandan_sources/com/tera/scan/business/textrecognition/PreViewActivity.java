package com.tera.scan.business.textrecognition;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.baidu.aiscan.R;
import com.tera.scan.framework.BaseActivity;
import com.tera.scan.ui.widget.titlebar.ICommonTitleBarClickListener;
import fe.mmm.qw.rg.de.fe;
import fe.mmm.qw.rg.qw.de.ad.ad;
import java.io.File;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0012\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/tera/scan/business/textrecognition/PreViewActivity;", "Lcom/tera/scan/framework/BaseActivity;", "Lcom/tera/scan/ui/widget/titlebar/ICommonTitleBarClickListener;", "()V", "contentView", "Landroid/widget/TextView;", "getContentView", "()Landroid/widget/TextView;", "contentView$delegate", "Lkotlin/Lazy;", "shareView", "Landroid/view/View;", "getShareView", "()Landroid/view/View;", "shareView$delegate", "getLayoutId", "", "getStatusBarColorResId", "initView", "", "onBackButtonClicked", "onRightButtonClicked", "view", "Companion", "business-text-recongition_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PreViewActivity extends BaseActivity implements ICommonTitleBarClickListener {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    @NotNull
    public static final String EXTRA_PATH = "extra_path";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    public final Lazy contentView$delegate = LazyKt__LazyJVMKt.lazy(new PreViewActivity$contentView$2(this));
    @NotNull
    public final Lazy shareView$delegate = LazyKt__LazyJVMKt.lazy(new PreViewActivity$shareView$2(this));

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Intent qw(@NotNull Context context, @NotNull String str) {
            Intrinsics.checkNotNullParameter(context, "ctx");
            Intrinsics.checkNotNullParameter(str, "path");
            Intent intent = new Intent(context, PreViewActivity.class);
            intent.putExtra("extra_path", str);
            return intent;
        }
    }

    private final TextView getContentView() {
        Object value = this.contentView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-contentView>(...)");
        return (TextView) value;
    }

    private final View getShareView() {
        Object value = this.shareView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-shareView>(...)");
        return (View) value;
    }

    /* renamed from: initView$lambda-2  reason: not valid java name */
    public static final void m731initView$lambda2(File file, PreViewActivity preViewActivity, View view) {
        Intrinsics.checkNotNullParameter(preViewActivity, "this$0");
        if (file != null) {
            ad.qw.ad(preViewActivity, CollectionsKt__CollectionsKt.arrayListOf(file.getAbsolutePath()));
            fe.mmm.qw.ggg.qw.qw.qw("ts_files_share", CollectionsKt__CollectionsJVMKt.listOf("1"));
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

    public int getLayoutId() {
        return R.layout.activity_text_recognition_preview_layout;
    }

    public int getStatusBarColorResId() {
        return fe.mmm.qw.rg.de.xxx.qw.qw(this);
    }

    public void initView() {
        String stringExtra = getIntent().getStringExtra("extra_path");
        String str = null;
        File file = stringExtra != null ? new File(stringExtra) : null;
        fe.mmm.qw.f.fe.ad.ad adVar = new fe.mmm.qw.f.fe.ad.ad(this);
        this.mTitleBar = adVar;
        String name = file != null ? file.getName() : null;
        if (name == null) {
            name = "";
        }
        adVar.when(name);
        this.mTitleBar.o(true);
        this.mTitleBar.xxx(false);
        this.mTitleBar.aaa(this);
        this.mTitleBar.pf(R.color.color_title_bar);
        TextView contentView = getContentView();
        if (file != null) {
            str = FilesKt__FileReadWriteKt.readText$default(file, (Charset) null, 1, (Object) null);
        }
        fe.mmm.qw.rg.de.xxx.qw.ad(this, contentView, str);
        getShareView().setOnClickListener(new fe(file, this));
    }

    public void onBackButtonClicked() {
        finish();
    }

    public void onRightButtonClicked(@Nullable View view) {
    }
}
