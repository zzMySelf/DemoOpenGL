package fe.mmm.qw.d.de;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.baidu.apollon.utils.ResUtils;
import com.tera.scan.themeskin.base.SkinBaseActivity;
import com.tera.scan.themeskin.base.SkinBaseActivityGroup;
import com.tera.scan.themeskin.loader.LayoutInflaterIntercept;
import fe.mmm.qw.d.ad.ggg.de;
import fe.mmm.qw.d.ad.ggg.fe;
import fe.mmm.qw.d.ad.ggg.qw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class ad implements LayoutInflaterIntercept {

    /* renamed from: ad  reason: collision with root package name */
    public final Activity f7688ad;
    public Map<View, fe> qw = new HashMap();

    public ad(Activity activity) {
        this.f7688ad = activity;
    }

    public final void ad(fe feVar) {
        if (this.qw.get(feVar.qw) != null) {
            this.qw.get(feVar.qw).f7686ad.addAll(feVar.f7686ad);
        } else {
            this.qw.put(feVar.qw, feVar);
        }
    }

    public void de() {
        if (!this.qw.isEmpty()) {
            for (View next : this.qw.keySet()) {
                if (next != null) {
                    this.qw.get(next).qw();
                }
            }
        }
    }

    public void fe() {
        for (View next : this.qw.keySet()) {
            if (next != null) {
                this.qw.get(next).ad();
            }
        }
        fe.ad(this.f7688ad);
        this.qw.clear();
        this.qw = null;
    }

    public final void i(int i2, String str, Context context, List<de> list, String str2, String str3) {
        if (i2 != -1) {
            String resourceEntryName = context.getResources().getResourceEntryName(i2);
            String resourceTypeName = context.getResources().getResourceTypeName(i2);
            de qw2 = qw.qw(str, i2, resourceEntryName, resourceTypeName);
            fe.mmm.qw.d.fe.ad.de("skinTheme/SkinInflaterFactory", str, "   in style is supported:", StringUtils.LF, "    resource id:", String.valueOf(i2), StringUtils.LF, "    attrName:", str2, StringUtils.LF, "    attrValue:", str3, StringUtils.LF, "    entryName:", resourceEntryName, StringUtils.LF, "    typeName:", resourceTypeName);
            if (qw2 == null) {
                return;
            }
            if (NotificationCompat.WearableExtender.KEY_BACKGROUND.equals(str)) {
                list.add(0, qw2);
            } else {
                list.add(qw2);
            }
        }
    }

    public void o(View view) {
        fe.mmm.qw.d.fe.ad.ad("skinTheme/SkinInflaterFactory", "removeSkinView:" + view);
        fe remove = this.qw.remove(view);
        if (remove != null) {
            fe.mmm.qw.d.fe.ad.de("skinTheme/SkinInflaterFactory", "removeSkinView from mSkinItemMap:" + remove.qw);
        }
        if (fe.mmm.qw.d.qw.de() && (view instanceof TextView)) {
            fe.mmm.qw.d.fe.ad.qw("skinTheme/SkinInflaterFactory", "removeSkinView from TextViewRepository:" + view);
            fe.de(this.f7688ad, (TextView) view);
        }
    }

    public void qw(View view, Context context, AttributeSet attributeSet) {
        if (view != null) {
            boolean attributeBooleanValue = attributeSet.getAttributeBooleanValue("http://schemas.android.com/android/skin", "enable", true);
            if (attributeBooleanValue || fe.mmm.qw.d.qw.th()) {
                if (view != null && (view instanceof TextView) && fe.mmm.qw.d.qw.de()) {
                    fe.qw(this.f7688ad, (TextView) view);
                }
                if (attributeBooleanValue) {
                    Activity activity = this.f7688ad;
                    if (activity instanceof SkinBaseActivity) {
                        if (((SkinBaseActivity) activity).isActivityDark()) {
                            uk(context, attributeSet, view);
                        }
                    } else if ((activity instanceof SkinBaseActivityGroup) && ((SkinBaseActivityGroup) activity).isActivityDark()) {
                        uk(context, attributeSet, view);
                    }
                }
            }
        }
    }

    public void rg(Activity activity, TextView textView) {
        fe.qw(activity, textView);
    }

    public void th(Context context, View view, String str, int i2) {
        de qw2 = qw.qw(str, i2, context.getResources().getResourceEntryName(i2), context.getResources().getResourceTypeName(i2));
        fe feVar = new fe();
        feVar.qw = view;
        ArrayList arrayList = new ArrayList();
        arrayList.add(qw2);
        feVar.f7686ad = arrayList;
        feVar.qw();
        ad(feVar);
    }

    public final void uk(Context context, AttributeSet attributeSet, View view) {
        int i2;
        AttributeSet attributeSet2 = attributeSet;
        View view2 = view;
        ArrayList arrayList = new ArrayList();
        int i3 = 2;
        fe.mmm.qw.d.fe.ad.ad("skinTheme/SkinInflaterFactory", "viewName:", view.getClass().getSimpleName());
        int i4 = 0;
        while (i4 < attributeSet.getAttributeCount()) {
            String attributeName = attributeSet2.getAttributeName(i4);
            String attributeValue = attributeSet2.getAttributeValue(i4);
            String[] strArr = new String[4];
            strArr[0] = "    AttributeName:";
            strArr[1] = attributeName;
            strArr[i3] = "|attrValue:";
            strArr[3] = attributeValue;
            fe.mmm.qw.d.fe.ad.ad("skinTheme/SkinInflaterFactory", strArr);
            if (ResUtils.d.equals(attributeName)) {
                TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, new int[]{16842904, 16842964, 16843049, 16843050, 16842965, 16842966, 16842968, 16842967, 16842969, 16843574, 16843015}, 0, 0);
                int resourceId = obtainStyledAttributes.getResourceId(0, -1);
                int resourceId2 = obtainStyledAttributes.getResourceId(1, -1);
                int resourceId3 = obtainStyledAttributes.getResourceId(i3, -1);
                int resourceId4 = obtainStyledAttributes.getResourceId(3, -1);
                int resourceId5 = obtainStyledAttributes.getResourceId(4, -1);
                int resourceId6 = obtainStyledAttributes.getResourceId(5, -1);
                int resourceId7 = obtainStyledAttributes.getResourceId(6, -1);
                int resourceId8 = obtainStyledAttributes.getResourceId(7, -1);
                int resourceId9 = obtainStyledAttributes.getResourceId(8, -1);
                int resourceId10 = obtainStyledAttributes.getResourceId(9, -1);
                int resourceId11 = obtainStyledAttributes.getResourceId(10, -1);
                int i5 = resourceId;
                TypedArray typedArray = obtainStyledAttributes;
                Context context2 = context;
                ArrayList arrayList2 = arrayList;
                String str = attributeValue;
                String str2 = attributeName;
                i2 = i4;
                String str3 = str;
                i(i5, "textColor", context2, arrayList2, str2, str3);
                i(resourceId2, NotificationCompat.WearableExtender.KEY_BACKGROUND, context2, arrayList2, str2, str3);
                i(resourceId3, "divider", context2, arrayList2, str2, str3);
                i(resourceId4, "dividerHeight", context2, arrayList2, str2, str3);
                i(resourceId5, "padding", context2, arrayList2, str2, str3);
                i(resourceId6, "paddingLeft", context2, arrayList2, str2, str3);
                i(resourceId7, "paddingRight", context2, arrayList2, str2, str3);
                i(resourceId6, "paddingLeft", context2, arrayList2, str2, str3);
                i(resourceId8, "paddingTop", context2, arrayList2, str2, str3);
                i(resourceId9, "paddingBottom", context2, arrayList2, str2, str3);
                i(resourceId10, "fastScrollThumbDrawable", context2, arrayList2, str2, str3);
                i(resourceId11, "button", context2, arrayList2, str2, str3);
                typedArray.recycle();
                Map<Integer, Pair<String, de>> ad2 = qw.ad();
                int size = ad2.size();
                if (size > 0) {
                    Iterator<Map.Entry<Integer, Pair<String, de>>> it = ad2.entrySet().iterator();
                    int[] iArr = new int[size];
                    Pair[] pairArr = new Pair[size];
                    for (int i6 = 0; i6 < size; i6++) {
                        Map.Entry next = it.next();
                        iArr[i6] = ((Integer) next.getKey()).intValue();
                        pairArr[i6] = (Pair) next.getValue();
                    }
                    TypedArray obtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(attributeSet2, iArr, 0, 0);
                    int i7 = 0;
                    while (i7 < size) {
                        i(obtainStyledAttributes2.getResourceId(i7, -1), (String) pairArr[i7].first, context, arrayList, attributeName, str);
                        i7++;
                        obtainStyledAttributes2 = obtainStyledAttributes2;
                        pairArr = pairArr;
                        size = size;
                    }
                    obtainStyledAttributes2.recycle();
                }
            } else {
                String str4 = attributeValue;
                i2 = i4;
                if (qw.de(attributeName)) {
                    String str5 = str4;
                    if (str5.startsWith("@")) {
                        try {
                            int parseInt = Integer.parseInt(str5.substring(1));
                            if (parseInt != 0) {
                                String resourceEntryName = context.getResources().getResourceEntryName(parseInt);
                                String resourceTypeName = context.getResources().getResourceTypeName(parseInt);
                                de qw2 = qw.qw(attributeName, parseInt, resourceEntryName, resourceTypeName);
                                String[] strArr2 = new String[18];
                                strArr2[0] = "    ";
                                strArr2[1] = attributeName;
                                try {
                                    strArr2[2] = " is supported:";
                                    strArr2[3] = StringUtils.LF;
                                    strArr2[4] = "    resource id:";
                                    strArr2[5] = String.valueOf(parseInt);
                                    strArr2[6] = StringUtils.LF;
                                    strArr2[7] = "    attrName:";
                                    strArr2[8] = attributeName;
                                    strArr2[9] = StringUtils.LF;
                                    strArr2[10] = "    attrValue:";
                                    strArr2[11] = str5;
                                    strArr2[12] = StringUtils.LF;
                                    strArr2[13] = "    entryName:";
                                    strArr2[14] = resourceEntryName;
                                    strArr2[15] = StringUtils.LF;
                                    strArr2[16] = "    typeName:";
                                    strArr2[17] = resourceTypeName;
                                    fe.mmm.qw.d.fe.ad.de("skinTheme/SkinInflaterFactory", strArr2);
                                    if (qw2 != null) {
                                        if (NotificationCompat.WearableExtender.KEY_BACKGROUND.equals(attributeName)) {
                                            arrayList.add(0, qw2);
                                        } else {
                                            arrayList.add(qw2);
                                        }
                                    }
                                } catch (NumberFormatException e) {
                                    e = e;
                                    fe.mmm.qw.d.fe.ad.qw("skinTheme/SkinInflaterFactory", e.toString());
                                    i4 = i2 + 1;
                                    i3 = 2;
                                }
                                i4 = i2 + 1;
                                i3 = 2;
                            }
                        } catch (NumberFormatException e2) {
                            e = e2;
                            fe.mmm.qw.d.fe.ad.qw("skinTheme/SkinInflaterFactory", e.toString());
                            i4 = i2 + 1;
                            i3 = 2;
                        }
                    }
                }
            }
            i4 = i2 + 1;
            i3 = 2;
        }
        if (!fe.mmm.qw.d.fe.fe.qw(arrayList)) {
            fe feVar = new fe();
            feVar.qw = view2;
            feVar.f7686ad = arrayList;
            Map<View, fe> map = this.qw;
            if (map != null) {
                map.put(view2, feVar);
                if (de.when().xxx()) {
                    feVar.qw();
                    return;
                }
                return;
            }
            return;
        }
    }

    public void yj(Context context, View view, List<fe.mmm.qw.d.ad.ggg.ad> list) {
        ArrayList arrayList = new ArrayList();
        fe feVar = new fe();
        feVar.qw = view;
        for (fe.mmm.qw.d.ad.ggg.ad next : list) {
            int ad2 = next.ad();
            arrayList.add(qw.qw(next.qw(), ad2, context.getResources().getResourceEntryName(ad2), context.getResources().getResourceTypeName(ad2)));
        }
        feVar.f7686ad = arrayList;
        feVar.qw();
        ad(feVar);
    }
}
