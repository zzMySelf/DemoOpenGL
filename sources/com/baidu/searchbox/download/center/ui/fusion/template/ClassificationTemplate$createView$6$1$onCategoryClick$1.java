package com.baidu.searchbox.download.center.ui.fusion.template;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.common.ui.style.R;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.searchbox.appframework.BaseActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "intent", "Landroid/content/Intent;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassificationTemplate.kt */
final class ClassificationTemplate$createView$6$1$onCategoryClick$1 extends Lambda implements Function1<Intent, Unit> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClassificationTemplate$createView$6$1$onCategoryClick$1(Context context) {
        super(1);
        this.$context = context;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Intent) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(Intent intent) {
        if (intent != null) {
            Intent intent2 = intent;
            ActivityUtils.startActivitySafely(this.$context, intent);
            BaseActivity.setNextPendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left, R.anim.slide_in_from_left, R.anim.slide_out_to_right);
        }
    }
}
