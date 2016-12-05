package operators.transforming;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class FlatMap {
    public static void main(String[] args) {
        Observable.just("Hello.")
                .flatMap(s -> Observable.just(s + "RxJava."))
                .subscribe(System.out::println);
    }
}
