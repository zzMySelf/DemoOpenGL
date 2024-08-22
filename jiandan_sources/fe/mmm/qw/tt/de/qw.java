package fe.mmm.qw.tt.de;

import android.content.Context;
import android.os.Bundle;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.tera.scan.model.CropInfo;
import fe.ggg.ad.qw.fe.ad.de;
import fe.mmm.qw.tt.ad.when.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Interceptor(name = "OCRRectifyRouterInterceptor", priority = 1)
public final class qw implements IInterceptor {
    public void init(@Nullable Context context) {
    }

    public void process(@Nullable Postcard postcard, @Nullable InterceptorCallback interceptorCallback) {
        boolean z;
        boolean z2;
        String str;
        Postcard postcard2 = postcard;
        InterceptorCallback interceptorCallback2 = interceptorCallback;
        if (postcard2 != null && Intrinsics.areEqual((Object) postcard.getPath(), (Object) "/flutternetdisk/native/OCRRectifyActivity")) {
            Bundle extras = postcard.getExtras();
            ArrayList<String> stringArrayList = extras != null ? extras.getStringArrayList("selectedImageList") : null;
            if (!(stringArrayList == null || stringArrayList.isEmpty())) {
                Bundle extras2 = postcard.getExtras();
                Integer valueOf = extras2 != null ? Integer.valueOf(extras2.getInt("category", -1)) : null;
                if ((valueOf != null && valueOf.intValue() == 15) || (valueOf != null && valueOf.intValue() == 0)) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z && (valueOf == null || valueOf.intValue() != 19)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                    ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(stringArrayList, 10));
                    for (String str2 : stringArrayList) {
                        List emptyList = CollectionsKt__CollectionsKt.emptyList();
                        Intrinsics.checkNotNullExpressionValue(str2, "path");
                        arrayList.add(e.ad(new CropInfo("", emptyList, 0, str2, 0.0f, 0.0f), false, 2, (Object) null));
                    }
                    postcard2.withSerializable("aiScanImages", de.qw(arrayList));
                } else {
                    if (((valueOf != null && valueOf.intValue() == 12) || (valueOf != null && valueOf.intValue() == 14)) || (valueOf != null && valueOf.intValue() == 20)) {
                        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(stringArrayList, 10));
                        for (String str3 : stringArrayList) {
                            List emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                            Intrinsics.checkNotNullExpressionValue(str3, "path");
                            arrayList2.add(e.ad(new CropInfo("", emptyList2, 0, str3, 0.0f, 0.0f), false, 2, (Object) null));
                        }
                        ArrayList<HashMap> qw = de.qw(arrayList2);
                        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(qw, 10));
                        for (HashMap hashMap : qw) {
                            String str4 = (String) hashMap.get("crop_path");
                            if (str4 == null || str4.length() == 0) {
                                str = String.valueOf(hashMap.get("source_path"));
                            } else {
                                str = String.valueOf(hashMap.get("crop_path"));
                            }
                            arrayList3.add(str);
                        }
                        postcard2.withStringArrayList("images", de.qw(arrayList3));
                    }
                }
                if (interceptorCallback2 != null) {
                    interceptorCallback2.onContinue(postcard2);
                }
            } else if (interceptorCallback2 != null) {
                interceptorCallback2.onContinue(postcard2);
            }
        } else if (interceptorCallback2 != null) {
            interceptorCallback2.onContinue(postcard2);
        }
    }
}
