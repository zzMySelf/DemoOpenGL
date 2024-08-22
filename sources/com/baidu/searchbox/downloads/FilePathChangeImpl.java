package com.baidu.searchbox.downloads;

import android.text.TextUtils;
import com.baidu.android.ext.widget.ListBtnPopupWindow;
import com.baidu.searchbox.data.DialogData;
import java.lang.ref.WeakReference;

public class FilePathChangeImpl implements ListBtnPopupWindow.IFilePathChange {
    private DialogData mDialogData;
    private WeakReference<ListBtnPopupWindow> mRealDialog;

    public void setRealDialog(ListBtnPopupWindow realDialog) {
        this.mRealDialog = new WeakReference<>(realDialog);
    }

    public void setDialogData(DialogData dialogData) {
        this.mDialogData = dialogData;
    }

    public void onFilePathReturn(String path, String name) {
        WeakReference<ListBtnPopupWindow> weakReference;
        ListBtnPopupWindow realDialog;
        if (!TextUtils.isEmpty(path) && (weakReference = this.mRealDialog) != null && this.mDialogData != null && (realDialog = (ListBtnPopupWindow) weakReference.get()) != null) {
            this.mDialogData.downloadPath[0] = path;
            this.mDialogData.fileName = name;
            realDialog.setDownloadPath(path, name);
        }
    }
}
