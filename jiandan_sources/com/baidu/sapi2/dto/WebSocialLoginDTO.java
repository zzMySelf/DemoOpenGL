package com.baidu.sapi2.dto;

import android.content.Context;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.utils.enums.ThirdPartyLoginBindType;

public class WebSocialLoginDTO extends SapiWebDTO {
    public String authCode;
    public Context context;
    public boolean finishActivityAfterSuc = true;
    public Boolean isReleaseAllCallback = Boolean.TRUE;
    public ThirdPartyLoginBindType loginBindType = ThirdPartyLoginBindType.TYPE_STANDDARD;
    public boolean needBpPush = false;
    public String pushBpFrom;
    public SocialType socialType;
    public String statExtra;
}
