package com.baidu.searchbox.download.center.ui;

import com.baidu.android.ext.widget.checkbox.BdCheckBox;
import com.baidu.searchbox.download.center.R;
import com.baidu.searchbox.download.center.ui.AutoBackupPopupOptionManager;
import com.baidu.searchbox.download.center.ui.autobackup.NetDiskOptionWrapper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "viewHolder", "Lcom/baidu/searchbox/download/center/ui/AutoBackupPopupOptionManager$AutoBackupPopupOptionViewHolder;", "Lcom/baidu/searchbox/download/center/ui/AutoBackupPopupOptionManager;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AutoBackupPopupView.kt */
final class AutoBackupPopupView$addPictureOption$1 extends Lambda implements Function1<AutoBackupPopupOptionManager.AutoBackupPopupOptionViewHolder, Unit> {
    final /* synthetic */ AutoBackupPopupView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AutoBackupPopupView$addPictureOption$1(AutoBackupPopupView autoBackupPopupView) {
        super(1);
        this.this$0 = autoBackupPopupView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((AutoBackupPopupOptionManager.AutoBackupPopupOptionViewHolder) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(final AutoBackupPopupOptionManager.AutoBackupPopupOptionViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        String string = this.this$0.context.getString(R.string.auto_backup_popup_options_picture);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…up_popup_options_picture)");
        viewHolder.initOption(string, Integer.valueOf(R.drawable.auto_backup_popup_option_detail_pic), false);
        viewHolder.setStartAutoBackupCallBack(new Function0<Unit>() {
            public final void invoke() {
                NetDiskOptionWrapper netDiskOptionWrapper = NetDiskOptionWrapper.INSTANCE;
                BdCheckBox checkBox = viewHolder.getCheckBox();
                NetDiskOptionWrapper.setSwitchStateOptionPicture$default(netDiskOptionWrapper, checkBox != null ? checkBox.isChecked() : false, true, (Function1) null, 4, (Object) null);
            }
        });
    }
}
