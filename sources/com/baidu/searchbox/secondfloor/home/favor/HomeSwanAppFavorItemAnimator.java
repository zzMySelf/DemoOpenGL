package com.baidu.searchbox.secondfloor.home.favor;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class HomeSwanAppFavorItemAnimator extends SimpleItemAnimator {
    private static final int ADD_ANIM_MAX_DELAY = 50;
    private static final boolean DEBUG = false;
    private static TimeInterpolator sDefaultInterpolator;
    ArrayList<RecyclerView.ViewHolder> mAddAnimations = new ArrayList<>();
    ArrayList<ArrayList<RecyclerView.ViewHolder>> mAdditionsList = new ArrayList<>();
    ArrayList<RecyclerView.ViewHolder> mChangeAnimations = new ArrayList<>();
    ArrayList<ArrayList<ChangeInfo>> mChangesList = new ArrayList<>();
    ArrayList<RecyclerView.ViewHolder> mMoveAnimations = new ArrayList<>();
    ArrayList<ArrayList<MoveInfo>> mMovesList = new ArrayList<>();
    private ArrayList<RecyclerView.ViewHolder> mPendingAdditions = new ArrayList<>();
    private ArrayList<ChangeInfo> mPendingChanges = new ArrayList<>();
    private ArrayList<MoveInfo> mPendingMoves = new ArrayList<>();
    private ArrayList<RecyclerView.ViewHolder> mPendingRemovals = new ArrayList<>();
    ArrayList<RecyclerView.ViewHolder> mRemoveAnimations = new ArrayList<>();

    private static class MoveInfo {
        public int fromX;
        public int fromY;
        public RecyclerView.ViewHolder holder;
        public int toX;
        public int toY;

        MoveInfo(RecyclerView.ViewHolder holder2, int fromX2, int fromY2, int toX2, int toY2) {
            this.holder = holder2;
            this.fromX = fromX2;
            this.fromY = fromY2;
            this.toX = toX2;
            this.toY = toY2;
        }
    }

    private static class ChangeInfo {
        public int fromX;
        public int fromY;
        public RecyclerView.ViewHolder newHolder;
        public RecyclerView.ViewHolder oldHolder;
        public int toX;
        public int toY;

        private ChangeInfo(RecyclerView.ViewHolder oldHolder2, RecyclerView.ViewHolder newHolder2) {
            this.oldHolder = oldHolder2;
            this.newHolder = newHolder2;
        }

        ChangeInfo(RecyclerView.ViewHolder oldHolder2, RecyclerView.ViewHolder newHolder2, int fromX2, int fromY2, int toX2, int toY2) {
            this(oldHolder2, newHolder2);
            this.fromX = fromX2;
            this.fromY = fromY2;
            this.toX = toX2;
            this.toY = toY2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.oldHolder + ", newHolder=" + this.newHolder + ", fromX=" + this.fromX + ", fromY=" + this.fromY + ", toX=" + this.toX + ", toY=" + this.toY + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public void runPendingAnimations() {
        boolean removalsPending = !this.mPendingRemovals.isEmpty();
        boolean movesPending = !this.mPendingMoves.isEmpty();
        boolean changesPending = !this.mPendingChanges.isEmpty();
        boolean additionsPending = !this.mPendingAdditions.isEmpty();
        if (removalsPending || movesPending || additionsPending || changesPending) {
            Iterator<RecyclerView.ViewHolder> it = this.mPendingRemovals.iterator();
            while (it.hasNext()) {
                animateRemoveImpl(it.next());
            }
            this.mPendingRemovals.clear();
            if (movesPending) {
                final ArrayList<MoveInfo> moves = new ArrayList<>();
                moves.addAll(this.mPendingMoves);
                this.mMovesList.add(moves);
                this.mPendingMoves.clear();
                Runnable mover = new Runnable() {
                    public void run() {
                        Iterator it = moves.iterator();
                        while (it.hasNext()) {
                            MoveInfo moveInfo = (MoveInfo) it.next();
                            HomeSwanAppFavorItemAnimator.this.animateMoveImpl(moveInfo.holder, moveInfo.fromX, moveInfo.fromY, moveInfo.toX, moveInfo.toY);
                        }
                        moves.clear();
                        HomeSwanAppFavorItemAnimator.this.mMovesList.remove(moves);
                    }
                };
                if (removalsPending) {
                    ViewCompat.postOnAnimationDelayed(moves.get(0).holder.itemView, mover, getRemoveDuration());
                } else {
                    mover.run();
                }
            }
            if (changesPending) {
                final ArrayList<ChangeInfo> changes = new ArrayList<>();
                changes.addAll(this.mPendingChanges);
                this.mChangesList.add(changes);
                this.mPendingChanges.clear();
                Runnable changer = new Runnable() {
                    public void run() {
                        Iterator it = changes.iterator();
                        while (it.hasNext()) {
                            HomeSwanAppFavorItemAnimator.this.animateChangeImpl((ChangeInfo) it.next());
                        }
                        changes.clear();
                        HomeSwanAppFavorItemAnimator.this.mChangesList.remove(changes);
                    }
                };
                if (removalsPending) {
                    ViewCompat.postOnAnimationDelayed(changes.get(0).oldHolder.itemView, changer, getRemoveDuration());
                } else {
                    changer.run();
                }
            }
            if (additionsPending) {
                final ArrayList<RecyclerView.ViewHolder> additions = new ArrayList<>();
                additions.addAll(this.mPendingAdditions);
                this.mAdditionsList.add(additions);
                this.mPendingAdditions.clear();
                Runnable adder = new Runnable() {
                    public void run() {
                        Iterator it = additions.iterator();
                        while (it.hasNext()) {
                            HomeSwanAppFavorItemAnimator.this.animateAddImpl((RecyclerView.ViewHolder) it.next());
                        }
                        additions.clear();
                        HomeSwanAppFavorItemAnimator.this.mAdditionsList.remove(additions);
                    }
                };
                if (removalsPending || movesPending || changesPending) {
                    long changeDuration = 0;
                    long removeDuration = removalsPending ? getRemoveDuration() : 0;
                    long moveDuration = movesPending ? getMoveDuration() : 0;
                    if (changesPending) {
                        changeDuration = getChangeDuration();
                    }
                    boolean z = removalsPending;
                    ViewCompat.postOnAnimationDelayed(additions.get(0).itemView, adder, Math.min(Math.max(moveDuration, changeDuration) + removeDuration, 50));
                    return;
                }
                adder.run();
                boolean z2 = removalsPending;
                return;
            }
        }
    }

    public boolean animateRemove(RecyclerView.ViewHolder holder) {
        resetAnimation(holder);
        this.mPendingRemovals.add(holder);
        return true;
    }

    private void animateRemoveImpl(final RecyclerView.ViewHolder holder) {
        final View view2 = holder.itemView;
        final ViewPropertyAnimator animation = view2.animate();
        this.mRemoveAnimations.add(holder);
        animation.setDuration(getRemoveDuration()).alpha(0.0f).setListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                HomeSwanAppFavorItemAnimator.this.dispatchRemoveStarting(holder);
            }

            public void onAnimationEnd(Animator animator) {
                animation.setListener((Animator.AnimatorListener) null);
                view2.setAlpha(1.0f);
                HomeSwanAppFavorItemAnimator.this.dispatchRemoveFinished(holder);
                HomeSwanAppFavorItemAnimator.this.mRemoveAnimations.remove(holder);
                HomeSwanAppFavorItemAnimator.this.dispatchFinishedWhenDone();
            }
        }).start();
    }

    public boolean animateAdd(RecyclerView.ViewHolder holder) {
        resetAnimation(holder);
        holder.itemView.setAlpha(0.0f);
        holder.itemView.setScaleX(0.5f);
        holder.itemView.setScaleY(0.5f);
        this.mPendingAdditions.add(holder);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void animateAddImpl(final RecyclerView.ViewHolder holder) {
        this.mAddAnimations.add(holder);
        final View view2 = holder.itemView;
        Animator addAnimator = HomeSwanAppFavorItemAddAnimator.createAddAnimator(view2);
        if (view2 != null) {
            addAnimator.addListener(new Animator.AnimatorListener() {
                public void onAnimationStart(Animator animation) {
                    HomeSwanAppFavorItemAnimator.this.dispatchAddStarting(holder);
                }

                public void onAnimationEnd(Animator animation) {
                    HomeSwanAppFavorItemAnimator.this.dispatchAddFinished(holder);
                    HomeSwanAppFavorItemAnimator.this.mAddAnimations.remove(holder);
                    HomeSwanAppFavorItemAnimator.this.dispatchFinishedWhenDone();
                }

                public void onAnimationCancel(Animator animation) {
                    view2.setAlpha(1.0f);
                    view2.setScaleX(1.0f);
                    view2.setScaleY(1.0f);
                }

                public void onAnimationRepeat(Animator animation) {
                }
            });
            addAnimator.start();
        }
    }

    public boolean animateMove(RecyclerView.ViewHolder holder, int fromX, int fromY, int toX, int toY) {
        RecyclerView.ViewHolder viewHolder = holder;
        View view2 = viewHolder.itemView;
        int fromX2 = fromX + ((int) viewHolder.itemView.getTranslationX());
        int fromY2 = fromY + ((int) viewHolder.itemView.getTranslationY());
        resetAnimation(holder);
        int deltaX = toX - fromX2;
        int deltaY = toY - fromY2;
        if (deltaX == 0 && deltaY == 0) {
            dispatchMoveFinished(holder);
            return false;
        }
        if (deltaX != 0) {
            view2.setTranslationX((float) (-deltaX));
        }
        if (deltaY != 0) {
            view2.setTranslationY((float) (-deltaY));
        }
        this.mPendingMoves.add(new MoveInfo(holder, fromX2, fromY2, toX, toY));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void animateMoveImpl(RecyclerView.ViewHolder holder, int fromX, int fromY, int toX, int toY) {
        RecyclerView.ViewHolder viewHolder = holder;
        View view2 = viewHolder.itemView;
        int deltaX = toX - fromX;
        int deltaY = toY - fromY;
        if (deltaX != 0) {
            view2.animate().translationX(0.0f);
        }
        if (deltaY != 0) {
            view2.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animation = view2.animate();
        this.mMoveAnimations.add(viewHolder);
        final RecyclerView.ViewHolder viewHolder2 = holder;
        final int i2 = deltaX;
        final View view3 = view2;
        final int i3 = deltaY;
        final ViewPropertyAnimator viewPropertyAnimator = animation;
        animation.setDuration(getMoveDuration()).setListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                HomeSwanAppFavorItemAnimator.this.dispatchMoveStarting(viewHolder2);
            }

            public void onAnimationCancel(Animator animator) {
                if (i2 != 0) {
                    view3.setTranslationX(0.0f);
                }
                if (i3 != 0) {
                    view3.setTranslationY(0.0f);
                }
            }

            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimator.setListener((Animator.AnimatorListener) null);
                HomeSwanAppFavorItemAnimator.this.dispatchMoveFinished(viewHolder2);
                HomeSwanAppFavorItemAnimator.this.mMoveAnimations.remove(viewHolder2);
                HomeSwanAppFavorItemAnimator.this.dispatchFinishedWhenDone();
            }
        }).start();
    }

    public boolean animateChange(RecyclerView.ViewHolder oldHolder, RecyclerView.ViewHolder newHolder, int fromX, int fromY, int toX, int toY) {
        RecyclerView.ViewHolder viewHolder = oldHolder;
        RecyclerView.ViewHolder viewHolder2 = newHolder;
        if (viewHolder == viewHolder2) {
            return animateMove(oldHolder, fromX, fromY, toX, toY);
        }
        float prevTranslationX = viewHolder.itemView.getTranslationX();
        float prevTranslationY = viewHolder.itemView.getTranslationY();
        float prevAlpha = viewHolder.itemView.getAlpha();
        resetAnimation(oldHolder);
        int deltaX = (int) (((float) (toX - fromX)) - prevTranslationX);
        int deltaY = (int) (((float) (toY - fromY)) - prevTranslationY);
        viewHolder.itemView.setTranslationX(prevTranslationX);
        viewHolder.itemView.setTranslationY(prevTranslationY);
        viewHolder.itemView.setAlpha(prevAlpha);
        if (viewHolder2 != null) {
            resetAnimation(viewHolder2);
            viewHolder2.itemView.setTranslationX((float) (-deltaX));
            viewHolder2.itemView.setTranslationY((float) (-deltaY));
            viewHolder2.itemView.setAlpha(0.0f);
        }
        ArrayList<ChangeInfo> arrayList = this.mPendingChanges;
        float f2 = prevTranslationX;
        ChangeInfo changeInfo = r7;
        ChangeInfo changeInfo2 = new ChangeInfo(oldHolder, newHolder, fromX, fromY, toX, toY);
        arrayList.add(changeInfo);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void animateChangeImpl(final ChangeInfo changeInfo) {
        RecyclerView.ViewHolder holder = changeInfo.oldHolder;
        final View newView = null;
        final View view2 = holder == null ? null : holder.itemView;
        RecyclerView.ViewHolder newHolder = changeInfo.newHolder;
        if (newHolder != null) {
            newView = newHolder.itemView;
        }
        if (view2 != null) {
            final ViewPropertyAnimator oldViewAnim = view2.animate().setDuration(getChangeDuration());
            this.mChangeAnimations.add(changeInfo.oldHolder);
            oldViewAnim.translationX((float) (changeInfo.toX - changeInfo.fromX));
            oldViewAnim.translationY((float) (changeInfo.toY - changeInfo.fromY));
            oldViewAnim.alpha(0.0f).setListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    HomeSwanAppFavorItemAnimator.this.dispatchChangeStarting(changeInfo.oldHolder, true);
                }

                public void onAnimationEnd(Animator animator) {
                    oldViewAnim.setListener((Animator.AnimatorListener) null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    HomeSwanAppFavorItemAnimator.this.dispatchChangeFinished(changeInfo.oldHolder, true);
                    HomeSwanAppFavorItemAnimator.this.mChangeAnimations.remove(changeInfo.oldHolder);
                    HomeSwanAppFavorItemAnimator.this.dispatchFinishedWhenDone();
                }
            }).start();
        }
        if (newView != null) {
            final ViewPropertyAnimator newViewAnimation = newView.animate();
            this.mChangeAnimations.add(changeInfo.newHolder);
            newViewAnimation.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    HomeSwanAppFavorItemAnimator.this.dispatchChangeStarting(changeInfo.newHolder, false);
                }

                public void onAnimationEnd(Animator animator) {
                    newViewAnimation.setListener((Animator.AnimatorListener) null);
                    newView.setAlpha(1.0f);
                    newView.setTranslationX(0.0f);
                    newView.setTranslationY(0.0f);
                    HomeSwanAppFavorItemAnimator.this.dispatchChangeFinished(changeInfo.newHolder, false);
                    HomeSwanAppFavorItemAnimator.this.mChangeAnimations.remove(changeInfo.newHolder);
                    HomeSwanAppFavorItemAnimator.this.dispatchFinishedWhenDone();
                }
            }).start();
        }
    }

    private void endChangeAnimation(List<ChangeInfo> infoList, RecyclerView.ViewHolder item) {
        for (int i2 = infoList.size() - 1; i2 >= 0; i2--) {
            ChangeInfo changeInfo = infoList.get(i2);
            if (endChangeAnimationIfNecessary(changeInfo, item) && changeInfo.oldHolder == null && changeInfo.newHolder == null) {
                infoList.remove(changeInfo);
            }
        }
    }

    private void endChangeAnimationIfNecessary(ChangeInfo changeInfo) {
        if (changeInfo.oldHolder != null) {
            endChangeAnimationIfNecessary(changeInfo, changeInfo.oldHolder);
        }
        if (changeInfo.newHolder != null) {
            endChangeAnimationIfNecessary(changeInfo, changeInfo.newHolder);
        }
    }

    private boolean endChangeAnimationIfNecessary(ChangeInfo changeInfo, RecyclerView.ViewHolder item) {
        boolean oldItem = false;
        if (changeInfo.newHolder == item) {
            changeInfo.newHolder = null;
        } else if (changeInfo.oldHolder != item) {
            return false;
        } else {
            changeInfo.oldHolder = null;
            oldItem = true;
        }
        item.itemView.setAlpha(1.0f);
        item.itemView.setTranslationX(0.0f);
        item.itemView.setTranslationY(0.0f);
        dispatchChangeFinished(item, oldItem);
        return true;
    }

    public void endAnimation(RecyclerView.ViewHolder item) {
        View view2 = item.itemView;
        view2.animate().cancel();
        int i2 = this.mPendingMoves.size();
        while (true) {
            i2--;
            if (i2 < 0) {
                break;
            } else if (this.mPendingMoves.get(i2).holder == item) {
                view2.setTranslationY(0.0f);
                view2.setTranslationX(0.0f);
                dispatchMoveFinished(item);
                this.mPendingMoves.remove(i2);
            }
        }
        endChangeAnimation(this.mPendingChanges, item);
        if (this.mPendingRemovals.remove(item)) {
            view2.setAlpha(1.0f);
            dispatchRemoveFinished(item);
        }
        if (this.mPendingAdditions.remove(item)) {
            view2.setAlpha(1.0f);
            dispatchAddFinished(item);
        }
        for (int i3 = this.mChangesList.size() - 1; i3 >= 0; i3--) {
            ArrayList<ChangeInfo> changes = this.mChangesList.get(i3);
            endChangeAnimation(changes, item);
            if (changes.isEmpty()) {
                this.mChangesList.remove(i3);
            }
        }
        for (int i4 = this.mMovesList.size() - 1; i4 >= 0; i4--) {
            ArrayList<MoveInfo> moves = this.mMovesList.get(i4);
            int j2 = moves.size() - 1;
            while (true) {
                if (j2 < 0) {
                    break;
                } else if (moves.get(j2).holder == item) {
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    dispatchMoveFinished(item);
                    moves.remove(j2);
                    if (moves.isEmpty()) {
                        this.mMovesList.remove(i4);
                    }
                } else {
                    j2--;
                }
            }
        }
        for (int i5 = this.mAdditionsList.size() - 1; i5 >= 0; i5--) {
            ArrayList<RecyclerView.ViewHolder> additions = this.mAdditionsList.get(i5);
            if (additions.remove(item)) {
                view2.setAlpha(1.0f);
                dispatchAddFinished(item);
                if (additions.isEmpty()) {
                    this.mAdditionsList.remove(i5);
                }
            }
        }
        this.mRemoveAnimations.remove(item);
        this.mAddAnimations.remove(item);
        this.mChangeAnimations.remove(item);
        this.mMoveAnimations.remove(item);
        dispatchFinishedWhenDone();
    }

    private void resetAnimation(RecyclerView.ViewHolder holder) {
        if (sDefaultInterpolator == null) {
            sDefaultInterpolator = new ValueAnimator().getInterpolator();
        }
        holder.itemView.animate().setInterpolator(sDefaultInterpolator);
        endAnimation(holder);
    }

    public boolean isRunning() {
        return !this.mPendingAdditions.isEmpty() || !this.mPendingChanges.isEmpty() || !this.mPendingMoves.isEmpty() || !this.mPendingRemovals.isEmpty() || !this.mMoveAnimations.isEmpty() || !this.mRemoveAnimations.isEmpty() || !this.mAddAnimations.isEmpty() || !this.mChangeAnimations.isEmpty() || !this.mMovesList.isEmpty() || !this.mAdditionsList.isEmpty() || !this.mChangesList.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public void dispatchFinishedWhenDone() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
        }
    }

    public void endAnimations() {
        for (int i2 = this.mPendingMoves.size() - 1; i2 >= 0; i2--) {
            MoveInfo item = this.mPendingMoves.get(i2);
            View view2 = item.holder.itemView;
            view2.setTranslationY(0.0f);
            view2.setTranslationX(0.0f);
            dispatchMoveFinished(item.holder);
            this.mPendingMoves.remove(i2);
        }
        for (int i3 = this.mPendingRemovals.size() - 1; i3 >= 0; i3--) {
            dispatchRemoveFinished(this.mPendingRemovals.get(i3));
            this.mPendingRemovals.remove(i3);
        }
        for (int i4 = this.mPendingAdditions.size() - 1; i4 >= 0; i4--) {
            RecyclerView.ViewHolder item2 = this.mPendingAdditions.get(i4);
            item2.itemView.setAlpha(1.0f);
            dispatchAddFinished(item2);
            this.mPendingAdditions.remove(i4);
        }
        for (int i5 = this.mPendingChanges.size() - 1; i5 >= 0; i5--) {
            endChangeAnimationIfNecessary(this.mPendingChanges.get(i5));
        }
        this.mPendingChanges.clear();
        if (isRunning()) {
            for (int i6 = this.mMovesList.size() - 1; i6 >= 0; i6--) {
                ArrayList<MoveInfo> moves = this.mMovesList.get(i6);
                for (int j2 = moves.size() - 1; j2 >= 0; j2--) {
                    MoveInfo moveInfo = moves.get(j2);
                    View view3 = moveInfo.holder.itemView;
                    view3.setTranslationY(0.0f);
                    view3.setTranslationX(0.0f);
                    dispatchMoveFinished(moveInfo.holder);
                    moves.remove(j2);
                    if (moves.isEmpty()) {
                        this.mMovesList.remove(moves);
                    }
                }
            }
            for (int i7 = this.mAdditionsList.size() - 1; i7 >= 0; i7--) {
                ArrayList<RecyclerView.ViewHolder> additions = this.mAdditionsList.get(i7);
                for (int j3 = additions.size() - 1; j3 >= 0; j3--) {
                    RecyclerView.ViewHolder item3 = additions.get(j3);
                    item3.itemView.setAlpha(1.0f);
                    dispatchAddFinished(item3);
                    additions.remove(j3);
                    if (additions.isEmpty()) {
                        this.mAdditionsList.remove(additions);
                    }
                }
            }
            for (int i8 = this.mChangesList.size() - 1; i8 >= 0; i8--) {
                ArrayList<ChangeInfo> changes = this.mChangesList.get(i8);
                for (int j4 = changes.size() - 1; j4 >= 0; j4--) {
                    endChangeAnimationIfNecessary(changes.get(j4));
                    if (changes.isEmpty()) {
                        this.mChangesList.remove(changes);
                    }
                }
            }
            cancelAll(this.mRemoveAnimations);
            cancelAll(this.mMoveAnimations);
            cancelAll(this.mAddAnimations);
            cancelAll(this.mChangeAnimations);
            dispatchAnimationsFinished();
        }
    }

    /* access modifiers changed from: package-private */
    public void cancelAll(List<RecyclerView.ViewHolder> viewHolders) {
        for (int i2 = viewHolders.size() - 1; i2 >= 0; i2--) {
            viewHolders.get(i2).itemView.animate().cancel();
        }
    }

    public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder viewHolder, List<Object> payloads) {
        return !payloads.isEmpty() || super.canReuseUpdatedViewHolder(viewHolder, payloads);
    }
}
