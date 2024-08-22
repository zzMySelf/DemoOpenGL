package com.dxmpay.wallet.router;

import android.content.Context;
import com.dxmpay.wallet.core.NoProguard;
import java.util.HashMap;

public interface RouterAction extends NoProguard {
    void invoke(Context context, HashMap hashMap, RouterCallback routerCallback);
}
