package fr.florent.lwjgl.utils;

import java.util.Objects;


public class Pair<A, B> {

    private final A first;

    private final B second;

    private Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }


    public static <A, B> Pair<A, B> of(A first, B second) {
        return new Pair<>(first, second);
    }

    /**
     * Return true if first value match or instance value is null  and the same for second
     *
     * @param first
     * @param second
     * @return
     */
    public boolean matchWithNull(A first, B second) {
        if (this.first == null && this.second == null) {
            return true;
        } else if (this.first != null && this.second == null && this.first == first) {
            return true;
        } else if (this.first == null && this.second == second) {
            return true;
        } else if (this.first == first && this.second == second) {
            return true;
        } else {
            return false;
        }
    }


    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) &&
                Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
