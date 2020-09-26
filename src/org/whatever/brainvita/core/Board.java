package org.whatever.brainvita.core;

import org.whatever.brainvita.data.Move;

public interface Board extends Validatable<Move>{
    void apply(Move move) throws RuntimeException;
    void undo(Move move) throws RuntimeException;
    boolean isFinished();
}
