package com.baidu.searchbox.player.model;

import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@StableApi
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/player/model/YYOption;", "", "()V", "CachePolicy", "Companion", "IsLive", "SourceFormat", "UrlProtocol", "yykernel-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: YYOption.kt */
public final class YYOption {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXT_JSON = "ext_json";
    public static final String MAX_PRELOAD_BUFFER_SIZE = "maxPreloadBufferSize";
    public static final String MAX_PRELOAD_FRAMES = "maxPreloadFrames";
    public static final String PCDN_REDIRECT = "pcdnRedirect";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/player/model/YYOption$Companion;", "", "()V", "EXT_JSON", "", "MAX_PRELOAD_BUFFER_SIZE", "MAX_PRELOAD_FRAMES", "PCDN_REDIRECT", "yykernel-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: YYOption.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/player/model/YYOption$UrlProtocol;", "", "()V", "Companion", "yykernel-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: YYOption.kt */
    public static final class UrlProtocol {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final String FILE = "2";
        public static final String HTTP = "0";
        public static final String KEY = "yy_url_protocol";
        public static final String P2P = "4";
        public static final String QUIC = "1";
        public static final String USER = "100";

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/player/model/YYOption$UrlProtocol$Companion;", "", "()V", "FILE", "", "HTTP", "KEY", "P2P", "QUIC", "USER", "yykernel-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: YYOption.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/player/model/YYOption$SourceFormat;", "", "()V", "Companion", "yykernel-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: YYOption.kt */
    public static final class SourceFormat {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final String KEY = "yy_source_format";
        public static final String VALUE_AUTO = "0";
        public static final String VALUE_FLV = "2";
        public static final String VALUE_HLS = "3";
        public static final String VALUE_MP4 = "1";

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/player/model/YYOption$SourceFormat$Companion;", "", "()V", "KEY", "", "VALUE_AUTO", "VALUE_FLV", "VALUE_HLS", "VALUE_MP4", "yykernel-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: YYOption.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/player/model/YYOption$CachePolicy;", "", "()V", "Companion", "yykernel-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: YYOption.kt */
    public static final class CachePolicy {
        public static final String BUFFER_SIZE_KEY = "yy_buffer_size";
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final int DEFAULT_BUFFER_SIZE = 1;
        public static final int DEFAULT_FRAMES_SIZE = 30;
        public static final String KEY = "yy_cache_policy";
        public static final String PRELOAD_FRAMES_KEY = "yy_preload_frames";
        public static final String VALUE_NOCACHE = "0";
        public static final String VALUE_STREAM_LATEST_GOP = "2";
        public static final String VALUE_WHOLE_FILE = "1";

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/player/model/YYOption$CachePolicy$Companion;", "", "()V", "BUFFER_SIZE_KEY", "", "DEFAULT_BUFFER_SIZE", "", "DEFAULT_FRAMES_SIZE", "KEY", "PRELOAD_FRAMES_KEY", "VALUE_NOCACHE", "VALUE_STREAM_LATEST_GOP", "VALUE_WHOLE_FILE", "yykernel-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: YYOption.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/player/model/YYOption$IsLive;", "", "()V", "Companion", "yykernel-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: YYOption.kt */
    public static final class IsLive {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final String KEY = "yy_is_live";
        public static final String VALUE_FALSE = "false";
        public static final String VALUE_TRUE = "true";

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/player/model/YYOption$IsLive$Companion;", "", "()V", "KEY", "", "VALUE_FALSE", "VALUE_TRUE", "yykernel-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: YYOption.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }
}
