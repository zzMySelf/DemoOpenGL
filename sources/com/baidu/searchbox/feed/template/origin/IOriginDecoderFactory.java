package com.baidu.searchbox.feed.template.origin;

import android.content.Context;
import com.baidu.searchbox.feed.model.DynamicItemData;
import com.baidu.searchbox.feed.template.origin.IOriginTemplate;

public interface IOriginDecoderFactory<T extends DynamicItemData, V extends IOriginTemplate<T>> {
    T buildOriginModel();

    V buildOriginTemplate(Context context);

    String getType();
}
