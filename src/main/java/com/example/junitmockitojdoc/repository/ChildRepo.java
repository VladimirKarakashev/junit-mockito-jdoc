package com.example.junitmockitojdoc.repository;

import com.example.junitmockitojdoc.model.Child;

import java.util.Collections;
import java.util.List;

/**
 * Repository for {@link Child} class
 */

public class ChildRepo implements IChildRepo {

    /**
     * Return all children from the data base.
     * @return not null {@link List<Child>}
     */
    public List<Child> findAll() {
      return Collections.emptyList();
    }
}
