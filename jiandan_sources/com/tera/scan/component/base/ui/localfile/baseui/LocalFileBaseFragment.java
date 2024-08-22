package com.tera.scan.component.base.ui.localfile.baseui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.baidu.aiscan.R;
import com.tera.scan.framework.kernel.BaseApplication;
import com.tera.scan.framework.kernel.architecture.ui.BaseFragment;
import com.tera.scan.localfile.model.FileItem;
import com.tera.scan.ui.widget.EmptyView;
import fe.mmm.qw.th.qw.th.o;
import java.util.ArrayList;

public abstract class LocalFileBaseFragment extends BaseFragment {
    public static final int LOADER_ID = 0;
    public static final String TAG = "LocalFileBaseFragment";
    public LocalFileBaseCursorAdapter mAdapter;
    public EmptyView mEmptyView;
    public int mMaxCount = 0;
    public ISelectChangeListener mSelectChangeListener;

    private void initMaxCount() {
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            this.mMaxCount = intent.getIntExtra("upload_max_count", 0);
        }
    }

    public void destroyLoader() {
        getLoaderManager().destroyLoader(0);
    }

    public String getCurrentPath() {
        return null;
    }

    public ArrayList<FileItem> getSelectedFiles() {
        LocalFileBaseCursorAdapter localFileBaseCursorAdapter = this.mAdapter;
        if (localFileBaseCursorAdapter == null) {
            return null;
        }
        return localFileBaseCursorAdapter.getSelectedFiles();
    }

    public void hideEmptyView() {
        this.mEmptyView.setVisibility(8);
    }

    public abstract void initLoader(int i2, Bundle bundle);

    public boolean isOverSize(int i2) {
        int i3 = this.mMaxCount;
        if (i3 <= 0 || i2 <= i3) {
            return false;
        }
        o.uk(BaseApplication.mContext.getString(R.string.select_max_netdisk_files, new Object[]{Integer.valueOf(i3)}));
        return true;
    }

    public boolean onBackKeyPressed() {
        getActivity().finish();
        return super.onBackKeyPressed();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initMaxCount();
        initLoader(0, (Bundle) null);
    }

    public void onDestroy() {
        super.onDestroy();
        destroyLoader();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        EmptyView emptyView = (EmptyView) view.findViewById(R.id.empty_view);
        this.mEmptyView = emptyView;
        emptyView.setLoading(R.string.loading);
    }

    public void selectAll(boolean z) {
        LocalFileBaseCursorAdapter localFileBaseCursorAdapter = this.mAdapter;
        if (localFileBaseCursorAdapter != null) {
            int count = localFileBaseCursorAdapter.getCount();
            if (!z || !isOverSize(count)) {
                if (z) {
                    for (int i2 = 0; i2 < count; i2++) {
                        this.mAdapter.addSelectedPosition(getContext(), i2);
                    }
                } else {
                    this.mAdapter.removeAllSelectedPositions();
                }
                this.mAdapter.notifyDataSetChanged();
                ISelectChangeListener iSelectChangeListener = this.mSelectChangeListener;
                if (iSelectChangeListener != null) {
                    iSelectChangeListener.qw(this.mAdapter.getSelectedFilesCount(), this.mAdapter.getSelectableCount());
                }
            }
        }
    }

    public void setSelectChangeListener(ISelectChangeListener iSelectChangeListener) {
        this.mSelectChangeListener = iSelectChangeListener;
    }

    public void showEmptyView() {
        showEmptyView(R.string.this_folder_is_empty);
    }

    public void showEmptyView(int i2) {
        this.mEmptyView.setLoadNoData(i2);
    }
}
