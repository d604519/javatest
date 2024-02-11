package com.example.demo69;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

@Component
public class subSectionFieldSelector {
    public static <T,U> String fieldSelector(
            List<T> subSection,
            Function<T,U> func,
            Predicate<T> ...predicates
    ){
        Optional<T> one = subSection.stream().filter(
                Arrays.stream(predicates).reduce((T t) -> true,Predicate::and))
                .findFirst();

        return one.map(func.andThen(Object::toString)).orElse(null);
    }
}
