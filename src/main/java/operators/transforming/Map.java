package operators.transforming;

import io.reactivex.Observable;

public class Map {
    public static void main(String[] args) {
        Observable.just(1,2,3)
                .map(i -> i * 10)
                .subscribe(System.out::println);
    }
}
