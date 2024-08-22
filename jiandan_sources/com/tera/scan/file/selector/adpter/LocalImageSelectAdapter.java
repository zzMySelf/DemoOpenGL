package com.tera.scan.file.selector.adpter;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.aiscan.R;
import com.tera.scan.component.base.ui.localfile.baseui.LocalFileBaseCursorAdapter;
import com.tera.scan.filetype.FileType;
import com.tera.scan.localfile.model.FileItem;
import com.tera.scan.localfile.model.MediaFileItem;
import fe.mmm.qw.pf.qw.de.fe.qw;
import fe.mmm.qw.pf.qw.qw.de;
import fe.rg.qw.rg;
import fe.rg.qw.when.ad;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 H\u0016J&\u0010!\u001a\u00020\u001a2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R#\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lcom/tera/scan/file/selector/adpter/LocalImageSelectAdapter;", "Lcom/tera/scan/component/base/ui/localfile/baseui/LocalFileBaseCursorAdapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_isHarmonyOs", "", "get_isHarmonyOs", "()Z", "_isHarmonyOs$delegate", "Lkotlin/Lazy;", "listener", "Lcom/tera/scan/file/selector/adpter/LocalImageSelectListener;", "getListener", "()Lcom/tera/scan/file/selector/adpter/LocalImageSelectListener;", "setListener", "(Lcom/tera/scan/file/selector/adpter/LocalImageSelectListener;)V", "packageName", "", "kotlin.jvm.PlatformType", "getPackageName", "()Ljava/lang/String;", "packageName$delegate", "bindView", "", "itemView", "Landroid/view/View;", "cursor", "Landroid/database/Cursor;", "getSelectedFile", "Lcom/tera/scan/localfile/model/FileItem;", "position", "", "newView", "parent", "Landroid/view/ViewGroup;", "business-file-selector_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LocalImageSelectAdapter extends LocalFileBaseCursorAdapter {
    @NotNull
    public final Lazy _isHarmonyOs$delegate = LazyKt__LazyJVMKt.lazy(LocalImageSelectAdapter$_isHarmonyOs$2.INSTANCE);
    @NotNull
    public final Context context;
    @Nullable
    public LocalImageSelectListener listener;
    @NotNull
    public final Lazy packageName$delegate = LazyKt__LazyJVMKt.lazy(new LocalImageSelectAdapter$packageName$2(this));

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LocalImageSelectAdapter(@NotNull Context context2) {
        super(context2);
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    /* renamed from: bindView$lambda-0  reason: not valid java name */
    public static final void m752bindView$lambda0(LocalImageSelectAdapter localImageSelectAdapter, View view, int i2, View view2) {
        Intrinsics.checkNotNullParameter(localImageSelectAdapter, "this$0");
        Intrinsics.checkNotNullParameter(view, "$itemView");
        LocalImageSelectListener localImageSelectListener = localImageSelectAdapter.listener;
        if (localImageSelectListener != null) {
            localImageSelectListener.selectImg(view, i2);
        }
    }

    /* renamed from: bindView$lambda-1  reason: not valid java name */
    public static final boolean m753bindView$lambda1(LocalImageSelectAdapter localImageSelectAdapter, int i2, View view) {
        Intrinsics.checkNotNullParameter(localImageSelectAdapter, "this$0");
        LocalImageSelectListener localImageSelectListener = localImageSelectAdapter.listener;
        if (localImageSelectListener == null) {
            return true;
        }
        localImageSelectListener.onItemLongClick(i2);
        return true;
    }

    /* renamed from: bindView$lambda-2  reason: not valid java name */
    public static final void m754bindView$lambda2(LocalImageSelectAdapter localImageSelectAdapter, View view, int i2, View view2) {
        Intrinsics.checkNotNullParameter(localImageSelectAdapter, "this$0");
        Intrinsics.checkNotNullParameter(view, "$itemView");
        LocalImageSelectListener localImageSelectListener = localImageSelectAdapter.listener;
        if (localImageSelectListener != null) {
            localImageSelectListener.selectImg(view, i2);
        }
    }

    private final String getPackageName() {
        return (String) this.packageName$delegate.getValue();
    }

    private final boolean get_isHarmonyOs() {
        return ((Boolean) this._isHarmonyOs$delegate.getValue()).booleanValue();
    }

    public void bindView(@NotNull View view, @NotNull Context context2, @NotNull Cursor cursor) {
        String str;
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        int position = cursor.getPosition();
        view.setTag(Integer.valueOf(position));
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = qw.qw(context2);
        layoutParams.height = qw.qw(context2);
        view.setLayoutParams(layoutParams);
        View findViewById = view.findViewById(R.id.forgound);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.forgound)");
        boolean isSelected = isSelected(position);
        findViewById.setSelected(isSelected);
        View findViewById2 = view.findViewById(R.id.imageview_checkbox);
        if (findViewById2 != null) {
            findViewById2.setSelected(isSelected);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.thumbnail);
        int columnIndex = cursor.getColumnIndex("_data");
        if (columnIndex >= 0) {
            str = cursor.getString(columnIndex);
            Intrinsics.checkNotNullExpressionValue(str, "cursor.getString(pathIndex)");
        } else {
            str = "";
        }
        int columnIndex2 = cursor.getColumnIndex("_id");
        if (columnIndex2 >= 0) {
            int i2 = cursor.getInt(columnIndex2);
            Uri parse = Uri.parse(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString() + File.separator + i2);
            ad w = new ad().w(R.drawable.icon_list_large_image_no_shadow);
            Intrinsics.checkNotNullExpressionValue(w, "RequestOptions().placeho…st_large_image_no_shadow)");
            rg<Drawable> when = fe.rg.qw.ad.mmm(context2).when(parse);
            when.de(w);
            when.m317switch(imageView);
        }
        view.setOnClickListener(new de(this, view, position));
        view.setOnLongClickListener(new fe.mmm.qw.pf.qw.qw.qw(this, position));
        View findViewById3 = view.findViewById(R.id.imageview_checkbox_layout);
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(new fe.mmm.qw.pf.qw.qw.ad(this, view, position));
        }
        View findViewById4 = view.findViewById(R.id.gif_icon);
        if (findViewById4 != null) {
            findViewById4.setVisibility(FileType.isGif(str) ? 0 : 8);
        }
    }

    @Nullable
    public final LocalImageSelectListener getListener() {
        return this.listener;
    }

    @Nullable
    public FileItem getSelectedFile(@NotNull Context context2, int i2) {
        int columnIndex;
        String string;
        Intrinsics.checkNotNullParameter(context2, "context");
        Object item = getItem(i2);
        Cursor cursor = item instanceof Cursor ? (Cursor) item : null;
        if (cursor == null || (columnIndex = cursor.getColumnIndex("_data")) < 0 || (string = cursor.getString(columnIndex)) == null) {
            return null;
        }
        MediaFileItem mediaFileItem = new MediaFileItem(context2, new File(string));
        mediaFileItem.setIcon(FileType.getListDrawableId(mediaFileItem.getFileName()));
        return mediaFileItem;
    }

    @NotNull
    public View newView(@Nullable Context context2, @Nullable Cursor cursor, @Nullable ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context2).inflate(R.layout.local_file_selectot_image_item, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.…mage_item, parent, false)");
        return inflate;
    }

    public final void setListener(@Nullable LocalImageSelectListener localImageSelectListener) {
        this.listener = localImageSelectListener;
    }
}
