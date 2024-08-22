package com.dxmbumptech.glide.request.transition;

import com.dxmbumptech.glide.load.DataSource;

public interface TransitionFactory<R> {
    Transition<R> qw(DataSource dataSource, boolean z);
}
