package com.baidu.searchbox.music.comp.playlist.toolbar;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.music.MusicManager;
import com.baidu.searchbox.music.R;
import com.baidu.searchbox.music.comp.playlist.panel.TabType;
import com.baidu.searchbox.music.ext.utils.MusicUiUtil;
import com.baidu.searchbox.nacomp.mvvm.impl.BaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u001cJ\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0007J\u000e\u0010!\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0007J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u0010#\u001a\u00020\u001cJ\u0012\u0010$\u001a\u00020\u001c2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\tR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\tR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\tR\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\t¨\u0006%"}, d2 = {"Lcom/baidu/searchbox/music/comp/playlist/toolbar/PanelToolBarViewModel;", "Lcom/baidu/searchbox/nacomp/mvvm/impl/BaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "actionImgResId", "Landroidx/lifecycle/MutableLiveData;", "", "getActionImgResId", "()Landroidx/lifecycle/MutableLiveData;", "actionTips", "", "getActionTips", "isEnableEdit", "", "isEnablePlay", "isEnterEditMode", "model", "Lcom/baidu/searchbox/music/comp/playlist/toolbar/ToolBarModel;", "showMusicCollect", "getShowMusicCollect", "showMusicEdit", "getShowMusicEdit", "supportPlayDes", "getSupportPlayDes", "tabType", "Lcom/baidu/searchbox/music/comp/playlist/panel/TabType;", "initData", "", "onMusicEditClick", "resetMusicEdit", "setListTotalCount", "count", "setSupportPlayCount", "updateActionTips", "updatePlayerActionTips", "updateToolsStatus", "lib-music_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PanelToolBarViewModel.kt */
public final class PanelToolBarViewModel extends BaseViewModel {
    private final MutableLiveData<Integer> actionImgResId = new MutableLiveData<>();
    private final MutableLiveData<String> actionTips = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isEnableEdit = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isEnablePlay = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isEnterEditMode = new MutableLiveData<>();
    private ToolBarModel model;
    private final MutableLiveData<Boolean> showMusicCollect = new MutableLiveData<>();
    private final MutableLiveData<Boolean> showMusicEdit = new MutableLiveData<>();
    private final MutableLiveData<String> supportPlayDes = new MutableLiveData<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PanelToolBarViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
    }

    public final MutableLiveData<Integer> getActionImgResId() {
        return this.actionImgResId;
    }

    public final MutableLiveData<Boolean> getShowMusicCollect() {
        return this.showMusicCollect;
    }

    public final MutableLiveData<Boolean> getShowMusicEdit() {
        return this.showMusicEdit;
    }

    public final MutableLiveData<Boolean> isEnterEditMode() {
        return this.isEnterEditMode;
    }

    public final MutableLiveData<String> getActionTips() {
        return this.actionTips;
    }

    public final MutableLiveData<Boolean> isEnablePlay() {
        return this.isEnablePlay;
    }

    public final MutableLiveData<String> getSupportPlayDes() {
        return this.supportPlayDes;
    }

    public final MutableLiveData<Boolean> isEnableEdit() {
        return this.isEnableEdit;
    }

    public final void initData(ToolBarModel model2) {
        Intrinsics.checkNotNullParameter(model2, "model");
        this.model = model2;
        this.actionImgResId.setValue(Integer.valueOf(getActionImgResId(model2.getTabType())));
        updateToolsStatus(model2);
        updateActionTips(model2.getTabType());
        setListTotalCount(model2.getMusicCount());
        setSupportPlayCount(model2.getCanPlayNum());
    }

    private final void updateToolsStatus(ToolBarModel model2) {
        TabType tabType = null;
        boolean z = true;
        this.showMusicCollect.setValue(Boolean.valueOf((model2 != null ? model2.getTabType() : null) == TabType.PLAY_LIST));
        MutableLiveData<Boolean> mutableLiveData = this.showMusicEdit;
        if ((model2 != null ? model2.getTabType() : null) != TabType.HIS_LIST) {
            if ((model2 != null ? model2.getTabType() : null) != TabType.PLAY_LIST) {
                if (model2 != null) {
                    tabType = model2.getTabType();
                }
                if (tabType != TabType.FAVOR_LIST) {
                    z = false;
                }
            }
        }
        mutableLiveData.setValue(Boolean.valueOf(z));
    }

    public final void setSupportPlayCount(int count) {
        this.supportPlayDes.setValue(MusicUiUtil.getNAPlaySongDesc(count));
        this.isEnablePlay.setValue(Boolean.valueOf(count > 0));
    }

    public final void setListTotalCount(int count) {
        boolean isEnableEdit2 = count > 0;
        this.isEnableEdit.setValue(Boolean.valueOf(isEnableEdit2));
        if (!isEnableEdit2) {
            resetMusicEdit();
        }
    }

    public final void onMusicEditClick() {
        this.isEnterEditMode.setValue(true);
        updateToolsStatus((ToolBarModel) null);
    }

    public final void resetMusicEdit() {
        this.isEnterEditMode.setValue(false);
        updateToolsStatus(this.model);
    }

    private final int getActionImgResId(TabType tabType) {
        if (tabType == TabType.FAVOR_LIST || tabType == TabType.HIS_LIST) {
            return R.drawable.search_music_detail_play;
        }
        if (tabType != TabType.PLAY_LIST) {
            return 0;
        }
        switch (MusicManager.Companion.get().getPlaylistController().getPlayMode()) {
            case 2:
                return R.drawable.play_mode_loop;
            case 3:
                return R.drawable.play_mode_random;
            default:
                return R.drawable.play_mode_order;
        }
    }

    private final void updateActionTips(TabType tabType) {
        String str;
        MutableLiveData<String> mutableLiveData = this.actionTips;
        if (tabType == TabType.PLAY_LIST) {
            switch (MusicManager.Companion.get().getPlaylistController().getPlayMode()) {
                case 2:
                    str = "单曲循环";
                    break;
                case 3:
                    str = "随机播放";
                    break;
                default:
                    str = "顺序播放";
                    break;
            }
        } else {
            str = "播放全部";
        }
        mutableLiveData.setValue(str);
    }

    public final void updatePlayerActionTips() {
        ToolBarModel $this$updatePlayerActionTips_u24lambda_u2d0 = this.model;
        if ($this$updatePlayerActionTips_u24lambda_u2d0 != null) {
            updateActionTips($this$updatePlayerActionTips_u24lambda_u2d0.getTabType());
        }
    }
}
