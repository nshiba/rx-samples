package operators.transforming;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class FlatMap {
    public static void main(String[] args) {
        Observable.just(1, 2, 3)
                .flatMap(i -> Observable.range(i, i * 2))
                .subscribe(System.out::print);
    }
}
