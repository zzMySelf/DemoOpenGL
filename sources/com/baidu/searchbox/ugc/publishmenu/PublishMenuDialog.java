package com.baidu.searchbox.ugc.publishmenu;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import com.baidu.android.ext.widget.PopupWindow;
import com.baidu.searchbox.rewardsystem.newtimer.constants.NewTimerConstants;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.utils.ResourceUtils;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.searchbox.ugc.utils.UgcUiUtils;
import com.baidu.searchbox.ugc.utils.UiBaseUtils;
import com.baidu.searchbox.ugc.webjs.UgcSchemeModel;
import java.util.ArrayList;
import java.util.List;

public class PublishMenuDialog extends PopupWindow {
    private static final int PUBLISH_MENU_ANIM_DURATION = 240;
    /* access modifiers changed from: private */
    public PublishMenuAdapter mAdapter;
    private View mCloseView;
    private Context mContext;
    private GridView mGridView;
    private View mMenuMask;
    /* access modifiers changed from: private */
    public OnItemClickListener mOnItemClickListener;
    /* access modifiers changed from: private */
    public View mPublishMenu;
    /* access modifiers changed from: private */
    public View mRootView;

    public interface OnItemClickListener {
        void onItemClick(ItemInfo itemInfo);
    }

    public PublishMenuDialog(Context context, UgcSchemeModel info) {
        super(context);
        this.mContext = context;
        UgcUBCUtils.enterUgc();
        initWindow();
        initView();
    }

    private void initWindow() {
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        setClippingEnabled(false);
        if (Build.VERSION.SDK_INT > 29) {
            setLayoutInScreenEnabled(true);
        }
    }

    private void initView() {
        View view2 = View.inflate(this.mContext, R.layout.ugc_publish_dialog, (ViewGroup) null);
        this.mRootView = view2;
        this.mPublishMenu = view2.findViewById(ResourceUtils.getResIdByName("ugc_items_layout"));
        this.mGridView = (GridView) view2.findViewById(ResourceUtils.getResIdByName("ugc_grid_view"));
        this.mCloseView = view2.findViewById(ResourceUtils.getResIdByName("ugc_close_view"));
        this.mMenuMask = view2.findViewById(ResourceUtils.getResIdByName("ugc_publish_menu_mask"));
        updataUi(view2);
        UiBaseUtils.setOnClickListener(this.mMenuMask, new View.OnClickListener() {
            public void onClick(View view2) {
                PublishMenuDialog.this.dismiss();
            }
        });
        UiBaseUtils.setOnClickListener(this.mCloseView, new View.OnClickListener() {
            public void onClick(View v) {
                UgcUBCUtils.clickLayerStatistics(2, UgcUBCUtils.mLayerBtnPage);
                PublishMenuDialog.this.dismiss();
            }
        });
        PublishMenuAdapter publishMenuAdapter = new PublishMenuAdapter(this.mContext);
        this.mAdapter = publishMenuAdapter;
        GridView gridView = this.mGridView;
        if (gridView != null) {
            gridView.setAdapter(publishMenuAdapter);
            this.mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view2, int position, long id) {
                    if (PublishMenuDialog.this.mOnItemClickListener != null) {
                        PublishMenuDialog.this.mOnItemClickListener.onItemClick(PublishMenuDialog.this.mAdapter.getItem(position));
                    }
                }
            });
        }
        setContentView(view2);
    }

    /* access modifiers changed from: private */
    public void updataUi(View view2) {
        if (view2 != null) {
            UgcUiUtils.setViewDrawable(view2.findViewById(ResourceUtils.getResIdByName("ugc_items_layout")), R.drawable.ugc_publish_menu_dialog);
            UgcUiUtils.setViewColor(view2.findViewById(ResourceUtils.getResIdByName("ugc_publish_dialog_line")), R.color.ugc_diolog_line_color);
            UgcUiUtils.setTextResource((TextView) this.mCloseView, R.color.ugc_publish_menu_text_selector);
        }
    }

    public void show() {
        Activity activity = UgcUiUtils.getActivity(this.mContext);
        if (activity != null) {
            showAtLocation(activity.findViewById(16908290), 80, 0, 0);
            if (this.mPublishMenu.getHeight() == 0) {
                this.mPublishMenu.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        PublishMenuDialog.this.popupEnterAnim();
                        PublishMenuDialog.this.mPublishMenu.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            } else {
                popupEnterAnim();
            }
            NightModeHelper.subscribeNightModeChangeEvent(this, new NightModeChangeListener() {
                public void onNightModeChanged(boolean b2) {
                    PublishMenuDialog publishMenuDialog = PublishMenuDialog.this;
                    publishMenuDialog.updataUi(publishMenuDialog.mRootView);
                    if (PublishMenuDialog.this.mAdapter != null) {
                        PublishMenuDialog.this.mAdapter.notifyDataSetChanged();
                    }
                }
            });
            UgcUBCUtils.ubcUgcPublishBehavior("publish_layer", "display", (String) null);
        }
    }

    /* access modifiers changed from: private */
    public void popupEnterAnim() {
        this.mMenuMask.setAlpha(0.0f);
        View view2 = this.mPublishMenu;
        view2.setTranslationY((float) view2.getHeight());
        ObjectAnimator maskAnim = ObjectAnimator.ofFloat(this.mMenuMask, "alpha", new float[]{1.0f});
        maskAnim.setDuration(240);
        maskAnim.setInterpolator(new LinearInterpolator());
        ObjectAnimator publishMenuAnim = ObjectAnimator.ofFloat(this.mPublishMenu, NewTimerConstants.NEWTIMER_ANIMATION_TRANSLATIONY, new float[]{0.0f});
        publishMenuAnim.setDuration(240);
        publishMenuAnim.setInterpolator(new LinearInterpolator());
        List<Animator> animators = new ArrayList<>();
        animators.add(maskAnim);
        animators.add(publishMenuAnim);
        AnimatorSet publishEnterAnimSet = new AnimatorSet();
        publishEnterAnimSet.playTogether(animators);
        publishEnterAnimSet.start();
    }

    private void popupExitAnim() {
        ObjectAnimator maskAnim = ObjectAnimator.ofFloat(this.mMenuMask, "alpha", new float[]{0.0f});
        maskAnim.setDuration(240);
        maskAnim.setInterpolator(new LinearInterpolator());
        View view2 = this.mPublishMenu;
        ObjectAnimator publishMenuAnim = ObjectAnimator.ofFloat(view2, NewTimerConstants.NEWTIMER_ANIMATION_TRANSLATIONY, new float[]{(float) view2.getHeight()});
        publishMenuAnim.setDuration(240);
        publishMenuAnim.setInterpolator(new LinearInterpolator());
        List<Animator> animators = new ArrayList<>();
        animators.add(maskAnim);
        animators.add(publishMenuAnim);
        AnimatorSet publishExitAnimSet = new AnimatorSet();
        publishExitAnimSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                PublishMenuDialog.super.dismiss();
            }
        });
        publishExitAnimSet.playTogether(animators);
        publishExitAnimSet.start();
    }

    public void dismiss() {
        NightModeHelper.unsubscribeNightModeChangedEvent(this);
        popupExitAnim();
        UgcUBCUtils.exitPages(-1, "publish_layer");
    }

    public void setData(List<String> types) {
        if (types != null && types.size() != 0) {
            if (types.contains("4")) {
                if (types.contains("0")) {
                    types.remove("4");
                } else {
                    types.set(types.indexOf("4"), "0");
                }
            }
            if (types.size() > 10) {
                types = types.subList(0, 10);
            }
            List<ItemInfo> list = new ArrayList<>();
            for (String type : types) {
                ItemInfo item = ItemInfo.newInstance(type);
                if (item != null) {
                    list.add(item);
                }
            }
            GridView gridView = this.mGridView;
            if (gridView != null) {
                gridView.setNumColumns(computeColumn(list.size()));
            }
            PublishMenuAdapter publishMenuAdapter = this.mAdapter;
            if (publishMenuAdapter != null) {
                publishMenuAdapter.updateAll(list);
            }
        }
    }

    private int computeColumn(int iconCount) {
        if (iconCount <= 5) {
            return iconCount;
        }
        if (iconCount == 6) {
            return 3;
        }
        if (iconCount == 7 || iconCount == 8) {
            return 4;
        }
        return 5;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        super.setOnDismissListener(onDismissListener);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}
