package operators.creating;

import io.reactivex.Observable;

public class EmptyNeverThrow {
    public static void main(String[] args) {
        // empty
        Observable.empty();

        // never
        Observable.never();

        // throw
        Observable.error(Throwable::new);
    }
}



