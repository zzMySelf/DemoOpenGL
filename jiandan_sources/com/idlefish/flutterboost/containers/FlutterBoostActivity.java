package com.idlefish.flutterboost.containers;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.idlefish.flutterboost.FlutterBoost;
import fe.p036switch.qw.c;
import fe.p036switch.qw.h;
import fe.p036switch.qw.k;
import fe.p036switch.qw.l.ad;
import fe.p036switch.qw.l.de;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import io.flutter.embedding.android.FlutterTextureView;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.RenderMode;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.plugin.platform.PlatformPlugin;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FlutterBoostActivity extends FlutterActivity implements FlutterViewContainer {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final boolean DEBUG = false;
    public static final String TAG = "FlutterBoostActivity";
    public FlutterView flutterView;
    public boolean isAttached = false;
    public PlatformPlugin platformPlugin;
    public LifecycleStage stage;
    public final de textureHooker = new de();
    public final String who = UUID.randomUUID().toString();

    static {
        Class<FlutterBoostActivity> cls = FlutterBoostActivity.class;
    }

    private void performAttach() {
        if (!this.isAttached) {
            getFlutterEngine().getActivityControlSurface().attachToActivity(this.delegate, getLifecycle());
            if (this.platformPlugin == null) {
                this.platformPlugin = new PlatformPlugin(getActivity(), getFlutterEngine().getPlatformChannel());
            }
            c.qw(this.flutterView);
            this.flutterView.attachToFlutterEngine(getFlutterEngine());
            this.isAttached = true;
        }
    }

    private void performDetach() {
        if (this.isAttached) {
            getFlutterEngine().getActivityControlSurface().detachFromActivity();
            releasePlatformChannel();
            c.qw(this.flutterView);
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

    private void setIsFlutterUiDisplayed(boolean z) {
        try {
            FlutterRenderer renderer = getFlutterEngine().getRenderer();
            Field declaredField = FlutterRenderer.class.getDeclaredField("isDisplayingFlutterUi");
            declaredField.setAccessible(true);
            declaredField.setBoolean(renderer, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void detachFromEngineIfNeeded() {
        performDetach();
    }

    public void detachFromFlutterEngine() {
    }

    public void finishContainer(Map<String, Object> map) {
        if (map != null && map.size() > 0) {
            Intent intent = new Intent();
            intent.putExtra("ActivityResult", new HashMap(map));
            if (intent.getExtras() == null) {
                intent.putExtras(new Bundle());
            }
            intent.putExtras(k.qw(map));
            setResult(-1, intent);
        }
        finish();
    }

    public String getCachedEngineId() {
        return "flutter_boost_default_engine";
    }

    public Activity getContextActivity() {
        return this;
    }

    public RenderMode getRenderMode() {
        return RenderMode.texture;
    }

    public String getUniqueId() {
        if (!getIntent().hasExtra("unique_id")) {
            return this.who;
        }
        return getIntent().getStringExtra("unique_id");
    }

    public String getUrl() {
        if (getIntent().hasExtra("url")) {
            return getIntent().getStringExtra("url");
        }
        throw new RuntimeException("Oops! The activity url are *MISSED*! You should override the |getUrl|, or set url via CachedEngineIntentBuilder.");
    }

    public Map<String, Object> getUrlParams() {
        return (HashMap) getIntent().getSerializableExtra("url_param");
    }

    public boolean isOpaque() {
        return getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque;
    }

    public boolean isPausing() {
        LifecycleStage lifecycleStage = this.stage;
        return (lifecycleStage == LifecycleStage.ON_PAUSE || lifecycleStage == LifecycleStage.ON_STOP) && !isFinishing();
    }

    public void onBackPressed() {
        FlutterBoost.yj().th().nn();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.stage = LifecycleStage.ON_CREATE;
        FlutterView de2 = h.de(getWindow().getDecorView());
        this.flutterView = de2;
        de2.detachFromFlutterEngine();
        FlutterBoost.yj().th().qqq(this);
    }

    public void onDestroy() {
        FlutterEngine flutterEngine = getFlutterEngine();
        super.onDestroy();
        this.stage = LifecycleStage.ON_DESTROY;
        this.textureHooker.fe();
        flutterEngine.getLifecycleChannel().appIsResumed();
        FlutterBoost.yj().th().eee(this);
    }

    public void onFlutterTextureViewCreated(FlutterTextureView flutterTextureView) {
        super.onFlutterTextureViewCreated(flutterTextureView);
        this.textureHooker.de(flutterTextureView);
    }

    public void onPause() {
        super.onPause();
        FlutterViewContainer rg2 = ad.yj().rg();
        if (Build.VERSION.SDK_INT != 29 || rg2 == null || rg2 == this || rg2.isOpaque() || !rg2.isPausing()) {
            this.stage = LifecycleStage.ON_PAUSE;
            FlutterBoost.yj().th().rrr(this);
            getFlutterEngine().getLifecycleChannel().appIsResumed();
            setIsFlutterUiDisplayed(false);
        }
    }

    public void onResume() {
        super.onResume();
        ad yj2 = ad.yj();
        if (Build.VERSION.SDK_INT == 29) {
            FlutterViewContainer rg2 = yj2.rg();
            if (yj2.uk(this) && rg2 != null && rg2 != this && !rg2.isOpaque() && rg2.isPausing()) {
                return;
            }
        }
        this.stage = LifecycleStage.ON_RESUME;
        FlutterViewContainer th2 = yj2.th();
        if (!(th2 == null || th2 == this)) {
            th2.detachFromEngineIfNeeded();
        }
        performAttach();
        this.textureHooker.rg();
        FlutterBoost.yj().th().aaa(this);
        getFlutterEngine().getLifecycleChannel().appIsResumed();
        c.qw(this.platformPlugin);
        this.platformPlugin.updateSystemUiOverlays();
    }

    public void onStart() {
        super.onStart();
        this.stage = LifecycleStage.ON_START;
    }

    public void onStop() {
        super.onStop();
        this.stage = LifecycleStage.ON_STOP;
        getFlutterEngine().getLifecycleChannel().appIsResumed();
    }

    public void onUserLeaveHint() {
        super.onUserLeaveHint();
    }

    public PlatformPlugin providePlatformPlugin(Activity activity, FlutterEngine flutterEngine) {
        return null;
    }

    public boolean shouldAttachEngineToActivity() {
        return false;
    }

    public boolean shouldDestroyEngineWithHost() {
        return false;
    }

    public boolean shouldRestoreAndSaveState() {
        if (getIntent().hasExtra("enable_state_restoration")) {
            return getIntent().getBooleanExtra("enable_state_restoration", false);
        }
        return true;
    }
}
