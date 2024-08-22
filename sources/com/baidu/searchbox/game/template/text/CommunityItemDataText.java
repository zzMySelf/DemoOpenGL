package com.baidu.searchbox.game.template.text;

import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.parser.ValidationResult;
import com.baidu.searchbox.game.template.model.CommunityItemData;
import com.baidu.searchbox.game.template.model.CommunityItemPostData;
import org.json.JSONObject;

public class CommunityItemDataText extends CommunityItemPostData {
    public CommunityItemData toModel(JSONObject jsonObject) {
        super.parse2Model(jsonObject, this);
        return this;
    }

    public JSONObject toJson() {
        return super.toJson();
    }

    public ValidationResult isValidate(FeedBaseModel context) {
        return super.isValidate(context);
    }
}
