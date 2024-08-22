package com.baidu.searchbox.youthhome.content.inter;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0012H\u0016J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0016H\u0016J\u001c\u0010\"\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\n\u0010'\u001a\u0004\u0018\u00010$H\u0016J \u0010(\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010)\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/baidu/searchbox/youthhome/content/inter/IYouthHomeContentAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "(Landroidx/fragment/app/FragmentManager;)V", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "mCurTransaction", "Landroidx/fragment/app/FragmentTransaction;", "mCurrentPrimaryItem", "Landroidx/fragment/app/Fragment;", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "frag", "", "finishUpdate", "getItem", "getItemId", "", "getItemPosition", "object", "instantiateItem", "isViewFromObject", "", "view", "Landroid/view/View;", "makeFragmentName", "", "viewId", "id", "restoreState", "state", "Landroid/os/Parcelable;", "loader", "Ljava/lang/ClassLoader;", "saveState", "setPrimaryItem", "startUpdate", "youth-home-content_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IYouthHomeContentAdapter.kt */
public abstract class IYouthHomeContentAdapter extends PagerAdapter {
    private final FragmentManager fragmentManager;
    private FragmentTransaction mCurTransaction;
    private Fragment mCurrentPrimaryItem;

    public abstract Fragment getItem(int i2);

    public IYouthHomeContentAdapter(FragmentManager fragmentManager2) {
        Intrinsics.checkNotNullParameter(fragmentManager2, "fragmentManager");
        this.fragmentManager = fragmentManager2;
    }

    public final FragmentManager getFragmentManager() {
        return this.fragmentManager;
    }

    public int getItemPosition(Object object) {
        Intrinsics.checkNotNullParameter(object, "object");
        return -2;
    }

    public void startUpdate(ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
    }

    public Object instantiateItem(ViewGroup container, int position) {
        Intrinsics.checkNotNullParameter(container, "container");
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.fragmentManager.beginTransaction();
        }
        long itemId = getItemId(position);
        Fragment fragment = this.fragmentManager.findFragmentByTag(makeFragmentName(container.getId(), itemId));
        if (fragment != null) {
            FragmentTransaction fragmentTransaction = this.mCurTransaction;
            if (fragmentTransaction != null) {
                fragmentTransaction.attach(fragment);
            }
        } else {
            fragment = getItem(position);
            FragmentTransaction fragmentTransaction2 = this.mCurTransaction;
            if (fragmentTransaction2 != null) {
                fragmentTransaction2.add(container.getId(), fragment, makeFragmentName(container.getId(), itemId));
            }
        }
        if (fragment != this.mCurrentPrimaryItem) {
            fragment.setMenuVisibility(false);
            FragmentTransaction fragmentTransaction3 = this.mCurTransaction;
            if (fragmentTransaction3 != null) {
                fragmentTransaction3.setMaxLifecycle(fragment, Lifecycle.State.STARTED);
            }
        }
        return fragment;
    }

    public void destroyItem(ViewGroup container, int position, Object frag) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(frag, "frag");
        Fragment fragment = (Fragment) frag;
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.fragmentManager.beginTransaction();
        }
        FragmentTransaction fragmentTransaction = this.mCurTransaction;
        if (fragmentTransaction != null) {
            fragmentTransaction.detach(fragment);
        }
        if (Intrinsics.areEqual((Object) fragment, (Object) this.mCurrentPrimaryItem)) {
            this.mCurrentPrimaryItem = null;
        }
    }

    public void setPrimaryItem(ViewGroup container, int position, Object frag) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(frag, "frag");
        Fragment fragment = (Fragment) frag;
        Fragment fragment2 = this.mCurrentPrimaryItem;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(false);
                }
                if (this.mCurTransaction == null) {
                    this.mCurTransaction = this.fragmentManager.beginTransaction();
                }
                FragmentTransaction fragmentTransaction = this.mCurTransaction;
                if (fragmentTransaction != null) {
                    Fragment fragment3 = this.mCurrentPrimaryItem;
                    Intrinsics.checkNotNull(fragment3);
                    fragmentTransaction.setMaxLifecycle(fragment3, Lifecycle.State.STARTED);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.mCurTransaction == null) {
                this.mCurTransaction = this.fragmentManager.beginTransaction();
            }
            FragmentTransaction fragmentTransaction2 = this.mCurTransaction;
            if (fragmentTransaction2 != null) {
                fragmentTransaction2.setMaxLifecycle(fragment, Lifecycle.State.RESUMED);
            }
            this.mCurrentPrimaryItem = fragment;
        }
    }

    public void finishUpdate(ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
        FragmentTransaction fragmentTransaction = this.mCurTransaction;
        if (fragmentTransaction != null) {
            if (fragmentTransaction != null) {
                try {
                    fragmentTransaction.commitNowAllowingStateLoss();
                } catch (Exception e2) {
                    FragmentTransaction fragmentTransaction2 = this.mCurTransaction;
                    if (fragmentTransaction2 != null) {
                        fragmentTransaction2.commitAllowingStateLoss();
                    }
                }
            }
            this.mCurTransaction = null;
        }
    }

    public boolean isViewFromObject(View view2, Object frag) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(frag, "frag");
        return Intrinsics.areEqual((Object) ((Fragment) frag).getView(), (Object) view2);
    }

    public Parcelable saveState() {
        return null;
    }

    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public String makeFragmentName(int viewId, long id) {
        return "android:switcher:" + viewId + AbstractJsonLexerKt.COLON + id;
    }
}
