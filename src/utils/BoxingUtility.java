package utils;

import model.Unboxable;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yuwei on 15/9/18.
 * Project: CodingProblems
 */
public class BoxingUtility {
    public static <T> List<T> unboxAll(Collection<? extends Unboxable<T>> collection) {
        return collection
                .stream()
                .map(Unboxable::unbox)
                .collect(Collectors.toList());
    }
}
