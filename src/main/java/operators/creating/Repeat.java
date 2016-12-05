package operators.creating;

import io.reactivex.Observable;

public class Repeat {
    public static void main(String[] args) {
        Observable.just(1, 2, 3)
                .repeat(3)
                .subscribe(i -> {
                    System.out.println("onNext: " + i);
                }, throwable -> {
                    System.out.println("onError");
                }, () -> {
                    System.out.println("onComplete");
                });
    }
}
