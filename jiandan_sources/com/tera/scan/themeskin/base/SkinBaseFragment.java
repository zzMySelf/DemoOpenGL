package com.tera.scan.themeskin.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.tera.scan.themeskin.listener.IDynamicNewView;
import com.tera.scan.themeskin.loader.ISkinChangeListener;
import fe.mmm.qw.d.ad.ggg.ad;
import fe.mmm.qw.d.de.qw;
import java.util.List;

public class SkinBaseFragment extends Fragment implements IDynamicNewView, ISkinChangeListener {
    public IDynamicNewView mIDynamicNewView;
    public boolean mIsObserveSkinChange = false;

    private void removeViewInSkinInflaterFactory(View view) {
        if (getSkinInflaterFactory() != null) {
            getSkinInflaterFactory().o(view);
        }
    }

    public final void dynamicAddFontView(TextView textView) {
        this.mIDynamicNewView.dynamicAddFontView(textView);
    }

    public final void dynamicAddView(View view, List<ad> list) {
        IDynamicNewView iDynamicNewView = this.mIDynamicNewView;
        if (iDynamicNewView != null) {
            iDynamicNewView.dynamicAddView(view, list);
            return;
        }
        throw new RuntimeException("IDynamicNewView should be implements !");
    }

    public final fe.mmm.qw.d.de.ad getSkinInflaterFactory() {
        if (getActivity() instanceof SkinBaseActivity) {
            return ((SkinBaseActivity) getActivity()).getInflaterFactory();
        }
        return null;
    }

    public boolean isObserveSkinChange() {
        return this.mIsObserveSkinChange;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.mIDynamicNewView = (IDynamicNewView) context;
        } catch (ClassCastException unused) {
            this.mIDynamicNewView = null;
        }
        if (isObserveSkinChange()) {
            qw.qw.qw(this);
        }
    }

    public void onDestroyView() {
        removeAllView(getView());
        super.onDestroyView();
    }

    public void onDetach() {
        super.onDetach();
        if (isObserveSkinChange()) {
            qw.qw.ad(this);
        }
    }

    public void onSkinChanged() {
    }

    public void removeAllView(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                removeAllView(viewGroup.getChildAt(i2));
            }
            removeViewInSkinInflaterFactory(view);
            return;
        }
        removeViewInSkinInflaterFactory(view);
    }

    public final void dynamicAddView(View view, String str, int i2) {
        this.mIDynamicNewView.dynamicAddView(view, str, i2);
    }
}
