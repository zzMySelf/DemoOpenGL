package com.baidu.wallet.paysdk.ui.widget.compliance.d;

import android.content.Context;
import com.baidu.wallet.paysdk.datamodel.DxmAddress;
import com.baidu.wallet.paysdk.ui.widget.compliance.DxmShowDateActivity;
import com.baidu.wallet.paysdk.ui.widget.compliance.DxmShowDetailedAddressActivity;
import com.baidu.wallet.paysdk.ui.widget.compliance.DxmShowJobActivity;
import com.baidu.wallet.paysdk.ui.widget.compliance.b.b;
import com.baidu.wallet.paysdk.ui.widget.compliance.b.c;
import java.util.Calendar;

public class a {

    /* renamed from: com.baidu.wallet.paysdk.ui.widget.compliance.d.a$a  reason: collision with other inner class name */
    public static class C0170a {
        public static final a a = new a();
    }

    public static a a() {
        return C0170a.a;
    }

    public a() {
    }

    public void a(Context context, Calendar calendar, Calendar calendar2, b bVar) {
        if (context == null || bVar == null) {
            throw new IllegalArgumentException(a.class.getSimpleName() + " please check params");
        }
        DxmShowDateActivity.startActivity(context, calendar, calendar2, bVar);
    }

    public void a(Context context, c cVar) {
        if (context == null || cVar == null) {
            throw new IllegalArgumentException(a.class.getSimpleName() + " please check params");
        }
        DxmShowJobActivity.startActivity(context, cVar);
    }

    public void a(Context context, DxmAddress dxmAddress, com.baidu.wallet.paysdk.ui.widget.compliance.b.a aVar) {
        if (context == null || aVar == null) {
            throw new IllegalArgumentException(a.class.getSimpleName() + " please check params");
        }
        DxmShowDetailedAddressActivity.startActivity(context, dxmAddress, aVar);
    }
}
