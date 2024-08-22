package com.baidu.searchbox;

import android.text.TextUtils;
import com.baidu.pyramid.annotation.component.ListHolder;
import fe.fe.ddd.qw;
import fe.fe.vvv.qw.qw.ad;
import java.util.List;

public class PerfSampleManager {
    public ListHolder<IPerfSampleCallback> qw;

    public interface IPerfSampleCallback {
        String qw();
    }

    public PerfSampleManager() {
        ad();
    }

    public void ad() {
        ad de2 = ad.de();
        this.qw = de2;
        de2.ad(new qw());
    }

    public String qw() {
        List<IPerfSampleCallback> qw2;
        ListHolder<IPerfSampleCallback> listHolder = this.qw;
        String str = null;
        if (!(listHolder == null || (qw2 = listHolder.qw()) == null || qw2.size() == 0)) {
            for (int i2 = 0; i2 < qw2.size(); i2++) {
                String qw3 = qw2.get(i2).qw();
                if (!TextUtils.isEmpty(qw3)) {
                    if (TextUtils.isEmpty(str)) {
                        str = qw3;
                    } else if (!str.contains(qw3)) {
                        str = str + "," + qw3;
                    }
                }
            }
        }
        return str;
    }
}
