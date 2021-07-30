package accessor;

import java.util.Comparator;
import java.util.function.Function;

public interface Accessor<T, R> extends Comparator<T>, Function<T, R> {
    public abstract T create(R a);
}
