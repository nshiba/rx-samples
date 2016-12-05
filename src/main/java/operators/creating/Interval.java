package operators.creating;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Interval {
    public static void main(String[] args) {
        Observable
                .interval(1, TimeUnit.SECONDS)
                .subscribe(System.out::print);
    }
}
