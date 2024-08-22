package com.tera.scan.main.viewmodel;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.baidu.aiscan.R;
import com.google.common.net.MediaType;
import com.tera.scan.account.OnLoginCallBack;
import com.tera.scan.component.base.ui.dialog.CustomListAdapter;
import com.tera.scan.framework.kernel.BaseApplication;
import com.tera.scan.libanalytics.ScanAnalyticsBaseEvent;
import com.tera.scan.main.MainActivity;
import com.tera.scan.main.file.FileFragment;
import com.tera.scan.main.fragment.ScanBaseFragment;
import com.tera.scan.main.home.FileSelectModeFragment;
import com.tera.scan.main.home.HomeFragment;
import com.tera.scan.main.home.bean.recordwrapper.RecordWrapper;
import com.tera.scan.record.model.ScanRecord;
import com.tera.scan.record.model.ScanRecordExportFile;
import com.tera.scan.vip.VipInfoManager;
import com.tera.scan.vip.network.model.MemberInfo;
import fe.mmm.qw.xxx.ggg.fe;
import fe.mmm.qw.xxx.ggg.rg;
import fe.mmm.qw.xxx.ppp.th;
import i.qw.Cif;
import i.qw.w1.b0;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002 @\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J<\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00140I2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020F0R2\u0006\u0010S\u001a\u00020F2\u0006\u0010T\u001a\u00020F2\u0006\u0010U\u001a\u00020F2\u0006\u0010V\u001a\u00020FH\u0002J,\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00140R2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020F0R2\u0010\u0010X\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030Y0\u0007J\u0006\u0010Z\u001a\u000205J\u0010\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u0014H\u0002JM\u0010^\u001a\u0002052\u0006\u0010_\u001a\u00020`2\f\u0010a\u001a\b\u0012\u0002\b\u0003\u0018\u00010b2\f\u0010c\u001a\b\u0012\u0004\u0012\u00020F0\u00072!\u0010d\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(e\u0012\u0004\u0012\u00020501J\u0011\u0010f\u001a\u000205H@ø\u0001\u0000¢\u0006\u0002\u0010gJ\u0011\u0010h\u001a\u000205H@ø\u0001\u0000¢\u0006\u0002\u0010gJ*\u0010i\u001a\u0002052\u0006\u0010_\u001a\u00020j2\n\u0010k\u001a\u0006\u0012\u0002\b\u00030b2\u0006\u0010l\u001a\u00020F2\u0006\u0010m\u001a\u00020FJ\u000e\u0010n\u001a\u0002052\u0006\u0010_\u001a\u00020jJ\u0006\u0010o\u001a\u00020\u0014J:\u0010p\u001a\u0012\u0012\u0004\u0012\u00020r0qj\b\u0012\u0004\u0012\u00020r`s2\u000e\u0010t\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010I2\u0012\u0010u\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030Y\u0018\u00010\u0007J\u000e\u0010v\u001a\u00020\u00142\u0006\u0010w\u001a\u00020FJ\f\u0010x\u001a\b\u0012\u0004\u0012\u00020y0\u000fJ\u000e\u0010z\u001a\u0002052\u0006\u0010_\u001a\u00020jJ\u0006\u0010{\u001a\u000205J\b\u0010|\u001a\u000205H\u0002J\u0006\u0010}\u001a\u000205J\u0006\u0010~\u001a\u000205J\u0006\u0010\u001a\u00020\u000bJ,\u0010\u0001\u001a\u0002052\u0006\u0010_\u001a\u00020j2\n\u0010k\u001a\u0006\u0012\u0002\b\u00030b2\u0007\u0010\u0001\u001a\u00020F2\u0006\u0010m\u001a\u00020FJ\u001c\u0010\u0001\u001a\u0002052\u0007\u0010\u0001\u001a\u00020)2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0012\u0010\u0001\u001a\u000205H@ø\u0001\u0000¢\u0006\u0002\u0010gJ\u0007\u0010\u0001\u001a\u000205J\u0010\u0010\u0001\u001a\u0002052\u0007\u0010\u0001\u001a\u00020FJ$\u0010\u0001\u001a\u0002052\u0006\u0010_\u001a\u00020j2\u0006\u00104\u001a\u00020\u00142\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0014J\u001e\u0010\u0001\u001a\u0002052\b\u00104\u001a\u0004\u0018\u00010\u00142\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0014JE\u0010\u0001\u001a\u0002052\b\u0010\u0001\u001a\u00030\u00012\f\u0010a\u001a\b\u0012\u0002\b\u0003\u0018\u00010b2\u0006\u0010]\u001a\u00020\u00142\u0007\u0010\u0001\u001a\u00020F2\u0013\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020501J\u0010\u0010\u0001\u001a\u0002052\u0007\u0010\u0001\u001a\u00020FJ\u0010\u0010\u0001\u001a\u0002052\u0007\u0010\u0001\u001a\u00020FR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00070\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0010\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0004\n\u0002\u0010!R\u001d\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00070\u0013¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0011R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010,\u001a\u00020-¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R7\u00100\u001a\u001f\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0004\u0012\u000205\u0018\u000101X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R#\u0010:\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000b0;0\u000f¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0011R\u0011\u0010=\u001a\u00020-¢\u0006\b\n\u0000\u001a\u0004\b>\u0010/R\u0010\u0010?\u001a\u00020@X\u0004¢\u0006\u0004\n\u0002\u0010AR\u001d\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020C0\u00070\u0013¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u0016R\u0017\u0010E\u001a\b\u0012\u0004\u0012\u00020F0\u0013¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u0016R\u0017\u0010H\u001a\b\u0012\u0004\u0012\u00020F0I¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0017\u0010L\u001a\b\u0012\u0004\u0012\u00020F0\u0013¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\u0016R\u0017\u0010N\u001a\b\u0012\u0004\u0012\u00020F0\u0013¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u0016\u0002\u0004\n\u0002\b\u0019¨\u0006\u0001"}, d2 = {"Lcom/tera/scan/main/viewmodel/MainActivityViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_allFileListLiveData", "Landroidx/lifecycle/MediatorLiveData;", "", "Lcom/tera/scan/main/home/bean/recordwrapper/AllFileRecordWrapper;", "_bottomCameraSelected", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "_bottomTabSelected", "Lcom/tera/scan/main/viewmodel/TabSelectedData;", "allFileLiveData", "Landroidx/lifecycle/LiveData;", "getAllFileLiveData", "()Landroidx/lifecycle/LiveData;", "bannerDataLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "getBannerDataLiveData", "()Landroidx/lifecycle/MutableLiveData;", "bottomCameraSelected", "Lkotlinx/coroutines/flow/SharedFlow;", "getBottomCameraSelected$app_main_aiscanConfigRelease", "()Lkotlinx/coroutines/flow/SharedFlow;", "bottomTabSelected", "getBottomTabSelected$app_main_aiscanConfigRelease", "currentTab", "getCurrentTab", "exportObserver", "com/tera/scan/main/viewmodel/MainActivityViewModel$exportObserver$1", "Lcom/tera/scan/main/viewmodel/MainActivityViewModel$exportObserver$1;", "fileExportList", "Lcom/tera/scan/main/home/bean/recordwrapper/FileExportRecordWrapper;", "getFileExportList", "fileSelectMode", "getFileSelectMode", "inFileSelectMode", "lastFileExportCursor", "Landroid/database/Cursor;", "lastScanRecordCursor", "lastTabTag", "leftTabData", "Lcom/tera/scan/main/view/TabData;", "getLeftTabData", "()Lcom/tera/scan/main/view/TabData;", "onBottomTagReSelected", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "tag", "", "getOnBottomTagReSelected", "()Lkotlin/jvm/functions/Function1;", "setOnBottomTagReSelected", "(Lkotlin/jvm/functions/Function1;)V", "rightOffInfoLiveData", "Lkotlin/Pair;", "getRightOffInfoLiveData", "rightTabData", "getRightTabData", "scanObserver", "com/tera/scan/main/viewmodel/MainActivityViewModel$scanObserver$1", "Lcom/tera/scan/main/viewmodel/MainActivityViewModel$scanObserver$1;", "scanRecordList", "Lcom/tera/scan/main/home/bean/recordwrapper/FileScanRecordWrapper;", "getScanRecordList", "selectFileCount", "", "getSelectFileCount", "selectItemList", "", "getSelectItemList", "()Ljava/util/Set;", "sortOrderLiveData", "getSortOrderLiveData", "sortTypeLiveData", "getSortTypeLiveData", "assemblyBottomMenu", "selectPositionList", "", "pdfCount", "txtCount", "scanCount", "nonStandardFileCount", "calculateBottomFuncEnable", "recordWrappers", "Lcom/tera/scan/main/home/bean/recordwrapper/RecordWrapper;", "clickBottomCenterButton", "createFragmentByTag", "Lcom/tera/scan/main/fragment/ScanBaseFragment;", "it", "deleteFiles", "activity", "Landroidx/fragment/app/FragmentActivity;", "listHolder", "Lcom/tera/scan/main/home/bean/listholder/BaseMainListHolder;", "positionList", "onResultCallback", "success", "doInitFileExportData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doInitScanRecordList", "enterFileSelectMode", "Lcom/tera/scan/main/MainActivity;", "holder", "indexPosition", "y", "exitFileSelectMode", "getExpiredTimeStr", "getSelectPdfFiles", "Ljava/util/ArrayList;", "Lcom/tera/scan/record/model/ScanRecordExportFile;", "Lkotlin/collections/ArrayList;", "selectItemIndexSet", "list", "getUpperRightCornerVipCopyWriting", "savePercentage", "getVipState", "Lcom/tera/scan/vip/VipStates;", "hideLoginGuide", "initFileExportListData", "initHomeBanner", "initHomeData", "initScanRecordList", "isInFileSelectMode", "onFileItemSelect", "position", "registerObserver", "cursor", "observer", "Landroid/database/ContentObserver;", "reloadScanRecordList", "reverseFileListOrder", "setFileListOrder", "order", "switchToFragment", "action", "switchToTab", "updateRecordName", "context", "Landroid/content/Context;", "onResult", "updateSelectItemCount", "size", "updateSortType", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MainActivityViewModel extends AndroidViewModel {
    @NotNull
    public final MutableSharedFlow<Boolean> aaa;
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final th f7006ad;
    @NotNull
    public final MutableLiveData<List<String>> ddd;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final MutableLiveData<String> f7007de = new MutableLiveData<>("");
    @Nullable
    public Function1<? super String, Unit> eee;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public String f7008fe = "";
    @NotNull
    public final ad ggg;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public final MutableLiveData<Integer> f7009i;
    @NotNull

    /* renamed from: if  reason: not valid java name */
    public final de f289if;
    @NotNull
    public final SharedFlow<rg> mmm;
    @NotNull
    public final MutableSharedFlow<rg> nn;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    public final MutableLiveData<List<fe.mmm.qw.xxx.yj.g.ad.de>> f7010o;
    @Nullable

    /* renamed from: pf  reason: collision with root package name */
    public Cursor f7011pf;
    @Nullable
    public Cursor ppp;
    @NotNull
    public final SharedFlow<Boolean> qqq;
    @NotNull
    public final th qw;
    @NotNull

    /* renamed from: rg  reason: collision with root package name */
    public final MutableLiveData<Boolean> f7012rg;
    @NotNull
    public final LiveData<Pair<String, Boolean>> rrr;
    @NotNull

    /* renamed from: switch  reason: not valid java name */
    public final Set<Integer> f290switch;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final LiveData<Boolean> f7013th;
    @NotNull

    /* renamed from: uk  reason: collision with root package name */
    public final MutableLiveData<Integer> f7014uk;
    @NotNull
    public final MediatorLiveData<List<fe.mmm.qw.xxx.yj.g.ad.qw>> vvv;
    @NotNull
    public final MutableLiveData<List<fe.mmm.qw.xxx.yj.g.ad.ad>> when;
    @NotNull
    public final LiveData<List<fe.mmm.qw.xxx.yj.g.ad.qw>> xxx;
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final MutableLiveData<Integer> f7015yj;

    public static final class ad extends ContentObserver {
        public final /* synthetic */ MainActivityViewModel qw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ad(MainActivityViewModel mainActivityViewModel, Handler handler) {
            super(handler);
            this.qw = mainActivityViewModel;
        }

        public void onChange(boolean z) {
            super.onChange(z);
            this.qw.initFileExportListData();
        }
    }

    public static final class de extends ContentObserver {
        public final /* synthetic */ MainActivityViewModel qw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public de(MainActivityViewModel mainActivityViewModel, Handler handler) {
            super(handler);
            this.qw = mainActivityViewModel;
        }

        public void onChange(boolean z) {
            super.onChange(z);
            this.qw.initScanRecordList();
        }
    }

    public static final class qw implements OnLoginCallBack {
        public final /* synthetic */ MainActivityViewModel qw;

        public qw(MainActivityViewModel mainActivityViewModel) {
            this.qw = mainActivityViewModel;
        }

        public void ad() {
            this.qw.initHomeData();
        }

        public void qw() {
            this.qw.initHomeData();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MainActivityViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, MediaType.APPLICATION_TYPE);
        fe.mmm.qw.qw.qw.qw.de(new qw(this));
        String ad2 = th.f8636rg.ad();
        String string = application.getResources().getString(R.string.tab_home);
        Intrinsics.checkNotNullExpressionValue(string, "application.resources.getString(R.string.tab_home)");
        this.qw = new th(ad2, R.drawable.main_tab_home_selected, R.drawable.main_tab_home_unselected, string);
        String qw2 = th.f8636rg.qw();
        String string2 = application.getResources().getString(R.string.tab_files);
        Intrinsics.checkNotNullExpressionValue(string2, "application.resources.ge…tring(R.string.tab_files)");
        this.f7006ad = new th(qw2, R.drawable.main_tab_file_selected, R.drawable.main_tab_file_unselected, string2);
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>(Boolean.FALSE);
        this.f7012rg = mutableLiveData;
        this.f7013th = mutableLiveData;
        this.f7015yj = new MutableLiveData<>(0);
        this.f7014uk = new MutableLiveData<>(0);
        this.f7009i = new MutableLiveData<>(1);
        this.f7010o = new MutableLiveData<>(new ArrayList());
        this.f289if = new de(this, new Handler(Looper.getMainLooper()));
        this.f290switch = new LinkedHashSet();
        this.when = new MutableLiveData<>(new ArrayList());
        this.ggg = new ad(this, new Handler(Looper.getMainLooper()));
        MediatorLiveData<List<fe.mmm.qw.xxx.yj.g.ad.qw>> mediatorLiveData = new MediatorLiveData<>();
        MainActivityViewModel$_allFileListLiveData$1$updateValue$1 mainActivityViewModel$_allFileListLiveData$1$updateValue$1 = new MainActivityViewModel$_allFileListLiveData$1$updateValue$1(this, mediatorLiveData);
        mediatorLiveData.addSource(this.f7010o, new fe.mmm.qw.xxx.ggg.ad(mainActivityViewModel$_allFileListLiveData$1$updateValue$1));
        mediatorLiveData.addSource(this.when, new fe(mainActivityViewModel$_allFileListLiveData$1$updateValue$1));
        this.vvv = mediatorLiveData;
        this.xxx = mediatorLiveData;
        this.ddd = new MutableLiveData<>(new ArrayList());
        MutableSharedFlow<rg> ad3 = b0.ad(0, 0, (BufferOverflow) null, 7, (Object) null);
        this.nn = ad3;
        this.mmm = ad3;
        MutableSharedFlow<Boolean> ad4 = b0.ad(0, 0, (BufferOverflow) null, 7, (Object) null);
        this.aaa = ad4;
        this.qqq = ad4;
        MediatorLiveData mediatorLiveData2 = new MediatorLiveData();
        MainActivityViewModel$rightOffInfoLiveData$1$updateValue$1 mainActivityViewModel$rightOffInfoLiveData$1$updateValue$1 = new MainActivityViewModel$rightOffInfoLiveData$1$updateValue$1(mediatorLiveData2, this);
        mediatorLiveData2.addSource(VipInfoManager.qw.fe(), new fe.mmm.qw.xxx.ggg.qw(mainActivityViewModel$rightOffInfoLiveData$1$updateValue$1));
        mediatorLiveData2.addSource(VipInfoManager.qw.th(), new fe.mmm.qw.xxx.ggg.de(mainActivityViewModel$rightOffInfoLiveData$1$updateValue$1));
        this.rrr = mediatorLiveData2;
    }

    public static final void ad(Function0 function0, List list) {
        Intrinsics.checkNotNullParameter(function0, "$updateValue");
        function0.invoke();
    }

    public static final void i(Function0 function0, Integer num) {
        Intrinsics.checkNotNullParameter(function0, "$updateValue");
        function0.invoke();
    }

    public static final void o(Function0 function0, fe.mmm.qw.k.de deVar) {
        Intrinsics.checkNotNullParameter(function0, "$updateValue");
        function0.invoke();
    }

    public static final void qw(Function0 function0, List list) {
        Intrinsics.checkNotNullParameter(function0, "$updateValue");
        function0.invoke();
    }

    public static /* synthetic */ void switchToFragment$default(MainActivityViewModel mainActivityViewModel, MainActivity mainActivity, String str, String str2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        mainActivityViewModel.switchToFragment(mainActivity, str, str2);
    }

    public static /* synthetic */ void switchToTab$default(MainActivityViewModel mainActivityViewModel, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        mainActivityViewModel.switchToTab(str, str2);
    }

    @NotNull
    public final Set<String> calculateBottomFuncEnable(@NotNull Set<Integer> set, @NotNull List<? extends RecordWrapper<?>> list) {
        Intrinsics.checkNotNullParameter(set, "selectPositionList");
        Intrinsics.checkNotNullParameter(list, "recordWrappers");
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (Number intValue : set) {
            Object data = ((RecordWrapper) list.get(intValue.intValue())).getData();
            if (data instanceof ScanRecordExportFile) {
                String localPath = ((ScanRecordExportFile) data).getLocalPath();
                if (localPath != null) {
                    if (fe.mmm.qw.o.qw.qw.ad.ad.yj(localPath)) {
                        i3++;
                    } else if (fe.mmm.qw.o.qw.qw.ad.ad.rg(localPath)) {
                        i2++;
                    } else {
                        i5++;
                    }
                }
            } else if (data instanceof ScanRecord) {
                i4++;
            }
        }
        return de(set, i2, i3, i4, i5);
    }

    public final void clickBottomCenterButton() {
        Job unused = Cif.fe(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new MainActivityViewModel$clickBottomCenterButton$1(this, (Continuation<? super MainActivityViewModel$clickBottomCenterButton$1>) null), 3, (Object) null);
    }

    public final Set<String> de(Set<Integer> set, int i2, int i3, int i4, int i5) {
        int size = set.size();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (size == 1) {
            if (i2 == 1) {
                linkedHashSet.add("share");
                linkedHashSet.add("move");
                linkedHashSet.add("rename");
                linkedHashSet.add("more");
            } else if (i3 == 1) {
                linkedHashSet.add("share");
                linkedHashSet.add("move");
                linkedHashSet.add("rename");
                linkedHashSet.add("delete");
            } else if (i4 == 1) {
                linkedHashSet.add("share");
                linkedHashSet.add("rename");
                linkedHashSet.add("delete");
            }
        } else if (i2 > 1 && i3 == 0 && i4 == 0) {
            linkedHashSet.add("share");
            linkedHashSet.add("move");
            linkedHashSet.add("merge");
            linkedHashSet.add("delete");
        } else if (i4 == 0 && i2 > 0 && i3 > 0) {
            linkedHashSet.add("share");
            linkedHashSet.add("move");
            linkedHashSet.add("delete");
        } else if (i4 == 0 && (i2 > 0 || i3 > 0)) {
            linkedHashSet.add("share");
            linkedHashSet.add("move");
            linkedHashSet.add("delete");
        } else if (i4 > 0 && (i2 > 0 || i3 > 0)) {
            linkedHashSet.add("share");
            linkedHashSet.add("delete");
        } else if (i4 > 0 && i2 == 0 && i3 == 0) {
            linkedHashSet.add("share");
            linkedHashSet.add("delete");
        }
        if (i5 > 0) {
            linkedHashSet.add("share");
            if (size == 1) {
                linkedHashSet.add("rename");
            } else {
                linkedHashSet.remove("rename");
            }
            linkedHashSet.add("delete");
            linkedHashSet.remove("move");
            linkedHashSet.remove("merge");
            linkedHashSet.remove("more");
        }
        return linkedHashSet;
    }

    public final void deleteFiles(@NotNull FragmentActivity fragmentActivity, @Nullable fe.mmm.qw.xxx.yj.g.qw.qw<?> qwVar, @NotNull List<Integer> list, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(list, "positionList");
        Intrinsics.checkNotNullParameter(function1, "onResultCallback");
        if (qwVar != null) {
            Job unused = Cif.fe(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new MainActivityViewModel$deleteFiles$1(qwVar, fragmentActivity, list, this, function1, (Continuation<? super MainActivityViewModel$deleteFiles$1>) null), 3, (Object) null);
        }
    }

    public final void enterFileSelectMode(@NotNull MainActivity mainActivity, @NotNull fe.mmm.qw.xxx.yj.g.qw.qw<?> qwVar, int i2, int i3) {
        Intrinsics.checkNotNullParameter(mainActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(qwVar, "holder");
        fe.mmm.qw.th.qw.th.p031switch.ad.de(this.f7012rg, Boolean.TRUE);
        Fragment qw2 = fe.ggg.ad.qw.de.qw.qw(mainActivity, FileSelectModeFragment.TAG);
        if (qw2 == null) {
            qw2 = new FileSelectModeFragment();
        }
        FragmentTransaction beginTransaction = mainActivity.getSupportFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "activity.supportFragmentManager.beginTransaction()");
        if (qw2.isAdded()) {
            beginTransaction.show(qw2);
        } else {
            beginTransaction.add((int) R.id.fl_container_select, qw2, FileSelectModeFragment.TAG);
        }
        beginTransaction.commitNowAllowingStateLoss();
        FileSelectModeFragment fileSelectModeFragment = qw2 instanceof FileSelectModeFragment ? (FileSelectModeFragment) qw2 : null;
        if (fileSelectModeFragment != null) {
            fileSelectModeFragment.updateData(mainActivity, qwVar, i2, i3);
        }
        if (qwVar.fe() == 0) {
            ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "home_recently_use_choose_page_show", (List) null, 2, (Object) null);
        }
    }

    /* JADX WARNING: type inference failed for: r5v1, types: [androidx.fragment.app.Fragment] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void exitFileSelectMode(@org.jetbrains.annotations.NotNull com.tera.scan.main.MainActivity r5) {
        /*
            r4 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> r0 = r4.f7012rg
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            fe.mmm.qw.th.qw.th.p031switch.ad.de(r0, r1)
            java.util.Set<java.lang.Integer> r0 = r4.f290switch
            r0.clear()
            java.lang.String r0 = "file_select"
            androidx.fragment.app.Fragment r0 = fe.ggg.ad.qw.de.qw.qw(r5, r0)
            boolean r1 = r0 instanceof com.tera.scan.main.home.FileSelectModeFragment
            r2 = 0
            if (r1 == 0) goto L_0x001f
            com.tera.scan.main.home.FileSelectModeFragment r0 = (com.tera.scan.main.home.FileSelectModeFragment) r0
            goto L_0x0020
        L_0x001f:
            r0 = r2
        L_0x0020:
            if (r0 != 0) goto L_0x0023
            return
        L_0x0023:
            androidx.fragment.app.FragmentManager r1 = r5.getSupportFragmentManager()
            androidx.fragment.app.FragmentTransaction r1 = r1.beginTransaction()
            java.lang.String r3 = "activity.supportFragmentManager.beginTransaction()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            boolean r3 = r0.isAdded()
            if (r3 == 0) goto L_0x0039
            r1.remove(r0)
        L_0x0039:
            r1.commitNowAllowingStateLoss()
            androidx.lifecycle.MutableLiveData<java.lang.String> r1 = r4.f7007de
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x0048
            java.lang.String r1 = ""
        L_0x0048:
            androidx.fragment.app.Fragment r5 = fe.ggg.ad.qw.de.qw.qw(r5, r1)
            boolean r1 = r5 instanceof com.tera.scan.main.fragment.MainFragmentScrollable
            if (r1 == 0) goto L_0x0053
            r2 = r5
            com.tera.scan.main.fragment.MainFragmentScrollable r2 = (com.tera.scan.main.fragment.MainFragmentScrollable) r2
        L_0x0053:
            if (r2 == 0) goto L_0x005c
            int r5 = r0.getListScrollY()
            r2.scrollListTo(r5)
        L_0x005c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.main.viewmodel.MainActivityViewModel.exitFileSelectMode(com.tera.scan.main.MainActivity):void");
    }

    public final ScanBaseFragment fe(String str) {
        if (Intrinsics.areEqual((Object) str, (Object) th.f8636rg.ad())) {
            return new HomeFragment();
        }
        if (Intrinsics.areEqual((Object) str, (Object) th.f8636rg.qw())) {
            return new FileFragment();
        }
        return new HomeFragment();
    }

    @NotNull
    public final LiveData<List<fe.mmm.qw.xxx.yj.g.ad.qw>> getAllFileLiveData() {
        return this.xxx;
    }

    @NotNull
    public final MutableLiveData<List<String>> getBannerDataLiveData() {
        return this.ddd;
    }

    @NotNull
    public final SharedFlow<Boolean> getBottomCameraSelected$app_main_aiscanConfigRelease() {
        return this.qqq;
    }

    @NotNull
    public final SharedFlow<rg> getBottomTabSelected$app_main_aiscanConfigRelease() {
        return this.mmm;
    }

    @NotNull
    public final MutableLiveData<String> getCurrentTab() {
        return this.f7007de;
    }

    @NotNull
    public final String getExpiredTimeStr() {
        Long expiredTime;
        MemberInfo value = VipInfoManager.qw.rg().getValue();
        String format = (value == null || (expiredTime = value.getExpiredTime()) == null) ? null : new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault()).format(new Date(expiredTime.longValue() * 1000));
        return format == null ? "" : format;
    }

    @NotNull
    public final MutableLiveData<List<fe.mmm.qw.xxx.yj.g.ad.ad>> getFileExportList() {
        return this.when;
    }

    @NotNull
    public final LiveData<Boolean> getFileSelectMode() {
        return this.f7013th;
    }

    @NotNull
    public final th getLeftTabData() {
        return this.qw;
    }

    @Nullable
    public final Function1<String, Unit> getOnBottomTagReSelected() {
        return this.eee;
    }

    @NotNull
    public final LiveData<Pair<String, Boolean>> getRightOffInfoLiveData() {
        return this.rrr;
    }

    @NotNull
    public final th getRightTabData() {
        return this.f7006ad;
    }

    @NotNull
    public final MutableLiveData<List<fe.mmm.qw.xxx.yj.g.ad.de>> getScanRecordList() {
        return this.f7010o;
    }

    @NotNull
    public final MutableLiveData<Integer> getSelectFileCount() {
        return this.f7015yj;
    }

    @NotNull
    public final Set<Integer> getSelectItemList() {
        return this.f290switch;
    }

    @NotNull
    public final ArrayList<ScanRecordExportFile> getSelectPdfFiles(@Nullable Set<Integer> set, @Nullable List<? extends RecordWrapper<?>> list) {
        ArrayList<ScanRecordExportFile> arrayList = new ArrayList<>();
        int i2 = 0;
        if (!(set == null || set.isEmpty()) && list != null) {
            for (T next : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                RecordWrapper recordWrapper = (RecordWrapper) next;
                if (set.contains(Integer.valueOf(i2))) {
                    Object data = recordWrapper.getData();
                    if (data instanceof ScanRecordExportFile) {
                        arrayList.add(data);
                    }
                }
                i2 = i3;
            }
        }
        return arrayList;
    }

    @NotNull
    public final MutableLiveData<Integer> getSortOrderLiveData() {
        return this.f7009i;
    }

    @NotNull
    public final MutableLiveData<Integer> getSortTypeLiveData() {
        return this.f7014uk;
    }

    @NotNull
    public final String getUpperRightCornerVipCopyWriting(int i2) {
        if (VipInfoManager.qw.yj() || i2 == 0) {
            return "";
        }
        String string = BaseApplication.getInstance().getString(R.string.save_copywriting, new Object[]{String.valueOf(i2)});
        Intrinsics.checkNotNullExpressionValue(string, "getInstance().getString(…avePercentage.toString())");
        return string;
    }

    @NotNull
    public final LiveData<fe.mmm.qw.k.de> getVipState() {
        return VipInfoManager.qw.th();
    }

    public final void hideLoginGuide(@NotNull MainActivity mainActivity) {
        Intrinsics.checkNotNullParameter(mainActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        String value = this.f7007de.getValue();
        if (value == null) {
            value = "";
        }
        Fragment qw2 = fe.ggg.ad.qw.de.qw.qw(mainActivity, value);
        if (qw2 != null && (qw2 instanceof FileFragment) && fe.mmm.qw.qw.qw.qw.pf()) {
            ((FileFragment) qw2).onHideLoginGuide();
        }
    }

    public final void initFileExportListData() {
        Job unused = Cif.fe(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new MainActivityViewModel$initFileExportListData$1(this, (Continuation<? super MainActivityViewModel$initFileExportListData$1>) null), 3, (Object) null);
    }

    public final void initHomeData() {
        initScanRecordList();
        initFileExportListData();
        yj();
    }

    public final void initScanRecordList() {
        Job unused = Cif.fe(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new MainActivityViewModel$initScanRecordList$1(this, (Continuation<? super MainActivityViewModel$initScanRecordList$1>) null), 3, (Object) null);
    }

    public final boolean isInFileSelectMode() {
        return Intrinsics.areEqual((Object) this.f7012rg.getValue(), (Object) Boolean.TRUE);
    }

    public final void onFileItemSelect(@NotNull MainActivity mainActivity, @NotNull fe.mmm.qw.xxx.yj.g.qw.qw<?> qwVar, int i2, int i3) {
        Intrinsics.checkNotNullParameter(mainActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(qwVar, "holder");
        this.f290switch.add(Integer.valueOf(i2));
        enterFileSelectMode(mainActivity, qwVar, i2, i3);
    }

    @Nullable
    public final Object reloadScanRecordList(@NotNull Continuation<? super Unit> continuation) {
        Object th2 = th(continuation);
        return th2 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? th2 : Unit.INSTANCE;
    }

    public final void reverseFileListOrder() {
        Integer value = this.f7009i.getValue();
        if (value != null && value.intValue() == 1) {
            this.f7009i.postValue(0);
        } else {
            this.f7009i.postValue(1);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0096 A[LOOP:0: B:29:0x0090->B:31:0x0096, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object rg(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.tera.scan.main.viewmodel.MainActivityViewModel$doInitFileExportData$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.tera.scan.main.viewmodel.MainActivityViewModel$doInitFileExportData$1 r0 = (com.tera.scan.main.viewmodel.MainActivityViewModel$doInitFileExportData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.tera.scan.main.viewmodel.MainActivityViewModel$doInitFileExportData$1 r0 = new com.tera.scan.main.viewmodel.MainActivityViewModel$doInitFileExportData$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.L$0
            com.tera.scan.main.viewmodel.MainActivityViewModel r0 = (com.tera.scan.main.viewmodel.MainActivityViewModel) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004e
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.CoroutineDispatcher r6 = i.qw.u.ad()
            com.tera.scan.main.viewmodel.MainActivityViewModel$doInitFileExportData$records$1 r2 = new com.tera.scan.main.viewmodel.MainActivityViewModel$doInitFileExportData$records$1
            r4 = 0
            r2.<init>(r5, r4)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = i.qw.o.yj(r6, r2, r0)
            if (r6 != r1) goto L_0x004d
            return r1
        L_0x004d:
            r0 = r5
        L_0x004e:
            kotlin.Pair r6 = (kotlin.Pair) r6
            android.database.Cursor r1 = r0.ppp
            r2 = 0
            if (r1 == 0) goto L_0x005c
            boolean r1 = r1.isClosed()
            if (r1 != r3) goto L_0x005c
            goto L_0x005d
        L_0x005c:
            r3 = 0
        L_0x005d:
            if (r3 != 0) goto L_0x0066
            android.database.Cursor r1 = r0.ppp
            if (r1 == 0) goto L_0x0066
            r1.close()
        L_0x0066:
            java.lang.Object r1 = r6.getFirst()
            android.database.Cursor r1 = (android.database.Cursor) r1
            r0.ppp = r1
            java.lang.Object r1 = r6.getFirst()
            android.database.Cursor r1 = (android.database.Cursor) r1
            if (r1 == 0) goto L_0x007b
            com.tera.scan.main.viewmodel.MainActivityViewModel$ad r2 = r0.ggg
            r0.uk(r1, r2)
        L_0x007b:
            java.lang.Object r6 = r6.getSecond()
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r6, r2)
            r1.<init>(r2)
            java.util.Iterator r6 = r6.iterator()
        L_0x0090:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L_0x00a5
            java.lang.Object r2 = r6.next()
            com.tera.scan.record.model.ScanRecordExportFile r2 = (com.tera.scan.record.model.ScanRecordExportFile) r2
            fe.mmm.qw.xxx.yj.g.ad.ad r3 = new fe.mmm.qw.xxx.yj.g.ad.ad
            r3.<init>(r2)
            r1.add(r3)
            goto L_0x0090
        L_0x00a5:
            androidx.lifecycle.MutableLiveData<java.util.List<fe.mmm.qw.xxx.yj.g.ad.ad>> r6 = r0.when
            r6.postValue(r1)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.main.viewmodel.MainActivityViewModel.rg(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void setFileListOrder(int i2) {
        this.f7009i.postValue(Integer.valueOf(i2));
    }

    public final void setOnBottomTagReSelected(@Nullable Function1<? super String, Unit> function1) {
        this.eee = function1;
    }

    public final void switchToFragment(@NotNull MainActivity mainActivity, @NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(mainActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(str, CustomListAdapter.VIEW_TAG);
        Object qw2 = fe.ggg.ad.qw.de.qw.qw(mainActivity, str);
        if (qw2 == null) {
            qw2 = fe(str);
        }
        ScanBaseFragment scanBaseFragment = qw2 instanceof ScanBaseFragment ? (ScanBaseFragment) qw2 : null;
        if (scanBaseFragment != null) {
            Fragment qw3 = fe.ggg.ad.qw.de.qw.qw(mainActivity, this.f7008fe);
            FragmentTransaction beginTransaction = mainActivity.getSupportFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "activity.supportFragmentManager.beginTransaction()");
            if (scanBaseFragment.isAdded()) {
                beginTransaction.show(scanBaseFragment);
            } else {
                beginTransaction.add(mainActivity.fragmentContainerId(), (Fragment) scanBaseFragment, str);
            }
            boolean z = true;
            if (qw3 == null || !qw3.isAdded()) {
                z = false;
            }
            if (z) {
                beginTransaction.hide(qw3);
            }
            scanBaseFragment.setAction(str2);
            if ((scanBaseFragment instanceof FileFragment) && fe.mmm.qw.qw.qw.qw.pf()) {
                ((FileFragment) scanBaseFragment).onHideLoginGuide();
            }
            beginTransaction.commitNowAllowingStateLoss();
        }
    }

    public final void switchToTab(@Nullable String str, @Nullable String str2) {
        if (str != null) {
            String value = this.f7007de.getValue();
            if (value == null) {
                value = "";
            }
            this.f7008fe = value;
            this.f7007de.postValue(str);
            if (Intrinsics.areEqual((Object) this.f7008fe, (Object) str)) {
                Function1<? super String, Unit> function1 = this.eee;
                if (function1 != null) {
                    function1.invoke(str);
                    return;
                }
                return;
            }
            Job unused = Cif.fe(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new MainActivityViewModel$switchToTab$1(this, str, str2, (Continuation<? super MainActivityViewModel$switchToTab$1>) null), 3, (Object) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0089 A[LOOP:0: B:26:0x0083->B:28:0x0089, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object th(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.tera.scan.main.viewmodel.MainActivityViewModel$doInitScanRecordList$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.tera.scan.main.viewmodel.MainActivityViewModel$doInitScanRecordList$1 r0 = (com.tera.scan.main.viewmodel.MainActivityViewModel$doInitScanRecordList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.tera.scan.main.viewmodel.MainActivityViewModel$doInitScanRecordList$1 r0 = new com.tera.scan.main.viewmodel.MainActivityViewModel$doInitScanRecordList$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.L$0
            com.tera.scan.main.viewmodel.MainActivityViewModel r0 = (com.tera.scan.main.viewmodel.MainActivityViewModel) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004e
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.CoroutineDispatcher r6 = i.qw.u.ad()
            com.tera.scan.main.viewmodel.MainActivityViewModel$doInitScanRecordList$recordsPair$1 r2 = new com.tera.scan.main.viewmodel.MainActivityViewModel$doInitScanRecordList$recordsPair$1
            r4 = 0
            r2.<init>(r5, r4)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = i.qw.o.yj(r6, r2, r0)
            if (r6 != r1) goto L_0x004d
            return r1
        L_0x004d:
            r0 = r5
        L_0x004e:
            kotlin.Pair r6 = (kotlin.Pair) r6
            android.database.Cursor r1 = r0.f7011pf
            r2 = 0
            if (r1 == 0) goto L_0x005c
            boolean r1 = r1.isClosed()
            if (r1 != r3) goto L_0x005c
            goto L_0x005d
        L_0x005c:
            r3 = 0
        L_0x005d:
            if (r3 != 0) goto L_0x0066
            android.database.Cursor r1 = r0.f7011pf
            if (r1 == 0) goto L_0x0066
            r1.close()
        L_0x0066:
            java.lang.Object r1 = r6.getFirst()
            android.database.Cursor r1 = (android.database.Cursor) r1
            r0.f7011pf = r1
            java.lang.Object r1 = r6.getSecond()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r1, r3)
            r2.<init>(r3)
            java.util.Iterator r1 = r1.iterator()
        L_0x0083:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0098
            java.lang.Object r3 = r1.next()
            com.tera.scan.record.model.ScanRecord r3 = (com.tera.scan.record.model.ScanRecord) r3
            fe.mmm.qw.xxx.yj.g.ad.de r4 = new fe.mmm.qw.xxx.yj.g.ad.de
            r4.<init>(r3)
            r2.add(r4)
            goto L_0x0083
        L_0x0098:
            java.lang.Object r6 = r6.getFirst()
            android.database.Cursor r6 = (android.database.Cursor) r6
            if (r6 == 0) goto L_0x00a5
            com.tera.scan.main.viewmodel.MainActivityViewModel$de r1 = r0.f289if
            r0.uk(r6, r1)
        L_0x00a5:
            androidx.lifecycle.MutableLiveData<java.util.List<fe.mmm.qw.xxx.yj.g.ad.de>> r6 = r0.f7010o
            r6.postValue(r2)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.main.viewmodel.MainActivityViewModel.th(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void uk(Cursor cursor, ContentObserver contentObserver) {
        ContentResolver contentResolver;
        ContentResolver contentResolver2 = getApplication().getContentResolver();
        if (contentResolver2 != null) {
            contentResolver2.unregisterContentObserver(contentObserver);
        }
        Uri notificationUri = cursor.getNotificationUri();
        if (notificationUri != null && (contentResolver = getApplication().getContentResolver()) != null) {
            contentResolver.registerContentObserver(notificationUri, true, contentObserver);
        }
    }

    public final void updateRecordName(@NotNull Context context, @Nullable fe.mmm.qw.xxx.yj.g.qw.qw<?> qwVar, @NotNull String str, int i2, @NotNull Function1<? super Boolean, Unit> function1) {
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context, "context");
        String str2 = str;
        Intrinsics.checkNotNullParameter(str, "it");
        Intrinsics.checkNotNullParameter(function1, "onResult");
        if (qwVar != null) {
            Job unused = Cif.fe(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new MainActivityViewModel$updateRecordName$1(qwVar, this, i2, str, function1, context, (Continuation<? super MainActivityViewModel$updateRecordName$1>) null), 3, (Object) null);
        }
    }

    public final void updateSelectItemCount(int i2) {
        this.f7015yj.postValue(Integer.valueOf(i2));
    }

    public final void updateSortType(int i2) {
        this.f7014uk.postValue(Integer.valueOf(i2));
    }

    public final void yj() {
    }
}
