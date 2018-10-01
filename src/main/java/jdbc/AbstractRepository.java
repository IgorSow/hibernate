package jdbc;

import java.util.List;
import java.util.Map;

public abstract class AbstractRepository<T> {

    public abstract T get(int id);

    public abstract List<T> getAll();

    public abstract boolean delete(int id);

    public abstract boolean insert(Map<String, String> stringStringMap);

    public abstract boolean update(int id, Map<String, String> stringStringMap );

    public abstract boolean addMark(int id, double mark);

}
