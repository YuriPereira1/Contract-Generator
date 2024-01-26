package document.core;

public interface Validator <S, E> {
    Result<S, E> execute(String input);
}
