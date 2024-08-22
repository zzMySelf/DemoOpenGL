package com.baidu.searchbox.scene.inter.configs;

import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.permission.R;
import com.baidu.searchbox.scene.inter.PermissionSceneImpl;
import com.baidu.searchbox.scene.inter.PermissionSceneInfo;
import com.baidu.searchbox.scene.inter.utils.PermissionSceneUtilsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000\u001a\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000¨\u0006\u0004"}, d2 = {"getDefaultSceneLocationConfigs", "", "Lcom/baidu/searchbox/scene/inter/PermissionSceneInfo;", "getSceneLocationConfigs", "lib-oem-permission_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SceneLocationConfigs.kt */
public final class SceneLocationConfigsKt {
    public static final List<PermissionSceneInfo> getSceneLocationConfigs() {
        List<PermissionSceneInfo> $this$filter$iv = PermissionSceneImpl.INSTANCE.getScenePerConfigList$lib_oem_permission_release();
        if (AppConfig.isDebug()) {
            Log.d("PermissionScene", "scenePerConfigList == " + $this$filter$iv + ' ');
        }
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            PermissionSceneInfo it = (PermissionSceneInfo) element$iv$iv;
            if (Intrinsics.areEqual((Object) it.getPermission(), (Object) "location") && !PermissionSceneUtilsKt.isSpecialScene(it.getSceneID())) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    public static final List<PermissionSceneInfo> getDefaultSceneLocationConfigs() {
        ArrayList arrayList = new ArrayList();
        ArrayList $this$getDefaultSceneLocationConfigs_u24lambda_u2d1 = arrayList;
        $this$getDefaultSceneLocationConfigs_u24lambda_u2d1.add(new PermissionSceneInfo().init("location", "liulan", com.baidu.searchbox.scene.inter.PermissionSceneUtilsKt.getString(R.string.scene_liulan), com.baidu.searchbox.scene.inter.PermissionSceneUtilsKt.getString(R.string.scene_liulan_location_title), com.baidu.searchbox.scene.inter.PermissionSceneUtilsKt.getString(R.string.scene_liulan_location_description), com.baidu.searchbox.scene.inter.PermissionSceneUtilsKt.getString(R.string.scene_liulan_location_go_setting_desc), "1", "3", com.baidu.searchbox.scene.inter.PermissionSceneUtilsKt.getString(R.string.scene_liulan_location_subtitle)));
        $this$getDefaultSceneLocationConfigs_u24lambda_u2d1.add(PermissionSceneInfo.init$default(new PermissionSceneInfo(), "location", "bendi", com.baidu.searchbox.scene.inter.PermissionSceneUtilsKt.getString(R.string.scene_bendi), com.baidu.searchbox.scene.inter.PermissionSceneUtilsKt.getString(R.string.scene_bendi_location_title), com.baidu.searchbox.scene.inter.PermissionSceneUtilsKt.getString(R.string.scene_bendi_location_description), com.baidu.searchbox.scene.inter.PermissionSceneUtilsKt.getString(R.string.scene_bendi_location_go_setting_desc), "1", "3", (String) null, 256, (Object) null));
        $this$getDefaultSceneLocationConfigs_u24lambda_u2d1.add(PermissionSceneInfo.init$default(new PermissionSceneInfo(), "location", "huishenghuo", com.baidu.searchbox.scene.inter.PermissionSceneUtilsKt.getString(R.string.scene_huishenghuo), com.baidu.searchbox.scene.inter.PermissionSceneUtilsKt.getString(R.string.scene_huishenghuo_location_title), com.baidu.searchbox.scene.inter.PermissionSceneUtilsKt.getString(R.string.scene_huishenghuo_location_description), com.baidu.searchbox.scene.inter.PermissionSceneUtilsKt.getString(R.string.scene_huishenghuo_location_go_setting_desc), "1", "3", (String) null, 256, (Object) null));
        $this$getDefaultSceneLocationConfigs_u24lambda_u2d1.add(PermissionSceneInfo.init$default(new PermissionSceneInfo(), "location", "fabu", com.baidu.searchbox.scene.inter.PermissionSceneUtilsKt.getString(R.string.scene_fabu), com.baidu.searchbox.scene.inter.PermissionSceneUtilsKt.getString(R.string.scene_fabu_location_title), com.baidu.searchbox.scene.inter.PermissionSceneUtilsKt.getString(R.string.scene_fabu_location_description), com.baidu.searchbox.scene.inter.PermissionSceneUtilsKt.getString(R.string.scene_fabu_location_go_setting_desc), "1", "3", (String) null, 256, (Object) null));
        $this$getDefaultSceneLocationConfigs_u24lambda_u2d1.add(PermissionSceneInfo.init$default(new PermissionSceneInfo(), "location", "weather", com.baidu.searchbox.scene.inter.PermissionSceneUtilsKt.getString(R.string.scene_weather), com.baidu.searchbox.scene.inter.PermissionSceneUtilsKt.getString(R.string.scene_weather_location_title), com.baidu.searchbox.scene.inter.PermissionSceneUtilsKt.getString(R.string.scene_weather_location_description), com.baidu.searchbox.scene.inter.PermissionSceneUtilsKt.getString(R.string.scene_weather_location_go_setting_desc), "1", "3", (String) null, 256, (Object) null));
        $this$getDefaultSceneLocationConfigs_u24lambda_u2d1.add(PermissionSceneInfo.init$default(new PermissionSceneInfo(), "location", "address", com.baidu.searchbox.scene.inter.PermissionSceneUtilsKt.getString(R.string.scene_address), com.baidu.searchbox.scene.inter.PermissionSceneUtilsKt.getString(R.string.scene_address_location_title), com.baidu.searchbox.scene.inter.PermissionSceneUtilsKt.getString(R.string.scene_address_location_description), com.baidu.searchbox.scene.inter.PermissionSceneUtilsKt.getString(R.string.scene_address_location_go_setting_desc), "1", "3", (String) null, 256, (Object) null));
        return arrayList;
    }
}
