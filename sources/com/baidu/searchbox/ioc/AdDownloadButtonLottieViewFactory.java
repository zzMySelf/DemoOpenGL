package com.baidu.searchbox.ioc;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.ad.IAdDownloadButtonLottieViewFactory;
import com.baidu.searchbox.ad.download.IDownloadView;
import com.baidu.searchbox.view.AdDownloadButtonLottieView;

public class AdDownloadButtonLottieViewFactory implements IAdDownloadButtonLottieViewFactory {
    public IDownloadView<View> newInstance(Context context, float btnRadius) {
        return new AdDownloadButtonLottieView(context, btnRadius);
    }
}
