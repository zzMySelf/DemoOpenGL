package com.baidu.swan.apps.component.base.interfaces;

import com.baidu.swan.apps.component.base.SwanAppComponentResult;
import com.baidu.swan.apps.component.base.interfaces.ISwanAppComponentModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import rx.Subscriber;

public interface ISwanAppComponent<M extends ISwanAppComponentModel> {
    public static final String ANIMATEVIEW = "animateview";
    public static final String ARCAMERA = "ARCamera";
    public static final String BUTTON = "button";
    public static final String CAMERA = "camera";
    public static final String CANVAS = "canvas";
    public static final String COVERIMAGE = "coverImage";
    public static final String COVERVIEW = "coverView";
    public static final int FLAG_CAN_NO_COMPONENT_ID = 2;
    public static final int FLAG_IGNORE_REMOVE_RESULT = 1;
    public static final int FLAG_RESPOND_ANIMATION = 4;
    public static final String INPUT = "input";
    public static final String LIVEPLAYER = "livePlayer";
    public static final String MAP = "map";
    public static final String TEXTAREA = "textArea";
    public static final String UNKNOWN = "unknown";
    public static final String VIDEO = "video";
    public static final String VOICEPANEL = "voicePanel";
    public static final String VRVIDEO = "vrvideo";
    public static final String WEBVIEW = "webView";

    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    SwanAppComponentResult insert();

    Subscriber insertDelayed();

    SwanAppComponentResult remove();

    SwanAppComponentResult update(M m);
}
