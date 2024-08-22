package com.tera.scan.doc.preview.office.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.baidu.aiscan.R;
import fe.mmm.qw.o.qw.ad.ad.ad;
import java.util.ArrayList;
import java.util.List;

public class ExcelTab extends LinearLayout {
    public static final String TAG = "ExcelTab";
    public int selectedIndex;
    public List<TabButton> tabs;

    public class qw implements ITabClickListener {
        public final ITabClickListener qw;

        public qw(ITabClickListener iTabClickListener) {
            this.qw = iTabClickListener;
        }

        public void qw(String str, String str2, int i2) {
            fe.mmm.qw.i.qw.ad(ExcelTab.TAG, "showing index:" + i2);
            fe.mmm.qw.i.qw.ad(ExcelTab.TAG, "hiding index:" + ExcelTab.this.selectedIndex);
            if (ExcelTab.this.selectedIndex != i2) {
                ((TabButton) ExcelTab.this.tabs.get(ExcelTab.this.selectedIndex)).setUnSelected();
                ((TabButton) ExcelTab.this.tabs.get(i2)).setSelected();
                String str3 = ((TabButton) ExcelTab.this.tabs.get(ExcelTab.this.selectedIndex)).getText().toString();
                int unused = ExcelTab.this.selectedIndex = i2;
                this.qw.qw(str3, str2, i2);
            }
        }
    }

    public ExcelTab(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.tabs = new ArrayList();
        setOrientation(0);
    }

    public void activateTab(int i2, boolean z) {
        fe.mmm.qw.i.qw.ad(TAG, "index:" + i2 + " needselect:" + z);
        StringBuilder sb = new StringBuilder();
        sb.append("tab size:");
        sb.append(this.tabs.size());
        fe.mmm.qw.i.qw.ad(TAG, sb.toString());
        for (int i3 = 0; i3 < this.tabs.size(); i3++) {
            fe.mmm.qw.i.qw.ad(TAG, "tab width:" + this.tabs.get(i3).getLayoutParams().width);
            if (i2 != i3) {
                this.tabs.get(i3).setUnSelected();
            } else if (z) {
                this.tabs.get(i3).setSelected();
                this.selectedIndex = i2;
            }
        }
    }

    public void configChanged(Configuration configuration) {
        Context context = getContext();
        if (context != null) {
            double dimension = (double) getResources().getDimension(R.dimen.tabbutton_width);
            double de2 = (double) ad.de(context, (float) configuration.screenWidthDp);
            if (de2 > ((double) this.tabs.size()) * dimension) {
                double size = (de2 * 1.0d) / ((double) this.tabs.size());
                for (int i2 = 0; i2 < this.tabs.size(); i2++) {
                    TabButton tabButton = this.tabs.get(i2);
                    tabButton.setWidth((int) size);
                    tabButton.setIsAdjustWidth(true);
                }
                return;
            }
            for (int i3 = 0; i3 < this.tabs.size(); i3++) {
                TabButton tabButton2 = this.tabs.get(i3);
                if (i3 == this.selectedIndex) {
                    tabButton2.setWidth(getResources().getDimensionPixelSize(R.dimen.select_tab_button_width));
                } else {
                    tabButton2.setWidth((int) dimension);
                }
                tabButton2.setIsAdjustWidth(false);
            }
        }
    }

    public void setTabs(List<String> list, ITabClickListener iTabClickListener) {
        boolean z;
        Context context = getContext();
        if (context != null) {
            double dimension = (double) getResources().getDimension(R.dimen.tabbutton_width);
            double qw2 = (double) fe.mmm.qw.o.qw.ad.ad.qw.qw(context);
            if (qw2 > ((double) list.size()) * dimension) {
                dimension = (qw2 * 1.0d) / ((double) list.size());
                z = true;
            } else {
                z = false;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) dimension, -1);
            qw qwVar = new qw(iTabClickListener);
            layoutParams.setMargins(0, 0, 0, 0);
            for (int i2 = 0; i2 < list.size(); i2++) {
                TabButton tabButton = (TabButton) LayoutInflater.from(getContext()).inflate(R.layout.excel_tab, this, false);
                tabButton.setText(list.get(i2));
                tabButton.setIndex(i2);
                tabButton.setListener(qwVar);
                tabButton.setIsAdjustWidth(z);
                this.tabs.add(tabButton);
                addView(tabButton, layoutParams);
            }
        }
    }
}
