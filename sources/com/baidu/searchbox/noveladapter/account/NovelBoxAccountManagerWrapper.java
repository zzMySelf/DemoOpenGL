package com.baidu.searchbox.noveladapter.account;

import android.content.Context;
import com.baidu.common.param.UrlEncodeUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.IAccountStatusChangedListener;
import com.baidu.searchbox.account.ILoginResultListener;
import com.baidu.searchbox.account.component.AccountComponentConfig;
import com.baidu.searchbox.account.data.BoxAccount;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.account.params.LoginParams;
import com.baidu.searchbox.security.WarmTipsManager;
import com.baidu.searchbox.util.BaiduIdentityManager;
import java.util.HashSet;
import java.util.Iterator;

public class NovelBoxAccountManagerWrapper implements NoProGuard {
    public static final int BOX_GET_ACCOUNT_CACHE_MODE = 10;
    public static final int BOX_GET_ACCOUNT_FORCE_MODE = 12;
    public static final int BOX_GET_ACCOUNT_LAZY_MODE = 11;
    public static final int NO_SUPPORT_GUEST_LOGIN = 2;
    public static final String SESSION_BDUSS = "";
    public static final String SESSION_DISPLAYNAME = "";
    public static final String SESSION_NICKNAME = "";
    public static final String SESSION_PTOKEN = "";
    public static final String SESSION_UID = "";
    public static final int STATUS_CHANGE_USER = 3;
    public static final int STATUS_LOGIN = 1;
    public static final int STATUS_LOGIN_OUT = 2;
    public static final int SUPPORT_GUEST_LOGIN = 0;
    public static final int TYPE_ACCOUNT_APPEAL = 1;
    public static final int TYPE_ACCOUNT_CANCEL = 2;
    public static final int TYPE_ACCOUNT_MANAGE = 3;
    /* access modifiers changed from: private */
    public static HashSet<NovelLoginStatusChangedListener> mStatusListeners = new HashSet<>();
    private IAccountStatusChangedListener mBdLoginlistener;

    public interface NovelILoginResultListener extends NoProGuard {
        public static final int CANCELD = -2;
        public static final int FAILED = -1;
        public static final int LOGOUT = -3;
        public static final int SUCCESS = 0;

        void onResult(int i2);
    }

    public interface NovelLoginStatusChangedListener extends NoProGuard {
        void onLoginStatusChanged(int i2);
    }

    public void compileLogin(Context context, int loginMode, int supportGustLogin, boolean thirdLogin, NovelUserAccountActionItem novelUserAccountActionItem, final NovelILoginResultListener iLoginResultListener) {
        ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).login(context, new LoginParams.Builder().setLoginSrc(new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, "novel")).build(), new ILoginResultListener() {
            public void onResult(int i2) {
                NovelILoginResultListener novelILoginResultListener = iLoginResultListener;
                if (novelILoginResultListener != null) {
                    novelILoginResultListener.onResult(i2);
                }
            }
        });
    }

    public void compileLogin(Context context, int supportGustLogin, boolean thirdLogin, NovelUserAccountActionItem novelUserAccountActionItem, final NovelILoginResultListener iLoginResultListener) {
        ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).login(context, new LoginParams.Builder().setLoginSrc(new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, "novel")).build(), new ILoginResultListener() {
            public void onResult(int i2) {
                NovelILoginResultListener novelILoginResultListener = iLoginResultListener;
                if (novelILoginResultListener != null) {
                    novelILoginResultListener.onResult(i2);
                }
            }
        });
    }

    public void combineLogin(Context context, String title, String src, final NovelILoginResultListener iLoginResultListener) {
        ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).combineLogin(context, new LoginParams.Builder().setLoginMode(5).setLoginDialogTitle(title).setLoginSrc(new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, src)).setThirdLogin(true).build(), 2, new ILoginResultListener() {
            public void onResult(int resultCode) {
                NovelILoginResultListener novelILoginResultListener = iLoginResultListener;
                if (novelILoginResultListener != null) {
                    novelILoginResultListener.onResult(resultCode);
                }
            }
        });
    }

    public NovelBoxAccountWrapper getBoxAccount() {
        return new NovelBoxAccountWrapper();
    }

    public boolean isLogin(int code) {
        BoxAccountManager mLoginManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        return mLoginManager != null && mLoginManager.isLogin();
    }

    public boolean isLogin() {
        BoxAccountManager mLoginManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        return mLoginManager != null && mLoginManager.isLogin();
    }

    public void showLoginComponentDialog(Context context, String title, boolean supportGuest, final NovelILoginResultListener listener) {
        AccountComponentConfig config = AccountComponentConfig.getDefaulgParamsBuilder().setMainTitleText(title).setSupportGuest(supportGuest).build();
        BoxAccountManager accountManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        if (accountManager != null) {
            accountManager.showLoginComponentDialog(context, config, new ILoginResultListener() {
                public void onResult(int i2) {
                    listener.onResult(i2);
                }
            });
        }
    }

    public void addLoginStatusChangedListener(NovelLoginStatusChangedListener novelLoginStatusChangedListener) {
        HashSet<NovelLoginStatusChangedListener> hashSet = mStatusListeners;
        if (hashSet != null) {
            if (hashSet.size() <= 0) {
                AnonymousClass5 r1 = new IAccountStatusChangedListener() {
                    public void onLoginStatusChanged(boolean oldStatus, boolean newStatus) {
                        int status = 1;
                        if (!oldStatus && newStatus) {
                            status = 1;
                        } else if (oldStatus && !newStatus) {
                            status = 2;
                        } else if (oldStatus && newStatus) {
                            status = 3;
                        }
                        if (NovelBoxAccountManagerWrapper.mStatusListeners != null) {
                            Iterator it = NovelBoxAccountManagerWrapper.mStatusListeners.iterator();
                            while (it.hasNext()) {
                                NovelLoginStatusChangedListener statusListener = (NovelLoginStatusChangedListener) it.next();
                                if (statusListener != null) {
                                    statusListener.onLoginStatusChanged(status);
                                }
                            }
                        }
                    }
                };
                this.mBdLoginlistener = r1;
                ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).addLoginStatusChangedListener(r1);
            }
            mStatusListeners.add(novelLoginStatusChangedListener);
        }
    }

    public void removeLoginStatusChangedListener(NovelLoginStatusChangedListener novelLoginStatusChangedListener) {
        HashSet<NovelLoginStatusChangedListener> hashSet = mStatusListeners;
        if (hashSet != null) {
            hashSet.remove(novelLoginStatusChangedListener);
            if (mStatusListeners.size() <= 0 && this.mBdLoginlistener != null) {
                ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).removeLoginStatusChangedListener(this.mBdLoginlistener);
                this.mBdLoginlistener = null;
            }
        }
    }

    public boolean isGuestLogin() {
        return false;
    }

    public boolean isGuestLoginState() {
        BoxAccountManager mLoginManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        return mLoginManager != null && mLoginManager.isGuestLogin();
    }

    public void bindPhone(Context context, String loginTitle, String loginSrc, final NovelILoginResultListener listener) {
        BoxAccountManager mLoginManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        if (mLoginManager != null) {
            mLoginManager.bindPhone(context, new LoginParams.Builder().setLoginSrc(new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, loginSrc)).setNeedUserSettingForLogin(false).setLoginMode(5).setLoginDialogTitle(loginTitle).build(), new ILoginResultListener() {
                public void onResult(int resultCode) {
                    NovelILoginResultListener novelILoginResultListener = listener;
                    if (novelILoginResultListener != null) {
                        novelILoginResultListener.onResult(!NovelBoxAccountManagerWrapper.this.isGuestLoginState() ? 0 : -1);
                    }
                }
            });
        }
    }

    public String getBduss() {
        BoxAccountManager manager;
        BoxAccount account;
        if (!WarmTipsManager.isPermissionGrantedForProcess() || (manager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)) == null || (account = manager.getBoxAccount()) == null) {
            return "";
        }
        return account.getBduss();
    }

    public boolean isPermissionGrantedForProcess() {
        return WarmTipsManager.isPermissionGrantedForProcess();
    }

    public String getCuid() {
        return UrlEncodeUtils.getEncodeValue(BaiduIdentityManager.getInstance().getEnUid());
    }
}
