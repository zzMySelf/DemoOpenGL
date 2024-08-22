package com.baidu.livesdk.sdk.im;

import android.content.Context;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.IConnectListener;
import com.baidu.android.imsdk.account.ILoginListener;
import com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.livesdk.api.im.ConnectListener;
import com.baidu.livesdk.api.im.FetchMsgByIdListener;
import com.baidu.livesdk.api.im.IMConnectParams;
import com.baidu.livesdk.api.im.IMConversation;
import com.baidu.livesdk.api.im.IMManager;
import com.baidu.livesdk.api.im.LoginListener;
import com.baidu.livesdk.api.im.LogoutListener;
import java.util.ArrayList;

public class BDIMManager implements IMManager {
    private Context mContext;

    public BDIMManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void init(long appId, int env, String cuid) {
        BIMManager.init(this.mContext, appId, env, cuid);
    }

    public void produceLine(IMConnectParams params) {
        BIMManager.setProductLine(this.mContext, params.getPl(), params.getVersionName());
    }

    public IMConversation build(Context context, String castId, String url, boolean isReliable) {
        return new BDIMConversation(context, BIMManager.getConversation(this.mContext, castId, isReliable, BIMManager.CATEGORY.STUDIO, url, 2));
    }

    public void login(String uid, String accessToken, int loginType, String from, String cfrom, final LoginListener listener) {
        BIMManager.login(uid, accessToken, loginType, from, cfrom, new ILoginListener() {
            public void onLoginResult(int i2, String s) {
                LoginListener loginListener = listener;
                if (loginListener != null) {
                    loginListener.onLoginResult(i2, s);
                }
            }

            public void onLogoutResult(int i2, String s, int i1) {
            }
        });
    }

    public void logout(final LogoutListener listener) {
        BIMManager.logout(new ILoginListener() {
            public void onLoginResult(int i2, String s) {
            }

            public void onLogoutResult(int i2, String s, int i1) {
                LogoutListener logoutListener = listener;
                if (logoutListener != null) {
                    logoutListener.onLogoutResult(i2, s, i1);
                }
            }
        });
    }

    public void registerConnectListener(final ConnectListener listener) {
        BIMManager.registerConnectListener(new IConnectListener() {
            public void onResult(int i2) {
                ConnectListener connectListener = listener;
                if (connectListener != null) {
                    connectListener.onResult(i2);
                }
            }
        });
    }

    public void unregisterConnectListener() {
        BIMManager.unregisterConnectListener();
    }

    public void tryConnection() {
        BIMManager.tryConnection(this.mContext);
    }

    public void fetchMsgByMsgId(Context context, int category, long contacter, long begigmsgid, long endmsgid, int count, int reason, FetchMsgByIdListener listener) {
        final FetchMsgByIdListener fetchMsgByIdListener = listener;
        BIMManager.fetchMsgByMsgid(context, category, contacter, begigmsgid, endmsgid, count, reason, new IFetchMsgByIdListener() {
            public void onFetchMsgByIdResult(int i2, String s, String s1, int i1, long l, long l1, long l2, int i22, int i3, long l3, ArrayList<ChatMsg> arrayList) {
                if (fetchMsgByIdListener != null) {
                    ArrayList<Object> command = new ArrayList<>();
                    command.addAll(arrayList);
                    fetchMsgByIdListener.onFetchMsgByIdResult(i2, s, s1, i1, l, l1, l2, i22, i3, l3, command);
                }
            }
        });
    }

    public void fetchMsgRequest(Context context, long appid, long myuk, int category, long contacter, long begigmsgid, long endmsgid, int count, int triggerreason, FetchMsgByIdListener listener) {
        final FetchMsgByIdListener fetchMsgByIdListener = listener;
        BIMManager.fetchMsgRequest(context, appid, myuk, category, contacter, begigmsgid, endmsgid, count, triggerreason, new IFetchMsgByIdListener() {
            public void onFetchMsgByIdResult(int i2, String s, String s1, int i1, long l, long l1, long l2, int i22, int i3, long l3, ArrayList<ChatMsg> arrayList) {
                if (fetchMsgByIdListener != null) {
                    ArrayList<Object> command = new ArrayList<>();
                    command.addAll(arrayList);
                    fetchMsgByIdListener.onFetchMsgByIdResult(i2, s, s1, i1, l, l1, l2, i22, i3, l3, command);
                }
            }
        });
    }
}
