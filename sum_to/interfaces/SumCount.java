package sum_to.interfaces;

public abstract class SumCount<T, R> {

    protected int a_len;
    protected double aim;
    protected R accessor;

    protected abstract long findCount(T[] a, int b, int pIndex, long count, double combinedValue);
}
