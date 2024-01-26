package document.core.parse;

import document.core.utils.Result;

public interface Parse<E> {
    Result<String, E> execute(String input);
}
