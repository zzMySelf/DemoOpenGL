package com.baidu.searchbox.feed.biserialdetail.content.imgscrollrecommend.template;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0007\b\u0012¢\u0006\u0002\u0010\u0002B\u0019\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/feed/biserialdetail/content/imgscrollrecommend/template/ImgScrollTplType;", "", "(Ljava/lang/String;I)V", "index", "", "layoutType", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getLayoutType", "()Ljava/lang/String;", "setLayoutType", "(Ljava/lang/String;)V", "NORMAL_IMAGE", "RS", "Companion", "lib-feed-biserial-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImgScrollTplType.kt */
public enum ImgScrollTplType {
    NORMAL_IMAGE(0, "double_list_search_note"),
    RS(1, "double_list_rs");
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public int index;
    private String layoutType;

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    public final String getLayoutType() {
        return this.layoutType;
    }

    public final void setLayoutType(String str) {
        this.layoutType = str;
    }

    private ImgScrollTplType(int index2, String layoutType2) {
        this.index = -1;
        this.index = index2;
        this.layoutType = layoutType2;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/feed/biserialdetail/content/imgscrollrecommend/template/ImgScrollTplType$Companion;", "", "()V", "getIndexByLayoutType", "", "layoutType", "", "getTplTypeByIndex", "Lcom/baidu/searchbox/feed/biserialdetail/content/imgscrollrecommend/template/ImgScrollTplType;", "viewType", "lib-feed-biserial-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImgScrollTplType.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ImgScrollTplType getTplTypeByIndex(int viewType) {
            if (viewType == ImgScrollTplType.NORMAL_IMAGE.index) {
                return ImgScrollTplType.NORMAL_IMAGE;
            }
            if (viewType == ImgScrollTplType.RS.index) {
                return ImgScrollTplType.RS;
            }
            return ImgScrollTplType.NORMAL_IMAGE;
        }

        public final int getIndexByLayoutType(String layoutType) {
            if (Intrinsics.areEqual((Object) layoutType, (Object) ImgScrollTplType.NORMAL_IMAGE.getLayoutType())) {
                return ImgScrollTplType.NORMAL_IMAGE.index;
            }
            if (Intrinsics.areEqual((Object) layoutType, (Object) ImgScrollTplType.RS.getLayoutType())) {
                return ImgScrollTplType.RS.index;
            }
            return ImgScrollTplType.NORMAL_IMAGE.index;
        }
    }
}
