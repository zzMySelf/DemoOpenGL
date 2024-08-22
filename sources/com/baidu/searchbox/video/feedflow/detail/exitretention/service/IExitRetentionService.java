package com.baidu.searchbox.video.feedflow.detail.exitretention.service;

import com.baidu.searchbox.feed.detail.arch.api.IService;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/exitretention/service/IExitRetentionService;", "Lcom/baidu/searchbox/feed/detail/arch/api/IService;", "isRetentionPanelHasShowed", "", "needIntercept", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IExitRetentionService.kt */
public interface IExitRetentionService extends IService {
    boolean isRetentionPanelHasShowed();

    boolean needIntercept();
}
