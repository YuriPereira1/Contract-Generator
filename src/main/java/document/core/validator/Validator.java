package document.core.validator;

import document.core.utils.Result;

public interface Validator <S, E> {
    Result<S, E> execute(String input);
}
