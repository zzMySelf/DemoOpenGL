package com.baidu.searchbox.dynamicpublisher.draft;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.dynamicpublisher.DynamicPublisherCoreAction;
import com.baidu.searchbox.dynamicpublisher.datacollection.DataCollectionAction;
import com.baidu.searchbox.dynamicpublisher.datacollection.DataCollectionModel;
import com.baidu.searchbox.dynamicpublisher.draft.DraftAction;
import com.baidu.searchbox.dynamicpublisher.topbar.TopbarAction;
import com.baidu.searchbox.dynamicpublisher.topbar.TopbarState;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.forwardpublisher.ForwardPublisherCoreAction;
import com.baidu.searchbox.ugc.draft.DraftBoxModel;
import com.baidu.searchbox.ugc.draft.VideoDraftModel;
import com.baidu.searchbox.ugc.utils.FileUtils;
import com.baidu.searchbox.ugc.utils.SelectUtil;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0016J\u001e\u0010\u000e\u001a\u00020\u000f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/draft/DraftMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "draftEnable", "", "secondEdit", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "switchDraftProcess", "", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DraftMiddleware.kt */
public final class DraftMiddleware implements Middleware<CommonState> {
    private boolean draftEnable;
    private boolean secondEdit;

    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(next, "next");
        boolean restore = false;
        if (action instanceof DynamicPublisherCoreAction.InitAction) {
            this.secondEdit = ((DynamicPublisherCoreAction.InitAction) action).getModel().getSecondEdit();
            if (((DynamicPublisherCoreAction.InitAction) action).getModel().getSecondEdit()) {
                FileUtils.clearUgcImageDir(FileUtils.getUgcFilesRootDir() + File.separator + "image_download");
            } else {
                if (!SelectUtil.hasAiCreativeImage() && ((DynamicPublisherCoreAction.InitAction) action).getModel().isReadDraft()) {
                    restore = true;
                }
                store.dispatch(new DraftAction.InitAction(((DynamicPublisherCoreAction.InitAction) action).getModel().getDraftKey(), restore, new DraftBoxModel(DraftBoxModel.DraftType.DYNAMIC, ((DynamicPublisherCoreAction.InitAction) action).getUgcSchemeModel(), ((DynamicPublisherCoreAction.InitAction) action).getModel().getDynamicDraftModel(), (VideoDraftModel) null, 8, (DefaultConstructorMarker) null)));
            }
        } else if (action instanceof ForwardPublisherCoreAction.InitAction) {
            this.secondEdit = ((ForwardPublisherCoreAction.InitAction) action).getModel().getSecondEdit();
            if (((ForwardPublisherCoreAction.InitAction) action).getModel().getSecondEdit()) {
                FileUtils.clearUgcImageDir(FileUtils.getUgcFilesRootDir() + File.separator + "image_download");
            } else {
                store.dispatch(new DraftAction.InitAction(((ForwardPublisherCoreAction.InitAction) action).getModel().getDraftKey(), false, (DraftBoxModel) null, 6, (DefaultConstructorMarker) null));
            }
        } else if (action instanceof TopbarAction.ClickCancel) {
            if (this.secondEdit) {
                TopbarState topbarState = (TopbarState) store.getState().select(TopbarState.class);
                MutableLiveData<Boolean> secondEdit2 = topbarState != null ? topbarState.getSecondEdit() : null;
                if (secondEdit2 != null) {
                    secondEdit2.setValue(true);
                }
            } else {
                store.dispatch(DraftAction.ReadyDraft.INSTANCE);
            }
        } else if (action instanceof DraftAction.NotifyDraftStatus) {
            if (((DraftAction.NotifyDraftStatus) action).getStatus() == 2) {
                this.draftEnable = true;
            } else if (((DraftAction.NotifyDraftStatus) action).getStatus() == 0) {
                this.draftEnable = false;
            }
        } else if (action instanceof TopbarAction.ClickPublish) {
            store.dispatch(DraftAction.ForceDelete.INSTANCE);
        }
        if (this.draftEnable) {
            switchDraftProcess(store, action);
        }
        return next.next(store, action);
    }

    private final void switchDraftProcess(Store<CommonState> store, Action action) {
        DataCollectionModel it;
        if ((action instanceof DataCollectionAction.CollectComplete) && (it = ((DataCollectionAction.CollectComplete) action).getData()) != null) {
            store.dispatch(new DraftAction.TriggerDraft(DraftModelCollectUtilKt.convertDataCollectionModelToDraftModel(it)));
        }
    }
}
