package com.baidu.searchbox.video.feedflow.ubc;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ubc/UBC6146;", "", "From", "Source", "Type", "Value", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UBCManifest.kt */
public interface UBC6146 {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ubc/UBC6146$From;", "", "()V", "FROM_FEED", "", "FROM_SEARCH", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UBCManifest.kt */
    public static final class From {
        public static final String FROM_FEED = "feed";
        public static final String FROM_SEARCH = "search";
        public static final From INSTANCE = new From();

        private From() {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ubc/UBC6146$Value;", "", "()V", "VALUE_REMIND_UPDATE", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UBCManifest.kt */
    public static final class Value {
        public static final Value INSTANCE = new Value();
        public static final String VALUE_REMIND_UPDATE = "remind_update";

        private Value() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ubc/UBC6146$Type;", "", "()V", "TYPE_CLICK", "", "TYPE_SHOW", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UBCManifest.kt */
    public static final class Type {
        public static final Type INSTANCE = new Type();
        public static final String TYPE_CLICK = "click";
        public static final String TYPE_SHOW = "show";

        private Type() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ubc/UBC6146$Source;", "", "()V", "SOURCE_DIBAR", "", "SOURCE_FEED", "SOURCE_SEARCH", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UBCManifest.kt */
    public static final class Source {
        public static final Source INSTANCE = new Source();
        public static final String SOURCE_DIBAR = "dibar";
        public static final String SOURCE_FEED = "feed";
        public static final String SOURCE_SEARCH = "search";

        private Source() {
        }
    }
}
