package com.baidu.searchbox.hotdiscussion.template.hotspot.bigimage;

import com.baidu.searchbox.feed.model.DynamicItemPostData;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.parser.ValidationResult;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class HotDiscussionItemDataBigImage extends DynamicItemPostData {
    public String image;

    public List<String> getPrePicList() {
        List<String> imageList = new ArrayList<>();
        imageList.add(this.image);
        return imageList;
    }

    /* access modifiers changed from: protected */
    public void applyCustomDataJson(JSONObject dataJson) {
        if (dataJson != null) {
            this.image = dataJson.optString("image");
        }
    }

    /* access modifiers changed from: protected */
    public void parseCustomModel2DataJson(JSONObject jsonObject) throws JSONException {
        jsonObject.put("image", this.image);
    }

    public ValidationResult isValidate(FeedBaseModel context) {
        return ValidationResult.ERROR_NONE;
    }
}
