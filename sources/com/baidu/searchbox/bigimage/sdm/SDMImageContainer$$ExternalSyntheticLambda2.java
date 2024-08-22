package com.baidu.searchbox.bigimage.sdm;

import com.baidu.search.permission.StoragePermission;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SDMImageContainer$$ExternalSyntheticLambda2 implements StoragePermission.ISearchPermissionsResult {
    public final /* synthetic */ SDMImageContainer f$0;

    public /* synthetic */ SDMImageContainer$$ExternalSyntheticLambda2(SDMImageContainer sDMImageContainer) {
        this.f$0 = sDMImageContainer;
    }

    public final void onPermissionsResult(boolean z) {
        SDMImageContainer.m16556downloadImg$lambda16(this.f$0, z);
    }
}
