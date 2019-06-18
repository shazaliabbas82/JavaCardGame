/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epita.spfall.daos;

import java.util.List;

/**
 *
 * @author ShzlAbbs
 */
public interface XMLDao<T> {

    T get(String name);

    List<T> getAll();

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);
}
