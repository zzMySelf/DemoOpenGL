package com.baidu.searchbox.dynamicpublisher.image;

import android.view.View;
import com.baidu.searchbox.ugc.model.ImageStruct;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u001a\u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000bH&¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/image/IBaseDragGridView;", "", "getGridView", "Landroid/view/View;", "hideDownloading", "", "newImage", "Lcom/baidu/searchbox/ugc/model/ImageStruct;", "refresh", "refreshByPosition", "position", "", "showDownloading", "clickPosition", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IBaseDragGridView.kt */
public interface IBaseDragGridView {
    View getGridView();

    void hideDownloading(ImageStruct imageStruct);

    void refresh();

    void refreshByPosition(int i2);

    void showDownloading(ImageStruct imageStruct, int i2);
}
