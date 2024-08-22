package com.baidu.searchbox.discovery.picture.scheme;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.netdisk.transfer.storage.db.TransferContract;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.search.basic.statistic.SearchNovelUbcManagerKt;
import com.baidu.searchbox.discovery.picture.utils.Utils;
import com.baidu.searchbox.music.ext.statistic.MusicExtStats;
import com.baidu.searchbox.picture.PictureBrowserManager;
import com.baidu.searchbox.picture.model.LightPictureUgcModel;
import com.baidu.searchbox.picture.model.PictureInfo;
import com.baidu.searchbox.picture.params.LaunchParams;
import com.baidu.searchbox.preview.ImagePreviewActivity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.video.feedflow.tab.wealth.statistics.WealthTaskUbcConstantKt;
import com.baidu.share.core.BdShareConstants;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class PictureBrowserActionHandle {
    private static final String KEY_PARAMS = "params";
    private static final String LIKE_STATUS = "1";
    private static final String SHOW_RECOMMEND = "1";
    private static final String STATE_FOLD = "1";

    public void handleOpenMultiAlbum(Context context, UnitedSchemeEntity entity) {
        String scheme;
        String param;
        String btnTitle;
        int clickIndex;
        String invokeSource;
        boolean z;
        JSONObject joComment;
        HashMap<String, String> map = entity.getParams();
        String param2 = map.remove("params");
        try {
            JSONObject jo = new JSONObject(param2);
            String nid = jo.optString("nid");
            JSONArray imageList = jo.optJSONArray(ImagePreviewActivity.INTENT_KEY_IMAGE_LIST);
            JSONObject joAuthor = jo.optJSONObject("author");
            String contentText = jo.optString("text");
            String contentCmd = jo.optString("cmd");
            JSONObject joLike = jo.optJSONObject("like");
            String foldState = jo.optString("foldstate", "1");
            String ext = jo.optString("ext");
            HashMap<String, String> hashMap = map;
            JSONObject copyright = jo.optJSONObject("copyright");
            if (copyright != null) {
                try {
                    String btnTitle2 = copyright.optString("btntitle");
                    String des = copyright.optString("des");
                    JSONObject jSONObject = copyright;
                    btnTitle = btnTitle2;
                    scheme = copyright.optString("scheme");
                    String btnTitle3 = param2;
                    param = des;
                } catch (Exception e2) {
                    e = e2;
                    Context context2 = context;
                    String str = param2;
                    e.printStackTrace();
                }
            } else {
                JSONObject jSONObject2 = copyright;
                btnTitle = null;
                scheme = null;
                String btnTitle4 = param2;
                param = null;
            }
            try {
                boolean showRecommend = "1".equals(jo.optString(MusicExtStats.VALUE_SONGS_RECOMMEND_SHOW));
                try {
                    clickIndex = Integer.parseInt(jo.optString("click_index"));
                } catch (Exception e3) {
                    e3.printStackTrace();
                    clickIndex = 0;
                }
                String des2 = param;
                String invokeSource2 = jo.optString(WealthTaskUbcConstantKt.UBC_EXT_KEY_INVOKE_SOURCE);
                PictureBrowserManager manager = (PictureBrowserManager) ServiceManager.getService(PictureBrowserManager.SERVICE_REFERENCE);
                String btnTitle5 = btnTitle;
                LightPictureUgcModel ugcModel = new LightPictureUgcModel();
                ugcModel.nid = nid;
                String str2 = nid;
                if (joLike != null) {
                    invokeSource = invokeSource2;
                    ugcModel.likeStatus = "1".equals(joLike.optString("type"));
                    ugcModel.likeNumber = joLike.optString("count");
                    ugcModel.likeExt = joLike.optString("ext");
                    ugcModel.isHeartPraise = joLike.optBoolean("is_heart");
                } else {
                    invokeSource = invokeSource2;
                }
                if (joAuthor != null) {
                    ugcModel.bjhId = joAuthor.optString("id");
                    ugcModel.bjhName = joAuthor.optString("name");
                    ugcModel.bjhIcon = joAuthor.optString("icon");
                    ugcModel.bjhCmd = joAuthor.optString("cmd");
                }
                ugcModel.contentText = contentText;
                ugcModel.contentCmd = contentCmd;
                ugcModel.ext = ext;
                ugcModel.foldState = "1".equals(foldState);
                JSONObject joComment2 = jo.optJSONObject("comment");
                if (joComment2 != null) {
                    ugcModel.commentNum = joComment2.optString("count");
                    ugcModel.commentCmd = joComment2.optString("cmd");
                }
                if (imageList == null || imageList.length() <= 0) {
                } else {
                    ugcModel.lightPicInfoList = new ArrayList<>();
                    int i2 = 0;
                    while (i2 < imageList.length()) {
                        PictureInfo pictureInfo = new PictureInfo();
                        JSONObject joItem = imageList.optJSONObject(i2);
                        if (joItem != null) {
                            pictureInfo.mUrl = joItem.optString("url");
                            pictureInfo.mOriginUrl = joItem.optString(SearchNovelUbcManagerKt.EXT_ORIGIN_URL);
                            joComment = joComment2;
                            pictureInfo.mOriginSize = Utils.convertStringToIntSafe(joItem.optString(TransferContract.DownloadSmoothVideoTasksColumns.ORIGIN_SIZE), 0);
                        } else {
                            joComment = joComment2;
                        }
                        pictureInfo.nid = ugcModel.nid;
                        pictureInfo.pos = i2;
                        pictureInfo.posInData = i2;
                        pictureInfo.count = imageList.length();
                        pictureInfo.index = 0;
                        ugcModel.lightPicInfoList.add(pictureInfo);
                        i2++;
                        joComment2 = joComment;
                    }
                }
                JSONObject joShare = jo.optJSONObject("share_data");
                if (joShare != null) {
                    ugcModel.shareTitle = joShare.optString("title");
                    ugcModel.shareContent = joShare.optString("text");
                    ugcModel.shareUrl = joShare.optString(BdShareConstants.KEY_URL);
                }
                PictureBrowserManager manager2 = manager;
                manager2.initPictureInstanceFlow(ugcModel.nid);
                String btnTitle6 = btnTitle5;
                JSONObject jSONObject3 = joShare;
                String des3 = des2;
                LightPictureUgcModel lightPictureUgcModel = ugcModel;
                String scheme2 = scheme;
                LaunchParams.Builder scheme3 = new LaunchParams.Builder().setUgcModel(ugcModel).setIndex(clickIndex).setShowRecommend(showRecommend).setPictureInfoList(ugcModel.lightPicInfoList).setType(LaunchParams.TYPE_UGC_IMMERSIVE).setSource(invokeSource).setExtLog(ext).setBtnTitle(btnTitle6).setDes(des3).setScheme(scheme2);
                if (TextUtils.isEmpty(btnTitle6) || TextUtils.isEmpty(des3) || TextUtils.isEmpty(scheme2)) {
                    int i3 = clickIndex;
                    z = false;
                } else {
                    int i4 = clickIndex;
                    z = true;
                }
                try {
                    manager2.open(context, scheme3.setIsPaySubscribe(z).build());
                } catch (Exception e4) {
                    e = e4;
                }
            } catch (Exception e5) {
                e = e5;
                Context context3 = context;
                e.printStackTrace();
            }
        } catch (Exception e6) {
            e = e6;
            Context context4 = context;
            HashMap<String, String> hashMap2 = map;
            String str3 = param2;
            e.printStackTrace();
        }
    }
}
