package com.baidu.searchbox.download.center.clearcache.view.funison.local;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.download.center.clearcache.view.funison.download.base.IClearCacheDownloadViewEventListener;
import com.baidu.searchbox.download.center.clearcache.view.funison.download.base.IClearCachePhoneFileEventListener;
import com.baidu.searchbox.download.center.clearcache.view.funison.fileScan.ScanBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H$J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH$J\u0018\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH$J\u001e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dR\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/funison/local/AbsClearCachePhoneViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "contentItemView", "Landroid/view/View;", "(Landroid/view/View;)V", "<set-?>", "", "dataPosition", "getDataPosition", "()I", "viewEventListener", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/download/base/IClearCacheDownloadViewEventListener;", "getViewEventListener", "()Lcom/baidu/searchbox/download/center/clearcache/view/funison/download/base/IClearCacheDownloadViewEventListener;", "setViewEventListener", "(Lcom/baidu/searchbox/download/center/clearcache/view/funison/download/base/IClearCacheDownloadViewEventListener;)V", "viewMonthEventListener", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/download/base/IClearCachePhoneFileEventListener;", "getViewMonthEventListener", "()Lcom/baidu/searchbox/download/center/clearcache/view/funison/download/base/IClearCachePhoneFileEventListener;", "setViewMonthEventListener", "(Lcom/baidu/searchbox/download/center/clearcache/view/funison/download/base/IClearCachePhoneFileEventListener;)V", "updateContentItemView", "", "phoneFileInfo", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/fileScan/ScanBean;", "updateFolderItemView", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/fileScan/ScanBean$MonthListBean;", "isPicture", "", "updateItemView", "position", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AbsClearCachePhoneViewHolder.kt */
public abstract class AbsClearCachePhoneViewHolder extends RecyclerView.ViewHolder {
    private int dataPosition = -1;
    private IClearCacheDownloadViewEventListener viewEventListener;
    private IClearCachePhoneFileEventListener viewMonthEventListener;

    /* access modifiers changed from: protected */
    public abstract void updateContentItemView(ScanBean scanBean);

    /* access modifiers changed from: protected */
    public abstract void updateFolderItemView(ScanBean.MonthListBean monthListBean, boolean z);

    /* access modifiers changed from: protected */
    public abstract void updateItemView(ScanBean scanBean, boolean z);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbsClearCachePhoneViewHolder(View contentItemView) {
        super(contentItemView);
        Intrinsics.checkNotNullParameter(contentItemView, "contentItemView");
    }

    public final IClearCacheDownloadViewEventListener getViewEventListener() {
        return this.viewEventListener;
    }

    public final void setViewEventListener(IClearCacheDownloadViewEventListener iClearCacheDownloadViewEventListener) {
        this.viewEventListener = iClearCacheDownloadViewEventListener;
    }

    public final IClearCachePhoneFileEventListener getViewMonthEventListener() {
        return this.viewMonthEventListener;
    }

    public final void setViewMonthEventListener(IClearCachePhoneFileEventListener iClearCachePhoneFileEventListener) {
        this.viewMonthEventListener = iClearCachePhoneFileEventListener;
    }

    /* access modifiers changed from: protected */
    public final int getDataPosition() {
        return this.dataPosition;
    }

    public final void updateItemView(ScanBean phoneFileInfo, int position, boolean isPicture) {
        Intrinsics.checkNotNullParameter(phoneFileInfo, "phoneFileInfo");
        this.dataPosition = position;
        updateItemView(phoneFileInfo, isPicture);
    }
}
