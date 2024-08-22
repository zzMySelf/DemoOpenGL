package _._._._._.___._;

import _._._._._.__;
import _._._._._.___.___.___;
import ad.qw.qw.qw.qw.ad.de.ad;
import ad.qw.qw.qw.qw.qw;
import com.baidu.netdisk.trade.privilege.MemberProduct;
import com.baidu.netdisk.trade.privilege.TradeAccount;
import com.baidu.netdisk.trade.privilege.config.IRequest;
import com.baidu.netdisk.trade.privilege.config.IStore;
import com.baidu.netdisk.trade.privilege.io.model.LevelInfo;
import com.baidu.netdisk.trade.privilege.io.model.Product;
import com.baidu.netdisk.trade.privilege.io.model.ProductListResponse;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;

public final class ___ {
    public final IStore qw;

    public static final class _ extends Lambda implements Function1<Product, Boolean> {

        /* renamed from: _  reason: collision with root package name */
        public final /* synthetic */ long f544_;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public _(long j) {
            super(1);
            this.f544_ = j;
        }

        public final boolean _(@NotNull Product product) {
            Intrinsics.checkNotNullParameter(product, "it");
            if (product.___() == null || product.___().longValue() < this.f544_) {
                return false;
            }
            MemberProduct[] values = MemberProduct.values();
            ArrayList arrayList = new ArrayList(values.length);
            for (MemberProduct cluster : values) {
                arrayList.add(cluster.getCluster());
            }
            if (CollectionsKt___CollectionsKt.contains(arrayList, product._())) {
                return true;
            }
            return false;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(_((Product) obj));
        }
    }

    public ___(@NotNull IStore iStore) {
        Intrinsics.checkNotNullParameter(iStore, "iStore");
        this.qw = iStore;
    }

    public final void ad() {
        MemberProduct[] values = MemberProduct.values();
        ArrayList<String> arrayList = new ArrayList<>(values.length);
        for (MemberProduct cluster : values) {
            arrayList.add(cluster.getCluster());
        }
        for (String str : arrayList) {
            this.qw.remove("trade_product_endtime_pre_" + str);
        }
    }

    public final void de(List<Product> list, long j) {
        qw qwVar;
        for (T t : SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(list), new _(j))) {
            if (!(t.___() == null || t._() == null)) {
                if (Intrinsics.areEqual((Object) t.__(), (Object) MemberProduct.SVIP.getCluster())) {
                    qwVar = new qw(t.__(), t.___().longValue());
                } else {
                    qwVar = new qw(t._(), t.___().longValue());
                }
                TradeAccount.f913rg.qw(qwVar);
                IStore iStore = this.qw;
                iStore.putLong("trade_product_endtime_pre_" + qwVar.qw(), t.___().longValue());
            }
        }
    }

    public final boolean fe() {
        Object obj;
        String __;
        Integer num = null;
        try {
            _._._._._.___.___.___ qw2 = ad.f546de.qw();
            IRequest ad2 = __.f542ad.ad();
            obj = Result.m1155constructorimpl((ProductListResponse) ___.qw.qw(qw2, ad2 != null ? ad2.fe() : null, 0, 0, 6, (Object) null).execute().body());
        } catch (Throwable th2) {
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m1161isFailureimpl(obj)) {
            obj = null;
        }
        ProductListResponse productListResponse = (ProductListResponse) obj;
        boolean z = false;
        if (productListResponse == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(productListResponse, "runCatching {\n          …tOrNull() ?: return false");
        String userTag = productListResponse.getUserTag();
        if (!(userTag == null || userTag.length() == 0)) {
            this.qw.putString("trade_user_identity_usertag", productListResponse.getUserTag());
        }
        LevelInfo levelInfo = productListResponse.getLevelInfo();
        if (!(levelInfo == null || (__ = levelInfo.__()) == null)) {
            if (__.length() == 0) {
                z = true;
            }
            if (!z) {
                this.qw.putString("trade_user_v10_identity_number", productListResponse.getLevelInfo().__());
            }
        }
        TradeAccount.f913rg.ad();
        ad();
        if (productListResponse.getInfoList() != null) {
            de(productListResponse.getInfoList(), productListResponse.getServerCurrentTime());
        }
        TradeAccount.f913rg.i(productListResponse.getPrivileges());
        LevelInfo levelInfo2 = productListResponse.getLevelInfo();
        TradeAccount.m33switch(levelInfo2 != null ? Integer.valueOf(levelInfo2._()) : null);
        List<Product> infoList = productListResponse.getInfoList();
        if (infoList != null) {
            ArrayList arrayList = new ArrayList();
            for (Product __2 : infoList) {
                String __3 = __2.__();
                Integer valueOf = __3 != null ? Integer.valueOf(qw(__3)) : null;
                if (valueOf != null) {
                    arrayList.add(valueOf);
                }
            }
            num = (Integer) CollectionsKt___CollectionsKt.maxOrNull(arrayList);
        }
        TradeAccount.when(num);
        return true;
    }

    public final int qw(String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            if (Intrinsics.areEqual((Object) lowerCase, (Object) MemberProduct.SVIP.getCluster())) {
                return 2;
            }
            return Intrinsics.areEqual((Object) lowerCase, (Object) MemberProduct.VIP.getCluster()) ? 1 : 0;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}
