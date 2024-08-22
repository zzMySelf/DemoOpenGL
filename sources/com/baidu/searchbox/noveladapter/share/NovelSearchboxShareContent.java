package com.baidu.searchbox.noveladapter.share;

import android.graphics.Bitmap;
import com.baidu.searchbox.NoProGuard;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

public class NovelSearchboxShareContent implements NoProGuard {
    public boolean isSDKShowToast = true;
    public boolean isScreenShot;
    public boolean isWeixinOnly;
    public String mAppId;
    public String mAudioUrl;
    public String mCategoryData;
    public String mCategoryInfo;
    public String mCommand;
    public String mContent;
    public List<NovelSearchboxCustomShare> mCustomShares = new ArrayList();
    public List<String> mFileShareLists;
    public Bitmap mIconBitmap;
    public byte[] mIconBytes;
    public boolean mIconNeedRecycle;
    public String mIconUrl;
    public String mIconUrlSmall;
    public Bitmap mImageBitmap;
    public byte[] mImageBytes;
    public boolean mImageNeedRecycle;
    public String mImageUrl;
    public String mLinkUrl;
    public String mMenuItem;
    public String mPanel;
    public List<String> mRemoveMenuItems = new ArrayList();
    public int mShareType;
    public String mSource;
    public NovelSearchboxSharePageEnum mSourcePage;
    public String mTextContent;
    public String mTheme;
    public String mTitle;
    public String mUserInfo;
    public String mVideoUrl;
    public String mWeiboTopic;

    public void parseH5JsonData(String jsonData) throws JSONException {
    }
}
