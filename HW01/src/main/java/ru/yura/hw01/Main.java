package ru.yura.hw01;

import com.google.common.base.Strings;
import io.reactivex.Observable;;

public class Main {
    private static final String ABS = "ABC";
    private static final int COUNT = 10;

    public static void main(String... args) {
        Observable.just(ABS)
                .map(s -> Strings.repeat(s, COUNT))
                .subscribe(System.out::println);
    }
}
