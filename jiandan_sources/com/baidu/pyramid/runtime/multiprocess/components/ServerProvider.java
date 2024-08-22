package com.baidu.pyramid.runtime.multiprocess.components;

import fe.fe.vvv.ad.qw.fe;
import fe.fe.vvv.ad.qw.uk.qw;
import java.util.ArrayList;
import java.util.List;

public class ServerProvider extends DispatchableContentProvider {
    public static String getCoreProviderAuthority() {
        return fe.qw().getPackageName() + ".provider.ipc.server";
    }

    public String getAuthority() {
        return getCoreProviderAuthority();
    }

    public List<qw> getContentProviderDelegates() {
        List<qw> qw = fe.fe.vvv.ad.qw.o.qw.qw(getAuthority());
        if (qw == null) {
            qw = new ArrayList<>();
        }
        qw.add(0, new fe.fe.vvv.ad.qw.i.qw());
        return qw;
    }
}
