package com.tera.scan.file.selector.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.IntRange;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.baidu.aiscan.R;
import com.mars.kotlin.extension.BundleKt;
import com.tera.scan.component.base.ui.localfile.baseui.ISelectChangeListener;
import com.tera.scan.file.selector.ui.viewmodel.LocalImageSelectViewModel;
import com.tera.scan.filetype.FileType;
import com.tera.scan.framework.BaseActivity;
import com.tera.scan.libanalytics.ScanAnalyticsBaseEvent;
import com.tera.scan.localfile.model.FileItem;
import com.tera.scan.permission.util.ReadImagesPermissionHelper;
import com.tera.scan.ui.view.widget.UIButton;
import com.tera.scan.ui.view.widget.UITextView;
import com.tera.scan.ui.widget.titlebar.ICommonTitleBarClickListener;
import fe.mmm.qw.th.qw.th.o;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\b\u0007\u0018\u0000 72\u00020\u0001:\u00017B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0014J\b\u0010\u001d\u001a\u00020\u000bH\u0014J\b\u0010\u001e\u001a\u00020\tH\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020 H\u0002J\b\u0010\"\u001a\u00020 H\u0014J\b\u0010#\u001a\u00020 H\u0002J\b\u0010$\u001a\u00020 H\u0014J\b\u0010%\u001a\u00020\u0004H\u0014J\b\u0010&\u001a\u00020\u0004H\u0016J\"\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000b2\b\u0010*\u001a\u0004\u0018\u00010+H\u0014J\b\u0010,\u001a\u00020 H\u0016J\b\u0010-\u001a\u00020 H\u0002J\u0012\u0010.\u001a\u00020 2\b\u0010/\u001a\u0004\u0018\u000100H\u0014J-\u00101\u001a\u00020 2\u0006\u0010(\u001a\u00020\u000b2\u000e\u00102\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t032\u0006\u00104\u001a\u000205H\u0016¢\u0006\u0002\u00106R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u0019\u0010\u001a¨\u00068"}, d2 = {"Lcom/tera/scan/file/selector/ui/LocalImageSelectActivity;", "Lcom/tera/scan/framework/BaseActivity;", "()V", "forbidGif", "", "forbidLiveP", "fragment", "Lcom/tera/scan/file/selector/ui/LocalImageSelectFragment;", "jumpRouter", "", "maxCount", "", "maxSize", "minCount", "readImagesPermissionHelper", "Lcom/tera/scan/permission/util/ReadImagesPermissionHelper;", "getReadImagesPermissionHelper", "()Lcom/tera/scan/permission/util/ReadImagesPermissionHelper;", "readImagesPermissionHelper$delegate", "Lkotlin/Lazy;", "source", "title", "ubcSource", "viewModel", "Lcom/tera/scan/file/selector/ui/viewmodel/LocalImageSelectViewModel;", "getViewModel", "()Lcom/tera/scan/file/selector/ui/viewmodel/LocalImageSelectViewModel;", "viewModel$delegate", "enableSwipeBack", "getLayoutId", "getUbcSource", "initDoneButton", "", "initFragment", "initParams", "initTitleBar", "initView", "interceptSwipeBack", "isActivityDark", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onChooseDone", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "Companion", "business-file-selector_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Route(path = "/fileSelector/native/LocalImageSelectActivity")
public final class LocalImageSelectActivity extends BaseActivity {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    @NotNull
    public static final String EXTRA_RESULT_FILES = "extra_result_files";
    @NotNull
    public static final String EXTRA_UBC_SOURCE = "extra_ubc_source";
    public static final float buttonRadius = 1.0f;
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Autowired(name = "forbidGif")
    @JvmField
    public boolean forbidGif = true;
    @Autowired(name = "forbidLiveP")
    @JvmField
    public boolean forbidLiveP = true;
    @Nullable
    public LocalImageSelectFragment fragment;
    @NotNull
    @Autowired(name = "jumpRouter")
    @JvmField
    public String jumpRouter = "";
    @Autowired(name = "maxCount")
    @JvmField
    public int maxCount;
    @Autowired(name = "maxSize")
    @JvmField
    public int maxSize;
    @Autowired(name = "minCount")
    @JvmField
    public int minCount;
    @NotNull
    public final Lazy readImagesPermissionHelper$delegate = LazyKt__LazyJVMKt.lazy(new LocalImageSelectActivity$readImagesPermissionHelper$2(this));
    @NotNull
    @Autowired(name = "source")
    @JvmField
    public String source = "";
    @NotNull
    @Autowired(name = "title")
    @JvmField
    public String title = "";
    @NotNull
    @Autowired(name = "ubcSource")
    @JvmField
    public String ubcSource = "";
    @NotNull
    public final Lazy viewModel$delegate = LazyKt__LazyJVMKt.lazy(new LocalImageSelectActivity$viewModel$2(this));

    public static final class ad implements ISelectChangeListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ LocalImageSelectActivity f6913ad;
        public int qw = -1;

        public ad(LocalImageSelectActivity localImageSelectActivity) {
            this.f6913ad = localImageSelectActivity;
        }

        public boolean ad(@Nullable String str) {
            String str2;
            String uk2 = fe.mmm.qw.j.xxx.ad.uk(str);
            if (uk2 != null) {
                Locale locale = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
                str2 = uk2.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String).toLowerCase(locale)");
            } else {
                str2 = null;
            }
            boolean z = true;
            boolean z2 = false;
            if (this.f6913ad.forbidLiveP && FileType.isSimpleLivp(str2)) {
                z = false;
            }
            if (!this.f6913ad.forbidGif || !FileType.isSimpleGif(str2)) {
                z2 = z;
            }
            if (!z2) {
                o.rg(R.string.choose_not_support_image_format);
            }
            return z2;
        }

        public void de() {
            fe.mmm.qw.pf.qw.de.ad.qw(this.f6913ad);
        }

        public void qw(int i2, int i3) {
            LocalImageSelectActivity localImageSelectActivity = this.f6913ad;
            boolean z = true;
            if (localImageSelectActivity.maxCount == 1 && i2 == 1) {
                localImageSelectActivity.onChooseDone();
                return;
            }
            ((UITextView) this.f6913ad._$_findCachedViewById(R.id.select_count_text)).setText(this.f6913ad.getString(R.string.local_image_select_choose_image_count, new Object[]{Integer.valueOf(i2), Integer.valueOf(this.f6913ad.maxCount)}));
            LocalImageSelectActivity localImageSelectActivity2 = this.f6913ad;
            if (localImageSelectActivity2.minCount > 0) {
                UIButton uIButton = (UIButton) localImageSelectActivity2._$_findCachedViewById(R.id.done_button);
                if (i2 < this.f6913ad.minCount) {
                    z = false;
                }
                uIButton.setEnabled(z);
            } else {
                UIButton uIButton2 = (UIButton) localImageSelectActivity2._$_findCachedViewById(R.id.done_button);
                if (i2 <= this.f6913ad.minCount) {
                    z = false;
                }
                uIButton2.setEnabled(z);
            }
            if (i2 != 0 || this.qw >= 0) {
                this.qw = i2;
            }
        }
    }

    public static final class de implements ICommonTitleBarClickListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ LocalImageSelectActivity f6914ad;

        public de(LocalImageSelectActivity localImageSelectActivity) {
            this.f6914ad = localImageSelectActivity;
        }

        public void onBackButtonClicked() {
            this.f6914ad.onBackPressed();
        }

        public void onRightButtonClicked(@Nullable View view) {
        }
    }

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent ad(qw qwVar, Activity activity, int i2, int i3, int i4, String str, int i5, Object obj) {
            return qwVar.qw(activity, i2, i3, (i5 & 8) != 0 ? 0 : i4, str);
        }

        public static /* synthetic */ void fe(qw qwVar, Activity activity, int i2, int i3, int i4, int i5, String str, int i6, Object obj) {
            qwVar.de(activity, i2, i3, i4, (i6 & 16) != 0 ? 0 : i5, str);
        }

        public final void de(@NotNull Activity activity, int i2, int i3, @IntRange int i4, int i5, @NotNull String str) {
            Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Intrinsics.checkNotNullParameter(str, "ubcSource");
            activity.startActivityForResult(qw(activity, i2, i3, i5, str), i4);
        }

        @NotNull
        public final Intent qw(@NotNull Activity activity, int i2, int i3, int i4, @NotNull String str) {
            Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Intrinsics.checkNotNullParameter(str, "ubcSource");
            Intent intent = new Intent(activity, LocalImageSelectActivity.class);
            intent.putExtra("extra_max_count", i2);
            intent.putExtra("max_size", i3);
            intent.putExtra("extra_min_count", i4);
            intent.putExtra("extra_ubc_source", str);
            return intent;
        }
    }

    private final ReadImagesPermissionHelper getReadImagesPermissionHelper() {
        return (ReadImagesPermissionHelper) this.readImagesPermissionHelper$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final String getUbcSource() {
        String stringExtra = getIntent().getStringExtra("extra_ubc_source");
        return stringExtra == null ? this.ubcSource : stringExtra;
    }

    /* access modifiers changed from: private */
    public final LocalImageSelectViewModel getViewModel() {
        return (LocalImageSelectViewModel) this.viewModel$delegate.getValue();
    }

    private final void initDoneButton() {
        ((UIButton) _$_findCachedViewById(R.id.done_button)).setOnClickListener(new fe.mmm.qw.pf.qw.de.qw(this));
    }

    /* renamed from: initDoneButton$lambda-0  reason: not valid java name */
    public static final void m755initDoneButton$lambda0(LocalImageSelectActivity localImageSelectActivity, View view) {
        Intrinsics.checkNotNullParameter(localImageSelectActivity, "this$0");
        localImageSelectActivity.onChooseDone();
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "import_images_done_click", (List) null, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void initFragment() {
        LocalImageSelectFragment localImageSelectFragment = new LocalImageSelectFragment();
        localImageSelectFragment.setArguments(BundleKt.Bundle(new LocalImageSelectActivity$initFragment$1$1(this)));
        this.fragment = localImageSelectFragment;
        ((UITextView) _$_findCachedViewById(R.id.select_count_text)).setText(getString(R.string.local_image_select_choose_image_count, new Object[]{0, Integer.valueOf(this.maxCount)}));
        LocalImageSelectFragment localImageSelectFragment2 = this.fragment;
        if (localImageSelectFragment2 != null) {
            localImageSelectFragment2.setSelectChangeListener(new ad(this));
        }
        LocalImageSelectFragment localImageSelectFragment3 = this.fragment;
        if (localImageSelectFragment3 != null) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "supportFragmentManager.beginTransaction()");
            beginTransaction.replace(R.id.fragment_container, localImageSelectFragment3);
            beginTransaction.commitAllowingStateLoss();
        }
    }

    private final void initTitleBar() {
        if (this.mTitleBar == null) {
            this.mTitleBar = new fe.mmm.qw.f.fe.ad.ad(this);
        }
        fe.mmm.qw.f.fe.ad.ad adVar = this.mTitleBar;
        if (adVar != null) {
            if (this.title.length() > 0) {
                adVar.when(this.title);
            } else {
                adVar.m969switch(R.string.local_image_selector_title);
            }
            adVar.aaa(new de(this));
        }
    }

    /* access modifiers changed from: private */
    public final void onChooseDone() {
        ArrayList<FileItem> selectedFiles;
        LocalImageSelectFragment localImageSelectFragment = this.fragment;
        if (localImageSelectFragment != null && (selectedFiles = localImageSelectFragment.getSelectedFiles()) != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(selectedFiles, 10));
            for (FileItem filePath : selectedFiles) {
                arrayList.add(filePath.getFilePath());
            }
            if (!(!arrayList.isEmpty())) {
                arrayList = null;
            }
            if (arrayList != null) {
                getViewModel().onReqGalleryOkBusiness(this, this.maxSize, new ArrayList(arrayList), getUbcSource());
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

    public boolean enableSwipeBack() {
        return false;
    }

    public int getLayoutId() {
        return R.layout.local_image_select_activity;
    }

    public void initParams() {
        this.maxCount = getIntent().getIntExtra("extra_max_count", this.maxCount);
        this.maxSize = getIntent().getIntExtra("max_size", this.maxSize);
        this.minCount = getIntent().getIntExtra("extra_min_count", this.minCount);
    }

    public void initView() {
        if (this.maxCount == 1) {
            ((RelativeLayout) _$_findCachedViewById(R.id.bottom_bar)).setVisibility(8);
        }
        initTitleBar();
        initDoneButton();
        fe.mmm.qw.pf.qw.de.de.qw(this);
    }

    public boolean interceptSwipeBack() {
        LocalImageSelectFragment localImageSelectFragment = this.fragment;
        if (localImageSelectFragment != null) {
            return localImageSelectFragment.getOnDragSelectMode();
        }
        return false;
    }

    public boolean isActivityDark() {
        return true;
    }

    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        super.onActivityResult(i2, i3, intent);
        getReadImagesPermissionHelper().uk(i2, i3, intent);
    }

    public void onBackPressed() {
        LocalImageSelectFragment localImageSelectFragment = this.fragment;
        if (localImageSelectFragment == null) {
            finish();
        } else if (localImageSelectFragment != null) {
            localImageSelectFragment.onBackKeyPressed();
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        fe.ad.qw.qw.ad.qw.de().rg(this);
        super.onCreate(bundle);
        getReadImagesPermissionHelper().pf(new LocalImageSelectActivity$onCreate$1(this));
        getReadImagesPermissionHelper().o();
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "import_images_display", (List) null, 2, (Object) null);
        fe.mmm.qw.pf.qw.ad.qw.fe("Album", "AlbumPms", (String) null, getUbcSource(), (Map) null, 20, (Object) null);
    }

    public void onRequestPermissionsResult(int i2, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        super.onRequestPermissionsResult(i2, strArr, iArr);
        getReadImagesPermissionHelper().i(i2, strArr, iArr);
    }
}
