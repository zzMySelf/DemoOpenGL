package com.baidu.talos.core.fontsize;

import com.baidu.talos.core.render.ViewProps;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TalosFontSizeManager {
    public static final Set<String> SUPPORT_PROPERTIES = new HashSet<String>() {
        {
            add("padding");
            add(ViewProps.PADDING_LEFT);
            add(ViewProps.PADDING_RIGHT);
            add(ViewProps.PADDING_TOP);
            add(ViewProps.PADDING_BOTTOM);
            add("margin");
            add(ViewProps.MARGIN_LEFT);
            add(ViewProps.MARGIN_RIGHT);
            add(ViewProps.MARGIN_TOP);
            add(ViewProps.MARGIN_BOTTOM);
            add("left");
            add("right");
            add("top");
            add("bottom");
            add("width");
            add("height");
            add(ViewProps.MAX_WIDTH);
            add("minWidth");
            add(ViewProps.MAX_HEIGHT);
            add("minHeight");
            add("fontSize");
            add("lineHeight");
            add(ViewProps.TEXT_LINESPACING);
            add(ViewProps.PROP_TEXT_INDENT);
            add("borderRadius");
            add(ViewProps.BORDER_TOP_LEFT_RADIUS);
            add(ViewProps.BORDER_TOP_RIGHT_RADIUS);
            add(ViewProps.BORDER_BOTTOM_LEFT_RADIUS);
            add(ViewProps.BORDER_BOTTOM_RIGHT_RADIUS);
            add("borderWidth");
            add(ViewProps.BORDER_TOP_WIDTH);
            add(ViewProps.BORDER_RIGHT_WIDTH);
            add(ViewProps.BORDER_BOTTOM_WIDTH);
            add(ViewProps.BORDER_LEFT_WIDTH);
            add(ViewProps.BACKGROUND_SIZE);
            add(ViewProps.PROP_WATERFALL_COLUMNS);
        }
    };
    Map<String, Long> pageIDToRootTagMap;

    private TalosFontSizeManager() {
        this.pageIDToRootTagMap = new ConcurrentHashMap();
    }

    public void addPageID(String pageID, long rootTag) {
        this.pageIDToRootTagMap.put(pageID, Long.valueOf(rootTag));
    }

    public long getRootTag(String pageID) {
        if (this.pageIDToRootTagMap.containsKey(pageID)) {
            return this.pageIDToRootTagMap.get(pageID).longValue();
        }
        return -1;
    }

    public static TalosFontSizeManager getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        /* access modifiers changed from: private */
        public static final TalosFontSizeManager INSTANCE = new TalosFontSizeManager();

        private Holder() {
        }
    }
}
