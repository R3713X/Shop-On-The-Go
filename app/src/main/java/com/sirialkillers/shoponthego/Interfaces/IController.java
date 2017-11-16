package com.sirialkillers.shoponthego.Interfaces;
import java.util.List;

/**
 * @author Ioakeim James Theologou
 * @version 12/11/2017
 *
 */
public interface IController<T, U> {
    List<T>  get();
    T getById(U objectId);
    T create(T objectToBeCreated);
    void update(U u, T object);
    void delete(U objectId);
}
