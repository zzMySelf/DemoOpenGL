package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import fe.rg.qw.ad;
import fe.rg.qw.th;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Deprecated
public class RequestManagerFragment extends Fragment {
    public static final String TAG = "RMFragment";
    public final Set<RequestManagerFragment> childRequestManagerFragments;
    public final fe.rg.qw.pf.qw lifecycle;
    @Nullable
    public Fragment parentFragmentHint;
    @Nullable
    public th requestManager;
    public final RequestManagerTreeNode requestManagerTreeNode;
    @Nullable
    public RequestManagerFragment rootRequestManagerFragment;

    public class qw implements RequestManagerTreeNode {
        public qw() {
        }

        public String toString() {
            return super.toString() + "{fragment=" + RequestManagerFragment.this + "}";
        }
    }

    public RequestManagerFragment() {
        this(new fe.rg.qw.pf.qw());
    }

    private void addChildRequestManagerFragment(RequestManagerFragment requestManagerFragment) {
        this.childRequestManagerFragments.add(requestManagerFragment);
    }

    @TargetApi(17)
    @Nullable
    private Fragment getParentFragmentUsingHint() {
        Fragment parentFragment = Build.VERSION.SDK_INT >= 17 ? getParentFragment() : null;
        return parentFragment != null ? parentFragment : this.parentFragmentHint;
    }

    @TargetApi(17)
    private boolean isDescendant(@NonNull Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private void registerFragmentWithRoot(@NonNull Activity activity) {
        unregisterFragmentWithRoot();
        RequestManagerFragment ggg = ad.de(activity).pf().ggg(activity);
        this.rootRequestManagerFragment = ggg;
        if (!equals(ggg)) {
            this.rootRequestManagerFragment.addChildRequestManagerFragment(this);
        }
    }

    private void removeChildRequestManagerFragment(RequestManagerFragment requestManagerFragment) {
        this.childRequestManagerFragments.remove(requestManagerFragment);
    }

    private void unregisterFragmentWithRoot() {
        RequestManagerFragment requestManagerFragment = this.rootRequestManagerFragment;
        if (requestManagerFragment != null) {
            requestManagerFragment.removeChildRequestManagerFragment(this);
            this.rootRequestManagerFragment = null;
        }
    }

    @TargetApi(17)
    @NonNull
    public Set<RequestManagerFragment> getDescendantRequestManagerFragments() {
        if (equals(this.rootRequestManagerFragment)) {
            return Collections.unmodifiableSet(this.childRequestManagerFragments);
        }
        if (this.rootRequestManagerFragment == null || Build.VERSION.SDK_INT < 17) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        for (RequestManagerFragment next : this.rootRequestManagerFragment.getDescendantRequestManagerFragments()) {
            if (isDescendant(next.getParentFragment())) {
                hashSet.add(next);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @NonNull
    public fe.rg.qw.pf.qw getGlideLifecycle() {
        return this.lifecycle;
    }

    @Nullable
    public th getRequestManager() {
        return this.requestManager;
    }

    @NonNull
    public RequestManagerTreeNode getRequestManagerTreeNode() {
        return this.requestManagerTreeNode;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            registerFragmentWithRoot(activity);
        } catch (IllegalStateException unused) {
            boolean isLoggable = Log.isLoggable("RMFragment", 5);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.lifecycle.de();
        unregisterFragmentWithRoot();
    }

    public void onDetach() {
        super.onDetach();
        unregisterFragmentWithRoot();
    }

    public void onStart() {
        super.onStart();
        this.lifecycle.fe();
    }

    public void onStop() {
        super.onStop();
        this.lifecycle.rg();
    }

    public void setParentFragmentHint(@Nullable Fragment fragment) {
        this.parentFragmentHint = fragment;
        if (fragment != null && fragment.getActivity() != null) {
            registerFragmentWithRoot(fragment.getActivity());
        }
    }

    public void setRequestManager(@Nullable th thVar) {
        this.requestManager = thVar;
    }

    public String toString() {
        return super.toString() + "{parent=" + getParentFragmentUsingHint() + "}";
    }

    @VisibleForTesting
    @SuppressLint({"ValidFragment"})
    public RequestManagerFragment(@NonNull fe.rg.qw.pf.qw qwVar) {
        this.requestManagerTreeNode = new qw();
        this.childRequestManagerFragments = new HashSet();
        this.lifecycle = qwVar;
    }
}
