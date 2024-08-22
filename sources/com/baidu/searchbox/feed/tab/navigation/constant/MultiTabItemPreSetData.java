package com.baidu.searchbox.feed.tab.navigation.constant;

import android.util.SparseArray;
import androidx.core.util.Pair;
import com.baidu.searchbox.feed.abtest.FeedAbtestManager;
import com.baidu.searchbox.feed.controller.FeedDataManager;
import com.baidu.searchbox.feed.tab.navigation.pbfile.MultiTabItemDataProto;
import com.baidu.searchbox.feed.tab.navigation.utils.AudioAlbumBubbleManager;
import com.baidu.searchbox.feed.tab.update.MultiTabItemInfo;
import com.baidu.searchbox.home.tabs.HomeTabTextHolder;
import com.baidu.searchbox.search.tab.utils.SearchVideoTcUtils;
import com.baidu.searchbox.sport.model.TabInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MultiTabItemPreSetData {
    public static final String HOT_CHILD_TAB = "{\"infos\":{\"font_color\":\"#FF525252\",\"dark_font_color\":\"#CCFFFFFF\",\"night_font_color\":\"#FF666666\",\"bg_color\":\"#FFF5F5F5\",\"dark_bg_color\":\"#FF222222\",\"night_bg_color\":\"#FF121212\",\"selected_color\":\"#FFFF4D04\",\"dark_selected_color\":\"#FFFF4D04\",\"night_selected_color\":\"#FF803300\",\"selected_bg_color\":\"#0DFF4D04\",\"dark_selected_bg_color\":\"#26FF4D04\",\"night_selected_bg_color\":\"#26FF4D04\",\"default_tab\":\"8\"},\"tabs\":[{\"id\":\"8\",\"name\":\"热搜榜\",\"canTTS\":\"1\",\"can_cache\":\"0\",\"lottie_name\":\"\",\"url\":\"\",\"type\":\"child_list\"},{\"id\":\"3888366610\",\"name\":\"小说榜\",\"canTTS\":\"0\",\"can_cache\":\"0\",\"lottie_name\":\"\",\"url\":\"\",\"type\":\"child_list\"},{\"id\":\"3888366611\",\"name\":\"电影榜\",\"canTTS\":\"0\",\"can_cache\":\"0\",\"lottie_name\":\"\",\"url\":\"\",\"type\":\"child_list\"},{\"id\":\"3888366612\",\"name\":\"电视剧榜\",\"canTTS\":\"0\",\"can_cache\":\"0\",\"lottie_name\":\"\",\"url\":\"\",\"type\":\"child_list\"},{\"id\":\"3888366616\",\"name\":\"汽车榜\",\"canTTS\":\"0\",\"can_cache\":\"0\",\"lottie_name\":\"\",\"url\":\"\",\"type\":\"child_list\"},{\"id\":\"3888366617\",\"name\":\"游戏榜\",\"canTTS\":\"0\",\"can_cache\":\"0\",\"lottie_name\":\"\",\"url\":\"\",\"type\":\"child_list\"}],\"default_tab\":\"8\"}";
    private static final String SN_BUNDLE_TYPE = "multi";
    public static final int TYPE_FORCE_INSERT_ADDED = 0;
    public static final int TYPE_FORCE_INSERT_UNADDED = 1;
    private static Set ttsBlackSet;

    static {
        HashSet hashSet = new HashSet();
        ttsBlackSet = hashSet;
        hashSet.add("32");
        ttsBlackSet.add("33");
        ttsBlackSet.add("27");
        ttsBlackSet.add("12");
        ttsBlackSet.add("2");
        ttsBlackSet.add("41");
        ttsBlackSet.add("25");
        ttsBlackSet.add(AudioAlbumBubbleManager.AUDIO_TAB_ID);
        ttsBlackSet.add("28");
    }

    public static MultiTabItemDataProto.MultiTabItemDataList getAddedTabData() {
        MultiTabItemDataProto.MultiTabItemData attentionTab = MultiTabItemDataProto.MultiTabItemData.newBuilder().setId("58").setName("关注").setBundleId("box.rnplugin.feedsn").setModuleName("FeedSnFeedfollow").setCanDelete("0").setBundleType("multi").build();
        MultiTabItemDataProto.MultiTabItemData mainTab = MultiTabItemDataProto.MultiTabItemData.newBuilder().setId("1").setName("推荐").setCanDelete("0").setCanDegrade("1").build();
        MultiTabItemDataProto.MultiTabItemData hotPointTab = MultiTabItemDataProto.MultiTabItemData.newBuilder().setId("8").setName("热搜").setIsNewTip("0").setChildTabInfo(HOT_CHILD_TAB).setType(MultiTabItemInfo.TYPE_SEGMENTED_LIST).setCanDelete("1").setTabType("1").build();
        MultiTabItemDataProto.MultiTabItemData videoTab = MultiTabItemDataProto.MultiTabItemData.newBuilder().setId("2").setName(HomeTabTextHolder.VIDEO_TAB_TEXT).setIsNewTip("0").setCanDelete("1").setCanDegrade("1").setTabType("1").build();
        MultiTabItemDataProto.MultiTabItemDataList.Builder builder = MultiTabItemDataProto.MultiTabItemDataList.newBuilder().addMultiTabItemData(attentionTab).addMultiTabItemData(mainTab).addMultiTabItemData(MultiTabItemDataProto.MultiTabItemData.newBuilder().setId("178").setName("发现").setIsNewTip("0").setCanDelete("1").setCanDegrade("1").setType(MultiTabItemInfo.TYPE_DUAL_LIST).setTabType("1").build());
        if (FeedAbtestManager.getDefaultVideoTabSwitch()) {
            builder.addMultiTabItemData(videoTab);
        }
        builder.addMultiTabItemData(hotPointTab);
        return builder.build();
    }

    public static MultiTabItemDataProto.MultiTabItemDataList getUnAddedTabData() {
        return getNewUnAddedTabData();
    }

    private static MultiTabItemDataProto.MultiTabItemDataList getNewUnAddedTabData() {
        MultiTabItemDataProto.MultiTabItemData novelTab = MultiTabItemDataProto.MultiTabItemData.newBuilder().setId("32").setName(HomeTabTextHolder.NOVEL_TAB_TEXT).setBundleId("box.rnplugin.feedsn").setModuleName("FeedSnNovel").setCanDelete("1").setCanDegrade("1").setUrl("https://boxnovel.baidu.com/boxnovel/homepage?data=%7B%22fromaction%22%3A%22feedtabnovel%22%7D").setTabType("1").build();
        MultiTabItemDataProto.MultiTabItemData liveTab = MultiTabItemDataProto.MultiTabItemData.newBuilder().setId(TabInfo.ID_PLAYER_INFO).setName("直播").setIsNewTip("0").setCanDelete("1").setCanDegrade("1").setCanTTS("0").setNaView("baiduboxapp://feedTab/live/createTab?params=%7B%22tab%22%3A%22feedtab_live%22%2C%22tab_id%22%3A%2240%22%7D").setTabType("1").build();
        MultiTabItemDataProto.MultiTabItemData jokeTab = MultiTabItemDataProto.MultiTabItemData.newBuilder().setId("28").setName("搞笑").setBundleId("box.rnplugin.feedsn").setModuleName("FeedSnFeedtab").setBundleType("multi").setIsNewTip("0").setCanDelete("1").setCanDegrade("1").setTabType("2").build();
        MultiTabItemDataProto.MultiTabItemData videoTab = MultiTabItemDataProto.MultiTabItemData.newBuilder().setId("144").setName("影视").setBundleId("box.rnplugin.feedsn").setModuleName("FeedSnVideo").setBundleType("multi").setIsNewTip("0").setCanDelete("1").setCanDegrade("1").setCanTTS("1").setTabType("2").build();
        MultiTabItemDataProto.MultiTabItemData gameTab = MultiTabItemDataProto.MultiTabItemData.newBuilder().setId("16").setName("游戏").setBundleId("box.rnplugin.feedsn").setModuleName("FeedSnFeedtab").setBundleType("multi").setIsNewTip("0").setCanDelete("1").setCanDegrade("1").setTabType("2").build();
        MultiTabItemDataProto.MultiTabItemData funnyTab = MultiTabItemDataProto.MultiTabItemData.newBuilder().setId("3").setName("娱乐").setBundleId("box.rnplugin.feedsn").setModuleName("FeedSnFeedtab").setBundleType("multi").setIsNewTip("0").setCanDelete("1").setCanDegrade("1").setTabType("2").build();
        MultiTabItemDataProto.MultiTabItemData shoppingTab = MultiTabItemDataProto.MultiTabItemData.newBuilder().setId("163").setName("购物").setIsNewTip("0").setCanDelete("1").setCanDegrade("0").setCanTTS("0").setBundleId("box.rnplugin.feedsn").setModuleName("SearchDuhuasuan").setBundleType("multi").setTabType("4").build();
        MultiTabItemDataProto.MultiTabItemData fitnessTab = MultiTabItemDataProto.MultiTabItemData.newBuilder().setId("51").setName("健康").setBundleId("box.rnplugin.feedsn").setModuleName("FeedSnFeedtab").setBundleType("multi").setIsNewTip("0").setCanDelete("1").setCanDegrade("1").setCanTTS("1").setTabType("4").build();
        MultiTabItemDataProto.MultiTabItemData bodyBuildingTabs = MultiTabItemDataProto.MultiTabItemData.newBuilder().setId("139").setName("健身").setBundleId("box.rnplugin.feedsn").setModuleName("FeedSnFeedtab").setBundleType("multi").setIsNewTip("0").setCanDelete("1").setCanDegrade("1").setCanTTS("0").setTabType("4").build();
        MultiTabItemDataProto.MultiTabItemData financeTab = MultiTabItemDataProto.MultiTabItemData.newBuilder().setId("15").setName("财经").setBundleId("box.rnplugin.feedsn").setModuleName("FeedSnFeedtab").setBundleType("multi").setIsNewTip("0").setCanDelete("1").setCanDegrade("1").setCanTTS("1").setTabType("5").build();
        MultiTabItemDataProto.MultiTabItemData fitnessTab2 = fitnessTab;
        MultiTabItemDataProto.MultiTabItemData carTab = MultiTabItemDataProto.MultiTabItemData.newBuilder().setId("12").setName("汽车").setBundleId("box.rnplugin.feedsn").setModuleName("FeedSnFeedtab").setBundleType("multi").setIsNewTip("0").setCanDelete("1").setCanDegrade("1").setCanTTS("1").setTabType("5").build();
        MultiTabItemDataProto.MultiTabItemData housePropertyTab = MultiTabItemDataProto.MultiTabItemData.newBuilder().setId("138").setName("房产").setBundleId("box.rnplugin.feedsn").setModuleName("FeedSnFeedtab").setBundleType("multi").setIsNewTip("0").setCanDelete("1").setCanDegrade("1").setCanTTS("1").setTabType("5").build();
        MultiTabItemDataProto.MultiTabItemData sportTab = MultiTabItemDataProto.MultiTabItemData.newBuilder().setId("4").setName("体育").setBundleId("box.rnplugin.feedsn").setModuleName("FeedSnFeedtab").setBundleType("multi").setIsNewTip("0").setCanDelete("1").setCanDegrade("1").setTabType("5").build();
        MultiTabItemDataProto.MultiTabItemData educationTab = MultiTabItemDataProto.MultiTabItemData.newBuilder().setId(FeedDataManager.FEED_GAOKAO_TAB_ID).setName("教育").setBundleId("box.rnplugin.feedsn").setModuleName("FeedSnFeedtab").setBundleType("multi").setIsNewTip("0").setCanDelete("1").setCanDegrade("0").setCanTTS("1").setTabType("6").build();
        MultiTabItemDataProto.MultiTabItemData housePropertyTab2 = housePropertyTab;
        MultiTabItemDataProto.MultiTabItemData scienceTab = MultiTabItemDataProto.MultiTabItemData.newBuilder().setId("14").setName("科技").setBundleId("box.rnplugin.feedsn").setModuleName("FeedSnFeedtab").setBundleType("multi").setIsNewTip("0").setCanDelete("1").setCanDegrade("1").setCanTTS("1").setTabType("6").build();
        MultiTabItemDataProto.MultiTabItemData historyTab = MultiTabItemDataProto.MultiTabItemData.newBuilder().setId("18").setName("历史").setBundleId("box.rnplugin.feedsn").setModuleName("FeedSnFeedtab").setBundleType("multi").setIsNewTip("0").setCanDelete("1").setCanDegrade("1").setCanTTS("1").setTabType("6").build();
        MultiTabItemDataProto.MultiTabItemData digitTab = MultiTabItemDataProto.MultiTabItemData.newBuilder().setId("142").setName("数码").setBundleId("box.rnplugin.feedsn").setModuleName("FeedSnFeedtab").setBundleType("multi").setIsNewTip("0").setCanDelete("1").setCanDegrade("1").setCanTTS("1").setTabType("6").build();
        MultiTabItemDataProto.MultiTabItemData internationalTab = MultiTabItemDataProto.MultiTabItemData.newBuilder().setId("6").setName("国际").setBundleId("box.rnplugin.feedsn").setModuleName("FeedSnFeedtab").setBundleType("multi").setIsNewTip("0").setCanDelete("1").setCanDegrade("1").setCanTTS("1").setTabType("7").build();
        MultiTabItemDataProto.MultiTabItemData digitTab2 = digitTab;
        MultiTabItemDataProto.MultiTabItemData militaryTab = MultiTabItemDataProto.MultiTabItemData.newBuilder().setId("13").setName("军事").setBundleId("box.rnplugin.feedsn").setModuleName("FeedSnFeedtab").setBundleType("multi").setIsNewTip("0").setCanDelete("1").setCanDegrade("1").setCanTTS("1").setTabType("7").build();
        MultiTabItemDataProto.MultiTabItemData importantNewsTab = MultiTabItemDataProto.MultiTabItemData.newBuilder().setId("166").setName("要闻").setBundleId("box.rnplugin.feedsn").setModuleName("FeedSnFeedtab").setBundleType("multi").setIsNewTip("0").setCanDelete("1").setCanDegrade("0").setCanTTS("1").setTabType("7").build();
        MultiTabItemDataProto.MultiTabItemData newEraTab = MultiTabItemDataProto.MultiTabItemData.newBuilder().setId(SearchVideoTcUtils.CST_55).setName("新时代").setBundleId("box.rnplugin.feedsn").setModuleName("FeedSnFeedtab").setBundleType("multi").setIsNewTip("0").setCanDelete("1").setCanDegrade("1").setCanTTS("1").setTabType("7").build();
        MultiTabItemDataProto.MultiTabItemData pictureTab = MultiTabItemDataProto.MultiTabItemData.newBuilder().setId("7").setName("图片").setBundleId("box.rnplugin.feedsn").setModuleName("FeedSnFeedtab").setBundleType("multi").setIsNewTip("0").setCanDelete("1").setCanDegrade("1").setCanTTS("1").setTabType(TabNavConstant.CLASSIFY_TAB_TYPE_OTHER).build();
        MultiTabItemDataProto.MultiTabItemData easyStudyTab = MultiTabItemDataProto.MultiTabItemData.newBuilder().setId("150").setName("轻松学").setBundleId("box.rnplugin.feedsn").setModuleName("FeedSnEasyStudy").setBundleType("multi").setIsNewTip("0").setCanDelete("1").setCanDegrade("1").setCanTTS("0").setTabType(TabNavConstant.CLASSIFY_TAB_TYPE_OTHER).build();
        MultiTabItemDataProto.MultiTabItemDataList.Builder builder = MultiTabItemDataProto.MultiTabItemDataList.newBuilder();
        builder.addMultiTabItemData(novelTab);
        builder.addMultiTabItemData(liveTab);
        builder.addMultiTabItemData(funnyTab);
        builder.addMultiTabItemData(jokeTab);
        builder.addMultiTabItemData(videoTab);
        builder.addMultiTabItemData(gameTab);
        builder.addMultiTabItemData(shoppingTab);
        builder.addMultiTabItemData(fitnessTab2);
        builder.addMultiTabItemData(bodyBuildingTabs);
        builder.addMultiTabItemData(MultiTabItemDataProto.MultiTabItemData.newBuilder().setId("116").setName("亲子").setBundleId("box.rnplugin.feedsn").setModuleName("FeedSnFeedtab").setBundleType("multi").setIsNewTip("0").setCanDelete("1").setCanDegrade("1").setCanTTS("0").setTabType("4").build());
        builder.addMultiTabItemData(sportTab);
        builder.addMultiTabItemData(financeTab);
        builder.addMultiTabItemData(carTab);
        MultiTabItemDataProto.MultiTabItemData multiTabItemData = novelTab;
        builder.addMultiTabItemData(housePropertyTab2);
        builder.addMultiTabItemData(educationTab);
        builder.addMultiTabItemData(scienceTab);
        builder.addMultiTabItemData(historyTab);
        builder.addMultiTabItemData(digitTab2);
        builder.addMultiTabItemData(internationalTab);
        builder.addMultiTabItemData(militaryTab);
        builder.addMultiTabItemData(importantNewsTab);
        builder.addMultiTabItemData(newEraTab);
        builder.addMultiTabItemData(pictureTab);
        builder.addMultiTabItemData(MultiTabItemDataProto.MultiTabItemData.newBuilder().setId("27").setName("问答").setBundleId("box.rnplugin.feedsn").setModuleName("FeedSnQa").setBundleType("multi").setIsNewTip("0").setCanDelete("1").setCanDegrade("1").setCanTTS("1").setTabType(TabNavConstant.CLASSIFY_TAB_TYPE_OTHER).build());
        builder.addMultiTabItemData(easyStudyTab);
        return builder.build();
    }

    public static List<MultiTabItemInfo> getForceOffLineTabData() {
        List<MultiTabItemInfo> forceOffLineTabs = new ArrayList<>(1);
        MultiTabItemInfo videoInfo = new MultiTabItemInfo();
        videoInfo.mId = "2";
        videoInfo.mTitle = HomeTabTextHolder.VIDEO_TAB_TEXT;
        videoInfo.isNewTip = false;
        videoInfo.canDelete = true;
        MultiTabItemInfo novelInfo = new MultiTabItemInfo();
        novelInfo.mId = "32";
        novelInfo.mTitle = HomeTabTextHolder.NOVEL_TAB_TEXT;
        novelInfo.mBundleId = "box.rnplugin.feedsn";
        novelInfo.mModuleName = "FeedSnNovel";
        novelInfo.isNewTip = false;
        novelInfo.canDelete = true;
        forceOffLineTabs.add(videoInfo);
        forceOffLineTabs.add(novelInfo);
        return forceOffLineTabs;
    }

    public static SparseArray<List<Pair<Integer, MultiTabItemInfo>>> getForceInsertTabData() {
        SparseArray<List<Pair<Integer, MultiTabItemInfo>>> inserts = new SparseArray<>(2);
        List<Pair<Integer, MultiTabItemInfo>> forceInsertAddTabs = new ArrayList<>(2);
        List<Pair<Integer, MultiTabItemInfo>> forceInsertUnAddTabs = new ArrayList<>(0);
        MultiTabItemInfo novelInfo = new MultiTabItemInfo();
        novelInfo.mId = "32";
        novelInfo.mTitle = HomeTabTextHolder.NOVEL_TAB_TEXT;
        novelInfo.mBundleId = "box.rnplugin.feedsn";
        novelInfo.mModuleName = "FeedSnNovel";
        novelInfo.isNewTip = false;
        novelInfo.canDelete = true;
        forceInsertAddTabs.add(new Pair(2, novelInfo));
        inserts.put(0, forceInsertAddTabs);
        inserts.put(1, forceInsertUnAddTabs);
        return inserts;
    }

    public static String getDefaultTabId() {
        return "1";
    }

    public static boolean isTTSInBlackList(String tabId) {
        return ttsBlackSet.contains(tabId);
    }

    static final class TabId {
        static final String ATTENTION_ID = "58";
        static final String AUDIO_TAB_ID = "125";
        static final String BABY_TAB_ID = "116";
        static final String BODYBUILDING_TAB_ID = "139";
        static final String CAR_TAB_ID = "12";
        static final String CHOIDCENESS_TAB_ID = "123";
        static final String COMIC_TAB_ID = "33";
        static final String DIGIT_TAB_ID = "142";
        static final String DISCOVERY_TAB_ID = "178";
        static final String EASY_STUDY_TAB_ID = "150";
        static final String EDUCATION_TAB_ID = "137";
        static final String EMOTION_TAB_ID = "35";
        static final String FASHION_TAB_ID = "5";
        static final String FINANCE_TAB_ID = "15";
        static final String FITNESS_TAB_ID = "51";
        static final String FOOD_TAB_ID = "34";
        static final String FUNNY_TAB_ID = "3";
        static final String GAME_TAB_ID = "16";
        static final String GOVERNMENT_TAB_ID = "42";
        static final String HISTORY_TAB_ID = "18";
        static final String HOME_TAB_ID = "41";
        static final String HOT_POINT_TAB_ID = "8";
        static final String HOUSE_PROPERTY_TAB_ID = "138";
        static final String IMPORTANT_NEWS_TAB_ID = "166";
        static final String INTERNATIONAL_TAB_ID = "6";
        static final String JOKE_TAB_ID = "28";
        static final String LIVE_TAB_ID = "40";
        static final String MAIN_TAB_ID = "1";
        static final String MILITARY_TAB_ID = "13";
        static final String MOVIE_TAB_ID = "144";
        static final String NEW_ERA_TAB_ID = "55";
        static final String NOVEL_TAB_ID = "32";
        static final String PICTURE_TAB_ID = "7";
        static final String QA_TAB_ID = "27";
        static final String REFUTE_SLANDERS_TAB_ID = "44";
        static final String SCIENCE_TAB_ID = "14";
        static final String SHOPPING_TAB_ID = "163";
        static final String SPORT_TAB_ID = "4";
        static final String TRAVEL_TAB_ID = "43";
        static final String VIDEO_TAB_ID = "2";

        TabId() {
        }
    }

    private static final class TabTitle {
        static final String ATTETION_NAME = "关注";
        static final String AUDIO_TAB_NAME = "好听";
        static final String BABY_TAB_NAME = "亲子";
        static final String BODYBUILDING_TAB_NAME = "健身";
        static final String CAR_TAB_NAME = "汽车";
        static final String CHOICENESS_TAB_NAME = "精选";
        static final String DIGIT_TAB_NAME = "数码";
        static final String DISCOVERY_TAB_NAME = "发现";
        static final String EASY_STUDY_TAB_NAME = "轻松学";
        static final String EDUCATION_TAB_NAME = "教育";
        static final String EMOTION_TAB_NAME = "情感";
        static final String FASHION_TAB_NAME = "时尚";
        static final String FINANCE_TAB_NAME = "财经";
        static final String FITNESS_TAB_NAME = "健康";
        static final String FOOD_TAB_NAME = "美食";
        static final String FUNNY_TAB_NAME = "娱乐";
        static final String GAME_TAB_NAME = "游戏";
        static final String GOVERNMENT_TAB_NAME = "政务";
        static final String HISTORY_TAB_NAME = "历史";
        static final String HOME_TAB_NAME = "家居";
        static final String HOT_POINT_TAB_NAME = "热搜";
        static final String HOUSE_PROPERTY_TAB_NAME = "房产";
        static final String IMPORTANT_NEWS_TAB_NAME = "要闻";
        static final String INTERNATIONAL_TAB_NAME = "国际";
        static final String JOKE_TAB_NAME = "搞笑";
        static final String LIVE_TAB_NAME = "直播";
        static final String MAIN_TAB_NAME = "推荐";
        static final String MILITARY_TAB_NAME = "军事";
        static final String MOVIE_TAB_NAME = "影视";
        static final String NEW_ERA_TAB_NAME = "新时代";
        static final String NOVEL_TAB_NAME = "小说";
        static final String PICTURE_TAB_NAME = "图片";
        static final String QA_TAB_NAME = "问答";
        static final String REFUTE_SLANDERS_TAB_NAME = "辟谣";
        static final String SCIENCE_TAB_NAME = "科技";
        static final String SHOPPING_TAB_NAME = "购物";
        static final String SPORT_TAB_NAME = "体育";
        static final String TRAVEL_TAB_NAME = "旅游";
        static final String VIDEO_TAB_NAME = "视频";

        private TabTitle() {
        }
    }

    private static final class RNBundleId {
        public static final String SN_BUNDLE_ID = "box.rnplugin.feedsn";
        public static final String SN_SHOP_BUNDLE_ID = "box.rnplugin.feedsn";

        private RNBundleId() {
        }
    }

    private static final class RNModuleName {
        static final String ATTENTION = "FeedSnFeedfollow";
        static final String EASY_STUDY_MODULE_NAME = "FeedSnEasyStudy";
        static final String FASHION_MODULE_NAME = "FeedSnFeedtabFashion";
        static final String HAO_TING = "FeedSnHaoting";
        static final String NOVEL_MODULE_NAME = "FeedSnNovel";
        static final String QA_MODULE_NAME = "FeedSnQa";
        static final String SHOP = "SearchDuhuasuan";
        static final String SN_COMMON_MODULE_NAME = "FeedSnFeedtab";
        static final String VIDEO_MODULE_NAME = "FeedSnVideo";

        private RNModuleName() {
        }
    }

    private static final class NAView {
        static final String AIRADIO = "native://airadio";
        static final String JOKE = "baiduboxapp://feedTab/moment/createTab?params=%7b%22tab%22%3a%22feedtab_moment%22%2c%22tab_id%22%3a%2228%22%2c%22source%22%3a%22gaoxiao%22%7d";

        private NAView() {
        }
    }

    private static final class DegradeUrl {
        static final String NOVEL_URL = "https://boxnovel.baidu.com/boxnovel/homepage?data=%7B%22fromaction%22%3A%22feedtabnovel%22%7D";

        private DegradeUrl() {
        }
    }
}
