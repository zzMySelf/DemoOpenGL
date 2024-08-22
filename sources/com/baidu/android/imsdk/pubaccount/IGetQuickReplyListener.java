package com.baidu.android.imsdk.pubaccount;

import com.baidu.android.imsdk.IMListener;

public interface IGetQuickReplyListener extends IMListener {
    void onGetQuickReply(QuickReply quickReply, boolean z);
}
