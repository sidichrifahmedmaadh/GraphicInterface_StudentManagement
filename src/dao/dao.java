package dao;

import java.util.List;

public interface dao<T> {

    T get(long id);
    List<T> getAll();
    void save(T t);
    public void update(T t, String[] params);
    void delete(T t);

}
