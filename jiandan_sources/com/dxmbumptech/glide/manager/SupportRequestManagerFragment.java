package com.dxmbumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.dxmbumptech.glide.Glide;
import fe.uk.qw.yj;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SupportRequestManagerFragment extends Fragment {
    public static final String TAG = "SupportRMFragment";
    public final Set<SupportRequestManagerFragment> childRequestManagerFragments;
    public final fe.uk.qw.p021if.qw lifecycle;
    @Nullable
    public Fragment parentFragmentHint;
    @Nullable
    public yj requestManager;
    public final RequestManagerTreeNode requestManagerTreeNode;
    @Nullable
    public SupportRequestManagerFragment rootRequestManagerFragment;

    public class qw implements RequestManagerTreeNode {
        public qw() {
        }

        @NonNull
        public Set<yj> qw() {
            Set<SupportRequestManagerFragment> descendantRequestManagerFragments = SupportRequestManagerFragment.this.getDescendantRequestManagerFragments();
            HashSet hashSet = new HashSet(descendantRequestManagerFragments.size());
            for (SupportRequestManagerFragment next : descendantRequestManagerFragments) {
                if (next.getRequestManager() != null) {
                    hashSet.add(next.getRequestManager());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + SupportRequestManagerFragment.this + "}";
        }
    }

    public SupportRequestManagerFragment() {
        this(new fe.uk.qw.p021if.qw());
    }

    private void addChildRequestManagerFragment(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.childRequestManagerFragments.add(supportRequestManagerFragment);
    }

    @Nullable
    private Fragment getParentFragmentUsingHint() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.parentFragmentHint;
    }

    @Nullable
    public static FragmentManager getRootFragmentManager(@NonNull Fragment fragment) {
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment.getFragmentManager();
    }

    private boolean isDescendant(@NonNull Fragment fragment) {
        Fragment parentFragmentUsingHint = getParentFragmentUsingHint();
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment == null) {
                return false;
            }
            if (parentFragment.equals(parentFragmentUsingHint)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private void registerFragmentWithRoot(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        unregisterFragmentWithRoot();
        SupportRequestManagerFragment pf2 = Glide.de(context).pf().pf(fragmentManager);
        this.rootRequestManagerFragment = pf2;
        if (!equals(pf2)) {
            this.rootRequestManagerFragment.addChildRequestManagerFragment(this);
        }
    }

    private void removeChildRequestManagerFragment(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.childRequestManagerFragments.remove(supportRequestManagerFragment);
    }

    private void unregisterFragmentWithRoot() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.rootRequestManagerFragment;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.removeChildRequestManagerFragment(this);
            this.rootRequestManagerFragment = null;
        }
    }

    @NonNull
    public Set<SupportRequestManagerFragment> getDescendantRequestManagerFragments() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.rootRequestManagerFragment;
        if (supportRequestManagerFragment == null) {
            return Collections.emptySet();
        }
        if (equals(supportRequestManagerFragment)) {
            return Collections.unmodifiableSet(this.childRequestManagerFragments);
        }
        HashSet hashSet = new HashSet();
        for (SupportRequestManagerFragment next : this.rootRequestManagerFragment.getDescendantRequestManagerFragments()) {
            if (isDescendant(next.getParentFragmentUsingHint())) {
                hashSet.add(next);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @NonNull
    public fe.uk.qw.p021if.qw getGlideLifecycle() {
        return this.lifecycle;
    }

    @Nullable
    public yj getRequestManager() {
        return this.requestManager;
    }

    @NonNull
    public RequestManagerTreeNode getRequestManagerTreeNode() {
        return this.requestManagerTreeNode;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        FragmentManager rootFragmentManager = getRootFragmentManager(this);
        if (rootFragmentManager == null) {
            boolean isLoggable = Log.isLoggable("SupportRMFragment", 5);
            return;
        }
        try {
            registerFragmentWithRoot(getContext(), rootFragmentManager);
        } catch (IllegalStateException unused) {
            boolean isLoggable2 = Log.isLoggable("SupportRMFragment", 5);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.lifecycle.de();
        unregisterFragmentWithRoot();
    }

    public void onDetach() {
        super.onDetach();
        this.parentFragmentHint = null;
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
        FragmentManager rootFragmentManager;
        this.parentFragmentHint = fragment;
        if (fragment != null && fragment.getContext() != null && (rootFragmentManager = getRootFragmentManager(fragment)) != null) {
            registerFragmentWithRoot(fragment.getContext(), rootFragmentManager);
        }
    }

    public void setRequestManager(@Nullable yj yjVar) {
        this.requestManager = yjVar;
    }

    public String toString() {
        return super.toString() + "{parent=" + getParentFragmentUsingHint() + "}";
    }

    @VisibleForTesting
    @SuppressLint({"ValidFragment"})
    public SupportRequestManagerFragment(@NonNull fe.uk.qw.p021if.qw qwVar) {
        this.requestManagerTreeNode = new qw();
        this.childRequestManagerFragments = new HashSet();
        this.lifecycle = qwVar;
    }
}
