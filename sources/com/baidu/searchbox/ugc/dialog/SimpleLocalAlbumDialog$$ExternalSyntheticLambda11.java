package com.baidu.searchbox.ugc.dialog;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.searchbox.ugc.view.LocalAlbumRootView;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SimpleLocalAlbumDialog$$ExternalSyntheticLambda11 implements View.OnTouchListener {
    public final /* synthetic */ SimpleLocalAlbumDialog f$0;
    public final /* synthetic */ LocalAlbumRootView f$1;

    public /* synthetic */ SimpleLocalAlbumDialog$$ExternalSyntheticLambda11(SimpleLocalAlbumDialog simpleLocalAlbumDialog, LocalAlbumRootView localAlbumRootView) {
        this.f$0 = simpleLocalAlbumDialog;
        this.f$1 = localAlbumRootView;
    }

    public final boolean onTouch(View view2, MotionEvent motionEvent) {
        return SimpleLocalAlbumDialog.m4423setRootViewTouchEvent$lambda12$lambda11(this.f$0, this.f$1, view2, motionEvent);
    }
}
