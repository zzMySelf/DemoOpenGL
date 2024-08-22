package com.idlefish.flutterboost.containers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.idlefish.flutterboost.FlutterBoost;
import fe.p036switch.qw.c;
import fe.p036switch.qw.h;
import fe.p036switch.qw.k;
import fe.p036switch.qw.l.de;
import io.flutter.Log;
import io.flutter.embedding.android.ExclusiveAppComponent;
import io.flutter.embedding.android.FlutterFragment;
import io.flutter.embedding.android.FlutterTextureView;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.RenderMode;
import io.flutter.embedding.android.TransparencyMode;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FlutterBoostFragment extends FlutterFragment implements FlutterViewContainer {
    public static final boolean DEBUG = false;
    public static final String TAG = "FlutterBoostFragment";
    public ad fakeAppComponent = new ad();
    public FlutterView flutterView;
    public boolean isAttached = false;
    public boolean isFinishing = false;
    public PlatformPlugin platformPlugin;
    public LifecycleStage stage;
    public final de textureHooker = new de();
    public final String who = UUID.randomUUID().toString();

    public class ad implements ExclusiveAppComponent<Activity> {
        public ad() {
        }

        public void detachFromFlutterEngine() {
        }

        /* renamed from: qw */
        public Activity getAppComponent() {
            return FlutterBoostFragment.this.getActivity();
        }
    }

    public static class qw {

        /* renamed from: ad  reason: collision with root package name */
        public boolean f6521ad = false;

        /* renamed from: de  reason: collision with root package name */
        public RenderMode f6522de = RenderMode.surface;

        /* renamed from: fe  reason: collision with root package name */
        public TransparencyMode f6523fe = TransparencyMode.opaque;
        public final Class<? extends FlutterBoostFragment> qw;

        /* renamed from: rg  reason: collision with root package name */
        public boolean f6524rg = true;

        /* renamed from: th  reason: collision with root package name */
        public String f6525th = "/";

        /* renamed from: uk  reason: collision with root package name */
        public String f6526uk;

        /* renamed from: yj  reason: collision with root package name */
        public HashMap<String, Object> f6527yj;

        public qw(Class<? extends FlutterBoostFragment> cls) {
            this.qw = cls;
        }

        public Bundle ad() {
            Bundle bundle = new Bundle();
            bundle.putString("cached_engine_id", "flutter_boost_default_engine");
            bundle.putBoolean(FlutterFragment.ARG_DESTROY_ENGINE_WITH_FRAGMENT, this.f6521ad);
            RenderMode renderMode = this.f6522de;
            if (renderMode == null) {
                renderMode = RenderMode.surface;
            }
            bundle.putString(FlutterFragment.ARG_FLUTTERVIEW_RENDER_MODE, renderMode.name());
            TransparencyMode transparencyMode = this.f6523fe;
            if (transparencyMode == null) {
                transparencyMode = TransparencyMode.transparent;
            }
            bundle.putString(FlutterFragment.ARG_FLUTTERVIEW_TRANSPARENCY_MODE, transparencyMode.name());
            bundle.putBoolean(FlutterFragment.ARG_SHOULD_ATTACH_ENGINE_TO_ACTIVITY, this.f6524rg);
            bundle.putString("url", this.f6525th);
            bundle.putSerializable("url_param", this.f6527yj);
            String str = this.f6526uk;
            if (str == null) {
                str = h.ad(this.f6525th);
            }
            bundle.putString("unique_id", str);
            return bundle;
        }

        public qw de(boolean z) {
            this.f6521ad = z;
            return this;
        }

        public qw fe(boolean z) {
            this.f6524rg = z;
            return this;
        }

        public <T extends FlutterBoostFragment> T qw() {
            try {
                T t = (FlutterBoostFragment) this.qw.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (t != null) {
                    t.setArguments(ad());
                    return t;
                }
                throw new RuntimeException("The FlutterFragment subclass sent in the constructor (" + this.qw.getCanonicalName() + ") does not match the expected return type.");
            } catch (Exception e) {
                throw new RuntimeException("Could not instantiate FlutterFragment subclass (" + this.qw.getName() + ")", e);
            }
        }

        public qw rg(TransparencyMode transparencyMode) {
            this.f6523fe = transparencyMode;
            return this;
        }

        public qw th(String str) {
            this.f6525th = str;
            return this;
        }

        public qw yj(Map<String, Object> map) {
            this.f6527yj = map instanceof HashMap ? (HashMap) map : new HashMap<>(map);
            return this;
        }
    }

    private void didFragmentHide() {
        FlutterBoost.yj().th().rrr(this);
    }

    private void didFragmentShow() {
        FlutterViewContainer th2 = fe.p036switch.qw.l.ad.yj().th();
        if (!(th2 == null || th2 == this)) {
            th2.detachFromEngineIfNeeded();
        }
        FlutterBoost.yj().th().aaa(this);
        performAttach();
        this.textureHooker.rg();
    }

    private void performAttach() {
        if (!this.isAttached) {
            getFlutterEngine().getActivityControlSurface().attachToActivity(this.fakeAppComponent, getLifecycle());
            if (this.platformPlugin == null) {
                this.platformPlugin = new PlatformPlugin(getActivity(), getFlutterEngine().getPlatformChannel());
            }
            this.flutterView.attachToFlutterEngine(getFlutterEngine());
            this.isAttached = true;
        }
    }

    private void performDetach() {
        if (this.isAttached) {
            getFlutterEngine().getActivityControlSurface().detachFromActivity();
            releasePlatformChannel();
            this.flutterView.detachFromFlutterEngine();
            this.isAttached = false;
        }
    }

    private void releasePlatformChannel() {
        PlatformPlugin platformPlugin2 = this.platformPlugin;
        if (platformPlugin2 != null) {
            platformPlugin2.destroy();
            this.platformPlugin = null;
        }
    }

    public void detachFromEngineIfNeeded() {
        performDetach();
    }

    public void detachFromFlutterEngine() {
    }

    public void finishContainer(Map<String, Object> map) {
        this.isFinishing = true;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (map != null && map.size() > 0) {
                Intent intent = new Intent();
                intent.putExtra("ActivityResult", new HashMap(map));
                if (intent.getExtras() == null) {
                    intent.putExtras(new Bundle());
                }
                intent.putExtras(k.qw(map));
                activity.setResult(-1, intent);
            }
            activity.finish();
        }
    }

    public String getCachedEngineId() {
        return "flutter_boost_default_engine";
    }

    public Activity getContextActivity() {
        return getActivity();
    }

    public RenderMode getRenderMode() {
        return RenderMode.texture;
    }

    public TransparencyMode getTransparencyMode() {
        return TransparencyMode.valueOf(getArguments().getString(FlutterFragment.ARG_FLUTTERVIEW_TRANSPARENCY_MODE, TransparencyMode.opaque.name()));
    }

    public String getUniqueId() {
        return getArguments().getString("unique_id", this.who);
    }

    public String getUrl() {
        if (getArguments().containsKey("url")) {
            return getArguments().getString("url");
        }
        throw new RuntimeException("Oops! The fragment url are *MISSED*! You should override the |getUrl|, or set url via CachedEngineFragmentBuilder.");
    }

    public Map<String, Object> getUrlParams() {
        return (HashMap) getArguments().getSerializable("url_param");
    }

    public boolean isOpaque() {
        return getTransparencyMode() == TransparencyMode.opaque;
    }

    public boolean isPausing() {
        LifecycleStage lifecycleStage = this.stage;
        return (lifecycleStage == LifecycleStage.ON_PAUSE || lifecycleStage == LifecycleStage.ON_STOP) && !this.isFinishing;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void onBackPressed() {
        FlutterBoost.yj().th().nn();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.stage = LifecycleStage.ON_CREATE;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FlutterBoost.yj().th().qqq(this);
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        FlutterView de2 = h.de(onCreateView);
        this.flutterView = de2;
        c.qw(de2);
        this.flutterView.detachFromFlutterEngine();
        return onCreateView;
    }

    public void onDestroy() {
        super.onDestroy();
        this.stage = LifecycleStage.ON_DESTROY;
        this.textureHooker.fe();
        detachFromEngineIfNeeded();
    }

    public void onDestroyView() {
        super.onDestroyView();
        FlutterBoost.yj().th().eee(this);
    }

    public void onDetach() {
        FlutterEngine flutterEngine = getFlutterEngine();
        super.onDetach();
        c.qw(flutterEngine);
        flutterEngine.getLifecycleChannel().appIsResumed();
    }

    public void onFlutterTextureViewCreated(FlutterTextureView flutterTextureView) {
        super.onFlutterTextureViewCreated(flutterTextureView);
        this.textureHooker.de(flutterTextureView);
    }

    public void onHiddenChanged(boolean z) {
        c.qw(this.flutterView);
        if (z) {
            didFragmentHide();
        } else {
            didFragmentShow();
        }
        super.onHiddenChanged(z);
    }

    public void onPause() {
        FlutterViewContainer rg2;
        super.onPause();
        if (Build.VERSION.SDK_INT != 29 || (rg2 = fe.p036switch.qw.l.ad.yj().rg()) == null || rg2 == getContextActivity() || rg2.isOpaque() || !rg2.isPausing()) {
            this.stage = LifecycleStage.ON_PAUSE;
            didFragmentHide();
            getFlutterEngine().getLifecycleChannel().appIsResumed();
            FlutterBoost.yj().de(1);
            return;
        }
        Log.w(TAG, "Skip the unexpected activity lifecycle event on Android Q. See https://issuetracker.google.com/issues/185693011 for more details.");
    }

    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT == 29) {
            fe.p036switch.qw.l.ad yj2 = fe.p036switch.qw.l.ad.yj();
            FlutterViewContainer rg2 = yj2.rg();
            if (yj2.uk(this) && rg2 != null && rg2 != getContextActivity() && !rg2.isOpaque() && rg2.isPausing()) {
                Log.w(TAG, "Skip the unexpected activity lifecycle event on Android Q. See https://issuetracker.google.com/issues/185693011 for more details.");
                return;
            }
        }
        this.stage = LifecycleStage.ON_RESUME;
        if (!isHidden()) {
            didFragmentShow();
            getFlutterEngine().getLifecycleChannel().appIsResumed();
            if (fe.p036switch.qw.l.ad.yj().fe() > 0) {
                FlutterBoost.yj().de(0);
            }
            c.qw(this.platformPlugin);
            this.platformPlugin.updateSystemUiOverlays();
        }
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
        this.stage = LifecycleStage.ON_STOP;
        c.qw(getFlutterEngine());
        getFlutterEngine().getLifecycleChannel().appIsResumed();
    }

    public void onUserLeaveHint() {
        super.onUserLeaveHint();
    }

    public PlatformPlugin providePlatformPlugin(Activity activity, FlutterEngine flutterEngine) {
        return null;
    }

    public void setUserVisibleHint(boolean z) {
        c.qw(this.flutterView);
        if (z) {
            didFragmentShow();
        } else {
            didFragmentHide();
        }
        super.setUserVisibleHint(z);
    }

    public boolean shouldDestroyEngineWithHost() {
        return false;
    }

    public boolean shouldRestoreAndSaveState() {
        if (getArguments().containsKey("enable_state_restoration")) {
            return getArguments().getBoolean("enable_state_restoration");
        }
        return true;
    }
}
