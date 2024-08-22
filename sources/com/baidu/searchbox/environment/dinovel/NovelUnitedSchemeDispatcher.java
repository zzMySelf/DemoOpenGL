package com.baidu.searchbox.environment.dinovel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.environment.dinovel.pluginentrance.NovelBaseImpl;
import com.baidu.searchbox.noveladapter.abtest.NovelAbTest;
import com.baidu.searchbox.noveladapter.novelcore.INovelUnitedSchemeInvokeInterface;
import com.baidu.searchbox.noveladapter.novelruntime.NovelPluginRuntime;
import com.baidu.searchbox.noveladapter.scheme.INovelUnitedSchemeCallbackHandler;
import com.baidu.searchbox.noveladapter.scheme.warpper.NovelUnitedSchemeEntityWarpper;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class NovelUnitedSchemeDispatcher extends UnitedSchemeBaseDispatcher implements NoProGuard {
    public static final String MODULE_NOVEL = "novel";
    private static HashMap<String, Class<? extends UnitedSchemeBaseDispatcher>> sSubDispatchers = new HashMap<>();
    private NovelBaseImpl<INovelUnitedSchemeInvokeInterface> novelBaseImpl = new NovelBaseImpl<INovelUnitedSchemeInvokeInterface>() {
        /* access modifiers changed from: protected */
        public INovelUnitedSchemeInvokeInterface getCorePluginInterface() {
            return INovelUnitedSchemeInvokeInterface.Impl.get();
        }
    };

    public String getDispatcherName() {
        return "novel";
    }

    public boolean invoke(Context context, UnitedSchemeEntity entity, CallbackHandler handler) {
        NovelUnitedSchemeEntityWarpper entityWarpper = new NovelUnitedSchemeEntityWarpper(entity);
        if (this.novelBaseImpl.isNovelPluginAvailable()) {
            if (this.novelBaseImpl.corePluginInterface != null) {
                ((INovelUnitedSchemeInvokeInterface) this.novelBaseImpl.corePluginInterface).invoke(context, entityWarpper, handler == null ? null : new StaticNovelUnitedSchemeCallbackHandler(handler));
            }
            NovelPluginRuntime.downloadUpdatePackage();
            return true;
        }
        String action = entity.getPath(false);
        boolean isShowLoading = true;
        if (!NovelAbTest.isMonitorOpen(NovelAbTest.KEY_NOVEL_NEW_READER_LOAD_NOVEL_PLUGIN_SWITCH)) {
            isShowLoading = false;
        } else if (!TextUtils.isEmpty(action) && ("getShelfUpdateBookCount".equalsIgnoreCase(action) || "lastreadbook".equalsIgnoreCase(action) || "openNewUser".equalsIgnoreCase(action))) {
            isShowLoading = false;
        }
        this.novelBaseImpl.loadPluginWithLoading(new NovelUnitedSchemeDispatcher$$ExternalSyntheticLambda0(this, context, entityWarpper, handler), isShowLoading);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$invoke$0$com-baidu-searchbox-environment-dinovel-NovelUnitedSchemeDispatcher  reason: not valid java name */
    public /* synthetic */ void m18358lambda$invoke$0$combaidusearchboxenvironmentdinovelNovelUnitedSchemeDispatcher(Context context, NovelUnitedSchemeEntityWarpper entityWarpper, CallbackHandler handler) {
        if (this.novelBaseImpl.corePluginInterface != null) {
            ((INovelUnitedSchemeInvokeInterface) this.novelBaseImpl.corePluginInterface).invoke(context, entityWarpper, handler == null ? null : new StaticNovelUnitedSchemeCallbackHandler(handler));
        }
    }

    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String path) {
        return sSubDispatchers.get(path);
    }

    private static class StaticNovelUnitedSchemeCallbackHandler implements INovelUnitedSchemeCallbackHandler {
        private WeakReference<CallbackHandler> handlerRef;

        StaticNovelUnitedSchemeCallbackHandler(CallbackHandler handler) {
            this.handlerRef = new WeakReference<>(handler);
        }

        public void handleSchemeDispatchCallback(String callback, String params) {
            CallbackHandler handler;
            WeakReference<CallbackHandler> weakReference = this.handlerRef;
            if (weakReference != null && (handler = (CallbackHandler) weakReference.get()) != null) {
                handler.handleSchemeDispatchCallback(callback, params);
            }
        }

        public String getCurrentPageUrl() {
            CallbackHandler handler;
            WeakReference<CallbackHandler> weakReference = this.handlerRef;
            if (weakReference == null || (handler = (CallbackHandler) weakReference.get()) == null) {
                return null;
            }
            return handler.getCurrentPageUrl();
        }
    }
}
