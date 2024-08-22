package com.baidu.searchbox.music.ext.album.detail.comp.songlist.item.cover.album;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.searchbox.music.ext.R;
import com.baidu.searchbox.music.ext.album.detail.comp.songlist.item.cover.base.BaseCoverAdapter;
import com.baidu.searchbox.nacomp.util.UniqueId;

public class AlbumCoverAdapter extends BaseCoverAdapter<AlbumCoverData, AlbumCoverComp> {
    public AlbumCoverComp onCreateViewHolder(ViewGroup parent) {
        return new AlbumCoverComp(getLifecycleOwner(), LayoutInflater.from(parent.getContext()).inflate(R.layout.search_music_album_cover, parent, false));
    }

    public AlbumCoverAdapter(LifecycleOwner owner) {
        super(owner);
    }

    public UniqueId getType() {
        return AlbumCoverData.TYPE;
    }
}
