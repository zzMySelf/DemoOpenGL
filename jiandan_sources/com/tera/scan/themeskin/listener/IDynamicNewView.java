package com.tera.scan.themeskin.listener;

import android.view.View;
import android.widget.TextView;
import fe.mmm.qw.d.ad.ggg.ad;
import java.util.List;

public interface IDynamicNewView {
    void dynamicAddFontView(TextView textView);

    void dynamicAddView(View view, String str, int i2);

    void dynamicAddView(View view, List<ad> list);
}
