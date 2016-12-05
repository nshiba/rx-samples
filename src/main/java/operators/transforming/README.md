# Transforming
## Buffer
指定した間隔でストリームを分割してリストを作成する。

```
Observable.range(1, 5)
        .buffer(3)
        .subscribe(System.out::println);
```

出力

```
[1, 2, 3]
[4, 5]
```

## FlatMap
ストリームに流れてきたものを処理してから、新しい `Observable` に合成します。
後述の `Map` との違いは、 `FlatMap` は `Observable` を返して、 `Map` は値そのものを返します。

```
Observable.just("Hello.")
        .flatMap(s -> Observable.just(s + "RxJava."))
        .subscribe(System.out::println);
```

出力

```
Hello.RxJava.
```

## GroupBy

```
```