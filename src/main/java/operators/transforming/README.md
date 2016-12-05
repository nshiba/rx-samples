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