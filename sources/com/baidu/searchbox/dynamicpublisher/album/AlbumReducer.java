package com.baidu.searchbox.dynamicpublisher.album;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.dynamicpublisher.album.AlbumAction;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/album/AlbumReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "reduce", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AlbumReducer.kt */
public final class AlbumReducer implements Reducer<CommonState> {
    public CommonState reduce(CommonState state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        MutableLiveData mutableLiveData = null;
        if (action instanceof AlbumAction.InitAction) {
            if (((AlbumAction.InitAction) action).getAlbumBaseModel() == null) {
                return state;
            }
            AlbumState albumState = (AlbumState) state.select(AlbumState.class);
            MutableLiveData<AlbumBaseModel> baseModel = albumState != null ? albumState.getBaseModel() : null;
            if (baseModel != null) {
                baseModel.setValue(((AlbumAction.InitAction) action).getAlbumBaseModel());
            }
            AlbumState albumState2 = (AlbumState) state.select(AlbumState.class);
            if (albumState2 != null) {
                mutableLiveData = albumState2.getAlbumInit();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(Unit.INSTANCE);
            }
        } else if (action instanceof AlbumAction.InvokeAlbum) {
            AlbumState albumState3 = (AlbumState) state.select(AlbumState.class);
            if (albumState3 != null) {
                mutableLiveData = albumState3.getOperationModel();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(new AlbumOperationModel(((AlbumAction.InvokeAlbum) action).getType(), false, ((AlbumAction.InvokeAlbum) action).getMaxImageSize(), ((AlbumAction.InvokeAlbum) action).getSourceFrom(), 2, (DefaultConstructorMarker) null));
            }
        } else if (action instanceof AlbumAction.InvokeCapture) {
            AlbumState albumState4 = (AlbumState) state.select(AlbumState.class);
            if (albumState4 != null) {
                mutableLiveData = albumState4.getCaptureOperation();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(Unit.INSTANCE);
            }
        } else if (action instanceof AlbumAction.InvokeCoverPage) {
            AlbumState albumState5 = (AlbumState) state.select(AlbumState.class);
            if (albumState5 != null) {
                mutableLiveData = albumState5.getCoverOperation();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(((AlbumAction.InvokeCoverPage) action).getVideoPath());
            }
        } else if (action instanceof AlbumAction.showHalfAlbumView) {
            AlbumState albumState6 = (AlbumState) state.select(AlbumState.class);
            if (albumState6 != null) {
                mutableLiveData = albumState6.getShowHalfAlbum();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(((AlbumAction.showHalfAlbumView) action).getShow());
            }
        } else if (action instanceof AlbumAction.ImageChange) {
            AlbumState albumState7 = (AlbumState) state.select(AlbumState.class);
            if (albumState7 != null) {
                mutableLiveData = albumState7.getImageSelChange();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(Unit.INSTANCE);
            }
        } else if (action instanceof AlbumAction.InitShowAiCreativeImageEnterView) {
            AlbumState albumState8 = (AlbumState) state.select(AlbumState.class);
            if (albumState8 != null) {
                mutableLiveData = albumState8.getInitShowAiCreativeImageEnterView();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(((AlbumAction.InitShowAiCreativeImageEnterView) action).getInitShowAiCreativeImageEnter());
            }
        } else if (action instanceof AlbumAction.HideAiCreativeImageAction) {
            AlbumState albumState9 = (AlbumState) state.select(AlbumState.class);
            if (albumState9 != null) {
                mutableLiveData = albumState9.getHideCreativeImageEnterView();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(Boolean.valueOf(((AlbumAction.HideAiCreativeImageAction) action).getHide()));
            }
        } else if (action instanceof AlbumAction.HideAlbumPermissionViewAction) {
            AlbumState albumState10 = (AlbumState) state.select(AlbumState.class);
            if (albumState10 != null) {
                mutableLiveData = albumState10.getHideAlbumPermissionView();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(Boolean.valueOf(((AlbumAction.HideAlbumPermissionViewAction) action).isAgree()));
            }
        } else if (action instanceof AlbumAction.HasReachMaxSelectImage) {
            AlbumState albumState11 = (AlbumState) state.select(AlbumState.class);
            if (albumState11 != null) {
                mutableLiveData = albumState11.getHasReachMaxSelectImage();
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(Boolean.valueOf(((AlbumAction.HasReachMaxSelectImage) action).getHasReachMaxSelectImage()));
            }
        }
        return state;
    }
}
