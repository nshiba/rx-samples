package operators.transforming;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

import java.util.List;

public class Window {
    public static void main(String[] args) {
        Observable.range(1,10)
                .buffer(3)
                .subscribe(new Consumer<List<Integer>>() {
                    @Override
                    public void accept(List<Integer> integers) throws Exception {

                    }
                });

        Observable.range(1,5)
                .window(3)
                .subscribe(integerObservable -> {
                    integerObservable.toList().subscribe(System.out::println);
                });
    }
}
