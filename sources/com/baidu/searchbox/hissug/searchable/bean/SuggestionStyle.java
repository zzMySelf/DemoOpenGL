package com.baidu.searchbox.hissug.searchable.bean;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.hissug.data.model.HisTagDataModel;
import com.baidu.searchbox.hissug.data.model.HisTextStyle;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/hissug/searchable/bean/SuggestionStyle;", "Lcom/baidu/searchbox/NoProGuard;", "()V", "tagStyle", "Lcom/baidu/searchbox/hissug/data/model/HisTagDataModel;", "getTagStyle", "()Lcom/baidu/searchbox/hissug/data/model/HisTagDataModel;", "setTagStyle", "(Lcom/baidu/searchbox/hissug/data/model/HisTagDataModel;)V", "textStyle", "Lcom/baidu/searchbox/hissug/data/model/HisTextStyle;", "getTextStyle", "()Lcom/baidu/searchbox/hissug/data/model/HisTextStyle;", "setTextStyle", "(Lcom/baidu/searchbox/hissug/data/model/HisTextStyle;)V", "isTagStyleValid", "", "isTextStyleValid", "lib_hissug_frame_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SuggestionStyle.kt */
public final class SuggestionStyle implements NoProGuard {
    private HisTagDataModel tagStyle;
    private HisTextStyle textStyle;

    public final HisTextStyle getTextStyle() {
        return this.textStyle;
    }

    public final void setTextStyle(HisTextStyle hisTextStyle) {
        this.textStyle = hisTextStyle;
    }

    public final HisTagDataModel getTagStyle() {
        return this.tagStyle;
    }

    public final void setTagStyle(HisTagDataModel hisTagDataModel) {
        this.tagStyle = hisTagDataModel;
    }

    public final boolean isTextStyleValid() {
        HisTextStyle hisTextStyle = this.textStyle;
        return hisTextStyle != null && hisTextStyle.isValid();
    }

    public final boolean isTagStyleValid() {
        HisTagDataModel hisTagDataModel = this.tagStyle;
        return hisTagDataModel != null && hisTagDataModel.isValid();
    }
}
