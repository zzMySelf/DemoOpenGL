package io.reactivex;

import th.de.rg;

public interface ObservableTransformer<Upstream, Downstream> {
    ObservableSource<Downstream> qw(rg<Upstream> rgVar);
}
