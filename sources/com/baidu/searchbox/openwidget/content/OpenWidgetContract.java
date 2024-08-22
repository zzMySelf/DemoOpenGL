package com.baidu.searchbox.openwidget.content;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.searchbox.openwidget.model.OpenWidgetSize;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/openwidget/content/OpenWidgetContract;", "", "()V", "Companion", "Widgets", "lib-openwidget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OpenWidgetContract.kt */
public final class OpenWidgetContract {
    /* access modifiers changed from: private */
    public static final String AUTHORITY;
    /* access modifiers changed from: private */
    public static final Uri CONTENT_URI;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/openwidget/content/OpenWidgetContract$Widgets;", "Landroid/provider/BaseColumns;", "()V", "Companion", "lib-openwidget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OpenWidgetContract.kt */
    public static final class Widgets implements BaseColumns {
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.baidusearchbox.openwidget";
        /* access modifiers changed from: private */
        public static final Uri CONTENT_LOOKUP_URI;
        /* access modifiers changed from: private */
        public static final Uri CONTENT_MIN_UPDATE_PERIOD_URI;
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.baidusearchbox.openwidget";
        /* access modifiers changed from: private */
        public static final Uri CONTENT_URI;
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final String ID = "_id";
        private static final String LOOK_UP_KEY_OPEN_WIDGET_ID = "open_widget_id";
        public static final String OPEN_WIDGET_CONFIG = "widgetConfig";
        public static final String OPEN_WIDGET_HEIGHT = "height";
        public static final String OPEN_WIDGET_ID = "widgetId";
        public static final String OPEN_WIDGET_INFO = "widgetInfo";
        public static final String OPEN_WIDGET_TOUCH = "touchConfig";
        public static final String OPEN_WIDGET_UPDATE_PERIOD = "updatePeriod";
        public static final String OPEN_WIDGET_WIDTH = "width";
        private static final String PATH = "widgets";

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/openwidget/content/OpenWidgetContract$Widgets$Companion;", "", "()V", "CONTENT_ITEM_TYPE", "", "CONTENT_LOOKUP_URI", "Landroid/net/Uri;", "CONTENT_MIN_UPDATE_PERIOD_URI", "CONTENT_TYPE", "CONTENT_URI", "getCONTENT_URI", "()Landroid/net/Uri;", "ID", "LOOK_UP_KEY_OPEN_WIDGET_ID", "OPEN_WIDGET_CONFIG", "OPEN_WIDGET_HEIGHT", "OPEN_WIDGET_ID", "OPEN_WIDGET_INFO", "OPEN_WIDGET_TOUCH", "OPEN_WIDGET_UPDATE_PERIOD", "OPEN_WIDGET_WIDTH", "PATH", "lookupUriByOpenWidgetId", "openWidgetId", "", "lookupUriMinUpdatePeriod", "size", "Lcom/baidu/searchbox/openwidget/model/OpenWidgetSize;", "lib-openwidget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: OpenWidgetContract.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Uri getCONTENT_URI() {
                return Widgets.CONTENT_URI;
            }

            public final Uri lookupUriByOpenWidgetId(long openWidgetId) {
                Uri withAppendedId = ContentUris.withAppendedId(Uri.withAppendedPath(Widgets.CONTENT_LOOKUP_URI, Widgets.LOOK_UP_KEY_OPEN_WIDGET_ID), openWidgetId);
                Intrinsics.checkNotNullExpressionValue(withAppendedId, "withAppendedId(\n        …idgetId\n                )");
                return withAppendedId;
            }

            public final Uri lookupUriMinUpdatePeriod(OpenWidgetSize size) {
                Intrinsics.checkNotNullParameter(size, "size");
                Uri withAppendedPath = Uri.withAppendedPath(Widgets.CONTENT_MIN_UPDATE_PERIOD_URI, new StringBuilder().append(size.getWidth()).append('x').append(size.getHeight()).toString());
                Intrinsics.checkNotNullExpressionValue(withAppendedPath, "withAppendedPath(CONTENT…_PERIOD_URI, pathSegment)");
                return withAppendedPath;
            }
        }

        static {
            Uri parse = Uri.parse(DownloadConstants.LOCAL_DATA_URI_PREFIX + OpenWidgetContract.Companion.getAUTHORITY() + "/widgets");
            Intrinsics.checkNotNullExpressionValue(parse, "parse(\"content://$AUTHORITY/$PATH\")");
            CONTENT_URI = parse;
            Uri withAppendedPath = Uri.withAppendedPath(parse, "lookup");
            Intrinsics.checkNotNullExpressionValue(withAppendedPath, "withAppendedPath(CONTENT_URI, \"lookup\")");
            CONTENT_LOOKUP_URI = withAppendedPath;
            Uri withAppendedPath2 = Uri.withAppendedPath(parse, "min_update_period");
            Intrinsics.checkNotNullExpressionValue(withAppendedPath2, "withAppendedPath(CONTENT_URI, \"min_update_period\")");
            CONTENT_MIN_UPDATE_PERIOD_URI = withAppendedPath2;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/openwidget/content/OpenWidgetContract$Companion;", "", "()V", "AUTHORITY", "", "getAUTHORITY", "()Ljava/lang/String;", "CONTENT_URI", "Landroid/net/Uri;", "getCONTENT_URI", "()Landroid/net/Uri;", "lib-openwidget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OpenWidgetContract.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getAUTHORITY() {
            return OpenWidgetContract.AUTHORITY;
        }

        public final Uri getCONTENT_URI() {
            return OpenWidgetContract.CONTENT_URI;
        }
    }

    static {
        String str = AppRuntime.getAppContext().getPackageName() + ".openwidget";
        AUTHORITY = str;
        Uri parse = Uri.parse(DownloadConstants.LOCAL_DATA_URI_PREFIX + str);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(\"content://$AUTHORITY\")");
        CONTENT_URI = parse;
    }
}
