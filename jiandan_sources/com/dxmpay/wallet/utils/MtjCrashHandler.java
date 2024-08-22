package com.dxmpay.wallet.utils;

import android.content.Context;
import com.baidu.android.lbspay.BuildConfig;
import com.baidu.apollon.a;
import com.baidu.mobstat.dxmpay.StatService;
import com.dxmpay.apollon.utils.PhoneUtils;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.utils.LogUtil;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class MtjCrashHandler {
    public static volatile AtomicBoolean qw = new AtomicBoolean(false);

    public static boolean ad() {
        try {
            Class.forName("com.baidu.mobstat.dxmpay.StatService");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static void init(Context context) {
        if (qw.compareAndSet(false, true) && ad()) {
            try {
                StatService.i(false);
                StatService.pf(context, 16);
                StatService.th("881db0b268");
                StatService.rg(BeanConstants.CHANNEL_ID);
                StatService.m29if(context, PhoneUtils.getCUID2(context));
                StatService.yj(context, BeanConstants.VERSION_NO);
                StatService.uk(PhoneUtils.getAppVersionName(context));
                StatService.o(qw());
                StatService.fe(true);
                StatService.m30switch(context);
            } catch (Throwable th2) {
                LogUtil.e("MtjCrashHandler", th2.getMessage(), th2);
            }
        }
    }

    public static List<String> qw() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("com.baidu.wallet");
        linkedList.add("com.baidu.bankdetection");
        linkedList.add("com.baidu.android.pay");
        linkedList.add(a.b);
        linkedList.add("com.baidu.android.minipay");
        linkedList.add(BuildConfig.LIBRARY_PACKAGE_NAME);
        linkedList.add("com.dxm.face");
        linkedList.add("com.baidu.idl");
        linkedList.add("com.dxm.passport");
        linkedList.add("com.dxmpay.apollon");
        linkedList.add("com.dxmpay.wallet");
        linkedList.add("com.dxmpay.ocr");
        linkedList.add("com.dxmpay.nfc");
        linkedList.add("com.dxm.ai");
        linkedList.add("com.dxm.facepay");
        linkedList.add("com.dxm.ai.facerecognize");
        linkedList.add("com.dxm.faceresult");
        linkedList.add("com.dxm.camera");
        linkedList.add("com.dxmpay.floatingwindow");
        linkedList.add("com.dxmpay.nfc");
        linkedList.add("com.dxm.savepicture");
        linkedList.add("com.duxiaoman.dxmpay.statistics");
        linkedList.add("com.dxm.scancode");
        linkedList.add("com.dxm.acstransfer");
        linkedList.add("com.dxm.lite.facerecognize");
        return linkedList;
    }
}
