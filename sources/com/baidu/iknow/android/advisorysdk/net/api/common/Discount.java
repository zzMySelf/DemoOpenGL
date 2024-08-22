package com.baidu.iknow.android.advisorysdk.net.api.common;

import com.baidu.searchbox.NoProGuard;
import java.io.Serializable;

public class Discount implements Serializable, NoProGuard {
    public int discount;
    public String discountName;
    public DiscountType discountType;
}
