package b.a.a.b.c;

import android.util.Log;
import com.baidu.mapapi.search.poi.PoiDetailSearchOption;
import com.baidu.platform.domain.c;
import com.baidu.talos.core.render.bindingx.internal.BindingXConstants;

public class e extends com.baidu.platform.base.e {
    e(PoiDetailSearchOption poiDetailSearchOption) {
        a(poiDetailSearchOption);
    }

    private void a(PoiDetailSearchOption poiDetailSearchOption) {
        if (poiDetailSearchOption == null) {
            Log.e(e.class.getSimpleName(), "Option is null");
            return;
        }
        if (!poiDetailSearchOption.isSearchByUids()) {
            poiDetailSearchOption.poiUids(poiDetailSearchOption.getUid());
        }
        this.f16200c.a("uids", poiDetailSearchOption.getUids());
        this.f16200c.a(BindingXConstants.KEY_INTERPOLATER_OUTPUT, "json");
        this.f16200c.a("scope", "2");
    }

    public String a(c cVar) {
        return cVar.b();
    }
}
