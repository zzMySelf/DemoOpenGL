package fe.mmm.qw.d.ad;

import android.view.View;
import android.widget.ListView;
import androidx.recyclerview.widget.RecyclerView;
import com.tera.scan.themeskin.viewcomplemen.RecyclerViewItemDecoration;
import fe.mmm.qw.d.fe.yj;

public class de extends fe.mmm.qw.d.ad.ggg.de {
    public void de(View view) {
        RecyclerViewItemDecoration recyclerViewItemDecoration;
        if (view instanceof ListView) {
            if (yj()) {
                ListView listView = (ListView) view;
                listView.setDivider(yj.rg(this.f7683th));
                listView.setDividerHeight(1);
            }
        } else if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getItemDecorationCount() <= 0 || !(((RecyclerViewItemDecoration) recyclerView.getItemDecorationAt(0)) instanceof RecyclerViewItemDecoration)) {
                recyclerViewItemDecoration = new RecyclerViewItemDecoration();
            } else {
                recyclerViewItemDecoration = (RecyclerViewItemDecoration) recyclerView.getItemDecorationAt(0);
            }
            while (recyclerView.getItemDecorationCount() > 0) {
                recyclerView.removeItemDecorationAt(0);
            }
            if (yj()) {
                recyclerViewItemDecoration.setmDividerDrawable(yj.rg(this.f7683th));
            } else if (rg()) {
                recyclerViewItemDecoration.setColor(yj.qw(this.f7683th));
            }
            if (recyclerViewItemDecoration != null) {
                recyclerView.addItemDecoration(recyclerViewItemDecoration);
            }
        }
    }
}
