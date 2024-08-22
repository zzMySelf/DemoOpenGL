package com.baidu.search.longpress;

import android.view.View;
import com.baidu.search.longpress.LongPressMenu;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/search/longpress/LongPressMenu$initMainMenuView$2", "Lcom/baidu/search/longpress/LongPressMenu$ItemClickListener;", "onItemClick", "", "id", "", "lib_search_long_press_menu_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LongPressMenu.kt */
public final class LongPressMenu$initMainMenuView$2 implements LongPressMenu.ItemClickListener {
    final /* synthetic */ LongPressMenu this$0;

    LongPressMenu$initMainMenuView$2(LongPressMenu $receiver) {
        this.this$0 = $receiver;
    }

    public void onItemClick(int id) {
        if (this.this$0.checkDismissNeedAnimal(id)) {
            this.this$0.showDismissAnimal(new LongPressMenu$initMainMenuView$2$onItemClick$1(this.this$0, id));
            return;
        }
        LongPressMenu.ItemClickListener access$getItemClickListener$p = this.this$0.itemClickListener;
        if (access$getItemClickListener$p != null) {
            access$getItemClickListener$p.onItemClick(id);
        }
        View.OnClickListener access$getMenuClickListener$p = this.this$0.menuClickListener;
        if (access$getMenuClickListener$p != null) {
            access$getMenuClickListener$p.onClick(this.this$0.rootView);
        }
        this.this$0.dismiss();
    }
}
