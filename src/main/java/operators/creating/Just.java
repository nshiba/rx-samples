package operators.creating;

import io.reactivex.Observable;

public class Just {
    public static void main(String[] args) {
        Observable.just(3, 1, 5, 4, "test")
                .subscribe(num -> {
                    System.out.println("onNext: " + num);
                }, throwable -> {
                    System.out.println("onError");
                }, () -> {
                    System.out.println("onComplete");
                });
    }
}
