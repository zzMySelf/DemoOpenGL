package com.tera.scan.doc.preview.office.ui;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.baidu.aiscan.R;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.android.util.io.FileUtils;
import com.tera.scan.component.base.ui.widget.AboveInputDialog;
import com.tera.scan.doc.preview.document.ui.view.DocumentFragment;
import com.tera.scan.doc.preview.document.ui.view.DocumentViewerActivity;
import com.tera.scan.doc.preview.document.ui.view.IControlCallback;
import com.tera.scan.doc.preview.document.ui.view.flavor.DocumentFragmentKt;
import com.tera.scan.doc.preview.document.ui.view.widget.DocumentWebScrollBar;
import com.tera.scan.doc.preview.document.ui.view.widget.DocumentWebView;
import com.tera.scan.doc.preview.office.tiny.ITinyConverterCallback;
import com.tera.scan.widget.LengthLimitedEditText;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class DocTinyFragment extends DocumentFragment implements ITinyConverterCallback {
    public static final float DEFAULT_DOUBLE_TAP_MAX_FACTOR = 2.0f;
    public static final float DEFAULT_DOUBLE_TAP_MID_FACTOR = 1.5f;
    public static final String TAG = "DocFragment";
    public static final String TIME_FORMAT = "HH:mm:ss";
    public fe.mmm.qw.o.qw.ad.qw.qw mConverter;
    public int mCurPage;
    public boolean mDialogDismissByBack = true;
    public View mExitPlayer;
    public String mFileExt;
    public fe.mmm.qw.a.uk.de mHandler;
    public boolean mHasStatPasswordOpen;
    public float mInitScale = 0.0f;
    public boolean mIsPlayMode;
    public String mPassword = "";
    public AboveInputDialog mPasswordInputDialog;
    public TextView mPlayTime;
    public DocumentWebScrollBar mScrollBar;
    public long mStartTime;
    public Cif mTimerHandler = new Cif(this);
    public View mTopBar;
    public int mTotalPage;
    public DocumentWebView mWebView;

    public class ad extends WebChromeClient {
        public ad() {
        }

        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if ("com_baidu_netdisk_office_renderer_complete".equalsIgnoreCase(str2)) {
                DocTinyFragment.this.loadSucceed();
                jsPromptResult.confirm();
                return true;
            } else if (!"com_baidu_netdisk_office_renderer_failed".equalsIgnoreCase(str2)) {
                return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            } else {
                DocTinyFragment.this.loadError(R.string.doc_open_failed, -2);
                jsPromptResult.confirm();
                return true;
            }
        }
    }

    public class de implements View.OnClickListener {
        public de() {
        }

        public void onClick(View view) {
            if (DocTinyFragment.this.mControlCallback != null) {
                DocTinyFragment.this.mControlCallback.onSingleClick();
            }
        }
    }

    public class fe implements View.OnClickListener {
        public fe() {
        }

        public void onClick(View view) {
            DocTinyFragment.this.exitPlay();
        }
    }

    public class i implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ String f6889ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ JSONObject f6890th;

        public i(String str, JSONObject jSONObject) {
            this.f6889ad = str;
            this.f6890th = jSONObject;
        }

        public void run() {
            DocTinyFragment.this.onJSEventUI(this.f6889ad, this.f6890th);
        }
    }

    /* renamed from: com.tera.scan.doc.preview.office.ui.DocTinyFragment$if  reason: invalid class name */
    public static class Cif extends fe.mmm.qw.p030switch.th.ad.qw.ad<DocTinyFragment> {
        public Cif(DocTinyFragment docTinyFragment) {
            super(docTinyFragment, Looper.getMainLooper());
        }

        /* renamed from: ad */
        public void qw(DocTinyFragment docTinyFragment, Message message) {
            docTinyFragment.updateTime();
            de();
        }

        public void de() {
            sendEmptyMessageDelayed(0, 250);
        }
    }

    public class o implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ String f6892ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ String f6893th;

        public o(String str, String str2) {
            this.f6892ad = str;
            this.f6893th = str2;
        }

        public void run() {
            String tt = DocTinyFragment.this.mConverter.tt(this.f6892ad, this.f6893th);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("result", tt);
                jSONObject.put(ActionJsonData.TAG_COMMAND, this.f6892ad);
                fe.mmm.qw.i.qw.ad("postResult", "command " + this.f6892ad + " " + tt);
                DocTinyFragment.this.evaluateJS("postResult", jSONObject.toString(), (ValueCallback<String>) null);
            } catch (Throwable th2) {
                fe.mmm.qw.i.qw.de(DocTinyFragment.TAG, th2.getMessage(), th2);
            }
        }
    }

    public class pf extends WebViewClient {
        public pf() {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!TextUtils.isEmpty(str) && !str.toLowerCase().startsWith("http")) {
                webView.loadUrl(str);
            }
            DocTinyFragment.this.mWebView.removeClickEvent();
            return true;
        }

        public /* synthetic */ pf(DocTinyFragment docTinyFragment, ad adVar) {
            this();
        }
    }

    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ String f6895ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ String f6896th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f6898yj;

        /* renamed from: com.tera.scan.doc.preview.office.ui.DocTinyFragment$qw$qw  reason: collision with other inner class name */
        public class C0265qw implements ValueCallback<String> {
            public C0265qw() {
            }

            /* renamed from: qw */
            public void onReceiveValue(String str) {
                fe.mmm.qw.i.qw.ad(DocTinyFragment.TAG, "receive " + str);
                ValueCallback valueCallback = qw.this.f6898yj;
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(str);
                }
            }
        }

        public qw(String str, String str2, ValueCallback valueCallback) {
            this.f6895ad = str;
            this.f6896th = str2;
            this.f6898yj = valueCallback;
        }

        public void run() {
            DocumentWebView access$1100 = DocTinyFragment.this.mWebView;
            access$1100.evaluateJavascript("javascript: OfficeJsBridge." + this.f6895ad + "(" + this.f6896th + ")", new C0265qw());
        }
    }

    public class rg implements LengthLimitedEditText.EditTextWatcher {
        public final /* synthetic */ View qw;

        public rg(View view) {
            this.qw = view;
        }

        public void ad() {
        }

        public void qw(int i2) {
            DocTinyFragment.this.mPasswordInputDialog.getOk().setEnabled(true);
            DocTinyFragment.this.mPasswordInputDialog.getOk().setAlpha(1.0f);
            if (i2 > 0) {
                this.qw.setVisibility(0);
            } else {
                this.qw.setVisibility(8);
            }
        }
    }

    /* renamed from: com.tera.scan.doc.preview.office.ui.DocTinyFragment$switch  reason: invalid class name */
    public static class Cswitch {
        public WeakReference<DocTinyFragment> qw;

        public Cswitch(DocTinyFragment docTinyFragment) {
            this.qw = new WeakReference<>(docTinyFragment);
        }

        @JavascriptInterface
        public void onNativeEvent(String str) {
            DocTinyFragment docTinyFragment = (DocTinyFragment) this.qw.get();
            if (docTinyFragment != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("eventName");
                    JSONObject optJSONObject = jSONObject.optJSONObject("params");
                    fe.mmm.qw.i.qw.ad(DocTinyFragment.TAG, "event: " + optString + " " + optJSONObject);
                    docTinyFragment.onJSEvent(optString, optJSONObject);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
    }

    public class th implements View.OnClickListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ LengthLimitedEditText f6900ad;

        public th(LengthLimitedEditText lengthLimitedEditText) {
            this.f6900ad = lengthLimitedEditText;
        }

        public void onClick(View view) {
            String unused = DocTinyFragment.this.mPassword = this.f6900ad.getText().toString();
            if (!TextUtils.isEmpty(DocTinyFragment.this.mPassword)) {
                DocTinyFragment.this.load();
            }
        }
    }

    public class uk implements DialogInterface.OnDismissListener {
        public uk() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            FragmentActivity activity;
            if (DocTinyFragment.this.mDialogDismissByBack && (activity = DocTinyFragment.this.getActivity()) != null) {
                activity.finish();
            }
        }
    }

    public class yj implements View.OnClickListener {
        public yj() {
        }

        public void onClick(View view) {
            DocTinyFragment.this.dismissPasswordInputDialog();
            if (!TextUtils.isEmpty(DocTinyFragment.this.mPassword)) {
                try {
                    new JSONObject().put(DocumentViewerActivity.KEY_SUFFIX, DocTinyFragment.this.mFileExt);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            FragmentActivity activity = DocTinyFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    private boolean changeOrientation(int i2, boolean z) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return false;
        }
        activity.setRequestedOrientation(i2);
        Window window = activity.getWindow();
        if (window == null) {
            return true;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.flags |= 1024;
        } else {
            attributes.flags &= -1025;
        }
        window.setAttributes(attributes);
        return true;
    }

    /* access modifiers changed from: private */
    public void dismissPasswordInputDialog() {
        this.mDialogDismissByBack = false;
        AboveInputDialog aboveInputDialog = this.mPasswordInputDialog;
        if (aboveInputDialog != null) {
            aboveInputDialog.dismiss();
        }
    }

    private void evaluateJS(String str) {
        evaluateJS(str, (String) null, (ValueCallback<String>) null);
    }

    private void listenJSEvent() {
        this.mWebView.addJavascriptInterface(new Cswitch(this), "AndroidTinyJS");
    }

    /* access modifiers changed from: private */
    public void load() {
        if (!this.mHasStatPasswordOpen && !TextUtils.isEmpty(this.mPassword)) {
            this.mHasStatPasswordOpen = true;
            try {
                new JSONObject().put(DocumentViewerActivity.KEY_SUFFIX, this.mFileExt);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        fe.mmm.qw.o.qw.ad.qw.qw qwVar = new fe.mmm.qw.o.qw.ad.qw.qw(this.mLocalPath, this.mPassword, this);
        this.mConverter = qwVar;
        qwVar.mmm();
    }

    /* access modifiers changed from: private */
    public void onJSEvent(String str, JSONObject jSONObject) {
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            activity.runOnUiThread(new i(str, jSONObject));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onJSEventUI(java.lang.String r8, org.json.JSONObject r9) {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "event "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r1 = " "
            r0.append(r1)
            java.lang.String r1 = r9.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "DocFragment"
            fe.mmm.qw.i.qw.ad(r1, r0)
            int r0 = r8.hashCode()
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            switch(r0) {
                case -2113923727: goto L_0x0062;
                case -1494548933: goto L_0x0058;
                case -1058863600: goto L_0x004e;
                case -806162926: goto L_0x0044;
                case -796797441: goto L_0x003a;
                case -493598457: goto L_0x0030;
                default: goto L_0x002f;
            }
        L_0x002f:
            goto L_0x006c
        L_0x0030:
            java.lang.String r0 = "playEnd"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x006c
            r8 = 2
            goto L_0x006d
        L_0x003a:
            java.lang.String r0 = "slideInfo"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x006c
            r8 = 4
            goto L_0x006d
        L_0x0044:
            java.lang.String r0 = "doubleTap"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x006c
            r8 = 1
            goto L_0x006d
        L_0x004e:
            java.lang.String r0 = "changeSlidePage"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x006c
            r8 = 3
            goto L_0x006d
        L_0x0058:
            java.lang.String r0 = "singleTap"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x006c
            r8 = 0
            goto L_0x006d
        L_0x0062:
            java.lang.String r0 = "dispatchCommand"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x006c
            r8 = 5
            goto L_0x006d
        L_0x006c:
            r8 = -1
        L_0x006d:
            if (r8 == 0) goto L_0x00c7
            if (r8 == r5) goto L_0x00c3
            if (r8 == r4) goto L_0x00bf
            if (r8 == r3) goto L_0x00a7
            if (r8 == r2) goto L_0x0092
            if (r8 == r1) goto L_0x007b
            goto L_0x00e8
        L_0x007b:
            java.lang.String r8 = "command"
            java.lang.String r8 = r9.optString(r8)
            java.lang.String r0 = "json"
            java.lang.String r9 = r9.optString(r0)
            fe.mmm.qw.a.uk.de r0 = r7.mHandler
            com.tera.scan.doc.preview.office.ui.DocTinyFragment$o r1 = new com.tera.scan.doc.preview.office.ui.DocTinyFragment$o
            r1.<init>(r8, r9)
            r0.yj(r1)
            goto L_0x00e8
        L_0x0092:
            java.lang.String r8 = "totalPage"
            int r8 = r9.optInt(r8, r6)
            r7.mTotalPage = r8
            java.lang.String r8 = "notesCount"
            int r8 = r9.optInt(r8, r6)
            if (r8 <= 0) goto L_0x00a3
            goto L_0x00a4
        L_0x00a3:
            r5 = 0
        L_0x00a4:
            r7.mHasNote = r5
            goto L_0x00e8
        L_0x00a7:
            java.lang.String r8 = "currentPage"
            int r8 = r9.optInt(r8, r6)
            r7.mCurPage = r8
            if (r8 >= 0) goto L_0x00b3
            r7.mCurPage = r6
        L_0x00b3:
            com.tera.scan.doc.preview.document.ui.view.IControlCallback r8 = r7.mControlCallback
            if (r8 == 0) goto L_0x00e8
            int r9 = r7.mCurPage
            int r0 = r7.mTotalPage
            r8.onPageChanged(r9, r0)
            goto L_0x00e8
        L_0x00bf:
            r7.exitPlay()
            goto L_0x00e8
        L_0x00c3:
            r7.zoom()
            goto L_0x00e8
        L_0x00c7:
            boolean r8 = r7.mIsPlayMode
            if (r8 == 0) goto L_0x00e1
            android.view.View r8 = r7.mTopBar
            int r8 = r8.getVisibility()
            if (r8 != 0) goto L_0x00db
            android.view.View r8 = r7.mTopBar
            r9 = 8
            r8.setVisibility(r9)
            goto L_0x00e8
        L_0x00db:
            android.view.View r8 = r7.mTopBar
            r8.setVisibility(r6)
            goto L_0x00e8
        L_0x00e1:
            com.tera.scan.doc.preview.document.ui.view.IControlCallback r8 = r7.mControlCallback
            if (r8 == 0) goto L_0x00e8
            r8.onSingleClick()
        L_0x00e8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.doc.preview.office.ui.DocTinyFragment.onJSEventUI(java.lang.String, org.json.JSONObject):void");
    }

    private void showInputPasswordDialog() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            this.mDialogDismissByBack = true;
            AboveInputDialog aboveInputDialog = new AboveInputDialog(getActivity(), getActivity());
            this.mPasswordInputDialog = aboveInputDialog;
            aboveInputDialog.setDialogTitle((int) R.string.passwd_input_nothing);
            this.mPasswordInputDialog.setRightBtnText(R.string.okay);
            this.mPasswordInputDialog.getInputNumTextView().setVisibility(8);
            this.mPasswordInputDialog.setCanCancelOutsideTouch(false);
            ImageView deleteView = this.mPasswordInputDialog.getDeleteView();
            deleteView.setVisibility(8);
            TextView errorInfoView = this.mPasswordInputDialog.getErrorInfoView();
            errorInfoView.setVisibility(0);
            errorInfoView.setText(R.string.doc_password_input_reminder);
            errorInfoView.setTextColor(getResources().getColor(R.color.text_assist_color));
            LengthLimitedEditText editText = this.mPasswordInputDialog.getEditText();
            editText.setInputType(15);
            editText.setHint(R.string.passwd_input_nothing);
            editText.setEditTextWatcher(new rg(deleteView));
            this.mPasswordInputDialog.setRightBtnOnClickListener(new th(editText));
            this.mPasswordInputDialog.setCancelButtonClickListener(new yj());
            this.mPasswordInputDialog.setOnDismissListener(new uk());
            this.mPasswordInputDialog.show();
        }
    }

    private void startTimer() {
        stopTimer();
        Cif ifVar = this.mTimerHandler;
        if (ifVar != null) {
            ifVar.de();
        }
        updateTime();
    }

    private void stopTimer() {
        Cif ifVar = this.mTimerHandler;
        if (ifVar != null) {
            ifVar.removeCallbacksAndMessages((Object) null);
        }
    }

    /* access modifiers changed from: private */
    public void updateTime() {
        String qw2 = fe.mmm.qw.j.fe.qw(SystemClock.elapsedRealtime() - this.mStartTime);
        String format = new SimpleDateFormat(TIME_FORMAT, Locale.getDefault()).format(new Date());
        this.mPlayTime.setText(getResources().getString(R.string.ppt_play_time, new Object[]{qw2, format}));
    }

    private void zoom() {
        if (this.mInitScale <= 0.0f) {
            this.mInitScale = this.mWebView.getScale();
        }
        if (this.mWebView.getScale() < this.mInitScale * 1.5f) {
            this.mWebView.zoomBy(1.5f);
            return;
        }
        float scale = this.mWebView.getScale();
        float f = this.mInitScale;
        if (scale < f * 2.0f) {
            this.mWebView.zoomBy(2.0f);
            return;
        }
        DocumentWebView documentWebView = this.mWebView;
        documentWebView.zoomBy(f / documentWebView.getScale());
    }

    public void enterPlay() {
        if (changeOrientation(6, true)) {
            evaluateJS("showPlayPageView");
            this.mTopBar.setVisibility(0);
            this.mIsPlayMode = true;
            this.mStartTime = SystemClock.elapsedRealtime();
            startTimer();
            IControlCallback iControlCallback = this.mControlCallback;
            if (iControlCallback != null) {
                iControlCallback.onEnterPlay();
            }
        }
    }

    public void exitPlay() {
        super.exitPlay();
        if (this.mIsPlayMode && changeOrientation(-1, false)) {
            stopTimer();
            onPageTypeChanged(this.mPageType);
            this.mIsPlayMode = false;
            this.mTopBar.setVisibility(8);
            IControlCallback iControlCallback = this.mControlCallback;
            if (iControlCallback != null) {
                iControlCallback.onExitPlay();
            }
        }
    }

    public int getCurrentPage() {
        return this.mCurPage;
    }

    public int getLayoutId() {
        return R.layout.fragment_document_doc;
    }

    public int getPageCount() {
        return this.mTotalPage;
    }

    public int getSupportBottomFunc() {
        return DocumentFragmentKt.qw(this);
    }

    public boolean hasNote() {
        return super.hasNote();
    }

    public void initView() {
        super.initView();
        this.mHandler = new fe.mmm.qw.a.uk.de(TAG);
        DocumentWebView documentWebView = (DocumentWebView) findViewById(R.id.web_view);
        this.mWebView = documentWebView;
        documentWebView.setWebViewClient(new pf(this, (ad) null));
        this.mWebView.setWebChromeClient(new ad());
        this.mWebView.setOnClickListener(new de());
        this.mWebView.setIgnoreTouch(true);
        this.mWebView.setHorizontalScrollBarEnabled(false);
        this.mWebView.setVerticalFadingEdgeEnabled(false);
        DocumentWebScrollBar documentWebScrollBar = new DocumentWebScrollBar(getContext());
        this.mScrollBar = documentWebScrollBar;
        documentWebScrollBar.setupLayout((RelativeLayout) this.mLayoutView);
        this.mScrollBar.setStaticUtils(this.mStaticUtils);
        this.mWebView.setScrollBar(this.mScrollBar);
        this.mWebView.getSettings().setTextZoom(100);
        this.mTopBar = findViewById(R.id.top_bar);
        this.mExitPlayer = findViewById(R.id.exit_play);
        this.mPlayTime = (TextView) findViewById(R.id.time);
        this.mExitPlayer.setOnClickListener(new fe());
        listenJSEvent();
    }

    public boolean jumpToPage(int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("currentPage", i2);
            evaluateJS("changeCurrenSlidePage", jSONObject.toString(), (ValueCallback<String>) null);
            return true;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public boolean onBackKeyPressed() {
        if (!this.mIsPlayMode) {
            return super.onBackKeyPressed();
        }
        exitPlay();
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        fe.mmm.qw.a.uk.de deVar = this.mHandler;
        if (deVar != null) {
            deVar.o();
            this.mHandler.i();
        }
        fe.mmm.qw.o.qw.ad.qw.qw qwVar = this.mConverter;
        if (qwVar != null) {
            qwVar.tt("S_Close", new JSONObject().toString());
            this.mConverter.nn();
        }
        stopTimer();
        dismissPasswordInputDialog();
    }

    public void onError(long j) {
        if (j == 1003 || j == 1006) {
            AboveInputDialog aboveInputDialog = this.mPasswordInputDialog;
            if (aboveInputDialog == null || !aboveInputDialog.isShowing()) {
                showInputPasswordDialog();
            } else {
                this.mPasswordInputDialog.getErrorInfoView().setTextColor(getResources().getColor(R.color.logout_text));
                this.mPasswordInputDialog.setErrorInfo(R.string.doc_password_error);
            }
            if (!TextUtils.isEmpty(this.mPassword)) {
                try {
                    new JSONObject().put(DocumentViewerActivity.KEY_SUFFIX, this.mFileExt);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            loadError(R.string.doc_open_failed, j);
        }
    }

    public void onNoteShowChanged(boolean z) {
        super.onNoteShowChanged(z);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isShowSlideNote", z);
            evaluateJS("changeSlideNotesVisible", jSONObject.toString(), (ValueCallback<String>) null);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void onPageTypeChanged(int i2) {
        evaluateJS(i2 == 0 ? "showListPageView" : "showSinglePageView");
    }

    public void onSucceed(String str) {
        String encode = Uri.encode(str);
        if (this.mType == 3) {
            encode = encode + "#/slides";
        }
        this.mWebView.loadUrl((FileUtils.FILE_SCHEMA + fe.mmm.qw.o.qw.ad.qw.qw.rrr + File.separator + "index.html") + "?theme=light&folder=" + encode);
        AboveInputDialog aboveInputDialog = this.mPasswordInputDialog;
        if (aboveInputDialog != null && aboveInputDialog.isShowing()) {
            dismissPasswordInputDialog();
        }
        if (!TextUtils.isEmpty(this.mPassword)) {
            try {
                new JSONObject().put(DocumentViewerActivity.KEY_SUFFIX, this.mFileExt);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void onTTSHighLight(int i2) {
        super.onTTSHighLight(i2);
        evaluateJS("setHighlight", String.valueOf(i2) + ", 0", (ValueCallback<String>) null);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mFileExt = fe.mmm.qw.j.xxx.ad.i(this.mLocalPath);
        load();
        fe.mmm.qw.o.qw.fe.qw.ad("Wordview", "WordV", "aiscan", (Map<String, ? extends Object>) null);
    }

    /* access modifiers changed from: private */
    public void evaluateJS(String str, String str2, ValueCallback<String> valueCallback) {
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            activity.runOnUiThread(new qw(str, str2, valueCallback));
        }
    }
}
