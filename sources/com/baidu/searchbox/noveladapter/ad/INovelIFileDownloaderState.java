package com.baidu.searchbox.noveladapter.ad;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.ad.download.ioc.IFileDownloader;

public enum INovelIFileDownloaderState implements NoProGuard {
    NOT_START,
    DOWNLOADING,
    DOWNLOAD_PAUSED,
    DOWNLOADED,
    DOWNLOAD_FAILED;

    /* renamed from: com.baidu.searchbox.noveladapter.ad.INovelIFileDownloaderState$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ad$download$ioc$IFileDownloader$STATE = null;

        static {
            int[] iArr = new int[IFileDownloader.STATE.values().length];
            $SwitchMap$com$baidu$searchbox$ad$download$ioc$IFileDownloader$STATE = iArr;
            try {
                iArr[IFileDownloader.STATE.NOT_START.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ad$download$ioc$IFileDownloader$STATE[IFileDownloader.STATE.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ad$download$ioc$IFileDownloader$STATE[IFileDownloader.STATE.DOWNLOAD_PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ad$download$ioc$IFileDownloader$STATE[IFileDownloader.STATE.DOWNLOADED.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ad$download$ioc$IFileDownloader$STATE[IFileDownloader.STATE.DOWNLOAD_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public static INovelIFileDownloaderState convertfrom(IFileDownloader.STATE state) {
        INovelIFileDownloaderState novelStatus = NOT_START;
        switch (AnonymousClass1.$SwitchMap$com$baidu$searchbox$ad$download$ioc$IFileDownloader$STATE[state.ordinal()]) {
            case 1:
                return NOT_START;
            case 2:
                return DOWNLOADING;
            case 3:
                return DOWNLOAD_PAUSED;
            case 4:
                return DOWNLOADED;
            case 5:
                return DOWNLOAD_FAILED;
            default:
                return novelStatus;
        }
    }
}
