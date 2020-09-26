package org.whatever.brainvita.core;

import org.whatever.brainvita.data.Move;

public interface Validatable<T> {
    boolean isValid(T t);
}
