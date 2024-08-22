package com.baidu.searchbox.socialshare.baidu;

import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;

public class BDWebPageObject implements BDMediaObject {
    private String mContent;
    private String mIconUrl;
    private String mLinkUrl;
    private int mMsgType;
    private byte[] mThumbImage;
    private String mTitle;

    public BDWebPageObject(String title, String content, String iconUrl, String linkUrl, byte[] thumbImage, int msgType) {
        this.mTitle = title;
        this.mContent = content;
        this.mIconUrl = iconUrl;
        this.mLinkUrl = linkUrl;
        this.mThumbImage = thumbImage;
        this.mMsgType = msgType;
    }

    public Bundle toBundle() {
        Bundle data = new Bundle();
        data.putString("title", this.mTitle);
        data.putString("content", this.mContent);
        data.putString("icon_url", this.mIconUrl);
        data.putString("link_url", this.mLinkUrl);
        data.putByteArray("thumb_data", this.mThumbImage);
        data.putInt("msg_type", this.mMsgType);
        return data;
    }

    public Boolean checkArgs() {
        if (this.mMsgType == 1 && !TextUtils.isEmpty(this.mTitle) && !TextUtils.isEmpty(this.mContent) && URLUtil.isNetworkUrl(this.mIconUrl) && URLUtil.isNetworkUrl(this.mLinkUrl)) {
            return true;
        }
        return false;
    }
}
