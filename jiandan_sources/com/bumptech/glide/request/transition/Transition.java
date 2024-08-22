package com.bumptech.glide.request.transition;

public interface Transition<R> {

    public interface ViewAdapter {
    }

    boolean qw(R r, ViewAdapter viewAdapter);
}
