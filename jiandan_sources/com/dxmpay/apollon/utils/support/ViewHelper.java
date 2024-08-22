package com.dxmpay.apollon.utils.support;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public final class ViewHelper {

    public static final class qw {
        public static float a(View view) {
            return view.getX();
        }

        public static void aaa(View view, float f) {
            view.setTranslationY(f);
        }

        public static void ad(View view, float f) {
            view.setAlpha(f);
        }

        public static float b(View view) {
            return view.getY();
        }

        public static float ddd(View view) {
            return (float) view.getScrollX();
        }

        public static void de(View view, int i2) {
            view.setScrollX(i2);
        }

        public static void eee(View view, float f) {
            view.setX(f);
        }

        public static float fe(View view) {
            return view.getPivotX();
        }

        public static void ggg(View view, float f) {
            view.setScaleX(f);
        }

        public static float i(View view) {
            return view.getRotation();
        }

        /* renamed from: if  reason: not valid java name */
        public static void m273if(View view, float f) {
            view.setRotationX(f);
        }

        public static float mmm(View view) {
            return (float) view.getScrollY();
        }

        public static void nn(View view, float f) {
            view.setTranslationX(f);
        }

        public static void o(View view, float f) {
            view.setRotation(f);
        }

        public static float pf(View view) {
            return view.getRotationX();
        }

        public static float ppp(View view) {
            return view.getScaleX();
        }

        public static float qqq(View view) {
            return view.getTranslationX();
        }

        public static float qw(View view) {
            return view.getAlpha();
        }

        public static void rg(View view, float f) {
            view.setPivotX(f);
        }

        public static float rrr(View view) {
            return view.getTranslationY();
        }

        /* renamed from: switch  reason: not valid java name */
        public static float m274switch(View view) {
            return view.getRotationY();
        }

        public static void th(View view, int i2) {
            view.setScrollY(i2);
        }

        public static void tt(View view, float f) {
            view.setY(f);
        }

        public static void uk(View view, float f) {
            view.setPivotY(f);
        }

        public static float vvv(View view) {
            return view.getScaleY();
        }

        public static void when(View view, float f) {
            view.setRotationY(f);
        }

        public static void xxx(View view, float f) {
            view.setScaleY(f);
        }

        public static float yj(View view) {
            return view.getPivotY();
        }
    }

    public static void ad(ArrayList<View> arrayList, View view, boolean z) {
        if (arrayList != null && arrayList.size() > 0 && view != null) {
            ArrayList<View> qw2 = qw(view);
            for (int i2 = 1; i2 < qw2.size(); i2++) {
                View view2 = qw2.get(i2);
                if (view2 != null && arrayList.contains(view2)) {
                    arrayList.remove(view2);
                }
            }
            if (z && arrayList.contains(view)) {
                arrayList.remove(view);
            }
        }
    }

    public static void de(ArrayList<View> arrayList, View view, boolean z) {
        if (arrayList != null && arrayList.size() > 0 && view != null) {
            View view2 = (View) view.getParent();
            if (view2 != null) {
                arrayList.remove(view2);
                de(arrayList, view2, true);
            }
            if (z && arrayList.contains(view)) {
                arrayList.remove(view);
            }
        }
    }

    public static float getAlpha(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getAlpha() : qw.qw(view);
    }

    public static float getPivotX(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getPivotX() : qw.fe(view);
    }

    public static float getPivotY(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getPivotY() : qw.yj(view);
    }

    public static float getRotation(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getRotation();
        }
        return qw.i(view);
    }

    public static float getRotationX(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getRotationX();
        }
        return qw.pf(view);
    }

    public static float getRotationY(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getRotationY();
        }
        return qw.m274switch(view);
    }

    public static float getScaleX(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getScaleX() : qw.ppp(view);
    }

    public static float getScaleY(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getScaleY() : qw.vvv(view);
    }

    public static float getScrollX(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return (float) AnimatorProxy.wrap(view).getScrollX();
        }
        return qw.ddd(view);
    }

    public static float getScrollY(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return (float) AnimatorProxy.wrap(view).getScrollY();
        }
        return qw.mmm(view);
    }

    public static float getTranslationX(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getTranslationX();
        }
        return qw.qqq(view);
    }

    public static float getTranslationY(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getTranslationY();
        }
        return qw.rrr(view);
    }

    public static float getX(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getX() : qw.a(view);
    }

    public static float getY(View view) {
        return AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(view).getY() : qw.b(view);
    }

    public static ArrayList<View> qw(View view) {
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
            arrayList3.addAll(qw(childAt));
            arrayList2.addAll(arrayList3);
        }
        return arrayList2;
    }

    public static void setAlpha(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setAlpha(f);
        } else {
            qw.ad(view, f);
        }
    }

    public static void setAlphaPartly(View view, float f, View... viewArr) {
        if (view != null) {
            if (viewArr == null || viewArr.length <= 0 || !(view instanceof ViewGroup)) {
                setAlpha(view, f);
                return;
            }
            ArrayList<View> qw2 = qw(view);
            if (qw2 == null || qw2.size() <= 0) {
                setAlpha(view, f);
                return;
            }
            for (View de2 : viewArr) {
                de(qw2, de2, true);
            }
            for (int i2 = 0; i2 < qw2.size(); i2++) {
                View view2 = qw2.get(i2);
                if ((view2 instanceof ViewGroup) && ((ViewGroup) view2).getChildCount() > 0) {
                    ad(qw2, view2, false);
                }
            }
            for (int i3 = 0; i3 < qw2.size(); i3++) {
                View view3 = qw2.get(i3);
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
            qw.rg(view, f);
        }
    }

    public static void setPivotY(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setPivotY(f);
        } else {
            qw.uk(view, f);
        }
    }

    public static void setRotation(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setRotation(f);
        } else {
            qw.o(view, f);
        }
    }

    public static void setRotationX(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setRotationX(f);
        } else {
            qw.m273if(view, f);
        }
    }

    public static void setRotationY(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setRotationY(f);
        } else {
            qw.when(view, f);
        }
    }

    public static void setScaleX(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScaleX(f);
        } else {
            qw.ggg(view, f);
        }
    }

    public static void setScaleY(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScaleY(f);
        } else {
            qw.xxx(view, f);
        }
    }

    public static void setScrollX(View view, int i2) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScrollX(i2);
        } else {
            qw.de(view, i2);
        }
    }

    public static void setScrollY(View view, int i2) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScrollY(i2);
        } else {
            qw.th(view, i2);
        }
    }

    public static void setTranslationX(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setTranslationX(f);
        } else {
            qw.nn(view, f);
        }
    }

    public static void setTranslationY(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setTranslationY(f);
        } else {
            qw.aaa(view, f);
        }
    }

    public static void setX(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setX(f);
        } else {
            qw.eee(view, f);
        }
    }

    public static void setY(View view, float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setY(f);
        } else {
            qw.tt(view, f);
        }
    }
}
