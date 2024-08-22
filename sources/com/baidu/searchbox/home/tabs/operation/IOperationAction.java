package com.baidu.searchbox.home.tabs.operation;

import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0005H&J\u001c\u0010\r\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/home/tabs/operation/IOperationAction;", "", "canShowTabOperation", "", "id", "", "getType", "onTabChanged", "", "tabId", "onTabClick", "tabType", "onTabClickBefore", "onTabOperationDismiss", "ext", "onTabOperationShow", "lib-home-tab-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IOperationAction.kt */
public interface IOperationAction {
    boolean canShowTabOperation(String str);

    String getType();

    void onTabChanged(String str);

    void onTabClick(String str);

    void onTabClickBefore(String str);

    void onTabOperationDismiss(String str, String str2);

    void onTabOperationShow(String str, String str2);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IOperationAction.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void onTabOperationShow$default(IOperationAction iOperationAction, String str, String str2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    str2 = null;
                }
                iOperationAction.onTabOperationShow(str, str2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onTabOperationShow");
        }

        public static /* synthetic */ void onTabOperationDismiss$default(IOperationAction iOperationAction, String str, String str2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    str2 = null;
                }
                iOperationAction.onTabOperationDismiss(str, str2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onTabOperationDismiss");
        }
    }
}
