package com.baidu.searchbox.bookmark;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.android.common.ui.style.R;
import com.baidu.searchbox.bookmark.adapter.FavorsChooseDirAdapter;
import java.util.ArrayList;
import java.util.List;

public class FavorsMoveToDirDialogFragment extends DialogFragment {
    private static final float FRAGMENT_WIDTH_PERCENT = 0.88f;
    public static final String KEY_CURRENT_DIR = "currentDir";
    public static final String KEY_DIRS_DATA = "dirs";
    private View mBtnDivider;
    private Button mCancel;
    private View mContentDivider;
    private String mCurrentDir;
    /* access modifiers changed from: private */
    public String mCurrentSelectedDir;
    /* access modifiers changed from: private */
    public FavorsChooseDirAdapter mFavorsChooseDirAdapter;
    private ListView mListview;
    private Button mMove;
    private View mRootView;
    private TextView mTitle;

    public interface FavorsChooseDirCallBack {
        void doMove(String str);

        void onMoved(boolean z);
    }

    public static FavorsMoveToDirDialogFragment newInstance(ArrayList<String> data, String curDir) {
        FavorsMoveToDirDialogFragment fragment = new FavorsMoveToDirDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("dirs", data);
        bundle.putString("currentDir", curDir);
        fragment.setArguments(bundle);
        return fragment;
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics dm = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
            dialog.getWindow().setLayout((int) (((float) dm.widthPixels) * FRAGMENT_WIDTH_PERCENT), -2);
        }
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(getActivity(), R.style.Dialog_No_Border);
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        dialog.getWindow().setLayout((int) (((float) dm.widthPixels) * FRAGMENT_WIDTH_PERCENT), -2);
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        if (inflater != null) {
            View inflate = inflater.inflate(com.baidu.searchbox.favor.R.layout.dialog_single_choice, (ViewGroup) null);
            this.mRootView = inflate;
            this.mTitle = (TextView) inflate.findViewById(com.baidu.searchbox.favor.R.id.title);
            ListView listView = (ListView) this.mRootView.findViewById(com.baidu.searchbox.favor.R.id.listview);
            this.mListview = listView;
            listView.setDividerHeight(0);
            this.mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view2, int position, long id) {
                    String unused = FavorsMoveToDirDialogFragment.this.mCurrentSelectedDir = "";
                    if (FavorsMoveToDirDialogFragment.this.mFavorsChooseDirAdapter != null) {
                        FavorsMoveToDirDialogFragment.this.mFavorsChooseDirAdapter.setSelectedPosition(position);
                        List<String> data = FavorsMoveToDirDialogFragment.this.mFavorsChooseDirAdapter.getData();
                        if (data != null && data.size() > 0 && position < data.size()) {
                            String unused2 = FavorsMoveToDirDialogFragment.this.mCurrentSelectedDir = data.get(position);
                        }
                    }
                }
            });
            this.mContentDivider = this.mRootView.findViewById(com.baidu.searchbox.favor.R.id.content_divider);
            this.mBtnDivider = this.mRootView.findViewById(com.baidu.searchbox.favor.R.id.btn_divider);
            Button button = (Button) this.mRootView.findViewById(com.baidu.searchbox.favor.R.id.btn_cancel);
            this.mCancel = button;
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    FavorsMoveToDirDialogFragment.this.dismiss();
                }
            });
            Button button2 = (Button) this.mRootView.findViewById(com.baidu.searchbox.favor.R.id.btn_move);
            this.mMove = button2;
            button2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    FavorsMoveToDirDialogFragment.this.dismiss();
                    if (FavorsMoveToDirDialogFragment.this.getActivity() != null && (FavorsMoveToDirDialogFragment.this.getActivity() instanceof FavorsChooseDirCallBack)) {
                        if (FavorsMoveToDirDialogFragment.this.mCurrentSelectedDir == null) {
                            FavorsMoveToDirDialogFragment favorsMoveToDirDialogFragment = FavorsMoveToDirDialogFragment.this;
                            String unused = favorsMoveToDirDialogFragment.mCurrentSelectedDir = favorsMoveToDirDialogFragment.getString(com.baidu.searchbox.favor.R.string.favor_root_dir);
                        }
                        ((FavorsChooseDirCallBack) FavorsMoveToDirDialogFragment.this.getActivity()).doMove(FavorsMoveToDirDialogFragment.this.mCurrentSelectedDir);
                    }
                }
            });
            setPageResources();
            Bundle bundle = getArguments();
            if (bundle != null) {
                String string = bundle.getString("currentDir", "");
                this.mCurrentDir = string;
                this.mCurrentSelectedDir = string;
                ArrayList<String> data = bundle.getStringArrayList("dirs");
                FavorsChooseDirAdapter favorsChooseDirAdapter = new FavorsChooseDirAdapter(getActivity(), data);
                this.mFavorsChooseDirAdapter = favorsChooseDirAdapter;
                this.mListview.setAdapter(favorsChooseDirAdapter);
                setDefaultSelection(data);
            }
            dialog.setContentView(this.mRootView);
        }
        return dialog;
    }

    public void setDefaultSelection(List<String> data) {
        if (data != null && data.size() >= 1) {
            int position = 0;
            int index = 0;
            while (true) {
                if (index >= data.size()) {
                    break;
                } else if (TextUtils.equals(data.get(index), this.mCurrentDir)) {
                    position = index;
                    break;
                } else {
                    index++;
                }
            }
            FavorsChooseDirAdapter favorsChooseDirAdapter = this.mFavorsChooseDirAdapter;
            if (favorsChooseDirAdapter != null) {
                favorsChooseDirAdapter.setSelectedPosition(position);
            }
            ListView listView = this.mListview;
            if (listView != null) {
                listView.smoothScrollToPosition(position);
            }
        }
    }

    private void setPageResources() {
        View view2 = this.mRootView;
        if (view2 != null) {
            view2.setBackgroundDrawable(getResources().getDrawable(R.drawable.dialog_bg_white));
        }
        ListView listView = this.mListview;
        if (listView != null) {
            listView.setBackgroundColor(getResources().getColor(R.color.white));
        }
        TextView textView = this.mTitle;
        if (textView != null) {
            textView.setTextColor(getResources().getColor(com.baidu.searchbox.userassetsaggr.container.R.color.bookmark_search_cancel_normal));
        }
        View view3 = this.mContentDivider;
        if (view3 != null) {
            view3.setBackgroundColor(getResources().getColor(com.baidu.searchbox.userassetsaggr.container.R.color.bookmark_search_vertical_line));
        }
        View view4 = this.mBtnDivider;
        if (view4 != null) {
            view4.setBackgroundColor(getResources().getColor(com.baidu.searchbox.userassetsaggr.container.R.color.bookmark_search_vertical_line));
        }
        Button button = this.mCancel;
        if (button != null) {
            button.setBackgroundDrawable(getResources().getDrawable(R.drawable.alertdialog_button_day_bg_all_selector));
            this.mCancel.setTextColor(getResources().getColor(com.baidu.searchbox.favor.R.color.cancel_btn_text_color));
        }
        Button button2 = this.mMove;
        if (button2 != null) {
            button2.setBackgroundDrawable(getResources().getDrawable(R.drawable.alertdialog_button_day_bg_all_selector));
            this.mMove.setTextColor(getResources().getColor(com.baidu.searchbox.favor.R.color.cancel_btn_text_color));
        }
    }
}
