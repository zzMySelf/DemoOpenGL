package com.baidu.searchbox.aisearch.comps.topbar;

import android.graphics.Typeface;
import android.view.KeyEvent;
import android.widget.TextView;
import com.baidu.searchbox.aisearch.R;
import com.baidu.searchbox.aisearch.utils.ResExtKt;
import com.google.android.material.tabs.TabLayout;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/aisearch/comps/topbar/TopBarComp$initTabLayout$1", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "onTabReselected", "", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabSelected", "onTabUnselected", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TopBarComp.kt */
public final class TopBarComp$initTabLayout$1 implements TabLayout.OnTabSelectedListener {
    TopBarComp$initTabLayout$1() {
    }

    public void onTabSelected(TabLayout.Tab tab) {
        TextView $this$onTabSelected_u24lambda_u2d0 = null;
        if ((tab != null ? tab.getCustomView() : null) == null && tab != null) {
            tab.setCustomView(R.layout.aisearch_top_bar_tab_item);
        }
        KeyEvent.Callback customView = tab != null ? tab.getCustomView() : null;
        if (customView instanceof TextView) {
            $this$onTabSelected_u24lambda_u2d0 = (TextView) customView;
        }
        if ($this$onTabSelected_u24lambda_u2d0 != null) {
            $this$onTabSelected_u24lambda_u2d0.setText(tab.getText());
            $this$onTabSelected_u24lambda_u2d0.setTextColor(ResExtKt.getColor(R.color.top_tab_selected_color));
            $this$onTabSelected_u24lambda_u2d0.setTypeface(Typeface.DEFAULT_BOLD);
        }
    }

    public void onTabUnselected(TabLayout.Tab tab) {
        TextView $this$onTabUnselected_u24lambda_u2d1 = null;
        KeyEvent.Callback customView = tab != null ? tab.getCustomView() : null;
        if (customView instanceof TextView) {
            $this$onTabUnselected_u24lambda_u2d1 = (TextView) customView;
        }
        if ($this$onTabUnselected_u24lambda_u2d1 != null) {
            $this$onTabUnselected_u24lambda_u2d1.setText(tab.getText());
            $this$onTabUnselected_u24lambda_u2d1.setTextColor(ResExtKt.getColor(R.color.top_tab_unselected_color));
            $this$onTabUnselected_u24lambda_u2d1.setTypeface(Typeface.DEFAULT);
        }
    }

    public void onTabReselected(TabLayout.Tab tab) {
    }
}
