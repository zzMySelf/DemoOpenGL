package com.baidu.searchbox.comment.definition;

import android.view.View;
import com.baidu.searchbox.comment.definition.ICommentSubBusiness;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\"\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/comment/definition/ICommentTemplateConfig;", "", "onFixUpView", "", "view", "Landroid/view/View;", "type", "Lcom/baidu/searchbox/comment/definition/ICommentSubBusiness$BusinessType;", "replaceLookAndFeelResource", "", "resource", "params", "", "lib-comment-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ICommentTemplateConfig.kt */
public interface ICommentTemplateConfig {
    void onFixUpView(View view2, ICommentSubBusiness.BusinessType businessType);

    int replaceLookAndFeelResource(View view2, int i2, String str);
}
