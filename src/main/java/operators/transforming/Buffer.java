package operators.transforming;

import io.reactivex.Observable;

public class Buffer {
    public static void main(String[] args) {
        Observable.range(1, 5)
                .buffer(3)
                .subscribe(System.out::println);
    }
}
