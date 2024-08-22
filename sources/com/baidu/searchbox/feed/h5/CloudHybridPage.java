package com.baidu.searchbox.feed.h5;

import android.os.Message;
import android.text.TextUtils;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.feed.h5.IH5Context;
import com.baidu.searchbox.feed.h5.config.HybridPageConfig;
import com.baidu.searchbox.feed.h5.interceptor.AbsCacheInterceptor;
import com.baidu.searchbox.feed.h5.interceptor.WebResourceCache;
import com.baidu.searchbox.feed.h5.page.AbsPage;
import com.baidu.searchbox.feed.h5.page.PageTrack;
import com.baidu.searchbox.feed.h5.template.TplResMapper;
import com.baidu.searchbox.feed.h5.utils.HybridCacheUtils;
import com.baidu.searchbox.feed.h5.utils.HybridUtils;
import com.baidu.searchbox.prefetch.PreFetcher;
import com.baidu.searchbox.prefetch.config.PrefetchTaskType;
import com.baidu.searchbox.prefetch.tasks.AbstractPrefetch;
import com.baidu.webkit.sdk.WebResourceResponse;
import java.io.File;
import java.io.PipedOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CloudHybridPage extends AbsPage {
    /* access modifiers changed from: private */
    public String mPendingClientCoreFilePath;

    CloudHybridPage(HybridData hybridData, HybridPageConfig pageConfig) {
        super(hybridData, pageConfig);
    }

    /* access modifiers changed from: protected */
    public void initPageUrl() {
        this.pageUrl = this.mHybridData.getCHUrl();
    }

    /* access modifiers changed from: protected */
    public void initDefPageConfig() {
        this.pageConfig = new HybridPageConfig.Builder().setCacheInterceptor(new CloudHybridCacheInterceptor(this.mHybridData)).build();
    }

    /* access modifiers changed from: protected */
    public void handleLoadCache(String cacheData) {
        Message msg = this.mMainHandler.obtainMessage(1);
        if (TextUtils.isEmpty(cacheData)) {
            msg.arg1 = 1;
            msg.obj = this.pageUrl;
            PageTrack.log("cache query__No cache, send message loadUrl, pageUrl is : " + this.pageUrl);
        } else {
            String cacheData2 = HybridUtils.buildCloudHybridHtml(cacheData, this.mHybridData.getCHReplacementMap());
            if (TextUtils.isEmpty(this.pageUrl)) {
                this.pageUrl = generateFilePath(cacheData2);
            }
            msg.arg1 = 2;
            msg.obj = cacheData2;
            PageTrack.log("cache query__Cache exists, send message loadData, pageUrl is : " + this.pageUrl);
        }
        this.mMainHandler.sendMessageAtFrontOfQueue(msg);
    }

    private String generateFilePath(String html) {
        if (TextUtils.isEmpty(html)) {
            return "";
        }
        String filePath = HybridUtils.generatePrefetchFileUrl(this.pageId, html);
        if (!TextUtils.isEmpty(filePath)) {
            this.mPendingClientCoreFilePath = filePath;
            this.pageUrl = "file://" + filePath;
        }
        return this.pageUrl;
    }

    /* access modifiers changed from: protected */
    public void clearPageData() {
        super.clearPageData();
        if (!TextUtils.isEmpty(this.mPendingClientCoreFilePath)) {
            ExecutorUtilsExt.postOnElastic(new Runnable() {
                public void run() {
                    if (!TextUtils.isEmpty(CloudHybridPage.this.mPendingClientCoreFilePath)) {
                        try {
                            FileUtils.deleteFile(new File(CloudHybridPage.this.mPendingClientCoreFilePath));
                            String unused = CloudHybridPage.this.mPendingClientCoreFilePath = null;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }, "delPendingFile", 2);
        }
    }

    /* access modifiers changed from: protected */
    public WebResourceResponse onRequestResource(String urlStr, List<? super PipedOutputStream> streamContainer) {
        return WebResourceCache.getWebResponse(urlStr, this.pageId, streamContainer, (TplResMapper) null);
    }

    private static class CloudHybridCacheInterceptor extends AbsCacheInterceptor {
        public static final String TAG = "hybrid_sdk_CloudHybridCacheInterceptor :";
        private final HybridData mData;

        public CloudHybridCacheInterceptor(HybridData data) {
            this.mData = data;
        }

        /* access modifiers changed from: protected */
        public String internalGetCache(AbsPage absPage) {
            if (!(absPage instanceof CloudHybridPage)) {
                return null;
            }
            CloudHybridPage page = (CloudHybridPage) absPage;
            long start = System.currentTimeMillis();
            AbstractPrefetch task = PreFetcher.getInstance().queryTask(page.pageId, PrefetchTaskType.TYPE_HTML);
            if (task != null) {
                PageTrack.log("hybrid_sdk_CloudHybridCacheInterceptor :The content is being preFetched...Waiting for the data ");
                try {
                    page.pageTrack.waitPrefetchIng300ms();
                    task.get(300, TimeUnit.MILLISECONDS);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                PageTrack.log("hybrid_sdk_CloudHybridCacheInterceptor :waitPrefetch cost:" + (System.currentTimeMillis() - start));
            }
            String htmlString = HybridCacheUtils.getHybridCache(HybridUtils.makeCacheId(page.pageId, HybridConstants.RES_HTML_SUFFIX));
            PageTrack.log("hybrid_sdk_CloudHybridCacheInterceptor :findCache cost:" + (System.currentTimeMillis() - start) + " hasCache:" + (!TextUtils.isEmpty(htmlString)));
            if (HybridCacheUtils.verifyData(htmlString)) {
                return htmlString;
            }
            IH5Context.Impl.get().meetUnexpectedCHCache(page.pageId, this.mData.getFrameSource(), this.mData.getSubFrameSource());
            HybridCacheUtils.removeCacheSync(HybridUtils.makeCacheId(page.pageId, HybridConstants.RES_HTML_SUFFIX));
            page.pageTrack.cacheFileVerifyFail();
            return null;
        }
    }
}
