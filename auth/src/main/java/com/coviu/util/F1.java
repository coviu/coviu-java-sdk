package com.coviu.util;

/**
 * A function from I to J.
 * @param <I> takes an I
 * @param <J> returns a J
 */
public interface F1<I,J> {
    public J apply(I i);
}
