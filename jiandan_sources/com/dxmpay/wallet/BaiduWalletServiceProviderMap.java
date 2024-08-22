package com.dxmpay.wallet;

import com.baidu.wallet.api.WalletServiceBeanConst;
import com.dxmpay.wallet.core.NoProguard;
import java.util.HashMap;
import java.util.Map;

public class BaiduWalletServiceProviderMap implements NoProguard {
    public static final String PLUGIN_FASTPAY = "fastpay";
    public static final String PLUGIN_LANGBRIGE = "langbrige";
    public static final String PLUGIN_NFC = "nfc";
    public static final String PLUGIN_PERSONAL = "personal";
    public static final String PLUGIN_QRCODESCANNER = "saoyisao";
    public static final String PLUGIN_TAB = "tab";
    public static final String PLUGIN_TRNASFER = "transfer";
    public static final String PLUGIN_WALLETHOME = "home";
    public Map<Long, String> maps;

    public static class ad {
        public static final BaiduWalletServiceProviderMap qw = new BaiduWalletServiceProviderMap();
    }

    public static final BaiduWalletServiceProviderMap getInstance() {
        return ad.qw;
    }

    private void initMaps() {
        this.maps.put(1L, "fastpay");
        this.maps.put(4096L, "fastpay");
        this.maps.put(2L, "transfer");
        this.maps.put(64L, "personal");
        this.maps.put(1024L, "nfc");
        this.maps.put(32768L, "saoyisao");
        this.maps.put(16384L, "home");
        this.maps.put(Long.valueOf(WalletServiceBeanConst.SERVICE_ID_WALLET_HOME_CREDIT), "home");
        this.maps.put(Long.valueOf(WalletServiceBeanConst.SERVICE_ID_WALLET_NFC_BUS_CARD_SETTING), "nfc");
        this.maps.put(Long.valueOf(WalletServiceBeanConst.SERVICE_ID_WALLET_LANGBRIGE), "langbrige");
        this.maps.put(Long.valueOf(WalletServiceBeanConst.SERVICE_ID_WALLET_HOME_FINANCE), "tab");
    }

    public void addDatas(Map<Long, String> map) {
        if (this.maps == null) {
            this.maps = new HashMap();
        }
        this.maps.putAll(map);
    }

    public String getProviderNameBySerID(long j) {
        Map<Long, String> map = this.maps;
        return (map == null || map.size() <= 0) ? "" : this.maps.get(Long.valueOf(j));
    }

    public BaiduWalletServiceProviderMap() {
        this.maps = new HashMap();
        initMaps();
    }
}
