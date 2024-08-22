package com.baidu.pass.face.platform.listener;

import com.baidu.pass.main.facesdk.FaceInfo;

public interface ISecurityCallback {
    void getFaceInfoForSecurity(FaceInfo[] faceInfoArr);
}
