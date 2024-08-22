package com.baidu.searchbox.music.ext.album.detail.comp.songlist.item.song;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.music.bean.Label;
import com.baidu.searchbox.music.ext.R;
import com.baidu.searchbox.music.ext.album.playback.PlaybackRepo;
import com.baidu.searchbox.music.ext.model.ISong;
import com.baidu.searchbox.music.ext.model.SongExtraKt;
import com.baidu.searchbox.nacomp.extension.base.BaseExtItemViewModel;
import com.baidu.searchbox.nacomp.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;

public class SongViewModel extends BaseExtItemViewModel<SongData> {
    final MutableLiveData<Boolean> isFree = new MutableLiveData<>();
    final MutableLiveData<Boolean> isSelected = new MutableLiveData<>();
    final MutableLiveData<List<Label>> labelList = new MutableLiveData<>();
    final MutableLiveData<String> musicTag = new MutableLiveData<>();
    final MutableLiveData<Integer> musicTagBgRes = new MutableLiveData<>();
    final MutableLiveData<Boolean> showCollect = new MutableLiveData<>();
    final MutableLiveData<Boolean> showSel = new MutableLiveData<>();
    final MutableLiveData<Boolean> showWave = new MutableLiveData<>();
    final MutableLiveData<String> songAdditional = new MutableLiveData<>();
    final MutableLiveData<Integer> songAdditionalColor = new MutableLiveData<>();
    final MutableLiveData<String> songCover = new MutableLiveData<>();
    final MutableLiveData<String> songName = new MutableLiveData<>();
    final MutableLiveData<Integer> songNameColor = new MutableLiveData<>();
    final MutableLiveData<Boolean> startWave = new MutableLiveData<>();

    public void setModel(SongData model) {
        super.setModel(model);
        this.songCover.setValue(model.getSong().getAlbumInfo().getCover());
        this.songName.setValue(model.getSong().getName());
        this.songAdditional.setValue(buildAdditional(model.getSong()));
        this.isSelected.setValue(Boolean.valueOf(model.isSelected()));
        this.showSel.setValue(Boolean.valueOf(model.isShowSelect()));
        this.showCollect.setValue(Boolean.valueOf(model.isShowCollect()));
        this.startWave.setValue(Boolean.valueOf(isSongPlaying(model.getSong())));
        this.isFree.setValue(Boolean.valueOf(model.isFree()));
        bindSongInfoColors(model.getSong());
        this.labelList.setValue(buildSongLabel(model));
        boolean canPlay = model.getSong().canInvokePlayer() || SongExtraKt.isSupportNAPlay(model.getSong());
        this.musicTag.setValue(AppRuntime.getAppContext().getString(canPlay ? R.string.search_music_tag_na : R.string.search_music_tag_net));
        this.musicTagBgRes.setValue(Integer.valueOf(canPlay ? R.drawable.list_music_na_tag_bg : R.drawable.list_music_net_tag_bg));
    }

    private List<Label> buildSongLabel(SongData data) {
        Label label = (Label) CollectionUtils.getFirst(data.getSong().getLabels());
        if (label == null) {
            return null;
        }
        List<Label> labels = new ArrayList<>();
        labels.add(label);
        return labels;
    }

    private void bindSongInfoColors(ISong song) {
        boolean isActiveSong = isSongSelected(song);
        int nameColorRes = isActiveSong ? com.baidu.android.common.ui.style.R.color.GC7 : com.baidu.android.common.ui.style.R.color.GC1;
        int additionalColorRes = isActiveSong ? com.baidu.android.common.ui.style.R.color.GC7 : com.baidu.android.common.ui.style.R.color.GC4;
        this.songNameColor.setValue(Integer.valueOf(nameColorRes));
        this.songAdditionalColor.setValue(Integer.valueOf(additionalColorRes));
        this.showWave.setValue(Boolean.valueOf(isActiveSong));
    }

    private String buildAdditional(ISong song) {
        StringBuilder authors = new StringBuilder();
        for (String author : song.getAuthors()) {
            authors.append(author).append("/");
        }
        if (authors.length() > 0) {
            authors.deleteCharAt(authors.length() - 1);
        }
        if (!TextUtils.isEmpty(song.getAlbumInfo().getName())) {
            authors.append(" - ").append(song.getAlbumInfo().getName());
        }
        return authors.toString();
    }

    public void collectSong() {
        SongData data = (SongData) getModel();
        if (data != null && Boolean.TRUE.equals(this.isFree.getValue())) {
            BdEventBus.Companion.getDefault().post(new SongCollectEvent(data.getToken(), data.getSong()));
        }
    }

    private boolean isSongPlaying(ISong song) {
        return song.equals(PlaybackRepo.INSTANCE.getPlayingSong()) && PlaybackRepo.INSTANCE.isPlaying();
    }

    private boolean isSongSelected(ISong song) {
        return song.equals(PlaybackRepo.INSTANCE.getPlayingSong());
    }
}
