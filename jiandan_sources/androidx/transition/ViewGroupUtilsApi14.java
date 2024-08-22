package androidx.transition;

import android.animation.Animator;
import android.animation.LayoutTransition;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ViewGroupUtilsApi14 {
    public static final int LAYOUT_TRANSITION_CHANGING = 4;
    public static final String TAG = "ViewGroupUtilsApi14";
    public static Method sCancelMethod;
    public static boolean sCancelMethodFetched;
    public static LayoutTransition sEmptyLayoutTransition;
    public static Field sLayoutSuppressedField;
    public static boolean sLayoutSuppressedFieldFetched;

    public static void cancelLayoutTransition(LayoutTransition layoutTransition) {
        if (!sCancelMethodFetched) {
            try {
                Method declaredMethod = LayoutTransition.class.getDeclaredMethod(QueryResponse.Options.CANCEL, new Class[0]);
                sCancelMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            sCancelMethodFetched = true;
        }
        Method method = sCancelMethod;
        if (method != null) {
            try {
                method.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
    }

    public static void suppressLayout(@NonNull ViewGroup viewGroup, boolean z) {
        boolean z2 = false;
        if (sEmptyLayoutTransition == null) {
            AnonymousClass1 r0 = new LayoutTransition() {
                public boolean isChangingLayout() {
                    return true;
                }
            };
            sEmptyLayoutTransition = r0;
            r0.setAnimator(2, (Animator) null);
            sEmptyLayoutTransition.setAnimator(0, (Animator) null);
            sEmptyLayoutTransition.setAnimator(1, (Animator) null);
            sEmptyLayoutTransition.setAnimator(3, (Animator) null);
            sEmptyLayoutTransition.setAnimator(4, (Animator) null);
        }
        if (z) {
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null) {
                if (layoutTransition.isRunning()) {
                    cancelLayoutTransition(layoutTransition);
                }
                if (layoutTransition != sEmptyLayoutTransition) {
                    viewGroup.setTag(R.id.transition_layout_save, layoutTransition);
                }
            }
            viewGroup.setLayoutTransition(sEmptyLayoutTransition);
            return;
        }
        viewGroup.setLayoutTransition((LayoutTransition) null);
        if (!sLayoutSuppressedFieldFetched) {
            try {
                Field declaredField = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
                sLayoutSuppressedField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            sLayoutSuppressedFieldFetched = true;
        }
        Field field = sLayoutSuppressedField;
        if (field != null) {
            try {
                boolean z3 = field.getBoolean(viewGroup);
                if (z3) {
                    try {
                        sLayoutSuppressedField.setBoolean(viewGroup, false);
                    } catch (IllegalAccessException unused2) {
                    }
                }
                z2 = z3;
            } catch (IllegalAccessException unused3) {
            }
        }
        if (z2) {
            viewGroup.requestLayout();
        }
        LayoutTransition layoutTransition2 = (LayoutTransition) viewGroup.getTag(R.id.transition_layout_save);
        if (layoutTransition2 != null) {
            viewGroup.setTag(R.id.transition_layout_save, (Object) null);
            viewGroup.setLayoutTransition(layoutTransition2);
        }
    }
}
