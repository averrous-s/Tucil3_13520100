package Commands;
public interface Command<T> {
    public T nextState(T previousState);
    public boolean isAllowed(T previousState);
    public String opposite();
}
