package operators.creating;

import io.reactivex.Observable;

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
