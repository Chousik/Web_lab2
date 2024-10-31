package org.chousik.weblab2.common;

public interface ServiceInterface<T> {
    boolean valid(T t);
    void check(T t);
}
