package operators.creating;

import io.reactivex.Observable;

public class Start {
    public static void main(String[] args) {
        Observable.fromCallable(() -> {
            String str = "java";
            str += ":" + "RxJava";
            return str;
        }).subscribe(System.out::println);
    }
}
