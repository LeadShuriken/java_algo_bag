package intersection.interfaces;

public interface ObjectArrayIntersection {
    public <T extends Comparable<T>> int countIntersection(T[] a, T[] b);
}
