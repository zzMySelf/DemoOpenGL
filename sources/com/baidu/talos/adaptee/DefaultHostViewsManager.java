package com.baidu.talos.adaptee;

import com.baidu.talos.adapter.IHostViewsManagerAdapter;
import java.util.ArrayList;
import javax.annotation.Nonnull;

public class DefaultHostViewsManager implements IHostViewsManagerAdapter {
    @Nonnull
    public ArrayList getHostViews() {
        return new ArrayList();
    }
}
