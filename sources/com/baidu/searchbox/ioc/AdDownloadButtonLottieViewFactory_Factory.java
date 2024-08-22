package com.baidu.searchbox.ioc;

public class AdDownloadButtonLottieViewFactory_Factory {
    private static volatile AdDownloadButtonLottieViewFactory instance;

    private AdDownloadButtonLottieViewFactory_Factory() {
    }

    public static synchronized AdDownloadButtonLottieViewFactory get() {
        AdDownloadButtonLottieViewFactory adDownloadButtonLottieViewFactory;
        synchronized (AdDownloadButtonLottieViewFactory_Factory.class) {
            if (instance == null) {
                instance = new AdDownloadButtonLottieViewFactory();
            }
            adDownloadButtonLottieViewFactory = instance;
        }
        return adDownloadButtonLottieViewFactory;
    }
}
