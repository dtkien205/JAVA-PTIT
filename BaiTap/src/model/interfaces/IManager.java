package model.interfaces;

import java.util.List;

/**
 * Interface chung cho các Manager
 */
public interface IManager<T> {
    void add(T item) throws Exception;

    void remove(T item) throws Exception;

    List<T> getAll();

    void saveToFile() throws Exception;

    void loadFromFile() throws Exception;
}
