package com.baidu.apollon.utils.support;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public final class ViewHelper {

    public static final class a {
        public static float a(View view) {
            return view.getAlpha();
        }

        public static float b(View view) {
            return view.getPivotX();
        }

        public static float c(View view) {
            return view.getPivotY();
        }

        public static float d(View view) {
            return view.getRotation();
        }

        public static float e(View view) {
            return view.getRotationX();
        }

        public static float f(View view) {
            return view.getRotationY();
        }

        public static float g(View view) {
            return view.getScaleX();
        }

        public static float h(View view) {
            return view.getScaleY();
        }

        public static float i(View view) {
            return (float) view.getScrollX();
        }

        public static float j(View view) {
            return (float) view.getScrollY();
        }

        public static float k(View view) {
            return view.getTranslationX();
        }

        public static float l(View view) {
            return view.getTranslationY();
        }

        public static float m(View view) {
            return view.getX();
        }

        public static float n(View view) {
            return view.getY();
        }

        public static void a(View view, float f) {
            view.setAlpha(f);
        }

        public static void b(View view, float f) {
            view.setPivotX(f);
        }

        public static void c(View view, float f) {
            view.setPivotY(f);
        }

        public static void d(View view, float f) {
            view.setRotation(f);
        }

        public static void e(View view, float f) {
            view.setRotationX(f);
        }

        public static void f(View view, float f) {
            view.setRotationY(f);
        }

        public static void g(View view, float f) {
            view.setScaleX(f);
        }

        public static void h(View view, float f) {
            view.setScaleY(f);
        }

        public static void i(View view, float f) {
            view.setTranslationX(f);
        }

        public static void j(View view, float f) {
            view.setTranslationY(f);
        }

        public static void k(View view, float f) {
            view.setX(f);
        }

        public static void l(View view, float f) {
            view.setY(f);
        }

        public static void a(View view, int i2) {
            view.setScrollX(i2);
        }

        public static void b(View view, int i2) {
            view.setScrollY(i2);
        }
    }

    public static void a(ArrayList<View> arrayList, View view, boolean z) {
        if (arrayList != null && arrayList.size() > 0 && view != null) {
            ArrayList<View> a2 = a(view);
            for (int i2 = 1; i2 < a2.size(); i2++) {
                View view2 = a2.get(i2);
                if (view2 != null && arrayList.contains(view2)) {
                    arrayList.remove(view2);
                }
            }
            if (z && arrayList.contains(view)) {
                arrayList.remove(view);
            }
        }
    }

    public static void b(ArrayList<View> arrayList, View view, boolean z) {
        if (arrayList != null && arrayList.size() > 0 && view != null) {
            View view2 = (View) view.getParent();
            if (view2 != null) {
                arrayList.remove(view2);
                b(arrayList, view2, true);
            }
            if (z && arrayList.contains(view)) {
                arrayList.remove(view);
            }
        }
    }

    public static float getAlpha(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getAlpha() : a.a(view);
    }

    public static float getPivotX(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getPivotX() : a.b(view);
    }

    public static float getPivotY(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getPivotY() : a.c(view);
    }

    public static float getRotation(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getRotation();
        }
        return a.d(view);
    }

    public static float getRotationX(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getRotationX();
        }
        return a.e(view);
    }

    public static float getRotationY(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getRotationY();
        }
        return a.f(view);
    }

    public static float getScaleX(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getScaleX() : a.g(view);
    }

    public static float getScaleY(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getScaleY() : a.h(view);
    }

    public static float getScrollX(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return (float) AnimatorProxy.wrap(view).getScrollX();
        }
        return a.i(view);
    }

    public static float getScrollY(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return (float) AnimatorProxy.wrap(view).getScrollY();
        }
        return a.j(view);
    }

    public static float getTranslationX(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getTranslationX();
        }
        return a.k(view);
    }

    public static float getTranslationY(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getTranslationY();
        }
        return a.l(view);
    }

    public static float getX(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getX() : a.m(view);
    }

    public static float getY(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getY() : a.n(view);
    }

    public static void setAlpha(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setAlpha(f);
        } else {
            a.a(view, f);
        }
    }

    public static void setAlphaPartly(View view, float f, View... viewArr) {
        if (view != null) {
            if (viewArr == null || viewArr.length <= 0 || !(view instanceof ViewGroup)) {
                setAlpha(view, f);
                return;
            }
            ArrayList<View> a2 = a(view);
            if (a2 == null || a2.size() <= 0) {
                setAlpha(view, f);
                return;
            }
            for (View b : viewArr) {
                b(a2, b, true);
            }
            for (int i2 = 0; i2 < a2.size(); i2++) {
                View view2 = a2.get(i2);
                if ((view2 instanceof ViewGroup) && ((ViewGroup) view2).getChildCount() > 0) {
                    a(a2, view2, false);
                }
            }
            for (int i3 = 0; i3 < a2.size(); i3++) {
                View view3 = a2.get(i3);
                if (view3 != null) {
                    setAlpha(view3, f);
                }
            }
        }
    }

    public static void setPivotX(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setPivotX(f);
        } else {
            a.b(view, f);
        }
    }

    public static void setPivotY(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setPivotY(f);
        } else {
            a.c(view, f);
        }
    }

    public static void setRotation(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setRotation(f);
        } else {
            a.d(view, f);
        }
    }

    public static void setRotationX(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setRotationX(f);
        } else {
            a.e(view, f);
        }
    }

    public static void setRotationY(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setRotationY(f);
        } else {
            a.f(view, f);
        }
    }

    public static void setScaleX(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScaleX(f);
        } else {
            a.g(view, f);
        }
    }

    public static void setScaleY(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScaleY(f);
        } else {
            a.h(view, f);
        }
    }

    public static void setScrollX(View view, int i2) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScrollX(i2);
        } else {
            a.a(view, i2);
        }
    }

    public static void setScrollY(View view, int i2) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScrollY(i2);
        } else {
            a.b(view, i2);
        }
    }

    public static void setTranslationX(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setTranslationX(f);
        } else {
            a.i(view, f);
        }
    }

    public static void setTranslationY(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setTranslationY(f);
        } else {
            a.j(view, f);
        }
    }

    public static void setX(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setX(f);
        } else {
            a.k(view, f);
        }
    }

    public static void setY(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setY(f);
        } else {
            a.l(view, f);
        }
    }

    public static ArrayList<View> a(View view) {
        if (!(view instanceof ViewGroup)) {
            ArrayList<View> arrayList = new ArrayList<>();
            arrayList.add(view);
            return arrayList;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        arrayList2.add(view);
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(a(childAt));
            arrayList2.addAll(arrayList3);
        }
        return arrayList2;
    }
}
