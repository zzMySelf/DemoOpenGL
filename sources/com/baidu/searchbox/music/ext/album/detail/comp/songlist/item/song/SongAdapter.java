package com.baidu.searchbox.music.ext.album.detail.comp.songlist.item.song;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.searchbox.music.ext.R;
import com.baidu.searchbox.nacomp.recycler.base.item.ItemAdapter;
import com.baidu.searchbox.nacomp.util.UniqueId;

public class SongAdapter extends ItemAdapter<SongData, SongComp> {
    public SongAdapter(LifecycleOwner owner) {
        super(owner);
    }

    public SongComp onCreateViewHolder(ViewGroup parent) {
        return new SongComp(getLifecycleOwner(), LayoutInflater.from(parent.getContext()).inflate(R.layout.search_music_album_song, parent, false));
    }

    public UniqueId getType() {
        return SongData.TYPE;
    }
}
