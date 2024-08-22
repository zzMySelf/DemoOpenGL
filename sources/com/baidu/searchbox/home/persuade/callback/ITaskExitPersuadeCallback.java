package com.baidu.searchbox.home.persuade.callback;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u001c\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/home/persuade/callback/ITaskExitPersuadeCallback;", "", "onDialogClickExitApp", "", "onDialogDismiss", "onShowDialogResult", "resultCode", "", "failReason", "", "lib-home-persuade_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ITaskExitPersuadeCallback.kt */
public interface ITaskExitPersuadeCallback {
    void onDialogClickExitApp();

    void onDialogDismiss();

    void onShowDialogResult(int i2, String str);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ITaskExitPersuadeCallback.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void onShowDialogResult$default(ITaskExitPersuadeCallback iTaskExitPersuadeCallback, int i2, String str, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    str = null;
                }
                iTaskExitPersuadeCallback.onShowDialogResult(i2, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onShowDialogResult");
        }
    }
}
