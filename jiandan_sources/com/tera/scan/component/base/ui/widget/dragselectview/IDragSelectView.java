package com.tera.scan.component.base.ui.widget.dragselectview;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.AutoScrollHelper;

public interface IDragSelectView {
    View findChildViewUnder(ViewGroup viewGroup, float f, float f2);

    ViewGroup getParentDragView();

    AutoScrollHelper initAutoScrollHelper();
}
