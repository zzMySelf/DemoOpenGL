package com.baidu.searchbox.favor.view;

import com.baidu.android.app.account.utils.SoftInputHelper;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FavorFolderPanelView$$ExternalSyntheticLambda9 implements SoftInputHelper.ISoftInputChanged {
    public final /* synthetic */ Ref.IntRef f$0;
    public final /* synthetic */ FavorFolderPanelView f$1;

    public /* synthetic */ FavorFolderPanelView$$ExternalSyntheticLambda9(Ref.IntRef intRef, FavorFolderPanelView favorFolderPanelView) {
        this.f$0 = intRef;
        this.f$1 = favorFolderPanelView;
    }

    public final void onChanged(boolean z, int i2, int i3) {
        FavorFolderPanelView.m18390initEditText$lambda15(this.f$0, this.f$1, z, i2, i3);
    }
}
