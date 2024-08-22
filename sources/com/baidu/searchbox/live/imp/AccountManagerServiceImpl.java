package com.baidu.searchbox.live.imp;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.IAccountStatusChangedListener;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.account.params.LoginParams;
import com.baidu.searchbox.account.utils.SocialEncodeUtils;
import com.baidu.searchbox.live.interfaces.context.PluginContextUtil;
import com.baidu.searchbox.live.interfaces.service.AccountManagerService;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/baidu/searchbox/live/imp/AccountManagerServiceImpl;", "Lcom/baidu/searchbox/live/interfaces/service/AccountManagerService;", "()V", "accountManager", "Lcom/baidu/searchbox/account/BoxAccountManager;", "getAccountManager", "()Lcom/baidu/searchbox/account/BoxAccountManager;", "accountManager$delegate", "Lkotlin/Lazy;", "mListenerMap", "", "Lcom/baidu/searchbox/live/interfaces/service/AccountManagerService$AccountStatusChangedListener;", "Lcom/baidu/searchbox/account/IAccountStatusChangedListener;", "addLoginStatusChangedListener", "", "listener", "getAccount", "Lcom/baidu/searchbox/live/interfaces/data/UserAccount;", "getSocialDecrypt", "", "plaintext", "tag", "getSocialEncryption", "getUid", "isLogin", "", "type", "", "login", "context", "Landroid/content/Context;", "Lcom/baidu/searchbox/live/interfaces/service/AccountManagerService$LoginResultListener;", "removeLoginStatusChangedListener", "lib-feed-live_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AccountManagerServiceImpl.kt */
public final class AccountManagerServiceImpl implements AccountManagerService {
    private final Lazy accountManager$delegate = LazyKt.lazy(AccountManagerServiceImpl$accountManager$2.INSTANCE);
    private final Map<AccountManagerService.AccountStatusChangedListener, IAccountStatusChangedListener> mListenerMap = new ConcurrentHashMap();

    private final BoxAccountManager getAccountManager() {
        return (BoxAccountManager) this.accountManager$delegate.getValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r1 = r1.getBoxAccount();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.live.interfaces.data.UserAccount getAccount() {
        /*
            r7 = this;
            com.baidu.searchbox.live.interfaces.data.UserAccount r0 = new com.baidu.searchbox.live.interfaces.data.UserAccount
            r0.<init>()
            com.baidu.searchbox.account.BoxAccountManager r1 = r7.getAccountManager()
            r2 = 0
            if (r1 == 0) goto L_0x0017
            com.baidu.searchbox.account.data.BoxAccount r1 = r1.getBoxAccount()
            if (r1 == 0) goto L_0x0017
            java.lang.String r1 = r1.getNickname()
            goto L_0x0018
        L_0x0017:
            r1 = r2
        L_0x0018:
            java.lang.String r3 = ""
            if (r1 != 0) goto L_0x001d
            r1 = r3
        L_0x001d:
            com.baidu.searchbox.account.BoxAccountManager r4 = r7.getAccountManager()
            if (r4 == 0) goto L_0x002e
            com.baidu.searchbox.account.data.BoxAccount r4 = r4.getBoxAccount()
            if (r4 == 0) goto L_0x002e
            java.lang.String r4 = r4.getDisplayname()
            goto L_0x002f
        L_0x002e:
            r4 = r2
        L_0x002f:
            if (r4 != 0) goto L_0x0032
            r4 = r3
        L_0x0032:
            com.baidu.searchbox.account.BoxAccountManager r5 = r7.getAccountManager()
            if (r5 == 0) goto L_0x0043
            com.baidu.searchbox.account.data.BoxAccount r5 = r5.getBoxAccount()
            if (r5 == 0) goto L_0x0043
            java.lang.String r5 = r5.getPortrait()
            goto L_0x0044
        L_0x0043:
            r5 = r2
        L_0x0044:
            if (r5 != 0) goto L_0x0047
            r5 = r3
        L_0x0047:
            r0.setDisplayname(r4)
            r0.setNickName(r1)
            r0.setProtrait(r5)
            com.baidu.searchbox.account.BoxAccountManager r6 = r7.getAccountManager()
            if (r6 == 0) goto L_0x0064
            com.baidu.searchbox.account.data.BoxAccount r6 = r6.getBoxAccount()
            if (r6 == 0) goto L_0x0064
            java.lang.String r6 = r6.getUid()
            if (r6 != 0) goto L_0x0063
            goto L_0x0064
        L_0x0063:
            r3 = r6
        L_0x0064:
            r0.setUid(r3)
            com.baidu.searchbox.account.BoxAccountManager r3 = r7.getAccountManager()
            if (r3 == 0) goto L_0x0079
            com.baidu.searchbox.account.data.BoxAccount r3 = r3.getBoxAccount()
            if (r3 == 0) goto L_0x0079
            java.lang.String r3 = r3.getUk()
            if (r3 != 0) goto L_0x007b
        L_0x0079:
            java.lang.String r3 = "0"
        L_0x007b:
            r0.setUk(r3)
            com.baidu.searchbox.account.BoxAccountManager r3 = r7.getAccountManager()
            if (r3 == 0) goto L_0x008e
            com.baidu.searchbox.account.data.BoxAccount r3 = r3.getBoxAccount()
            if (r3 == 0) goto L_0x008e
            java.lang.String r2 = r3.getBduss()
        L_0x008e:
            r0.setBduss(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.live.imp.AccountManagerServiceImpl.getAccount():com.baidu.searchbox.live.interfaces.data.UserAccount");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getBoxAccount();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getUid() {
        /*
            r1 = this;
            com.baidu.searchbox.account.BoxAccountManager r0 = r1.getAccountManager()
            if (r0 == 0) goto L_0x0011
            com.baidu.searchbox.account.data.BoxAccount r0 = r0.getBoxAccount()
            if (r0 == 0) goto L_0x0011
            java.lang.String r0 = r0.getUid()
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            if (r0 != 0) goto L_0x0016
            java.lang.String r0 = ""
        L_0x0016:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.live.imp.AccountManagerServiceImpl.getUid():java.lang.String");
    }

    public boolean isLogin(int type) {
        BoxAccountManager accountManager = getAccountManager();
        if (accountManager != null) {
            return accountManager.isLogin(type);
        }
        return false;
    }

    public void login(Context context, AccountManagerService.LoginResultListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context realContext = PluginContextUtil.INSTANCE.getRealContext(context);
        if (realContext instanceof Activity) {
            BoxAccountManager accountManager = getAccountManager();
            if (accountManager != null) {
                accountManager.combineLogin(realContext, new LoginParams.Builder().setLoginSrc(new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, "liveshow")).setLoginMode(5).build(), 2, new AccountManagerServiceImpl$$ExternalSyntheticLambda0(listener));
                return;
            }
            return;
        }
        BoxAccountManager accountManager2 = getAccountManager();
        if (accountManager2 != null) {
            accountManager2.combineLogin(realContext, new LoginParams.Builder().setLoginSrc(new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, "liveshow")).build(), 2, new AccountManagerServiceImpl$$ExternalSyntheticLambda1(listener));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: login$lambda-0  reason: not valid java name */
    public static final void m137login$lambda0(AccountManagerService.LoginResultListener $listener, int state) {
        if ($listener != null) {
            $listener.onResult(state);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: login$lambda-1  reason: not valid java name */
    public static final void m138login$lambda1(AccountManagerService.LoginResultListener $listener, int state) {
        if ($listener != null) {
            $listener.onResult(state);
        }
    }

    public String getSocialEncryption(String plaintext, String tag) {
        Intrinsics.checkNotNullParameter(plaintext, "plaintext");
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (TextUtils.isEmpty(plaintext) || TextUtils.isEmpty(tag)) {
            return "";
        }
        String socialEncryption = SocialEncodeUtils.getSocialEncryption(plaintext, tag);
        Intrinsics.checkNotNullExpressionValue(socialEncryption, "{\n            SocialEnco…plaintext, tag)\n        }");
        return socialEncryption;
    }

    public String getSocialDecrypt(String plaintext, String tag) {
        Intrinsics.checkNotNullParameter(plaintext, "plaintext");
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (TextUtils.isEmpty(plaintext) || TextUtils.isEmpty(tag)) {
            return "";
        }
        String socialDecrypt = SocialEncodeUtils.getSocialDecrypt(plaintext, tag);
        Intrinsics.checkNotNullExpressionValue(socialDecrypt, "{\n            SocialEnco…plaintext, tag)\n        }");
        return socialDecrypt;
    }

    public void addLoginStatusChangedListener(AccountManagerService.AccountStatusChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        IAccountStatusChangedListener realListerner = new AccountManagerServiceImpl$$ExternalSyntheticLambda2(listener);
        this.mListenerMap.put(listener, realListerner);
        BoxAccountManager accountManager = getAccountManager();
        if (accountManager != null) {
            accountManager.addLoginStatusChangedListener(realListerner);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: addLoginStatusChangedListener$lambda-2  reason: not valid java name */
    public static final void m136addLoginStatusChangedListener$lambda2(AccountManagerService.AccountStatusChangedListener $listener, boolean z, boolean newStatus) {
        Intrinsics.checkNotNullParameter($listener, "$listener");
        $listener.onAccountStatusChanged(newStatus);
    }

    public void removeLoginStatusChangedListener(AccountManagerService.AccountStatusChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        IAccountStatusChangedListener realListerner = this.mListenerMap.get(listener);
        if (realListerner != null) {
            IAccountStatusChangedListener iAccountStatusChangedListener = realListerner;
            BoxAccountManager accountManager = getAccountManager();
            if (accountManager != null) {
                accountManager.removeLoginStatusChangedListener(realListerner);
            }
            IAccountStatusChangedListener remove = this.mListenerMap.remove(listener);
        }
    }
}
