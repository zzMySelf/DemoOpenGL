package com.baidu.searchbox.tools.develop.provider.basicinfo;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.IMEIRequestUtils;
import com.baidu.helios.HeliosManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.debug.data.DebugDataGroupProvider;
import com.baidu.searchbox.debug.data.DebugItemInfo;
import com.baidu.searchbox.debug.data.TextItemInfo;
import com.baidu.searchbox.push.PushUtil;
import com.baidu.searchbox.util.BaiduIdentityManager;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.http.conn.util.InetAddressUtils;

public class DeviceInfoProvider extends DebugDataGroupProvider {
    public String getGroupName() {
        return "B-设备信息";
    }

    public List<DebugItemInfo> getChildItemList() {
        return getDeviceInfo();
    }

    private List<DebugItemInfo> getDeviceInfo() {
        List<DebugItemInfo> deviceData = new ArrayList<>();
        int width = DeviceUtil.ScreenInfo.getDisplayWidth(AppRuntime.getAppContext());
        int height = DeviceUtil.ScreenInfo.getDisplayHeight(AppRuntime.getAppContext());
        int densityDpi = DeviceUtil.ScreenInfo.getDensityDpi(AppRuntime.getAppContext());
        String cuid = BaiduIdentityManager.getInstance(AppRuntime.getAppContext()).getUid();
        String enUid = BaiduIdentityManager.getInstance(AppRuntime.getAppContext()).getEnUid();
        deviceData.add(new TextItemInfo("CUID：", cuid, (View.OnClickListener) null));
        deviceData.add(new TextItemInfo("加密UID：", enUid, (View.OnClickListener) null));
        deviceData.add(new TextItemInfo("CH_UID：", PushUtil.getUserId(AppRuntime.getAppContext()), (View.OnClickListener) null));
        deviceData.add(new TextItemInfo("CH_CID：", PushUtil.getChannelId(AppRuntime.getAppContext()), (View.OnClickListener) null));
        deviceData.add(new TextItemInfo("IMEI：", IMEIRequestUtils.getIMEI("0"), (View.OnClickListener) null));
        deviceData.add(new TextItemInfo("OAID: ", HeliosManager.getInstance(AppRuntime.getAppContext()).getLastCachedOid(), (View.OnClickListener) null));
        deviceData.add(new TextItemInfo("屏幕像素：", width + "x" + height, (View.OnClickListener) null));
        deviceData.add(new TextItemInfo("屏幕密度：", String.valueOf(densityDpi), (View.OnClickListener) null));
        deviceData.add(new TextItemInfo("SDK版本：", String.valueOf(Build.VERSION.SDK_INT), (View.OnClickListener) null));
        deviceData.add(new TextItemInfo("I P 地址：", getLocalIpAddress(), (View.OnClickListener) null));
        deviceData.add(new TextItemInfo("系统版本：", Build.VERSION.RELEASE, (View.OnClickListener) null));
        deviceData.add(new TextItemInfo("制造厂商：", Build.MANUFACTURER, (View.OnClickListener) null));
        deviceData.add(new TextItemInfo("手机型号：", Build.MODEL, (View.OnClickListener) null));
        DeviceUtil.CPUInfo cpu = DeviceUtil.CPUInfo.getSystemCPUInfo();
        deviceData.add(new TextItemInfo("CPU 信息：", "Processor=" + cpu.processor + "\r\nFeatures=" + cpu.features, (View.OnClickListener) null));
        deviceData.add(new TextItemInfo("设备支持ABI列表：", getABIList().toString(), (View.OnClickListener) null));
        return deviceData;
    }

    public List<String> getABIList() {
        List abiList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            if (Build.SUPPORTED_64_BIT_ABIS != null && Build.SUPPORTED_64_BIT_ABIS.length > 0) {
                for (String add : Build.SUPPORTED_64_BIT_ABIS) {
                    abiList.add(add);
                }
            }
            if (Build.SUPPORTED_32_BIT_ABIS != null && Build.SUPPORTED_32_BIT_ABIS.length > 0) {
                for (String add2 : Build.SUPPORTED_32_BIT_ABIS) {
                    abiList.add(add2);
                }
            }
        } else {
            if (!TextUtils.isEmpty(Build.CPU_ABI)) {
                abiList.add(Build.CPU_ABI);
            }
            if (!TextUtils.isEmpty(Build.CPU_ABI2)) {
                abiList.add(Build.CPU_ABI2);
            }
        }
        return abiList;
    }

    public String getLocalIpAddress() {
        try {
            Iterator<NetworkInterface> it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                Iterator<InetAddress> it2 = Collections.list(it.next().getInetAddresses()).iterator();
                while (true) {
                    if (it2.hasNext()) {
                        InetAddress address = it2.next();
                        String ipv4 = address.getHostAddress();
                        if (!address.isLoopbackAddress() && InetAddressUtils.isIPv4Address(ipv4)) {
                            return ipv4;
                        }
                    }
                }
            }
            return null;
        } catch (SocketException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
