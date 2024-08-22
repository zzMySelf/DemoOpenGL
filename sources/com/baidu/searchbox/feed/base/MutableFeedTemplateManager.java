package com.baidu.searchbox.feed.base;

import com.baidu.searchbox.feed.base.FeedTemplateManager;

public final class MutableFeedTemplateManager extends AbstractFeedTemplateManager {
    private static volatile MutableFeedTemplateManager sDefault;

    public static MutableFeedTemplateManager getDefault() {
        if (sDefault == null) {
            sDefault = new MutableFeedTemplateManager();
        }
        return sDefault;
    }

    public MutableFeedTemplateManager() {
        super((FeedTemplateManager.Collector) null);
    }

    public synchronized int size() {
        return super.size();
    }

    public synchronized boolean putFeedTemplate(IFeedTemplate tpl) {
        return super.putFeedTemplate(tpl);
    }

    public synchronized IFeedTemplate getFeedTemplate(int index) {
        return super.getFeedTemplate(index);
    }

    public synchronized IFeedTemplate getFeedTemplate(CharSequence name) {
        return super.getFeedTemplate(name);
    }

    public synchronized int indexOf(IFeedTemplate tpl) {
        return super.indexOf(tpl);
    }

    public synchronized int indexOf(CharSequence name) {
        return super.indexOf(name);
    }
}
