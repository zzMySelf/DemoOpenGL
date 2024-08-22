package com.baidu.searchbox.ioc;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.ad.uimodule.IAdEnhanceMiniPopViewFactory;
import com.baidu.searchbox.ad.uimodule.video.IEnhanceMiniPopView;
import com.baidu.searchbox.view.video.AdEnhanceMiniPopView;

public class AdEnhanceMiniPopViewFactoryImpl implements IAdEnhanceMiniPopViewFactory {
    public IEnhanceMiniPopView<View> newInstance(Context context, ViewGroup container) {
        return new AdEnhanceMiniPopView(context, container);
    }
}
