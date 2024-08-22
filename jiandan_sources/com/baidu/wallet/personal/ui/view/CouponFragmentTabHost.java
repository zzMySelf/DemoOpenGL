package com.baidu.wallet.personal.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.util.ArrayList;

public class CouponFragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {
    public static final String a = CouponFragmentTabHost.class.getSimpleName();
    public final ArrayList<c> b = new ArrayList<>();
    public FrameLayout c;
    public Context d;
    public FragmentManager e;
    public int f;
    public TabHost.OnTabChangeListener g;
    public c h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3645i;

    public static class a implements TabHost.TabContentFactory {
        public final Context a;

        public a(Context context) {
            this.a = context;
        }

        public View createTabContent(String str) {
            View view = new View(this.a);
            view.setMinimumWidth(0);
            view.setMinimumHeight(0);
            return view;
        }
    }

    public static class b extends View.BaseSavedState {
        public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() {
            /* renamed from: a */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            /* renamed from: a */
            public b[] newArray(int i2) {
                return new b[i2];
            }
        };
        public String a;

        public b(Parcel parcel) {
            super(parcel);
            this.a = parcel.readString();
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.a + "}";
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.a);
        }
    }

    public static final class c {
        public int a;
        public final String b;
        public final Class<?> c;
        public final Bundle d;
        public Fragment e;

        public c(String str, Class<?> cls, Bundle bundle) {
            this.b = str;
            this.c = cls;
            this.d = bundle;
            this.a = 0;
        }

        public c(String str, Class<?> cls, Bundle bundle, int i2) {
            this(str, cls, bundle);
            this.a = i2;
        }
    }

    public CouponFragmentTabHost(Context context) {
        super(context, (AttributeSet) null);
        a(context, (AttributeSet) null);
    }

    public CouponFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    private FragmentTransaction a(String str, FragmentTransaction fragmentTransaction) {
        c cVar = null;
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            c cVar2 = this.b.get(i2);
            if (cVar2.b.equals(str)) {
                cVar = cVar2;
            }
        }
        if (cVar == null) {
            throw new IllegalStateException("No tab known for tag " + str);
        } else if (cVar.a == 1) {
            c cVar3 = this.h;
            if (cVar3 != null && !TextUtils.isEmpty(cVar3.b)) {
                setCurrentTabByTag(this.h.b);
            }
            return null;
        } else {
            if (this.h != cVar) {
                if (fragmentTransaction == null) {
                    fragmentTransaction = this.e.beginTransaction();
                }
                c cVar4 = this.h;
                if (!(cVar4 == null || cVar4.e == null)) {
                    if (this.h.a == 2) {
                        fragmentTransaction.hide(this.h.e);
                    } else {
                        fragmentTransaction.detach(this.h.e);
                    }
                }
                if (cVar.e == null) {
                    Fragment unused = cVar.e = Fragment.instantiate(this.d, cVar.c.getName(), cVar.d);
                    if (!cVar.e.isAdded()) {
                        fragmentTransaction.add(this.f, cVar.e, cVar.b);
                    }
                } else {
                    int c2 = cVar.a;
                    fragmentTransaction.attach(cVar.e);
                    fragmentTransaction.show(cVar.e);
                }
                this.h = cVar;
            }
            return fragmentTransaction;
        }
    }

    private void a() {
        Context context = getContext();
        if (findViewById(16908307) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
            TabWidget tabWidget = new TabWidget(context);
            tabWidget.setId(16908307);
            tabWidget.setOrientation(0);
            linearLayout.addView(tabWidget, new LinearLayout.LayoutParams(-1, -2, 0.0f));
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setId(16908305);
            linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(0, 0, 0.0f));
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.c = frameLayout2;
            frameLayout2.setId(this.f);
            linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
        if (this.c == null) {
            FrameLayout frameLayout3 = (FrameLayout) findViewById(this.f);
            this.c = frameLayout3;
            if (frameLayout3 == null) {
                throw new IllegalStateException("No tab content FrameLayout found for id " + this.f);
            }
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.f = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    /* access modifiers changed from: private */
    public void b() {
        FragmentTransaction a2;
        String currentTabTag = getCurrentTabTag();
        FragmentTransaction fragmentTransaction = null;
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            c cVar = this.b.get(i2);
            Fragment unused = cVar.e = this.e.findFragmentByTag(cVar.b);
            if (cVar.e != null && !cVar.e.isDetached()) {
                if (cVar.b.equals(currentTabTag)) {
                    this.h = cVar;
                } else {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.e.beginTransaction();
                    }
                    fragmentTransaction.detach(cVar.e);
                }
            }
        }
        this.f3645i = true;
        if (!TextUtils.isEmpty(currentTabTag) && (a2 = a(currentTabTag, fragmentTransaction)) != null) {
            a2.commitAllowingStateLoss();
            FragmentManager fragmentManager = this.e;
            if (fragmentManager != null && !fragmentManager.isDestroyed()) {
                this.e.executePendingTransactions();
            }
        }
    }

    public void a(Context context, FragmentManager fragmentManager, int i2) {
        super.setup();
        this.d = context;
        this.e = fragmentManager;
        this.f = i2;
        a();
        this.c.setId(i2);
        if (getId() == -1) {
            setId(16908306);
        }
    }

    public void a(TabHost.TabSpec tabSpec, Class<?> cls, Bundle bundle, int i2) {
        tabSpec.setContent(new a(this.d));
        String tag = tabSpec.getTag();
        c cVar = new c(tag, cls, bundle, i2);
        if (this.f3645i) {
            Fragment unused = cVar.e = this.e.findFragmentByTag(tag);
            if (cVar.e != null && !cVar.e.isDetached()) {
                FragmentTransaction beginTransaction = this.e.beginTransaction();
                beginTransaction.detach(cVar.e);
                beginTransaction.commitAllowingStateLoss();
            }
        }
        this.b.add(cVar);
        addTab(tabSpec);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        if (TextUtils.isEmpty(currentTabTag)) {
            postDelayed(new Runnable() {
                public void run() {
                    CouponFragmentTabHost.this.b();
                }
            }, 50);
            return;
        }
        FragmentTransaction fragmentTransaction = null;
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            c cVar = this.b.get(i2);
            Fragment unused = cVar.e = this.e.findFragmentByTag(cVar.b);
            if (cVar.e != null && !cVar.e.isDetached()) {
                if (cVar.b.equals(currentTabTag)) {
                    this.h = cVar;
                } else {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.e.beginTransaction();
                    }
                    fragmentTransaction.detach(cVar.e);
                }
            }
        }
        this.f3645i = true;
        FragmentTransaction a2 = a(currentTabTag, fragmentTransaction);
        if (a2 != null) {
            a2.commitAllowingStateLoss();
            this.e.executePendingTransactions();
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3645i = false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        setCurrentTabByTag(bVar.a);
    }

    public Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.a = getCurrentTabTag();
        return bVar;
    }

    public void onTabChanged(String str) {
        FragmentTransaction a2;
        if (this.f3645i && (a2 = a(str, (FragmentTransaction) null)) != null) {
            a2.commitAllowingStateLoss();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.g;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.g = onTabChangeListener;
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }
}
