package androidx.databinding;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import android.view.Choreographer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.databinding.CallbackRegistry;
import androidx.databinding.Observable;
import androidx.databinding.ObservableList;
import androidx.databinding.ObservableMap;
import androidx.databinding.library.R;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.viewbinding.ViewBinding;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

public abstract class ViewDataBinding extends BaseObservable implements ViewBinding {
    public static final int BINDING_NUMBER_START = 8;
    public static final String BINDING_TAG_PREFIX = "binding_";
    public static final CreateWeakListener CREATE_LIST_LISTENER = new CreateWeakListener() {
        public WeakListener create(ViewDataBinding viewDataBinding, int i2) {
            return new WeakListListener(viewDataBinding, i2).getListener();
        }
    };
    public static final CreateWeakListener CREATE_LIVE_DATA_LISTENER = new CreateWeakListener() {
        public WeakListener create(ViewDataBinding viewDataBinding, int i2) {
            return new LiveDataListener(viewDataBinding, i2).getListener();
        }
    };
    public static final CreateWeakListener CREATE_MAP_LISTENER = new CreateWeakListener() {
        public WeakListener create(ViewDataBinding viewDataBinding, int i2) {
            return new WeakMapListener(viewDataBinding, i2).getListener();
        }
    };
    public static final CreateWeakListener CREATE_PROPERTY_LISTENER = new CreateWeakListener() {
        public WeakListener create(ViewDataBinding viewDataBinding, int i2) {
            return new WeakPropertyListener(viewDataBinding, i2).getListener();
        }
    };
    public static final int HALTED = 2;
    public static final int REBIND = 1;
    public static final CallbackRegistry.NotifierCallback<OnRebindCallback, ViewDataBinding, Void> REBIND_NOTIFIER = new CallbackRegistry.NotifierCallback<OnRebindCallback, ViewDataBinding, Void>() {
        public void onNotifyCallback(OnRebindCallback onRebindCallback, ViewDataBinding viewDataBinding, int i2, Void voidR) {
            if (i2 != 1) {
                if (i2 == 2) {
                    onRebindCallback.onCanceled(viewDataBinding);
                } else if (i2 == 3) {
                    onRebindCallback.onBound(viewDataBinding);
                }
            } else if (!onRebindCallback.onPreBind(viewDataBinding)) {
                boolean unused = viewDataBinding.mRebindHalted = true;
            }
        }
    };
    public static final int REBOUND = 3;
    public static final View.OnAttachStateChangeListener ROOT_REATTACHED_LISTENER;
    public static int SDK_INT;
    public static final boolean USE_CHOREOGRAPHER;
    public static final ReferenceQueue<ViewDataBinding> sReferenceQueue = new ReferenceQueue<>();
    public final DataBindingComponent mBindingComponent;
    public Choreographer mChoreographer;
    public ViewDataBinding mContainingBinding;
    public final Choreographer.FrameCallback mFrameCallback;
    public boolean mInLiveDataRegisterObserver;
    public boolean mIsExecutingPendingBindings;
    public LifecycleOwner mLifecycleOwner;
    public WeakListener[] mLocalFieldObservers;
    public OnStartListener mOnStartListener;
    public boolean mPendingRebind;
    public CallbackRegistry<OnRebindCallback, ViewDataBinding, Void> mRebindCallbacks;
    public boolean mRebindHalted;
    public final Runnable mRebindRunnable;
    public final View mRoot;
    public Handler mUIThreadHandler;

    public interface CreateWeakListener {
        WeakListener create(ViewDataBinding viewDataBinding, int i2);
    }

    public static class IncludedLayouts {
        public final int[][] indexes;
        public final int[][] layoutIds;
        public final String[][] layouts;

        public IncludedLayouts(int i2) {
            this.layouts = new String[i2][];
            this.indexes = new int[i2][];
            this.layoutIds = new int[i2][];
        }

        public void setIncludes(int i2, String[] strArr, int[] iArr, int[] iArr2) {
            this.layouts[i2] = strArr;
            this.indexes[i2] = iArr;
            this.layoutIds[i2] = iArr2;
        }
    }

    public static class LiveDataListener implements Observer, ObservableReference<LiveData<?>> {
        public LifecycleOwner mLifecycleOwner;
        public final WeakListener<LiveData<?>> mListener;

        public LiveDataListener(ViewDataBinding viewDataBinding, int i2) {
            this.mListener = new WeakListener<>(viewDataBinding, i2, this);
        }

        public WeakListener<LiveData<?>> getListener() {
            return this.mListener;
        }

        public void onChanged(@Nullable Object obj) {
            ViewDataBinding binder = this.mListener.getBinder();
            if (binder != null) {
                WeakListener<LiveData<?>> weakListener = this.mListener;
                binder.handleFieldChange(weakListener.mLocalFieldId, weakListener.getTarget(), 0);
            }
        }

        public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
            LiveData target = this.mListener.getTarget();
            if (target != null) {
                if (this.mLifecycleOwner != null) {
                    target.removeObserver(this);
                }
                if (lifecycleOwner != null) {
                    target.observe(lifecycleOwner, this);
                }
            }
            this.mLifecycleOwner = lifecycleOwner;
        }

        public void addListener(LiveData<?> liveData) {
            LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
            if (lifecycleOwner != null) {
                liveData.observe(lifecycleOwner, this);
            }
        }

        public void removeListener(LiveData<?> liveData) {
            liveData.removeObserver(this);
        }
    }

    public interface ObservableReference<T> {
        void addListener(T t);

        WeakListener<T> getListener();

        void removeListener(T t);

        void setLifecycleOwner(LifecycleOwner lifecycleOwner);
    }

    public static class OnStartListener implements LifecycleObserver {
        public final WeakReference<ViewDataBinding> mBinding;

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void onStart() {
            ViewDataBinding viewDataBinding = (ViewDataBinding) this.mBinding.get();
            if (viewDataBinding != null) {
                viewDataBinding.executePendingBindings();
            }
        }

        public OnStartListener(ViewDataBinding viewDataBinding) {
            this.mBinding = new WeakReference<>(viewDataBinding);
        }
    }

    public static abstract class PropertyChangedInverseListener extends Observable.OnPropertyChangedCallback implements InverseBindingListener {
        public final int mPropertyId;

        public PropertyChangedInverseListener(int i2) {
            this.mPropertyId = i2;
        }

        public void onPropertyChanged(Observable observable, int i2) {
            if (i2 == this.mPropertyId || i2 == 0) {
                onChange();
            }
        }
    }

    public static class WeakListListener extends ObservableList.OnListChangedCallback implements ObservableReference<ObservableList> {
        public final WeakListener<ObservableList> mListener;

        public WeakListListener(ViewDataBinding viewDataBinding, int i2) {
            this.mListener = new WeakListener<>(viewDataBinding, i2, this);
        }

        public WeakListener<ObservableList> getListener() {
            return this.mListener;
        }

        public void onChanged(ObservableList observableList) {
            ObservableList target;
            ViewDataBinding binder = this.mListener.getBinder();
            if (binder != null && (target = this.mListener.getTarget()) == observableList) {
                binder.handleFieldChange(this.mListener.mLocalFieldId, target, 0);
            }
        }

        public void onItemRangeChanged(ObservableList observableList, int i2, int i3) {
            onChanged(observableList);
        }

        public void onItemRangeInserted(ObservableList observableList, int i2, int i3) {
            onChanged(observableList);
        }

        public void onItemRangeMoved(ObservableList observableList, int i2, int i3, int i4) {
            onChanged(observableList);
        }

        public void onItemRangeRemoved(ObservableList observableList, int i2, int i3) {
            onChanged(observableList);
        }

        public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        }

        public void addListener(ObservableList observableList) {
            observableList.addOnListChangedCallback(this);
        }

        public void removeListener(ObservableList observableList) {
            observableList.removeOnListChangedCallback(this);
        }
    }

    public static class WeakListener<T> extends WeakReference<ViewDataBinding> {
        public final int mLocalFieldId;
        public final ObservableReference<T> mObservable;
        public T mTarget;

        public WeakListener(ViewDataBinding viewDataBinding, int i2, ObservableReference<T> observableReference) {
            super(viewDataBinding, ViewDataBinding.sReferenceQueue);
            this.mLocalFieldId = i2;
            this.mObservable = observableReference;
        }

        public ViewDataBinding getBinder() {
            ViewDataBinding viewDataBinding = (ViewDataBinding) get();
            if (viewDataBinding == null) {
                unregister();
            }
            return viewDataBinding;
        }

        public T getTarget() {
            return this.mTarget;
        }

        public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
            this.mObservable.setLifecycleOwner(lifecycleOwner);
        }

        public void setTarget(T t) {
            unregister();
            this.mTarget = t;
            if (t != null) {
                this.mObservable.addListener(t);
            }
        }

        public boolean unregister() {
            boolean z;
            T t = this.mTarget;
            if (t != null) {
                this.mObservable.removeListener(t);
                z = true;
            } else {
                z = false;
            }
            this.mTarget = null;
            return z;
        }
    }

    public static class WeakMapListener extends ObservableMap.OnMapChangedCallback implements ObservableReference<ObservableMap> {
        public final WeakListener<ObservableMap> mListener;

        public WeakMapListener(ViewDataBinding viewDataBinding, int i2) {
            this.mListener = new WeakListener<>(viewDataBinding, i2, this);
        }

        public WeakListener<ObservableMap> getListener() {
            return this.mListener;
        }

        public void onMapChanged(ObservableMap observableMap, Object obj) {
            ViewDataBinding binder = this.mListener.getBinder();
            if (binder != null && observableMap == this.mListener.getTarget()) {
                binder.handleFieldChange(this.mListener.mLocalFieldId, observableMap, 0);
            }
        }

        public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        }

        public void addListener(ObservableMap observableMap) {
            observableMap.addOnMapChangedCallback(this);
        }

        public void removeListener(ObservableMap observableMap) {
            observableMap.removeOnMapChangedCallback(this);
        }
    }

    public static class WeakPropertyListener extends Observable.OnPropertyChangedCallback implements ObservableReference<Observable> {
        public final WeakListener<Observable> mListener;

        public WeakPropertyListener(ViewDataBinding viewDataBinding, int i2) {
            this.mListener = new WeakListener<>(viewDataBinding, i2, this);
        }

        public WeakListener<Observable> getListener() {
            return this.mListener;
        }

        public void onPropertyChanged(Observable observable, int i2) {
            ViewDataBinding binder = this.mListener.getBinder();
            if (binder != null && this.mListener.getTarget() == observable) {
                binder.handleFieldChange(this.mListener.mLocalFieldId, observable, i2);
            }
        }

        public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        }

        public void addListener(Observable observable) {
            observable.addOnPropertyChangedCallback(this);
        }

        public void removeListener(Observable observable) {
            observable.removeOnPropertyChangedCallback(this);
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        SDK_INT = i2;
        USE_CHOREOGRAPHER = i2 >= 16;
        if (Build.VERSION.SDK_INT < 19) {
            ROOT_REATTACHED_LISTENER = null;
        } else {
            ROOT_REATTACHED_LISTENER = new View.OnAttachStateChangeListener() {
                @TargetApi(19)
                public void onViewAttachedToWindow(View view) {
                    ViewDataBinding.getBinding(view).mRebindRunnable.run();
                    view.removeOnAttachStateChangeListener(this);
                }

                public void onViewDetachedFromWindow(View view) {
                }
            };
        }
    }

    public ViewDataBinding(DataBindingComponent dataBindingComponent, View view, int i2) {
        this.mRebindRunnable = new Runnable() {
            public void run() {
                synchronized (this) {
                    boolean unused = ViewDataBinding.this.mPendingRebind = false;
                }
                ViewDataBinding.processReferenceQueue();
                if (Build.VERSION.SDK_INT < 19 || ViewDataBinding.this.mRoot.isAttachedToWindow()) {
                    ViewDataBinding.this.executePendingBindings();
                    return;
                }
                ViewDataBinding.this.mRoot.removeOnAttachStateChangeListener(ViewDataBinding.ROOT_REATTACHED_LISTENER);
                ViewDataBinding.this.mRoot.addOnAttachStateChangeListener(ViewDataBinding.ROOT_REATTACHED_LISTENER);
            }
        };
        this.mPendingRebind = false;
        this.mRebindHalted = false;
        this.mBindingComponent = dataBindingComponent;
        this.mLocalFieldObservers = new WeakListener[i2];
        this.mRoot = view;
        if (Looper.myLooper() == null) {
            throw new IllegalStateException("DataBinding must be created in view's UI Thread");
        } else if (USE_CHOREOGRAPHER) {
            this.mChoreographer = Choreographer.getInstance();
            this.mFrameCallback = new Choreographer.FrameCallback() {
                public void doFrame(long j) {
                    ViewDataBinding.this.mRebindRunnable.run();
                }
            };
        } else {
            this.mFrameCallback = null;
            this.mUIThreadHandler = new Handler(Looper.myLooper());
        }
    }

    public static ViewDataBinding bind(Object obj, View view, int i2) {
        return DataBindingUtil.bind(checkAndCastToBindingComponent(obj), view, i2);
    }

    public static DataBindingComponent checkAndCastToBindingComponent(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof DataBindingComponent) {
            return (DataBindingComponent) obj;
        }
        throw new IllegalArgumentException("The provided bindingComponent parameter must be an instance of DataBindingComponent. See  https://issuetracker.google.com/issues/116541301 for details of why this parameter is not defined as DataBindingComponent");
    }

    private void executeBindingsInternal() {
        if (this.mIsExecutingPendingBindings) {
            requestRebind();
        } else if (hasPendingBindings()) {
            this.mIsExecutingPendingBindings = true;
            this.mRebindHalted = false;
            CallbackRegistry<OnRebindCallback, ViewDataBinding, Void> callbackRegistry = this.mRebindCallbacks;
            if (callbackRegistry != null) {
                callbackRegistry.notifyCallbacks(this, 1, null);
                if (this.mRebindHalted) {
                    this.mRebindCallbacks.notifyCallbacks(this, 2, null);
                }
            }
            if (!this.mRebindHalted) {
                executeBindings();
                CallbackRegistry<OnRebindCallback, ViewDataBinding, Void> callbackRegistry2 = this.mRebindCallbacks;
                if (callbackRegistry2 != null) {
                    callbackRegistry2.notifyCallbacks(this, 3, null);
                }
            }
            this.mIsExecutingPendingBindings = false;
        }
    }

    public static void executeBindingsOn(ViewDataBinding viewDataBinding) {
        viewDataBinding.executeBindingsInternal();
    }

    public static int findIncludeIndex(String str, int i2, IncludedLayouts includedLayouts, int i3) {
        CharSequence subSequence = str.subSequence(str.indexOf(47) + 1, str.length() - 2);
        String[] strArr = includedLayouts.layouts[i3];
        int length = strArr.length;
        while (i2 < length) {
            if (TextUtils.equals(subSequence, strArr[i2])) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int findLastMatching(ViewGroup viewGroup, int i2) {
        String str = (String) viewGroup.getChildAt(i2).getTag();
        String substring = str.substring(0, str.length() - 1);
        int length = substring.length();
        int childCount = viewGroup.getChildCount();
        for (int i3 = i2 + 1; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            String str2 = childAt.getTag() instanceof String ? (String) childAt.getTag() : null;
            if (str2 != null && str2.startsWith(substring)) {
                if (str2.length() == str.length() && str2.charAt(str2.length() - 1) == '0') {
                    return i2;
                }
                if (isNumeric(str2, length)) {
                    i2 = i3;
                }
            }
        }
        return i2;
    }

    public static ViewDataBinding getBinding(View view) {
        if (view != null) {
            return (ViewDataBinding) view.getTag(R.id.dataBinding);
        }
        return null;
    }

    public static int getBuildSdkInt() {
        return SDK_INT;
    }

    public static int getColorFromResource(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return view.getContext().getColor(i2);
        }
        return view.getResources().getColor(i2);
    }

    public static ColorStateList getColorStateListFromResource(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return view.getContext().getColorStateList(i2);
        }
        return view.getResources().getColorStateList(i2);
    }

    public static Drawable getDrawableFromResource(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getContext().getDrawable(i2);
        }
        return view.getResources().getDrawable(i2);
    }

    public static <K, T> T getFrom(Map<K, T> map, K k) {
        if (map == null) {
            return null;
        }
        return map.get(k);
    }

    public static <T> T getFromArray(T[] tArr, int i2) {
        if (tArr == null || i2 < 0 || i2 >= tArr.length) {
            return null;
        }
        return tArr[i2];
    }

    public static <T> T getFromList(List<T> list, int i2) {
        if (list == null || i2 < 0 || i2 >= list.size()) {
            return null;
        }
        return list.get(i2);
    }

    /* access modifiers changed from: private */
    public void handleFieldChange(int i2, Object obj, int i3) {
        if (!this.mInLiveDataRegisterObserver && onFieldChange(i2, obj, i3)) {
            requestRebind();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static <T extends ViewDataBinding> T inflateInternal(@NonNull LayoutInflater layoutInflater, int i2, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return DataBindingUtil.inflate(layoutInflater, i2, viewGroup, z, checkAndCastToBindingComponent(obj));
    }

    public static boolean isNumeric(String str, int i2) {
        int length = str.length();
        if (length == i2) {
            return false;
        }
        while (i2 < length) {
            if (!Character.isDigit(str.charAt(i2))) {
                return false;
            }
            i2++;
        }
        return true;
    }

    public static Object[] mapBindings(DataBindingComponent dataBindingComponent, View view, int i2, IncludedLayouts includedLayouts, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i2];
        mapBindings(dataBindingComponent, view, objArr, includedLayouts, sparseIntArray, true);
        return objArr;
    }

    public static boolean parse(String str, boolean z) {
        return str == null ? z : Boolean.parseBoolean(str);
    }

    public static int parseTagInt(String str, int i2) {
        int length = str.length();
        int i3 = 0;
        while (i2 < length) {
            i3 = (i3 * 10) + (str.charAt(i2) - '0');
            i2++;
        }
        return i3;
    }

    public static void processReferenceQueue() {
        while (true) {
            Reference<? extends ViewDataBinding> poll = sReferenceQueue.poll();
            if (poll == null) {
                return;
            }
            if (poll instanceof WeakListener) {
                ((WeakListener) poll).unregister();
            }
        }
    }

    public static int safeUnbox(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static void setBindingInverseListener(ViewDataBinding viewDataBinding, InverseBindingListener inverseBindingListener, PropertyChangedInverseListener propertyChangedInverseListener) {
        if (inverseBindingListener != propertyChangedInverseListener) {
            if (inverseBindingListener != null) {
                viewDataBinding.removeOnPropertyChangedCallback((PropertyChangedInverseListener) inverseBindingListener);
            }
            if (propertyChangedInverseListener != null) {
                viewDataBinding.addOnPropertyChangedCallback(propertyChangedInverseListener);
            }
        }
    }

    public static <T> void setTo(T[] tArr, int i2, T t) {
        if (tArr != null && i2 >= 0 && i2 < tArr.length) {
            tArr[i2] = t;
        }
    }

    private boolean updateRegistration(int i2, Object obj, CreateWeakListener createWeakListener) {
        if (obj == null) {
            return unregisterFrom(i2);
        }
        WeakListener weakListener = this.mLocalFieldObservers[i2];
        if (weakListener == null) {
            registerTo(i2, obj, createWeakListener);
            return true;
        } else if (weakListener.getTarget() == obj) {
            return false;
        } else {
            unregisterFrom(i2);
            registerTo(i2, obj, createWeakListener);
            return true;
        }
    }

    public void addOnRebindCallback(@NonNull OnRebindCallback onRebindCallback) {
        if (this.mRebindCallbacks == null) {
            this.mRebindCallbacks = new CallbackRegistry<>(REBIND_NOTIFIER);
        }
        this.mRebindCallbacks.add(onRebindCallback);
    }

    public void ensureBindingComponentIsNotNull(Class<?> cls) {
        if (this.mBindingComponent == null) {
            throw new IllegalStateException("Required DataBindingComponent is null in class " + ViewDataBinding.class.getSimpleName() + ". A BindingAdapter in " + cls.getCanonicalName() + " is not static and requires an object to use, retrieved from the DataBindingComponent. If you don't use an inflation method taking a DataBindingComponent, use DataBindingUtil.setDefaultComponent or make all BindingAdapter methods static.");
        }
    }

    public abstract void executeBindings();

    public void executePendingBindings() {
        ViewDataBinding viewDataBinding = this.mContainingBinding;
        if (viewDataBinding == null) {
            executeBindingsInternal();
        } else {
            viewDataBinding.executePendingBindings();
        }
    }

    public void forceExecuteBindings() {
        executeBindings();
    }

    @Nullable
    public LifecycleOwner getLifecycleOwner() {
        return this.mLifecycleOwner;
    }

    public Object getObservedField(int i2) {
        WeakListener weakListener = this.mLocalFieldObservers[i2];
        if (weakListener == null) {
            return null;
        }
        return weakListener.getTarget();
    }

    @NonNull
    public View getRoot() {
        return this.mRoot;
    }

    public abstract boolean hasPendingBindings();

    public abstract void invalidateAll();

    public abstract boolean onFieldChange(int i2, Object obj, int i3);

    public void registerTo(int i2, Object obj, CreateWeakListener createWeakListener) {
        if (obj != null) {
            WeakListener weakListener = this.mLocalFieldObservers[i2];
            if (weakListener == null) {
                weakListener = createWeakListener.create(this, i2);
                this.mLocalFieldObservers[i2] = weakListener;
                LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
                if (lifecycleOwner != null) {
                    weakListener.setLifecycleOwner(lifecycleOwner);
                }
            }
            weakListener.setTarget(obj);
        }
    }

    public void removeOnRebindCallback(@NonNull OnRebindCallback onRebindCallback) {
        CallbackRegistry<OnRebindCallback, ViewDataBinding, Void> callbackRegistry = this.mRebindCallbacks;
        if (callbackRegistry != null) {
            callbackRegistry.remove(onRebindCallback);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
        if (USE_CHOREOGRAPHER == false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        r2.mChoreographer.postFrameCallback(r2.mFrameCallback);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
        r2.mUIThreadHandler.post(r2.mRebindRunnable);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void requestRebind() {
        /*
            r2 = this;
            androidx.databinding.ViewDataBinding r0 = r2.mContainingBinding
            if (r0 == 0) goto L_0x0008
            r0.requestRebind()
            goto L_0x003b
        L_0x0008:
            androidx.lifecycle.LifecycleOwner r0 = r2.mLifecycleOwner
            if (r0 == 0) goto L_0x001d
            androidx.lifecycle.Lifecycle r0 = r0.getLifecycle()
            androidx.lifecycle.Lifecycle$State r0 = r0.getCurrentState()
            androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.STARTED
            boolean r0 = r0.isAtLeast(r1)
            if (r0 != 0) goto L_0x001d
            return
        L_0x001d:
            monitor-enter(r2)
            boolean r0 = r2.mPendingRebind     // Catch:{ all -> 0x003c }
            if (r0 == 0) goto L_0x0024
            monitor-exit(r2)     // Catch:{ all -> 0x003c }
            return
        L_0x0024:
            r0 = 1
            r2.mPendingRebind = r0     // Catch:{ all -> 0x003c }
            monitor-exit(r2)     // Catch:{ all -> 0x003c }
            boolean r0 = USE_CHOREOGRAPHER
            if (r0 == 0) goto L_0x0034
            android.view.Choreographer r0 = r2.mChoreographer
            android.view.Choreographer$FrameCallback r1 = r2.mFrameCallback
            r0.postFrameCallback(r1)
            goto L_0x003b
        L_0x0034:
            android.os.Handler r0 = r2.mUIThreadHandler
            java.lang.Runnable r1 = r2.mRebindRunnable
            r0.post(r1)
        L_0x003b:
            return
        L_0x003c:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.databinding.ViewDataBinding.requestRebind():void");
    }

    public void setContainedBinding(ViewDataBinding viewDataBinding) {
        if (viewDataBinding != null) {
            viewDataBinding.mContainingBinding = this;
        }
    }

    @MainThread
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        LifecycleOwner lifecycleOwner2 = this.mLifecycleOwner;
        if (lifecycleOwner2 != lifecycleOwner) {
            if (lifecycleOwner2 != null) {
                lifecycleOwner2.getLifecycle().removeObserver(this.mOnStartListener);
            }
            this.mLifecycleOwner = lifecycleOwner;
            if (lifecycleOwner != null) {
                if (this.mOnStartListener == null) {
                    this.mOnStartListener = new OnStartListener();
                }
                lifecycleOwner.getLifecycle().addObserver(this.mOnStartListener);
            }
            for (WeakListener weakListener : this.mLocalFieldObservers) {
                if (weakListener != null) {
                    weakListener.setLifecycleOwner(lifecycleOwner);
                }
            }
        }
    }

    public void setRootTag(View view) {
        view.setTag(R.id.dataBinding, this);
    }

    public abstract boolean setVariable(int i2, @Nullable Object obj);

    public void unbind() {
        for (WeakListener weakListener : this.mLocalFieldObservers) {
            if (weakListener != null) {
                weakListener.unregister();
            }
        }
    }

    public boolean unregisterFrom(int i2) {
        WeakListener weakListener = this.mLocalFieldObservers[i2];
        if (weakListener != null) {
            return weakListener.unregister();
        }
        return false;
    }

    public boolean updateLiveDataRegistration(int i2, LiveData<?> liveData) {
        this.mInLiveDataRegisterObserver = true;
        try {
            return updateRegistration(i2, liveData, CREATE_LIVE_DATA_LISTENER);
        } finally {
            this.mInLiveDataRegisterObserver = false;
        }
    }

    public static byte parse(String str, byte b) {
        try {
            return Byte.parseByte(str);
        } catch (NumberFormatException unused) {
            return b;
        }
    }

    public static long safeUnbox(Long l) {
        if (l == null) {
            return 0;
        }
        return l.longValue();
    }

    public void setRootTag(View[] viewArr) {
        for (View tag : viewArr) {
            tag.setTag(R.id.dataBinding, this);
        }
    }

    public static boolean getFromArray(boolean[] zArr, int i2) {
        if (zArr == null || i2 < 0 || i2 >= zArr.length) {
            return false;
        }
        return zArr[i2];
    }

    public static <T> T getFromList(SparseArray<T> sparseArray, int i2) {
        if (sparseArray == null || i2 < 0) {
            return null;
        }
        return sparseArray.get(i2);
    }

    public static Object[] mapBindings(DataBindingComponent dataBindingComponent, View[] viewArr, int i2, IncludedLayouts includedLayouts, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i2];
        for (View mapBindings : viewArr) {
            mapBindings(dataBindingComponent, mapBindings, objArr, includedLayouts, sparseIntArray, true);
        }
        return objArr;
    }

    public static short parse(String str, short s) {
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException unused) {
            return s;
        }
    }

    public static short safeUnbox(Short sh) {
        if (sh == null) {
            return 0;
        }
        return sh.shortValue();
    }

    public static void setTo(boolean[] zArr, int i2, boolean z) {
        if (zArr != null && i2 >= 0 && i2 < zArr.length) {
            zArr[i2] = z;
        }
    }

    @TargetApi(16)
    public static <T> T getFromList(LongSparseArray<T> longSparseArray, int i2) {
        if (longSparseArray == null || i2 < 0) {
            return null;
        }
        return longSparseArray.get((long) i2);
    }

    public static int parse(String str, int i2) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    public static byte safeUnbox(Byte b) {
        if (b == null) {
            return 0;
        }
        return b.byteValue();
    }

    public static byte getFromArray(byte[] bArr, int i2) {
        if (bArr == null || i2 < 0 || i2 >= bArr.length) {
            return 0;
        }
        return bArr[i2];
    }

    public static <T> T getFromList(androidx.collection.LongSparseArray<T> longSparseArray, int i2) {
        if (longSparseArray == null || i2 < 0) {
            return null;
        }
        return longSparseArray.get((long) i2);
    }

    public static long parse(String str, long j) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public static char safeUnbox(Character ch) {
        if (ch == null) {
            return 0;
        }
        return ch.charValue();
    }

    public static void setTo(byte[] bArr, int i2, byte b) {
        if (bArr != null && i2 >= 0 && i2 < bArr.length) {
            bArr[i2] = b;
        }
    }

    public static boolean getFromList(SparseBooleanArray sparseBooleanArray, int i2) {
        if (sparseBooleanArray == null || i2 < 0) {
            return false;
        }
        return sparseBooleanArray.get(i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x010b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void mapBindings(androidx.databinding.DataBindingComponent r16, android.view.View r17, java.lang.Object[] r18, androidx.databinding.ViewDataBinding.IncludedLayouts r19, android.util.SparseIntArray r20, boolean r21) {
        /*
            r6 = r16
            r0 = r17
            r7 = r19
            r8 = r20
            androidx.databinding.ViewDataBinding r1 = getBinding(r17)
            if (r1 == 0) goto L_0x000f
            return
        L_0x000f:
            java.lang.Object r1 = r17.getTag()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x001a
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x001b
        L_0x001a:
            r1 = 0
        L_0x001b:
            java.lang.String r9 = "layout"
            r2 = -1
            r11 = 1
            if (r21 == 0) goto L_0x004b
            if (r1 == 0) goto L_0x004b
            boolean r3 = r1.startsWith(r9)
            if (r3 == 0) goto L_0x004b
            r3 = 95
            int r3 = r1.lastIndexOf(r3)
            if (r3 <= 0) goto L_0x0047
            int r3 = r3 + r11
            boolean r4 = isNumeric(r1, r3)
            if (r4 == 0) goto L_0x0047
            int r1 = parseTagInt(r1, r3)
            r3 = r18[r1]
            if (r3 != 0) goto L_0x0042
            r18[r1] = r0
        L_0x0042:
            if (r7 != 0) goto L_0x0045
            r1 = -1
        L_0x0045:
            r3 = 1
            goto L_0x0049
        L_0x0047:
            r1 = -1
            r3 = 0
        L_0x0049:
            r12 = r1
            goto L_0x0069
        L_0x004b:
            if (r1 == 0) goto L_0x0067
            java.lang.String r3 = "binding_"
            boolean r3 = r1.startsWith(r3)
            if (r3 == 0) goto L_0x0067
            int r3 = BINDING_NUMBER_START
            int r1 = parseTagInt(r1, r3)
            r3 = r18[r1]
            if (r3 != 0) goto L_0x0061
            r18[r1] = r0
        L_0x0061:
            if (r7 != 0) goto L_0x0064
            r1 = -1
        L_0x0064:
            r12 = r1
            r3 = 1
            goto L_0x0069
        L_0x0067:
            r3 = 0
            r12 = -1
        L_0x0069:
            if (r3 != 0) goto L_0x007f
            int r1 = r17.getId()
            if (r1 <= 0) goto L_0x007f
            if (r8 == 0) goto L_0x007f
            int r1 = r8.get(r1, r2)
            if (r1 < 0) goto L_0x007f
            r2 = r18[r1]
            if (r2 != 0) goto L_0x007f
            r18[r1] = r0
        L_0x007f:
            boolean r1 = r0 instanceof android.view.ViewGroup
            if (r1 == 0) goto L_0x0113
            r13 = r0
            android.view.ViewGroup r13 = (android.view.ViewGroup) r13
            int r14 = r13.getChildCount()
            r0 = 0
            r1 = 0
        L_0x008c:
            if (r0 >= r14) goto L_0x0113
            android.view.View r2 = r13.getChildAt(r0)
            if (r12 < 0) goto L_0x00f9
            java.lang.Object r3 = r2.getTag()
            boolean r3 = r3 instanceof java.lang.String
            if (r3 == 0) goto L_0x00f9
            java.lang.Object r3 = r2.getTag()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "_0"
            boolean r4 = r3.endsWith(r4)
            if (r4 == 0) goto L_0x00f9
            boolean r4 = r3.startsWith(r9)
            if (r4 == 0) goto L_0x00f9
            r4 = 47
            int r4 = r3.indexOf(r4)
            if (r4 <= 0) goto L_0x00f9
            int r3 = findIncludeIndex(r3, r1, r7, r12)
            if (r3 < 0) goto L_0x00f9
            int r1 = r3 + 1
            int[][] r4 = r7.indexes
            r4 = r4[r12]
            r4 = r4[r3]
            int[][] r5 = r7.layoutIds
            r5 = r5[r12]
            r3 = r5[r3]
            int r5 = findLastMatching(r13, r0)
            if (r5 != r0) goto L_0x00dc
            androidx.databinding.ViewDataBinding r3 = androidx.databinding.DataBindingUtil.bind((androidx.databinding.DataBindingComponent) r6, (android.view.View) r2, (int) r3)
            r18[r4] = r3
        L_0x00d8:
            r10 = r0
            r11 = r1
            r0 = 1
            goto L_0x00fc
        L_0x00dc:
            int r5 = r5 - r0
            int r5 = r5 + r11
            android.view.View[] r15 = new android.view.View[r5]
            r10 = 0
        L_0x00e1:
            if (r10 >= r5) goto L_0x00ef
            int r11 = r0 + r10
            android.view.View r11 = r13.getChildAt(r11)
            r15[r10] = r11
            int r10 = r10 + 1
            r11 = 1
            goto L_0x00e1
        L_0x00ef:
            androidx.databinding.ViewDataBinding r3 = androidx.databinding.DataBindingUtil.bind((androidx.databinding.DataBindingComponent) r6, (android.view.View[]) r15, (int) r3)
            r18[r4] = r3
            int r5 = r5 + -1
            int r0 = r0 + r5
            goto L_0x00d8
        L_0x00f9:
            r10 = r0
            r11 = r1
            r0 = 0
        L_0x00fc:
            if (r0 != 0) goto L_0x010b
            r5 = 0
            r0 = r16
            r1 = r2
            r2 = r18
            r3 = r19
            r4 = r20
            mapBindings(r0, r1, r2, r3, r4, r5)
        L_0x010b:
            r0 = 1
            int r1 = r10 + 1
            r0 = r1
            r1 = r11
            r11 = 1
            goto L_0x008c
        L_0x0113:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.databinding.ViewDataBinding.mapBindings(androidx.databinding.DataBindingComponent, android.view.View, java.lang.Object[], androidx.databinding.ViewDataBinding$IncludedLayouts, android.util.SparseIntArray, boolean):void");
    }

    public static float parse(String str, float f) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f;
        }
    }

    public static double safeUnbox(Double d) {
        if (d == null) {
            return 0.0d;
        }
        return d.doubleValue();
    }

    public static short getFromArray(short[] sArr, int i2) {
        if (sArr == null || i2 < 0 || i2 >= sArr.length) {
            return 0;
        }
        return sArr[i2];
    }

    public static int getFromList(SparseIntArray sparseIntArray, int i2) {
        if (sparseIntArray == null || i2 < 0) {
            return 0;
        }
        return sparseIntArray.get(i2);
    }

    public static double parse(String str, double d) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d;
        }
    }

    public static float safeUnbox(Float f) {
        if (f == null) {
            return 0.0f;
        }
        return f.floatValue();
    }

    public static void setTo(short[] sArr, int i2, short s) {
        if (sArr != null && i2 >= 0 && i2 < sArr.length) {
            sArr[i2] = s;
        }
    }

    public boolean updateRegistration(int i2, Observable observable) {
        return updateRegistration(i2, observable, CREATE_PROPERTY_LISTENER);
    }

    @TargetApi(18)
    public static long getFromList(SparseLongArray sparseLongArray, int i2) {
        if (sparseLongArray == null || i2 < 0) {
            return 0;
        }
        return sparseLongArray.get(i2);
    }

    public static char parse(String str, char c) {
        return (str == null || str.isEmpty()) ? c : str.charAt(0);
    }

    public static boolean safeUnbox(Boolean bool) {
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean updateRegistration(int i2, ObservableList observableList) {
        return updateRegistration(i2, observableList, CREATE_LIST_LISTENER);
    }

    public static char getFromArray(char[] cArr, int i2) {
        if (cArr == null || i2 < 0 || i2 >= cArr.length) {
            return 0;
        }
        return cArr[i2];
    }

    public static void setTo(char[] cArr, int i2, char c) {
        if (cArr != null && i2 >= 0 && i2 < cArr.length) {
            cArr[i2] = c;
        }
    }

    public boolean updateRegistration(int i2, ObservableMap observableMap) {
        return updateRegistration(i2, observableMap, CREATE_MAP_LISTENER);
    }

    public static int getFromArray(int[] iArr, int i2) {
        if (iArr == null || i2 < 0 || i2 >= iArr.length) {
            return 0;
        }
        return iArr[i2];
    }

    public static void setTo(int[] iArr, int i2, int i3) {
        if (iArr != null && i2 >= 0 && i2 < iArr.length) {
            iArr[i2] = i3;
        }
    }

    public static long getFromArray(long[] jArr, int i2) {
        if (jArr == null || i2 < 0 || i2 >= jArr.length) {
            return 0;
        }
        return jArr[i2];
    }

    public static void setTo(long[] jArr, int i2, long j) {
        if (jArr != null && i2 >= 0 && i2 < jArr.length) {
            jArr[i2] = j;
        }
    }

    public ViewDataBinding(Object obj, View view, int i2) {
        this(checkAndCastToBindingComponent(obj), view, i2);
    }

    public static float getFromArray(float[] fArr, int i2) {
        if (fArr == null || i2 < 0 || i2 >= fArr.length) {
            return 0.0f;
        }
        return fArr[i2];
    }

    public static void setTo(float[] fArr, int i2, float f) {
        if (fArr != null && i2 >= 0 && i2 < fArr.length) {
            fArr[i2] = f;
        }
    }

    public static double getFromArray(double[] dArr, int i2) {
        if (dArr == null || i2 < 0 || i2 >= dArr.length) {
            return 0.0d;
        }
        return dArr[i2];
    }

    public static void setTo(double[] dArr, int i2, double d) {
        if (dArr != null && i2 >= 0 && i2 < dArr.length) {
            dArr[i2] = d;
        }
    }

    public static <T> void setTo(List<T> list, int i2, T t) {
        if (list != null && i2 >= 0 && i2 < list.size()) {
            list.set(i2, t);
        }
    }

    public static <T> void setTo(SparseArray<T> sparseArray, int i2, T t) {
        if (sparseArray != null && i2 >= 0 && i2 < sparseArray.size()) {
            sparseArray.put(i2, t);
        }
    }

    @TargetApi(16)
    public static <T> void setTo(LongSparseArray<T> longSparseArray, int i2, T t) {
        if (longSparseArray != null && i2 >= 0 && i2 < longSparseArray.size()) {
            longSparseArray.put((long) i2, t);
        }
    }

    public static <T> void setTo(androidx.collection.LongSparseArray<T> longSparseArray, int i2, T t) {
        if (longSparseArray != null && i2 >= 0 && i2 < longSparseArray.size()) {
            longSparseArray.put((long) i2, t);
        }
    }

    public static void setTo(SparseBooleanArray sparseBooleanArray, int i2, boolean z) {
        if (sparseBooleanArray != null && i2 >= 0 && i2 < sparseBooleanArray.size()) {
            sparseBooleanArray.put(i2, z);
        }
    }

    public static void setTo(SparseIntArray sparseIntArray, int i2, int i3) {
        if (sparseIntArray != null && i2 >= 0 && i2 < sparseIntArray.size()) {
            sparseIntArray.put(i2, i3);
        }
    }

    @TargetApi(18)
    public static void setTo(SparseLongArray sparseLongArray, int i2, long j) {
        if (sparseLongArray != null && i2 >= 0 && i2 < sparseLongArray.size()) {
            sparseLongArray.put(i2, j);
        }
    }

    public static <K, T> void setTo(Map<K, T> map, K k, T t) {
        if (map != null) {
            map.put(k, t);
        }
    }
}
