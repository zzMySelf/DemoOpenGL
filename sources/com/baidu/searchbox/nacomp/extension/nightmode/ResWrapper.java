package com.baidu.searchbox.nacomp.extension.nightmode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;

public class ResWrapper {
    public static int getColor(Context context, int resId) {
        return context.getResources().getColor(resId);
    }

    public static Drawable getDrawable(Context context, int resId) {
        if (context.getResources() != null) {
            return ResourcesCompat.getDrawable(context.getResources(), resId, (Resources.Theme) null);
        }
        return null;
    }

    public static void setBackgroundColor(View view2, int resId) {
        if (view2 != null) {
            view2.setBackgroundColor(getColor(view2.getContext(), resId));
        }
    }

    public static void setTextColor(TextView textView, int resId) {
        if (textView != null) {
            textView.setTextColor(getColor(textView.getContext(), resId));
        }
    }

    public static void setBackground(View view2, int drawable) {
        if (view2 != null) {
            view2.setBackground(getDrawable(view2.getContext(), drawable));
        }
    }

    public static void setImageDrawable(ImageView imageView, int drawable) {
        if (imageView != null) {
            imageView.setImageDrawable(getDrawable(imageView.getContext(), drawable));
        }
    }
}
