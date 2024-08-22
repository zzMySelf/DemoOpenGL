package com.tera.scan.vip;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.mars.kotlin.service.Result;
import com.tera.scan.vip.network.model.ProductInfo;
import com.tera.scan.vip.network.model.ProductsData;
import com.tera.scan.vip.network.model.ProductsResponse;
import fe.mmm.qw.i.qw;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/tera/scan/vip/VipInfoManager$getProducts$1", "Landroidx/lifecycle/Observer;", "Lcom/mars/kotlin/service/Result;", "Lcom/tera/scan/vip/network/model/ProductsResponse;", "onChanged", "", "result", "lib_vip_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VipInfoManager$getProducts$1 implements Observer<Result<ProductsResponse>> {
    public final /* synthetic */ LiveData<Result<ProductsResponse>> qw;

    public void onChanged(@Nullable Result<ProductsResponse> result) {
        Unit unit;
        ProductsResponse data;
        ProductsData data2;
        List<ProductInfo> productList;
        this.qw.removeObserver(this);
        qw.ad("vip_info", "getProducts: " + result);
        if (result == null || (data = result.getData()) == null || (data2 = data.getData()) == null || (productList = data2.getProductList()) == null) {
            unit = null;
        } else {
            VipInfoManager.f7458th.postValue(productList);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            VipInfoManager.f7458th.postValue(CollectionsKt__CollectionsKt.emptyList());
        }
    }
}
