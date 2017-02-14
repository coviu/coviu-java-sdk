package com.coviu.util;

public class Thunk<I> {
    private I v = null;

    private F0<I> f;

    public Thunk(F0<I> f) {
        this.f = f;
    }

    public I get() {
        if (v == null) {
            v = f.apply();
        }
        return v;
    }

    public static <I> Thunk<I> thunk(F0<I> f) {
        return new Thunk<I>(f);
    }
}
