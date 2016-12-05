# Creating
## Create
スクラッチで `Observable` を作るオペレーターです。
Androidだと非同期通信なんかでよくみるやつですね。

使い方は以下のような感じです。

```Java
public class Create {
    public static void main(String[] args) {
        Observable.create(e -> {
            Person person = new Person();
            person.age = 100;
            person.name = "nshiba";
            e.onNext(person);
            e.onComplete();
        }).subscribe(System.out::println);
    }

    private static class Person {
        int age;
        String name;

        @Override
        public String toString() {
            return name + ":" + String.valueOf(age);
        }
    }
}
```

出力

```
nshiba:100
```

`onNext` で値を渡してあげて、終了時に `onComplete` を呼ぶ感じです。

また、エラーの場合には `onError` を呼びます。

## Defer
`defer` は実行させる `Observable` を `subscribe` したときに作成するオペレーターです。

通常の `create` はその場で実行する `Observable` を作成しますが、 `defer` は `Observable` の作成自体を遅延させます。

```Java
Observable observable = Observable.defer(() -> observer -> {
    observer.onNext("test");
    observer.onComplete();
});

// この瞬間にdeferの中で新しく Observable を作成することができる
observable.subscribe(System.out::println);
```

## Empty/Never/Throw
これらのOperatorたちは限られた用途で主にテスト用として使われると思います。

### Empty
何も値はないが正常に終了する `Observable` をつくります。
つまり `onComplete` しか呼ばれません。

### Never
何も値がなく、終了もしない `Observable` をつくります。

### Throw
何も値はないが、指定したエラーをはいて終了する `Observable` をつくります。

## From
様々なオブジェクトをObservableに変換します。
おそらくリストを変換することが多いと思うのでサンプルは `fromArray` で作ってみました。

```
int[] nums = new int[] {1, 2, 3, 4, 5};
Observable
        .fromArray(nums)
        .subscribe(ints -> {
            System.out.println("onNext");
            System.out.println(Arrays.toString(ints));
        },
        throwable -> {
            System.out.println("onError");
        },
        () -> {
            System.out.println("onComplete");
        });
```

出力
```
onNext
[1, 2, 3, 4, 5]
onComplete
```

## Interval
指定した一定間隔で整数の値を出力する `Observable` を生成します。
最初にどれくらい遅延させるかの指定も可能です。

```
Observable
        .interval(1, TimeUnit.SECONDS)
        .subscribe(System.out::print);
```

出力

```
01234567789...
```

## Just
直接引数に渡したオブジェクトで `Observable` を生成します。
また、複数渡した場合はその分 `onNext` が呼ばれ、複数渡す場合は型が統一されてなくてもエラーになりません。

```
Observable.just(3, 1, 5, 4, "test")
        .subscribe(num -> {
            System.out.println("onNext: " + num);
        }, throwable -> {
            System.out.println("onError");
        }, () -> {
            System.out.println("onComplete");
        });
```

出力

```
onNext: 3
onNext: 1
onNext: 5
onNext: 4
onNext: test
onComplete
```

## Range
指定した範囲の整数を出力する `Observable` を生成します。

```
Observable.range(0, 10)
        .subscribe(i -> {
            System.out.println("onNext: " + i);
        }, throwable -> {
            System.out.println("onError");
        }, () -> {
            System.out.println("onComplete");
        });
```

出力

```
onNext: 0
onNext: 1
onNext: 2
onNext: 3
onNext: 4
onNext: 5
onNext: 6
onNext: 7
onNext: 8
onNext: 9
onComplete
```

## Repeat
指定回数繰り返す `Observable` を生成します。

```
Observable.just(1, 2, 3, 4, 5)
        .repeat(3)
        .subscribe(i -> {
            System.out.println("onNext: " + i);
        }, throwable -> {
            System.out.println("onError");
        }, () -> {
            System.out.println("onComplete");
        });
```

出力

```
onNext: 1
onNext: 2
onNext: 3
onNext: 1
onNext: 2
onNext: 3
onNext: 1
onNext: 2
onNext: 3
onComplete
```

## Start
なんか計算した値などを返せるメソッドの戻り値を出力する `Observable` を作成します。
`Create` にちょっと似てる部分はありますが、こちらは戻り値が任意の値であって、 `onNext` , `onComplete` は呼ばないものです。

```
Observable.fromCallable(() -> {
    String str = "java";
    str += ":" + "RxJava";
    return str;
}).subscribe(System.out::println);
```

出力

```
java:RxJava
```

## Timer
