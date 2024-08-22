package com.tera.scan.doc.preview.document.ui.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.baidu.aiscan.R;
import com.github.barteksc.pdfviewer.PDFThumb;
import com.github.barteksc.pdfviewer.PDFView;
import com.tera.scan.framework.kernel.architecture.ui.BaseFragment;
import fe.mmm.qw.o.qw.qw.ad.qw;
import java.util.List;

public abstract class DocumentFragment extends BaseFragment {
    public static final int BOTTOM_FUNC_DELETE = 2;
    public static final int BOTTOM_FUNC_MARK = 8;
    public static final int BOTTOM_FUNC_PDF_SPLIT = 16;
    public static final int BOTTOM_FUNC_SHARE = 1;
    public static final int BOTTOM_FUNC_TRANSLATE = 4;
    public static final String KEY_LOCAL_PATH = "key_local_path";
    public static final String KEY_REMOTE_PATH = "key_remote_path";
    public static final String KEY_TYPE = "key_type";
    public static final int PAGE_TYPE_FLIP = 1;
    public static final int PAGE_TYPE_SLIDE = 0;
    public IControlCallback mControlCallback;
    public boolean mHasNote;
    public ILoadCallback mLoadCallback;
    public String mLocalPath;
    public boolean mNoteShow;
    public int mPageType = 0;
    public String mRemotePath;
    public qw mStaticUtils;
    public int mType;

    public void enterPlay() {
    }

    public void exitPlay() {
    }

    public List<fe.mmm.qw.o.qw.qw.qw.qw.qw> getBookmarks() {
        return null;
    }

    public int getCurrentPage() {
        return 0;
    }

    public abstract int getLayoutId();

    public PDFThumb getPDFThumb() {
        return null;
    }

    public PDFView getPDFView() {
        return null;
    }

    public int getPageCount() {
        return 0;
    }

    public int getPageType() {
        return this.mPageType;
    }

    public String getPositionInfo() {
        return null;
    }

    public abstract int getSupportBottomFunc();

    public boolean hasNote() {
        return this.mHasNote;
    }

    public void initView() {
    }

    public boolean isNoteShow() {
        return this.mNoteShow;
    }

    public boolean isPlayMode() {
        return false;
    }

    public boolean jumpToPage(int i2) {
        return false;
    }

    public void loadError() {
        loadError(R.string.doc_open_failed);
    }

    public void loadSucceed() {
        ILoadCallback iLoadCallback = this.mLoadCallback;
        if (iLoadCallback != null) {
            iLoadCallback.onLoadSucceed();
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        String str;
        int i2;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        String str2 = null;
        if (arguments == null) {
            str = null;
        } else {
            str = arguments.getString("key_local_path");
        }
        this.mLocalPath = str;
        if (arguments == null) {
            i2 = 1;
        } else {
            i2 = arguments.getInt(KEY_TYPE);
        }
        this.mType = i2;
        if (arguments != null) {
            str2 = arguments.getString(KEY_REMOTE_PATH);
        }
        this.mRemotePath = str2;
        if (TextUtils.isEmpty(this.mLocalPath) && bundle != null) {
            this.mLocalPath = bundle.getString("key_local_path", this.mLocalPath);
            this.mType = bundle.getInt(KEY_TYPE, this.mType);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mLayoutView = layoutInflater.inflate(getLayoutId(), viewGroup, false);
        initView();
        return this.mLayoutView;
    }

    public void onNoteShowChanged(boolean z) {
    }

    public void onPageTypeChanged(int i2) {
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("key_local_path", this.mLocalPath);
        bundle.putInt(KEY_TYPE, this.mType);
    }

    public void onTTSHighLight(int i2) {
    }

    public void setControlCallback(IControlCallback iControlCallback) {
        this.mControlCallback = iControlCallback;
    }

    public void setLoadCallback(ILoadCallback iLoadCallback) {
        this.mLoadCallback = iLoadCallback;
    }

    public void setNoteShow(boolean z) {
        if (this.mNoteShow != z) {
            this.mNoteShow = z;
            onNoteShowChanged(z);
        }
    }

    public void setPageType(int i2) {
        if (this.mPageType != i2) {
            this.mPageType = i2;
            onPageTypeChanged(i2);
        }
    }

    public boolean setPositionInfo(String str) {
        return false;
    }

    public void setStaticUtils(qw qwVar) {
        this.mStaticUtils = qwVar;
    }

    public void loadError(@StringRes int i2) {
        ILoadCallback iLoadCallback = this.mLoadCallback;
        if (iLoadCallback != null) {
            iLoadCallback.onLoadFailed(i2, 0);
        }
    }

    public void loadError(@StringRes int i2, long j) {
        ILoadCallback iLoadCallback = this.mLoadCallback;
        if (iLoadCallback != null) {
            iLoadCallback.onLoadFailed(i2, j);
        }
    }
}
