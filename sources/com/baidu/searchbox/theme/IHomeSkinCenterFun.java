package com.baidu.searchbox.theme;

import android.content.Context;
import android.content.Intent;
import com.baidu.pyramid.runtime.service.ServiceReference;

public interface IHomeSkinCenterFun {
    public static final String NAME = "skincenter";
    public static final String NAME_SPACE = "baiduhome";
    public static final ServiceReference SERVICE_REFERENCE = new ServiceReference("baiduhome", NAME);

    Intent buildSkinCenterNewActivityIntent(Context context);

    void getSkinHasSetFromServer(Context context);

    String getSkinId();

    void releaseManagersInstance();
}
