package com.baidu.taskmanager.recognizers;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class SchemeRecognizers {
    private static volatile SchemeRecognizers sInstance;
    List<IBusinessRecognizer> mRecognizers;

    private SchemeRecognizers() {
        ArrayList arrayList = new ArrayList();
        this.mRecognizers = arrayList;
        arrayList.add(new SwanSchemeRecognizer());
    }

    public static SchemeRecognizers getInstance() {
        if (sInstance == null) {
            synchronized (SchemeRecognizers.class) {
                if (sInstance == null) {
                    sInstance = new SchemeRecognizers();
                }
            }
        }
        return sInstance;
    }

    public String recognize(String scheme) {
        String businessId = null;
        for (IBusinessRecognizer recognizer : this.mRecognizers) {
            businessId = recognizer.recognize(scheme);
            if (!TextUtils.isEmpty(businessId)) {
                break;
            }
        }
        return businessId;
    }
}
