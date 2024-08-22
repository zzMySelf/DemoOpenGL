package com.baidu.searchbox.account.userinfo.activity;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.android.common.menu.bottomlist.BottomCustomMenuItem;
import com.baidu.searchbox.account.userinfo.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/account/userinfo/activity/PersonalPageNaFragment$showBottomPhotoMenu$customItem$1", "Lcom/baidu/android/common/menu/bottomlist/BottomCustomMenuItem;", "getCustomView", "Landroid/view/View;", "context", "Landroid/content/Context;", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalPageNaFragment.kt */
public final class PersonalPageNaFragment$showBottomPhotoMenu$customItem$1 extends BottomCustomMenuItem {
    PersonalPageNaFragment$showBottomPhotoMenu$customItem$1() {
        super(10, true, true);
    }

    public View getCustomView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.ai_genearte_background);
        return imageView;
    }
}
