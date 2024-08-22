package com.tera.scan.file.selector.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.baidu.aiscan.R;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.tera.scan.component.base.ui.localfile.baseui.ISelectChangeListener;
import com.tera.scan.component.base.ui.localfile.baseui.LocalFileBaseFragment;
import com.tera.scan.component.base.ui.widget.dragselectview.DragSelectGridView;
import com.tera.scan.component.base.ui.widget.dragselectview.IDragSelectListener;
import com.tera.scan.file.selector.adpter.LocalImageSelectAdapter;
import com.tera.scan.file.selector.adpter.LocalImageSelectListener;
import com.tera.scan.file.selector.data.cursorloader.LocalImageSelectLoader;
import com.tera.scan.localfile.model.FileItem;
import fe.mmm.qw.pf.qw.de.fe.qw;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0016J\u001a\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\u0012\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u001cH\u0016J \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030 2\u0006\u0010!\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001cH\u0017J\u0010\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\fH\u0016J \u0010*\u001a\u00020\u00162\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030 2\b\u0010,\u001a\u0004\u0018\u00010\u0003H\u0016J\u0016\u0010-\u001a\u00020\u00162\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030 H\u0016J\u001a\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u00020#2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u00100\u001a\u00020\u00162\b\u0010/\u001a\u0004\u0018\u00010#2\u0006\u0010)\u001a\u00020\fH\u0016J\u0018\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\u000eH\u0016J\u001a\u00104\u001a\u00020\u00162\b\u0010/\u001a\u0004\u0018\u00010#2\u0006\u0010)\u001a\u00020\fH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/tera/scan/file/selector/ui/LocalImageSelectFragment;", "Lcom/tera/scan/component/base/ui/localfile/baseui/LocalFileBaseFragment;", "Landroidx/loader/app/LoaderManager$LoaderCallbacks;", "Landroid/database/Cursor;", "Lcom/tera/scan/file/selector/adpter/LocalImageSelectListener;", "Lcom/tera/scan/component/base/ui/widget/dragselectview/IDragSelectListener;", "()V", "bucketId", "", "gridView", "Lcom/tera/scan/component/base/ui/widget/dragselectview/DragSelectGridView;", "maxCount", "", "onDragSelectMode", "", "getOnDragSelectMode", "()Z", "setOnDragSelectMode", "(Z)V", "showAllBucket", "toastOverFlow", "dragSelectEnd", "", "initIndex", "lastIndex", "initLoader", "loaderId", "args", "Landroid/os/Bundle;", "onCreate", "savedInstanceState", "onCreateLoader", "Landroidx/loader/content/Loader;", "id", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onItemLongClick", "position", "onLoadFinished", "loader", "cursor", "onLoaderReset", "onViewCreated", "view", "selectImg", "setDragSelected", "index", "selected", "viewPic", "business-file-selector_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Tag("LocalImageSelectFragment")
public final class LocalImageSelectFragment extends LocalFileBaseFragment implements LoaderManager.LoaderCallbacks<Cursor>, LocalImageSelectListener, IDragSelectListener {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    public String bucketId;
    @Nullable
    public DragSelectGridView gridView;
    public int maxCount;
    public boolean onDragSelectMode;
    public boolean showAllBucket = true;
    public boolean toastOverFlow;

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i2) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i2)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void dragSelectEnd(int i2, int i3) {
        this.onDragSelectMode = false;
    }

    public final boolean getOnDragSelectMode() {
        return this.onDragSelectMode;
    }

    public void initLoader(int i2, @Nullable Bundle bundle) {
        getLoaderManager().initLoader(i2, (Bundle) null, this);
    }

    public void onCreate(@Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.showAllBucket = arguments.getBoolean("extra_show_all_bucket", true);
            this.bucketId = arguments.getString("buket_id", (String) null);
            this.maxCount = arguments.getInt("extra_max_count", 0);
        }
        super.onCreate(bundle);
    }

    @NotNull
    public Loader<Cursor> onCreateLoader(int i2, @Nullable Bundle bundle) {
        return new LocalImageSelectLoader(getContext(), (String) null);
    }

    @Nullable
    @SuppressLint({"InflateParams"})
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.local_image_select_fragment, (ViewGroup) null);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onItemLongClick(int i2) {
        setDragSelected(i2, true);
        DragSelectGridView dragSelectGridView = this.gridView;
        if (dragSelectGridView != null) {
            dragSelectGridView.dragToStartSelect(true, i2);
        }
        this.onDragSelectMode = true;
    }

    public void onLoaderReset(@NotNull Loader<Cursor> loader) {
        Intrinsics.checkNotNullParameter(loader, "loader");
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Context context = getContext();
        if (context != null) {
            LocalImageSelectAdapter localImageSelectAdapter = new LocalImageSelectAdapter(context);
            localImageSelectAdapter.setListener(this);
            this.mAdapter = localImageSelectAdapter;
            View findViewById = view.findViewById(R.id.folder_grid);
            DragSelectGridView dragSelectGridView = findViewById instanceof DragSelectGridView ? (DragSelectGridView) findViewById : null;
            this.gridView = dragSelectGridView;
            if (dragSelectGridView != null) {
                dragSelectGridView.setAdapter(this.mAdapter);
                dragSelectGridView.setEmptyView(this.mEmptyView);
                dragSelectGridView.setDragSelectListener(this);
                dragSelectGridView.setStretchMode(1);
                dragSelectGridView.setNumColumns(4);
                Context context2 = dragSelectGridView.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "it.context");
                dragSelectGridView.setColumnWidth(qw.qw(context2));
            }
        }
    }

    public void selectImg(@Nullable View view, int i2) {
        ISelectChangeListener iSelectChangeListener;
        LoggerKt.d$default("选中位置 " + i2, (Object) null, 1, (Object) null);
        if (view != null) {
            View findViewById = view.findViewById(R.id.forgound);
            boolean z = !findViewById.isSelected();
            if (z) {
                if (this.maxCount <= 0 || this.mAdapter.getSelectedFilesCount() < this.maxCount) {
                    FileItem selectedFile = this.mAdapter.getSelectedFile(getContext(), i2);
                    if (!(selectedFile == null || (iSelectChangeListener = this.mSelectChangeListener) == null || iSelectChangeListener.ad(selectedFile.getFileName()))) {
                        return;
                    }
                } else {
                    ISelectChangeListener iSelectChangeListener2 = this.mSelectChangeListener;
                    if (iSelectChangeListener2 != null) {
                        iSelectChangeListener2.de();
                        return;
                    }
                    return;
                }
            }
            findViewById.setSelected(z);
            view.findViewById(R.id.imageview_checkbox).setSelected(z);
            if (z) {
                this.mAdapter.addSelectedPosition(getContext(), i2);
            } else {
                this.mAdapter.removeSelectedPosition(i2);
            }
            ISelectChangeListener iSelectChangeListener3 = this.mSelectChangeListener;
            if (iSelectChangeListener3 != null) {
                iSelectChangeListener3.qw(this.mAdapter.getSelectedFilesCount(), this.mAdapter.getCount());
            }
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void setDragSelected(int i2, boolean z) {
        if (!z || this.mAdapter.getSelectedFilesCount() < this.maxCount) {
            this.toastOverFlow = false;
            if (z) {
                this.mAdapter.addSelectedPosition(getContext(), i2);
            } else {
                this.mAdapter.removeSelectedPosition(i2);
            }
            ISelectChangeListener iSelectChangeListener = this.mSelectChangeListener;
            if (iSelectChangeListener != null) {
                iSelectChangeListener.qw(this.mAdapter.getSelectedFilesCount(), this.mAdapter.getCount());
            }
            this.mAdapter.notifyDataSetChanged();
            return;
        }
        ISelectChangeListener iSelectChangeListener2 = this.mSelectChangeListener;
        if (iSelectChangeListener2 != null && !this.toastOverFlow) {
            this.toastOverFlow = true;
            iSelectChangeListener2.de();
        }
    }

    public final void setOnDragSelectMode(boolean z) {
        this.onDragSelectMode = z;
    }

    public void viewPic(@Nullable View view, int i2) {
    }

    public void onLoadFinished(@NotNull Loader<Cursor> loader, @Nullable Cursor cursor) {
        Intrinsics.checkNotNullParameter(loader, "loader");
        if (cursor == null || cursor.getCount() <= 0) {
            showEmptyView();
        } else {
            this.mAdapter.swapCursor(cursor);
        }
    }
}
