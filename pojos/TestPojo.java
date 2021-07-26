package pojos;

public class TestPojo {
    private int someNumber;

    public int getSomeNumber() {
        return someNumber;
    }

    public void setSomeNumber(int someNumber) {
        this.someNumber = someNumber;
    }

    @Override
    public String toString() {
        return "TestPojo [the num=" + someNumber + "]";
    }

    public TestPojo(int someNumber) {
        this.someNumber = someNumber;
    }
}
