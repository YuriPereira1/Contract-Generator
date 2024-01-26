package org.example;

public class Result<S, E> {
    private final S successValue;
    private final E errorValue;

    private Result(S sucess, E error) {
        this.successValue = sucess;
        this.errorValue = error;
    }
    public static <S,E> Result<S, E> success(S value) {
        return new Result<>(value, null);
    }

    public static <S,E> Result<S,E> error(E error) {
        return new Result<>(null, error);
    }

    public boolean isSuccess() {
        return successValue != null;
    }

    public boolean isError() {
        return errorValue != null;
    }

    public S getSuccessValue() {
        return successValue;
    }

    public E getErrorValue() {
        return errorValue;
    }
}

