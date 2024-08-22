package com.baidu.sapi2.result;

import com.baidu.sapi2.NoProguard;
import java.util.List;

public class GetPopularPortraitsInfoResult extends SapiResult implements NoProguard {
    public List<PopularPortraitsInfo> popularPortraitsInfoList;

    public static class PopularPortraitsInfo implements NoProguard {
        public String category;
        public String color;
        public String gifUrl;
        public int myItem;
        public int num;
        public String serie;
        public String url;
    }
}
