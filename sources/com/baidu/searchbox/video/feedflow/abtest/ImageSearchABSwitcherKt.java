package com.baidu.searchbox.video.feedflow.abtest;

import com.baidu.searchbox.video.detail.switcher.VideoAbSwitcher;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"+\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00038F@FX\u0002¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"FEED_VIDEO_IMAGE_SEARCH_SWITCH", "", "<set-?>", "", "imageSearchEnabled", "getImageSearchEnabled", "()Z", "setImageSearchEnabled", "(Z)V", "imageSearchEnabled$delegate", "Lcom/baidu/searchbox/video/detail/switcher/VideoAbSwitcher;", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageSearchABSwitcher.kt */
public final class ImageSearchABSwitcherKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty0(new MutablePropertyReference0Impl(ImageSearchABSwitcherKt.class, "imageSearchEnabled", "getImageSearchEnabled()Z", 1))};
    private static final String FEED_VIDEO_IMAGE_SEARCH_SWITCH = "feedvideo_image_search_switch_android";
    private static final VideoAbSwitcher imageSearchEnabled$delegate = new VideoAbSwitcher(FEED_VIDEO_IMAGE_SEARCH_SWITCH, false, true);

    public static final boolean getImageSearchEnabled() {
        return ((Boolean) imageSearchEnabled$delegate.getValue((Object) null, $$delegatedProperties[0])).booleanValue();
    }

    public static final void setImageSearchEnabled(boolean z) {
        imageSearchEnabled$delegate.setValue((Object) null, $$delegatedProperties[0], Boolean.valueOf(z));
    }
}
