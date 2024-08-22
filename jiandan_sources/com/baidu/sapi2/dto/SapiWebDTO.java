package com.baidu.sapi2.dto;

import android.view.View;
import com.baidu.sapi2.enums.LoginTypes;
import java.util.ArrayList;

public class SapiWebDTO extends SapiDTO {
    public int closeEnterAnimId = 0;
    public int closeExitAnimId = 0;
    public LoginTypes excludeTypes;
    public ArrayList<LoginTypes> excludeTypesList;
    public View loadingView;
    public int openEnterAnimId = 0;
    public int openExitAnimId = 0;
    public boolean sweepLightLoading = true;
}
