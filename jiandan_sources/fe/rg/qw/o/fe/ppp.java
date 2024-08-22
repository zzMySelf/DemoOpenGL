package fe.rg.qw.o.fe;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import fe.rg.qw.ggg.uk;
import fe.rg.qw.o.ad;
import fe.rg.qw.o.fe.th;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class ppp<Data, ResourceType, Transcode> {

    /* renamed from: ad  reason: collision with root package name */
    public final List<? extends th<Data, ResourceType, Transcode>> f4847ad;

    /* renamed from: de  reason: collision with root package name */
    public final String f4848de;
    public final Pools.Pool<List<Throwable>> qw;

    public ppp(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<th<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.qw = pool;
        uk.de(list);
        this.f4847ad = list;
        this.f4848de = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public final Resource<Transcode> ad(DataRewinder<Data> dataRewinder, @NonNull ad adVar, int i2, int i3, th.qw<ResourceType> qwVar, List<Throwable> list) throws GlideException {
        List<Throwable> list2 = list;
        int size = this.f4847ad.size();
        Resource<Transcode> resource = null;
        for (int i4 = 0; i4 < size; i4++) {
            try {
                resource = ((th) this.f4847ad.get(i4)).qw(dataRewinder, i2, i3, adVar, qwVar);
            } catch (GlideException e) {
                list2.add(e);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.f4848de, (List<Throwable>) new ArrayList(list2));
    }

    public Resource<Transcode> qw(DataRewinder<Data> dataRewinder, @NonNull ad adVar, int i2, int i3, th.qw<ResourceType> qwVar) throws GlideException {
        List<Throwable> acquire = this.qw.acquire();
        uk.fe(acquire);
        List list = acquire;
        try {
            return ad(dataRewinder, adVar, i2, i3, qwVar, list);
        } finally {
            this.qw.release(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f4847ad.toArray()) + ExtendedMessageFormat.END_FE;
    }
}
