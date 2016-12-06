# Transforming
## Buffer
指定した間隔でストリームを分割してリストを作成するオペレーター。

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
ストリームに流れてきたものを処理してから、新しい `Observable` に合成するオペレーター。
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
ストリームを条件に従ってグループに分けるオペレーター。
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
ストリームに流れてきた値を変化させる事ができるオペレーター。
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

## Scan
リストに順次アクセスしていくOperator。２つずつアクセスしていく。
最初は1つ目と2つ目が引数に渡され、それ以降は前回の処理で戻り値に渡された値が第一引数、次の値が第２引数に渡される。
`subscribe` 時に渡される値は要素の１つ目 + 戻り値に渡された値。

```
Observable.range(1, 5)
        .scan((sum, item) -> sum + item)
        .subscribe(System.out::println);
```

出力

```
1
3
6
10
15
```
