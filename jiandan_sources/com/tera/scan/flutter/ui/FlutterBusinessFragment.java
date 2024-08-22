package com.tera.scan.flutter.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.containers.FlutterBoostFragment;
import fe.mmm.qw.p024if.ad;
import io.flutter.embedding.android.FlutterActivity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016¨\u0006\r"}, d2 = {"Lcom/tera/scan/flutter/ui/FlutterBusinessFragment;", "Lcom/idlefish/flutterboost/containers/FlutterBoostFragment;", "()V", "isCurrentInvalid", "", "currActivity", "Landroid/app/Activity;", "isFlutterActivity", "onAttach", "", "context", "Landroid/content/Context;", "shouldAttachEngineToActivity", "flutter-core_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class FlutterBusinessFragment extends FlutterBoostFragment {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    private final boolean isCurrentInvalid(Activity activity) {
        return activity.isDestroyed() || activity.isFinishing();
    }

    private final boolean isFlutterActivity(Activity activity) {
        return (activity instanceof FlutterBusinessActivity) || (activity instanceof FlutterActivity);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i2) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i2)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ad.ad(activity.getApplication());
        }
        super.onAttach(context);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public boolean shouldAttachEngineToActivity() {
        Activity fe2 = FlutterBoost.yj().fe();
        FragmentActivity activity = getActivity();
        if (activity == null || fe2 == null || !isFlutterActivity(fe2) || !isCurrentInvalid(activity)) {
            return super.shouldAttachEngineToActivity();
        }
        return false;
    }
}
