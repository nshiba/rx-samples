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
Observable.just(1, 2, 3)
        .flatMap(i -> Observable.range(i, i * 2))
        .subscribe(System.out::print);
```

出力

```
122345345678
```

## GroupBy
ストリームを条件に従ってグループに分けることができます。
同じグループにしたいものに同じ値を返すと同じグループになります。

```
Observable.range(1, 10)
        .groupBy(integer -> integer % 3)
        .subscribe(integerIntegerGroupedObservable -> {
            integerIntegerGroupedObservable.toList().subscribe(System.out::println);
        });
```

出力

```
[3, 6, 9]
[1, 4, 7, 10]
[2, 5, 8]
```

## Map
ストリームに流れてきた値を変化させることができます。
前述の `FlatMap` との違いは、 `FlatMap` は `Observable` を返して、 `Map` は値そのものを返します。

```
Observable.just(1,2,3)
        .map(i -> i * 10)
        .subscribe(System.out::println);
```

出力

```
10
20
30
```
