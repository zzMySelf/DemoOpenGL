package com.baidu.talos.core.render.views.text;

import com.baidu.talos.core.context.TalosPageContext;
import com.baidu.talos.core.layout.ILayoutContext;

public class ReactRawTextManager extends ReactTextViewManager {
    public static final String REACT_CLASS = "RawText";

    public String getName() {
        return REACT_CLASS;
    }

    public ReactTextView createViewInstance(TalosPageContext context) {
        throw new IllegalStateException("RKRawText doesn't map into a native view");
    }

    public void updateExtraData(ReactTextView view2, Object extraData) {
    }

    public ReactTextShadowNode createShadowNodeInstance(ILayoutContext environment) {
        return new ReactTextShadowNode(environment, true);
    }

    public Class<ReactTextShadowNode> getShadowNodeClass() {
        return ReactTextShadowNode.class;
    }
}
