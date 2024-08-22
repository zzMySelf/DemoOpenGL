package com.baidu.searchbox.comment.data;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.comment.statistic.BDCommentStatisticHelper;
import com.baidu.searchbox.video.inf.GoodsModel;
import com.baidu.searchbox.video.inf.ListPanelItemModel;
import com.baidu.searchbox.video.inf.ListPanelModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class CommentTitleMountData {
    private static final String TAG = "CommentTitleMountData";
    private static final String TYPE_TITLE_MOUN_GOODS = "goods";
    public String commentTitleCMD;
    public List<String> describeList;
    public String ext;
    public boolean isCircle;
    public String jumpType;
    public ListPanelModel listPanelModel;
    public List<String> mainBodyList;
    public String titleIcon;
    public CommentTitleTalosLiteData titleTalosLiteData;

    public @interface MountJumpType {
        public static final String TYPE_JUMP_NA = "1";
        public static final String TYPE_JUMP_SCHEME = "0";
    }

    public boolean parse(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jsonObject = new JSONObject(str);
            this.titleIcon = jsonObject.optString("icon");
            this.isCircle = TextUtils.equals(jsonObject.optString("icon_shape"), "1");
            this.commentTitleCMD = jsonObject.optString("scheme");
            this.ext = jsonObject.optString("ext");
            this.jumpType = jsonObject.optString("jump_type");
            JSONArray mainBadyOBJList = jsonObject.optJSONArray("main_body_list");
            if (mainBadyOBJList != null && mainBadyOBJList.length() > 0) {
                this.mainBodyList = new ArrayList();
                for (int i2 = 0; i2 < mainBadyOBJList.length(); i2++) {
                    this.mainBodyList.add(mainBadyOBJList.optString(i2));
                }
            }
            JSONArray describeOBJList = jsonObject.optJSONArray("describe_list");
            if (describeOBJList != null && describeOBJList.length() > 0) {
                this.describeList = new ArrayList();
                for (int i3 = 0; i3 < describeOBJList.length(); i3++) {
                    this.describeList.add(describeOBJList.optString(i3));
                }
            }
            String listPanelString = jsonObject.optString("goods_info");
            if (!TextUtils.isEmpty(listPanelString)) {
                this.listPanelModel = parseListPanelModel(new JSONObject(listPanelString));
            }
            String tittleTalosLite = jsonObject.optString(CommentTitleTalosLiteDataKt.KEY_TITLEBAR_TALOS_LITE);
            if (TextUtils.isEmpty(tittleTalosLite)) {
                return true;
            }
            this.titleTalosLiteData = new CommentTitleTalosLiteData(tittleTalosLite);
            return true;
        } catch (Exception e2) {
            Log.e(TAG, BDCommentStatisticHelper.COMMENT_PARSE, e2);
            return false;
        }
    }

    private ListPanelModel parseListPanelModel(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        ListPanelModel listPanelModel2 = new ListPanelModel();
        listPanelModel2.setTitle(jsonObject.optString("title"));
        listPanelModel2.setSubTitle(jsonObject.optString("subTitle"));
        listPanelModel2.setSubTitleIcon(jsonObject.optString("subTitleIcon"));
        listPanelModel2.setSubTitleIconLandscape(jsonObject.optString("subTitleIconLandScape"));
        listPanelModel2.setSubTitleIconNight(jsonObject.optString("subTitleIconNight"));
        listPanelModel2.setSubTitleCmd(jsonObject.optString("subTitleCmd"));
        JSONArray jsonArray = jsonObject.optJSONArray("list");
        List<ListPanelItemModel<?>> listPanelItemModels = new ArrayList<>();
        if (jsonArray != null) {
            for (int i2 = 0; i2 < jsonArray.length(); i2++) {
                ListPanelItemModel<GoodsModel> itemModel = toListPanelItemModel(jsonArray.optJSONObject(i2));
                itemModel.setPosition(i2);
                listPanelItemModels.add(itemModel);
            }
            listPanelModel2.setList(listPanelItemModels);
        }
        return listPanelModel2;
    }

    private ListPanelItemModel<GoodsModel> toListPanelItemModel(JSONObject itemObj) {
        if (itemObj == null) {
            return new ListPanelItemModel<>();
        }
        String layout = itemObj.optString("layout");
        if (!TextUtils.equals(layout, "goods")) {
            return new ListPanelItemModel<>();
        }
        ListPanelItemModel<GoodsModel> listPanelItemModel = new ListPanelItemModel<>();
        JSONObject goodsDataObj = itemObj.optJSONObject("data");
        listPanelItemModel.setLayout(layout);
        if (goodsDataObj != null) {
            GoodsModel goodsModel = new GoodsModel();
            goodsModel.setGoodsTitle(goodsDataObj.optString("goodsTitle"));
            goodsModel.setGoodsIcon(goodsDataObj.optString("goodsIcon"));
            goodsModel.setGoodsCmd(goodsDataObj.optString("goodsCmd"));
            goodsModel.setGoodsPrice(goodsDataObj.optString("goodsPrice"));
            goodsModel.setGoodsOriginPrice(goodsDataObj.optString("goodsOriginPrice"));
            goodsModel.setGoodsDiscount(goodsDataObj.optString("goodsDiscount"));
            goodsModel.setGoodsSales(goodsDataObj.optString("goodsSales"));
            goodsModel.setGoodsBuy(goodsDataObj.optString("goodsBuy"));
            goodsModel.setGoodsSource(goodsDataObj.optString("goodsSource"));
            goodsModel.setAvailable(TextUtils.equals(goodsDataObj.optString("goodsAvailable"), "1"));
            goodsModel.setGoodsSoldOutToast(goodsDataObj.optString("goodsSoldOutToast"));
            goodsModel.setExt(goodsDataObj.optJSONObject("ext"));
            listPanelItemModel.setData(goodsModel);
        }
        return listPanelItemModel;
    }

    public boolean isDescribeListNull() {
        List<String> list = this.describeList;
        if (list != null && list.size() >= 1) {
            return false;
        }
        return true;
    }

    public boolean isLegalData() {
        List<String> list = this.mainBodyList;
        return list != null && !list.isEmpty() && !TextUtils.isEmpty(this.titleIcon);
    }
}
