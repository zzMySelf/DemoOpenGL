package fe.uk.qw.pf.fe;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.dxmbumptech.glide.load.data.DataRewinder;
import com.dxmbumptech.glide.load.engine.GlideException;
import com.dxmbumptech.glide.load.engine.Resource;
import fe.uk.qw.pf.ad;
import fe.uk.qw.pf.fe.th;
import fe.uk.qw.vvv.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class ppp<Data, ResourceType, Transcode> {

    /* renamed from: ad  reason: collision with root package name */
    public final List<? extends th<Data, ResourceType, Transcode>> f5822ad;

    /* renamed from: de  reason: collision with root package name */
    public final String f5823de;
    public final Pools.Pool<List<Throwable>> qw;

    public ppp(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<th<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.qw = pool;
        i.de(list);
        this.f5822ad = list;
        this.f5823de = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public final Resource<Transcode> ad(DataRewinder<Data> dataRewinder, @NonNull ad adVar, int i2, int i3, th.qw<ResourceType> qwVar, List<Throwable> list) throws GlideException {
        List<Throwable> list2 = list;
        int size = this.f5822ad.size();
        Resource<Transcode> resource = null;
        for (int i4 = 0; i4 < size; i4++) {
            try {
                resource = ((th) this.f5822ad.get(i4)).qw(dataRewinder, i2, i3, adVar, qwVar);
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
        throw new GlideException(this.f5823de, (List<Throwable>) new ArrayList(list2));
    }

    public Resource<Transcode> qw(DataRewinder<Data> dataRewinder, @NonNull ad adVar, int i2, int i3, th.qw<ResourceType> qwVar) throws GlideException {
        List<Throwable> acquire = this.qw.acquire();
        i.fe(acquire);
        List list = acquire;
        try {
            return ad(dataRewinder, adVar, i2, i3, qwVar, list);
        } finally {
            this.qw.release(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f5822ad.toArray()) + ExtendedMessageFormat.END_FE;
    }
}
