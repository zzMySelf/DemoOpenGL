package com.baidu.netdisk.account.io.parser;

import android.util.Pair;
import com.baidu.netdisk.BaseApplication;
import com.baidu.netdisk.account.AccountUtils;
import com.baidu.netdisk.account.constant.AccountPersonalConfigKey;
import com.baidu.netdisk.account.io.model.ProductInfo;
import com.baidu.netdisk.account.io.model.ProductInfoListResponse;
import com.baidu.netdisk.account.overduestorage.NoticeProviderHelper;
import com.baidu.netdisk.config.PersonalConfig;
import com.baidu.netdisk.kernel.architecture.debug.NetDiskLog;
import com.baidu.netdisk.network.exception.RemoteException;
import com.baidu.netdisk.network.parser.IApiResultParseable;
import com.baidu.netdisk.network.response.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONException;

public class IsVipParser implements IApiResultParseable<Pair<Integer, String>> {
    public static final String NEW_VIP_CLUSTER = "vipv2";
    private static final String TAG = "IsVipParser";

    public Pair<Integer, String> parse(HttpResponse response) throws JSONException, RemoteException, IOException {
        try {
            String content = response.getContent();
            NetDiskLog.d(TAG, "【Upload-SDK】 content:" + content);
            ProductInfoListResponse infoListResponse = (ProductInfoListResponse) new Gson().fromJson(content, ProductInfoListResponse.class);
            if (infoListResponse != null) {
                NetDiskLog.d(TAG, "【Upload-SDK】 ProductInfolistResponse:" + infoListResponse);
                ArrayList<ProductInfo> infoList = infoListResponse.infoList;
                if (infoList == null) {
                    return new Pair<>(0, (Object) null);
                }
                int higherLevelFinder = 0;
                int maxLevel = 0;
                PersonalConfig.getInstance().putLong(AccountPersonalConfigKey.NEW_VIP_ENDTIME, 0);
                for (int i2 = 0; i2 < infoList.size(); i2++) {
                    ProductInfo info = infoList.get(i2);
                    int level = getLevel(info, infoListResponse.serverCurrentTime);
                    if (level > higherLevelFinder) {
                        higherLevelFinder = level;
                        maxLevel = i2;
                    }
                    if (info.cluster != null && info.cluster.equals(NEW_VIP_CLUSTER) && info.endTime > infoListResponse.serverCurrentTime) {
                        PersonalConfig.getInstance().putLong(AccountPersonalConfigKey.NEW_VIP_ENDTIME, info.endTime);
                    }
                }
                return new Pair<>(Integer.valueOf(higherLevelFinder), infoList.get(maxLevel).getSvipType());
            }
            throw new JSONException("IsVipParser JsonParser is null.");
        } catch (JsonSyntaxException e2) {
            throw new JSONException(e2.getMessage());
        } catch (JsonIOException e3) {
            throw new IOException(e3.getMessage());
        } catch (JsonParseException e4) {
            throw new JSONException(e4.getMessage());
        } catch (IllegalArgumentException e5) {
            throw new JSONException(e5.getMessage());
        }
    }

    public int getLevel(ProductInfo info, long currentTime) {
        boolean z = false;
        if ("vip0".equals(info.productName) || !"vip".equals(info.cluster) || info.endTime < currentTime) {
            return 0;
        }
        int level = "svip".equalsIgnoreCase(info.detailCluster) ? 2 : 1;
        if (2 == level) {
            if (info.endTime > PersonalConfig.getInstance().getLong(AccountPersonalConfigKey.SVIP_ENDTIME, 0)) {
                new NoticeProviderHelper(AccountUtils.getInstance().getBduss()).clearAll(BaseApplication.getInstance());
            }
            PersonalConfig.getInstance().putLong(AccountPersonalConfigKey.SVIP_ENDTIME, info.endTime);
            PersonalConfig instance = PersonalConfig.getInstance();
            if (info.isAutoUpgradeToSVip == 1) {
                z = true;
            }
            instance.putBoolean(AccountPersonalConfigKey.IS_VIP_UPGRADE_TO_SVIP, z);
        } else {
            if (info.endTime > PersonalConfig.getInstance().getLong(AccountPersonalConfigKey.VIP_ENDTIME, 0)) {
                PersonalConfig.getInstance().putLong(AccountPersonalConfigKey.VIP_ENDTIME, info.endTime);
                new NoticeProviderHelper(AccountUtils.getInstance().getBduss()).clearAll(BaseApplication.getInstance());
            }
        }
        PersonalConfig.getInstance().commit();
        return level;
    }
}
