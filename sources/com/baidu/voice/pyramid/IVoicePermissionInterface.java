package com.baidu.voice.pyramid;

import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceReference;

public interface IVoicePermissionInterface {
    public static final ServiceReference SERVICE_REFERENCE = new ServiceReference("voice", "voice_permission_interface");

    boolean getCanRequestPermission();

    boolean getShouldShowRequestPermissionRationale(Context context);

    void setCanRequestPermission(boolean z);
}
