package com.baidu.searchbox.video.detail.export;

import androidx.fragment.app.Fragment;
import com.baidu.searchbox.video.detail.dependency.impl.channel.VideoFlowChannel_Factory;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\tJ\u0010\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/video/detail/export/IVideoFlowChannel;", "", "getVideoTabClass", "Ljava/lang/Class;", "Landroidx/fragment/app/Fragment;", "isInDarkMode", "", "release", "", "Impl", "lib-dependency_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IVideoFlowChannel.kt */
public interface IVideoFlowChannel {
    Class<? extends Fragment> getVideoTabClass();

    boolean isInDarkMode();

    void release();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/video/detail/export/IVideoFlowChannel$Impl;", "", "()V", "get", "Lcom/baidu/searchbox/video/detail/export/IVideoFlowChannel;", "lib-dependency_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IVideoFlowChannel.kt */
    public static final class Impl {
        public static final Impl INSTANCE = new Impl();

        private Impl() {
        }

        public final IVideoFlowChannel get() {
            return VideoFlowChannel_Factory.get();
        }
    }
}
