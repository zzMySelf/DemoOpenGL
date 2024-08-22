package com.dxmbumptech.glide.load;

import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.engine.Resource;
import fe.uk.qw.pf.ad;

public interface ResourceEncoder<T> extends Encoder<Resource<T>> {
    @NonNull
    EncodeStrategy ad(@NonNull ad adVar);
}
