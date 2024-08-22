package com.baidu.searchbox.live.imp;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.feed.controller.FeedLinkageManager;
import com.baidu.searchbox.feed.controller.ILinkageOperation;
import com.baidu.searchbox.feed.model.LinkageData;
import com.baidu.searchbox.follow.FollowManager;
import com.baidu.searchbox.live.follow.LiveFollowHelper;
import com.baidu.searchbox.live.interfaces.service.AccountManagerService;
import com.baidu.searchbox.live.interfaces.service.FollowStatusService;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R#\u0010\n\u001a\n \u0005*\u0004\u0018\u00010\u000b0\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/live/imp/FeedLinkageServiceImpl;", "Lcom/baidu/searchbox/live/interfaces/service/FollowStatusService;", "()V", "accountManager", "Lcom/baidu/searchbox/live/interfaces/service/AccountManagerService;", "kotlin.jvm.PlatformType", "getAccountManager", "()Lcom/baidu/searchbox/live/interfaces/service/AccountManagerService;", "accountManager$delegate", "Lkotlin/Lazy;", "followManager", "Lcom/baidu/searchbox/follow/FollowManager;", "getFollowManager", "()Lcom/baidu/searchbox/follow/FollowManager;", "followManager$delegate", "saveFollowStatus", "", "isFollow", "", "id", "", "type", "lib-feed-live_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedLinkageServiceImpl.kt */
public final class FeedLinkageServiceImpl implements FollowStatusService {
    private final Lazy accountManager$delegate = LazyKt.lazy(FeedLinkageServiceImpl$accountManager$2.INSTANCE);
    private final Lazy followManager$delegate = LazyKt.lazy(FeedLinkageServiceImpl$followManager$2.INSTANCE);

    private final FollowManager getFollowManager() {
        return (FollowManager) this.followManager$delegate.getValue();
    }

    private final AccountManagerService getAccountManager() {
        return (AccountManagerService) this.accountManager$delegate.getValue();
    }

    public void saveFollowStatus(boolean isFollow, String id, String type) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        if ("uid".equals(type)) {
            getFollowManager().postFollowStatus(AppRuntime.getAppContext(), type, getAccountManager().getSocialEncryption(id, "baiduuid_"), isFollow);
            return;
        }
        LinkageData linkageData = new LinkageData();
        linkageData.type = "follow";
        linkageData.status = isFollow ? "1" : "0";
        HashMap ext = new HashMap(2);
        ext.put("third_id", id);
        ext.put(ILinkageOperation.FOLLOW_INFO_TYPE, type);
        linkageData.ext = ext;
        linkageData.isUsed = false;
        FeedLinkageManager.getInstance("feed").addLinkage(linkageData);
        getFollowManager().postFollowStatus(AppRuntime.getAppContext(), type, id, isFollow);
        LiveFollowHelper.isFromPluginChange = true;
    }
}
