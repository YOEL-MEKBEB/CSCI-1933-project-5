// Generic linked list node class

public class NGen <T> {
    private T data;
    private NGen<T> next;

    public NGen() {
    }

    public NGen(T item, NGen<T> link) {
        data = item;
        next = link;
    }

    public T getData() {
        return data;
    }

    public void setData(T item) {
        data = item;
    }

    public NGen<T> getNext() {
        return next;
    }

    public void setNext(NGen<T> link) {
        next = link;
    }

}
