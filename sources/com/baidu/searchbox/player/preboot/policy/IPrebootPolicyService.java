package com.baidu.searchbox.player.preboot.policy;

import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.player.preboot.env.PrebootInfo;
import com.baidu.searchbox.player.preboot.task.AbsPrebootTask;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0019\u0010\u0006\u001a\u000e\u0012\b\u0012\u00060\bj\u0002`\t\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/player/preboot/policy/IPrebootPolicyService;", "", "deliverTask", "Lcom/baidu/searchbox/player/preboot/task/AbsPrebootTask;", "prebootInfo", "Lcom/baidu/searchbox/player/preboot/env/PrebootInfo;", "serviceFor", "", "", "Lcom/baidu/searchbox/player/env/From;", "()[Ljava/lang/String;", "preboot_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IPrebootPolicyService.kt */
public interface IPrebootPolicyService {
    AbsPrebootTask deliverTask(PrebootInfo prebootInfo);

    String[] serviceFor();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IPrebootPolicyService.kt */
    public static final class DefaultImpls {
        public static String[] serviceFor(IPrebootPolicyService iPrebootPolicyService) {
            return null;
        }
    }
}
