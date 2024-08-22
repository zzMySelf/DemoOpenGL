package com.baidu.searchbox.smartmenu.model;

import com.baidu.searchbox.downloadcenter.service.models.SmartMenuDownloadItem;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.history.api.data.HistoryModel;
import com.baidu.searchbox.smartmenu.SmartMenuCardType;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/smartmenu/model/SmartMenuExposeBlockModel;", "Lcom/baidu/searchbox/smartmenu/model/SmartMenuBlockModel;", "()V", "downloadData", "", "Lcom/baidu/searchbox/downloadcenter/service/models/SmartMenuDownloadItem;", "getDownloadData", "()Ljava/util/List;", "setDownloadData", "(Ljava/util/List;)V", "favorData", "Lcom/baidu/searchbox/favor/data/FavorModel;", "getFavorData", "setFavorData", "historyData", "Lcom/baidu/searchbox/history/api/data/HistoryModel;", "getHistoryData", "setHistoryData", "resumePlayData", "Lcom/baidu/searchbox/smartmenu/model/SmartMenuResumePlayItemModel;", "getResumePlayData", "setResumePlayData", "shareData", "Lcom/baidu/searchbox/smartmenu/model/SmartMenuShareModel;", "getShareData", "()Lcom/baidu/searchbox/smartmenu/model/SmartMenuShareModel;", "setShareData", "(Lcom/baidu/searchbox/smartmenu/model/SmartMenuShareModel;)V", "isAvailable", "", "lib-smart-menu_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SmartMenuExposeBlockModel.kt */
public final class SmartMenuExposeBlockModel extends SmartMenuBlockModel {
    private List<SmartMenuDownloadItem> downloadData;
    private List<? extends FavorModel> favorData;
    private List<HistoryModel> historyData;
    private List<SmartMenuResumePlayItemModel> resumePlayData;
    private SmartMenuShareModel shareData;

    public final List<SmartMenuDownloadItem> getDownloadData() {
        return this.downloadData;
    }

    public final void setDownloadData(List<SmartMenuDownloadItem> list) {
        this.downloadData = list;
    }

    public final List<HistoryModel> getHistoryData() {
        return this.historyData;
    }

    public final void setHistoryData(List<HistoryModel> list) {
        this.historyData = list;
    }

    public final List<FavorModel> getFavorData() {
        return this.favorData;
    }

    public final void setFavorData(List<? extends FavorModel> list) {
        this.favorData = list;
    }

    public final SmartMenuShareModel getShareData() {
        return this.shareData;
    }

    public final void setShareData(SmartMenuShareModel smartMenuShareModel) {
        this.shareData = smartMenuShareModel;
    }

    public final List<SmartMenuResumePlayItemModel> getResumePlayData() {
        return this.resumePlayData;
    }

    public final void setResumePlayData(List<SmartMenuResumePlayItemModel> list) {
        this.resumePlayData = list;
    }

    public boolean isAvailable() {
        boolean z = true;
        if (getBlockModelType() == SmartMenuCardType.DOWNLOAD) {
            Collection collection = this.downloadData;
            if (collection == null || collection.isEmpty()) {
                return false;
            }
        }
        if (getBlockModelType() == SmartMenuCardType.HISTORY) {
            Collection collection2 = this.historyData;
            if (collection2 == null || collection2.isEmpty()) {
                return false;
            }
        }
        if (getBlockModelType() == SmartMenuCardType.COLLECTION) {
            Collection collection3 = this.favorData;
            if (collection3 == null || collection3.isEmpty()) {
                return false;
            }
        }
        if (getBlockModelType() == SmartMenuCardType.SHARE) {
            SmartMenuShareModel smartMenuShareModel = this.shareData;
            if (!(smartMenuShareModel != null && smartMenuShareModel.isAvailable())) {
                return false;
            }
        }
        if (getBlockModelType() == SmartMenuCardType.RESUME_PLAY) {
            Collection collection4 = this.resumePlayData;
            if (collection4 != null && !collection4.isEmpty()) {
                z = false;
            }
            if (z) {
                return false;
            }
        }
        return super.isAvailable();
    }
}
