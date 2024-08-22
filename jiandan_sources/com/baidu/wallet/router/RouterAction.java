package com.baidu.wallet.router;

import android.content.Context;
import com.baidu.wallet.core.NoProguard;
import java.util.HashMap;

public interface RouterAction extends NoProguard {
    void invoke(Context context, HashMap hashMap, RouterCallback routerCallback);
}
