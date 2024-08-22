package com.baidu.searchbox.search.tab.subTab;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/search/tab/subTab/VideoCommonSubTabModel;", "", "()V", "extLog", "", "getExtLog", "()Ljava/lang/String;", "setExtLog", "(Ljava/lang/String;)V", "hasTagSearch", "", "getHasTagSearch", "()Z", "setHasTagSearch", "(Z)V", "subTabList", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/search/tab/subTab/VideoCommonSubTabModel$Tab;", "Lkotlin/collections/ArrayList;", "getSubTabList", "()Ljava/util/ArrayList;", "setSubTabList", "(Ljava/util/ArrayList;)V", "Tab", "search_video_business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoCommonSubTabModel.kt */
public final class VideoCommonSubTabModel {
    private String extLog = "";
    private boolean hasTagSearch;
    private ArrayList<Tab> subTabList = new ArrayList<>();

    public final ArrayList<Tab> getSubTabList() {
        return this.subTabList;
    }

    public final void setSubTabList(ArrayList<Tab> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.subTabList = arrayList;
    }

    public final String getExtLog() {
        return this.extLog;
    }

    public final void setExtLog(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.extLog = str;
    }

    public final boolean getHasTagSearch() {
        return this.hasTagSearch;
    }

    public final void setHasTagSearch(boolean z) {
        this.hasTagSearch = z;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/search/tab/subTab/VideoCommonSubTabModel$Tab;", "", "()V", "isSelected", "", "()Z", "setSelected", "(Z)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "url", "getUrl", "setUrl", "vs", "getVs", "setVs", "search_video_business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VideoCommonSubTabModel.kt */
    public static final class Tab {
        private boolean isSelected;
        private String title = "";
        private String url = "";
        private String vs = "";

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.url = str;
        }

        public final String getVs() {
            return this.vs;
        }

        public final void setVs(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.vs = str;
        }

        public final boolean isSelected() {
            return this.isSelected;
        }

        public final void setSelected(boolean z) {
            this.isSelected = z;
        }
    }
}
