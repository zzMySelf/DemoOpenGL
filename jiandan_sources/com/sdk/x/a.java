package com.sdk.x;

import android.content.Context;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.sdk.a.e;
import com.sdk.a.f;
import com.sdk.base.framework.bean.DataInfo;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

public class a {
    public <T> e<T> a(Context context, int i2, List<String> list, com.sdk.e.a<T> aVar) {
        StringBuffer stringBuffer;
        com.sdk.z.a aVar2 = new com.sdk.z.a(context, list, aVar);
        DataInfo dataInfo = new DataInfo();
        StringBuffer stringBuffer2 = new StringBuffer();
        StringBuffer stringBuffer3 = new StringBuffer();
        if (list.size() != 0) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                String str = list.get(i3);
                String substring = str.substring(0, 3);
                try {
                    InetAddress byName = InetAddress.getByName(str);
                    byName.getHostAddress();
                    byte[] address = byName.getAddress();
                    if (str.length() != 0) {
                        if (address.length == 4) {
                            if (!substring.equals("127")) {
                                if (!substring.equals("192")) {
                                    stringBuffer2.append(str);
                                    stringBuffer = stringBuffer2;
                                }
                            }
                        } else if (!str.contains("%")) {
                            if (!"::1".equals(str)) {
                                stringBuffer3.append(str);
                                stringBuffer = stringBuffer3;
                            }
                        }
                        stringBuffer.append("-");
                    }
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
            }
            if (stringBuffer2.length() != 0 && '-' == stringBuffer2.charAt(stringBuffer2.length() - 1)) {
                dataInfo.putData("privateIp", stringBuffer2.deleteCharAt(stringBuffer2.length() - 1));
            }
            if (stringBuffer3.length() != 0 && '-' == stringBuffer3.charAt(stringBuffer3.length() - 1)) {
                dataInfo.putData("privateIp_v6", stringBuffer3.deleteCharAt(stringBuffer3.length() - 1));
            }
        }
        dataInfo.putData("serviceType", Integer.valueOf(i2));
        dataInfo.putData("newVersion", BindFastRequest.BIND_FROM_INITIATIVE);
        return aVar2.a(aVar2.f6817i, "/dro/netm/v1.0/qc", dataInfo, new com.sdk.g.a(aVar2), 0, f.a.POST);
    }
}
