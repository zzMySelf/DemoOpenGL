package com.baidu.android.imsdk.internal;

import android.content.Context;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;

public class IMConfigInternal {
    private static final String TAG = IMConfigInternal.class.getSimpleName();
    private static IMConfigInternal sConfig;
    private IIMConfig mConfig;

    public static IMConfigInternal getInstance() {
        synchronized (IMConfigInternal.class) {
            if (sConfig == null) {
                sConfig = new IMConfigInternal();
            }
        }
        return sConfig;
    }

    public boolean setProductLine(Context context, int pl) {
        Utility.writeIntData(context, "product_line", pl);
        return true;
    }

    public IIMConfig getIMConfig(Context context) {
        String className;
        if (this.mConfig == null) {
            synchronized (IMConfigInternal.class) {
                if (this.mConfig == null) {
                    switch (getProductLine(context)) {
                        case 1:
                            className = "com.baidu.android.imsdk.internal.DefaultConfig";
                            break;
                        case 3:
                            className = "com.baidu.android.imsdk.box.BoxConfig";
                            break;
                        default:
                            className = "com.baidu.android.imsdk.internal.DefaultConfig";
                            break;
                    }
                    IIMConfig createConfig = createConfig(context, className);
                    this.mConfig = createConfig;
                    if (createConfig == null) {
                        this.mConfig = new DefaultConfig();
                    }
                }
            }
        }
        return this.mConfig;
    }

    private IIMConfig createConfig(Context context, String className) {
        try {
            Class<?> classForName = Class.forName(className);
            if (classForName != null) {
                try {
                    return (IIMConfig) classForName.newInstance();
                } catch (Exception e2) {
                    LogUtils.d(TAG, "Product line of jar is ERROR!");
                }
            }
            LogUtils.d(TAG, "Init ERROR!");
            return null;
        } catch (ClassNotFoundException e3) {
            LogUtils.d(TAG, "Product line of jar is ERROR!");
            return null;
        }
    }

    public int getProductLine(Context context) {
        if (context == null) {
            return 1;
        }
        int productLine = Utility.readIntData(context, "product_line", 1);
        if (productLine == 3 || productLine == 1 || productLine == 6 || productLine == 4) {
            return productLine;
        }
        return 1;
    }

    public int getSDKVersionValue(Context context) {
        try {
            int pl = getProductLine(context);
            return Integer.valueOf("1305" + String.format("%03d", new Object[]{Integer.valueOf(pl)}) + "6").intValue();
        } catch (Exception e2) {
            return 0;
        }
    }
}
