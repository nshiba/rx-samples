package operators.creating;

import io.reactivex.Observable;

import java.util.Arrays;

public class From {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5};
        Observable.fromArray(nums).subscribe(ints -> {
                    System.out.println("onNext");
                    System.out.println(Arrays.toString(ints));
                },
                throwable -> {
                    System.out.println("onError");
                },
                () -> {
                    System.out.println("onComplete");
                });
    }
}
