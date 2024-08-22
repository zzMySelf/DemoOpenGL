package com.baidu.wallet.personal.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.personal.a.a;
import com.baidu.wallet.personal.datamodel.CouponList;
import com.baidu.wallet.personal.ui.view.c;
import com.baidu.wallet.personal.ui.view.d;
import com.baidu.wallet.personal.ui.view.e;
import com.baidu.wallet.personal.ui.view.g;
import com.baidu.wallet.personal.ui.view.h;
import com.baidu.wallet.personal.ui.view.i;

public class b extends a<CouponList.Coupon> {
    public Context c;
    public int d = 0;
    public int e;

    public b(ListView listView, Context context) {
        super(context);
        this.c = context;
    }

    private boolean e(int i2) {
        CouponList.Coupon coupon;
        CouponList.Coupon coupon2;
        CouponList.Coupon coupon3;
        if (i2 < this.a.size() && (coupon = (CouponList.Coupon) this.a.get(i2)) != null) {
            String str = coupon.groupDesc;
            if (TextUtils.isEmpty(str) || i2 == 0) {
                return true;
            }
            int i3 = i2 - 1;
            if (i3 >= 0 && i3 < this.a.size() && (coupon3 = (CouponList.Coupon) this.a.get(i3)) != null) {
                return !str.equals(coupon3.groupDesc);
            }
            int i4 = i2 + 1;
            if (i4 >= 0 && i4 < this.a.size() && (coupon2 = (CouponList.Coupon) this.a.get(i4)) != null) {
                return !str.equals(coupon2.groupDesc);
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
        r3 = (com.baidu.wallet.personal.datamodel.CouponList.Coupon) r2.a.get(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean f(int r3) {
        /*
            r2 = this;
            java.util.List<T> r0 = r2.a
            r1 = 0
            if (r0 == 0) goto L_0x001d
            int r0 = r0.size()
            if (r3 >= r0) goto L_0x001d
            java.util.List<T> r0 = r2.a
            java.lang.Object r3 = r0.get(r3)
            com.baidu.wallet.personal.datamodel.CouponList$Coupon r3 = (com.baidu.wallet.personal.datamodel.CouponList.Coupon) r3
            if (r3 == 0) goto L_0x001d
            int r3 = r3.coupon_receive_timestamp
            int r0 = r2.d
            if (r3 <= r0) goto L_0x001d
            r3 = 1
            r1 = 1
        L_0x001d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.personal.a.b.f(int):boolean");
    }

    public int a(int i2) {
        Context context;
        String str;
        if (getItemViewType(i2) == 1) {
            context = this.c;
            str = "wallet_personal_coupon_banner_item";
        } else {
            context = this.c;
            str = "wallet_personal_coupon_group_item";
        }
        return ResUtils.layout(context, str);
    }

    public a.b<CouponList.Coupon> a(int i2, View view) {
        a.b<CouponList.Coupon> bVar;
        CouponList.Coupon coupon = (CouponList.Coupon) this.a.get(i2);
        if (getItemViewType(i2) == 1) {
            if (coupon != null) {
                e eVar = new e();
                eVar.a(view);
                return eVar;
            }
        } else if (coupon != null) {
            int i3 = coupon.need_unlock;
            int i4 = coupon.coupon_list_show_formwork;
            if (i3 == 1) {
                bVar = (i4 == 5 || i4 == 9 || i4 == 11 || i4 == 22 || i4 == 33 || i4 == 44 || i4 == 55 || i4 == 66) ? new i() : new d();
            } else {
                if (i4 != 5) {
                    if (i4 != 9) {
                        if (!(i4 == 11 || i4 == 22 || i4 == 33 || i4 == 44)) {
                            if (i4 != 55) {
                                if (i4 != 66) {
                                    bVar = new c();
                                }
                            }
                        }
                        bVar = new h();
                    } else {
                        bVar = new g();
                    }
                }
                bVar = new com.baidu.wallet.personal.ui.view.b();
            }
            if (this.e == 0) {
                bVar.a(e(i2));
                bVar.b(f(i2));
            } else {
                bVar.c(true);
            }
            bVar.a(view);
            return bVar;
        }
        return null;
    }

    public void b(int i2) {
        this.e = i2;
    }

    public void c(int i2) {
        this.d = i2;
    }

    /* renamed from: d */
    public CouponList.Coupon getItem(int i2) {
        if (i2 < this.a.size()) {
            return (CouponList.Coupon) this.a.get(i2);
        }
        return null;
    }

    public int getCount() {
        return this.a.size();
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    public int getItemViewType(int i2) {
        if (((CouponList.Coupon) this.a.get(i2)).local_view_type == 1) {
            return 1;
        }
        return super.getItemViewType(i2);
    }

    public int getViewTypeCount() {
        return 1;
    }
}
