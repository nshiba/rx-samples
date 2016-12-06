package operators.transforming;

import io.reactivex.Observable;

public class Scan {
    public static void main(String[] args) {
        Observable.range(1, 5)
                .scan((sum, item) -> {
                    System.out.println("sum:item -> " + sum + ":" + item);
                    return sum + item;
                })
                .subscribe(System.out::println);
    }
}
