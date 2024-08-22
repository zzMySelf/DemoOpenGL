package fe.uk.qw.pf.th.th;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

public final class qw {
    public static volatile boolean qw = true;

    public static Drawable ad(Context context, Context context2, @DrawableRes int i2) {
        return de(context, context2, i2, (Resources.Theme) null);
    }

    public static Drawable de(Context context, Context context2, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        try {
            if (qw) {
                return rg(context2, i2, theme);
            }
        } catch (NoClassDefFoundError unused) {
            qw = false;
        } catch (IllegalStateException e) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                return ContextCompat.getDrawable(context2, i2);
            }
            throw e;
        } catch (Resources.NotFoundException unused2) {
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return fe(context2, i2, theme);
    }

    public static Drawable fe(Context context, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        return ResourcesCompat.getDrawable(context.getResources(), i2, theme);
    }

    public static Drawable qw(Context context, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        return de(context, context, i2, theme);
    }

    public static Drawable rg(Context context, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        if (theme != null) {
            context = new ContextThemeWrapper(context, theme);
        }
        return AppCompatResources.getDrawable(context, i2);
    }
}
