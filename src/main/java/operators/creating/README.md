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

出力は `nshiba:100` です。

`onNext` で値を渡してあげて、終了時に `onComplete` を呼ぶ感じです。

また、エラーの場合には `onError` を呼びます。

##

