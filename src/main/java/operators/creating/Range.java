package operators.creating;

import io.reactivex.Observable;

public class Range {
    public static void main(String[] args) {
        Observable.range(0, 10)
                .subscribe(i -> {
                    System.out.println("onNext: " + i);
                }, throwable -> {
                    System.out.println("onError");
                }, () -> {
                    System.out.println("onComplete");
                });
    }
}
