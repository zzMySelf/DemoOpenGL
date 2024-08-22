package com.baidu.searchbox.paywall.database;

import android.database.Cursor;
import com.baidu.searchbox.paywall.database.PaywallDbControl;
import com.baidu.searchbox.paywall.privatemodel.PaywallItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "Lcom/baidu/searchbox/paywall/database/PaywallDbControl$COLUMN;", "cursor", "Landroid/database/Cursor;", "item", "Lcom/baidu/searchbox/paywall/privatemodel/PaywallItem;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaywallDbControl.kt */
final class PaywallDbControl$Companion$setResourceType$1 extends Lambda implements Function3<PaywallDbControl.COLUMN, Cursor, PaywallItem, Unit> {
    public static final PaywallDbControl$Companion$setResourceType$1 INSTANCE = new PaywallDbControl$Companion$setResourceType$1();

    PaywallDbControl$Companion$setResourceType$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((PaywallDbControl.COLUMN) p1, (Cursor) p2, (PaywallItem) p3);
        return Unit.INSTANCE;
    }

    public final void invoke(PaywallDbControl.COLUMN $this$null, Cursor cursor, PaywallItem item) {
        Intrinsics.checkNotNullParameter($this$null, "$this$null");
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        Intrinsics.checkNotNullParameter(item, "item");
        if ($this$null.getColumnIndex() == null) {
            $this$null.setColumnIndex(Integer.valueOf(cursor.getColumnIndex($this$null.getColumnName())));
        }
        Integer columnIndex = $this$null.getColumnIndex();
        Intrinsics.checkNotNull(columnIndex);
        item.resourceType = cursor.getInt(columnIndex.intValue());
    }
}
