package com.dxmbumptech.glide.request;

import com.dxmbumptech.glide.request.target.Target;
import java.util.concurrent.Future;

public interface FutureTarget<R> extends Future<R>, Target<R> {
}
