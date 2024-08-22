package com.tera.scan.doc.preview.document.ui.view;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.aiscan.R;
import com.google.android.gms.common.internal.ImagesContract;
import com.tera.scan.business.core.widget.FileSelectBottomItemView;
import com.tera.scan.business.textrecognition.TextRecognitionActivity;
import com.tera.scan.doc.preview.document.ui.view.flavor.DocumentFragmentKt;
import com.tera.scan.doc.preview.document.ui.view.pdf.IPdfSwtichWordResult;
import com.tera.scan.doc.preview.office.ui.DocTinyFragment;
import com.tera.scan.doc.preview.pdf.ui.PDFFragment;
import com.tera.scan.flutter.component.provider.FlutterYouthProvider;
import com.tera.scan.framework.BaseActivity;
import com.tera.scan.record.database.DocScanProviderHelper;
import com.tera.scan.record.model.ScanRecordExportFile;
import com.tera.scan.ui.view.widget.UITextView;
import com.tera.scan.ui.widget.EmptyView;
import com.tera.scan.vip.model.PrivilegeType;
import com.tera.scan.vip.util.VipRightsManager;
import fe.mmm.qw.th.qw.rg.de.fe;
import fe.mmm.qw.th.qw.th.o;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.json.JSONException;
import org.json.JSONObject;

public class DocumentViewerActivity extends BaseActivity implements View.OnClickListener, IControlCallback, ILoadCallback, IPdfSwtichWordResult {
    public static final String ACTION_DOCUMENT_DELETE_SUCCESS = "action_document_delete_success";
    public static final String ACTION_DOCUMENT_DOWNLOAD = "action_document_download";
    public static final String ACTION_DOCUMENT_GET_SAVE_DIR = "action_document_get_save_dir";
    public static final String ACTION_DOCUMENT_SAVE = "action_document_save";
    public static final String ACTION_DOCUMENT_SAVE_FROM_SHARE = "action_document_save_from_share";
    public static final String BUY_FROM_WORK_SPACE = "workspace_filemultiversion_button_yulan";
    public static final String CUSTOMIZE_PATH_PREFIX = "/_pcs_.appdata/xpan";
    public static final String DEFAULT_SAFE_BOX_PATH = "/_pcs_.safebox";
    public static final String FRAGMENT_DOCUMENT = "fragment_document";
    public static final String FROM_PDF_MERGE = "from_pdf_merge";
    public static final String FROM_PDF_SPLIT = "from_pdf_split";
    public static final String KEY_CLOUD_FILE = "key_cloud_file";
    public static final String KEY_CONVERT_OPTION = "key_convert_option";
    public static final String KEY_CURRENT_PATH = "key_current_path";
    public static final String KEY_DOWNLOAD_TIME = "key_download_time";
    public static final String KEY_EXPORT_FILE = "key_export_file";
    public static final String KEY_FILE_HISTORY_VERSION = "key_file_history_version";
    public static final String KEY_FILE_PRODUCT_TYPE = "key_file_product_type";
    public static final String KEY_FILE_RESTORE_ABLE = "key_file_restore_able";
    public static final String KEY_FILE_REVERT_PATH = "key_file_revert_path";
    public static final String KEY_FILE_VERSION_CODE = "key_file_version_code";
    public static final String KEY_FROM = "key_from";
    public static final String KEY_FROM_PAGE_NAME = "key_from_page_name";
    public static final String KEY_LOCAL_PATH = "key_local_path";
    public static final String KEY_SUFFIX = "suffix";
    public static final String KEY_UBC_SOURCE = "key_ubc_source";
    public static final int MAX_TRANSLATE_COUNT = 10;
    public static final String PDF_TO_WORD = "pdf_to_word";
    public static final String PRODUCT_TYPE_WORK_SPACE = "workspace";
    public static final int REQUEST_PDF_TO_WORD_CODE = 10002;
    public static final int SWITCH_BACKGROUND = 102;
    public static final int SWITCH_CANCEL = 101;
    public static final int SWITCH_SUCCESS = 100;
    public static final String TAG = "pdf2word/DocumentViewerActivity";
    public View mClBottomMenu;
    public DocumentFragment mCurrentFragment;
    public EmptyView mEmptyView;
    public ScanRecordExportFile mExportFile;
    public ImageView mFileType;
    public String mFrom;
    public String mFromPageName;
    public boolean mIsHideBarMode = false;
    public boolean mLoadSucceed;
    public String mLocalPath;
    public Handler mMainHandler = new Handler(Looper.getMainLooper());
    public PopupWindow mPopWindow;
    public boolean mPositionRestoreSucceed;
    public String mStatSource = "";
    public fe.mmm.qw.o.qw.qw.ad.qw mStaticUtils = new fe.mmm.qw.o.qw.qw.ad.qw();
    public Runnable mThumbRecyViewRunnable = new yj();
    public TextView mTitle;
    public RelativeLayout mTitleLayout;
    public int mType = 0;
    public UITextView tvWatermarkFreeTimes;
    public String ubcSource = "";

    public class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ View f6870ad;

        public ad(View view) {
            this.f6870ad = view;
        }

        public void run() {
            int[] iArr = new int[2];
            this.f6870ad.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            View findViewById = DocumentViewerActivity.this.findViewById(R.id.fl_translate_vip_status);
            findViewById.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams2.leftMargin = i2 + (this.f6870ad.getWidth() / 2);
                findViewById.setLayoutParams(layoutParams2);
            }
        }
    }

    public class de implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ View f6872ad;

        public de(View view) {
            this.f6872ad = view;
        }

        public void run() {
            int[] iArr = new int[2];
            this.f6872ad.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            View findViewById = DocumentViewerActivity.this.findViewById(R.id.fl_translate_watermark_vip_status);
            findViewById.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams2.leftMargin = i2 + (this.f6872ad.getWidth() / 2);
                findViewById.setLayoutParams(layoutParams2);
            }
        }
    }

    public class fe implements Function1<Boolean, Unit> {
        public fe() {
        }

        /* renamed from: qw */
        public Unit invoke(Boolean bool) {
            if (!bool.booleanValue()) {
                return null;
            }
            DocumentViewerActivity.this.executeDeleteFile();
            return null;
        }
    }

    public class qw implements View.OnClickListener {
        public qw() {
        }

        public void onClick(View view) {
            DocumentViewerActivity.this.openByOtherApp();
        }
    }

    public class rg implements Runnable {

        public class qw implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ int f6877ad;

            public qw(int i2) {
                this.f6877ad = i2;
            }

            public void run() {
                if (this.f6877ad > 0) {
                    o.rg(R.string.delete_success);
                    if (TextUtils.equals(DocumentViewerActivity.this.mFrom, "from_shot")) {
                        Intent intent = new Intent();
                        intent.putExtra("path", DocumentViewerActivity.this.mLocalPath);
                        intent.putExtra("from", DocumentViewerActivity.this.mFrom);
                        DocumentViewerActivity.this.setResult(-1, intent);
                    }
                    String access$500 = DocumentViewerActivity.this.ubcPage();
                    if (!TextUtils.isEmpty(access$500)) {
                        fe.mmm.qw.o.qw.fe.qw.qw(access$500, DocumentViewerActivity.this.mType == 0 ? "PDFV_DltSuc" : "WordV_DltSuc", "aiscan", (Map<String, ? extends Object>) null);
                    }
                    DocumentViewerActivity.this.finish();
                    return;
                }
                o.rg(R.string.delete_fail);
            }
        }

        public rg() {
        }

        public void run() {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(DocumentViewerActivity.this.mExportFile);
            int th2 = new DocScanProviderHelper(fe.mmm.qw.p030switch.rg.qw.qw().getBduss()).th(DocumentViewerActivity.this, arrayList);
            fe.mmm.qw.j.xxx.ad.fe(DocumentViewerActivity.this.mExportFile.getLocalPath());
            DocumentViewerActivity.this.runOnUiThread(new qw(th2));
        }
    }

    public class th implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Dialog f6879ad;

        public th(Dialog dialog) {
            this.f6879ad = dialog;
        }

        public /* synthetic */ Unit ad(Dialog dialog, List list) {
            DocumentViewerActivity.this.mMainHandler.post(new fe.mmm.qw.o.qw.qw.qw.ad.qw(this, dialog, list));
            return Unit.INSTANCE;
        }

        public /* synthetic */ void qw(Dialog dialog, List list) {
            dialog.dismiss();
            DocumentViewerActivity.this.jumpToAiTranslatePage(list);
        }

        public void run() {
            fe.mmm.qw.o.qw.rg.qw qwVar = fe.mmm.qw.o.qw.rg.qw.qw;
            DocumentViewerActivity documentViewerActivity = DocumentViewerActivity.this;
            qwVar.qw(documentViewerActivity, documentViewerActivity.mLocalPath, false, new fe.mmm.qw.o.qw.qw.qw.ad.ad(this, this.f6879ad));
        }
    }

    public class yj implements Runnable {
        public yj() {
        }

        public void run() {
        }
    }

    private void aiTranslatePdf() {
        int pageCount;
        fe.mmm.qw.ggg.qw.qw.qw("file_preview_translate_click", (List<String>) null);
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(FRAGMENT_DOCUMENT);
        if (!(findFragmentByTag instanceof PDFFragment) || (pageCount = ((PDFFragment) findFragmentByTag).getPageCount()) <= 0) {
            return;
        }
        if (pageCount > 10) {
            new fe.mmm.qw.th.qw.rg.de.fe().rg(this, (String) null, getString(R.string.pdf_translate_title_limit), (String) null, getString(R.string.ok), (fe.ad) null).show();
            return;
        }
        fe.mmm.qw.o.qw.qw.qw.ad.uk.qw.qw(this, new fe.mmm.qw.o.qw.qw.qw.ad.yj(this, findFragmentByTag));
    }

    private void changeBarHideMode() {
        if (this.mIsHideBarMode) {
            this.mTitleLayout.setVisibility(8);
            this.mClBottomMenu.setVisibility(8);
        } else {
            this.mTitleLayout.setVisibility(0);
            this.mClBottomMenu.setVisibility(0);
        }
        updateSeekBar();
    }

    private void deleteLocalFile() {
    }

    /* access modifiers changed from: private */
    public void executeDeleteFile() {
        if (this.mExportFile == null) {
            o.rg(R.string.delete_fail);
        } else {
            fe.mmm.qw.a.th.f7617de.execute(new rg());
        }
    }

    private String getFileName() {
        return fe.mmm.qw.j.xxx.ad.pf(this.mLocalPath);
    }

    public static Intent getStartIntent(Context context, String str, String str2, int i2, long j, String str3) {
        Intent intent = new Intent(context, DocumentViewerActivity.class);
        intent.putExtra("key_local_path", str);
        intent.putExtra(KEY_FROM, str2);
        intent.putExtra(KEY_CONVERT_OPTION, i2);
        intent.putExtra(KEY_DOWNLOAD_TIME, j);
        intent.putExtra(KEY_FROM_PAGE_NAME, str3);
        try {
            new JSONObject().put(KEY_SUFFIX, fe.mmm.qw.j.xxx.ad.i(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return intent;
    }

    private void handlePdfWatermarkPath() {
        Dialog th2 = new fe.mmm.qw.th.qw.rg.de.fe().th(this);
        th2.setCancelable(false);
        th2.show();
        fe.mmm.qw.a.th.f7617de.execute(new fe.mmm.qw.o.qw.qw.qw.ad.th(this, th2));
    }

    private void hideEmptyView() {
        this.mEmptyView.setEmptyImage(R.drawable.ic_doc_open_failed);
        this.mEmptyView.setVisibility(8);
    }

    private void initEmptyView() {
        EmptyView emptyView = (EmptyView) findViewById(R.id.empty_view);
        this.mEmptyView = emptyView;
        emptyView.setRefreshButtonText(R.string.doc_open_by_other);
        this.mEmptyView.setRefreshListener(new qw());
    }

    private void initRecyclerView() {
    }

    private void initTitleBar() {
        this.mTitleLayout = (RelativeLayout) findViewById(R.id.title_bar_layout);
        this.mClBottomMenu = findViewById(R.id.cl_bottom_menu);
        findViewById(R.id.title_back_button).setOnClickListener(this);
        this.mTitle = (TextView) findViewById(R.id.elliptic_title_text);
        this.mFileType = (ImageView) findViewById(R.id.title_icon);
        this.tvWatermarkFreeTimes = (UITextView) findViewById(R.id.tv_free_watermark_times);
        updateTitleBar();
        findViewById(R.id.file_bottom_item_share).setOnClickListener(this);
        findViewById(R.id.file_bottom_item_pdf_split).setOnClickListener(this);
        findViewById(R.id.file_bottom_item_delete).setOnClickListener(this);
        ((FileSelectBottomItemView) findViewById(R.id.file_bottom_item_translate)).setOnClickListener(this);
        findViewById(R.id.file_bottom_item_watermark).setOnClickListener(this);
    }

    /* access modifiers changed from: private */
    public void jumpToAiTranslatePage(List<String> list) {
        if (list != null && !list.isEmpty()) {
            startActivity(TextRecognitionActivity.Companion.qw(this, list, TextRecognitionActivity.FROM_PDF_TRANSLATE, (String) null, this.ubcSource));
        }
    }

    private void jumpToPage(int i2) {
    }

    private void jumpToPdfWatermarkEditPage(String str, List<String> list) {
        new FlutterYouthProvider().jumpToWatermarkEditPage(this, str, (ArrayList) list, "pdf");
    }

    /* access modifiers changed from: private */
    public void openByOtherApp() {
    }

    private void performPdfWatermarkPath() {
        fe.mmm.qw.ggg.qw.qw.qw("finsh_document_operate_watermark", (List<String>) null);
        fe.mmm.qw.o.qw.qw.qw.ad.uk.qw.ad(this, new fe.mmm.qw.o.qw.qw.qw.ad.fe(this));
    }

    private void showFailedView(@StringRes int i2) {
        this.mEmptyView.setEmptyImage(R.drawable.ic_doc_open_failed);
        this.mEmptyView.setEmptyText(i2);
        this.mEmptyView.setRefreshVisibility(0);
        this.mEmptyView.setVisibility(0);
    }

    private void showLoading() {
        this.mEmptyView.setVisibility(0);
        this.mEmptyView.setLoading(R.string.doc_is_opening);
    }

    private void showTranslateVipStatusView() {
        View findViewById = ((FileSelectBottomItemView) findViewById(R.id.file_bottom_item_translate)).findViewById(R.id.iv_file_select_bottom);
        findViewById.post(new ad(findViewById));
    }

    private void showWatermarkVipStatusView() {
        View findViewById = ((FileSelectBottomItemView) findViewById(R.id.file_bottom_item_watermark)).findViewById(R.id.iv_file_select_bottom);
        findViewById.post(new de(findViewById));
    }

    private void startAiTranslate() {
        Dialog th2 = new fe.mmm.qw.th.qw.rg.de.fe().th(this);
        th2.setCancelable(false);
        th2.show();
        VipRightsManager.qw.ad(PrivilegeType.imageAiTranslate.getValue(), (Function2<? super Boolean, ? super Integer, Unit>) null);
        findViewById(R.id.tv_free_times).setVisibility(8);
        if (!fe.mmm.qw.p030switch.rg.qw.qw().qw()) {
            showTranslateVipStatusView();
        }
        fe.mmm.qw.a.th.f7617de.execute(new th(th2));
    }

    private void switchFragment() {
        DocumentFragment documentFragment;
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        if (fe.mmm.qw.o.qw.qw.ad.ad.rg(this.mLocalPath)) {
            this.mType = 0;
            documentFragment = new PDFFragment();
        } else if (fe.mmm.qw.o.qw.qw.ad.ad.ad(this.mLocalPath)) {
            this.mType = 1;
            documentFragment = new DocTinyFragment();
        } else {
            if (fe.mmm.qw.o.qw.qw.ad.ad.de(this.mLocalPath)) {
                this.mType = 2;
            } else if (fe.mmm.qw.o.qw.qw.ad.ad.th(this.mLocalPath)) {
                this.mType = 3;
                documentFragment = new DocTinyFragment();
            }
            documentFragment = null;
        }
        if (this.mExportFile != null) {
            this.mClBottomMenu.setVisibility(0);
            updateSupportBottomFunc(documentFragment);
        }
        if (documentFragment != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_local_path", this.mLocalPath);
            bundle.putInt(DocumentFragment.KEY_TYPE, this.mType);
            documentFragment.setArguments(bundle);
            documentFragment.setControlCallback(this);
            documentFragment.setLoadCallback(this);
            documentFragment.setStaticUtils(this.mStaticUtils);
            getContext().getContentResolver();
            fe.mmm.qw.yj.th ppp = fe.mmm.qw.yj.th.ppp();
            ppp.fe("key_document_ppt_note_show_" + this.mType, false);
            this.mCurrentFragment = documentFragment;
            beginTransaction.replace((int) R.id.document_content, (Fragment) documentFragment, FRAGMENT_DOCUMENT);
        }
        beginTransaction.commitAllowingStateLoss();
        this.mLoadSucceed = false;
        showLoading();
    }

    /* access modifiers changed from: private */
    public String ubcPage() {
        int i2 = this.mType;
        if (i2 == 0) {
            return "PDFview";
        }
        return i2 == 1 ? "Wordview" : "";
    }

    private void updateAiTranslateVipStatus() {
        UITextView uITextView = (UITextView) findViewById(R.id.tv_free_times);
        int rg2 = VipRightsManager.qw.rg(PrivilegeType.imageAiTranslate.getValue());
        if (rg2 <= 0 || fe.mmm.qw.p030switch.rg.qw.qw().qw()) {
            uITextView.setVisibility(8);
            showTranslateVipStatusView();
            return;
        }
        uITextView.setVisibility(0);
        uITextView.setText(getString(R.string.free_times, new Object[]{String.valueOf(rg2)}));
    }

    private void updateSeekBar() {
    }

    private void updateSupportBottomFunc(DocumentFragment documentFragment) {
        if (documentFragment != null) {
            int supportBottomFunc = documentFragment.getSupportBottomFunc();
            if ((supportBottomFunc & 1) != 0) {
                findViewById(R.id.file_bottom_item_share).setVisibility(0);
            }
            if ((supportBottomFunc & 2) != 0) {
                findViewById(R.id.file_bottom_item_delete).setVisibility(0);
            }
            if ((supportBottomFunc & 16) != 0) {
                findViewById(R.id.file_bottom_item_pdf_split).setVisibility(0);
            }
            int i2 = supportBottomFunc & 4;
            if (i2 != 0) {
                findViewById(R.id.file_bottom_item_translate).setVisibility(0);
            } else {
                findViewById(R.id.fl_translate_vip_status).setVisibility(8);
                findViewById(R.id.tv_free_times).setVisibility(8);
            }
            int i3 = supportBottomFunc & 8;
            if (i3 != 0) {
                findViewById(R.id.file_bottom_item_watermark).setVisibility(0);
            } else {
                findViewById(R.id.tv_free_watermark_times).setVisibility(8);
                findViewById(R.id.fl_translate_watermark_vip_status).setVisibility(8);
            }
            if (i2 != 0) {
                updateAiTranslateVipStatus();
            }
            if (i3 != 0) {
                updateWaterMarkerVipStatus();
            }
        }
    }

    private void updateTitleBar() {
        this.mTitle.setText(getFileName());
    }

    private void updateView() {
    }

    private void updateWaterMarkerVipStatus() {
        int rg2 = VipRightsManager.qw.rg(PrivilegeType.imageAddWatermark.getValue());
        if (rg2 <= 0 || fe.mmm.qw.p030switch.rg.qw.qw().qw()) {
            this.tvWatermarkFreeTimes.setVisibility(8);
            showWatermarkVipStatusView();
            return;
        }
        this.tvWatermarkFreeTimes.setVisibility(0);
        this.tvWatermarkFreeTimes.setText(getString(R.string.free_times, new Object[]{String.valueOf(rg2)}));
    }

    public /* synthetic */ Unit ad(Fragment fragment, Boolean bool) {
        if (bool.booleanValue()) {
            startAiTranslate();
        }
        updateSupportBottomFunc((DocumentFragment) fragment);
        return null;
    }

    public boolean canShowToExcel() {
        return false;
    }

    public boolean canShowToPPT() {
        return false;
    }

    public boolean canShowToPic() {
        return false;
    }

    public boolean canShowToWord() {
        return false;
    }

    public /* synthetic */ void de(Dialog dialog, List list) {
        dialog.dismiss();
        jumpToPdfWatermarkEditPage(this.mLocalPath, list);
    }

    public /* synthetic */ Unit fe(Dialog dialog, List list) {
        this.mMainHandler.post(new fe.mmm.qw.o.qw.qw.qw.ad.rg(this, dialog, list));
        return Unit.INSTANCE;
    }

    public int getLayoutId() {
        return R.layout.activity_document_viewer;
    }

    public void initParams() {
        super.initParams();
        Intent intent = getIntent();
        if (intent != null) {
            this.mLocalPath = intent.getStringExtra("key_local_path");
            this.mExportFile = (ScanRecordExportFile) intent.getParcelableExtra(KEY_EXPORT_FILE);
            this.mFrom = intent.getStringExtra(KEY_FROM);
            this.ubcSource = intent.getStringExtra(KEY_UBC_SOURCE);
            ArrayList arrayList = new ArrayList(1);
            if (FROM_PDF_MERGE.equals(this.mFrom)) {
                arrayList.add("merge");
                fe.mmm.qw.ggg.qw.qw.qw("record_detail_page_display", arrayList);
            } else if (FROM_PDF_SPLIT.equals(this.mFrom)) {
                arrayList.add("extract");
                fe.mmm.qw.ggg.qw.qw.qw("record_detail_page_display", arrayList);
            }
        }
        if (!fe.mmm.qw.j.xxx.ad.xxx(this.mLocalPath)) {
            o.rg(R.string.error_file_does_not_exists);
            finish();
        }
        if (!fe.mmm.qw.o.qw.qw.ad.ad.rg(this.mLocalPath) && !fe.mmm.qw.o.qw.qw.ad.ad.fe(this.mLocalPath)) {
            finish();
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "file_form_local";
        }
    }

    public void initView() {
        initEmptyView();
        initTitleBar();
        switchFragment();
        updateSupportBottomFunc(this.mCurrentFragment);
    }

    public boolean isActivityDark() {
        return true;
    }

    public boolean isDownloaded() {
        return false;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        fe.mmm.qw.i.qw.uk(TAG, "onActivityResult requestCode = " + i2 + " resultCode = " + i3);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 10002) {
            switch (i3) {
                case 100:
                    switchSuccess(intent);
                    return;
                case 101:
                    switchFail();
                    return;
                case 102:
                    switchCancel();
                    return;
                default:
                    return;
            }
        }
    }

    public void onBackPressed() {
        DocumentFragment documentFragment = this.mCurrentFragment;
        if (documentFragment == null || !documentFragment.isPlayMode()) {
            super.onBackPressed();
        } else {
            this.mCurrentFragment.exitPlay();
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.title_back_button) {
            finish();
        } else if (id == R.id.file_bottom_item_share) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.mLocalPath);
            fe.mmm.qw.rg.qw.de.ad.ad.qw.ad(this, arrayList);
            String ubcPage = ubcPage();
            if (!TextUtils.isEmpty(ubcPage)) {
                fe.mmm.qw.o.qw.fe.qw.qw(ubcPage, this.mType == 0 ? "PDFV_Shr" : "WordV_Shr", "aiscan", (Map<String, ? extends Object>) null);
            }
        } else if (id == R.id.file_bottom_item_pdf_split) {
            if (this.mExportFile == null) {
                fe.mmm.qw.i.qw.ad(TAG, "文件为空，PDF提取失败");
                return;
            } else {
                fe.ad.qw.qw.ad.qw.de().qw("/pdf_edit/native/PdfSplitActivity").withParcelable("recordFile", this.mExportFile).navigation();
                fe.mmm.qw.o.qw.fe.qw.qw("PDFview", "PDFV_Ex", "aiscan", (Map<String, ? extends Object>) null);
            }
        } else if (id == R.id.file_bottom_item_delete) {
            DocumentFragmentKt.de(this, new fe());
            String ubcPage2 = ubcPage();
            if (!TextUtils.isEmpty(ubcPage2)) {
                fe.mmm.qw.o.qw.fe.qw.qw(ubcPage2, this.mType == 0 ? "PDFV_Dlt" : "WordV_Dlt", "aiscan", (Map<String, ? extends Object>) null);
            }
        } else if (id == R.id.file_bottom_item_translate) {
            aiTranslatePdf();
        } else if (id == R.id.file_bottom_item_watermark) {
            performPdfWatermarkPath();
        }
        if (!"file_form_local".equals(this.mFrom)) {
            "file_from_unknown".equals(this.mFrom);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mStaticUtils.de(this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mStatSource = ImagesContract.LOCAL;
        this.mStaticUtils.i(ImagesContract.LOCAL);
    }

    public void onDestroy() {
        this.mStaticUtils.qw();
        PopupWindow popupWindow = this.mPopWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.mPopWindow.dismiss();
        }
        Handler handler = this.mMainHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        super.onDestroy();
    }

    public void onEnterPlay() {
        this.mIsHideBarMode = true;
        changeBarHideMode();
    }

    public void onExitPlay() {
        this.mIsHideBarMode = false;
        changeBarHideMode();
    }

    public void onLoadFailed(@StringRes int i2, long j) {
        this.mLoadSucceed = false;
        showFailedView(i2);
        this.mStaticUtils.yj();
    }

    public void onLoadSucceed() {
        this.mLoadSucceed = true;
        hideEmptyView();
        updateView();
        updateSeekBar();
        if (this.mPositionRestoreSucceed) {
            this.mPositionRestoreSucceed = false;
        }
        this.mStaticUtils.uk();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        initParams();
        updateTitleBar();
        switchFragment();
        updateView();
    }

    public void onPDFToExcel() {
    }

    public void onPDFToPPT() {
    }

    public void onPDFToPic() {
    }

    public void onPDFToWord() {
    }

    public void onPageChanged(int i2, int i3) {
        fe.mmm.qw.i.qw.ad(TAG, i2 + " / " + i3);
    }

    public void onPause() {
        super.onPause();
        this.mStaticUtils.fe();
    }

    public void onResume() {
        super.onResume();
        this.mStaticUtils.rg();
    }

    public void onSingleClick() {
        this.mIsHideBarMode = !this.mIsHideBarMode;
        fe.mmm.qw.i.qw.ad(TAG, "单击切换沉浸态   " + this.mIsHideBarMode);
        changeBarHideMode();
    }

    public /* synthetic */ void rg(Dialog dialog) {
        fe.mmm.qw.o.qw.rg.qw.qw.qw(this, this.mLocalPath, true, new fe.mmm.qw.o.qw.qw.qw.ad.de(this, dialog));
    }

    public void switchCancel() {
        fe.mmm.qw.i.qw.uk(TAG, "switchCancel");
    }

    public void switchFail() {
        fe.mmm.qw.i.qw.uk(TAG, "switchFail");
    }

    public void switchSuccess(Intent intent) {
        fe.mmm.qw.i.qw.uk(TAG, "switchSuccess");
    }

    public /* synthetic */ Unit th(Boolean bool) {
        if (bool.booleanValue()) {
            handlePdfWatermarkPath();
        }
        updateSupportBottomFunc(this.mCurrentFragment);
        return null;
    }

    public static Intent getStartIntent(Context context, String str, ScanRecordExportFile scanRecordExportFile, String str2, int i2, long j, String str3) {
        Intent intent = new Intent(context, DocumentViewerActivity.class);
        intent.putExtra("key_local_path", str);
        intent.putExtra(KEY_EXPORT_FILE, scanRecordExportFile);
        intent.putExtra(KEY_FROM, str2);
        intent.putExtra(KEY_CONVERT_OPTION, i2);
        intent.putExtra(KEY_DOWNLOAD_TIME, j);
        intent.putExtra(KEY_FROM_PAGE_NAME, str3);
        try {
            new JSONObject().put(KEY_SUFFIX, fe.mmm.qw.j.xxx.ad.i(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return intent;
    }
}
