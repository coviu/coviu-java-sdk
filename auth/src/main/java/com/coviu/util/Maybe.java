package com.coviu.util;

public class Maybe<I> {
    private I i = null;

    public Boolean isJust() {
        return i != null;
    }

    public Boolean isNothing() {
        return i == null;
    }

    public I get() {
        return i;
    }

    public <J> Maybe<J> map(F1<I, J> f) {
        if (isJust()) {
            J j = f.apply(i);
            return just(j);
        }
        return nothing();
    }

    public <J> Maybe<J> flatMap(F1<I, Maybe<J>> f) {
        return flatten(map(f));
    }

    public I getOrElse(I i) {
        if (isJust()) {
            return this.i;
        }
        return i;
    }

    public I getOrElseLazy(Thunk<I> i) {
        if (isJust()) {
            return this.i;
        }
        return i.get();
    }

    public void forEach(FVoid<I> f) {
        if (isJust()) {
            f.apply(i);
        }
    }

    public Maybe<I> recover(Thunk<I> t) {
        if (isJust()) {
            return this;
        }
        return just(t.get());
    }

    public static <I> Maybe<I> flatten(Maybe<Maybe<I>> mmi) {
        if (mmi.isJust()) {
            return mmi.i;
        }
        return new Maybe<I>();
    }

    public static <I> Maybe<I> just(I i) {
        Maybe<I> mi = new Maybe<I>();
        mi.i = i;
        return mi;
    }

    public static <I> Maybe<I> nothing() {
        return new Maybe<I>();
    }

    public <T2> Maybe<T2> fmap(F1<I, T2> f) {
        return map(f);
    }
}
