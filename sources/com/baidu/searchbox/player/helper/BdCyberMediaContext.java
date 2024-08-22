package com.baidu.searchbox.player.helper;

import android.content.Context;
import com.baidu.cyberplayer.sdk.context.DuMediaContextDef;
import com.baidu.cyberplayer.sdk.context.ICyberDeviceInfo;
import com.baidu.cyberplayer.sdk.context.ICyberGlobalOptions;
import com.baidu.cyberplayer.sdk.context.ICyberMediaAbTest;
import com.baidu.cyberplayer.sdk.context.ICyberMsgHandler;
import com.baidu.cyberplayer.sdk.context.ICyberOnlineLog;
import com.baidu.cyberplayer.sdk.context.ICyberPlayConfig;
import com.baidu.cyberplayer.sdk.context.ICyberPlayServer;
import com.baidu.cyberplayer.sdk.context.ICyberStatistic;
import com.baidu.searchbox.player.iocimpl.CyberMsgHandler;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/player/helper/BdCyberMediaContext;", "Lcom/baidu/cyberplayer/sdk/context/DuMediaContextDef;", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getCtx", "()Landroid/content/Context;", "cyberPlayerServer", "Lcom/baidu/searchbox/player/helper/BdCyberMediaPlayServerImpl;", "getAbTestInterface", "Lcom/baidu/cyberplayer/sdk/context/ICyberMediaAbTest;", "getAppContext", "getCyberDeviceInfo", "Lcom/baidu/cyberplayer/sdk/context/ICyberDeviceInfo;", "getCyberGlobalOptions", "Lcom/baidu/cyberplayer/sdk/context/ICyberGlobalOptions;", "getCyberMsgHandler", "Lcom/baidu/cyberplayer/sdk/context/ICyberMsgHandler;", "getCyberOnlineLog", "Lcom/baidu/cyberplayer/sdk/context/ICyberOnlineLog;", "getCyberPlayConfig", "Lcom/baidu/cyberplayer/sdk/context/ICyberPlayConfig;", "getCyberPlayServer", "Lcom/baidu/cyberplayer/sdk/context/ICyberPlayServer;", "getCyberStatistic", "Lcom/baidu/cyberplayer/sdk/context/ICyberStatistic;", "lib-player-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BdCyberMediaContext.kt */
public final class BdCyberMediaContext extends DuMediaContextDef {
    private final Context ctx;
    private final BdCyberMediaPlayServerImpl cyberPlayerServer;

    public BdCyberMediaContext(Context ctx2) {
        this.ctx = ctx2;
        this.cyberPlayerServer = new BdCyberMediaPlayServerImpl(ctx2);
    }

    public final Context getCtx() {
        return this.ctx;
    }

    public Context getAppContext() {
        Context context = this.ctx;
        if (context != null) {
            return context.getApplicationContext();
        }
        return null;
    }

    public ICyberMediaAbTest getAbTestInterface() {
        return new BdCyberMediaAbTestImpl();
    }

    public ICyberMsgHandler getCyberMsgHandler() {
        return new CyberMsgHandler();
    }

    public ICyberGlobalOptions getCyberGlobalOptions() {
        return new CyberGlobalOptionsImpl();
    }

    public ICyberPlayConfig getCyberPlayConfig() {
        return new CyberConfigImp();
    }

    public ICyberStatistic getCyberStatistic() {
        return new BdCyberMediaStatisticImpl();
    }

    public ICyberOnlineLog getCyberOnlineLog() {
        return new BdCyberMediaOnlineLogImpl();
    }

    public ICyberPlayServer getCyberPlayServer() {
        return this.cyberPlayerServer;
    }

    public ICyberDeviceInfo getCyberDeviceInfo() {
        return new BdCyberMediaDeviceInfoImpl();
    }
}
