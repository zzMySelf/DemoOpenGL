package com.baidu.searchbox.dynamicpublisher.toolbar;

import android.view.View;
import com.baidu.searchbox.publishercomponent.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u00020\u00108\u0016XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0002\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/toolbar/AlbumSelect;", "Lcom/baidu/searchbox/dynamicpublisher/toolbar/IBottomToolbarButton;", "()V", "clickListener", "Landroid/view/View$OnClickListener;", "getClickListener", "()Landroid/view/View$OnClickListener;", "setClickListener", "(Landroid/view/View$OnClickListener;)V", "drawable", "", "getDrawable", "()I", "setDrawable", "(I)V", "id", "", "getId$annotations", "getId", "()Ljava/lang/String;", "visible", "getVisible", "setVisible", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ToolbarItem.kt */
public final class AlbumSelect extends IBottomToolbarButton {
    private View.OnClickListener clickListener;
    private int drawable = R.drawable.dynamic_publisher_toolbar_album_unpress;
    private final String id = ToolbarItemKt.ALBUM_SELECT;
    private int visible = 8;

    @BottomToolbarButtonId
    public static /* synthetic */ void getId$annotations() {
    }

    public String getId() {
        return this.id;
    }

    public int getDrawable() {
        return this.drawable;
    }

    public void setDrawable(int i2) {
        this.drawable = i2;
    }

    public View.OnClickListener getClickListener() {
        return this.clickListener;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.clickListener = onClickListener;
    }

    public int getVisible() {
        return this.visible;
    }

    public void setVisible(int i2) {
        this.visible = i2;
    }
}
