package com.baidu.searchbox.music.lyric.comp;

import androidx.lifecycle.Observer;
import com.baidu.searchbox.music.lyric.comp.config.LoadingConfig;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LyricComp$$ExternalSyntheticLambda11 implements Observer {
    public final /* synthetic */ LyricComp f$0;

    public /* synthetic */ LyricComp$$ExternalSyntheticLambda11(LyricComp lyricComp) {
        this.f$0 = lyricComp;
    }

    public final void onChanged(Object obj) {
        LyricComp.m1251bindLoadingConfig$lambda17(this.f$0, (LoadingConfig) obj);
    }
}
