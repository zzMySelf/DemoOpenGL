package fe.uk.qw.pf.fe;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.dxmbumptech.glide.load.ResourceDecoder;
import com.dxmbumptech.glide.load.data.DataRewinder;
import com.dxmbumptech.glide.load.engine.GlideException;
import com.dxmbumptech.glide.load.engine.Resource;
import com.dxmbumptech.glide.load.resource.transcode.ResourceTranscoder;
import fe.uk.qw.pf.ad;
import fe.uk.qw.vvv.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class th<DataType, ResourceType, Transcode> {

    /* renamed from: ad  reason: collision with root package name */
    public final List<? extends ResourceDecoder<DataType, ResourceType>> f5850ad;

    /* renamed from: de  reason: collision with root package name */
    public final ResourceTranscoder<ResourceType, Transcode> f5851de;

    /* renamed from: fe  reason: collision with root package name */
    public final Pools.Pool<List<Throwable>> f5852fe;
    public final Class<DataType> qw;

    /* renamed from: rg  reason: collision with root package name */
    public final String f5853rg;

    public interface qw<ResourceType> {
        @NonNull
        Resource<ResourceType> qw(@NonNull Resource<ResourceType> resource);
    }

    public th(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends ResourceDecoder<DataType, ResourceType>> list, ResourceTranscoder<ResourceType, Transcode> resourceTranscoder, Pools.Pool<List<Throwable>> pool) {
        this.qw = cls;
        this.f5850ad = list;
        this.f5851de = resourceTranscoder;
        this.f5852fe = pool;
        this.f5853rg = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    @NonNull
    public final Resource<ResourceType> ad(DataRewinder<DataType> dataRewinder, int i2, int i3, @NonNull ad adVar) throws GlideException {
        List<Throwable> acquire = this.f5852fe.acquire();
        i.fe(acquire);
        List list = acquire;
        try {
            return de(dataRewinder, i2, i3, adVar, list);
        } finally {
            this.f5852fe.release(list);
        }
    }

    @NonNull
    public final Resource<ResourceType> de(DataRewinder<DataType> dataRewinder, int i2, int i3, @NonNull ad adVar, List<Throwable> list) throws GlideException {
        int size = this.f5850ad.size();
        Resource<ResourceType> resource = null;
        for (int i4 = 0; i4 < size; i4++) {
            ResourceDecoder resourceDecoder = (ResourceDecoder) this.f5850ad.get(i4);
            try {
                if (resourceDecoder.qw(dataRewinder.qw(), adVar)) {
                    resource = resourceDecoder.ad(dataRewinder.qw(), i2, i3, adVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e) {
                if (Log.isLoggable("DecodePath", 2)) {
                    "Failed to decode data for " + resourceDecoder;
                }
                list.add(e);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.f5853rg, (List<Throwable>) new ArrayList(list));
    }

    public Resource<Transcode> qw(DataRewinder<DataType> dataRewinder, int i2, int i3, @NonNull ad adVar, qw<ResourceType> qwVar) throws GlideException {
        return this.f5851de.qw(qwVar.qw(ad(dataRewinder, i2, i3, adVar)), adVar);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.qw + ", decoders=" + this.f5850ad + ", transcoder=" + this.f5851de + ExtendedMessageFormat.END_FE;
    }
}
