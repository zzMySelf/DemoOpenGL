package com.tera.scan.scanner.ocr;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.baidu.aiscan.R;
import com.baidu.ubc.UBCManager;
import com.google.common.base.Ascii;
import com.google.common.net.MediaType;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.tera.scan.component.base.ui.widget.titlebar.CustomizedTitleBar;
import com.tera.scan.flutter.documentscan.OCRRectifyActivity;
import com.tera.scan.framework.BaseActivity;
import com.tera.scan.framework.kernel.BaseApplication;
import com.tera.scan.libanalytics.ScanAnalyticsBaseEvent;
import com.tera.scan.scanner.ocr.control.IOCRTakePhotoControl;
import com.tera.scan.scanner.ocr.control.IOCRTakePhotoView;
import com.tera.scan.scanner.ocr.control.OCRAutoScanControl;
import com.tera.scan.scanner.ocr.control.OCRToPDFControl;
import com.tera.scan.scanner.ocr.control.OCRToWordControl;
import com.tera.scan.scanner.ocr.control.ScanIdCardsControl;
import com.tera.scan.scanner.ocr.control.TakeSingleOrMultipleView;
import com.tera.scan.scanner.ocr.viewmodel.OCRTakePhotoViewModel;
import com.tera.scan.scanner.ocr.widget.CenterItemDecoration;
import com.tera.scan.scanner.ocr.widget.CenterLayoutManager;
import com.tera.scan.scanner.ui.cameranew.CameraNewFragment;
import com.tera.scan.ui.view.layout.UIFrameLayout;
import com.tera.scan.ui.view.widget.UITextView;
import com.tera.scan.utils.SizeUtils;
import fe.mmm.qw.th.qw.th.o;
import fe.mmm.qw.tt.ad.Cif;
import fe.mmm.qw.tt.ad.Cswitch;
import fe.mmm.qw.tt.ad.i;
import fe.mmm.qw.tt.ad.yj;
import fe.mmm.qw.yj.th;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Route(path = "/ocr/native/OCRTakePhotoActivity")
@Tag("OCRTakePhotoActivity")
@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u000f\b\u0007\u0018\u0000 ­\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\b¬\u0001­\u0001®\u0001¯\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010I\u001a\u00020D2\u0006\u0010G\u001a\u00020HH\u0002J\u0012\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\b\u0010N\u001a\u00020DH\u0002J\u0010\u0010O\u001a\u00020D2\u0006\u0010P\u001a\u00020\u0013H\u0002J\u0006\u0010Q\u001a\u00020DJ5\u0010R\u001a\u00020D2\b\b\u0002\u0010S\u001a\u00020K2!\u0010T\u001a\u001d\u0012\u0013\u0012\u00110K¢\u0006\f\bV\u0012\b\bW\u0012\u0004\b\b(X\u0012\u0004\u0012\u00020D0UH\u0002J\b\u0010Y\u001a\u00020\u0013H\u0002J\b\u0010Z\u001a\u00020KH\u0002J\u0006\u0010[\u001a\u00020\u0015J\r\u0010\\\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010]J\b\u0010^\u001a\u00020\u0015H\u0014J\n\u0010_\u001a\u0004\u0018\u00010`H\u0016J\b\u0010a\u001a\u00020bH\u0016J\"\u0010c\u001a\u00020D2\u0006\u0010d\u001a\u00020\u00152\u0006\u0010e\u001a\u00020\u00152\b\u0010f\u001a\u0004\u0018\u00010gH\u0002J\b\u0010h\u001a\u00020KH\u0002J\u0006\u0010i\u001a\u00020DJ\b\u0010j\u001a\u00020DH\u0002J\b\u0010k\u001a\u00020DH\u0002J\b\u0010l\u001a\u00020\u0015H\u0002J\b\u0010m\u001a\u00020DH\u0002J\b\u0010n\u001a\u00020DH\u0002J\b\u0010o\u001a\u00020DH\u0014J\b\u0010)\u001a\u00020DH\u0002J\b\u0010p\u001a\u00020DH\u0002J\b\u0010q\u001a\u00020DH\u0002J\b\u0010r\u001a\u00020DH\u0014J\b\u0010s\u001a\u00020KH\u0016J\u0017\u0010t\u001a\u00020K2\b\b\u0002\u0010S\u001a\u00020KH\u0000¢\u0006\u0002\buJ\b\u0010v\u001a\u00020KH\u0002J\b\u0010w\u001a\u00020KH\u0014J\u0010\u0010x\u001a\u00020D2\u0006\u0010y\u001a\u00020`H\u0002J\"\u0010z\u001a\u00020D2\u0006\u0010d\u001a\u00020\u00152\u0006\u0010e\u001a\u00020\u00152\b\u0010f\u001a\u0004\u0018\u00010gH\u0014J\b\u0010{\u001a\u00020DH\u0002J\b\u0010|\u001a\u00020DH\u0016J\u0012\u0010}\u001a\u00020D2\b\u0010~\u001a\u0004\u0018\u00010\u0019H\u0016J\u0014\u0010\u001a\u00020D2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0014J\t\u0010\u0001\u001a\u00020DH\u0014J\u0012\u0010\u0001\u001a\u00020D2\u0007\u0010\u0001\u001a\u00020\u0015H\u0016J\u0014\u0010\u0001\u001a\u00020D2\t\u0010\u0001\u001a\u0004\u0018\u00010gH\u0014J3\u0010\u0001\u001a\u00020D2\u0006\u0010d\u001a\u00020\u00152\u0010\u0010\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\u00130\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016¢\u0006\u0003\u0010\u0001J\t\u0010\u0001\u001a\u00020DH\u0014J\t\u0010\u0001\u001a\u00020DH\u0014J\u0013\u0010\u0001\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\t\u0010\u0001\u001a\u00020DH\u0002J\t\u0010\u0001\u001a\u00020DH\u0002J\t\u0010\u0001\u001a\u00020DH\u0002J\t\u0010\u0001\u001a\u00020DH\u0002J\u001a\u0010\u0001\u001a\u00020D2\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001H\u0002J\t\u0010\u0001\u001a\u00020DH\u0016J\u0012\u0010\u0001\u001a\u00020D2\u0007\u0010\u0001\u001a\u00020\u0015H\u0016J\t\u0010\u0001\u001a\u00020DH\u0002J\u0011\u0010\u0001\u001a\u00020D2\u0006\u0010y\u001a\u00020`H\u0016J\u0012\u0010\u0001\u001a\u00020D2\u0007\u0010\u0001\u001a\u00020\u0015H\u0002J\u0013\u0010\u0001\u001a\u00020D2\b\u0010 \u0001\u001a\u00030¡\u0001H\u0016J\t\u0010¢\u0001\u001a\u00020DH\u0002J\t\u0010£\u0001\u001a\u00020DH\u0002J\t\u0010¤\u0001\u001a\u00020DH\u0002J\t\u0010¥\u0001\u001a\u00020DH\u0002J\u0010\u0010¦\u0001\u001a\u00020D2\u0007\u0010§\u0001\u001a\u00020\u0015J\u0010\u0010¦\u0001\u001a\u00020D2\u0007\u0010§\u0001\u001a\u00020\u0013J\u0015\u0010¨\u0001\u001a\u00020\u00132\n\u0010©\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\t\u0010ª\u0001\u001a\u00020DH\u0002J\t\u0010«\u0001\u001a\u00020DH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010&\u001a\u00020\u00158\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010)\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u001b\u00106\u001a\u0002078BX\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b8\u00109R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010@\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u000e¢\u0006\u0002\n\u0000¨\u0006°\u0001"}, d2 = {"Lcom/tera/scan/scanner/ocr/OCRTakePhotoActivity;", "Lcom/tera/scan/framework/BaseActivity;", "Lcom/tera/scan/scanner/ocr/OnItemClickListener;", "Lcom/tera/scan/scanner/ocr/control/IOCRTakePhotoView;", "Landroid/view/View$OnClickListener;", "()V", "bottomCenterItemDecoration", "Lcom/tera/scan/scanner/ocr/widget/CenterItemDecoration;", "bottomLayoutManager", "Lcom/tera/scan/scanner/ocr/widget/CenterLayoutManager;", "bottomTabConfig", "Lcom/tera/scan/scanner/ocr/ScanBottomTabConfig;", "bottomUIAdapter", "Lcom/tera/scan/scanner/ocr/OCRBottomAdapter;", "getBottomUIAdapter$scanner_aiscanConfigRelease", "()Lcom/tera/scan/scanner/ocr/OCRBottomAdapter;", "setBottomUIAdapter$scanner_aiscanConfigRelease", "(Lcom/tera/scan/scanner/ocr/OCRBottomAdapter;)V", "cacheDir", "", "category", "", "choosePictureSize", "Landroid/widget/LinearLayout;", "chooseSizeContainer", "Landroid/view/View;", "containerFragment", "Lcom/tera/scan/scanner/ui/cameranew/CameraNewFragment;", "customizedTitleBar", "Lcom/tera/scan/component/base/ui/widget/titlebar/CustomizedTitleBar;", "defaultTab", "docSavePath", "getDocSavePath", "()Ljava/lang/String;", "setDocSavePath", "(Ljava/lang/String;)V", "fragmentContainer", "Lcom/tera/scan/ui/view/layout/UIFrameLayout;", "from", "gestureDetector", "Landroid/view/GestureDetector;", "initTab", "ocrBottomRecyclerview", "Landroidx/recyclerview/widget/RecyclerView;", "ocrTakingTab", "Landroid/widget/TextView;", "pdfAddCount", "pdfMode", "pdfReChoosePage", "screenHeight", "subIndex", "takePhotoButton", "Landroid/widget/ImageView;", "takePhotoPreviousStep", "takePhotoViewModel", "Lcom/tera/scan/scanner/ocr/viewmodel/OCRTakePhotoViewModel;", "getTakePhotoViewModel", "()Lcom/tera/scan/scanner/ocr/viewmodel/OCRTakePhotoViewModel;", "takePhotoViewModel$delegate", "Lkotlin/Lazy;", "takeSingleOrMultipleView", "Lcom/tera/scan/scanner/ocr/control/TakeSingleOrMultipleView;", "tipRunnable", "Ljava/lang/Runnable;", "ubcSource", "vibrateManager", "Lcom/tera/scan/scanner/ocr/OCRVibrateManager;", "callBackBitmap", "", "ocrAutoScanControl", "Lcom/tera/scan/scanner/ocr/control/OCRAutoScanControl;", "result", "Lcom/otaliastudios/cameraview/PictureResult;", "callBackFile", "dispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "enterTakingMode", "enterpriseUbc", "value", "exitTakingMode", "exitTakingModeWithConfirm", "isPrevious", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "exit", "generateImageName", "getAutoScanConfig", "getCategory", "getCurrentTab", "()Ljava/lang/Integer;", "getLayoutId", "getPictureSize", "Lcom/otaliastudios/cameraview/size/Size;", "getPreviewRect", "Landroid/graphics/Rect;", "handleOtherRequestCode", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "hasCameraPermission", "hideTipView", "initBottomUIAdapter", "initCacheDir", "initDefaultTab", "initFragment", "initListeners", "initParams", "initTitleBar", "initTouchEvent", "initView", "isActivityDark", "isCertificateTakingType", "isCertificateTakingType$scanner_aiscanConfigRelease", "isSelectScanIdCardsControlAndPictureEmpty", "needSetStatusBar", "notifyPictureSizeChanged", "size", "onActivityResult", "onBackBusinessFinish", "onBackPressed", "onClick", "v", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onItemClick", "position", "onNewIntent", "intent", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onStop", "onTouchEvent", "permissionRequest", "refreshTitleBar", "reportEvent", "restoreOCRCameraSize", "scanIdCardShowTypeChangeCallBack", "tabs", "", "Lcom/tera/scan/scanner/ocr/OCRBottomTab;", "setActivityBg", "setCarmeSize", "layoutWHParams", "setDefaultTab", "setPictureSize", "setRightLayoutVisible", "tabType", "setZoom", "zoom", "", "showCertificateScanTitleBar", "showDocScanTitleBar", "showOtherTitleBar", "showTakeShotTitleBar", "showTipView", "stringResource", "tabToFrom", "tab", "takePhoto", "takePhotoButtonClick", "ChooseSizeAction", "Companion", "FlashAction", "OcrAutoCropAction", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCRTakePhotoActivity extends BaseActivity implements OnItemClickListener, IOCRTakePhotoView, View.OnClickListener {
    @NotNull
    public static final String AI_SCAN_NODE = "ai_scan_node";
    @NotNull
    public static final String AUTO_SWITCH_SHOW_COUNT = "auto_switch_show_count";
    @NotNull
    public static final String AUTO_SWITCH_SHOW_LAST_TIME = "auto_switch_show_last_time";
    @NotNull
    public static final ad Companion = new ad((DefaultConstructorMarker) null);
    @NotNull
    public static final String EXTRA_CATEGORY = "extra_category";
    @NotNull
    public static final String EXTRA_DOC_SCAN_MODE = "doc_scan_mode";
    @NotNull
    public static final String EXTRA_FROM = "extra_from";
    @NotNull
    public static final String EXTRA_PDF_ADD_COUNT = "extra_pdf_add_count";
    @NotNull
    public static final String EXTRA_PDF_MODE = "extra_pdf_mode";
    @NotNull
    public static final String EXTRA_PDF_RE_CHOOSE_PAGE = "extra_pdf_re_choose_page";
    @NotNull
    public static final String EXTRA_RESULT_CATEGORY = "extra_result_category";
    @NotNull
    public static final String EXTRA_RESULT_FILES = "extra_result_files";
    @NotNull
    public static final String EXTRA_SCAN_FILTER_INDEX = "doc_scan_filter_index";
    @NotNull
    public static final String EXTRA_SUB_INDEX = "extra_sub_index";
    @NotNull
    public static final String EXTRA_TAB = "extra_tab";
    @NotNull
    public static final String EXTRA_UBC_SOURCE = "extra_ubc_source";
    public static final int PDF_MODE_ADD = 2;
    public static final int PDF_MODE_APPEND = 3;
    public static final int PDF_MODE_DEFAULT = 0;
    public static final int PDF_MODE_RE_CHOOSE = 1;
    @NotNull
    public static final String PHOTO_CACHE_DIR = "/ocr/photo/";
    @NotNull
    public static final String ROUTER_FROM = "from";
    @NotNull
    public static final String ROUTER_INIT_CATEGORY = "initCategory";
    @NotNull
    public static final String ROUTER_INIT_TAB = "initTab";
    @NotNull
    public static final String ROUTER_INIT_TAB_CERTIFICATE = "certificate";
    @NotNull
    public static final String ROUTER_INIT_TAB_DEFAULT = "default";
    @NotNull
    public static final String ROUTER_INIT_TAB_ID_PHOTO = "id_photo";
    @NotNull
    public static final String ROUTER_INIT_TAB_PAPER = "paper";
    @NotNull
    public static final String ROUTER_INIT_TAB_PDF = "pdf";
    @NotNull
    public static final String ROUTER_INIT_TAB_PIC_TO_EXCEL = "pic_to_excel";
    @NotNull
    public static final String ROUTER_INIT_TAB_PIC_TO_WORD = "pic_to_word";
    @NotNull
    public static final String ROUTER_INIT_TAB_QRCODE = "qrcode";
    @NotNull
    public static final String ROUTER_INIT_TAB_REMOVE_HANDWRITTEN = "removeHandWritten";
    @NotNull
    public static final String ROUTER_INIT_TAB_REMOVE_WATER_MARK = "removeWater";
    @NotNull
    public static final String ROUTER_INIT_TAB_TAKE_SHOT = "ai_scan";
    @NotNull
    public static final String ROUTER_INIT_TAB_TRANSLATE = "translate";
    @NotNull
    public static final String ROUTER_INIT_TAB_WORD = "word";
    public static final int TAB_TO_AI_TRANSLATE = 8;
    public static final int TAB_TO_CERTIFICATES = 3;
    public static final int TAB_TO_CONVERT_EXCEL = 7;
    public static final int TAB_TO_CONVERT_WORD = 6;
    public static final int TAB_TO_DEFAULT = 1;
    public static final int TAB_TO_ID_PHOTO = 5;
    public static final int TAB_TO_PAPER_REMOVE_HANDWRITTEN = 4;
    public static final int TAB_TO_PDF = 2;
    public static final int TAB_TO_QR_CODE = 0;
    public static final int TAB_TO_REMOVE_WATER_MARKER = 9;
    public static final int TAB_TO_WORD = 1;
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    public CenterItemDecoration bottomCenterItemDecoration;
    @Nullable
    public CenterLayoutManager bottomLayoutManager;
    @Nullable
    public Cswitch bottomTabConfig;
    @Nullable
    public OCRBottomAdapter bottomUIAdapter;
    public String cacheDir;
    @Autowired(name = "initCategory", required = false)
    @JvmField
    public int category = -1;
    @Nullable
    public LinearLayout choosePictureSize;
    @Nullable
    public View chooseSizeContainer;
    @Nullable
    public CameraNewFragment containerFragment;
    @Nullable
    public CustomizedTitleBar customizedTitleBar;
    public int defaultTab = 1;
    @Nullable
    public String docSavePath;
    @Nullable
    public UIFrameLayout fragmentContainer;
    @Autowired(name = "from", required = false)
    @JvmField
    public int from = 2;
    @Nullable
    public GestureDetector gestureDetector;
    @NotNull
    @Autowired(name = "initTab", required = false)
    @JvmField
    public String initTab = "default";
    @Nullable
    public RecyclerView ocrBottomRecyclerview;
    @Nullable
    public TextView ocrTakingTab;
    public int pdfAddCount;
    public int pdfMode;
    public int pdfReChoosePage;
    public int screenHeight;
    public int subIndex;
    @Nullable
    public ImageView takePhotoButton;
    @Nullable
    public TextView takePhotoPreviousStep;
    @NotNull
    public final Lazy takePhotoViewModel$delegate = LazyKt__LazyJVMKt.lazy(new OCRTakePhotoActivity$takePhotoViewModel$2(this));
    @Nullable
    public TakeSingleOrMultipleView takeSingleOrMultipleView;
    @Nullable
    public Runnable tipRunnable;
    @NotNull
    @Autowired(name = "ubcSource", required = false)
    @JvmField
    public String ubcSource = "";
    @Nullable
    public Cif vibrateManager;

    public static final class ad {
        public ad() {
        }

        public /* synthetic */ ad(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent de(ad adVar, Context context, String str, int i2, int i3, int i4, int i5, int i6, int i7, String str2, int i8, Object obj) {
            int i9 = i8;
            return adVar.qw(context, (i9 & 2) != 0 ? "default" : str, (i9 & 4) != 0 ? 0 : i2, (i9 & 8) != 0 ? 0 : i3, (i9 & 16) != 0 ? 0 : i4, (i9 & 32) != 0 ? 0 : i5, i6, (i9 & 128) != 0 ? -1 : i7, str2);
        }

        public static /* synthetic */ Intent fe(ad adVar, Context context, String str, int i2, int i3, int i4, int i5, String str2, int i6, Object obj) {
            return adVar.ad(context, (i6 & 2) != 0 ? "default" : str, (i6 & 4) != 0 ? 0 : i2, (i6 & 8) != 0 ? 0 : i3, (i6 & 16) != 0 ? 0 : i4, i5, str2);
        }

        @JvmStatic
        @NotNull
        public final Intent ad(@NotNull Context context, @NotNull String str, int i2, int i3, int i4, int i5, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "tab");
            String str3 = str2;
            Intrinsics.checkNotNullParameter(str3, "ubcSource");
            return de(this, context, str, i2, i3, 0, i4, i5, -1, str3, 16, (Object) null);
        }

        @JvmStatic
        @NotNull
        public final Intent qw(@NotNull Context context, @NotNull String str, int i2, int i3, int i4, int i5, int i6, int i7, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "tab");
            Intrinsics.checkNotNullParameter(str2, "ubcSource");
            Intent intent = new Intent(context, OCRTakePhotoActivity.class);
            intent.putExtra(OCRTakePhotoActivity.EXTRA_TAB, str);
            intent.putExtra(OCRTakePhotoActivity.EXTRA_PDF_MODE, i2);
            intent.putExtra(OCRTakePhotoActivity.EXTRA_SUB_INDEX, i4);
            intent.putExtra(OCRTakePhotoActivity.EXTRA_PDF_RE_CHOOSE_PAGE, i3);
            intent.putExtra(OCRTakePhotoActivity.EXTRA_PDF_ADD_COUNT, i5);
            intent.putExtra(OCRTakePhotoActivity.EXTRA_FROM, i6);
            intent.putExtra(OCRTakePhotoActivity.EXTRA_CATEGORY, i7);
            intent.putExtra("extra_ubc_source", str2);
            return intent;
        }
    }

    public final class de extends CustomizedTitleBar.qw {
        public de(int i2) {
            super(i2);
        }

        public int de() {
            CameraNewFragment access$getContainerFragment$p = OCRTakePhotoActivity.this.containerFragment;
            boolean z = true;
            if (access$getContainerFragment$p == null || !access$getContainerFragment$p.getFlash()) {
                z = false;
            }
            return z ? R.drawable.ocr_flash_on : R.drawable.ocr_flash_off;
        }

        public void qw(@Nullable View view) {
            CameraNewFragment access$getContainerFragment$p = OCRTakePhotoActivity.this.containerFragment;
            if (access$getContainerFragment$p != null) {
                OCRTakePhotoActivity oCRTakePhotoActivity = OCRTakePhotoActivity.this;
                boolean z = !access$getContainerFragment$p.getFlash();
                access$getContainerFragment$p.setFlash(z);
                fe.mmm.qw.ggg.qw.qw.qw("take_pictures_page_flashlight_click", CollectionsKt__CollectionsJVMKt.listOf(fe.mmm.qw.tt.ad.nn.qw.ad(z)));
                oCRTakePhotoActivity.refreshTitleBar();
                boolean flash = access$getContainerFragment$p.getFlash();
            }
        }
    }

    public final class fe extends CustomizedTitleBar.qw {
        public fe(int i2) {
            super(i2);
        }

        public int de() {
            return OCRTakePhotoActivity.this.getTakePhotoViewModel().isAutoScanSwitchOpen() ? R.drawable.ocr_auto_scan : R.drawable.ocr_auto_scan_off;
        }

        public void qw(@Nullable View view) {
            if (OCRTakePhotoActivity.this.getTakePhotoViewModel().isTakingMode()) {
                o.th(OCRTakePhotoActivity.this, R.string.string_crop_not_change);
                return;
            }
            View access$getChooseSizeContainer$p = OCRTakePhotoActivity.this.chooseSizeContainer;
            boolean z = false;
            if (access$getChooseSizeContainer$p != null) {
                if (access$getChooseSizeContainer$p.getVisibility() == 0) {
                    z = true;
                }
            }
            if (z) {
                View access$getChooseSizeContainer$p2 = OCRTakePhotoActivity.this.chooseSizeContainer;
                if (access$getChooseSizeContainer$p2 != null) {
                    access$getChooseSizeContainer$p2.setVisibility(8);
                    return;
                }
                return;
            }
            OCRTakePhotoActivity.this.getTakePhotoViewModel().setAutoScanSwitch(!OCRTakePhotoActivity.this.getTakePhotoViewModel().isAutoScanSwitchOpen());
            OCRTakePhotoActivity.this.refreshTitleBar();
        }
    }

    public final class qw extends CustomizedTitleBar.qw {

        /* renamed from: com.tera.scan.scanner.ocr.OCRTakePhotoActivity$qw$qw  reason: collision with other inner class name */
        public static final class C0267qw<T> implements Comparator {
            public final int compare(T t, T t2) {
                return ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((fe.vvv.qw.xxx.ad) t2).fe()), Integer.valueOf(((fe.vvv.qw.xxx.ad) t).fe()));
            }
        }

        public qw(int i2) {
            super(i2);
        }

        public static final void th(OCRTakePhotoActivity oCRTakePhotoActivity, fe.vvv.qw.xxx.ad adVar, qw qwVar, View view) {
            Intrinsics.checkNotNullParameter(oCRTakePhotoActivity, "this$0");
            Intrinsics.checkNotNullParameter(adVar, "$it");
            Intrinsics.checkNotNullParameter(qwVar, "this$1");
            oCRTakePhotoActivity.setPictureSize(adVar);
            fe.mmm.qw.ggg.qw.qw.qw("take_pictures_page_clarity_choose_click", CollectionsKt__CollectionsJVMKt.listOf(fe.mmm.qw.tt.ad.nn.qw.qw(adVar)));
            View access$getChooseSizeContainer$p = oCRTakePhotoActivity.chooseSizeContainer;
            if (access$getChooseSizeContainer$p != null) {
                access$getChooseSizeContainer$p.setVisibility(8);
            }
            th.ppp().pf("key_ocr_last_camera_width", adVar.rg());
            th.ppp().pf("key_ocr_last_camera_height", adVar.fe());
            qwVar.yj(adVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
            r0 = r0.getCameraSizeSelector();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int de() {
            /*
                r1 = this;
                com.tera.scan.scanner.ocr.OCRTakePhotoActivity r0 = com.tera.scan.scanner.ocr.OCRTakePhotoActivity.this
                com.tera.scan.scanner.ui.cameranew.CameraNewFragment r0 = r0.containerFragment
                if (r0 == 0) goto L_0x0013
                fe.mmm.qw.tt.rg.ad.i r0 = r0.getCameraSizeSelector()
                if (r0 == 0) goto L_0x0013
                fe.vvv.qw.xxx.ad r0 = r0.ad()
                goto L_0x0014
            L_0x0013:
                r0 = 0
            L_0x0014:
                if (r0 != 0) goto L_0x001b
                int r0 = super.de()
                return r0
            L_0x001b:
                int r0 = fe.mmm.qw.tt.ad.mmm.qw.qw.qw(r0)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.scanner.ocr.OCRTakePhotoActivity.qw.de():int");
        }

        public final String fe(fe.vvv.qw.xxx.ad adVar) {
            StringBuilder sb = new StringBuilder();
            sb.append(adVar.fe());
            sb.append('*');
            sb.append(adVar.rg());
            return sb.toString();
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0031  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0040  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void qw(@org.jetbrains.annotations.Nullable android.view.View r12) {
            /*
                r11 = this;
                com.tera.scan.scanner.ocr.OCRTakePhotoActivity r12 = com.tera.scan.scanner.ocr.OCRTakePhotoActivity.this
                com.tera.scan.scanner.ui.cameranew.CameraNewFragment r12 = r12.containerFragment
                if (r12 != 0) goto L_0x0009
                return
            L_0x0009:
                java.util.Collection r0 = r12.getSupportPictureSizes()
                if (r0 == 0) goto L_0x0112
                java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList(r0)
                if (r0 != 0) goto L_0x0017
                goto L_0x0112
            L_0x0017:
                com.tera.scan.scanner.ocr.OCRTakePhotoActivity r1 = com.tera.scan.scanner.ocr.OCRTakePhotoActivity.this
                android.view.View r1 = r1.chooseSizeContainer
                r2 = 1
                r3 = 0
                if (r1 == 0) goto L_0x002e
                int r1 = r1.getVisibility()
                if (r1 != 0) goto L_0x0029
                r1 = 1
                goto L_0x002a
            L_0x0029:
                r1 = 0
            L_0x002a:
                if (r1 != r2) goto L_0x002e
                r1 = 1
                goto L_0x002f
            L_0x002e:
                r1 = 0
            L_0x002f:
                if (r1 == 0) goto L_0x0040
                com.tera.scan.scanner.ocr.OCRTakePhotoActivity r12 = com.tera.scan.scanner.ocr.OCRTakePhotoActivity.this
                android.view.View r12 = r12.chooseSizeContainer
                if (r12 != 0) goto L_0x003a
                goto L_0x003f
            L_0x003a:
                r0 = 8
                r12.setVisibility(r0)
            L_0x003f:
                return
            L_0x0040:
                fe.vvv.qw.xxx.ad r12 = r12.getPictureSize()
                fe.mmm.qw.tt.rg.ad.i r1 = new fe.mmm.qw.tt.rg.ad.i
                r4 = 0
                r1.<init>(r4, r2, r4)
                java.util.List r0 = r1.qw(r0)
                int r1 = r0.size()
                if (r1 <= r2) goto L_0x005c
                com.tera.scan.scanner.ocr.OCRTakePhotoActivity$qw$qw r1 = new com.tera.scan.scanner.ocr.OCRTakePhotoActivity$qw$qw
                r1.<init>()
                kotlin.collections.CollectionsKt__MutableCollectionsJVMKt.sortWith(r0, r1)
            L_0x005c:
                boolean r1 = r0.isEmpty()
                if (r1 == 0) goto L_0x0063
                return
            L_0x0063:
                r11.uk(r12)
                fe.mmm.qw.ggg.qw r1 = fe.mmm.qw.ggg.qw.qw
                java.lang.String r5 = fe.mmm.qw.tt.ad.nn.qw.qw(r12)
                java.util.List r5 = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r5)
                java.lang.String r6 = "take_pictures_page_choose_size_show"
                r1.qw(r6, r5)
                com.tera.scan.scanner.ocr.OCRTakePhotoActivity r1 = com.tera.scan.scanner.ocr.OCRTakePhotoActivity.this
                android.widget.LinearLayout r1 = r1.choosePictureSize
                if (r1 == 0) goto L_0x0080
                r1.removeAllViews()
            L_0x0080:
                com.tera.scan.scanner.ocr.OCRTakePhotoActivity r1 = com.tera.scan.scanner.ocr.OCRTakePhotoActivity.this
                java.util.Iterator r0 = r0.iterator()
            L_0x0086:
                boolean r5 = r0.hasNext()
                if (r5 == 0) goto L_0x0106
                java.lang.Object r5 = r0.next()
                fe.vvv.qw.xxx.ad r5 = (fe.vvv.qw.xxx.ad) r5
                java.lang.String r6 = r11.rg(r5)
                java.lang.String r7 = r11.fe(r5)
                if (r12 == 0) goto L_0x00a8
                int r8 = r12.rg()
                int r9 = r5.rg()
                if (r8 != r9) goto L_0x00a8
                r8 = 1
                goto L_0x00a9
            L_0x00a8:
                r8 = 0
            L_0x00a9:
                if (r8 == 0) goto L_0x00b7
                int r8 = r12.fe()
                int r9 = r5.fe()
                if (r8 != r9) goto L_0x00b7
                r8 = 1
                goto L_0x00b8
            L_0x00b7:
                r8 = 0
            L_0x00b8:
                android.view.LayoutInflater r9 = android.view.LayoutInflater.from(r1)
                r10 = 2131558456(0x7f0d0038, float:1.8742228E38)
                android.view.View r9 = r9.inflate(r10, r4, r3)
                if (r9 == 0) goto L_0x00fe
                android.view.ViewGroup r9 = (android.view.ViewGroup) r9
                r9.setSelected(r8)
                r8 = 2131363378(0x7f0a0632, float:1.8346563E38)
                android.view.View r8 = r9.findViewById(r8)
                android.widget.TextView r8 = (android.widget.TextView) r8
                r8.setText(r6)
                r6 = 2131363377(0x7f0a0631, float:1.8346561E38)
                android.view.View r6 = r9.findViewById(r6)
                android.widget.TextView r6 = (android.widget.TextView) r6
                r6.setText(r7)
                fe.mmm.qw.tt.ad.qw r6 = new fe.mmm.qw.tt.ad.qw
                r6.<init>(r1, r5, r11)
                r9.setOnClickListener(r6)
                android.widget.LinearLayout$LayoutParams r5 = new android.widget.LinearLayout$LayoutParams
                r6 = -1
                r5.<init>(r3, r6)
                r6 = 1065353216(0x3f800000, float:1.0)
                r5.weight = r6
                android.widget.LinearLayout r6 = r1.choosePictureSize
                if (r6 == 0) goto L_0x0086
                r6.addView(r9, r5)
                goto L_0x0086
            L_0x00fe:
                java.lang.NullPointerException r12 = new java.lang.NullPointerException
                java.lang.String r0 = "null cannot be cast to non-null type android.view.ViewGroup"
                r12.<init>(r0)
                throw r12
            L_0x0106:
                com.tera.scan.scanner.ocr.OCRTakePhotoActivity r12 = com.tera.scan.scanner.ocr.OCRTakePhotoActivity.this
                android.view.View r12 = r12.chooseSizeContainer
                if (r12 != 0) goto L_0x010f
                goto L_0x0112
            L_0x010f:
                r12.setVisibility(r3)
            L_0x0112:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.scanner.ocr.OCRTakePhotoActivity.qw.qw(android.view.View):void");
        }

        public final String rg(fe.vvv.qw.xxx.ad adVar) {
            if (adVar.fe() >= 4000) {
                String string = OCRTakePhotoActivity.this.getString(R.string.camera_size_title_4);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.camera_size_title_4)");
                return string;
            } else if (adVar.fe() >= 3000) {
                String string2 = OCRTakePhotoActivity.this.getString(R.string.camera_size_title_3);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.camera_size_title_3)");
                return string2;
            } else if (adVar.fe() >= 2000) {
                String string3 = OCRTakePhotoActivity.this.getString(R.string.camera_size_title_2);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.camera_size_title_2)");
                return string3;
            } else {
                String string4 = OCRTakePhotoActivity.this.getString(R.string.camera_size_title_1);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.camera_size_title_1)");
                return string4;
            }
        }

        public final void uk(fe.vvv.qw.xxx.ad adVar) {
            if (adVar != null && adVar.fe() <= 4000 && adVar.fe() <= 3000) {
                int fe2 = adVar.fe();
            }
        }

        public final void yj(fe.vvv.qw.xxx.ad adVar) {
            String str;
            if (adVar != null) {
                if (adVar.fe() > 4000) {
                    str = "Ultra";
                } else if (adVar.fe() > 3000) {
                    str = "HD";
                } else {
                    str = adVar.fe() > 2000 ? "Standard" : "Mini";
                }
                OCRTakePhotoActivity oCRTakePhotoActivity = OCRTakePhotoActivity.this;
                fe.mmm.qw.tt.fe.qw.ad("Clarity_slt_clk", "CameraPage", (String) null, oCRTakePhotoActivity.ubcSource, MapsKt__MapsKt.mapOf(TuplesKt.to("ScanButton", fe.mmm.qw.tt.qw.qw.qw(oCRTakePhotoActivity.getCategory())), TuplesKt.to("definition", str)), 4, (Object) null);
            }
        }
    }

    public static final class rg implements CameraNewFragment.IPictureListener {
        public final /* synthetic */ OCRTakePhotoActivity qw;

        public rg(OCRTakePhotoActivity oCRTakePhotoActivity) {
            this.qw = oCRTakePhotoActivity;
        }

        public void ad(@NotNull fe.vvv.qw.ad adVar) {
            Intrinsics.checkNotNullParameter(adVar, "options");
            OCRBottomAdapter bottomUIAdapter$scanner_aiscanConfigRelease = this.qw.getBottomUIAdapter$scanner_aiscanConfigRelease();
            if (bottomUIAdapter$scanner_aiscanConfigRelease != null && bottomUIAdapter$scanner_aiscanConfigRelease.getCurrentTab() == 0) {
                this.qw.setZoom(0.15f);
            }
        }

        /* JADX WARNING: type inference failed for: r0v8, types: [com.tera.scan.scanner.ocr.control.IOCRTakePhotoControl] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void de(@org.jetbrains.annotations.NotNull fe.vvv.qw.fe r5) {
            /*
                r4 = this;
                java.lang.String r0 = "result"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "pic height:"
                r0.append(r1)
                fe.vvv.qw.xxx.ad r1 = r5.ad()
                int r1 = r1.fe()
                r0.append(r1)
                java.lang.String r1 = ",width:"
                r0.append(r1)
                fe.vvv.qw.xxx.ad r1 = r5.ad()
                int r1 = r1.rg()
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r1 = 0
                r2 = 1
                com.mars.kotlin.extension.LoggerKt.d$default(r0, r1, r2, r1)
                com.tera.scan.scanner.ocr.OCRTakePhotoActivity r0 = r4.qw
                com.tera.scan.scanner.ocr.OCRBottomAdapter r0 = r0.getBottomUIAdapter$scanner_aiscanConfigRelease()
                if (r0 != 0) goto L_0x003c
                return
            L_0x003c:
                int r2 = r0.getCurrentTab()
                int r2 = r0.getPosition(r2)
                java.util.List r3 = r0.getItems()
                int r3 = r3.size()
                if (r2 < r3) goto L_0x004f
                return
            L_0x004f:
                java.util.List r0 = r0.getItems()
                java.lang.Object r0 = r0.get(r2)
                fe.mmm.qw.tt.ad.i r0 = (fe.mmm.qw.tt.ad.i) r0
                com.tera.scan.scanner.ocr.control.IOCRTakePhotoControl r0 = r0.ad()
                boolean r2 = r0 instanceof com.tera.scan.scanner.ocr.control.OCRAutoScanControl
                if (r2 == 0) goto L_0x0064
                r1 = r0
                com.tera.scan.scanner.ocr.control.OCRAutoScanControl r1 = (com.tera.scan.scanner.ocr.control.OCRAutoScanControl) r1
            L_0x0064:
                if (r1 == 0) goto L_0x006c
                com.tera.scan.scanner.ocr.OCRTakePhotoActivity r0 = r4.qw
                r0.callBackBitmap(r1, r5)
                return
            L_0x006c:
                com.tera.scan.scanner.ocr.OCRTakePhotoActivity r0 = r4.qw
                r0.callBackFile(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.scanner.ocr.OCRTakePhotoActivity.rg.de(fe.vvv.qw.fe):void");
        }

        public void qw(@NotNull fe.vvv.qw.o.qw qwVar, int i2, int i3) {
            Intrinsics.checkNotNullParameter(qwVar, "frame");
            OCRBottomAdapter bottomUIAdapter$scanner_aiscanConfigRelease = this.qw.getBottomUIAdapter$scanner_aiscanConfigRelease();
            if (bottomUIAdapter$scanner_aiscanConfigRelease != null && !this.qw.isFinishing() && ArraysKt___ArraysKt.contains(new int[]{0, 6, 7, 2, 8, 4, 9}, bottomUIAdapter$scanner_aiscanConfigRelease.getCurrentTab())) {
                bottomUIAdapter$scanner_aiscanConfigRelease.getItems().get(bottomUIAdapter$scanner_aiscanConfigRelease.getCurPosition()).ad().qw(qwVar, i2, i3);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void callBackBitmap(OCRAutoScanControl oCRAutoScanControl, fe.vvv.qw.fe feVar) {
        feVar.fe(new fe.mmm.qw.tt.ad.ad(this, oCRAutoScanControl));
    }

    /* renamed from: callBackBitmap$lambda-14  reason: not valid java name */
    public static final void m894callBackBitmap$lambda14(OCRTakePhotoActivity oCRTakePhotoActivity, OCRAutoScanControl oCRAutoScanControl, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(oCRTakePhotoActivity, "this$0");
        Intrinsics.checkNotNullParameter(oCRAutoScanControl, "$ocrAutoScanControl");
        if (bitmap != null && !oCRTakePhotoActivity.isFinishing()) {
            String de2 = fe.mmm.qw.j.ddd.de.de(BaseApplication.getInstance());
            StringBuilder sb = new StringBuilder();
            String str = oCRTakePhotoActivity.cacheDir;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cacheDir");
                str = null;
            }
            sb.append(str);
            sb.append(oCRTakePhotoActivity.generateImageName());
            String fe2 = fe.mmm.qw.j.ddd.de.fe(sb.toString(), de2);
            Intrinsics.checkNotNullExpressionValue(fe2, "imgCompressPath");
            oCRAutoScanControl.aaa(bitmap, fe2);
        }
    }

    /* access modifiers changed from: private */
    public final void callBackFile(fe.vvv.qw.fe feVar) {
        StringBuilder sb = new StringBuilder();
        String str = this.cacheDir;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cacheDir");
            str = null;
        }
        sb.append(str);
        sb.append(generateImageName());
        feVar.rg(new File(sb.toString()), new fe.mmm.qw.tt.ad.th(this));
    }

    /* renamed from: callBackFile$lambda-13  reason: not valid java name */
    public static final void m895callBackFile$lambda13(OCRTakePhotoActivity oCRTakePhotoActivity, File file) {
        int position;
        Intrinsics.checkNotNullParameter(oCRTakePhotoActivity, "this$0");
        OCRBottomAdapter oCRBottomAdapter = oCRTakePhotoActivity.bottomUIAdapter;
        if (oCRBottomAdapter != null && !oCRTakePhotoActivity.isFinishing() && file != null) {
            if (fe.mmm.qw.tt.ad.ggg.ad.qw(oCRBottomAdapter.getCurrentTab(), 1, 6, 7, 2, 3, 4, 5) && (position = oCRBottomAdapter.getPosition(oCRBottomAdapter.getCurrentTab())) < oCRBottomAdapter.getItems().size()) {
                oCRBottomAdapter.getItems().get(position).ad().th(file);
            }
            ImageView imageView = oCRTakePhotoActivity.takePhotoButton;
            if (imageView != null) {
                imageView.setEnabled(true);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r0 = r0.getCurrentTabItem();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void enterTakingMode() {
        /*
            r4 = this;
            com.tera.scan.scanner.ocr.viewmodel.OCRTakePhotoViewModel r0 = r4.getTakePhotoViewModel()
            r1 = 1
            r0.setIsTakingMode(r1)
            com.tera.scan.scanner.ocr.OCRBottomAdapter r0 = r4.bottomUIAdapter
            r1 = 0
            if (r0 == 0) goto L_0x0018
            fe.mmm.qw.tt.ad.i r0 = r0.getCurrentTabItem()
            if (r0 == 0) goto L_0x0018
            com.tera.scan.scanner.ocr.control.IOCRTakePhotoControl r0 = r0.ad()
            goto L_0x0019
        L_0x0018:
            r0 = r1
        L_0x0019:
            boolean r0 = r0 instanceof com.tera.scan.scanner.ocr.control.ScanIdCardsControl
            if (r0 == 0) goto L_0x0032
            fe.mmm.qw.ggg.qw r0 = fe.mmm.qw.ggg.qw.qw
            r2 = 2
            java.lang.String r3 = "camera_id_cards_last_step_show"
            com.tera.scan.libanalytics.ScanAnalyticsBaseEvent.qw.qw(r0, r3, r1, r2, r1)
            int r0 = r4.pdfMode
            if (r0 != 0) goto L_0x0032
            android.widget.TextView r0 = r4.takePhotoPreviousStep
            if (r0 != 0) goto L_0x002e
            goto L_0x0032
        L_0x002e:
            r1 = 0
            r0.setVisibility(r1)
        L_0x0032:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.scanner.ocr.OCRTakePhotoActivity.enterTakingMode():void");
    }

    private final void enterpriseUbc(String str) {
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002f, code lost:
        r0 = r0.getCurrentTabItem();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void exitTakingModeWithConfirm(boolean r11, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r12) {
        /*
            r10 = this;
            com.tera.scan.scanner.ocr.OCRBottomAdapter r0 = r10.bottomUIAdapter
            if (r0 == 0) goto L_0x0016
            fe.mmm.qw.tt.ad.i r0 = r0.getCurrentTabItem()
            if (r0 == 0) goto L_0x0016
            com.tera.scan.scanner.ocr.control.IOCRTakePhotoControl r0 = r0.ad()
            if (r0 == 0) goto L_0x0016
            java.util.List r0 = r0.yj()
            if (r0 != 0) goto L_0x001a
        L_0x0016:
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x001a:
            r5 = r0
            boolean r0 = r5.isEmpty()
            if (r0 == 0) goto L_0x002a
            r10.exitTakingMode()
            java.lang.Boolean r11 = java.lang.Boolean.TRUE
            r12.invoke(r11)
            return
        L_0x002a:
            com.tera.scan.scanner.ocr.OCRBottomAdapter r0 = r10.bottomUIAdapter
            r7 = 0
            if (r0 == 0) goto L_0x003a
            fe.mmm.qw.tt.ad.i r0 = r0.getCurrentTabItem()
            if (r0 == 0) goto L_0x003a
            com.tera.scan.scanner.ocr.control.IOCRTakePhotoControl r0 = r0.ad()
            goto L_0x003b
        L_0x003a:
            r0 = r7
        L_0x003b:
            boolean r0 = r0 instanceof com.tera.scan.scanner.ocr.control.ScanIdCardsControl
            com.tera.scan.scanner.ocr.widget.ChangeScanTabDialog r8 = new com.tera.scan.scanner.ocr.widget.ChangeScanTabDialog
            r8.<init>(r0)
            com.tera.scan.scanner.ocr.OCRTakePhotoActivity$exitTakingModeWithConfirm$1 r9 = new com.tera.scan.scanner.ocr.OCRTakePhotoActivity$exitTakingModeWithConfirm$1
            r1 = r9
            r2 = r0
            r3 = r10
            r4 = r11
            r6 = r12
            r1.<init>(r2, r3, r4, r5, r6)
            r8.fe(r9)
            com.tera.scan.scanner.ocr.OCRTakePhotoActivity$exitTakingModeWithConfirm$2 r11 = new com.tera.scan.scanner.ocr.OCRTakePhotoActivity$exitTakingModeWithConfirm$2
            r11.<init>(r0, r12)
            r8.de(r11)
            if (r0 == 0) goto L_0x0061
            fe.mmm.qw.ggg.qw r11 = fe.mmm.qw.ggg.qw.qw
            r12 = 2
            java.lang.String r0 = "camera_id_cards_discard_content_show"
            com.tera.scan.libanalytics.ScanAnalyticsBaseEvent.qw.qw(r11, r0, r7, r12, r7)
        L_0x0061:
            androidx.fragment.app.FragmentManager r11 = r10.getSupportFragmentManager()
            java.lang.String r12 = "supportFragmentManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)
            java.lang.String r12 = "ChangeScanTabDialog"
            r8.rg(r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.scanner.ocr.OCRTakePhotoActivity.exitTakingModeWithConfirm(boolean, kotlin.jvm.functions.Function1):void");
    }

    public static /* synthetic */ void exitTakingModeWithConfirm$default(OCRTakePhotoActivity oCRTakePhotoActivity, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        oCRTakePhotoActivity.exitTakingModeWithConfirm(z, function1);
    }

    private final String generateImageName() {
        String de2 = fe.mmm.qw.j.ddd.ad.de();
        int i2 = 0;
        String str = de2;
        while (true) {
            StringBuilder sb = new StringBuilder();
            String str2 = this.cacheDir;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cacheDir");
                str2 = null;
            }
            sb.append(str2);
            sb.append(str);
            sb.append(".jpg");
            if (fe.mmm.qw.j.xxx.ad.xxx(sb.toString())) {
                i2++;
                str = de2 + '_' + i2;
            } else {
                return str + ".jpg";
            }
        }
    }

    private final boolean getAutoScanConfig() {
        int rg2 = th.ppp().rg(AUTO_SWITCH_SHOW_COUNT, 0);
        long th2 = th.ppp().th(AUTO_SWITCH_SHOW_LAST_TIME, 0);
        if (rg2 <= 1 && (rg2 == 0 || rg2 != 1 || SystemClock.elapsedRealtime() - th2 >= 86400000)) {
            return false;
        }
        return true;
    }

    @JvmStatic
    @NotNull
    public static final Intent getStartIntent(@NotNull Context context, @NotNull String str, int i2, int i3, int i4, int i5, int i6, int i7, @NotNull String str2) {
        return Companion.qw(context, str, i2, i3, i4, i5, i6, i7, str2);
    }

    @JvmStatic
    @NotNull
    public static final Intent getStartIntent(@NotNull Context context, @NotNull String str, int i2, int i3, int i4, int i5, @NotNull String str2) {
        return Companion.ad(context, str, i2, i3, i4, i5, str2);
    }

    /* access modifiers changed from: private */
    public final OCRTakePhotoViewModel getTakePhotoViewModel() {
        return (OCRTakePhotoViewModel) this.takePhotoViewModel$delegate.getValue();
    }

    private final void handleOtherRequestCode(int i2, int i3, Intent intent) {
        int position;
        OCRBottomAdapter oCRBottomAdapter = this.bottomUIAdapter;
        if (oCRBottomAdapter != null) {
            if (fe.mmm.qw.tt.ad.ggg.ad.qw(oCRBottomAdapter.getCurrentTab(), 1, 6, 7, 2, 0, 3, 4, 5, 8, 9) && (position = oCRBottomAdapter.getPosition(oCRBottomAdapter.getCurrentTab())) < oCRBottomAdapter.getItems().size()) {
                oCRBottomAdapter.getItems().get(position).ad().onActivityResult(i2, i3, intent);
            }
        }
    }

    private final boolean hasCameraPermission() {
        return ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0;
    }

    private final void initBottomUIAdapter() {
        List<i> items;
        List<i> list;
        OCRBottomAdapter oCRBottomAdapter = this.bottomUIAdapter;
        if (oCRBottomAdapter != null && (items = oCRBottomAdapter.getItems()) != null) {
            items.clear();
            Cswitch switchR = this.bottomTabConfig;
            if (switchR == null || (list = switchR.yj()) == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            items.addAll(list);
            scanIdCardShowTypeChangeCallBack(items);
        }
    }

    private final void initCacheDir() {
        File externalCacheDir = getExternalCacheDir();
        String str = null;
        String absolutePath = externalCacheDir != null ? externalCacheDir.getAbsolutePath() : null;
        if (absolutePath == null) {
            absolutePath = getCacheDir().getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getCacheDir().absolutePath");
        }
        this.cacheDir = absolutePath + PHOTO_CACHE_DIR;
        String str2 = this.cacheDir;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cacheDir");
        } else {
            str = str2;
        }
        File file = new File(str);
        if (this.pdfMode == 0 && file.exists()) {
            fe.mmm.qw.j.xxx.ad.th(file);
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!fe.mmm.qw.j.xxx.ad.ppp(file)) {
            finish();
        }
    }

    private final int initDefaultTab() {
        return 2;
    }

    private final void initFragment() {
        CameraNewFragment cameraNewFragment = new CameraNewFragment();
        this.containerFragment = cameraNewFragment;
        if (cameraNewFragment != null) {
            cameraNewFragment.setPictureListener(new rg(this));
            Bundle bundle = new Bundle();
            bundle.putBoolean("show_grid", fe.mmm.qw.tt.ad.ggg.ad.qw(this.defaultTab, 1, 6, 7, 2, 4, 9));
            bundle.putBoolean("is_fit_camera_size", true);
            cameraNewFragment.setArguments(bundle);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "fm.beginTransaction()");
            beginTransaction.replace(R.id.fragment_container, cameraNewFragment);
            beginTransaction.commitAllowingStateLoss();
        }
        initTouchEvent();
    }

    private final void initListeners() {
        ImageView imageView = this.takePhotoButton;
        if (imageView != null) {
            imageView.setOnClickListener(new fe.mmm.qw.tt.ad.fe(this));
        }
        View view = this.chooseSizeContainer;
        if (view != null) {
            view.setOnClickListener(new yj(this));
        }
        TextView textView = this.takePhotoPreviousStep;
        if (textView != null) {
            fe.mmm.qw.th.qw.th.yj.de(textView, 0, new OCRTakePhotoActivity$initListeners$3(this), 1, (Object) null);
        }
    }

    /* JADX WARNING: type inference failed for: r7v5, types: [com.tera.scan.scanner.ocr.control.IOCRTakePhotoControl] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: initListeners$lambda-23  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m896initListeners$lambda23(com.tera.scan.scanner.ocr.OCRTakePhotoActivity r7, android.view.View r8) {
        /*
            java.lang.String r8 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r8)
            com.tera.scan.scanner.ocr.viewmodel.OCRTakePhotoViewModel r8 = r7.getTakePhotoViewModel()
            java.lang.String r3 = r8.getUbcSource$scanner_aiscanConfigRelease()
            int r8 = r7.getCategory()
            java.lang.String r8 = fe.mmm.qw.tt.qw.qw.qw(r8)
            java.lang.String r0 = "ScanButton"
            kotlin.Pair r8 = kotlin.TuplesKt.to(r0, r8)
            java.util.Map r4 = kotlin.collections.MapsKt__MapsJVMKt.mapOf(r8)
            java.lang.String r0 = "CamB_clk"
            java.lang.String r1 = "CameraPage"
            r2 = 0
            r5 = 4
            r6 = 0
            fe.mmm.qw.tt.fe.qw.ad(r0, r1, r2, r3, r4, r5, r6)
            boolean r8 = r7.hasCameraPermission()
            if (r8 != 0) goto L_0x0033
            r7.permissionRequest()
            return
        L_0x0033:
            r7.takePhotoButtonClick()
            fe.mmm.qw.ggg.qw r8 = fe.mmm.qw.ggg.qw.qw
            com.tera.scan.scanner.ocr.OCRBottomAdapter r0 = r7.bottomUIAdapter
            r1 = 0
            if (r0 == 0) goto L_0x0046
            int r0 = r0.getCurrentTab()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0047
        L_0x0046:
            r0 = r1
        L_0x0047:
            java.lang.String r0 = fe.mmm.qw.tt.ad.nn.qw.fe(r0)
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r0)
            java.lang.String r2 = "take_pictures_confirm_click"
            r8.qw(r2, r0)
            com.tera.scan.scanner.ocr.OCRBottomAdapter r7 = r7.bottomUIAdapter
            if (r7 == 0) goto L_0x0078
            int r8 = r7.getCurPosition()
            if (r8 < 0) goto L_0x0078
            java.util.List r7 = r7.getItems()
            java.lang.Object r7 = r7.get(r8)
            fe.mmm.qw.tt.ad.i r7 = (fe.mmm.qw.tt.ad.i) r7
            com.tera.scan.scanner.ocr.control.IOCRTakePhotoControl r7 = r7.ad()
            boolean r8 = r7 instanceof com.tera.scan.scanner.ocr.control.ScanIdCardsControl
            if (r8 == 0) goto L_0x0073
            r1 = r7
            com.tera.scan.scanner.ocr.control.ScanIdCardsControl r1 = (com.tera.scan.scanner.ocr.control.ScanIdCardsControl) r1
        L_0x0073:
            if (r1 == 0) goto L_0x0078
            r1.c()
        L_0x0078:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.scanner.ocr.OCRTakePhotoActivity.m896initListeners$lambda23(com.tera.scan.scanner.ocr.OCRTakePhotoActivity, android.view.View):void");
    }

    /* renamed from: initListeners$lambda-24  reason: not valid java name */
    public static final void m897initListeners$lambda24(OCRTakePhotoActivity oCRTakePhotoActivity, View view) {
        Intrinsics.checkNotNullParameter(oCRTakePhotoActivity, "this$0");
        View view2 = oCRTakePhotoActivity.chooseSizeContainer;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b0, code lost:
        r4 = r4.getItems();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initTab() {
        /*
            r7 = this;
            com.tera.scan.scanner.ocr.OCRBottomAdapter r0 = new com.tera.scan.scanner.ocr.OCRBottomAdapter
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 1
            r0.<init>(r1, r2, r7)
            r7.bottomUIAdapter = r0
            androidx.recyclerview.widget.RecyclerView r1 = r7.ocrBottomRecyclerview
            if (r1 != 0) goto L_0x0012
            goto L_0x0015
        L_0x0012:
            r1.setAdapter(r0)
        L_0x0015:
            com.tera.scan.scanner.ocr.widget.CenterLayoutManager r0 = new com.tera.scan.scanner.ocr.widget.CenterLayoutManager
            android.content.Context r1 = r7.getContext()
            java.lang.String r3 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            r3 = 0
            r0.<init>(r1, r3, r3)
            r7.bottomLayoutManager = r0
            androidx.recyclerview.widget.RecyclerView r1 = r7.ocrBottomRecyclerview
            if (r1 != 0) goto L_0x002b
            goto L_0x002e
        L_0x002b:
            r1.setLayoutManager(r0)
        L_0x002e:
            androidx.recyclerview.widget.LinearSnapHelper r0 = new androidx.recyclerview.widget.LinearSnapHelper
            r0.<init>()
            androidx.recyclerview.widget.RecyclerView r1 = r7.ocrBottomRecyclerview
            r0.attachToRecyclerView(r1)
            com.tera.scan.scanner.ocr.widget.CenterItemDecoration r0 = new com.tera.scan.scanner.ocr.widget.CenterItemDecoration
            r1 = 1118437376(0x42aa0000, float:85.0)
            int r1 = com.tera.scan.utils.SizeUtils.qw(r1)
            r0.<init>(r1)
            r7.bottomCenterItemDecoration = r0
            if (r0 == 0) goto L_0x004e
            androidx.recyclerview.widget.RecyclerView r1 = r7.ocrBottomRecyclerview
            if (r1 == 0) goto L_0x004e
            r1.addItemDecoration(r0)
        L_0x004e:
            androidx.recyclerview.widget.RecyclerView r0 = r7.ocrBottomRecyclerview
            if (r0 == 0) goto L_0x005f
            com.tera.scan.scanner.ocr.widget.CenterItemTouchListener r1 = new com.tera.scan.scanner.ocr.widget.CenterItemTouchListener
            com.tera.scan.scanner.ocr.OCRTakePhotoActivity$initTab$2$1 r4 = new com.tera.scan.scanner.ocr.OCRTakePhotoActivity$initTab$2$1
            r4.<init>(r7)
            r1.<init>(r0, r4)
            r0.setOnTouchListener(r1)
        L_0x005f:
            r7.initBottomUIAdapter()
            com.tera.scan.scanner.ocr.OCRBottomAdapter r0 = r7.bottomUIAdapter
            if (r0 == 0) goto L_0x00ed
            int r1 = r7.defaultTab
            int r1 = r0.getPosition(r1)
            r0.selectItem(r1)
            fe.mmm.qw.tt.ad.i r4 = r0.getCurrentTabItem()
            if (r4 == 0) goto L_0x007c
            com.tera.scan.scanner.ocr.viewmodel.OCRTakePhotoViewModel r5 = r7.getTakePhotoViewModel()
            r5.setCurrentBottomTab(r4)
        L_0x007c:
            int r4 = r7.from
            r5 = 2
            if (r4 != r5) goto L_0x0098
            java.lang.String r4 = r7.initTab
            java.lang.String r5 = "word"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x0098
            fe.mmm.qw.ggg.qw r4 = fe.mmm.qw.ggg.qw.qw
            java.lang.String r5 = "quick"
            java.util.List r5 = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r5)
            java.lang.String r6 = "ocr_scanning_page_show"
            r4.qw(r6, r5)
        L_0x0098:
            com.tera.scan.scanner.ui.cameranew.CameraNewFragment r4 = r7.containerFragment
            if (r4 == 0) goto L_0x00a7
            fe.mmm.qw.tt.ad.i r0 = r0.getCurrentTabItem()
            java.lang.String r0 = r7.tabToFrom(r0)
            r4.updateCurrentFrom(r0)
        L_0x00a7:
            com.tera.scan.scanner.ocr.widget.CenterItemDecoration r0 = r7.bottomCenterItemDecoration
            if (r0 != 0) goto L_0x00ac
            goto L_0x00c3
        L_0x00ac:
            com.tera.scan.scanner.ocr.OCRBottomAdapter r4 = r7.bottomUIAdapter
            if (r4 == 0) goto L_0x00bb
            java.util.List r4 = r4.getItems()
            if (r4 == 0) goto L_0x00bb
            int r4 = r4.size()
            goto L_0x00bc
        L_0x00bb:
            r4 = 0
        L_0x00bc:
            if (r4 <= r2) goto L_0x00bf
            goto L_0x00c0
        L_0x00bf:
            r2 = 0
        L_0x00c0:
            r0.setEnableCenter(r2)
        L_0x00c3:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "1 >>> "
            r0.append(r2)
            long r2 = java.lang.System.currentTimeMillis()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "OCRBottomBarScrollIdle"
            fe.mmm.qw.i.qw.ad(r2, r0)
            androidx.recyclerview.widget.RecyclerView r0 = r7.ocrBottomRecyclerview
            if (r0 == 0) goto L_0x00ed
            android.os.MessageQueue r2 = android.os.Looper.myQueue()
            fe.mmm.qw.tt.ad.vvv.qw r3 = new fe.mmm.qw.tt.ad.vvv.qw
            r3.<init>(r0, r1)
            r2.addIdleHandler(r3)
        L_0x00ed:
            int r0 = r7.defaultTab
            r7.setRightLayoutVisible(r0)
            com.tera.scan.scanner.ocr.viewmodel.OCRTakePhotoViewModel r0 = r7.getTakePhotoViewModel()
            boolean r0 = r0.isTakingMode()
            if (r0 == 0) goto L_0x00ff
            r7.enterTakingMode()
        L_0x00ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.scanner.ocr.OCRTakePhotoActivity.initTab():void");
    }

    private final void initTitleBar() {
        CustomizedTitleBar customizedTitleBar2 = (CustomizedTitleBar) findViewById(R.id.ocr_title_bar);
        this.customizedTitleBar = customizedTitleBar2;
        if (customizedTitleBar2 != null) {
            customizedTitleBar2.setLeftImageResource(R.drawable.close_ocr_camera);
            customizedTitleBar2.setLeftClickListener(new fe.mmm.qw.tt.ad.de(this));
            customizedTitleBar2.setTitleBarBackgroundColor(R.color.transparent);
        }
    }

    /* renamed from: initTitleBar$lambda-6$lambda-5  reason: not valid java name */
    public static final void m898initTitleBar$lambda6$lambda5(OCRTakePhotoActivity oCRTakePhotoActivity, View view) {
        Intrinsics.checkNotNullParameter(oCRTakePhotoActivity, "this$0");
        if (oCRTakePhotoActivity.isSelectScanIdCardsControlAndPictureEmpty()) {
            oCRTakePhotoActivity.finish();
        } else if (isCertificateTakingType$scanner_aiscanConfigRelease$default(oCRTakePhotoActivity, false, 1, (Object) null)) {
        } else {
            if (oCRTakePhotoActivity.getTakePhotoViewModel().isTakingMode()) {
                exitTakingModeWithConfirm$default(oCRTakePhotoActivity, false, new OCRTakePhotoActivity$initTitleBar$1$1$1(oCRTakePhotoActivity), 1, (Object) null);
                return;
            }
            fe.mmm.qw.ggg.qw.qw.qw("take_pictures_return_click", CollectionsKt__CollectionsJVMKt.listOf("return"));
            oCRTakePhotoActivity.onBackBusinessFinish();
        }
    }

    private final void initTouchEvent() {
        this.gestureDetector = new GestureDetector(this, new OCRTakePhotoActivity$initTouchEvent$1(this));
    }

    public static /* synthetic */ boolean isCertificateTakingType$scanner_aiscanConfigRelease$default(OCRTakePhotoActivity oCRTakePhotoActivity, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return oCRTakePhotoActivity.isCertificateTakingType$scanner_aiscanConfigRelease(z);
    }

    private final boolean isSelectScanIdCardsControlAndPictureEmpty() {
        int curPosition;
        OCRBottomAdapter oCRBottomAdapter = this.bottomUIAdapter;
        if (oCRBottomAdapter == null || (curPosition = oCRBottomAdapter.getCurPosition()) < 0) {
            return false;
        }
        IOCRTakePhotoControl ad2 = oCRBottomAdapter.getItems().get(curPosition).ad();
        ScanIdCardsControl scanIdCardsControl = ad2 instanceof ScanIdCardsControl ? (ScanIdCardsControl) ad2 : null;
        if (scanIdCardsControl == null) {
            return false;
        }
        return scanIdCardsControl.yj().isEmpty();
    }

    private final void notifyPictureSizeChanged(fe.vvv.qw.xxx.ad adVar) {
        List<i> items;
        i iVar;
        IOCRTakePhotoControl ad2;
        OCRBottomAdapter oCRBottomAdapter = this.bottomUIAdapter;
        int curPosition = oCRBottomAdapter != null ? oCRBottomAdapter.getCurPosition() : 0;
        OCRBottomAdapter oCRBottomAdapter2 = this.bottomUIAdapter;
        if (oCRBottomAdapter2 != null && (items = oCRBottomAdapter2.getItems()) != null && (iVar = items.get(curPosition)) != null && (ad2 = iVar.ad()) != null) {
            ad2.fe(adVar);
            refreshTitleBar();
        }
    }

    private final void onBackBusinessFinish() {
        setResult(0);
        finish();
    }

    public static final void onItemClick$doItemSelect(OCRTakePhotoActivity oCRTakePhotoActivity, int i2) {
        i currentTabItem;
        OCRBottomAdapter oCRBottomAdapter = oCRTakePhotoActivity.bottomUIAdapter;
        int tab = oCRBottomAdapter != null ? oCRBottomAdapter.getTab(i2) : -1;
        CenterItemDecoration centerItemDecoration = oCRTakePhotoActivity.bottomCenterItemDecoration;
        if (centerItemDecoration != null) {
            centerItemDecoration.setEnableCenter(true);
        }
        RecyclerView recyclerView = oCRTakePhotoActivity.ocrBottomRecyclerview;
        if (recyclerView != null) {
            recyclerView.smoothScrollToPosition(i2);
        }
        OCRBottomAdapter oCRBottomAdapter2 = oCRTakePhotoActivity.bottomUIAdapter;
        if (oCRBottomAdapter2 != null) {
            oCRBottomAdapter2.selectItem(i2);
        }
        OCRBottomAdapter oCRBottomAdapter3 = oCRTakePhotoActivity.bottomUIAdapter;
        if (!(oCRBottomAdapter3 == null || (currentTabItem = oCRBottomAdapter3.getCurrentTabItem()) == null)) {
            oCRTakePhotoActivity.getTakePhotoViewModel().setCurrentBottomTab(currentTabItem);
        }
        CameraNewFragment cameraNewFragment = oCRTakePhotoActivity.containerFragment;
        if (cameraNewFragment != null) {
            OCRBottomAdapter oCRBottomAdapter4 = oCRTakePhotoActivity.bottomUIAdapter;
            cameraNewFragment.updateCurrentFrom(oCRTakePhotoActivity.tabToFrom(oCRBottomAdapter4 != null ? oCRBottomAdapter4.getCurrentTabItem() : null));
        }
        CameraNewFragment cameraNewFragment2 = oCRTakePhotoActivity.containerFragment;
        if (cameraNewFragment2 != null) {
            cameraNewFragment2.showGrid(fe.mmm.qw.tt.ad.ggg.ad.qw(tab, 1, 6, 7, 2, 4, 9));
        }
        if (tab == 3) {
            ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "camera_id_cards_click", (List) null, 2, (Object) null);
            int i3 = oCRTakePhotoActivity.from;
            fe.mmm.qw.ggg.qw.qw.qw("camera_id_cards_show", CollectionsKt__CollectionsJVMKt.listOf(i3 != 2 ? i3 != 5 ? "camera" : "tools" : "banner"));
        }
        oCRTakePhotoActivity.setRightLayoutVisible(tab);
        fe.mmm.qw.tt.ad.ggg.ad.qw(oCRTakePhotoActivity.defaultTab, 4, 2);
    }

    private final void permissionRequest() {
        String[] strArr = {"android.permission.CAMERA"};
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 1; i2++) {
            String str = strArr[i2];
            if (ContextCompat.checkSelfPermission(this, str) != 0) {
                arrayList.add(str);
            }
        }
        if (!arrayList.isEmpty()) {
            ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "camera_auth_alert_show", (List) null, 2, (Object) null);
            String string = getContext().getResources().getString(R.string.permission_desc_title_in_camera);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…ion_desc_title_in_camera)");
            String string2 = getContext().getResources().getString(R.string.permission_desc_detail_in_camera);
            Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr…on_desc_detail_in_camera)");
            fe.mmm.qw.eee.de.qw.qw(this, string, string2);
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                ActivityCompat.requestPermissions(this, (String[]) array, 101);
                fe.mmm.qw.tt.fe.qw.ad("CameraPms", "CameraPms", (String) null, this.ubcSource, MapsKt__MapsJVMKt.mapOf(TuplesKt.to("ScanButton", fe.mmm.qw.tt.qw.qw.qw(getCategory()))), 4, (Object) null);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        fe.mmm.qw.ggg.qw.qw.qw("take_pictures_page_show", CollectionsKt__CollectionsJVMKt.listOf(fe.mmm.qw.tt.ad.nn.qw.de(Integer.valueOf(this.from))));
        if (Intrinsics.areEqual((Object) this.initTab, (Object) ROUTER_INIT_TAB_CERTIFICATE)) {
            ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "camera_id_cards_click", (List) null, 2, (Object) null);
            int i3 = this.from;
            fe.mmm.qw.ggg.qw.qw.qw("camera_id_cards_show", CollectionsKt__CollectionsJVMKt.listOf(i3 != 2 ? i3 != 5 ? "camera" : "tools" : "banner"));
        }
    }

    /* access modifiers changed from: private */
    public final void refreshTitleBar() {
        CustomizedTitleBar customizedTitleBar2;
        View view = this.chooseSizeContainer;
        if (view != null) {
            view.setVisibility(8);
        }
        Integer[] numArr = {2, 6, 7, 4, 8, 9};
        OCRBottomAdapter oCRBottomAdapter = this.bottomUIAdapter;
        int currentTab = oCRBottomAdapter != null ? oCRBottomAdapter.getCurrentTab() : -1;
        if (ArraysKt___ArraysKt.contains((T[]) numArr, Integer.valueOf(currentTab))) {
            CustomizedTitleBar customizedTitleBar3 = this.customizedTitleBar;
            if (customizedTitleBar3 != null) {
                customizedTitleBar3.removeAllActions();
                if (!(currentTab == 6 || currentTab == 7)) {
                    customizedTitleBar3.addAction(new fe(getTakePhotoViewModel().isAutoScanSwitchOpen() ? R.drawable.ocr_auto_scan : R.drawable.ocr_auto_scan_off));
                }
                customizedTitleBar3.addAction(new qw(R.drawable.ocr_choose_size));
                customizedTitleBar3.addAction(new de(R.drawable.ocr_flash_on));
            }
        } else if (currentTab == 0 || currentTab == 1) {
            CustomizedTitleBar customizedTitleBar4 = this.customizedTitleBar;
            if (customizedTitleBar4 != null) {
                customizedTitleBar4.removeAllActions();
                customizedTitleBar4.addAction(new de(R.drawable.ocr_flash_on));
            }
        } else if (currentTab == 3 && (customizedTitleBar2 = this.customizedTitleBar) != null) {
            customizedTitleBar2.removeAllActions();
            customizedTitleBar2.addAction(new de(R.drawable.ocr_flash_on));
            customizedTitleBar2.addAction(new qw(R.drawable.ocr_choose_size));
        }
    }

    private final void reportEvent() {
        Intent intent = getIntent();
        if (intent != null) {
            boolean areEqual = Intrinsics.areEqual((Object) "shortcuts", (Object) intent.getStringExtra(UBCManager.CONTENT_KEY_SOURCE));
            boolean areEqual2 = Intrinsics.areEqual((Object) "tiles", (Object) intent.getStringExtra(UBCManager.CONTENT_KEY_SOURCE));
        }
    }

    private final void restoreOCRCameraSize() {
        int rg2 = th.ppp().rg("key_ocr_last_camera_width", 4500);
        int rg3 = th.ppp().rg("key_ocr_last_camera_height", 4500);
        if (rg2 > 0 && rg3 > 0) {
            setPictureSize(new fe.vvv.qw.xxx.ad(rg2, rg3));
        }
    }

    private final void scanIdCardShowTypeChangeCallBack(List<i> list) {
        ScanIdCardsControl scanIdCardsControl;
        i iVar;
        Iterator<T> it = list.iterator();
        while (true) {
            scanIdCardsControl = null;
            if (!it.hasNext()) {
                iVar = null;
                break;
            }
            iVar = it.next();
            if (iVar.ad() instanceof ScanIdCardsControl) {
                break;
            }
        }
        i iVar2 = (i) iVar;
        IOCRTakePhotoControl ad2 = iVar2 != null ? iVar2.ad() : null;
        if (ad2 instanceof ScanIdCardsControl) {
            scanIdCardsControl = (ScanIdCardsControl) ad2;
        }
        if (scanIdCardsControl != null) {
            scanIdCardsControl.e(new OCRTakePhotoActivity$scanIdCardShowTypeChangeCallBack$1(this));
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
        if (r0.equals(ROUTER_INIT_TAB_PAPER) == false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0098, code lost:
        if (r0.equals(ROUTER_INIT_TAB_REMOVE_HANDWRITTEN) == false) goto L_0x009a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setDefaultTab() {
        /*
            r5 = this;
            android.content.Intent r0 = r5.getIntent()
            r1 = 0
            if (r0 == 0) goto L_0x000e
            java.lang.String r2 = "extra_tab"
            java.lang.String r0 = r0.getStringExtra(r2)
            goto L_0x000f
        L_0x000e:
            r0 = r1
        L_0x000f:
            if (r0 != 0) goto L_0x0013
            java.lang.String r0 = r5.initTab
        L_0x0013:
            r5.initTab = r0
            int r2 = r0.hashCode()
            r3 = 4
            r4 = 1
            switch(r2) {
                case -1853136252: goto L_0x0092;
                case -1760471288: goto L_0x0087;
                case -951532658: goto L_0x007c;
                case -306041330: goto L_0x0071;
                case -301494541: goto L_0x0065;
                case -194808679: goto L_0x005a;
                case 110834: goto L_0x004f;
                case 3655434: goto L_0x0044;
                case 106434956: goto L_0x003b;
                case 1052832078: goto L_0x002d;
                case 1952399767: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x009a
        L_0x0020:
            java.lang.String r2 = "certificate"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x002a
            goto L_0x009a
        L_0x002a:
            r3 = 3
            goto L_0x009e
        L_0x002d:
            java.lang.String r2 = "translate"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0037
            goto L_0x009a
        L_0x0037:
            r3 = 8
            goto L_0x009e
        L_0x003b:
            java.lang.String r2 = "paper"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x009e
            goto L_0x009a
        L_0x0044:
            java.lang.String r2 = "word"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x004d
            goto L_0x009a
        L_0x004d:
            r3 = 1
            goto L_0x009e
        L_0x004f:
            java.lang.String r2 = "pdf"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0058
            goto L_0x009a
        L_0x0058:
            r3 = 2
            goto L_0x009e
        L_0x005a:
            java.lang.String r2 = "pic_to_word"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0063
            goto L_0x009a
        L_0x0063:
            r3 = 6
            goto L_0x009e
        L_0x0065:
            java.lang.String r2 = "removeWater"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x006e
            goto L_0x009a
        L_0x006e:
            r3 = 9
            goto L_0x009e
        L_0x0071:
            java.lang.String r2 = "id_photo"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x007a
            goto L_0x009a
        L_0x007a:
            r3 = 5
            goto L_0x009e
        L_0x007c:
            java.lang.String r2 = "qrcode"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0085
            goto L_0x009a
        L_0x0085:
            r3 = 0
            goto L_0x009e
        L_0x0087:
            java.lang.String r2 = "pic_to_excel"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0090
            goto L_0x009a
        L_0x0090:
            r3 = 7
            goto L_0x009e
        L_0x0092:
            java.lang.String r2 = "removeHandWritten"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x009e
        L_0x009a:
            int r3 = r5.initDefaultTab()
        L_0x009e:
            r5.defaultTab = r3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "setDefaultTab：initTab:"
            r0.append(r2)
            java.lang.String r2 = r5.initTab
            r0.append(r2)
            java.lang.String r2 = ", defaultTab:"
            r0.append(r2)
            int r2 = r5.defaultTab
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.mars.kotlin.extension.LoggerKt.d$default(r0, r1, r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.scanner.ocr.OCRTakePhotoActivity.setDefaultTab():void");
    }

    private final void setRightLayoutVisible(int i2) {
        switch (i2) {
            case 1:
            case 2:
            case 4:
            case 6:
            case 7:
            case 8:
            case 9:
                showDocScanTitleBar();
                restoreOCRCameraSize();
                TextView textView = this.takePhotoPreviousStep;
                if (textView != null) {
                    textView.setVisibility(8);
                    return;
                }
                return;
            case 3:
                showCertificateScanTitleBar();
                restoreOCRCameraSize();
                return;
            default:
                showOtherTitleBar();
                TextView textView2 = this.takePhotoPreviousStep;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    return;
                }
                return;
        }
    }

    private final void showCertificateScanTitleBar() {
        refreshTitleBar();
    }

    private final void showDocScanTitleBar() {
        refreshTitleBar();
    }

    private final void showOtherTitleBar() {
        fe.vvv.qw.xxx.ad pictureSize;
        CustomizedTitleBar customizedTitleBar2 = this.customizedTitleBar;
        if (customizedTitleBar2 != null) {
            customizedTitleBar2.removeAllActions();
        }
        CameraNewFragment cameraNewFragment = this.containerFragment;
        boolean z = false;
        if (cameraNewFragment != null) {
            cameraNewFragment.setFlash(false);
        }
        View view = this.chooseSizeContainer;
        if (view != null) {
            view.setVisibility(8);
        }
        CameraNewFragment cameraNewFragment2 = this.containerFragment;
        if (cameraNewFragment2 != null && cameraNewFragment2.restoreDefaultPictureSize()) {
            z = true;
        }
        if (z && (pictureSize = getPictureSize()) != null) {
            notifyPictureSizeChanged(pictureSize);
        }
    }

    private final void showTakeShotTitleBar() {
        refreshTitleBar();
    }

    /* renamed from: showTipView$lambda-30  reason: not valid java name */
    public static final void m899showTipView$lambda30(UITextView uITextView) {
        if (uITextView.getVisibility() == 0) {
            Intrinsics.checkNotNullExpressionValue(uITextView, "textView");
            uITextView.setVisibility(8);
        }
    }

    private final String tabToFrom(i iVar) {
        if (iVar == null) {
            return "";
        }
        if (iVar.ad() instanceof OCRToWordControl) {
            return "wenzi_san";
        }
        if (iVar.ad() instanceof OCRToPDFControl) {
            return "word_sann";
        }
        return "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0047 A[Catch:{ Exception -> 0x0057 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0052 A[Catch:{ Exception -> 0x0057 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0053 A[Catch:{ Exception -> 0x0057 }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x003f A[Catch:{ Exception -> 0x0057 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void takePhoto() {
        /*
            r6 = this;
            java.lang.String r0 = "ocr_copy_all"
            r6.enterpriseUbc(r0)
            com.tera.scan.scanner.ocr.OCRBottomAdapter r0 = r6.bottomUIAdapter     // Catch:{ Exception -> 0x0057 }
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x003c
            int r0 = r0.getCurrentTab()     // Catch:{ Exception -> 0x0057 }
            r3 = 5
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0057 }
            r4 = 2
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0057 }
            r3[r2] = r5     // Catch:{ Exception -> 0x0057 }
            r5 = 6
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0057 }
            r3[r1] = r5     // Catch:{ Exception -> 0x0057 }
            r5 = 7
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0057 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0057 }
            r4 = 3
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0057 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0057 }
            r4 = 4
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0057 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0057 }
            boolean r0 = fe.mmm.qw.tt.ad.ggg.ad.qw(r0, r3)     // Catch:{ Exception -> 0x0057 }
            if (r0 != r1) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r1 = 0
        L_0x003d:
            if (r1 == 0) goto L_0x0047
            com.tera.scan.scanner.ui.cameranew.CameraNewFragment r0 = r6.containerFragment     // Catch:{ Exception -> 0x0057 }
            if (r0 == 0) goto L_0x004e
            r0.takePicture()     // Catch:{ Exception -> 0x0057 }
            goto L_0x004e
        L_0x0047:
            com.tera.scan.scanner.ui.cameranew.CameraNewFragment r0 = r6.containerFragment     // Catch:{ Exception -> 0x0057 }
            if (r0 == 0) goto L_0x004e
            r0.takePictureSnapshot()     // Catch:{ Exception -> 0x0057 }
        L_0x004e:
            android.widget.ImageView r0 = r6.takePhotoButton     // Catch:{ Exception -> 0x0057 }
            if (r0 != 0) goto L_0x0053
            goto L_0x0061
        L_0x0053:
            r0.setEnabled(r2)     // Catch:{ Exception -> 0x0057 }
            goto L_0x0061
        L_0x0057:
            r0 = move-exception
            r1 = 2131887541(0x7f1205b5, float:1.9409692E38)
            fe.mmm.qw.th.qw.th.o.rg(r1)
            r0.printStackTrace()
        L_0x0061:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.scanner.ocr.OCRTakePhotoActivity.takePhoto():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getCurrentTabItem();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void takePhotoButtonClick() {
        /*
            r1 = this;
            com.tera.scan.scanner.ocr.OCRBottomAdapter r0 = r1.bottomUIAdapter
            if (r0 == 0) goto L_0x000f
            fe.mmm.qw.tt.ad.i r0 = r0.getCurrentTabItem()
            if (r0 == 0) goto L_0x000f
            com.tera.scan.scanner.ocr.control.IOCRTakePhotoControl r0 = r0.ad()
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            boolean r0 = r0 instanceof com.tera.scan.scanner.ocr.control.OCRToWordControl
            if (r0 != 0) goto L_0x001b
            r1.takePhoto()
            r1.enterTakingMode()
            return
        L_0x001b:
            r1.takePhoto()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.scanner.ocr.OCRTakePhotoActivity.takePhotoButtonClick():void");
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

    public boolean dispatchTouchEvent(@Nullable MotionEvent motionEvent) {
        StringBuilder sb = new StringBuilder();
        sb.append("dispatchTouchEvent pointerCount = ");
        boolean z = false;
        sb.append(motionEvent != null ? motionEvent.getPointerCount() : 0);
        sb.append(Ascii.CASE_MASK);
        LoggerKt.d$default(sb.toString(), (Object) null, 1, (Object) null);
        if (motionEvent == null || motionEvent.getPointerCount() > 1) {
            return super.dispatchTouchEvent(motionEvent);
        }
        GestureDetector gestureDetector2 = this.gestureDetector;
        if (gestureDetector2 != null && gestureDetector2.onTouchEvent(motionEvent)) {
            z = true;
        }
        if (z) {
            return true;
        }
        LoggerKt.d$default("dispatchTouchEvent defalut ", (Object) null, 1, (Object) null);
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void exitTakingMode() {
        i currentTabItem;
        IOCRTakePhotoControl ad2;
        if (this.from != 6 || this.category == -1) {
            getTakePhotoViewModel().setIsTakingMode(false);
            TextView textView = this.takePhotoPreviousStep;
            if (textView != null) {
                textView.setVisibility(8);
            }
            TextView textView2 = this.ocrTakingTab;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            TextView textView3 = this.ocrTakingTab;
            if (textView3 != null) {
                textView3.setText((CharSequence) null);
            }
            RecyclerView recyclerView = this.ocrBottomRecyclerview;
            if (recyclerView != null) {
                recyclerView.setVisibility(0);
            }
            OCRBottomAdapter oCRBottomAdapter = this.bottomUIAdapter;
            if (oCRBottomAdapter != null && (currentTabItem = oCRBottomAdapter.getCurrentTabItem()) != null && (ad2 = currentTabItem.ad()) != null) {
                ad2.uk();
                return;
            }
            return;
        }
        setResult(0);
        finish();
    }

    @Nullable
    public final OCRBottomAdapter getBottomUIAdapter$scanner_aiscanConfigRelease() {
        return this.bottomUIAdapter;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getCurrentTabItem();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int getCategory() {
        /*
            r1 = this;
            com.tera.scan.scanner.ocr.OCRBottomAdapter r0 = r1.bottomUIAdapter
            if (r0 == 0) goto L_0x000f
            fe.mmm.qw.tt.ad.i r0 = r0.getCurrentTabItem()
            if (r0 == 0) goto L_0x000f
            int r0 = r0.qw()
            goto L_0x0011
        L_0x000f:
            int r0 = r1.category
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.scanner.ocr.OCRTakePhotoActivity.getCategory():int");
    }

    @Nullable
    public final Integer getCurrentTab() {
        OCRBottomAdapter oCRBottomAdapter = this.bottomUIAdapter;
        if (oCRBottomAdapter != null) {
            return Integer.valueOf(oCRBottomAdapter.getCurrentTab());
        }
        return null;
    }

    @Nullable
    public final String getDocSavePath() {
        return this.docSavePath;
    }

    public int getLayoutId() {
        return R.layout.activity_take_photo_layout_new;
    }

    @Nullable
    public fe.vvv.qw.xxx.ad getPictureSize() {
        CameraNewFragment cameraNewFragment = this.containerFragment;
        if (cameraNewFragment != null) {
            return cameraNewFragment.getPictureSize();
        }
        return null;
    }

    @NotNull
    public Rect getPreviewRect() {
        View view;
        Rect rect = new Rect();
        CameraNewFragment cameraNewFragment = this.containerFragment;
        if (!(cameraNewFragment == null || (view = cameraNewFragment.getView()) == null)) {
            view.getGlobalVisibleRect(rect);
        }
        return rect;
    }

    public final void hideTipView() {
        ((UITextView) findViewById(R.id.take_photo_tip)).setVisibility(8);
    }

    public void initParams() {
        super.initParams();
        Intent intent = getIntent();
        int i2 = 4;
        if (intent != null) {
            i2 = intent.getIntExtra(EXTRA_FROM, 4);
        }
        this.from = i2;
        setDefaultTab();
        Intent intent2 = getIntent();
        boolean z = false;
        this.pdfMode = intent2 != null ? intent2.getIntExtra(EXTRA_PDF_MODE, 0) : 0;
        Intent intent3 = getIntent();
        this.subIndex = intent3 != null ? intent3.getIntExtra(EXTRA_SUB_INDEX, 0) : 0;
        Intent intent4 = getIntent();
        this.category = intent4 != null ? intent4.getIntExtra(EXTRA_CATEGORY, -1) : -1;
        OCRTakePhotoViewModel takePhotoViewModel = getTakePhotoViewModel();
        if (this.from == 6 && this.category != -1) {
            z = true;
        }
        takePhotoViewModel.setIsTakingMode(z);
        int i3 = this.category;
        int i4 = this.subIndex;
        int i5 = this.pdfMode;
        int i6 = this.defaultTab;
        int i7 = this.from;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.bottomTabConfig = new Cswitch(i3, i4, i5, i6, i7, context, getIntent(), new OCRTakePhotoActivity$initParams$1(this), new OCRTakePhotoActivity$initParams$2(this));
    }

    public void initView() {
        this.takePhotoPreviousStep = (TextView) findViewById(R.id.btn_start_scan);
        this.ocrTakingTab = (TextView) findViewById(R.id.ocr_taking_tab_name);
        this.fragmentContainer = (UIFrameLayout) findViewById(R.id.fragment_container);
        this.chooseSizeContainer = findViewById(R.id.choose_size_container);
        this.choosePictureSize = (LinearLayout) findViewById(R.id.choose_size);
        this.takePhotoButton = (ImageView) findViewById(R.id.take_photo_button);
        this.ocrBottomRecyclerview = (RecyclerView) findViewById(R.id.ocr_bottom_recyclerview);
        OCRTakePhotoActivity$initView$1 oCRTakePhotoActivity$initView$1 = new OCRTakePhotoActivity$initView$1(this);
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, MediaType.APPLICATION_TYPE);
        this.takeSingleOrMultipleView = new TakeSingleOrMultipleView(this, this, oCRTakePhotoActivity$initView$1, application, this.pdfMode, getCategory());
        initCacheDir();
        initTitleBar();
        initFragment();
        initTab();
        initListeners();
        ImageView imageView = this.takePhotoButton;
        ViewGroup.LayoutParams layoutParams = imageView != null ? imageView.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.width = SizeUtils.qw(72.0f);
        }
        if (layoutParams != null) {
            layoutParams.height = SizeUtils.qw(72.0f);
        }
        ImageView imageView2 = this.takePhotoButton;
        if (imageView2 != null) {
            imageView2.setLayoutParams(layoutParams);
        }
    }

    public boolean isActivityDark() {
        return false;
    }

    public final boolean isCertificateTakingType$scanner_aiscanConfigRelease(boolean z) {
        int curPosition;
        OCRBottomAdapter oCRBottomAdapter = this.bottomUIAdapter;
        if (oCRBottomAdapter == null || (curPosition = oCRBottomAdapter.getCurPosition()) < 0) {
            return false;
        }
        IOCRTakePhotoControl ad2 = oCRBottomAdapter.getItems().get(curPosition).ad();
        ScanIdCardsControl scanIdCardsControl = ad2 instanceof ScanIdCardsControl ? (ScanIdCardsControl) ad2 : null;
        if (scanIdCardsControl == null) {
            return false;
        }
        if (!scanIdCardsControl.b() && !(!scanIdCardsControl.yj().isEmpty())) {
            if (z) {
                scanIdCardsControl.d();
            } else {
                scanIdCardsControl.ad();
            }
            return true;
        } else if (!z) {
            return false;
        } else {
            scanIdCardsControl.d();
            return false;
        }
    }

    public boolean needSetStatusBar() {
        return false;
    }

    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 5000) {
            fe.mmm.qw.eee.de.qw.ad(this);
        }
        handleOtherRequestCode(i2, i3, intent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
        r3 = (r3 = (r3 = r3.getCurrentTabItem()).ad()).yj();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBackPressed() {
        /*
            r4 = this;
            fe.mmm.qw.ggg.qw r0 = fe.mmm.qw.ggg.qw.qw
            java.lang.String r1 = "device"
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r1)
            java.lang.String r2 = "take_pictures_return_click"
            r0.qw(r2, r1)
            boolean r0 = r4.isSelectScanIdCardsControlAndPictureEmpty()
            if (r0 == 0) goto L_0x0017
            r4.finish()
            return
        L_0x0017:
            r0 = 0
            r1 = 1
            r2 = 0
            boolean r3 = isCertificateTakingType$scanner_aiscanConfigRelease$default(r4, r0, r1, r2)
            if (r3 == 0) goto L_0x0025
            int r3 = r4.pdfMode
            if (r3 != 0) goto L_0x0025
            return
        L_0x0025:
            com.tera.scan.scanner.ocr.viewmodel.OCRTakePhotoViewModel r3 = r4.getTakePhotoViewModel()
            boolean r3 = r3.isTakingMode()
            if (r3 == 0) goto L_0x005a
            com.tera.scan.scanner.ocr.OCRBottomAdapter r3 = r4.bottomUIAdapter
            if (r3 == 0) goto L_0x004e
            fe.mmm.qw.tt.ad.i r3 = r3.getCurrentTabItem()
            if (r3 == 0) goto L_0x004e
            com.tera.scan.scanner.ocr.control.IOCRTakePhotoControl r3 = r3.ad()
            if (r3 == 0) goto L_0x004e
            java.util.List r3 = r3.yj()
            if (r3 == 0) goto L_0x004e
            boolean r3 = r3.isEmpty()
            r3 = r3 ^ r1
            if (r3 != r1) goto L_0x004e
            r3 = 1
            goto L_0x004f
        L_0x004e:
            r3 = 0
        L_0x004f:
            if (r3 == 0) goto L_0x005a
            com.tera.scan.scanner.ocr.OCRTakePhotoActivity$onBackPressed$1 r3 = new com.tera.scan.scanner.ocr.OCRTakePhotoActivity$onBackPressed$1
            r3.<init>(r4)
            exitTakingModeWithConfirm$default(r4, r0, r3, r1, r2)
            return
        L_0x005a:
            super.onBackPressed()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.scanner.ocr.OCRTakePhotoActivity.onBackPressed():void");
    }

    public void onClick(@Nullable View view) {
    }

    public void onCreate(@Nullable Bundle bundle) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            fe.ad.qw.qw.ad.qw.de().rg(this);
            obj = Result.m1155constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m1158exceptionOrNullimpl(obj) != null) {
            fe.ad.qw.qw.ad.qw.fe(getApplication());
            fe.ad.qw.qw.ad.qw.de().rg(this);
        }
        String stringExtra = getIntent().getStringExtra("extra_ubc_source");
        if (stringExtra == null) {
            stringExtra = this.ubcSource;
        }
        this.ubcSource = stringExtra;
        getTakePhotoViewModel().setUbcSource$scanner_aiscanConfigRelease(this.ubcSource);
        super.onCreate(bundle);
        permissionRequest();
        Intent intent = getIntent();
        this.docSavePath = intent != null ? intent.getStringExtra(OCRRectifyActivity.EXTRA_SAVE_PATH) : null;
        this.screenHeight = fe.mmm.qw.p030switch.th.de.ad.qw.fe();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.vibrateManager = new Cif(context);
        reportEvent();
    }

    public void onDestroy() {
        List<i> items;
        super.onDestroy();
        OCRBottomAdapter oCRBottomAdapter = this.bottomUIAdapter;
        if (!(oCRBottomAdapter == null || (items = oCRBottomAdapter.getItems()) == null)) {
            for (i ad2 : items) {
                ad2.ad().onDestroy();
            }
        }
        Cif ifVar = this.vibrateManager;
        if (ifVar != null) {
            ifVar.qw();
        }
    }

    public void onItemClick(int i2) {
        if (getTakePhotoViewModel().isTakingMode()) {
            exitTakingModeWithConfirm$default(this, false, new OCRTakePhotoActivity$onItemClick$1(this, i2), 1, (Object) null);
        } else {
            onItemClick$doItemSelect(this, i2);
        }
    }

    public void onNewIntent(@Nullable Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        initParams();
        OCRBottomAdapter oCRBottomAdapter = this.bottomUIAdapter;
        if (oCRBottomAdapter != null) {
            int position = oCRBottomAdapter.getPosition(this.defaultTab);
            oCRBottomAdapter.selectItem(position);
            i currentTabItem = oCRBottomAdapter.getCurrentTabItem();
            if (currentTabItem != null) {
                getTakePhotoViewModel().setCurrentBottomTab(currentTabItem);
            }
            CameraNewFragment cameraNewFragment = this.containerFragment;
            if (cameraNewFragment != null) {
                cameraNewFragment.updateCurrentFrom(tabToFrom(oCRBottomAdapter.getCurrentTabItem()));
            }
            fe.mmm.qw.i.qw.ad("OCRBottomBarScrollIdle", "1 >>> " + System.currentTimeMillis());
            RecyclerView recyclerView = this.ocrBottomRecyclerview;
            if (recyclerView != null) {
                Looper.myQueue().addIdleHandler(new fe.mmm.qw.tt.ad.vvv.qw(recyclerView, position));
            }
        }
        setRightLayoutVisible(this.defaultTab);
        if (getTakePhotoViewModel().isTakingMode()) {
            exitTakingMode();
        }
    }

    public void onRequestPermissionsResult(int i2, @NotNull String[] strArr, @NotNull int[] iArr) {
        Integer num;
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (101 == i2) {
            int length = iArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    num = null;
                    break;
                }
                int i4 = iArr[i3];
                if (i4 != 0) {
                    num = Integer.valueOf(i4);
                    break;
                }
                i3++;
            }
            if (num != null) {
                fe.mmm.qw.eee.de.de.de deVar = new fe.mmm.qw.eee.de.de.de();
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                deVar.qw(context, supportFragmentManager, new OCRTakePhotoActivity$onRequestPermissionsResult$2(this));
                return;
            }
            fe.mmm.qw.eee.de.qw.ad(this);
            fe.mmm.qw.ggg.qw.qw.qw("take_pictures_page_show", CollectionsKt__CollectionsJVMKt.listOf(fe.mmm.qw.tt.ad.nn.qw.de(Integer.valueOf(this.from))));
        }
    }

    public void onResume() {
        IOCRTakePhotoControl curControl;
        super.onResume();
        OCRBottomAdapter oCRBottomAdapter = this.bottomUIAdapter;
        if (oCRBottomAdapter != null && (curControl = oCRBottomAdapter.getCurControl()) != null) {
            curControl.onResume();
        }
    }

    public void onStop() {
        List<i> items;
        super.onStop();
        OCRBottomAdapter oCRBottomAdapter = this.bottomUIAdapter;
        if (oCRBottomAdapter != null && (items = oCRBottomAdapter.getItems()) != null) {
            for (i ad2 : items) {
                ad2.ad().onStop();
            }
        }
    }

    public boolean onTouchEvent(@Nullable MotionEvent motionEvent) {
        LoggerKt.d$default("onTouchEvent", (Object) null, 1, (Object) null);
        return super.onTouchEvent(motionEvent);
    }

    public void setActivityBg() {
    }

    public final void setBottomUIAdapter$scanner_aiscanConfigRelease(@Nullable OCRBottomAdapter oCRBottomAdapter) {
        this.bottomUIAdapter = oCRBottomAdapter;
    }

    public void setCarmeSize(int i2) {
        fe.mmm.qw.f.de.ad.ad helper;
        fe.mmm.qw.f.de.ad.ad helper2;
        if (i2 == -2) {
            UIFrameLayout uIFrameLayout = this.fragmentContainer;
            if (!(uIFrameLayout == null || (helper2 = uIFrameLayout.getHelper()) == null)) {
                helper2.tt(3, 4);
            }
        } else {
            UIFrameLayout uIFrameLayout2 = this.fragmentContainer;
            if (!(uIFrameLayout2 == null || (helper = uIFrameLayout2.getHelper()) == null)) {
                helper.tt(0, 0);
            }
        }
        CameraNewFragment cameraNewFragment = this.containerFragment;
        if (cameraNewFragment != null) {
            cameraNewFragment.setHeightParams(i2);
        }
    }

    public final void setDocSavePath(@Nullable String str) {
        this.docSavePath = str;
    }

    public void setPictureSize(@NotNull fe.vvv.qw.xxx.ad adVar) {
        Intrinsics.checkNotNullParameter(adVar, "size");
        CameraNewFragment cameraNewFragment = this.containerFragment;
        boolean z = true;
        if (cameraNewFragment == null || !cameraNewFragment.setPictureSize(adVar)) {
            z = false;
        }
        if (z) {
            notifyPictureSizeChanged(adVar);
        }
    }

    public void setZoom(float f) {
        CameraNewFragment cameraNewFragment = this.containerFragment;
        if (cameraNewFragment != null) {
            cameraNewFragment.setPreviewZoom(f);
        }
    }

    public final void showTipView(int i2) {
        String string = getResources().getString(i2);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(stringResource)");
        showTipView(string);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0014, code lost:
        r1 = r1.getCurrentTabItem();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void showTipView(@org.jetbrains.annotations.NotNull java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r0 = "stringResource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "showTipView "
            r0.append(r1)
            com.tera.scan.scanner.ocr.OCRBottomAdapter r1 = r3.bottomUIAdapter
            r2 = 0
            if (r1 == 0) goto L_0x001f
            fe.mmm.qw.tt.ad.i r1 = r1.getCurrentTabItem()
            if (r1 == 0) goto L_0x001f
            java.lang.String r1 = r1.fe()
            goto L_0x0020
        L_0x001f:
            r1 = r2
        L_0x0020:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 1
            com.mars.kotlin.extension.LoggerKt.d$default(r0, r2, r1, r2)
            r0 = 2131363463(0x7f0a0687, float:1.8346736E38)
            android.view.View r0 = r3.findViewById(r0)
            com.tera.scan.ui.view.widget.UITextView r0 = (com.tera.scan.ui.view.widget.UITextView) r0
            r1 = 0
            r0.setVisibility(r1)
            r0.setText(r4)
            java.lang.Runnable r4 = r3.tipRunnable
            r0.removeCallbacks(r4)
            fe.mmm.qw.tt.ad.uk r4 = new fe.mmm.qw.tt.ad.uk
            r4.<init>(r0)
            r3.tipRunnable = r4
            r1 = 3000(0xbb8, double:1.482E-320)
            r0.postDelayed(r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.scanner.ocr.OCRTakePhotoActivity.showTipView(java.lang.String):void");
    }
}
