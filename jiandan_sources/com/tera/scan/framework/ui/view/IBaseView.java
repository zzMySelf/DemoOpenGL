package com.tera.scan.framework.ui.view;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelStoreOwner;

public interface IBaseView {
    FragmentActivity getActivity();

    ViewModelStoreOwner getViewModelStoreOwner();
}
