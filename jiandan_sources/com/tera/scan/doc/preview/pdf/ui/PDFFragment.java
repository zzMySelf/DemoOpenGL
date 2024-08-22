package com.tera.scan.doc.preview.pdf.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.baidu.aiscan.R;
import com.baidu.android.util.io.DocumentOpenUtil;
import com.github.barteksc.pdfviewer.PDFThumb;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnEndTipShowListener;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnLongPressListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnRenderListener;
import com.github.barteksc.pdfviewer.listener.OnTapListener;
import com.google.gson.Gson;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfPasswordException;
import com.tera.scan.component.base.ui.widget.AboveInputDialog;
import com.tera.scan.doc.preview.document.ui.view.DocumentFragment;
import com.tera.scan.doc.preview.document.ui.view.IControlCallback;
import com.tera.scan.doc.preview.document.ui.view.flavor.DocumentFragmentKt;
import com.tera.scan.doc.preview.pdf.ui.model.PDFPosition;
import com.tera.scan.doc.preview.pdf.ui.widget.PDFScrollHandle;
import com.tera.scan.utils.SizeUtils;
import com.tera.scan.widget.LengthLimitedEditText;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PDFFragment extends DocumentFragment implements OnPageChangeListener, OnLoadCompleteListener, OnErrorListener, OnRenderListener, OnTapListener, OnLongPressListener, OnEndTipShowListener, View.OnClickListener {
    public static final String KEY_PAGE = "key_page";
    public static final String KEY_PASSWORD = "key_password";
    public static final int SPACE = 2;
    public static final String TAG = "PDFFragment";
    public List<fe.mmm.qw.o.qw.qw.qw.qw.qw> mBookmarks = new ArrayList();
    public boolean mDialogDismissByBack = true;
    public View mEndTipView;
    public boolean mIsNightMode;
    public View mPDF2Excel;
    public View mPDF2PPT;
    public View mPDF2Pic;
    public View mPDF2Word;
    public PDFPosition mPDFPosition;
    public PDFView mPDFView;
    public int mPage = 0;
    public String mPassword = "";
    public AboveInputDialog mPasswordInputDialog;
    public PDFScrollHandle mScrollHandle;

    public class ad implements View.OnClickListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ LengthLimitedEditText f6905ad;

        public ad(LengthLimitedEditText lengthLimitedEditText) {
            this.f6905ad = lengthLimitedEditText;
        }

        public void onClick(View view) {
            String unused = PDFFragment.this.mPassword = this.f6905ad.getText().toString();
            if (!TextUtils.isEmpty(PDFFragment.this.mPassword)) {
                PDFFragment.this.load();
            }
        }
    }

    public class de implements View.OnClickListener {
        public de() {
        }

        public void onClick(View view) {
            PDFFragment.this.dismissPasswordInputDialog();
            FragmentActivity activity = PDFFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public class fe implements DialogInterface.OnDismissListener {
        public fe() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            FragmentActivity activity;
            if (PDFFragment.this.mDialogDismissByBack && (activity = PDFFragment.this.getActivity()) != null) {
                activity.finish();
            }
        }
    }

    public class qw implements LengthLimitedEditText.EditTextWatcher {
        public final /* synthetic */ View qw;

        public qw(View view) {
            this.qw = view;
        }

        public void ad() {
        }

        public void qw(int i2) {
            PDFFragment.this.mPasswordInputDialog.getOk().setEnabled(true);
            PDFFragment.this.mPasswordInputDialog.getOk().setAlpha(1.0f);
            if (i2 > 0) {
                this.qw.setVisibility(0);
            } else {
                this.qw.setVisibility(8);
            }
        }
    }

    public class rg implements Runnable {
        public rg() {
        }

        public void run() {
            PDFFragment.this.mPDFView.zoomTo(PDFFragment.this.mPDFPosition.getZoom());
            if (PDFFragment.this.mPageType == 1 || (PDFFragment.this.mPDFPosition.getOffsetX() == 0.0f && PDFFragment.this.mPDFPosition.getOffsetY() == 0.0f)) {
                PDFFragment.this.mPDFView.jumpTo(PDFFragment.this.mPDFPosition.getPage(), false);
            } else {
                PDFFragment.this.mPDFView.moveTo(PDFFragment.this.mPDFPosition.getOffsetX(), PDFFragment.this.mPDFPosition.getOffsetY(), true);
            }
            PDFFragment.this.mPDFView.loadPageByOffset();
            PDFPosition unused = PDFFragment.this.mPDFPosition = null;
        }
    }

    private List<fe.mmm.qw.o.qw.qw.qw.qw.qw> convertBookmarks(PdfDocument.Bookmark bookmark) {
        ArrayList arrayList = new ArrayList();
        fe.mmm.qw.o.qw.qw.qw.qw.qw qwVar = new fe.mmm.qw.o.qw.qw.qw.qw.qw();
        qwVar.fe(bookmark.getTitle());
        qwVar.ad((int) bookmark.getPageIdx());
        arrayList.add(qwVar);
        for (PdfDocument.Bookmark convertBookmarks : bookmark.getChildren()) {
            arrayList.addAll(convertBookmarks(convertBookmarks));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void dismissPasswordInputDialog() {
        this.mDialogDismissByBack = false;
        this.mPasswordInputDialog.dismiss();
    }

    private boolean isNightMode(Context context) {
        if (context != null) {
            return !context.getPackageName().equals(fe.mmm.qw.d.de.de.when().pf());
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void load() {
        fe.mmm.qw.i.qw.ad(TAG, "PDF open " + this.mLocalPath);
        if (this.mPDFView != null) {
            boolean z = this.mPageType == 1;
            PDFView.ad fromFile = this.mPDFView.fromFile(new File(this.mLocalPath));
            fromFile.ad(this.mPage);
            fromFile.xxx(this.mPassword);
            fromFile.fe(true);
            fromFile.rg(true);
            fromFile.th(true);
            fromFile.qw(z);
            fromFile.nn(SizeUtils.qw(2.0f));
            fromFile.vvv(z);
            fromFile.ggg(z);
            fromFile.mmm(z);
            fromFile.de(true);
            fromFile.m278switch(this);
            fromFile.pf(this);
            fromFile.o(this);
            fromFile.when(this);
            fromFile.ppp(this);
            fromFile.m277if(this);
            fromFile.ddd(this.mScrollHandle);
            fromFile.yj(this.mEndTipView);
            fromFile.i(this);
            fromFile.uk();
        }
    }

    private void loadEndTipView(Context context) {
        if (this.mEndTipView == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_pdf_end_layout, (ViewGroup) null, false);
            this.mEndTipView = inflate;
            this.mPDF2Word = inflate.findViewById(R.id.pdf_to_word);
            this.mPDF2PPT = this.mEndTipView.findViewById(R.id.pdf_to_ppt);
            this.mPDF2Excel = this.mEndTipView.findViewById(R.id.pdf_to_excel);
            this.mPDF2Pic = this.mEndTipView.findViewById(R.id.pdf_to_pic);
            this.mPDF2Word.setOnClickListener(this);
            this.mPDF2PPT.setOnClickListener(this);
            this.mPDF2Excel.setOnClickListener(this);
            this.mPDF2Pic.setOnClickListener(this);
            IControlCallback iControlCallback = this.mControlCallback;
            if (iControlCallback != null) {
                if (iControlCallback.canShowToWord()) {
                    this.mPDF2Word.setVisibility(0);
                }
                if (this.mControlCallback.canShowToPPT()) {
                    this.mPDF2PPT.setVisibility(0);
                }
                if (this.mControlCallback.canShowToExcel()) {
                    this.mPDF2Excel.setVisibility(0);
                }
                if (this.mControlCallback.canShowToPic()) {
                    this.mPDF2Pic.setVisibility(0);
                }
            }
        }
    }

    private void readBookmarks() {
        this.mBookmarks.clear();
        List<PdfDocument.Bookmark> tableOfContents = this.mPDFView.getTableOfContents();
        if (tableOfContents != null) {
            for (PdfDocument.Bookmark convertBookmarks : tableOfContents) {
                this.mBookmarks.addAll(convertBookmarks(convertBookmarks));
            }
        }
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
            editText.setEditTextWatcher(new qw(deleteView));
            this.mPasswordInputDialog.setRightBtnOnClickListener(new ad(editText));
            this.mPasswordInputDialog.setCancelButtonClickListener(new de());
            this.mPasswordInputDialog.setOnDismissListener(new fe());
            this.mPasswordInputDialog.show();
        }
    }

    public List<fe.mmm.qw.o.qw.qw.qw.qw.qw> getBookmarks() {
        if (this.mBookmarks.size() > 0) {
            boolean z = false;
            for (int size = this.mBookmarks.size() - 1; size >= 0; size--) {
                fe.mmm.qw.o.qw.qw.qw.qw.qw qwVar = this.mBookmarks.get(size);
                if (z || qwVar.qw() > this.mPDFView.getCurrentPage()) {
                    qwVar.de(false);
                } else {
                    qwVar.de(true);
                    z = true;
                }
            }
        }
        return this.mBookmarks;
    }

    public int getCurrentPage() {
        PDFView pDFView = this.mPDFView;
        if (pDFView == null) {
            return 0;
        }
        return pDFView.getCurrentPage();
    }

    public String getKeyPassword() {
        return this.mPassword;
    }

    public int getLayoutId() {
        return R.layout.fragment_document_pdf;
    }

    public PDFThumb getPDFThumb() {
        PDFView pDFView = this.mPDFView;
        if (pDFView == null) {
            return null;
        }
        return pDFView.getPDFThumb();
    }

    public PDFView getPDFView() {
        return this.mPDFView;
    }

    public int getPageCount() {
        PDFView pDFView = this.mPDFView;
        if (pDFView == null) {
            return 0;
        }
        return pDFView.getPageCount();
    }

    public String getPositionInfo() {
        if (this.mPDFView != null) {
            PDFPosition pDFPosition = new PDFPosition();
            pDFPosition.setSwipeVertical(this.mPDFView.isSwipeVertical());
            pDFPosition.setZoom(this.mPDFView.getZoom());
            pDFPosition.setPage(this.mPDFView.getCurrentPage());
            if (getResources().getConfiguration().orientation == 1) {
                pDFPosition.setOffsetX(this.mPDFView.getCurrentXOffset());
                pDFPosition.setOffsetY(this.mPDFView.getCurrentYOffset());
            }
            try {
                return new Gson().toJson((Object) pDFPosition);
            } catch (Exception e) {
                fe.mmm.qw.i.qw.de(TAG, e.getMessage(), e);
            }
        }
        return super.getPositionInfo();
    }

    public int getSupportBottomFunc() {
        return DocumentFragmentKt.ad(this);
    }

    public void initView() {
        super.initView();
        PDFScrollHandle pDFScrollHandle = new PDFScrollHandle(getContext());
        this.mScrollHandle = pDFScrollHandle;
        pDFScrollHandle.setStaticUtils(this.mStaticUtils);
        this.mPDFView = (PDFView) findViewById(R.id.pdf_view);
        loadEndTipView(getContext());
    }

    public boolean jumpToPage(int i2) {
        PDFView pDFView = this.mPDFView;
        if (pDFView == null || i2 >= pDFView.getPageCount()) {
            return false;
        }
        this.mPDFView.jumpTo(i2, false);
        return true;
    }

    public void loadComplete(int i2) {
        fe.mmm.qw.i.qw.ad(TAG, "loadComplete");
        readBookmarks();
        if (this.mScrollHandle.shown()) {
            this.mScrollHandle.hideDelayed();
        }
        AboveInputDialog aboveInputDialog = this.mPasswordInputDialog;
        if (aboveInputDialog != null && aboveInputDialog.isShowing()) {
            dismissPasswordInputDialog();
        }
        loadSucceed();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.pdf_to_word) {
            if (this.mControlCallback != null) {
                fe.mmm.qw.o.qw.qw.ad.qw qwVar = this.mStaticUtils;
                if (qwVar != null) {
                    qwVar.ad(DocumentOpenUtil.DOC);
                }
                this.mControlCallback.onPDFToWord();
            }
        } else if (id == R.id.pdf_to_ppt) {
            if (this.mControlCallback != null) {
                fe.mmm.qw.o.qw.qw.ad.qw qwVar2 = this.mStaticUtils;
                if (qwVar2 != null) {
                    qwVar2.ad(DocumentOpenUtil.PPT);
                }
                this.mControlCallback.onPDFToPPT();
            }
        } else if (id == R.id.pdf_to_excel) {
            if (this.mControlCallback != null) {
                fe.mmm.qw.o.qw.qw.ad.qw qwVar3 = this.mStaticUtils;
                if (qwVar3 != null) {
                    qwVar3.ad("excel");
                }
                this.mControlCallback.onPDFToExcel();
            }
        } else if (id == R.id.pdf_to_pic && this.mControlCallback != null) {
            fe.mmm.qw.o.qw.qw.ad.qw qwVar4 = this.mStaticUtils;
            if (qwVar4 != null) {
                qwVar4.ad("pic");
            }
            this.mControlCallback.onPDFToPic();
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.mPage = bundle.getInt(KEY_PAGE, 0);
            this.mPassword = bundle.getString(KEY_PASSWORD);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        AboveInputDialog aboveInputDialog = this.mPasswordInputDialog;
        if (aboveInputDialog != null) {
            aboveInputDialog.dismiss();
        }
    }

    public void onEndTipShow() {
    }

    public void onError(Throwable th2) {
        fe.mmm.qw.i.qw.th(TAG, th2.getMessage(), th2);
        if (th2 instanceof PdfPasswordException) {
            AboveInputDialog aboveInputDialog = this.mPasswordInputDialog;
            if (aboveInputDialog == null || !aboveInputDialog.isShowing()) {
                showInputPasswordDialog();
                return;
            }
            this.mPasswordInputDialog.getErrorInfoView().setTextColor(getResources().getColor(R.color.logout_text));
            this.mPasswordInputDialog.setErrorInfo(R.string.doc_password_error);
            return;
        }
        loadError();
    }

    public void onInitiallyRendered(int i2) {
        PDFView pDFView;
        if (this.mPDFPosition != null && (pDFView = this.mPDFView) != null) {
            pDFView.post(new rg());
        }
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public void onPageChanged(int i2, int i3) {
        IControlCallback iControlCallback = this.mControlCallback;
        if (iControlCallback != null) {
            iControlCallback.onPageChanged(i2, i3);
        }
    }

    public void onPageTypeChanged(int i2) {
        PDFView pDFView = this.mPDFView;
        if (pDFView != null) {
            this.mPage = Math.max(pDFView.getCurrentPage(), 0);
        }
        load();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(KEY_PAGE, this.mPDFView.getCurrentPage());
        bundle.putString(KEY_PASSWORD, this.mPassword);
    }

    public boolean onTap(MotionEvent motionEvent) {
        IControlCallback iControlCallback = this.mControlCallback;
        if (iControlCallback == null) {
            return false;
        }
        iControlCallback.onSingleClick();
        if (!this.mScrollHandle.shown()) {
            return true;
        }
        this.mScrollHandle.hideDelayed();
        return true;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mIsNightMode = isNightMode(view.getContext());
        load();
        fe.mmm.qw.o.qw.fe.qw.ad("PDFview", "PDFV", "aiscan", (Map<String, ? extends Object>) null);
    }

    public boolean setPositionInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                PDFPosition pDFPosition = (PDFPosition) new Gson().fromJson(str, PDFPosition.class);
                this.mPDFPosition = pDFPosition;
                this.mPageType = pDFPosition.isSwipeVertical() ? 0 : 1;
                return true;
            } catch (Exception e) {
                fe.mmm.qw.i.qw.de(TAG, e.getMessage(), e);
            }
        }
        return super.setPositionInfo(str);
    }
}
