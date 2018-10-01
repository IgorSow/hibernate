package hibernate;

import java.util.List;


public abstract class AbstractRepositoryHb<T> {
    public abstract T get(int id);

    public abstract List<T> getAll();

    public abstract boolean delete(int id);

    public abstract boolean insert(T insertData);

    public abstract boolean update(T updateData);

}
