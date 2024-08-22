package com.baidu.searchbox.feed.h5.page;

import com.baidu.searchbox.feed.log.OnLineLog;

public class PageTrack {
    private PageStatus mStatus = PageStatus.STATUS_OTHER;
    public int pageResponseCode = -1;

    public synchronized void urlNotValid() {
        this.mStatus = PageStatus.URL_ILLEGAL;
    }

    public synchronized void requestPageStarted() {
        if (this.mStatus != PageStatus.URL_ILLEGAL) {
            this.mStatus = PageStatus.REQUEST_ING;
        }
    }

    public synchronized void requestPageInterrupted() {
        if (this.mStatus != PageStatus.URL_ILLEGAL) {
            this.mStatus = PageStatus.REQUEST_INTERRUPTED;
        }
    }

    public synchronized void requestPageError(int errorCode) {
        if (this.mStatus != PageStatus.URL_ILLEGAL) {
            if (this.mStatus != PageStatus.HYBRID_TPL_NOT_FOUND) {
                this.mStatus = PageStatus.REQUEST_ERROR;
                this.pageResponseCode = errorCode;
            }
        }
    }

    public synchronized void requestPageSuccess() {
        this.mStatus = PageStatus.REQUEST_SUCCESS;
    }

    public synchronized void hybridTplFindFail() {
        this.mStatus = PageStatus.HYBRID_TPL_NOT_FOUND;
    }

    public synchronized void noHtmlCache() {
    }

    public synchronized void waitPrefetchIng300ms() {
        this.mStatus = PageStatus.WAITING_PREFETCH;
    }

    public synchronized void cacheFileVerifyFail() {
        this.mStatus = PageStatus.STATUS_OTHER;
    }

    public synchronized void specialDetermine(PageStatus status) {
        if (status != null) {
            this.mStatus = status;
        }
    }

    public String getPageStatusValue() {
        PageStatus pageStatus = this.mStatus;
        if (pageStatus == null) {
            return PageStatus.STATUS_OTHER.value;
        }
        return pageStatus.value;
    }

    public String getPageResponseCode() {
        int i2 = this.pageResponseCode;
        if (i2 < 0) {
            return null;
        }
        return String.valueOf(i2);
    }

    public enum PageStatus {
        STATUS_OTHER("100_0"),
        URL_ILLEGAL("100_1"),
        REQUEST_ING("100_2"),
        REQUEST_SUCCESS("100_3"),
        HYBRID_TPL_NOT_FOUND("100_4"),
        WAITING_PREFETCH("100_5"),
        REQUEST_INTERRUPTED("100_6"),
        FE_ERROR("200_1"),
        KERNEL_ERROR("200_2"),
        REQUEST_ERROR("200_3");
        
        public String value;

        private PageStatus(String type) {
            this.value = type;
        }
    }

    public static void log(String message) {
        OnLineLog.get(OnLineLog.TAG_DETAIL).d("HybridTrack :" + message);
    }
}
