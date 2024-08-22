package com.tera.scan.component.base.ui.widget.bottomsheets;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.aiscan.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.List;

public class SheetsDialog extends Dialog {
    public BottomSheetBehavior bottomSheetBehavior;
    public Activity mActivity;
    public View mRootView;
    public LinearLayout mSheetsBottomLayout;
    public RecyclerView mSheetsList;
    public TextView mSheetsTitle;
    public LinearLayout mSheetsTopLayout;

    public class ad extends BottomSheetBehavior.BottomSheetCallback {

        /* renamed from: ad  reason: collision with root package name */
        public int f6848ad = 0;

        /* renamed from: de  reason: collision with root package name */
        public int f6849de = 0;
        public int qw = 0;

        public ad() {
        }

        public void onSlide(@NonNull View view, float f) {
            if (this.f6848ad == 0) {
                this.f6848ad = SheetsDialog.this.mSheetsBottomLayout.getTop();
                this.f6849de = SheetsDialog.this.mSheetsBottomLayout.getBottom();
            }
            if (f <= 0.0f) {
                if (this.qw == 0) {
                    this.qw = view.getTop();
                }
                int top = view.getTop();
                int i2 = top - this.qw;
                int bottom = SheetsDialog.this.mSheetsBottomLayout.getBottom() + i2;
                int i3 = this.f6849de;
                if (bottom < i3) {
                    i2 = i3 - SheetsDialog.this.mSheetsBottomLayout.getBottom();
                }
                SheetsDialog.this.mSheetsBottomLayout.layout(SheetsDialog.this.mSheetsBottomLayout.getLeft(), SheetsDialog.this.mSheetsBottomLayout.getTop() + i2, SheetsDialog.this.mSheetsBottomLayout.getRight(), SheetsDialog.this.mSheetsBottomLayout.getBottom() + i2);
                this.qw = top;
                return;
            }
            this.qw = 0;
            int bottom2 = SheetsDialog.this.mSheetsBottomLayout.getBottom() - this.f6849de;
            if (SheetsDialog.this.mSheetsBottomLayout.getBottom() != this.f6849de) {
                SheetsDialog.this.mSheetsBottomLayout.layout(SheetsDialog.this.mSheetsBottomLayout.getLeft(), SheetsDialog.this.mSheetsBottomLayout.getTop() - bottom2, SheetsDialog.this.mSheetsBottomLayout.getRight(), SheetsDialog.this.mSheetsBottomLayout.getBottom() - bottom2);
            }
        }

        public void onStateChanged(@NonNull View view, int i2) {
            if (i2 == 5) {
                SheetsDialog.this.dismiss();
            }
        }
    }

    public class de implements View.OnClickListener {
        public de() {
        }

        public void onClick(View view) {
            SheetsDialog.this.animationDismiss();
        }
    }

    public class fe implements Animation.AnimationListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ View f6852ad;
        public final /* synthetic */ View.OnClickListener qw;

        public fe(View.OnClickListener onClickListener, View view) {
            this.qw = onClickListener;
            this.f6852ad = view;
        }

        public void onAnimationEnd(Animation animation) {
            SheetsDialog.this.dismiss();
            View.OnClickListener onClickListener = this.qw;
            if (onClickListener != null) {
                onClickListener.onClick(this.f6852ad);
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public class qw implements View.OnClickListener {
        public qw() {
        }

        public void onClick(View view) {
            SheetsDialog.this.animationDismiss();
        }
    }

    public class rg implements View.OnClickListener {

        /* renamed from: ad  reason: collision with root package name */
        public View.OnClickListener f6855ad;

        public rg(View.OnClickListener onClickListener) {
            this.f6855ad = onClickListener;
        }

        public void onClick(View view) {
            SheetsDialog.this.animationDismiss(this.f6855ad, view);
        }
    }

    public SheetsDialog(Activity activity, fe.mmm.qw.th.qw.rg.fe.qw.qw qwVar) {
        super(activity, R.style.BaiduNetDiskDialogTheme);
        this.mActivity = activity;
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes = attributes == null ? new WindowManager.LayoutParams() : attributes;
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            setContentView(R.layout.sheets_menu_layout);
            findViewById(R.id.bottom_sheets_layout).setOnClickListener(new qw());
            BottomSheetBehavior from = BottomSheetBehavior.from(findViewById(R.id.bottom_sheets_layout));
            this.bottomSheetBehavior = from;
            from.setBottomSheetCallback(new ad());
            this.mRootView = findViewById(R.id.sheets_root);
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.sheets_list);
            this.mSheetsList = recyclerView;
            recyclerView.setLayoutManager(new LinearLayoutManager(activity));
            this.mSheetsList.getItemAnimator().setChangeDuration(0);
            this.mSheetsBottomLayout = (LinearLayout) findViewById(R.id.sheets_bottom_layout);
            this.mSheetsTopLayout = (LinearLayout) findViewById(R.id.sheets_top_layout);
            this.mSheetsTitle = (TextView) findViewById(R.id.sheets_dialog_title);
            if (TextUtils.isEmpty(qwVar.rg())) {
                this.mSheetsTitle.setVisibility(8);
            } else {
                this.mSheetsTitle.setVisibility(0);
                this.mSheetsTitle.setText(qwVar.rg());
            }
            findViewById(R.id.sheets_null_content).setOnClickListener(new de());
            List<View> fe2 = qwVar.fe();
            for (View addView : fe2) {
                this.mSheetsTopLayout.addView(addView, 0);
            }
            if (TextUtils.isEmpty(qwVar.rg()) && fe2.size() == 0) {
                View view = new View(activity);
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, activity.getResources().getDimensionPixelSize(R.dimen.dimen_15dp)));
                view.setBackgroundColor(0);
                this.mSheetsTopLayout.addView(view);
            }
            int i2 = 0;
            for (View next : qwVar.de()) {
                i2 += next.getLayoutParams().height;
                this.mSheetsBottomLayout.addView(next);
            }
            this.mSheetsList.setPadding(0, 0, 0, i2);
            RecyclerView.Adapter ad2 = qwVar.ad();
            if (ad2 != null) {
                this.mSheetsList.setAdapter(ad2);
            } else {
                for (fe.mmm.qw.th.qw.rg.fe.qw.ad next2 : qwVar.qw()) {
                    next2.fe(new rg(next2.qw()));
                }
                this.mSheetsList.setAdapter(new SheetsItemAdapter(qwVar.qw()));
            }
            setCanceledOnTouchOutside(true);
        }
    }

    public void animationDismiss() {
        animationDismiss((View.OnClickListener) null, (View) null);
    }

    public void onBackPressed() {
        animationDismiss();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View view = this.mRootView;
        if (view != null) {
            view.clearAnimation();
            this.mRootView.setAnimation(AnimationUtils.loadAnimation(this.mRootView.getContext(), R.anim.pop_slide_from_down_to_top));
            this.mRootView.getAnimation().startNow();
        }
    }

    public void animationDismiss(View.OnClickListener onClickListener, View view) {
        Activity activity = this.mActivity;
        if (activity != null && !activity.isFinishing() && isShowing()) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mActivity, R.anim.pop_slide_from_top_to_down);
            loadAnimation.setFillAfter(true);
            loadAnimation.setAnimationListener(new fe(onClickListener, view));
            this.mRootView.clearAnimation();
            this.mRootView.startAnimation(loadAnimation);
        }
    }
}
