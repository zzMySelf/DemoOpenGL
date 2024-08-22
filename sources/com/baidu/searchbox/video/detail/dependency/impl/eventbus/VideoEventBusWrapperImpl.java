package com.baidu.searchbox.video.detail.dependency.impl.eventbus;

import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.eventmessage.FontSizeChangeMessage;
import com.baidu.searchbox.feed.event.NewLinkageDataEvent;
import com.baidu.searchbox.feed.event.TTSActionEvent;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.video.detail.dependency.impl.linkage.LinkageUtils;
import com.baidu.searchbox.video.detail.export.IVideoEventBusWrapper;
import com.baidu.searchbox.video.detail.export.LinkageBean;
import rx.functions.Action1;

public class VideoEventBusWrapperImpl implements IVideoEventBusWrapper {
    public void post(Object event) {
        BdEventBus.Companion.getDefault().post(event);
    }

    public void postRecommendAdFirstDisplayMessage(FeedBaseModel adModel) {
        BdEventBus.Companion.getDefault().post(new RecommendAdFirstDisplayMessage(1, adModel));
    }

    public <T> void register(Object tag, Class<T> type, final Action1<T> action) {
        BdEventBus.Companion.getDefault().register(tag, type, new Action<T>() {
            public void call(T t) {
                action.call(t);
            }
        });
    }

    public <T> void registerOnMainThread(Object tag, Class<T> type, final Action1<T> action) {
        BdEventBus.Companion.getDefault().register(tag, type, 1, new Action<T>() {
            public void call(T t) {
                action.call(t);
            }
        });
    }

    public <T> void registerOnMainThread(Object tag, Class<T> type, final IVideoEventBusWrapper.RegisterAction<T> action) {
        BdEventBus.Companion.getDefault().register(tag, type, 1, new Action<T>() {
            public void call(T t) {
                IVideoEventBusWrapper.RegisterAction registerAction = action;
                if (registerAction != null) {
                    registerAction.call(t);
                }
            }
        });
    }

    public <T> void lazyRegisterOnMainThread(Object tag, Class<T> type, final Action1<T> action) {
        BdEventBus.Companion.getDefault().lazyRegister(tag, type, 1, new Action<T>() {
            public void call(T t) {
                action.call(t);
            }
        });
    }

    public <T> void lazyRegisterOnMainThread(Object tag, Class<T> type, final IVideoEventBusWrapper.RegisterAction<T> action) {
        BdEventBus.Companion.getDefault().lazyRegister(tag, type, 1, new Action<T>() {
            public void call(T t) {
                IVideoEventBusWrapper.RegisterAction registerAction = action;
                if (registerAction != null) {
                    registerAction.call(t);
                }
            }
        });
    }

    public void unregister(Object tag) {
        BdEventBus.Companion.getDefault().unregister(tag);
    }

    public void registerFontSizeChangeEvent(Object tag, final IVideoEventBusWrapper.IVideoFontSizeChangeAction action) {
        BdEventBus.Companion.getDefault().register(tag, FontSizeChangeMessage.class, new Action<FontSizeChangeMessage>() {
            public void call(FontSizeChangeMessage message) {
                action.call();
            }
        });
    }

    public void registerTTSActionEvent(Object tag, final IVideoEventBusWrapper.IVideoTTSActionEvent action) {
        BdEventBus.Companion.getDefault().lazyRegister(tag, TTSActionEvent.class, 1, new Action<TTSActionEvent>() {
            public void call(TTSActionEvent ttsActionEvent) {
                IVideoEventBusWrapper.IVideoTTSActionEvent iVideoTTSActionEvent = action;
                if (iVideoTTSActionEvent != null) {
                    iVideoTTSActionEvent.call();
                }
            }
        });
    }

    public void registerPraiseEvent(Object tag, final IVideoEventBusWrapper.RegisterAction<LinkageBean> action) {
        BdEventBus.Companion.getDefault().lazyRegister(tag, NewLinkageDataEvent.class, 1, new Action<NewLinkageDataEvent>() {
            public void call(NewLinkageDataEvent linkageDataEvent) {
                if (linkageDataEvent != null && linkageDataEvent.getData() != null) {
                    action.call(LinkageUtils.transformLinkageData(linkageDataEvent.getData()));
                }
            }
        });
    }
}
