package fe.mmm.qw.d.ad;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import fe.mmm.qw.d.ad.ggg.de;
import fe.mmm.qw.d.fe.yj;
import java.lang.reflect.Field;

public class th extends de {
    public void de(View view) {
        if ((view instanceof ListView) && yj()) {
            uk((ListView) view);
        }
    }

    public final void uk(ListView listView) {
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mFastScroll");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(listView);
            Field declaredField2 = declaredField.getType().getDeclaredField("mThumbImage");
            declaredField2.setAccessible(true);
            ImageView imageView = (ImageView) declaredField2.get(obj);
            imageView.setImageDrawable(yj.rg(this.f7683th));
            declaredField2.set(obj, imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
