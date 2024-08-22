package com.baidu.searchbox.bdprecyclebin.face;

import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\fJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/bdprecyclebin/face/IRecycleBinRegularClearHandler;", "", "clearRecords", "", "daysRetain", "", "callback", "Lcom/baidu/searchbox/bdprecyclebin/face/IRecycleBinRegularClearHandler$IRecordsRegularClearCallback;", "getBusinessType", "", "isNeedLogin", "", "IRecordsRegularClearCallback", "lib-bdprecyclebin-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IRecycleBinRegularClearHandler.kt */
public interface IRecycleBinRegularClearHandler {

    @StableApi
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/bdprecyclebin/face/IRecycleBinRegularClearHandler$IRecordsRegularClearCallback;", "", "completion", "", "businessName", "", "clearRegularResult", "", "lib-bdprecyclebin-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IRecycleBinRegularClearHandler.kt */
    public interface IRecordsRegularClearCallback {
        void completion(String str, boolean z);
    }

    void clearRecords(int i2, IRecordsRegularClearCallback iRecordsRegularClearCallback);

    String getBusinessType();

    boolean isNeedLogin();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IRecycleBinRegularClearHandler.kt */
    public static final class DefaultImpls {
        public static boolean isNeedLogin(IRecycleBinRegularClearHandler iRecycleBinRegularClearHandler) {
            return false;
        }
    }
}
