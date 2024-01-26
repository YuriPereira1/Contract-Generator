package org.example;

public interface Validator <S, E> {
    Result<S, E> execute(String input);
}
