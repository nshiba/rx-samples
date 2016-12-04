package operators.creating;

import io.reactivex.Observable;

public class Defer {
    public static void main(String[] args) {
        Observable observable = Observable.defer(() -> observer -> {
            observer.onNext("test");
            observer.onComplete();
        });

        // この瞬間にdeferの中で新しく Observable を作成することができる
        observable.subscribe(System.out::println);
    }
}
