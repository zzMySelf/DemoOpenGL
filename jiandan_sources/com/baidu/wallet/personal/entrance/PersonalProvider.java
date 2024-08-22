package com.baidu.wallet.personal.entrance;

import com.baidu.wallet.router.RouterProvider;

public class PersonalProvider extends RouterProvider {
    public void registerActions() {
        registerAction("entercoupon", new EnterCouponPageAction());
    }
}
