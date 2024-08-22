package com.baidu.wallet.paysdk.datamodel;

import com.dxmpay.wallet.core.NoProguard;
import java.io.Serializable;

public class LivingVerifyResultModel implements NoProguard, Serializable {
    public static final int ERROR_CODE_COMMON_REQUEST_ERROR = -402;
    public static final int ERROR_CODE_DETAIN_DIALOG_USER_EXIT = -203;
    public static final int ERROR_CODE_DETECT_FACE_TIMEOUT = -202;
    public static final int ERROR_CODE_INNER_ERROR = -100;
    public static final int ERROR_CODE_NOT_LIVENESSIDENTIFYAUTH = 10003;
    public static final int ERROR_CODE_USER_INITIATIVE_EXIT = -201;
    public static final int RESULT_CODE_SUCCESS = 0;
    public String callback_key;
    public String experiment_id;
    public String is_need_living_video;
    public String is_verify_pass;
}
