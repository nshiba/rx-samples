package operators.transforming;

import io.reactivex.Observable;

public class GroupBy {
    public static void main(String[] args) {
        Observable.range(1, 10)
                .groupBy(integer -> integer % 3)
                .subscribe(integerIntegerGroupedObservable -> {
                    integerIntegerGroupedObservable.toList().subscribe(System.out::println);
                });
    }
}
