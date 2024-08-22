package com.baidu.searchbox.video.widget;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.ext.widget.LoadingView;

public class LoadingDialogFragment extends DialogFragment {
    private static final String KEY_LOADING_MESSAGE = "LOADING_MESSAGE";

    private LoadingDialogFragment() {
    }

    public static LoadingDialogFragment newInstance(String msg) {
        Bundle args = new Bundle();
        args.putString(KEY_LOADING_MESSAGE, msg);
        LoadingDialogFragment dialogFragment = new LoadingDialogFragment();
        dialogFragment.setArguments(args);
        return dialogFragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(1, 0);
        setCancelable(false);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LoadingView mLoadingView = new LoadingView(getActivity());
        if (getArguments() != null) {
            mLoadingView.setMsg(getArguments().getString(KEY_LOADING_MESSAGE));
        }
        return mLoadingView;
    }

    public void setMessage(String msg) {
        Bundle args = getArguments();
        if (args == null) {
            args = new Bundle();
        }
        args.putString(KEY_LOADING_MESSAGE, msg);
    }
}
