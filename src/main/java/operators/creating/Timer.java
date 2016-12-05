package operators.creating;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Timer {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        Observable.timer(3, TimeUnit.SECONDS)
                .subscribe(aLong -> {
                    System.out.println(System.currentTimeMillis());
                });
    }
}
